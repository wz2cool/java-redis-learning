package com.github.wz2cool.javaRedisLearning.learning.sortedSet.model;

public class User {

    private String id;                //编号
    private String name;            //姓名
    private double score;            //得分
    private int rank;                //排名

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public User() {

    }


    public User(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

}
