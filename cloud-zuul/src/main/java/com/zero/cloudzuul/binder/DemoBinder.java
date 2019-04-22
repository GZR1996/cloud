package com.zero.cloudzuul.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author zero
 * @date 2019/4/22 17:39
 */

public interface DemoBinder {

    String NAME = "example-topic";

    @Input(DemoBinder.NAME)
    SubscribableChannel input();
}
