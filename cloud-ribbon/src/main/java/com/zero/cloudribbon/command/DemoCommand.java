package com.zero.cloudribbon.command;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import org.springframework.web.client.RestTemplate;

/**
 * @author zero
 * @date 2019/4/30 11:10
 */

public class DemoCommand extends HystrixCommand<JSONObject> {

    private RestTemplate template;
    private Long id;

    public DemoCommand() {
        /*super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GroupName"))
                    .andCommandKey(HystrixCommandKey.Factory.asKey("CommandName")));*/
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GroupName"))
                    .andCommandKey(HystrixCommandKey.Factory.asKey("CommandName"))
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ThreadPoolKey")));
    }

    public DemoCommand(Setter setter, RestTemplate template, Long id) {
        super(setter);
        this.template = template;
        this.id = id;
    }

    @Override
    protected JSONObject run() throws Exception {
        return null;
    }

    @Override
    protected JSONObject getFallback() {
        return new JSONObject();
    }
}
