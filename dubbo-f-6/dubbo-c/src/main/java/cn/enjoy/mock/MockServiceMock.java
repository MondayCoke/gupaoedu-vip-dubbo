package cn.enjoy.mock;

/**
 * @Classname MockServiceMock
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/9 21:15
 * Version 1.0
 *
 * 1、接口名称 + Mock
 *
 * MockService + Mock
 *
 * 2、mock逻辑必须定义在接口的包下面
 *
 */
public class MockServiceMock implements MockService {
    @Override
    public String mock(String s) {
        System.out.println(this.getClass().getName() + "--mock");
        return s;
    }

    @Override
    public String queryArea(String s) {
        System.out.println(this.getClass().getName() + "--queryArea");
        return s;
    }

    @Override
    public String queryUser(String s) {
        System.out.println(this.getClass().getName() + "--queryUser");
        return s;
    }
}
