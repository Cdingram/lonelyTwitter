package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

public abstract class User {

	protected String name;

	public String getName() {
		return name;
	}

	public abstract void setName(String name) throws IOException;
	
	public User(String name) {
		super();
		this.name = name;
	}
	
	public User() {
		super();
		name = "anonymous";
	}
	
}
