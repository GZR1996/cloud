package com.zero.cloudzuul;

import com.zero.cloudzuul.binder.DemoBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

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

   /* @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Person handle(Person person) {
        System.out.println("Received 1: " + person);
        person.setName(person.toString().toUpperCase());
        System.out.println("Set Name: " + person);
        return person;
    }

    @StreamListener(DemoBinder.INPUT)
    public void handleMyPipe(Person person) {
        int a;
        System.out.println("Received 2: " + person);
    }*/

    public static class Person {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return this.name;
        }
    }
}
