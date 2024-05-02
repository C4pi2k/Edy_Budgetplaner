package application;

public enum Category {
	EINNAHMEN_GESAMT_NETTO("Einnahmen gesamt (Netto)"),
	SPARZIEL("Sparziel"),
	WOHNKOSTEN("Wohnkosten"),
	VERSICHERUNG_UND_VORSORGE("Versicherung und Vorsorge"),
	TWINT("Twint"),
	AUTO("Auto"),
	VERSCHIEDENES("Verschiedenes"),
	STEUERN("Steuern"),
	FERIEN("Ferien"),
	AUSGABEN_EC_ODER_KREDITKARTE("Ausgaben EC- oder Kreditkarte");
	
	public final String stringValue;
	
	private Category(String stringValue) {
		this.stringValue = stringValue;
	}
	
}
