package com.zero.cloudfeign.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.cloudfeign.client.DcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zero
 * @date 2019/4/11 13:42
 */

@RestController
public class DcController {

    private Logger logger = LoggerFactory.getLogger(DcController.class);

    @Autowired
    DcClient client;

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String dc(@RequestHeader("Accept-Encoding") String encoding) {
        logger.info(encoding);
        return client.consumer();
    }

    @RequestMapping(value = "consumer1", method = RequestMethod.GET)
    public JSONObject consumer1() {
        return client.setUser("123", "123");
    }
}
