package protasewicz.piotr.klasy;

public class Wpis {
	private int id;
	private int idS;
	private int idU;
	
	
	
	public Wpis(int id, int idS, int idU) {
		super();
		this.id = id;
		this.idS = idS;
		this.idU = idU;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdS() {
		return idS;
	}
	public void setIdS(int idS) {
		this.idS = idS;
	}
	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	@Override
	public String toString() {
		return "Wpis [id=" + id + ", idS=" + idS + ", idU=" + idU + "]";
	}
	
	
}
