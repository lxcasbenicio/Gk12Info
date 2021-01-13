package main;

public class AutomatenSteuerung {

	private JMyAutomat automat;

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
				automat.setButtonEnabled("Aus", true);
				break;

			// 50CT-Knopf
			case "50CT":
				automat.setZustand(1);
				automat.setBetrag(betrag + 5);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// RK-Knopf
			case "RK":
				automat.setZustand(0);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// WF-Knopf
			case "WK":
				automat.setZustand(0);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// Aus-Knopf
			case "Aus":
				System.exit(0);
				break;
			}
			break;

		// Zustand 1: Geld eingeworfen, Betrag = 0.50
		case 1:
			switch (eingabe) {

			// 2 EUR-Knopf
			case "2EUR":
				automat.setZustand(4);
				automat.setBetrag(betrag + 20);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("WK", true);
				automat.setButtonEnabled("Aus", true);
				break;
			// 1 EUR-Knopf
			case "1EUR":
				automat.setZustand(3);
				automat.setBetrag(betrag + 10);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("WK", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// 50CT-Knopf
			case "50CT":
				automat.setZustand(2);
				automat.setBetrag(betrag + 5);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// RK-Knopf
			case "RK":
				automat.setZustand(5);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RF", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// WF-Knopf
			case "WK":
				automat.setZustand(1);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// Aus-Knopf
			case "Aus":
				System.exit(0);
				break;
			}
			break;

		// Zustand 2: Geld eingeworfen, Betrag = 1.00
		case 2:
			switch (eingabe) {

			// 2 EUR-Knopf
			case "2EUR":
				automat.setZustand(4);
				automat.setBetrag(betrag + 20);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("WK", true);
				automat.setButtonEnabled("Aus", true);
				break;
			// 1 EUR-Knopf
			case "1EUR":
				automat.setZustand(4);
				automat.setBetrag(betrag + 10);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("WK", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// 50CT-Knopf
			case "50CT":
				automat.setZustand(3);
				automat.setBetrag(betrag + 5);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("WK", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// RK-Knopf
			case "RK":
				automat.setZustand(5);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RF", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// WF-Knopf
			case "WK":
				automat.setZustand(2);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// Aus-Knopf
			case "Aus":
				System.exit(0);
				break;
			}

			break;

		// Zustand 3: Geld eingeworfen, Betrag = 1.50
		case 3:
			switch (eingabe) {

			// 2 EUR-Knopf
			case "2EUR":
				automat.setZustand(3);
				automat.setBetrag(betrag + 20);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("WK", true);
				automat.setButtonEnabled("Aus", true);
				break;
			// 1 EUR-Knopf
			case "1EUR":
				automat.setZustand(3);
				automat.setBetrag(betrag + 10);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("WK", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// 50CT-Knopf
			case "50CT":
				automat.setZustand(3);
				automat.setBetrag(betrag + 5);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("WK", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// RK-Knopf
			case "RK":
				automat.setZustand(5);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RF", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// WF-Knopf
			case "WK":
				automat.setZustand(6);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("WF", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// Aus-Knopf
			case "Aus":
				System.exit(0);
				break;
			}

			break;

		// Zustand 4: Geld eingeworfen, Betrag = 2.00-2.50
		case 4:
			switch (eingabe) {
			// 2 EUR-Knopf
			case "2EUR":
				automat.setZustand(4);
				automat.setBetrag(betrag + 20);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("WK", true);
				automat.setButtonEnabled("Aus", true);
				break;
			// 1 EUR-Knopf
			case "1EUR":
				automat.setZustand(4);
				automat.setBetrag(betrag + 10);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("WK", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// 50CT-Knopf
			case "50CT":
				automat.setZustand(4);
				automat.setBetrag(betrag + 5);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("WK", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// RK-Knopf
			case "RK":
				automat.setZustand(5);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RF", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// WF-Knopf
			case "WK":
				automat.setZustand(6);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("WF", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// Aus-Knopf
			case "Aus":
				System.exit(0);
				break;
			}
			break;

		// Zustand 5: Geld eingeworfen, Betrag = 0.00
		case 5:
			switch (eingabe) {
			// 2 EUR-Knopf
			case "2EUR":
				automat.setZustand(5);
				automat.setBetrag(betrag + 20);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("WK", true);
				automat.setButtonEnabled("Aus", true);
				break;
			// 1 EUR-Knopf
			case "1EUR":
				automat.setZustand(5);
				automat.setBetrag(betrag + 10);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// 50CT-Knopf
			case "50CT":
				automat.setZustand(5);
				automat.setBetrag(betrag + 5);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// RK-Knopf
			case "RK":
				automat.setZustand(5);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// WF-Knopf
			case "WK":
				automat.setZustand(5);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// Aus-Knopf
			case "Aus":
				System.exit(0);
				break;
			}
			break;

		// Zustand 6: Geld eingeworfen, Betrag = 1.50
		case 6:
			switch (eingabe) {
			// 2 EUR-Knopf
			case "2EUR":
				automat.setZustand(6);
				automat.setBetrag(betrag + 20);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("WK", true);
				automat.setButtonEnabled("Aus", true);
				break;
			// 1 EUR-Knopf
			case "1EUR":
				automat.setZustand(6);
				automat.setBetrag(betrag + 10);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// 50CT-Knopf
			case "50CT":
				automat.setZustand(6);
				automat.setBetrag(betrag + 5);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// RK-Knopf
			case "RK":
				automat.setZustand(6);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// WF-Knopf
			case "WK":
				automat.setZustand(6);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// Aus-Knopf
			case "Aus":
				System.exit(0);
				break;
			}
			break;

		// Zustand 5: Geld eingeworfen, Betrag = 0.00
		case 7:
			switch (eingabe) {
			// 2 EUR-Knopf
			case "2EUR":
				automat.setZustand(7);
				automat.setBetrag(betrag + 20);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("WK", true);
				automat.setButtonEnabled("Aus", true);
				break;
			// 1 EUR-Knopf
			case "1EUR":
				automat.setZustand(7);
				automat.setBetrag(betrag + 10);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// 50CT-Knopf
			case "50CT":
				automat.setZustand(7);
				automat.setBetrag(betrag + 5);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("RK", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// RK-Knopf
			case "RK":
				automat.setZustand(7);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("Aus", true);
				break;

			// WF-Knopf
			case "WK":
				automat.setZustand(7);
				automat.setBetrag(betrag + 0);
				automat.setButtonEnabled("2EUR", true);
				automat.setButtonEnabled("1EUR", true);
				automat.setButtonEnabled("50CT", true);
				automat.setButtonEnabled("Aus", true);
				break;
			// Aus-Knopf
			case "Aus":
				System.exit(0);
				break;
			}

			// Default-Fall für den Zustand: Es passiert nichts.
		default:
			System.exit(0);
			break;
		} // end of switch(zustand)
	}

}
