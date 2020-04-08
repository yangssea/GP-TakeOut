package com.example.api.test;

import com.example.api.entity.UserAddress;
import com.example.api.service.impl.UserAddressServiceImpl;
import com.example.api.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static sun.security.krb5.Confounder.longValue;

/**
 * @author yzx
 * @date 2020/4/7  10:15
 */
@RestController
public class UserAddressTest {
    @Autowired
    private UserAddressServiceImpl userAddressService;
    public void testStart(){
        System.out.println("userAddress findAll test");
        findAllTest();
    }
    private void findAllTest(){
        long l = 1;
        List<UserAddress> list=userAddressService.findAll(l);
        if(list==null||list.size()>=0){
            System.out.println("findAll cuceess");
        }
    }
    private void saveTest(){
        long a=2;
        UserAddress userAddress=new UserAddress(a,"name","1885623982","5986","101","201","");
    }
}
