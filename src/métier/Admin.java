package métier;

public class Admin {
	
	private int id;
	private String login;
	private String password;

	public Admin() {
		
	}
	public Admin(String login, String password) {
		super();
		
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
