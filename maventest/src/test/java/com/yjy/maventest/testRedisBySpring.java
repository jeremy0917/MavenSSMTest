package com.yjy.maventest;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.yjy.maven.bean.UserBill;
import com.yjy.maven.datasource.DatabaseContextHolder;
import com.yjy.maven.service.IUserService;
import com.yjy.maven.utils.RedisClientTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class testRedisBySpring {
	private static Logger logger = Logger.getLogger(TestMybatisBySpring.class);
	@Resource
	private IUserService userService = null;
	@Resource
	private RedisClientTemplate redisClientTemplate;

	/*@Before
	public void before(){
		List<JedisShardInfo> list = new ArrayList<JedisShardInfo>();
		JedisShardInfo info = new JedisShardInfo("127.0.0.1", 6379, 1000);
		list.add(info);
		
		ShardedJedisPool s = new ShardedJedisPool(getJedisPoolConfig(), list);
		
		RedisDataSourceImpl r = new RedisDataSourceImpl();
		r.setShardedJedisPool(s);
		redisClientTemplate.setRedisDataSource(r);
		
	}*/
	
	/*public JedisPoolConfig getJedisPoolConfig(){
		JedisPoolConfig j = new JedisPoolConfig();
		j.setMaxTotal(2048);
		j.setMaxIdle(200);
		j.setNumTestsPerEvictionRun(1024);
		j.setTimeBetweenEvictionRunsMillis(30000);
		j.setMinEvictableIdleTimeMillis(-1);
		j.setSoftMinEvictableIdleTimeMillis(10000);
		j.setMaxWaitMillis(1500);
		j.setTestOnBorrow(true);
		j.setTestWhileIdle(true);
		j.setTestOnReturn(false);
		j.setJmxEnabled(true);
		j.setBlockWhenExhausted(false);
		return j;
	}*/
	
	@Test
	public void test1() {		
		String userId = "2910063021038582";
		String key = "USER_ID" + userId;
		try {
			boolean flag = redisClientTemplate.exists(key);
			if (flag) {
				String userBillString = redisClientTemplate.get(key);
				logger.info("_____________________________________");
				logger.info(" userBillString : " + JSON.toJSONString(userBillString));
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabaseContextHolder.setCustomerType(DatabaseContextHolder.DATA_SOURCE_ACTPAR1);
		UserBill userBill = userService.getUserBillByUserId(Long.parseLong(userId));
		
		try {    
            redisClientTemplate.setex(key, 60, userBill.toString());
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
		logger.info("*************************");
		logger.info(Long.parseLong(userId));
		logger.info("sql, userBillString : " + JSON.toJSONString(userBill));
		
	}
}
