package com.zero.cloudeurekaserverbackup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zero
 * @date 2019/4/22 11:12:00
 */

@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaServerBackupApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServerBackupApplication.class, args);
    }

}
