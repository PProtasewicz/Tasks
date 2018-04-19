package protasewicz.piotr.klasy;

public class Login {
	
	private int id;
	private String user;
	private String password;
	private String rola;
	
	public Login(int id, String user, String password, String rola) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.rola = rola;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRola() {
		return rola;
	}
	public void setRola(String rola) {
		this.rola = rola;
	}
	
	@Override
	public String toString() {
		return "Login [id=" + id + ", user=" + user + ", password=" + password + ", rola=" + rola + "]";
	}


}
