package com.example.demo.redis;

import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisUtils {
	StringRedisTemplate redisTemplate;

	public void setString(String key, String value, long timeout) {
		if (timeout > 0) {
			redisTemplate.opsForValue().set(key, value, timeout);
		} else {
			redisTemplate.opsForValue().set(key, value);
		}

	}

}
