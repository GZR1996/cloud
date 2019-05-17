package com.zero.cloudserviceapi.service;

import com.zero.cloudserviceapi.domain.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author zero
 * @date 2019/5/17 13:56
 */

@RequestMapping(name = "/refactor")
public interface HelloService {

    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello5", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("password") String password);

    @RequestMapping(value = "/hello6", method = RequestMethod.POST)
    String hello(@RequestBody User user);

}
