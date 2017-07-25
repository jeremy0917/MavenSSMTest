package com.yjy.maventest.disruptor.testevent;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

/**
 * 生产者
 * @author YJY
 *
 */
public class TestEventProducer {

	private RingBuffer<TestEvent> ringBuffer;
	
	public static String a = "a";

	public TestEventProducer(RingBuffer<TestEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	/**
	 * 转换器，向队列里放值的时候调用(队列先设置固定长度的对象，然后通过set方法生产值)
	 */
	private static EventTranslatorOneArg<TestEvent, String> eventTranslatorOneArg = new EventTranslatorOneArg<TestEvent, String>() {
		@Override
		public void translateTo(TestEvent event, long sequence, String arg0) {
			event.setLine(arg0);
		}
	};

	/**
	 * 生产者向队列里放入数据
	 * 
	 * @param line
	 */
	public void onData(String line) {
		this.ringBuffer.publishEvent(eventTranslatorOneArg, line);
	}

	/**
	 * 处理数据
	 */
	public void handler() {
		for (int i = 0; i < 100000; i++) {
			this.onData(String.valueOf(i));
		}
		
	}
}