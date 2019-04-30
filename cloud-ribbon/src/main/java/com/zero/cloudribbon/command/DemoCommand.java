package com.zero.cloudribbon.command;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * @author zero
 * @date 2019/4/30 11:10
 */

public class DemoCommand extends HystrixCommand<JSONObject> {

    private RestTemplate template;
    private Long id;

    public DemoCommand(Setter setter, RestTemplate template, Long id) {
        super(setter);
        this.template = template;
        this.id = id;
    }

    @Override
    protected JSONObject run() throws Exception {
        return null;
    }
}
