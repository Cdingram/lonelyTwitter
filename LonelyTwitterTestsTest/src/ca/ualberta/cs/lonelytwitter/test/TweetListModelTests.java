package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TwitterListModel;
import android.test.ActivityInstrumentationTestCase2;

public class TweetListModelTests extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	private TwitterListModel tweets;
	
	public TweetListModelTests() {
		super(LonelyTwitterActivity.class);
		// TODO Auto-generated constructor stub
	}

	protected void setUp() throws Exception {
		super.setUp();
		tweets = new TwitterListModel();
	}
	
	public void test1() {
		Date date1 = new Date(12312);
		
		ImportantTweetModel tweet1 = new ImportantTweetModel("hi", date1);
		NormalTweetModel tweet2 = new NormalTweetModel("hi", date1);
		
		//
		assertFalse("They are different", tweet1.equals(tweet2));
	}
	
	public void test2(){
		Date date1 = new Date(12312);
		
		NormalTweetModel tweet1 = new NormalTweetModel("hi", date1);
		NormalTweetModel tweet2 = new NormalTweetModel("hi", date1);
		
		tweets.addTweet(tweet1);
		tweets.addTweet(tweet2);
		
	}
	
	public void test3(){
		
		NormalTweetModel tweet1 = new NormalTweetModel("hi");
		NormalTweetModel tweet2 = new NormalTweetModel("hi2");
		NormalTweetModel tweet3 = new NormalTweetModel("hi3");
		
		tweets.addTweet(tweet1);
		tweets.addTweet(tweet2);
		tweets.addTweet(tweet3);
		
		LonelyTweetModel[] tweets1 = tweets.getTweets();
		
		assertEquals("sadfsda", tweets1[0].getText().toString(), "hi");
	}
}
