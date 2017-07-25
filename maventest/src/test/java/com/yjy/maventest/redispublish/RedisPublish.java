package com.yjy.maventest.redispublish;

import redis.clients.jedis.Jedis;

public class RedisPublish extends Thread{

	private static Jedis redis = new Jedis("localhost");
	
	/*public RedisPublish(Jedis redis) {
		this.redis = redis;
	}*/
	
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			redis.publish("test111", "this is " + i + " message!");
			redis.publish("test222", "this is " + i + " message!");
		}
	}

}
