package beans;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

public class User {
	private String username;
	private String password;
	private LocalDate dataPassword;
	private int error;
	private boolean validPassword;
	private String groupId;
	private HttpSession session;
	private boolean finalized;
	
	public User() {
		super();
		error=0;
	}

	
	
	public String getGroupId() {
		return groupId;
	}



	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}



	public HttpSession getSession() {
		return session;
	}



	public void setSession(HttpSession session) {
		this.session = session;
	}



	public boolean isFinalized() {
		return finalized;
	}



	public void setFinalized(boolean finalized) {
		this.finalized = finalized;
	}



	public void setError(int error) {
		this.error = error;
	}



	public int getError() {
		return error;
	}


	public void setError() {
		this.error ++;
	}
	
	public void resetError() {
		this.error =0;
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
		this.validPassword = true;
	}
	
	

	public boolean isValidPassword() {
		return validPassword;
	}


	public void setValidPassword(boolean validPassword) {
		this.validPassword = validPassword;
	}


	public LocalDate getDataPassword() {
		return dataPassword;
	}

	public void setDataPassword(LocalDate dataPassword) {
		this.dataPassword = dataPassword;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", dataPassword=" + dataPassword + ", error="
				+ error + ", validPassword=" + validPassword + "]";
	}



	
	
	
}
