package com.baizhi.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

/**
 * @ClassName ShiroToken
 * @Author
 * @Date 2020/1/5 10:03
 * @Version 1.0
 **/
public class ShiroSubjectUtil {
    public Subject getSubject(String username, String password) {
        //1 创建安全管理器
        MyRealm myRealm = new MyRealm();
        CredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        ((HashedCredentialsMatcher) credentialsMatcher).setHashIterations(1024);
        ((HashedCredentialsMatcher) credentialsMatcher).setHashAlgorithmName("MD5");
        myRealm.setCredentialsMatcher(credentialsMatcher);
        SecurityManager securityManager = new DefaultWebSecurityManager(myRealm);
        //2 创建主体
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        //3 进行主体认证
        AuthenticationToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            return subject;
        } catch (UnknownAccountException e) {
            throw new RuntimeException("用户不存在");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            throw new RuntimeException("密码错误");
        }
//        return null;
    }


}
