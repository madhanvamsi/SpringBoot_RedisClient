package org.Tayana.Sprinb_Boot_RedisClient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
@Configuration
public class RedisConfig {
	
	@Bean
	JedisConnectionFactory connectionFactory() //used to connect with Redis cache 
	{
		RedisStandaloneConfiguration rsc=new RedisStandaloneConfiguration();
		rsc.setHostName("localhost");
		rsc.setPort(6379);
		return new JedisConnectionFactory(rsc);
	}
	
	@Bean
	RedisTemplate<String, Object> redisTemplate() //set or fetch the values from redis cache memory
	{
		RedisTemplate<String, Object> template=new RedisTemplate<String, Object>(); //<key,value>
		template.setConnectionFactory(connectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new JdkSerializationRedisSerializer());
		template.setValueSerializer(new JdkSerializationRedisSerializer());
		template.setEnableTransactionSupport(true);
		template.afterPropertiesSet();
		return template;
		
	}

}
