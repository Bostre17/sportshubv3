package beans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {
	private String id;
	private Set<User>users=new HashSet<User>();
	private int count;
	
	public Group() {
		super();
		count=0;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}


	@Override
	public String toString() {
		return "Group [id=" + id + ", users=" + users + ", count=" + count + "]";
	}


	public void aggiungiUtente(User user) {
		this.users.add(user);
	}
	
	
	
}
