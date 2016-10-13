package com.wangsong.sys.util.mybatis;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version 0.0.1
 * @since 0.0.1
 * @author Shaun Chyxion <br>
 * chyxion@163.com <br>
 * May 12, 2016 9:02:37 PM
 */
public class RedisCacheTransfer 
{
	private static int  expire=100000;
    @Autowired
    public void setRedisTemplate(RedisTemplate<String,Object> redisTemplate) {
        RedisCache.setRedisTemplate(redisTemplate);
    }
	public static int getExpire() {
		return expire;
	}
	public void setExpire(int expire) {
		this.expire = expire;
	}

    
	
	
}
