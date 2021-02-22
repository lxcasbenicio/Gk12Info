package aufgabe; 
/** 
*	Die Automatenklasse enthÃ¤lt die ZustandsÃ¼berfÃ¼hrungsfunktion. 
*	@author schroeder 
 * 
 */ 
public class Automat { 
 
 	private boolean akzeptiert = false; 
 	// Der Automat speichert in dieser Instanzvariable den  	// aktuellen Zustand, in dem er sich befindet. 
 	private int aktuellerZustand; 
 	 
 	// Im Konstruktor wird der Zahlenschloss-Automat initialisiert. 
 	// Der Startzustand ist q_0  	public Automat() { 
 	 	aktuellerZustand = 0; 
 	} 
 
 	// In dieser Methode wird die ZustandsÃ¼berfÃ¼hrungsfunktion 
 	// programmiert  	public void input(char input) { 
 	 	int z = aktuellerZustand;  	 	switch (z) {  	 	case 0: 
 	 	 	switch (input) {  	 	 	case '1':  	 	 	 	setZustand(1);  	 	 	 	break;  	 	 	case '2':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '3':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '4':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '5': 
 	 	 	 	setZustand(5);  	break; case '6': 
 	setZustand(5);  	break; case '7': 
 	setZustand(5);  	break; case '8':  	setZustand(5);  	break; case '9': 
 	setZustand(5);  	break; case '0': 
 	setZustand(5);  	break;  	 	 	default:  	 	 	 	break; 
 	 	 	} 
 	 	 	break;  	 	case 1: 
 	 	 	switch (input) {  	 	 	case '2':  	 	 	 	setZustand(2);  	 	 	 	break;  	 	 	case '0':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '1':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '3':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '4':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '5':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '6':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '7':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '8': 
 	 	 	 	setZustand(5); 
 	break; case '9': 
 	setZustand(5);  	break; default: 
	 	break; 
} break; case 2:  	switch (input) {  	case '3':  	 	setZustand(3);  	 	break;  	case '0':  	 	setZustand(5);  	 	break; 
 	 	 	case '1':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '2':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '4':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '5':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '6':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '7':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '8':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '9':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	default:  	 	 	 	break; 
 	 	 	} 
 	 	 	break;  	 	case 3: 
 	 	 	switch (input) {  	 	 	case '4': 
 	 	 	 	setZustand(4); 
 	akzeptiert = true;  	break; case '0': 
 	setZustand(5);  	break; case '1': 
 	setZustand(5);  	break; 
case '2': 
 	setZustand(5);  	break; case '3': 
 	setZustand(5);  	break; case '5': 
	 	setZustand(5); 
 	 	 	 	break;  	 	 	case '6':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '7':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '8':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '9':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	default:  	 	 	 	break; 
 	 	 	} 
 	 	 	break;  	 	case 4: 
 	 	 	switch (input) {  	 	 	case '0':  	 	 	 	setZustand(5);  	 	 	 	akzeptiert = false; 
 	 	 	 	break;  	 	 	case '1':  	 	 	 	setZustand(5);  	 	 	 	akzeptiert = false; 
 	 	 	 	break;  	 	 	case '2':  	 	 	 	setZustand(5);  	 	 	 	akzeptiert = false; 
 	 	 	 	break;  	 	 	case '3': 
 	setZustand(5);  	akzeptiert = false;  	break; case '4': 
 	setZustand(5);  	akzeptiert = false;  	break; case '5': 
	 	setZustand(5); 
 	akzeptiert = false;  	break; case '6': 
 	setZustand(5);  	akzeptiert = false;  	break; case '7': 
 	 	 	 	setZustand(5);  	 	 	 	akzeptiert = false; 
 	 	 	 	break;  	 	 	case '8':  	 	 	 	setZustand(5); 
 	 	 	 	akzeptiert = false; 
 	 	 	 	break;  	 	 	case '9':  	 	 	 	setZustand(5);  	 	 	 	akzeptiert = false; 
 	 	 	 	break;  	 	 	default:  	 	 	 	break; 
 	 	 	} 
 	 	 	break;  	 	case 5: 
 	 	 	switch (input) {  	 	 	case '0':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '1':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '2':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '3':  	 	 	 	setZustand(5);  	 	 	 	break;  	 	 	case '4':  	 	 	 	setZustand(5);  	 	 	 	break; 
case '5': 
 	setZustand(5);  	break; case '6': 
 	setZustand(5);  	break; case '7': 
	 	setZustand(5); 
 	break; case '8': 
 	setZustand(5);  	break; case '9': 
 	setZustand(5);  	break; default: 
 	 	 	 	break; 
 	 	 	} 
 	 	 	break;  	 	default: 
 	 	 	break; 
 	 	} 
 	} 
 	 
 	// Diese Methode setzt den aktuellen Zustand auf den   	// Ã¼bergebenen Wert z.  	private void setZustand(int z) { 
 	 	aktuellerZustand =z; 
 	} 
 	 
 	// Diese Methode fragt den aktuellen Zustand ab und liefert  	// ihn als Zahl zurÃ¼ck.  	private int getZustand() { 
 	 	return aktuellerZustand; 
 	} 
 	 
 	// Mit dieser Methode wird gefragt, ob der Automat zum  	// aktuellen Zeitpunkt in einem akzeptierenden oder in einem  	// nicht akzeptierenden Zustand befindet.  	public boolean akzeptiert() { 
 	 	return akzeptiert; 
 	} 
 
} 
 
 
 
 
Hier ist noch die andere Datei!!! 
package aufgabe; 
 
import javax.swing.JOptionPane; 
/** 
*	Dies ist die Klasse, die die main-Methode enthÃ¤lt. 
 *  
*	Der Zahlenschloss-Automat akzeptiert eine 4-stellige 
*	Zahlenkombination und verwirft jede andere. 
 *   
*	@author schroeder 
 * 
 */ 
public class Zahlenschloss { 
  	public static void main(String[] args) {  	 	// ZunÃ¤chst wird der Automat erzeugt 
 	 	Automat a = new Automat(); 
 	 	 
 	 	// Hier wird die Eingabe als String-Objekt erzeugt 
 	 	String in = new String("1234"); 
 	 	 
 	 	// Die Anzahl der Zeichen in der Eingabe wird bestimmt 
 	 	int l = in.length(); 
 	 	 
 	 	// Zeichenweise wird die Eingabe eingelesen... 
 	 	for (int i=0; i < l; i++) { 
 	 	 	//und das aktuelle Zeichen wird an den Automaten 
 	 	 	//Ã¼bergeben 
 	 	 	a.input(in.charAt(i)); 
 	 	} 
 	 	 
 	 	// Wenn der Automat die richtige Zahlenkombination gelesen  	 	// hat, liefert diese Abfrage hier true, sonst false. 
 	 	System.out.println(a.akzeptiert()); 
 	 
 	 	if (a.akzeptiert()) { 
 	 	JOptionPane.showMessageDialog(null, "zugriff erlaubt"); 
 	} 
 	 	else { 
 	 	 	JOptionPane.showMessageDialog(null, "zugriff verwehrt"); 
 	 	 	 
} 
} 
} 
 
