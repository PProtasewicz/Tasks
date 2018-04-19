package protasewicz.piotr.klasy;

public class Uczelnia {
	
	private int id;
	private String nazwa;
	private String miejscowosc;
	private int rokZalozenia;
	private String adres;
	private String mail;
	private int telefon;
	
	public Uczelnia(int id , String nazwa , String miejscowosc , int rokZalozenia , String adres , String mail , int telefon)
	{
		this.id = id;
		this.nazwa = nazwa;
		this.miejscowosc = miejscowosc;
		this.rokZalozenia= rokZalozenia;
		this.adres = adres;
		this.mail = mail;
		this.telefon = telefon;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getNazwa()
	{
		return nazwa;
	}
	public void setNazwa(String nazwa)
	{
		this.nazwa = nazwa;
	}
	public String getMiejscowosc()
	{
		return miejscowosc;
	}
	public void setMiejscowosc(String miejscowosc)
	{
		this.miejscowosc = miejscowosc;
	}
	public int getRokZalozenia()
	{
		return rokZalozenia;
	}
	public void setRokZalozenia(int rokZalozenia)
	{
		this.rokZalozenia = rokZalozenia;
    }
	public String getAdres()
	{
		return adres;
	}
	public void setAdres(String adres)
	{
		this.adres=adres;
	}
	public String getMail()
	{
		return mail;
	}
	public void setMail(String mail)
	{
		this.mail=mail;
	}
	public int getTelefon()
	{
		return telefon;
	}
	public void setTelefon(int telefon)
	{
		this.telefon = telefon;
	}
	
	public String toString()
	{
		return id + " " + nazwa + " " + miejscowosc + " " + rokZalozenia + " " + adres + " " + mail + " " + telefon;
	}

}
