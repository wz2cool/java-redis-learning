package com.github.wz2cool.javaRedisLearning.learning.hash;

import com.github.wz2cool.javaRedisLearning.config.PropertyManager;
import redis.clients.jedis.Jedis;

public class Program {
    private static PropertyManager propertyManager = PropertyManager.getInstance();

    public static void main(String[] args) {

        String host = propertyManager.getRedisHost();
        Jedis jedis = new Jedis(host);



    }
}
