package com.zero.cloudstream;

import com.zero.cloudstream.component.DemoBinder;
import com.zero.cloudstream.domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(DemoBinder.class)
@SpringBootApplication
public class CloudStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamApplication.class, args);
    }

    @StreamListener(DemoBinder.INPUT)
    public void handle(Person person) {
        System.out.println("Received: " + person);
    }
}
