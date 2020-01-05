package com.baizhi.util;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyRealm
 * @Author
 * @Date 2020/1/3 16:33
 * @Version 1.0
 **/
public class MyRealm extends AuthorizingRealm {
    @Override//授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取主身份
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
//        User user = userDao.selectOne(primaryPrincipal);
        //根据身份查角色   设置主身份的权限
        AuthorizationInfo authorizationInfo = null;
        if (primaryPrincipal != null) {
            authorizationInfo = new SimpleAuthorizationInfo();
            List<String> strings = new ArrayList<>();
            //添加角色
            strings.add("admin");
            strings.add("superAdmin");
            ((SimpleAuthorizationInfo) authorizationInfo).addRoles(strings);
            //添加权限
            ArrayList<String> list = new ArrayList<>();
            list.add("user:select:*");//对user表拥有查询权限
            list.add("user:select:1");//对user表中id为 1 拥有查询权限
            list.add("user:*");//对user表拥有所有操作权限
            ((SimpleAuthorizationInfo) authorizationInfo).addStringPermissions(list);
        }
        return authorizationInfo;
    }

    @Override//认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        System.out.println("开始认证=》" + principal);
        AuthenticationInfo authenticationInfo = null;
        if (principal != null) {
            authenticationInfo = new SimpleAuthenticationInfo(
                    "222", "7898b3274711377e0ce33b2a527add89", ByteSource.Util.bytes("222")
                    , this.getName()
            );
           /* authenticationInfo = new SimpleAuthenticationInfo(
                    user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getSalt())
                    , this.getName()
            );*/
        }
        return authenticationInfo;
    }
}
