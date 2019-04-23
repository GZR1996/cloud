package com.zero.cloudzuul;

import com.zero.cloudzuul.binder.DemoBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

/**
 * @author zero
 * @date 2019/4/22 11:12:00
 */

@EnableZuulProxy
@EnableBinding({Processor.class, DemoBinder.class})
@SpringBootApplication
public class CloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudZuulApplication.class, args);
    }
}
