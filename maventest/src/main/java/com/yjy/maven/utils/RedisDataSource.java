package com.yjy.maven.utils;
import redis.clients.jedis.ShardedJedis;    
    
/**    
 * @Title: RedisDataSource.java  
 * @copyright   
 * @Package com.cy.redis  
 * @Description: 该接口用于获取redis客户端实例，通过该实例操作redis数据源  
 * @author    
 */    
public interface RedisDataSource {    
        
    public abstract ShardedJedis getRedisClient();    
        
    public void returnResource(ShardedJedis shardedJedis);    
        
        public void returnResource(ShardedJedis shardedJedis,boolean broken);    
    
} 
