package com.github.wz2cool.javaRedisLearning.learning.test;

import com.github.wz2cool.javaRedisLearning.config.PropertyManager;
import redis.clients.jedis.Jedis;

public class Program {
    private static PropertyManager propertyManager = PropertyManager.getInstance();

    public static void main(String[] args) {
        String host = propertyManager.getRedisHost();
        Jedis jedis = new Jedis(host);
        System.out.println("Connect Success");
        //查看服务是否运行
        System.out.println("Service is running: " + jedis.ping());
    }
}
