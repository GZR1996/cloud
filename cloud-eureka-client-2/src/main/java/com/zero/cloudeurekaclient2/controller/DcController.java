package com.zero.cloudeurekaclient2.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.cloudeurekaclient2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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
        String services = "Services 2: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @RequestMapping(value = "/setUser", method = RequestMethod.GET)
    public JSONObject setUser(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setClient("client2");
        return (JSONObject) JSONObject.toJSON(user);
    }
}
