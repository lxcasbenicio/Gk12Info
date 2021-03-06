
public class KurvenZeichner {

	private Schildkroete schildkroete;

	public KurvenZeichner(Schildkroete schildkroete) {
		this.schildkroete = schildkroete;
		schildkroete.positionieren(200, 400);
	}

	public void zackenKoch(int n, double s) {
		zackenKochInitiator(n, s);
	}

	/**
	 * Zeichnet die Startfigur mit einem Aufruf des Generators fuer jede Kante.
	 */
	private void zackenKochInitiator(int n, double s) {
		zackenKochGenerator(n, s);
	}

	/**
	 * Zeichnet eine Kante der gegebenen Rekursionsebene.
	 * 
	 * @param s aktuelle Kantenlaenge.
	 * @param n aktuelle Rekursionstiefe.
	 */
	private void zackenKochGenerator(int n, double s) {
		if (n == 0) {
			schildkroete.laufen(s);
		} else {
			schildkroete.drehen(-90);
			zackenKochGenerator(n - 1, s / 3);
			schildkroete.drehen(+60);
			zackenKochGenerator(n - 1, s / 3);
			schildkroete.drehen(-120);
			zackenKochGenerator(n - 1, s / 3);
			schildkroete.drehen(+60);
			zackenKochGenerator(n - 1, s / 3);

		}
	}

	public void quadratKoch(int n, double s) {
		quadratKochInitiator(n, s);

		if (n == 0) {
			schildkroete.laufen(s);
		} else {
			schildkroete.drehen(-90);
			zackenKochGenerator(n - 1, s / 3);
			schildkroete.drehen(+90);
			zackenKochGenerator(n - 1, s / 3);
			schildkroete.drehen(-90);
			zackenKochGenerator(n - 1, s / 3);
			schildkroete.drehen(-90);
			zackenKochGenerator(n - 1, s / 3);
			schildkroete.drehen(-90);
			zackenKochGenerator(n - 1, s / 3);
		
			
		}
	}

	/**
	 * Zeichnet die Startfigur mit einem Aufruf des Generators fuer jede Kante.
	 */
	private void quadratKochInitiator(int n, double s) {

	}

	/**
	 * Zeichnet eine Kante der gegebenen Rekursionsebene.
	 * 
	 * @param s aktuelle Kantenlaenge.
	 * @param n aktuelle Rekursionstiefe.
	 */
	private void quadratKochGenerator(int n, double s) {
	}

	public void schneeflocke(int n, double s) {
		 schneeflockeInitiator(n, s);
	}
	/**
	 * Zeichnet die Startfigur mit einem Aufruf des Generators fuer jede Kante.
	 */
	private void schneeflockeInitiator(int n, double s) {
		schneeflockeGenerator(n, s);
		schildkroete.drehen(-120);
		schneeflockeGenerator(n, s);
		schildkroete.drehen(-120);
		schneeflockeGenerator(n, s);
	}

	/**
	 * Zeichnet eine Kante der gegebenen Rekursionsebene.
	 * 
	 * @param s aktuelle Kantenlaenge.
	 * @param n aktuelle Rekursionstiefe.
	 */
	private void schneeflockeGenerator(int n, double s) {
		if (n == 0) {
			schildkroete.laufen(s);
		} else {
			schneeflockeGenerator(n - 1, s / 3);
			schildkroete.drehen(60);
			schneeflockeGenerator(n - 1, s / 3);
			schildkroete.drehen(-120);
			schneeflockeGenerator(n - 1, s / 3);
			schildkroete.drehen(+60);
			schneeflockeGenerator(n - 1, s / 3);
			
		}
	}

}
