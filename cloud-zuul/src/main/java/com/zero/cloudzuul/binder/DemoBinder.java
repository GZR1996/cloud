package com.zero.cloudzuul.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author zero
 * @date 2019/4/22 17:39
 */

public interface DemoBinder {

    String INPUT = "example-topic-1";
    String OUTPUT = "example-topic-2";

    @Input(DemoBinder.INPUT)
    SubscribableChannel input();

    @Output(DemoBinder.OUTPUT)
    MessageChannel output();
}
