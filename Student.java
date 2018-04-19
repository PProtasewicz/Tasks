package protasewicz.piotr.klasy;

public class Student {
	private int id;
	private String imie;
	private String nazwisko;
	private int wiek;
	private int rokStudiow;

	public Student(int id, String imie, String nazwisko, int wiek, int rokStudiow)
	{
		this.id = id;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wiek = wiek;
		this.rokStudiow = rokStudiow;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getImie()
	{
		return imie;
	}
	public void setImie(String imie)
	{
		this.imie=imie;
	}
	public String getNazwisko()
	{
		return nazwisko;
	}
	public void setNazwisko(String nazwisko)
	{
		this.nazwisko=nazwisko;
	}
	public int getWiek()
	{
		return wiek;
	}
	public void setWiek(int wiek)
	{
		this.wiek=wiek;
	}
	public int getRokStudiow()
	{
		return rokStudiow;
	}
	public void setRokStudiow(int rokStudiow)
	{
		this.rokStudiow=rokStudiow;
	}
	
	@Override
	public String toString() {
		return id + " " + imie + " " + nazwisko + " " + wiek + " " + rokStudiow;
	}
}
