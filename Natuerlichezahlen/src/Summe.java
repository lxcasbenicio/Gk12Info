
public class Summe {

	// Aufgabe 1 rekursiv
	public int fakultaet (int n) {
	if (n == 0) {
		return n= 1 ;}
		else  {
			return n* fakultaet (n-1);}	
		}
	public static void main (String[] args) {
		Summe n = new Summe();
		
		System.out.println("n! = " + n.fakultaet(10));
	}
}
	
