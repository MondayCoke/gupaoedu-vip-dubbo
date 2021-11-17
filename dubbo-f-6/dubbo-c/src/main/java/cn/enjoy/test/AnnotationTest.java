package cn.enjoy.test;

import cn.enjoy.async.AsyncService;
import cn.enjoy.callback.CallbackListener;
import cn.enjoy.callback.CallbackService;
import cn.enjoy.config.ConsumerConfiguration;
import cn.enjoy.group.Group;
import cn.enjoy.mock.MockService;
import cn.enjoy.service.UserService;
import cn.enjoy.stub.StubService;
import cn.enjoy.validation.ValidationParamter;
import cn.enjoy.validation.ValidationService;
import cn.enjoy.version.VersionService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.GenericService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

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

    @DubboReference(check = false/*,url = "dubbo://localhost:20880"*/,retries = 3,timeout = 1000,cluster = "failover",loadbalance = "random")
    private UserService userService;

    //*要聚合所有接口的实例
    @DubboReference(check = false,group = "*",parameters = {"merger","true"})
    private Group group;

    @DubboReference(check = false,version = "1.0.0")
    private VersionService versionService;

    @DubboReference(check = false,validation = "true")
    private ValidationService validationService;

    @DubboReference(check = false)
    private CallbackService callbackService;

    @DubboReference(check = false,stub = "cn.enjoy.stub.LocalStubProxy")
    private StubService stubService;

//    @DubboReference(check = false,mock = "true")
//    @DubboReference(check = false,mock = "cn.enjoy.mock.LocalMockService")
    @DubboReference(check = false,mock = "force:return gpwy")
    private MockService mockService;

    @DubboReference(check = false,timeout = 1000000000,methods = {@Method(name = "asynctoDo",async = true),@Method(name = "doOne",async = false)})
    private AsyncService asyncService;

    @Test
    public void test1() {
        System.out.println(userService.queryUser("WUYA"));
    }

    @Test
    public void refService() {
        // 1、应用信息
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo_consumer");

        //2、注册信息
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");

        //引用API
        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registry);
        referenceConfig.setInterface(UserService.class);

        //服务引用  。这个引用过程非常重，如果想用api方式去引用服务，这个对象需要缓存
        UserService userService = referenceConfig.get();
        System.out.println(userService.queryUser("wuya"));
    }

    @Test
    public void group() {
        System.out.println(group.doSomething("wuya"));
    }

    @Test
    public void version() {
        System.out.println(versionService.version("wuya"));
    }

    @Test
    public void validation() {
        ValidationParamter paramter = new ValidationParamter();
        paramter.setName("wuya");
        paramter.setAge(98);
        paramter.setLoginDate(new Date(System.currentTimeMillis() - 10000000));
        paramter.setExpiryDate(new Date(System.currentTimeMillis() + 10000000));
        validationService.save(paramter);
    }

    @Test
    public void usegeneric() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo_consumer");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");

        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setInterface("cn.enjoy.service.UserService");
        //这个是使用泛化调用
        referenceConfig.setGeneric(true);
        GenericService genericService = referenceConfig.get();

        Object result = genericService.$invoke("queryUser", new String[]{"java.lang.String"}, new Object[]{"wuya"});
        System.out.println(result);
    }

    @Test
    public void callback() {
        callbackService.addListener("wuya", new CallbackListener() {
            @Override
            public void changed(String s) {
                //这个方法就是来处理客户端的回调逻辑
                //修改订单状态
                System.out.println("回调客户端逻辑，修改订单状态==" + s);
            }
        });
    }

    @Test
    public void stub() {
        System.out.println(stubService.stub("wuya"));
    }

    @Test
    public void mock() {
        System.out.println(mockService.mock("wy"));
    }

    @Test
    public void mock1() {
        System.out.println(mockService.queryArea("wy"));
    }

    @Test
    public void async() throws InterruptedException {
        String aa = asyncService.asynctoDo("aa");
        System.out.println("main==" + aa);
        System.out.println("并行调用其他接口====");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //需要拿到异步调用的返回结果
        CompletableFuture<Object> resultFuture = RpcContext.getContext().getCompletableFuture();
        resultFuture.whenComplete((retValue,exception)->{
            if(exception == null) {
                System.out.println("正常返回==" + retValue);
            } else {
                exception.printStackTrace();
            }
        });
        Thread.currentThread().join();
    }

    @Test
    public void asyncDoOne() throws InterruptedException {
        CompletableFuture<String> resultFuture = asyncService.doOne("wy");
        resultFuture.whenComplete((retValue,exception)->{
            if(exception == null) {
                System.out.println("正常返回==" + retValue);
            } else {
                exception.printStackTrace();
            }
        });
        Thread.currentThread().join();
    }
}
