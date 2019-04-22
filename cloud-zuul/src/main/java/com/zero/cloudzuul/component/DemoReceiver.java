package com.zero.cloudzuul.component;

import com.zero.cloudzuul.binder.DemoBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author zero
 * @date 2019/4/22 18:54
 */

@EnableBinding(DemoBinder.class)
public class DemoReceiver {

    private static Logger logger = LoggerFactory.getLogger(DemoReceiver.class);

    @StreamListener(DemoBinder.NAME)
    public void receive(String payload) {
        logger.info("Received: " + payload);
    }
}
