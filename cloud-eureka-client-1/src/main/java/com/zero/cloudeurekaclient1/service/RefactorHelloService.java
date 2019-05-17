package com.zero.cloudeurekaclient1.service;

import com.zero.cloudserviceapi.domain.User;
import com.zero.cloudserviceapi.service.HelloService;

/**
 * @author zero
 * @date 2019/5/17 14:28
 */

public class RefactorHelloService implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello" + name;
    }

    @Override
    public User hello(String name, String password) {
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setClient("client1");
        return user;
    }

    @Override
    public String hello(User user) {
        return null;
    }
}
