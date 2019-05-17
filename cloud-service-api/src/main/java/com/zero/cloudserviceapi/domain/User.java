package com.zero.cloudserviceapi.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zero
 * @date 2019/5/17 13:55
 */

@Getter
@Setter
public class User {
    private String client;
    private String username;
    private String password;
}