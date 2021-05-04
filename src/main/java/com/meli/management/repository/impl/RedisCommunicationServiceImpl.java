package com.meli.management.repository.impl;

import com.meli.management.component.IpManagementComponent;
import com.meli.management.repository.api.RedisCommunicationService;
import com.meli.management.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

@Repository
@EnableScheduling
public class RedisCommunicationServiceImpl implements RedisCommunicationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCommunicationServiceImpl.class);


    @Autowired
    private RedisTemplate redisTemplate;


    public void saveInRedisThingsOnlyMono(String keyInRedis, String hashKeyInRedis, Object objectToSave) {
        try {
            redisTemplate.opsForHash().put(keyInRedis, hashKeyInRedis, objectToSave);
            LOGGER.info("Obj saved in redis");
        } catch (Exception e) {
            deleteRedisByKeyAndId(keyInRedis, hashKeyInRedis);
            LOGGER.error("Can't save obj in redis", e);
        }


    }

    public Object getInRedisOnlyMono(String keyInRedis, String hashKeyInRedis) {
        try {
           return redisTemplate.opsForHash().get(keyInRedis,hashKeyInRedis);
        } catch (Exception e) {
            LOGGER.error("Can't get obj from redis", e);
            deleteRedisByKeyAndId(keyInRedis, hashKeyInRedis);
            return null;
        }
    }


    public void deleteRedisByKeyAndId(String keyInRedis, String hashKeyInRedis) {
         redisTemplate.opsForHash().delete(keyInRedis,hashKeyInRedis);
         LOGGER.info("deleteRedisByKeyAndId + ".concat(keyInRedis).concat(hashKeyInRedis));
    }

    /**
     * Crontab for reset redis var
     */
    @Scheduled(cron = IpManagementComponent.CRON_RESET_REDIS)
    public void deleteAll() {
        redisTemplate.delete(Constants.COUNTRY_KEY_REDIS);
        redisTemplate.delete(Constants.COUNTRY_KEY_REDIS);
        redisTemplate.delete(Constants.IP_KEY_REDIS);
    }











}
