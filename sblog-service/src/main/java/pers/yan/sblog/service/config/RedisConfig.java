package pers.yan.sblog.service.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;

/**
 * redis配置
 *
 * @author likaiyan
 * @date 2021/8/4 4:32 下午
 */
@Configuration
@EnableCaching
public class RedisConfig {

    /**
     * 自定义redis缓存过期时间
     *
     * @param redisConnectionFactory 连接工厂
     * @return manager
     */
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        return new RedisCacheManager(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory)
                , RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(2 * 60 * 60)));
    }

}
