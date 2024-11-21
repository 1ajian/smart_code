package cn.edu.seig.smartcode.common.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * ClassName: RedisConfiguration
 * Package: cn.edu.seig.smartcode.common.redis
 * Description:
 *      重构RedisTemplate类
 * @Author 阿小健
 * @Create 2024/11/16 14:45
 * @Version 1.0
 */
@Configuration
public class RedisConfiguration {
    @Bean
    public RedisTemplate<String, Object> stringObjectRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(RedisSerializer.java());
        return template;
    }
}
