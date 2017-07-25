package com.yjy.maventest.redispublish;

import redis.clients.jedis.JedisPubSub;

public class MyListener extends JedisPubSub {

	@Override
	public void onMessage(String channel, String message) {
		 System.out.println(channel + "=" + message); 
	}

	@Override
	public void onPMessage(String pattern, String channel, String message) {
		System.out.println(pattern + "=" + channel + "=" + message + Thread.currentThread().getName());
	}

	@Override
	public void onSubscribe(String paramString, int paramInt) {
		
	}

	@Override
	public void onUnsubscribe(String paramString, int paramInt) {

	}

	@Override
	public void onPUnsubscribe(String paramString, int paramInt) {
		
	}

	@Override
	public void onPSubscribe(String paramString, int paramInt) {
		
	}
	
}
