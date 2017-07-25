package com.yjy.maventest.disruptor.testevent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.FatalExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class TestEventMain {  
  
    public static void main (String[] args) {  
    	ExecutorService executor = Executors.newFixedThreadPool(8);  
        EventFactory<TestEvent> eventFactory = new TestEventFactory();  
        //创建disruptor，设置单生产者模式  
        Disruptor<TestEvent> disruptor = new Disruptor<TestEvent>(eventFactory, 8, executor, ProducerType.SINGLE,  
                new YieldingWaitStrategy());
        //设置消费者程序
        TestEventHandler[] handler = new TestEventHandler[4];
        for (int i = 0; i < handler.length; i++) {
        	handler[i] = new TestEventHandler();
		}
        //disruptor.handleEventsWithWorkerPool(new TestEventHandler(), new TestEventHandler(),  
         //       new TestEventHandler(), new TestEventHandler());  
        disruptor.handleEventsWithWorkerPool(handler);
        //设置异常处理  
        disruptor.handleExceptionsWith(new FatalExceptionHandler());  
        //启动disruptor并返回RingBuffer  
        RingBuffer<TestEvent> ringBuffer = disruptor.start();  
        //创建生产者线程，并生产  
        TestEventProducer producer = new TestEventProducer(ringBuffer);  
        producer.handler();  
        disruptor.shutdown();  
        executor.shutdown(); 
    }  
}  
