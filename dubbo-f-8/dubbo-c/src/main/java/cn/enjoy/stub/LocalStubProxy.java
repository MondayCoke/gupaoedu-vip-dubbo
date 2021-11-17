package cn.enjoy.stub;

/**
 * @Classname LocalStubProxy
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/9 20:58
 * Version 1.0
 * 代理层
 * 1、必须实现接口
 * 2、要定义构造函数（传递客户端引用的实例的）
 */
public class LocalStubProxy implements StubService {

    private StubService stubService;

    public LocalStubProxy(StubService stubService) {
        this.stubService = stubService;
    }

    //在这里就会对远程调用进行包装
    @Override
    public String stub(String s) {
        try {
            //1、一系列校验
            System.out.println("校验");
            //如果校验通过调用后端接口
            return stubService.stub("wuya");
        } catch (Exception e) {
            System.out.println("异常包装，服务降级");
            return "ok";
        }
    }
}
