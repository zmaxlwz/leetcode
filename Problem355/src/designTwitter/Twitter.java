package designTwitter;

import java.util.*;

public class Twitter {
	
	HashMap<Integer, List<Tweet>> tweetMap;
	HashMap<Integer, Set<Integer>> userMap;
	int timestamp;
	
	/** Initialize your data structure here. */
	public Twitter() {
		tweetMap = new HashMap<Integer, List<Tweet>>();
		userMap = new HashMap<Integer, Set<Integer>>();
		timestamp = 0;
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if(!tweetMap.containsKey(userId)){
			List<Tweet> tList = new ArrayList<Tweet>();
			tweetMap.put(userId, tList);
		}	
		if(!userMap.containsKey(userId)){
			Set<Integer> uSet = new HashSet<Integer>();
			uSet.add(userId);
			userMap.put(userId, uSet);
		}
		tweetMap.get(userId).add(0, new Tweet(tweetId, timestamp++));
	}

	/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> result = new ArrayList<Integer>();
		if(!userMap.containsKey(userId)){
			return result;
		}
		PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>();
		Set<Integer> userSet = userMap.get(userId);
		for(Integer user: userSet){
			if(tweetMap.containsKey(user)){
				List<Tweet> tList = tweetMap.get(user);
				int size = Math.min(tList.size(), 10);
				for(int i=0;i<size;i++){
					pq.offer(tList.get(i));
				}
			}
		}
		int length = Math.min(10, pq.size());
		for(int i=0;i<length;i++){
			result.add(pq.poll().tweetId);
		}
		return result;
	}

	/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	public void follow(int followerId, int followeeId) {
		if(!userMap.containsKey(followerId)){
			Set<Integer> uSet = new HashSet<Integer>();
			uSet.add(followerId);
			userMap.put(followerId, uSet);
		}	
		userMap.get(followerId).add(followeeId);
		if(!tweetMap.containsKey(followeeId)){
			List<Tweet> tList = new ArrayList<Tweet>();
			tweetMap.put(followeeId, tList);
		}
	}

	/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	public void unfollow(int followerId, int followeeId) {
		if(!userMap.containsKey(followerId) || followerId == followeeId){
			return;
		}
		userMap.get(followerId).remove(followeeId);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Tweet implements Comparable<Tweet>{
	int tweetId;
	int time;
	Tweet(int id, int t){
		tweetId = id;
		time = t;
	}
	public int compareTo(Tweet that){
		return that.time - this.time;
	}
}
