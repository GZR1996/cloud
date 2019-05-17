package com.zero.cloudfeign.client;

import com.alibaba.fastjson.JSONObject;
import com.zero.cloudfeign.component.HystrixClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zero
 * @date 2019/4/11 14:31
 */

@FeignClient(name = "cloud-eureka-client", fallbackFactory = HystrixClientFallbackFactory.class)
public interface DcClient {

    /**
     * 服务调用接口
     * @return
     */
    @RequestMapping(value = "/dc", method = RequestMethod.GET)
    String consumer();


    @RequestMapping(value = "/setUser", method = RequestMethod.GET)
    JSONObject setUser(@RequestParam("username") String username,
                       @RequestParam("password") String password);
}
