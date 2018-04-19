package protasewicz.piotr.klasy;

public class StudentUczelnia {
	private int id; //id z tabeli Wpis
	//dane ze studenta
	private String imie;
	private String nazwisko;
	private int wiek;
	private int rokStudiow;
	//dane z uczelni
	private String nazwa;
	private String miejscowosc;
	private int rokZalozenia;
	private String adres;
	private String mail;
	private int telefon;
	

	
	public StudentUczelnia(int id, String imie, String nazwisko, int wiek, int rokStudiow, String nazwa,
			String miejscowosc, int rokZalozenia, String adres, String mail, int telefon) {
		super();
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wiek = wiek;
		this.rokStudiow = rokStudiow;
		this.nazwa = nazwa;
		this.miejscowosc = miejscowosc;
		this.rokZalozenia = rokZalozenia;
		this.adres = adres;
		this.mail = mail;
		this.telefon = telefon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public int getWiek() {
		return wiek;
	}
	public void setWiek(int wiek) {
		this.wiek = wiek;
	}
	public int getRokStudiow() {
		return rokStudiow;
	}
	public void setRokStudiow(int rokStudiow) {
		this.rokStudiow = rokStudiow;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getMiejscowosc() {
		return miejscowosc;
	}
	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}
	public int getRokZalozenia() {
		return rokZalozenia;
	}
	public void setRokZalozenia(int rokZalozenia) {
		this.rokZalozenia = rokZalozenia;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getTelefon() {
		return telefon;
	}
	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "StudentUczelnia [id=" + id + ", imie=" + imie + ", nazwisko=" + nazwisko + ", wiek=" + wiek
				+ ", rokStudiow=" + rokStudiow + ", nazwa=" + nazwa + ", miejscowosc=" + miejscowosc + ", rokZalozenia="
				+ rokZalozenia + ", adres=" + adres + ", mail=" + mail + ", telefon=" + telefon + "]";
	}
	
	
}
