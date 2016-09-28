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
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liguoqing on 2016/9/21.
 */
@Component
public class UserAuthorizingRealm extends AuthorizingRealm{

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @PostConstruct
    public void UserAuthorizingRealm(){
        setName("user-authorizing-realm");
    }

    //授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username =  (String)principalCollection.getPrimaryPrincipal();
        //User user =  (User)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        roleMapper.findByUserId(username).forEach(role ->{
            roles.add(role.getName());
            permissionMapper.findByRoleId(role.getPkId()).forEach(permission -> permissions.add(permission.getCode()));
        });
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }

    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        User user = userMapper.findByUserId(username);
        if(null != user) {
            return new SimpleAuthenticationInfo(user.getUserId(), user.getUserPwd(), getName());
            //return new SimpleAuthenticationInfo(user,user.getUserPwd(),getName());
        }
        throw new UnknownAccountException();
    }
}
