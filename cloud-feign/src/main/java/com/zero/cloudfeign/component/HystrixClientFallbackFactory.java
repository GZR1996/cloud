package com.zero.cloudfeign.component;

import com.alibaba.fastjson.JSONObject;
import com.zero.cloudfeign.client.DcClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zero
 * @date 2019/4/11 15:38
 */

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<DcClient> {

    private static final Logger log = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);

    @Override
    public DcClient create(Throwable throwable) {
        return new DcClient() {
            @Override
            public String consumer() {
                log.error("异常处理={}", throwable);
                return "Execute raw fallback: access service fail , " + " reason = " + throwable;
            }

            @Override
            public JSONObject setUser(String username, String password) {
                JSONObject json = new JSONObject();
                json.put("msg", "Execute raw fallback: access service fail , " + " reason = " + throwable);
                return json;
            }
        };
    }
}
