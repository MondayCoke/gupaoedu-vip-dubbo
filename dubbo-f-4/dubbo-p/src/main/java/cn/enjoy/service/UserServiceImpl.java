package cn.enjoy.service;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Author Jack
 * Date 2021/9/26 21:54
 * Version 1.0
 */
@DubboService
public class UserServiceImpl implements UserService {
    @Override
    public String queryUser(String s) {
        System.out.println(s);
        System.out.println("==========provider===========" + s);
        return "OK--" + s;
    }

    @Override
    public void doKill(String s) {
        System.out.println("==========provider===========" + s);
    }
}
