package cn.enjoy.mock;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Classname MockServiceImpl
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/9 21:12
 * Version 1.0
 */
@DubboService
public class MockServiceImpl implements MockService {
    @Override
    public String mock(String s) {
        System.out.println("=======mockservice的业务处理=======");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=======mockservice的业务处理完成=======");
        return "MockServiceImpl.mock";
    }

    @Override
    public String queryArea(String s) {
        return s;
    }

    @Override
    public String queryUser(String s) {
        return s;
    }
}
