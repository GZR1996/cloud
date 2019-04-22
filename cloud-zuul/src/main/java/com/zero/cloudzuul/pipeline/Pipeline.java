package com.zero.cloudzuul.pipeline;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author zero
 * @date 2019/4/22 17:39
 */

public interface Pipeline {

    String INPUT = "output";

    @Input(Pipeline.INPUT)
    SubscribableChannel input();
}
