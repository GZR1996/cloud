package com.zero.cloudribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zero
 * @date 2019/4/28 16:58
 */

@RestController
public class DcController {

    @Autowired
    RestTemplate template;

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String dc() {
        return template.getForObject("http://cloud-eureka-client/dc", String.class);
    }
}