package com.bin.liu.springboot.demo.springboot.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @program: springboot-parent
 * @description: redisService
 * @author: bin.liu
 * @create: 2019-03-18 13:44
 **/

@Service("redisService")
public class RedisService {

    @Resource
    private RedisTemplate redisTemplate;

    public void set(String key,Object value,Long expireTime){
        redisTemplate.opsForValue().set(key, value);
        if (expireTime != null){
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        }
    }

    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void delete(String key){
        redisTemplate.delete(key);
    }


    public void setString(String key,Object value,Long expireTime){
       redisTemplate.opsForValue().set(key, value);
       if (expireTime != null){
           redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
       }
    }

    public String getString(String key){
        String value = (String) redisTemplate.opsForValue().get(key);
        return value;
    }

    public void setListCollection(String key, List<Object> list, Long expireTime){
      redisTemplate.opsForList().rightPushAll(key, list);
      if (expireTime != null){
          redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
      }
    }

    public void setlist(String key,Object object){
        redisTemplate.opsForList().leftPush(key, object);
    }

    public void setMap(String key, Map map,Long expireTime){
        redisTemplate.opsForHash().putAll(key, map);
        if (expireTime != null){
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        }
    }

    public Object getMapByKey(String key,String mapKey){
        return redisTemplate.opsForHash().get(key, mapKey);
    }

    public void deletMapByKey(String key,String mapKey){
        redisTemplate.opsForHash().delete(key, mapKey);
    }

    public Set<String> getMapKeys(String key){
        return redisTemplate.opsForHash().keys(key);
    }



}

