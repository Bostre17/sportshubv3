package beans;

import javax.servlet.http.HttpSession;

public abstract class Utente {
	public Utente(String username, String id) {
		super();
		this.username = username;
		this.id = id;
	}
	String username;
	String id;
	private HttpSession session;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Utente [username=" + username + ", id=" + id + "]";
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	
}
