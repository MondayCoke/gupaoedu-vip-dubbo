package cn.enjoy.stub;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Classname StubServiceImpl
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/9 20:56
 * Version 1.0
 */
@DubboService
public class StubServiceImpl implements StubService {
    @Override
    public String stub(String s) {
        System.out.println("==========本地存根业务逻辑=========");
        return s;
    }
}
