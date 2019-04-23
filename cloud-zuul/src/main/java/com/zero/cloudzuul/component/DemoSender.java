package com.zero.cloudzuul.component;

import com.zero.cloudzuul.binder.DemoBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author zero
 * @date 2019/4/23 10:30
 */

@Component
public class DemoSender {

    private MessageChannel output;

    @Autowired
    public DemoSender(@Qualifier(DemoBinder.OUTPUT) MessageChannel output) {
        this.output = output;
    }

    public void sayHello(String message) {
        this.output.send(MessageBuilder.withPayload(message).build());
    }
}
