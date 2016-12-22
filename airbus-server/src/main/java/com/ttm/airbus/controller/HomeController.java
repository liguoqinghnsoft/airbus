package com.ttm.airbus.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liguoqing on 2016/8/30.
 */
@RestController
@Configuration
public class HomeController {

    @RequestMapping("/user/home")
    @RequiresPermissions({"user:query","ADMIN"})
    @RequiresRoles({})
    public String home(){
        return "It works!";
    }

}
