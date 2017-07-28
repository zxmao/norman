//package com.junxiong.norman.service.redis;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * @author zhangjunxiong
// * @since 2017/7/28
// */
//@Configuration
//public class RedisConfig {
//
//    @Bean
//    JedisConnectionFactory connectionFactory() {
//        return new JedisConnectionFactory();
//    }
//
//    @Bean
//    ValueOperations<String, String> strOperations(RedisTemplate<String, String> redisTemplate) {
//        return redisTemplate.opsForValue();
//    }
//
//    @Bean
//    RedisTemplate<String, Integer> intRedisTemplate(JedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, Integer> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(connectionFactory);
//        return redisTemplate;
//    }
//
//    @Bean
//    ValueOperations<String, Integer> intOperations(RedisTemplate<String, Integer> redisTemplate) {
//        return redisTemplate.opsForValue();
//    }
//
//    @Bean
//    Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer(ObjectMapper objectMapper) {
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(
//                Object.class);
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//        return jackson2JsonRedisSerializer;
//    }
//
//    @Bean
//    RedisTemplate<String, Object> objRedisTemplate(JedisConnectionFactory connectionFactory,
//                                                   Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(connectionFactory);
//        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashKeySerializer(stringRedisSerializer);
//        return redisTemplate;
//    }
//
//    @Bean
//    ValueOperations<String, Object> objOperations(RedisTemplate<String, Object> redisTemplate) {
//        return redisTemplate.opsForValue();
//    }
//}
