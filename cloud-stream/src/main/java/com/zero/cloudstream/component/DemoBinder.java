package com.zero.cloudstream.component;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author zero
 * @date 2019/4/23 9:44
 */

public interface DemoBinder {

    String INPUT = "example-topic-2";

    @Input(DemoBinder.INPUT)
    SubscribableChannel input();
}
