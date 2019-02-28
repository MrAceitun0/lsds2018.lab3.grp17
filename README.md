lsds2018.lab3.grp17

bucket: https://s3.console.aws.amazon.com/s3/buckets/upf.edu.ldsd2018.lab3.grp17/?region=us-east-1&tab=overview

***SPARK-SUBMIT***

	spark-submit --master local --class upf.edu.lsds2018.TwitterGames .\lsds2018.lab3-1.0-SNAPSHOT.jar path_to_JSON_file.json

***TO SPLIT THE BIG FILES IN LOCAL***

	64 upf.edu.ldsd2018.lab3.grp17 Eurovision3.json Eurovision4.json Eurovision5.json Eurovision6.json Eurovision7.json Eurovision8.json Eurovision9.json Eurovision10.json

***CLUSTER_CONFIG***

	- You can find inside the repository the picture cluster_config.png which shows you how to run our .JAR in the cluster of AWS.

Section 2

	1. How many tweets have been produced during the celebration?		
		
	2. How many unique users have been tweeting during the celebration?

	3. What is the ratio of original (non-retweeted) tweets?