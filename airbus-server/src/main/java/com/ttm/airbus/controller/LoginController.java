package com.ttm.airbus.controller;

import com.ttm.airbus.dal.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liguoqing on 2016/9/19.
 */
@Controller
@Configuration
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "index";
    }

}
