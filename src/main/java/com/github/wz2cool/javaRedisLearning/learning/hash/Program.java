package com.github.wz2cool.javaRedisLearning.learning.hash;

import com.github.wz2cool.javaRedisLearning.config.PropertyManager;

public class Program {
    public static void main(String[] args) {
        String host = PropertyManager.getInstance().getRedisHost();
        System.out.println("hello world: " + host);


    }
}
