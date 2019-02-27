package upf.edu.lsds2018;

import org.apache.spark.*;
import org.apache.spark.api.java.*;

import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import scala.Tuple2;
import upf.edu.lsds2018.model.SimplifiedTweet;

import java.util.Arrays;

import static java.lang.Integer.max;


public class TwitterGames {

    public static void main(String[] args){

    	String inputDir = args[0];

        //Create a SparkContext to initialize
        SparkConf conf = new SparkConf().setAppName("Twitter Games");
        JavaSparkContext sparkContext = new JavaSparkContext(conf);

        // Load input
		JavaRDD<String> stringRDD = sparkContext.textFile(inputDir);
        JavaRDD<SimplifiedTweet> tweets = stringRDD.map(t -> SimplifiedTweet.fromJson(t).orElse(null)).filter(t -> t != null);
        		

        // 2.1
        long numberOfTweets =  tweets.count(); //do something on tweets
        System.out.println("Total tweets: " + numberOfTweets);

        long numberOfRetweets = tweets.filter(s -> s.isRetweeted()).count();
        // 2.2
        float numberOfOriginalTweets = ((float)numberOfTweets - (float)numberOfRetweets) / (float)numberOfTweets;// do something on tweets
        System.out.println("Original tweets ratio: " + 	numberOfOriginalTweets );

        // 2.3
        JavaPairRDD<String, Integer> userFollowers = tweets.mapToPair(t -> new Tuple2(t.getUserName(), t.getFollowersCount()))
                                                           .reduceByKey((x,y) -> max(Integer.parseInt(x.toString()), Integer.parseInt(y.toString())));
        long uniqueUsers = userFollowers.count();// do something on tweets

        System.out.println("Number of distinct users: " + uniqueUsers);



        // Top 10 users by followers
        JavaRDD<SimplifiedTweet> byFollowers = tweets.mapToPair(t -> new Tuple2<>(t.getUserId(), t)).reduceByKey(new Function2<SimplifiedTweet, SimplifiedTweet, SimplifiedTweet>() {
            @Override
            public SimplifiedTweet call(SimplifiedTweet v1, SimplifiedTweet v2) {
                try
                {
                    if (v1.getFollowersCount() >= v2.getFollowersCount()) return v1;
                    else return v2;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return null;
                }
            }
        }).map(t->t._2);// do something on tweets

        JavaRDD<SimplifiedTweet> top10Followers = sparkContext.parallelize(byFollowers.take(10));// do something on the previous step

        // Store here both outputs (the top10 and the overall list)
        byFollowers.saveAsTextFile("output/byFollowers");
        top10Followers.saveAsTextFile("output/top10Followers");
    }
}

