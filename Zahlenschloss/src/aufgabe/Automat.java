package aufgabe;
/**
 * Die Automatenklasse enthält die Zustandsüberführungsfunktion.
 * @author schroeder
 *
 */
public class Automat {

	// Der Automat speichert in dieser Instanzvariable den
	// aktuellen Zustand, in dem er sich befindet.
	private int aktuellerZustand;
	
	// Im Konstruktor wird der Zahlenschloss-Automat initialisiert.
	// Der Startzustand ist q_0
	public Automat() {
		aktuellerZustand = 0;
	}

	// In dieser Methode wird die Zustandsüberführungsfunktion
	// programmiert
	public void input(char input) {

	}
	
	// Diese Methode setzt den aktuellen Zustand auf den 
	// übergebenen Wert z.
	private void setZustand(int z) {
		
	}
	
	// Diese Methode fragt den aktuellen Zustand ab und liefert
	// ihn als Zahl zurück.
	private int getZustand() {
		return 0;
	}
	
	// Mit dieser Methode wird gefragt, ob der Automat zum
	// aktuellen Zeitpunkt in einem akzeptierenden oder in einem
	// nicht akzeptierenden Zustand befindet.
	public boolean akzeptiert() {
		return false;
	}

}
