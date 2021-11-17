package cn.enjoy.test;

import cn.enjoy.config.SpringConfiguration;
import cn.enjoy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.PostConstruct;

/**
 * @Classname SpringTest
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/10 14:46
 * Version 1.0
 */
@Component
public class SpringTest {

    @Autowired
    private UserService userService;

    private UserService userService1;

    private UserService userService2;

    private UserService userService3;
    private UserService userService4;


    public UserService getUserService() {
        return userService;
    }

    @PostConstruct
    public void init() {
        System.out.println(userService);
    }
}
