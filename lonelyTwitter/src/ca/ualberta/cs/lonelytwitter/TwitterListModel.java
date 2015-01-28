package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TwitterListModel {

		private ArrayList<LonelyTweetModel> tweets;
		private int count;
		
		public TwitterListModel() {
			count=0;
			tweets = new ArrayList<LonelyTweetModel>();
		}
		
		
		public int getListLength() {
			return count;
		}
		
		// implement
		
		public void addTweet(LonelyTweetModel tweet) {
			for (LonelyTweetModel item: tweets) {
				if(item.equals(tweet)){
					throw new IllegalArgumentException();
				}
			}
			this.tweets.add(tweet);
			count ++;
		}
		
		public LonelyTweetModel[] getTweets() {
			LonelyTweetModel[] returnedTweets;
			returnedTweets = (LonelyTweetModel[])tweets.toArray();
			return returnedTweets;
			
		}
		
		public boolean hasTweet(LonelyTweetModel ltm) {
			return false;
			
		}
		
		public void removeTweet(LonelyTweetModel ltm) {
			
		}
}
