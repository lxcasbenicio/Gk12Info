package aufgabe;

/**
 * Dies ist die Klasse, die die main-Methode enthält.
 * 
 * Der Zahlenschloss-Automat akzeptiert eine 4-stellige
 * Zahlenkombination und verwirft jede andere.
 *  
 * @author schroeder
 *
 */
public class Zahlenschloss {

	public static void main(String[] args) {
		// Zunächst wird der Automat erzeugt
		Automat a = new Automat();
		
		// Hier wird die Eingabe als String-Objekt erzeugt
		String in = new String("4711");
		
		// Die Anzahl der Zeichen in der Eingabe wird bestimmt
		int l = in.length();
		
		// Zeichenweise wird die Eingabe eingelesen...
		for (int i=0; i < l; i++) {
			//und das aktuelle Zeichen wird an den Automaten
			//übergeben
			a.input(in.charAt(i));
		}
		
		// Wenn der Automat die richtige Zahlenkombination gelesen
		// hat, liefert diese Abfrage hier true, sonst false.
		System.out.println(a.akzeptiert());
	}

}
