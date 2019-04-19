package com.zero.cloudeurekaclient2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
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
        String services = "Services 2: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
