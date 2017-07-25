package com.yjy.maventest.redispublish;

import redis.clients.jedis.Jedis;

public class RedisSubscribe extends Thread{

	private static Jedis redis = new Jedis("localhost");
	
	private static MyListener listener = new MyListener();
	
	/*public RedisSubscribe(Jedis redis, MyListener listener) {
		this.redis = redis;
		this.listener = listener;
	}*/
	
	@Override
	public void run() {
		redis.psubscribe(listener, new String[]{"test*"});
	}
	
}
