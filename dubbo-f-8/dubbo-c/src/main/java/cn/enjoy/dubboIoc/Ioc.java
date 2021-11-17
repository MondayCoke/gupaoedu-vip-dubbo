package cn.enjoy.dubboIoc;

import cn.enjoy.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;

import javax.annotation.PostConstruct;

/**
 * @Classname Ioc
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/10 15:24
 * Version 1.0
 */
public class Ioc {
    @DubboReference(check = false/*,url = "dubbo://localhost:20880"*/,retries = 3,timeout = 6000,cluster = "failover",loadbalance = "random",methods = {@Method(name = "doKill",isReturn = false)})
    private UserService userService;

    @PostConstruct
    public void init() {
        System.out.println(userService);
        userService.queryUser("wya");
    }
}
