package com.example.api.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yzx
 * @date 2020/4/7  10:02
 */
@RunWith(SpringRunner.class)
//启动Spring
@SpringBootTest
public class TestsApplication {
    @Autowired
    private UserAddressTest userAddressTest;
    @Test
    public void entrance(){
        System.out.println("集成单元测试开始");
        System.out.println("每次修改代码都运行一遍检查代码");
        userAddressTest.testStart();
    }
}
