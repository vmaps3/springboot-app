package com.wangsong.sys.util.shiro;

import java.util.Set;

import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Jedis;

public class RedisManager {

	private int expire = 0;
	private JedisConnectionFactory jedisConnectionFactory;
	/**
	 * get value from redis
	 * @param key
	 * @return
	 */
	public byte[] get(byte[] key){
		byte[] value = null;
		JedisConnection  jedisConnection=jedisConnectionFactory.getConnection();
		try{	
			Jedis jedis=jedisConnection.getNativeConnection(); 
			value = jedis.get(key);
		}finally{
			jedisConnection.close();
		}
		return value;
	}
	
	/**
	 * set 
	 * @param key
	 * @param value
	 * @return
	 */
	public byte[] set(byte[] key,byte[] value){
		JedisConnection  jedisConnection=jedisConnectionFactory.getConnection();
		try{
			Jedis jedis=jedisConnection.getNativeConnection(); 
			jedis.set(key,value);
			if(this.expire != 0){
				jedis.expire(key, this.expire);
		 	}
		}finally{
			jedisConnection.close();
		}
		return value;
	}
	
	/**
	 * set 
	 * @param key
	 * @param value
	 * @param expire
	 * @return
	 */
	public byte[] set(byte[] key,byte[] value,int expire){
		JedisConnection  jedisConnection=jedisConnectionFactory.getConnection();
		try{
			Jedis jedis=jedisConnection.getNativeConnection(); 
			jedis.set(key,value);
			if(expire != 0){
				jedis.expire(key, expire);
		 	}
		}finally{
			jedisConnection.close();
		}
		return value;
	}
	
	/**
	 * del
	 * @param key
	 */
	public void del(byte[] key){
		JedisConnection  jedisConnection=jedisConnectionFactory.getConnection();
		try{
			Jedis jedis=jedisConnection.getNativeConnection(); 
			jedis.del(key);
		}finally{
			jedisConnection.close();
		}
	}
	
	/**
	 * flush
	 */
	public void flushDB(){
		JedisConnection  jedisConnection=jedisConnectionFactory.getConnection();
		try{
			Jedis jedis=jedisConnection.getNativeConnection(); 
			jedis.flushDB();
		}finally{
			jedisConnection.close();
		}
	}
	
	/**
	 * size
	 */
	public Long dbSize(){
		JedisConnection  jedisConnection=jedisConnectionFactory.getConnection();
		Long dbSize = 0L;
		try{
			Jedis jedis=jedisConnection.getNativeConnection(); 
			dbSize = jedis.dbSize();
		}finally{
			jedisConnection.close();
		}
		return dbSize;
	}

	/**
	 * keys
	 * @param regex
	 * @return
	 */
	public Set<byte[]> keys(String pattern){
		JedisConnection  jedisConnection=jedisConnectionFactory.getConnection();
		Set<byte[]> keys = null;
		try{
			Jedis jedis=jedisConnection.getNativeConnection(); 
			keys = jedis.keys(pattern.getBytes());
		}finally{
			jedisConnection.close();
		}
		return keys;
	}
	
	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

	public  JedisConnectionFactory getJedisConnectionFactory() {
		return jedisConnectionFactory;
	}

	public  void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
		this.jedisConnectionFactory = jedisConnectionFactory;
	}

}
