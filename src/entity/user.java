package entity;

public class user {
	int id;
	String username ;
	String password ;
	String email ;
	boolean admin;
	
	public user() {
		// TODO Auto-generated constructor stub
	}

	public user(int id, String username, String password, String email, boolean admin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
