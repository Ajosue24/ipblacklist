package com.meli.management.repository.impl;

import com.meli.management.repository.api.RedisCommunicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisCommunicationServiceImpl implements RedisCommunicationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCommunicationServiceImpl.class);


    @Autowired
    private RedisTemplate redisTemplate;


    public void saveInRedisThingsOnlyMono(String keyInRedis, String hashKeyInRedis, Object objectToSave) {
        try {
            redisTemplate.opsForHash().put(keyInRedis, hashKeyInRedis, objectToSave);
            /*reactiveRedisOperations.<String, Object>opsForHash().put(keyInRedis, hashKeyInRedis, objectToSave)
                    .log()
                    .map(p -> objectToSave);*/
            LOGGER.info("Obj saved in redis");
        } catch (Exception e) {
            deleteRedisByKeyAndId(keyInRedis, hashKeyInRedis);
            LOGGER.error("Can't save obj in redis", e);
        }


    }

    public Object getInRedisOnlyMono(String keyInRedis, String hashKeyInRedis) {
        try {
           return redisTemplate.opsForHash().get(keyInRedis,hashKeyInRedis);
            //return reactiveRedisOperations.<String, Object>opsForHash().get(keyInRedis, hashKeyInRedis);
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









}
