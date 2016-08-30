package com.ttm.airbus.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liguoqing on 2016/8/30.
 */
@RestController
@Configuration
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        return "It works!";
    }

}
