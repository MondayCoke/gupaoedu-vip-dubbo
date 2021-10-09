package cn.enjoy.test;

import cn.enjoy.config.ConsumerConfiguration;
import cn.enjoy.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Classname AnnotationTest
 * @Description TODO
 * @Author Jack
 * Date 2021/9/26 22:18
 * Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConsumerConfiguration.class)
public class AnnotationTest {

    @DubboReference(check = false)
    private UserService userService;

    @Test
    public void test1() {
        System.out.println(userService.queryUser("WUYA"));
    }
}
