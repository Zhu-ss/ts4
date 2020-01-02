package com.baizhi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Ts5ApplicationTests {
    @Autowired
    private T1 t1;

    @Test
    public void test1() {
        t1.m1();
    }

    @Test
    public void test2() {
        t1.m2(1, 2);
    }

}
