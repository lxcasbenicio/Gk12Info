package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Aufzug extends JFrame implements ActionListener {
	private volatile int	inZustand	= 0;
	private static int		hoeheAufzug	= 150;
	private static int		posEG		= 2 * hoeheAufzug + 20;
	private volatile int	posAufzug	= posEG;
	private static String	anzeige		= "EG";
	private Panel			panel;
	Label					lblAnzeige;
	JCheckBox				cb02, cb01, cbEG;
	private Button			btnFahre;

	private AufzugsteuerungS	aufzugsteuerung;

	private void knopfLoeschen(int nr) {
		switch (nr) {
		case 0:
			cbEG.setSelected(false);
			break;
		case 1:
			cb01.setSelected(false);
			break;
		case 2:
			cb02.setSelected(false);
			break;
		}
	}
	
	public String getEingabe() {
		return getWahl();
	}

	private String getWahl() {
		char stWahl[] = { '0', '0', '0' };
		if (cbEG.isSelected())
			stWahl[0] = '1';
		if (cb01.isSelected())
			stWahl[1] = '1';
		if (cb02.isSelected())
			stWahl[2] = '1';
		return new String(stWahl);
	}

	private synchronized void setAnzeige(int i) {
		switch (inZustand) {
		case 0:
			anzeige = "EG";
			break;
		case 1:
			anzeige = "01";
			break;
		case 2:
			anzeige = "02";
			break;
		case -1:
			anzeige = "01";
			break;
		}
		lblAnzeige.setText(anzeige);
	}

	private void setAufzug(int oben) {
		panel.setBounds(30, oben, 80, hoeheAufzug);
	}

	private void aufzugFahren(int pos) {
		try {
			boolean auf = (pos < posAufzug);
			if (auf) {
				for (int i = posAufzug; i > pos; i--) {
					Thread.sleep(2);
					setAufzug(i);				
				}
			}
			else {
				for (int i = posAufzug; i < pos; i++) {
					Thread.sleep(2);
					setAufzug(i);
				}
			}
		}
		catch (InterruptedException e) {
		}
	}

	public void init() {
		aufzugsteuerung = new AufzugsteuerungS(this);
		setLayout(null);
		setSize(140, 3 * hoeheAufzug + 40);
		getContentPane().setBackground(Color.yellow);
		panel = new Panel();
		panel.setLayout(null);
		setAufzug(posEG);
		panel.setBackground(Color.lightGray);
		getContentPane().add(panel);
		lblAnzeige = new Label(anzeige, Label.CENTER);
		lblAnzeige.setBackground(Color.black);
		lblAnzeige.setForeground(Color.green);
		lblAnzeige.setBounds(28, 10, 24, 24);
		panel.add(lblAnzeige);
		cb02 = new JCheckBox("2. OG", false);
		cb02.setBounds(10, 40, 60, 15);
		cb01 = new JCheckBox("1. OG", false);
		cb01.setBounds(10, 60, 60, 15);
		cbEG = new JCheckBox("EG", false);
		cbEG.setBounds(10, 80, 60, 15);
		panel.add(cb02);
		panel.add(cb01);
		panel.add(cbEG);
		btnFahre = new Button("Fahre");
		btnFahre.setBounds(10, 120, 60, 24);
		panel.add(btnFahre);
		btnFahre.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnFahre) {
			int inAltZustand = inZustand;
			aufzugsteuerung.eingabenVerarbeitung();
			//animiere(inAltZustand);
			int posNeu = posEG - Math.abs(inZustand) * hoeheAufzug;
			Move move = new Move(inAltZustand,posNeu);
			move.start();
		}
	}

	public boolean wurdeGedrueckt(String auswahl) {
		String stWahl = getWahl();
		return stWahl.equals(auswahl);
	}

	public int getZustand() {
		return inZustand;
	}

	public void setZustand(int zustand) {
		inZustand = zustand;
	}
	
	public void setAnzeige(String anzeige) {
		lblAnzeige.setText(anzeige);
	}
	
	public static void main(String args[]) {
		
		Aufzug aufzug = new Aufzug();
		aufzug.init();
		aufzug.setSize(300, 500);
		aufzug.setVisible(true);
		
	}
	
	class Move extends Thread {
		
		private int pos;
		private int inAltZustand;
		public Move(int altZustand, int target) {
			super();
			pos = target;
			inAltZustand=altZustand;
		}

        @Override
        public void run() {
        	boolean auf = (pos < posAufzug);
			if (auf) {
				for (int i = posAufzug; i > pos; i--) {
					try {
                        Thread.sleep(3);
                    } catch (InterruptedException ex) {
                    }
					panel.setBounds(30, i, 80, hoeheAufzug);				
				}
			}
			else {
				for (int i = posAufzug; i < pos; i++) {
					try {
                        Thread.sleep(3);
                    } catch (InterruptedException ex) {
                    }
					panel.setBounds(30, i, 80, hoeheAufzug);
				}
			}
			//System.out.println("prev: " + inAltZustand + ", next: " + inZustand);
			knopfLoeschen(inAltZustand);
			knopfLoeschen(inZustand);
			setAnzeige(inZustand);
			posAufzug = pos;
        }
    }
}
