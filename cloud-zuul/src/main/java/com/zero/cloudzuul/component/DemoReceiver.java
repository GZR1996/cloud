package com.zero.cloudzuul.component;

import com.zero.cloudzuul.binder.DemoBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @author zero
 * @date 2019/4/22 18:54
 */

@EnableBinding(DemoBinder.class)
public class DemoReceiver {

    @Autowired
    private DemoSender sender;

    private static Logger logger = LoggerFactory.getLogger(DemoReceiver.class);

    @StreamListener(target = DemoBinder.INPUT, condition = "headers['version']=='1.0'")
    /*@SendTo(DemoBinder.OUTPUT)*/
    public void receive1(@Payload String payload, @Header("version") String version) {
        logger.info("Received: version 1.0: " + payload);
        payload += version;
        sender.sayHello(payload);
        /*return payload;*/
    }

    @StreamListener(target = DemoBinder.INPUT, condition = "headers['version']=='2.0'")
    /*@SendTo(DemoBinder.OUTPUT)*/
    public void receive2(@Payload String payload, @Header("version") String version) {
        logger.info("Received: version 2.0: " + payload);
        payload += version;
        sender.sayHello(payload);
        /*return payload;*/
    }
}
