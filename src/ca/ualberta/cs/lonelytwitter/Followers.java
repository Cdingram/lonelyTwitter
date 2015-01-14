package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class Followers extends Viewer{
	
	private ArrayList<User> followers;
	
	public Followers() {
		super();
		followers = new ArrayList<User>();
	}
	
	public void addFollower(User user) {
		followers.add(user);
	}
	
	public void removeFollower(User user) {
		followers.remove(user);
	}
	
}
