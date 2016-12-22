package com.ttm.airbus.controller;

import com.ttm.airbus.dal.model.User;
import com.ttm.airbus.utils.Consist;
import com.ttm.airbus.utils.PwdEncoder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by liguoqing on 2016/9/19.
 */
@RestController
@Configuration
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private static final String SALT = "AIRBUS01";

    @RequestMapping("/airbus/login")
    public String login(String username,String userPassword){
        UsernamePasswordToken token = new UsernamePasswordToken(username, new PwdEncoder(SALT, Consist.MD5).encoder(userPassword));
        Subject subject = SecurityUtils.getSubject();
        logger.info("【开始对用户"+username+"进行身份校验】");
        subject.login(token);
        if(subject.isAuthenticated()){
            logger.info("【用户"+username+"校验通过】");
            return "login";
        }else{
            logger.info("【用户"+username+"校验失败】");
        }
        return "unauthorized";
    }

    @RequestMapping("/airbus/logout")
    public String logOut(){
        Subject subject = SecurityUtils.getSubject();
        logger.info("【用户"+((User)subject.getPrincipal()).getUserId()+"进行系统登出】");
        subject.logout();
        return "success";
    }

}
