package com.lee.leetcode.Q300;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Pwenlee
 * @date 2019/5/9 10:53
 * @description
 */
public class Q355 {
//    355. 设计推特
//    设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
//
//    postTweet(userId, tweetId): 创建一条新的推文
//    getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
//    follow(followerId, followeeId): 关注一个用户
//    unfollow(followerId, followeeId): 取消关注一个用户
//    示例:
//
//    Twitter twitter = new Twitter();
//
//    // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//    twitter.postTweet(1, 5);
//
//    // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//    twitter.getNewsFeed(1);
//
//    // 用户1关注了用户2.
//    twitter.follow(1, 2);
//
//    // 用户2发送了一个新推文 (推文id = 6).
//    twitter.postTweet(2, 6);
//
//    // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//    // 推文id6应当在推文id5之前，因为它是在5之后发送的.
//    twitter.getNewsFeed(1);
//
//    // 用户1取消关注了用户2.
//    twitter.unfollow(1, 2);
//
//    // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//    // 因为用户1已经不再关注用户2.
//    twitter.getNewsFeed(1);

    class Twitter {

        class TwitterHistory{
            private int userId;
            private int tweetId;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getTweetId() {
                return tweetId;
            }

            public void setTweetId(int tweetId) {
                this.tweetId = tweetId;
            }

            public TwitterHistory(int userId, int tweetId) {
                this.userId = userId;
                this.tweetId = tweetId;
            }
        }

        private LinkedList<TwitterHistory> twitterHistoryList;

        private Map<Integer, Set<Integer>> followMap;

        /** Initialize your data structure here. */
        public Twitter() {
            twitterHistoryList = new LinkedList<>();
            followMap = new HashMap<>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            twitterHistoryList.addFirst(new TwitterHistory(userId, tweetId));
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> followSet = followMap.getOrDefault(userId, new HashSet<>());
            followSet.add(userId);
            return twitterHistoryList.stream().filter(ele -> followSet.contains(ele.userId)).limit(10).map(TwitterHistory::getTweetId).collect(Collectors.toList());
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if(followerId != followeeId){
                Set<Integer> followSet = followMap.getOrDefault(followerId, new HashSet<>());
                followSet.add(followeeId);
                followMap.put(followerId, followSet);
            }
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(followerId != followeeId){
                if(followerId != followeeId){
                    Set<Integer> followSet = followMap.getOrDefault(followerId, new HashSet<>());
                    followSet.remove(followeeId);
                    followMap.put(followerId, followSet);
                }
            }
        }
    }


}
