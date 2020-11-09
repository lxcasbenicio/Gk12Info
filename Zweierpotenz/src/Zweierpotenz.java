
public class Zweierpotenz {

	public int potenzRekursiv(int n) {
		if (n == 0) {
			return 1;
		} else {
			return 2 * 2 ^ potenzRekursiv(n - 1);

		}
	}

	public int potenzIterativ(int n) {
		return 0;
	}

	public static void main(String[] args) {

		Zweierpotenz z = new Zweierpotenz();
		System.out.println(z.potenzRekursiv(7));

	}

}
