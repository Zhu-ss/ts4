package com.baizhi.service;

import com.baizhi.config.RedisCache;
import org.springframework.stereotype.Component;

/**
 * @ClassName T1
 * @Author
 * @Date 2019/12/31 15:02
 * @Version 1.0
 **/
//@Component
@Component
public class T1 {

    public void m1() {
        System.out.println("测试");
        System.out.println("再次测试");
        System.out.print("github修改，本地进行更新");
        System.out.print("本地修改，GitHub进行更新");
        System.out.print("本地修改，GitHub进行更新");
        System.out.println("协同开发，猿A--完毕");
        System.out.println("协同开发，猿XXX--完毕");
    }

    @RedisCache
    public String m2(Integer a, Integer b) {
        System.out.println("测试注解式开发redis缓存");
        return "success";
    }
}
