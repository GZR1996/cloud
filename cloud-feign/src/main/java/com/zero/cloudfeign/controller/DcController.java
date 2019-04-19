package com.zero.cloudfeign.controller;

import com.zero.cloudfeign.client.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zero
 * @date 2019/4/11 13:42
 */

@RestController
public class DcController {

    @Autowired
    DcClient client;

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String dc() {
        return client.consumer();
    }
}
