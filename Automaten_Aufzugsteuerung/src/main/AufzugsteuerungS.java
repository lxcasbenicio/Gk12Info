package main;

public class AufzugsteuerungS extends Aufzugsteuerung {

	private Aufzug	aufzug;

	public AufzugsteuerungS(Aufzug aufzug) {
		this.aufzug = aufzug;
	}

	public void eingabenVerarbeitung() {
		int zustand = aufzug.getZustand();
		String eingabe = aufzug.getEingabe();
		
		switch (zustand) {
		case 0:
			switch (eingabe) {
			case "000":
				aufzug.setZustand(0);
				aufzug.setAnzeige("EG");
				break;
			case "100":
				aufzug.setZustand(0);
				aufzug.setAnzeige("EG");
				break;
			case "010":
				aufzug.setZustand(1);
				aufzug.setAnzeige("01");
				break;
			case "001":
				//Zustand EG; Eingabe 001
				break;
			case "110":
				aufzug.setZustand(1);
				aufzug.setAnzeige("01");
				break;
			case "101":
				//Zustand EG; Eingabe 101
				break;
			case "011":
				aufzug.setZustand(1);
				aufzug.setAnzeige("01");
				break;
			case "111":
				aufzug.setZustand(1);
				aufzug.setAnzeige("01");
				break;
			default:
				break;
			}
			break;
		case 1:
			switch (eingabe) {
			case "000":
				break;
			case "100":
				break;
			case "010":
				break;
			case "001":
				break;
			case "110":
				break;
			case "101":
				break;
			case "011":
				break;
			case "111":
				break;
			default:
				break;
			}
			break;
		case 2:
			switch (eingabe) {
			case "000":
				break;
			case "100":
				break;
			case "010":
				break;
			case "001":
				break;
			case "110":
				break;
			case "101":
				break;
			case "011":
				break;
			case "111":
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
	}
}