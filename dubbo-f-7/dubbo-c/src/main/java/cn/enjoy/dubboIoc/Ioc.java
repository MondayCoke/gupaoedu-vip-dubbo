package cn.enjoy.dubboIoc;

import cn.enjoy.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;

import javax.annotation.PostConstruct;

/**
 * @Classname Ioc
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/10 15:24
 * Version 1.0
 */
public class Ioc {
    @DubboReference
    private UserService userService;

    @PostConstruct
    public void init() {
        System.out.println(userService);
    }
}
