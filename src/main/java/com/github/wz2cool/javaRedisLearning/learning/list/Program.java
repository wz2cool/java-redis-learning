package com.github.wz2cool.javaRedisLearning.learning.list;

import com.github.wz2cool.javaRedisLearning.config.PropertyManager;
import redis.clients.jedis.Jedis;

import java.util.List;

public class Program {

    private static PropertyManager propertyManager = PropertyManager.getInstance();

    public static void main(String[] args) {
        String host = propertyManager.getRedisHost();
        Jedis jedis = new Jedis(host);

        System.out.println("Connect Success");

        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list: " + list.get(i));
        }
    }
}
