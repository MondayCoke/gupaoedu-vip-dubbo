package cn.enjoy.group;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Classname GroupImpl1
 * @Description TODO
 * @Author Jack
 * Date 2021/9/29 21:46
 * Version 1.0GroupImpl1
 */
@DubboService(group = "groupImpl1")
public class GroupImpl1 implements Group {
    @Override
    public String doSomething(String s) {
        return "GroupImpl1";
    }
}
