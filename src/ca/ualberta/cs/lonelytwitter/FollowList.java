package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class FollowList extends Viewer {
	
	private ArrayList<User> following;
	
	public  FollowList(String name) {
		super(name);
		following = new ArrayList<User>();
	}
	
	public void addFollowing(User user) {
		following.add(user);
	}
	
	public void removeFollowing(User user) {
		following.remove(user);
	}
}
