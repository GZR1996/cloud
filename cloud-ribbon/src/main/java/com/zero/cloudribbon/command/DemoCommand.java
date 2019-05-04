package com.zero.cloudribbon.command;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zero
 * @date 2019/4/30 11:10
 */

public class DemoCommand extends HystrixCommand<JSONObject> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private RestTemplate template;
    private Long id;

    public DemoCommand() {
        /*super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GroupName"))
                    .andCommandKey(HystrixCommandKey.Factory.asKey("CommandName")));*/
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("1"))
                    .andCommandKey(HystrixCommandKey.Factory.asKey("2"))
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("3")));
        logger.info("CommandKey: " + this.commandKey);
    }

    public DemoCommand(Setter setter, RestTemplate template, Long id) {
        super(setter);
        this.template = template;
        this.id = id;
    }

    /**
     * 重载执行方法
     * @return
     * @throws Exception
     */
    @Override
    protected JSONObject run() throws Exception {
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
     * 重载熔断方法
     * @return
     */
    /*@Override
    protected JSONObject getFallback() {
        JSONObject json = new JSONObject();
        json.put("msg", "fallback");
        return json;
    }*/

    /**
     * 重载缓存方法
     * @return
     *//*
    @Override
    protected String getCacheKey() {
        return String.valueOf(id);
    }*/
}
