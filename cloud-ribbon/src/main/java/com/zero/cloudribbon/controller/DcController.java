package com.zero.cloudribbon.controller;

import com.alibaba.fastjson.JSONObject;
import com.zero.cloudribbon.service.ConsumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;

import java.net.URI;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author zero
 * @date 2019/4/28 16:58
 */

@RestController
public class DcController {

    private Logger logger = LoggerFactory.getLogger(DcController.class);

    @Autowired
    private ConsumeService service;

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String consumer() {
        return service.consumer();
    }

    @RequestMapping(value = "/consumer2", method = RequestMethod.GET)
    public JSONObject consumer2() {
        return service.consumer2();
    }

    @RequestMapping(value = "/consumer3", method = RequestMethod.GET)
    public JSONObject consumer3() {
        JSONObject json;
        try {
            json = service.consumer3().get();
        } catch (InterruptedException e) {
            logger.error(e.toString());
            json = new JSONObject();
            json.put("Exception", e.toString());
        } catch (ExecutionException e) {
            logger.error(e.toString());
            json = new JSONObject();
            json.put("Exception", e.toString());
        }
        return json;
    }

    @RequestMapping(value = "/consumer4", method = RequestMethod.GET)
    public Observable<JSONObject> consumer4() {
        return service.consumer4();
    }

    @RequestMapping(value = "/consumer5", method = RequestMethod.GET)
    public JSONObject consumer5() {
        return service.consumer5();
    }
}