package com.yjy.maventest.disruptor.testevent;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lmax.disruptor.WorkHandler;
import com.yjy.maven.service.IUserService;

/**
 * 消费者
 * @author YJY
 *
 */
public class TestEventHandler implements WorkHandler<TestEvent> {
	
	public static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
	public static IUserService userService = (IUserService) ac.getBean("userService");
	
	
	@Override
	public void onEvent(TestEvent event) throws Exception {
		/*IUserService userService = null;
		ApplicationContext ac = null;
		ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		userService = (IUserService) ac.getBean("userService");*/
		String a = event.getLine();
		String b = "";
    	String c = "'";
    	if ("0".equals(a)) {
    		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			b = sf.format(new Date());
			System.out.println(b);
			//b = b.substring(11,13) + b.substring(14,16) + b.substring(17,19);
			//System.out.println(b1);
		}
    	
    	
		System.out.println("处理了一行数据：" + a);
		System.out.println("****" + TestEventProducer.a);
		//User user = userService.getUserByUserId(Long.parseLong(a));
		
		if ("9999".equals(a)) {
    		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			c = sf.format(new Date()); 
			System.out.println(c);
			
			//c = c.substring(11,13) + c.substring(14,16) + c.substring(17,19);
			//System.out.println(Integer.valueOf(c) - Integer.valueOf(b));
			
		}
		
		//System.out.println(JSON.toJSONString(user));
	}
}
