package com.yjy.maventest.redispublish;

import redis.clients.jedis.Jedis;

public class TestRedis {
	public static void main(String[] args) throws InterruptedException {
		//Jedis redis = new Jedis("localhost");

		Thread publish = new RedisPublish();
		Thread subscribe = new RedisSubscribe();
		
		subscribe.start();

		publish.start();
		//subscribe.sleep(2000);

		//PublishExample1(redis, 1);
		// ListExample(redis, 20000);
		// SimpleExample(redis);
	}
	
	

	// 简单添加信息
	public static void SimpleExample(Jedis redis) {
		redis.set("key1", "I am value 1");
		String ss = redis.get("key1");
		System.out.println(ss);
	}

	// 队列添加信息
	public static void ListExample(Jedis redis, int number) {
		String messageStr = "";
		int count = 0;
		Long currentTime = System.currentTimeMillis();
		while (count++ < number) {
			messageStr = "this is " + count + " message!";
			redis.rpush("logstash-test-list", messageStr);
			// System.out.println(messageStr);
		}
		System.out.println(System.currentTimeMillis() - currentTime);// 8414
	}

	// 发布订阅
	public static void PublishExample(Jedis redis, int number) {
		String messageStr = "";
		int count = 0;
		while (count++ < number) {
			messageStr = "this is " + count + " message!";
			redis.publish("logstash-test-list", messageStr);
			System.out.println(messageStr);
		}
	}

	public static void PublishExample1(Jedis redis, int number) {
		String messageStr = "";
		int count = 200000;

		messageStr = "this is " + count + " message!";
		long a = redis.publish("logstash-test-list", messageStr);
		System.out.println(messageStr);
		System.out.println(a);

	}
}