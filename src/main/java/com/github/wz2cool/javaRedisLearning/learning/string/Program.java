package com.github.wz2cool.javaRedisLearning.learning.string;

import com.github.wz2cool.javaRedisLearning.config.PropertyManager;
import redis.clients.jedis.Jedis;

public class Program {

    private static PropertyManager propertyManager = PropertyManager.getInstance();

    public static void main(String[] args) {
        Jedis jedis = new Jedis(propertyManager.getRedisHost());
        System.out.println("Connect to success");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: " + jedis.get("runoobkey"));
    }
}
