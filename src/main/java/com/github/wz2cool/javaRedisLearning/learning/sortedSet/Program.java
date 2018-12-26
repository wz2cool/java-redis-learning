package com.github.wz2cool.javaRedisLearning.learning.sortedSet;

import com.github.wz2cool.javaRedisLearning.config.PropertyManager;
import com.github.wz2cool.javaRedisLearning.learning.sortedSet.model.User;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class Program {
    private static PropertyManager propertyManager = PropertyManager.getInstance();
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        String host = propertyManager.getRedisHost();
        Jedis jedis = new Jedis(host);


        User user1 = new User("12345", "常少鹏", 1);
        User user2 = new User("12346", "王卓卓", 3);
        User user3 = new User("12347", "邹雨欣", 2);
        User user4 = new User("12348", "郑伟山", 10);
        User user5 = new User("12349", "李超杰", 5);
        User user6 = new User("12350", "董明明", 6);
        User user7 = new User("12351", "陈国峰", 8);
        User user8 = new User("12352", "楚晓丽", 9);


        jedis.zadd("game", user1.getScore(), getUserJson(user1));
        jedis.zadd("game", user2.getScore(), getUserJson(user2));
        jedis.zadd("game", user3.getScore(), getUserJson(user3));
        jedis.zadd("game", user4.getScore(), getUserJson(user4));
        jedis.zadd("game", user5.getScore(), getUserJson(user5));
        jedis.zadd("game", user6.getScore(), getUserJson(user6));
        jedis.zadd("game", user7.getScore(), getUserJson(user7));
        jedis.zadd("game", user8.getScore(), getUserJson(user8));

        Set<String> list = jedis.zrangeByScore("game", 4, 7);

        for (String usrJson : list) {
            System.out.println(usrJson);
        }
    }

    private static String getUserJson(User user) {
        return gson.toJson(user);
    }
}
