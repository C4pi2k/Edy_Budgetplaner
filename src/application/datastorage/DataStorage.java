package application.datastorage;

public class DataStorage {
	
	private String[] id;
	private int position;
	private EinnahmenGesamtNetto einnahmenGesamtNetto;
	private Sparziel sparziel;
	private Wohnkosten wohnkosten;
	private VersicherungUndVorsorge versicherungUndVorsorge;
	private Twint twint;
	private Auto auto;
	private Verschiedenes verschiedenes;
	private Steuern steuern;
	private Ferien ferien;
	private AusgabenECOderKreditkarte ausgabenECOderKreditkarte;
	
	public DataStorage(String month, String week, String weekday, int position) {
		id = new String[3];
		id[0] = month;
		id[1] = week;
		id[2] = weekday;
		this.position = position;
		this.einnahmenGesamtNetto = new EinnahmenGesamtNetto();
		this.sparziel = new Sparziel();
		this.wohnkosten = new Wohnkosten();
		this.versicherungUndVorsorge = new VersicherungUndVorsorge();
		this.twint = new Twint();
		this.auto = new Auto();
		this.verschiedenes = new Verschiedenes();
		this.steuern = new Steuern();
		this.ferien = new Ferien();
		this.ausgabenECOderKreditkarte = new AusgabenECOderKreditkarte();
	}
	
	public String[] getId() {
		return id;
	}
	
	public int getPosition() {
		return position;
	}

	public EinnahmenGesamtNetto getEinnahmenGesamtNetto() {
		return einnahmenGesamtNetto;
	}


	public void setEinnahmenGesamtNetto(EinnahmenGesamtNetto einnahmenGesamtNetto) {
		this.einnahmenGesamtNetto = einnahmenGesamtNetto;
	}


	public Sparziel getSparziel() {
		return sparziel;
	}


	public void setSparziel(Sparziel sparziel) {
		this.sparziel = sparziel;
	}


	public Wohnkosten getWohnkosten() {
		return wohnkosten;
	}


	public void setWohnkosten(Wohnkosten wohnkosten) {
		this.wohnkosten = wohnkosten;
	}


	public VersicherungUndVorsorge getVersicherungUndVorsorge() {
		return versicherungUndVorsorge;
	}


	public void setVersicherungUndVorsorge(VersicherungUndVorsorge versicherungUndVorsorge) {
		this.versicherungUndVorsorge = versicherungUndVorsorge;
	}


	public Twint getTwint() {
		return twint;
	}


	public void setTwint(Twint twint) {
		this.twint = twint;
	}


	public Auto getAuto() {
		return auto;
	}


	public void setAuto(Auto auto) {
		this.auto = auto;
	}


	public Verschiedenes getVerschiedenes() {
		return verschiedenes;
	}


	public void setVerschiedenes(Verschiedenes verschiedenes) {
		this.verschiedenes = verschiedenes;
	}


	public Steuern getSteuern() {
		return steuern;
	}


	public void setSteuern(Steuern steuern) {
		this.steuern = steuern;
	}


	public Ferien getFerien() {
		return ferien;
	}


	public void setFerien(Ferien ferien) {
		this.ferien = ferien;
	}


	public AusgabenECOderKreditkarte getAusgabenECOderKreditkarte() {
		return ausgabenECOderKreditkarte;
	}


	public void setAusgabenECOderKreditkarte(AusgabenECOderKreditkarte ausgabenECOderKreditkarte) {
		this.ausgabenECOderKreditkarte = ausgabenECOderKreditkarte;
	}
	
}
