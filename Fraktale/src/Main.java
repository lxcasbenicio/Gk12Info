
public class Main {

	public static void main(String args[]) {

		SchildkroetenGrafik schildkroetenGrafik = new SchildkroetenGrafik("Kochkurve", 700, 700);
		Schildkroete schildkroete = schildkroetenGrafik.createSchildkroete();

		schildkroete.drehen(90);
		KurvenZeichner zeichner = new KurvenZeichner(schildkroete);
		zeichner.zackenKoch(1, 150);
		zeichner.quadratKoch(1, 150);
		zeichner.schneeflocke(3, 250);
		schildkroetenGrafik.warten(); // wartet bis das Fenster geschlossen wird

	}

}
