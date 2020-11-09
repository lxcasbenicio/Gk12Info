
public class SummeIterativ {
	
	// Aufgabe 1 iterativ
		public static void main(String[]args) {
			System.out.println("n! = "+SummeIterativ(10));
			
		}
	public static int SummeIterativ(int n) {
		int result = 0;
		while (n>0) {
			result = result+n;
			n=n-1;
		}
		return result;
	}
	}
