package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import android.test.ActivityInstrumentationTestCase2;

public class LonelyTweetModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public LonelyTweetModelTest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	/*
	public void sampleTest() {
		assertFalse("My first number is greater", greaterThan(5,6));
	}
	*/
	
	public void testEqual(){
		Date date = new Date(123113);
		NormalTweetModel normal = new NormalTweetModel("test tweet", date);
		NormalTweetModel secondTweet = new NormalTweetModel("test tweet", date);
		assertFalse("Different tweets are not equal", normal.equals(secondTweet));
	}
	//assert__(message, observed, actual)
	
	public boolean greaterThan(int i, int j) {
		if(i>j){
			return true;
		} else {
			return false;
		}
	
	}

}
