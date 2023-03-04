package com.test.entity;

public enum Status {
    SLEEP("睡觉"),STUDY("学习"),RUNNING("跑步");
    public String name;
    Status(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
