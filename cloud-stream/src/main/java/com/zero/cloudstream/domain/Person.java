package com.zero.cloudstream.domain;

/**
 * @author zero
 * @date 2019/4/23 9:53
 */

public class Person {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
