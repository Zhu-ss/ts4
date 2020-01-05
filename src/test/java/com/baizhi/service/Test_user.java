package com.baizhi.service;

import com.baizhi.dao.RATableDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.RATable;
import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName Test_user
 * @Author
 * @Date 2020/1/5 14:49
 * @Version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test_user {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RATableDao raTableDao;

    @Test
    public void test1() {
        List<User> list = userDao.selectAll();
        for (User user : list) {
            System.out.println(user);
        }
        List<RATable> raTables = raTableDao.selectAll();
        raTables.forEach(r -> System.out.println(r));
    }
}
