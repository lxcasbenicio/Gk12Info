package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Getrtränkeautomat<br>
 * Realisierung des Automaten als package. Dadurch wird der Quell-Code soweit
 * als möglich versteckt. Als Progrogrammieraufgabe bleibt die
 * Ereignissteuerung. Es kann mit 2EUR-, 1EUR- und 0.50EUR-Münzen bezahlt werden.
 * <br>
 * Die Beträge werden in Vielfachen von 0.50EUR berechnet.<br>
 * Die Buttons sind wie folgt nummeriert:<br>
 * 0: 2EUR-Münze<br>
 * 1: 1EUR-Münze<br>
 * 2: 0.50EUR-Münze<br>
 * 3: Geldrückgabe-Knopf<br>
 * 4: Warenausgabe-Knopf<br>
 * 5: Warenentnahme-Fach<br>
 * 6: Geldrückgabe-Fach<br>
 * 7: Ende-Knopf<br>
 * 
 */

public class JMyAutomat extends JFrame implements ActionListener {

	/*
	 * Bereitstellen der Konstanten und Objekte. Buttons muessen hier deklariert
	 * werden, damit die Ereignisse ausserhalb des Konstruktors behandelt werden
	 * koennen.
	 */
	private URL					codeBase;

	private final static Color	bgColor				= new Color(153, 0, 0);

	private int					zustand				= 0;
	private String				zustandStr			= new String(" 0 ");
	private final static int	preis				= 15;
	private final String		preisStr			= new String(
			betragToString(preis));
	private int					betrag				= 0;
	private int					anzButtons;
	private int					buttonPressed		= 0;
	private String				anzeige				= new String("0.00 EUR");

	private final static String	iconFName[][]		= {
			// 0 - 2: Die Muenzen
			{ "dm200.gif", "dm200m.gif", "dm200p.gif", "dm200n.gif" },
			{ "dm100.gif", "dm100m.gif", "dm100p.gif", "dm100n.gif" },
			{ "dm050.gif", "dm050m.gif", "dm050p.gif", "dm050n.gif" },
			// 3: Der Geldrueckgabe-Knopf
			{ "rueckgabe_knopf.gif", "rueckgabe_knopfm.gif",
					"rueckgabe_knopfp.gif", "rueckgabe_knopfn.gif" },
			// 4: Der Warenknopf
			{ "waren_knopf.gif", "waren_knopfm.gif", "waren_knopfp.gif",
					"waren_knopfn.gif" },
			// 5: Das Ausgabefach
			{ "ausgabe_fertig.gif", "ausgabe_offen.gif", "ausgabe_flasche.gif",
					"ausgabe_leer.gif" },
			// 6: Das Geldrueckgabe-Fach
			{ "rueckgabe_voll.gif", "rueckgabe_vollm.gif",
					"rueckgabe_vollp.gif", "rueckgabe_leer.gif" },
			// 7: Ende-Knopf
			{ "ende.gif", "endem.gif", "endep.gif", "enden.gif" } };

	// Definieren der Grafik-Objekte
	private ImageIcon			iconSchrift;
	private JLabel				jlblSchrift;
	private JLabel				jlblZustand			= new JLabel(zustandStr);
	private JLabel				jlblPreis			= new JLabel(preisStr);
	private JMyButton[]			button				= new JMyButton[iconFName.length];
	private JTextField			jtfAnzeige			= new JTextField(anzeige,
			anzeige.length() + 1);

	private AutomatenSteuerung	automatenSteuerung	= new AutomatenSteuerung(
			this);

	// Hier werden die Elemente initialisiert
	public void init() {

		iconSchrift = new ImageIcon(
				main.JMyAutomat.class.getResource("/images/schrift.gif"));
		jlblSchrift = new JLabel(iconSchrift);
		Font fontAnzeige = new Font("SansSerif", Font.BOLD, 24);
		FontMetrics fmAnzeige = getFontMetrics(fontAnzeige);
		Font fontInfo = new Font("SansSerif", Font.BOLD, 12);

		// Alle Buttons mit Aktionen erzeugen
		anzButtons = iconFName.length;
		for (int i = 0; i < anzButtons; i++) {
			button[i] = new JMyButton(
					main.JMyAutomat.class
							.getResource("/images/" + iconFName[i][0]),
					main.JMyAutomat.class
							.getResource("/images/" + iconFName[i][1]),
					main.JMyAutomat.class
							.getResource("/images/" + iconFName[i][2]),
					main.JMyAutomat.class
							.getResource("/images/" + iconFName[i][3]));
			button[i].addActionListener(this);
		}

		// GridbagLayout fuer den Container
		GridBagLayout gbLayout = new GridBagLayout();
		GridBagConstraints gbConstraints;

		// Panel zum Aufnehmen der einzelnen Elemente
		JPanel jpAutomat = new JPanel();
		jpAutomat.setOpaque(false);
		jpAutomat.setLayout(gbLayout);

		// Schrift
		gbConstraints = new GridBagConstraints();
		gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
		gbConstraints.insets = new Insets(0, 10, 25, 10);
		jpAutomat.add(jlblSchrift, gbConstraints);

		// Muenzen und Geldrueckgabe
		gbConstraints = new GridBagConstraints();
		gbConstraints.weightx = 1.0;
		for (int i = 0; i <= 3; i++) {
			if (i == 3)
				gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
			gbLayout.setConstraints(button[i], gbConstraints);
			jpAutomat.add(button[i]);
		}

		// Anzeige
		jtfAnzeige.setHorizontalAlignment(JLabel.RIGHT);
		jtfAnzeige.setOpaque(true);
		jtfAnzeige.setBackground(Color.white);
		jtfAnzeige.setForeground(Color.black);
		jtfAnzeige.setFont(fontAnzeige);

		gbConstraints = new GridBagConstraints();
		gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
		gbConstraints.insets = new Insets(25, 10, 25, 10);
		gbConstraints.ipadx = getTextWidth("0" + anzeige, fmAnzeige);
		gbLayout.setConstraints(jtfAnzeige, gbConstraints);
		jpAutomat.add(jtfAnzeige);

		// Warenknopf, Warenausgabe, Geldrueckgabe
		gbConstraints = new GridBagConstraints();
		gbConstraints.gridx = 0;
		gbConstraints.gridy = 3;
		gbLayout.setConstraints(button[4], gbConstraints);
		jpAutomat.add(button[4]);

		gbConstraints = new GridBagConstraints();
		gbConstraints.gridx = 0;
		gbConstraints.gridy = 4;
		jlblPreis.setForeground(Color.white);
		jlblPreis.setFont(fontInfo);
		jlblPreis.setHorizontalAlignment(JLabel.CENTER);
		gbLayout.setConstraints(jlblPreis, gbConstraints);
		jpAutomat.add(jlblPreis);

		gbConstraints = new GridBagConstraints();
		gbConstraints.gridwidth = 2;
		gbConstraints.gridheight = 2;
		gbLayout.setConstraints(button[5], gbConstraints);
		jpAutomat.add(button[5]);

		gbConstraints = new GridBagConstraints();
		gbConstraints.gridx = 3;
		gbConstraints.gridy = 3;
		gbConstraints.gridheight = 2;
		gbLayout.setConstraints(button[6], gbConstraints);
		jpAutomat.add(button[6]);

		// Ende-Button und Zustandsnummer
		gbConstraints = new GridBagConstraints();
		gbConstraints.gridwidth = 2;
		gbConstraints.gridx = 1;
		gbConstraints.gridy = 5;
		gbLayout.setConstraints(button[7], gbConstraints);
		jpAutomat.add(button[7]);

		gbConstraints = new GridBagConstraints();
		gbConstraints.gridx = 3;
		gbConstraints.gridy = 5;
		jlblZustand.setForeground(Color.white);
		jlblZustand.setFont(fontInfo);
		gbLayout.setConstraints(jlblZustand, gbConstraints);
		jpAutomat.add(jlblZustand);

		Container contentPane = getContentPane();
		contentPane.setBackground(bgColor);
		contentPane.add(jpAutomat);

		// Fenstergroesse einstellen und Fenster anzeigen
		setVisible(true);

		// Zum Anfang Muenzen und Endeknopf aktivieren
		for (int i = 0; i < getMaxButtons(); i++)
			if (3 <= i && i <= 6)
				setButtonEnabled(i, false);
			else
				setButtonEnabled(i, true);
	}

	// ######################################################################

	/**
	 * Hier wird geprüft ob ein Button gedrückt wurde und seine Nummer
	 * gemerkt
	 */
	public void actionPerformed(ActionEvent e) {
		// Automat-Operationen
		Object obj = e.getSource();
		for (int i = 0; i < anzButtons; i++)
			if (button[i] == obj)
				buttonPressed = i;

		// Zunaechst alle Knoepfe abschalten
		for (int i = 0; i < anzButtons; i++)
			setButtonEnabled(i, false);

		automatenSteuerung.eingabenVerarbeitung();
	}

	private String betragToString(int i) {
		String str;
		try {
			str = String.valueOf((double) i / 10) + "0 EUR";
		}
		catch (Exception e) {
			str = "0.00 EUR";
		}
		return str;
	}

	private String intToString(int i) {
		String str;
		try {
			str = String.valueOf(i);
		}
		catch (Exception e) {
			str = "0";
		}
		return str;
	}

	private int getTextWidth(String text, FontMetrics fm) {
		int textlen = 0;
		for (int i = 0; i < text.length(); i++)
			textlen = textlen + fm.charWidth(text.charAt(i));
		return textlen;
	}

	/**
	 * Setzt den Zustand und aktualisiert die Zustandsanzeige
	 * 
	 * @param zustand
	 *            Zustandsnummer
	 */
	public void setZustand(int zustand) {
		this.zustand = zustand;
		zustandStr = " " + intToString(zustand) + " ";
		jlblZustand.setText(zustandStr);
	}

	/**
	 * Gibt den aktuellen Zustand zurück
	 * 
	 * @return Zustandsnummer
	 */
	public int getZustand() {
		return zustand;
	}

	/**
	 * Setzt den Betrag und aktualisiert die Ausgabe im Textfeld
	 * 
	 * @param betrag
	 *            Betrag in Vielfachen von 0.10EUR
	 */
	public void setBetrag(int betrag) {
		this.betrag = betrag;
		anzeige = betragToString(betrag);
		jtfAnzeige.setText(anzeige);
	}

	/**
	 * Gibt den aktuellen Betrag zurück
	 * 
	 * @return Betrag in Vielfachen von 0.10EUR
	 */
	public int getBetrag() {
		return betrag;
	}

	/**
	 * Gibt die maximale Anzahl der verfügbaren Buttons zurück
	 * 
	 * @return Anzahl der verfügbaren Buttons
	 */
	public int getMaxButtons() {
		return anzButtons;
	}

	/**
	 * Gibt die Nummer des gedrückten Buttons zurück
	 * 
	 * @return Button-Nummer des gedrückten Buttons
	 */
	public int getButtonPressed() {
		return buttonPressed;
	}

	/**
	 * Aktiviert oder deaktiviert einen Button
	 * 
	 * @param buttNr
	 *            Nummer des Buttons
	 * @param enable
	 *            true: aktiviert den Button, false: deaktivert ihn
	 */
	public void setButtonEnabled(int buttonNr, boolean enable) {
		if ((0 <= buttonNr) && (buttonNr <= anzButtons))
			button[buttonNr].setEnabled(enable);
	}
	
	/**
	 * Aktiviert oder deaktiviert einen Button 
	 * 
	 * @param buttonBez
	 *            Bezeichnung des Buttons
	 * @param enable
	 *            true: aktiviert den Button, false: deaktivert ihn
	 */
	public void setButtonEnabled(String buttonBez, boolean enable) {
		
		int buttonNr = 0;
		
		switch (buttonBez) {
		case "2EUR":
			buttonNr=0;
			break;
		case "1EUR":
			buttonNr=1;
			break;
		case "50CT":
			buttonNr=2;
			break;
		case "RK":
			buttonNr=3;
			break;
		case "WK":
			buttonNr=4;
			break;
		case "WF":
			buttonNr=5;
			break;
		case "RF":
			buttonNr=6;
			break;
		case "Aus":
			buttonNr=7;
			break;
		default:
			break;
		}		
		
		if ((0 <= buttonNr) && (buttonNr <= anzButtons))
			button[buttonNr].setEnabled(enable);
	}
	
	/**
	 * Gibt in Abhängigkeit der Nummer des gedrückten Buttons zurück
	 * die Eingabe zurück
	 * 
	 * @return Eingabe, die durch den gedrückten Button ausgelöst wird
	 */
	public String getEingabe(){
		
		String input = "";
		switch (buttonPressed) {
		case 0:
			input="2EUR";
			break;
		case 1:
			input="1EUR";
			break;
		case 2:
			input="50CT";
			break;
		case 3:
			input="RK";
			break;
		case 4:
			input="WK";
			break;
		case 5:
			input="WF";
			break;
		case 6:
			input="RF";
			break;
		case 7:
			input="Aus";
			break;
		default:
			break;
		}		
		return input;
	}
	
	public static void main(String args[]) {
		
		JMyAutomat getraenkeAutomat = new JMyAutomat();
		getraenkeAutomat.init();
		getraenkeAutomat.setSize(300, 500);
		getraenkeAutomat.setVisible(true);
	}

}
