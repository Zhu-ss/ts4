package com.baizhi.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Set;

/**
 * @ClassName Redisannotayion
 * @Author
 * @Date 2020/1/2 16:54
 * @Version 1.0
 **/
@Configuration
@Aspect
public class Redisannotayion {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Around("@annotation(com.baizhi.config.RedisCache)")//使用自定义注解，来进行切入，想要切入什么方法，直接在方法上面加上自定义注解
    public void addcache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String target = proceedingJoinPoint.getTarget().getClass().getName();//包名
        String method = proceedingJoinPoint.getSignature().getName();//方法名？
        Object[] args = proceedingJoinPoint.getArgs();//参数数组
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(method);
        Set<String> keys = stringRedisTemplate.keys("*");
        System.out.println(target);
        for (Object key : keys) {
            System.out.println(key + "----2");
        }
        for (Object arg : args) {
            stringBuilder.append(arg.toString());
        }
        String s = stringBuilder.toString();
        HashOperations<String, Object, Object> opsForHash = stringRedisTemplate.opsForHash();
        Boolean aBoolean = stringRedisTemplate.hasKey(target);
        Object proceed = null;
        if (aBoolean) {
            System.out.println("缓存存在，该方法返回值：" + opsForHash.get(target, s));
        } else {
            proceed = proceedingJoinPoint.proceed();
            System.out.println("缓存不存在，已新增：" + target);
            HashMap<String, Object> map = new HashMap<>();
            map.put(s, proceed);
            opsForHash.putAll(target, map);
        }
        proceedingJoinPoint.proceed();//执行被切方法
    }
}
