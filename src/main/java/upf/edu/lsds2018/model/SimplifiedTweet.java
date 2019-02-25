package upf.edu.lsds2018.model;

import java.io.Serializable;
import java.util.Optional;

import com.google.gson.*;

public class SimplifiedTweet implements Serializable {

    private static JsonParser parser = new JsonParser();

    private final long tweetId;		        // the id of the tweet ('id')
    private final String text;  	        // the content of the tweet ('text')
    private final long userId;		        // the user id ('user->id')
    private final String userName;	        // the user name ('user'->'name')
    private final long followersCount;	    // the number of followers ('user'->'followers_count')
    private final boolean isRetweeted;	    // is it a retweet? (the object 'retweeted_status' exists?)
    private final Long retweetedUserId;     // [if retweeted] ('retweeted_status'->'user'->'id')
    private final String retweetedUserName; // [if retweeted] ('retweeted_status'->'user'->'name')
    private final long timestampMs;		    // seconds from epoch ('timestamp_ms')

    public SimplifiedTweet(long tweetId, String text, long userId, String userName,
                           long followersCount, boolean isRetweeted,
                           Long retweetedUserId, String retweetedUserName, long timestampMs) {
    	
    	this.tweetId = tweetId;        
        this.text = text;
        this.userId = userId;
        this.userName = userName;
        this.followersCount = followersCount;
        this.isRetweeted = isRetweeted;
        this.retweetedUserId = retweetedUserId;
        this.retweetedUserName = retweetedUserName;
        this.timestampMs = timestampMs;
    }
    
    /*Getters*/
    public long getTwittID() {
		return tweetId;
	}
    
    public String getText() {
		return text;
	}
    
    public long getUserId() {
		return userId;
	}

	public long getTweetId() {
		return tweetId;
	}

	public String getUserName() {
		return userName;
	}

	public long getFollowersCount() {
		return followersCount;
	}

	public boolean isRetweeted() {
		return isRetweeted;
	}

	public Long getRetweetedUserId() {
		return retweetedUserId;
	}

	public String getRetweetedUserName() {
		return retweetedUserName;
	}

	public long getTimestampMs() {
		return timestampMs;
	}

	
	/**
     * Returns a {@link SimplifiedTweet} from a JSON String.
     * If parsing fails, for any reason, return an {@link Optional#empty()}
     *
     * @param jsonStr
     * @return an {@link Optional} of a {@link SimplifiedTweet}
     */
    public static Optional<SimplifiedTweet> fromJson(String jsonStr) {
    	
    	/*
	    	private final long tweetId;		        // the id of the tweet ('id')
		    private final String text;  	        // the content of the tweet ('text')
		    private final long userId;		        // the user id ('user->id')
		    private final String userName;	        // the user name ('user'->'name')
		    private final long followersCount;	    // the number of followers ('user'->'followers_count')
		    private final boolean isRetweeted;	    // is it a retweet? (the object 'retweeted_status' exists?)
		    private final Long retweetedUserId;     // [if retweeted] ('retweeted_status'->'user'->'id')
		    private final String retweetedUserName; // [if retweeted] ('retweeted_status'->'user'->'name')
		    private final long timestampMs;		    // seconds from epoch ('timestamp_ms')
    	 */
    	
    	JsonParser jp = new JsonParser();
    	JsonElement je = jp.parse(jsonStr);
    	JsonObject jo = je.getAsJsonObject();
    	
    	long tID;
    	
    	if (jo.has("id")) {
	    	 tID = jo.get("id").getAsLong();; // cast method
    	}
    	
    	return null;
    }

    @Override
    public String toString() {
        // IMPLEMENT ME
    	
    	return null;
    }
}

