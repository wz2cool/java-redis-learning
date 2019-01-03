package com.github.wz2cool.javaRedisLearning.learning.hash;

import com.github.wz2cool.javaRedisLearning.config.PropertyManager;

import com.github.wz2cool.javaRedisLearning.learning.hash.model.User;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class Program {
    private static PropertyManager propertyManager = PropertyManager.getInstance();

    public static void main(String[] args) {
        User user = new User();
        user.setEmail("wz2cool@live.cn");
        user.setFirstName("frank");
        user.setLastName("Wang");
        user.setPassword("test123");
        user.setUsername("wz2cool");

        insertUser(user);

        user.setEmail("test@live.cn");
        updateEmail(user);
    }

    private static void insertUser(User user) {
        Map<String, String> userProperties = new HashMap<>();
        userProperties.put("username", user.getUsername());
        userProperties.put("firstName", user.getFirstName());
        userProperties.put("lastName", user.getLastName());
        userProperties.put("email", user.getEmail());
        userProperties.put("password", user.getPassword());

        String host = propertyManager.getRedisHost();
        try (Jedis jedis = new Jedis(host)) {
            jedis.hmset("user: " + user.getUsername(), userProperties);
        }
    }

    private static void updateEmail(User user) {
        String host = propertyManager.getRedisHost();
        try (Jedis jedis = new Jedis(host)) {
            jedis.hset("user: " + user.getUsername(), "email", user.getEmail());
        }
    }
}
