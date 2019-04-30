package com.zero.cloudeurekaclient1.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.cloudeurekaclient1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zero
 * @date 2019/4/11 11:56
 */

@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dc")
    public String dc() {
        String services = "Services 1: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @RequestMapping(value = "/setUser", method = RequestMethod.GET)
    public JSONObject setUser(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setClient("client1");
        JSONObject json = (JSONObject) JSONObject.toJSON(user);
        return json;
    }
}
