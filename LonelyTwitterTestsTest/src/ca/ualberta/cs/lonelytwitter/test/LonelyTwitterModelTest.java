package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import android.test.ActivityInstrumentationTestCase2;

public class LonelyTwitterModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	private int count;
	
	public LonelyTwitterModelTest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
	}
	
	/*
	public void testFail() {
		fail("This is a failing test");
	}
	*/
	
	public void testTrue(){
		assertEquals("They are not equal", 5,5);
	}

}
