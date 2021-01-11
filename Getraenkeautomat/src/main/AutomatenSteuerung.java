package main;

public class AutomatenSteuerung {

	private JMyAutomat	automat;

	public AutomatenSteuerung(JMyAutomat automat) {
		this.automat = automat;
	}

	public void eingabenVerarbeitung() {
		int zustand = automat.getZustand();
		String eingabe = automat.getEingabe();
		int betrag = automat.getBetrag();

		switch (zustand) {

		// Zustand: Initialisierung, kein Geld eingeworfen, Betrag = 0.00
		case 0:
			switch (eingabe) {

			// 2 EUR-Knopf
			case "2EUR":
				automat.setZustand(4);
				automat.setBetrag(betrag + 20);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("WK", true);
				break;
			// 1 EUR-Knopf
			case "1EUR":
				automat.setZustand(2);
				automat.setBetrag(betrag + 10);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				break;
				
			// 50CT-Knopf
			case "50CT":
				automat.setZustand(1);
				automat.setBetrag(betrag + 5);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				break;

			// Default-Fall für die Eingabe im Zustand 0: Es passiert nichts.
			default:
				break;
			}
			break;
		// Zustand 1: Geld eingeworfen, Betrag = 0.50
		case 1:
			switch (eingabe) {
			case "1":
				automat.getBetrag("1EUR", true);
				automat.getEingabe("RK", true);
				break;

			default:
				break;
			}
			break;
			// Default-Fall für den Zustand: Es passiert nichts.
		default:
			break;
		} // end of switch(zustand)
	}

}
