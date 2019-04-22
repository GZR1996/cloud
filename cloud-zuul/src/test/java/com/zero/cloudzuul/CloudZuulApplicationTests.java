package com.zero.cloudzuul;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableBinding(value = {CloudZuulApplicationTests.ExampleBinder.class})
public class CloudZuulApplicationTests {

    @Autowired
    private ExampleBinder exampleBinder;

    @Test
    public void test() {
        System.out.println("111111");
    }

    @Test
    public void exampleBinderTester() {
        exampleBinder.output().send(MessageBuilder.withPayload("Produce a message from : http://blog.didispace.com").build());
    }

    public interface ExampleBinder {

        String NAME = "example-topic";

        @Output(ExampleBinder.NAME)
        MessageChannel output();

    }
}
