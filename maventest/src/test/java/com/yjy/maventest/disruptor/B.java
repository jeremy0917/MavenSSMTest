package com.yjy.maventest.disruptor;

public class B extends LongEventHandler{
	
	@Override
	public void onEvent(LongEvent longEvent, long paramLong, boolean paramBoolean) throws Exception {
		System.out.println("b" + longEvent.getValue());
	}
	
}
