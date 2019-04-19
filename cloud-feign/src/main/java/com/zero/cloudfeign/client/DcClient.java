package com.zero.cloudfeign.client;

import com.zero.cloudfeign.component.HystrixClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
