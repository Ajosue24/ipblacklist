package com.meli.management.repository.impl;

import com.meli.management.component.IpManagementComponent;
import com.meli.management.repository.api.RedisCommunicationService;
import com.meli.management.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

@Repository
@EnableScheduling
public class RedisCommunicationServiceImpl implements RedisCommunicationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCommunicationServiceImpl.class);


    private final RedisTemplate redisTemplate;

    public RedisCommunicationServiceImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public void saveInRedisThingsOnlyMono(String keyInRedis, String hashKeyInRedis, Object objectToSave) {
        try {
            redisTemplate.opsForHash().put(keyInRedis, hashKeyInRedis, objectToSave);
            LOGGER.info("Obj saved in redis");
        } catch (RedisConnectionFailureException e) {
            deleteRedisByKeyAndId(keyInRedis, hashKeyInRedis);
            LOGGER.error("Redis off", e);
        } catch (Exception e) {
            deleteRedisByKeyAndId(keyInRedis, hashKeyInRedis);
            LOGGER.error("Can't save obj in redis", e);
        }

    }

    public Object getInRedisOnlyMono(String keyInRedis, String hashKeyInRedis) {
        try {
            return redisTemplate.opsForHash().get(keyInRedis, hashKeyInRedis);
        } catch (RedisConnectionFailureException e) {
            deleteRedisByKeyAndId(keyInRedis, hashKeyInRedis);
            LOGGER.error("getInRedisOnlyMono RedisConnectionFailureException", e);
            return null;
        } catch (Exception e) {
            LOGGER.error("Can't get obj from redis", e);
            deleteRedisByKeyAndId(keyInRedis, hashKeyInRedis);
            return null;
        }
    }


    public void deleteRedisByKeyAndId(String keyInRedis, String hashKeyInRedis) {
        try {

            redisTemplate.opsForHash().delete(keyInRedis, hashKeyInRedis);
            LOGGER.info("deleteRedisByKeyAndId + ".concat(keyInRedis).concat(hashKeyInRedis));
        } catch (RedisConnectionFailureException e) {
            deleteRedisByKeyAndId(keyInRedis, hashKeyInRedis);
            LOGGER.error("deleteRedisByKeyAndId RedisConnectionFailureException", e);
        } catch (Exception e) {
            LOGGER.error("cannot delete ".concat(keyInRedis), e);
        }
    }

    /**
     * Crontab for reset redis var
     */
    @Scheduled(cron = IpManagementComponent.CRON_RESET_REDIS)
    public void deleteAll() {
        try {
            redisTemplate.delete(Constants.COUNTRY_KEY_REDIS);
            redisTemplate.delete(Constants.COUNTRY_KEY_REDIS);
            redisTemplate.delete(Constants.IP_KEY_REDIS);
        } catch (RedisConnectionFailureException e) {
            LOGGER.error("RedisConnectionFailureException", e);
        } catch (Exception e) {
            LOGGER.error("cannot deleteAll ", e);
        }

    }


}
