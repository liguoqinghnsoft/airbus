package com.ttm.airbus.config.shiro;

import com.ttm.airbus.dal.mapper.PermissionMapper;
import com.ttm.airbus.dal.mapper.RoleMapper;
import com.ttm.airbus.dal.mapper.UserMapper;
import com.ttm.airbus.dal.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liguoqing on 2016/9/21.
 */
@Component
public class UserAuthorizingRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthorizingRealm.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @PostConstruct
    public void UserAuthorizingRealm() {
        setName("user-authorizing-realm");
    }

    //授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user =  (User)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        logger.info("【身份授权】 参数:用户ID {}", user.getUserId());
        Set<String> roles = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        //超级管理员
        if ("ADMIN".equals(user.getUserId())) {
            roleMapper.findAll().forEach(role -> {
                roles.add(role.getName());
                permissionMapper.findByRoleId(role.getPkId()).forEach(permission -> permissions.add(permission.getCode()));
            });
        } else {
            //普通管理员
            //查询角色的权限
            roleMapper.findByUserId(user.getPkId()).forEach(role -> {
                roles.add(role.getName());
                permissionMapper.findByRoleId(role.getPkId()).forEach(permission -> permissions.add(permission.getCode()));
            });
            //查询用户的权限
            permissionMapper.findByUserId(user.getPkId()).forEach(permission -> permissions.add(permission.getCode()));
        }
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }

    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        logger.info("【身份认证】 参数:用户ID {} 用户密码 {}", token.getUsername(), new String(token.getPassword()));
        User user = userMapper.login(new User(token.getUsername(), new String(token.getPassword())));
        if (null != user) {
            return new SimpleAuthenticationInfo(user,user.getUserPwd(),getName());
        }
        throw new UnknownAccountException();
    }
}
