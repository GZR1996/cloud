package com.zero.cloudribbon.service;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.zero.cloudribbon.controller.DcController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author zero
 * @date 2019/4/30 9:55
 */

@Service
public class ConsumeService {

    @Autowired
    private RestTemplate template;

    public String consumer() {
        ResponseEntity<String> entity = template.getForEntity("http://CLOUD-EUREKA-CLIENT/dc", String.class, "zero");
        String body = entity.getBody();
        Object object = template.getForObject("http://CLOUD-EUREKA-CLIENT/dc", String.class, "zero");
        return (String) object;
    }

    /**
     * 熔断-同步实现
     * @return
     */
    @HystrixCommand(fallbackMethod = "setUserFallback")
    public JSONObject consumer2() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(
                "http://CLOUD-EUREKA-CLIENT/setUser?username={username}&password={123456}")
                .build()
                .expand("hello", "world")
                .encode();
        URI uri = uriComponents.toUri();
        LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) template.getForObject(uri, Object.class);
        JSONObject json = new JSONObject(true);
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            json.put((String) entry.getKey(), entry.getValue());
        }
        return json;
    }

    /**
     * 熔断-异步实现
     * @return
     */
    @HystrixCommand
    public Future<JSONObject> consumer3() {
        return new AsyncResult<JSONObject>() {
            @Override
            public JSONObject invoke() {
                UriComponents uriComponents = UriComponentsBuilder.fromUriString(
                        "http://CLOUD-EUREKA-CLIENT/setUser?username={username}&password={123456}")
                        .build()
                        .expand("hello", "world")
                        .encode();
                URI uri = uriComponents.toUri();
                LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) template.getForObject(uri, Object.class);
                JSONObject json = new JSONObject(true);
                Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = iterator.next();
                    json.put((String) entry.getKey(), entry.getValue());
                }
                return json;
            }
        };
    }

    public JSONObject setUserFallback() {
        JSONObject json = new JSONObject();
        json.put("msg", "fallback");
        return json;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
