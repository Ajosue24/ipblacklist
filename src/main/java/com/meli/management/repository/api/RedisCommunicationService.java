package com.meli.management.repository.api;

import reactor.core.publisher.Mono;

public interface RedisCommunicationService {

     void saveInRedisThingsOnlyMono(String keyInRedis,String hashKeyInRedis,Object objectToSave);

    Object getInRedisOnlyMono(String keyInRedis,String hashKeyInRedis);

    void deleteRedisByKeyAndId(String keyInRedis,String hashKeyInRedis);

}
