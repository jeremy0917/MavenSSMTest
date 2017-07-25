package com.yjy.maventest.disruptor;

public class A extends LongEventHandler{
	
	@Override
	public void onEvent(LongEvent longEvent, long paramLong, boolean paramBoolean) throws Exception {
		
		if (longEvent.getValue() == 1000) {
			throw new Exception("a" + longEvent.getValue());
		}
		System.out.println("a" + longEvent.getValue());
	}
	
}
