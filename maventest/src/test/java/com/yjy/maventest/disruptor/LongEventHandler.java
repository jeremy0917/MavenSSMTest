package com.yjy.maventest.disruptor;

import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent> {

	@Override
	public void onEvent(LongEvent longEvent, long paramLong, boolean paramBoolean) throws Exception {
		System.out.println("**************");
		System.out.println(longEvent.getValue());
	}

}
