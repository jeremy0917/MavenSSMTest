package com.yjy.maventest.disruptor.testevent;

import com.lmax.disruptor.EventFactory;

public class TestEventFactory implements EventFactory<TestEvent>{

	@Override
	public TestEvent newInstance() {
		return new TestEvent();
	}

}
