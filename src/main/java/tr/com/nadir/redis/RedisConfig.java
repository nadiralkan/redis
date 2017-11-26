package tr.com.nadir.redis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
@ComponentScan("tr.com.nadir.redis")
public class RedisConfig {
	@Bean
	JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
		jedisConFactory.setHostName("ec2-34-252-202-201.eu-west-1.compute.amazonaws.com");
		jedisConFactory.setPassword("p670f00109627967a88be4cb3b0cd825003e851c5e77f85d72353743081cc3b5c");
		jedisConFactory.setPort(36159);
		return jedisConFactory;
	}
//
//	@Bean
//	public RedisSerializer<String> redisStringSerializer() {
//		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//		return stringRedisSerializer;
//	}

	/**
	 * public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory
	 * cf,RedisSerializer<String> redisSerializer) { RedisTemplate<String,
	 * String> redisTemplate = new RedisTemplate<String, String>();
	 * redisTemplate.setConnectionFactory(cf);
	 * redisTemplate.setDefaultSerializer(redisSerializer); return
	 * redisTemplate; }
	 **/
	@Bean
	public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory cf) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(cf);
//		redisTemplate.setDefaultSerializer(redisSerializer);
		return redisTemplate;
	}

	@Bean
	public CacheManager cacheManager() {
		return new RedisCacheManager(redisTemplate(redisConnectionFactory()));
	}

}
