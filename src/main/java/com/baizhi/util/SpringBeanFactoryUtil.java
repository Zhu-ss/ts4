package com.baizhi.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName SpringBeanFactoryUtil
 * @Author
 * @Date 2020/1/5 9:46
 * @Version 1.0
 **/
@Component
public class SpringBeanFactoryUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringBeanFactoryUtil.applicationContext == null) {
            SpringBeanFactoryUtil.applicationContext = applicationContext;
        }
    }

    private SpringBeanFactoryUtil() {
        // TODO Auto-generated constructor stub
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    // 根据名称-------@Resource 注解
    public static Object getBeanByName(String name) {
        return getApplicationContext().getBean(name);
    }

    // 根据类型-------@Autowired 注解
    public static <T> T getBeanByType(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    // 根据名称和类型--------@Autowired+@Qualifier
    public static <T> T getBeanByNameAndType(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}