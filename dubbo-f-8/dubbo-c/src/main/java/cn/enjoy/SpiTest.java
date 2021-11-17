package cn.enjoy;

import cn.enjoy.dubbospi.ActivateApi;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.registry.Registry;
import org.apache.dubbo.registry.RegistryFactory;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Protocol;
import org.junit.Test;

import java.util.List;

/**
 * @Classname SpiTest
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/13 20:55
 * Version 1.0
 */
public class SpiTest {

    @Test
    public void adaptive() {
        ActivateApi adaptiveExtension = ExtensionLoader.getExtensionLoader(ActivateApi.class).getAdaptiveExtension();
        System.out.println(adaptiveExtension.getClass());
//        URL url = new URL("test://");
//        url.addParameter("activate.api","mybatis");
//        adaptiveExtension.todo("wya",url);
    }

    @Test
    public void getDefualt() {
        ActivateApi defaultExtension = ExtensionLoader.getExtensionLoader(ActivateApi.class).getDefaultExtension();
        System.out.println(defaultExtension);
    }

    /**
     getActivateExtension
     1、首先看分组，如果值@Activate只配置了分组，那么就只匹配分组值
     2、会匹配url中的参数，如果分组和value都配置了。首先匹配分组，然后在匹配url中的参数key
     */
    @Test
    public void test1() {
        URL url = URL.valueOf("test://localhost/test");
        url = url.addParameter("value1","gggg");
        //只看分组，不看url中的参数
        List<ActivateApi> rabbitmq = ExtensionLoader.getExtensionLoader(ActivateApi.class).getActivateExtension(url, new String[]{"spring"}, "rabbitmq");
        System.out.println(rabbitmq.size());
        for (ActivateApi activateApi : rabbitmq) {
            System.out.println(activateApi.getClass());
        }
    }

    @Test
    public void getExtension() {
//        ActivateApi ac = ExtensionLoader.getExtensionLoader(ActivateApi.class).getExtension("mybatis");
//        System.out.println(ac);

        Protocol po = ExtensionLoader.getExtensionLoader(Protocol.class).getExtension("dubbo");
    }

    @Test
    public void xx() {
        System.out.println(ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension());
    }

    @Test
    public void providerReg() {
        String url = "dubbo%3A%2F%2F192.168.67.3%3A20990%2Fcn.enjoy.service.UserService%3Fanyhost%3Dtrue%26application%3Ddubbo_provider%26deprecated%3Dfalse%26dubbo%3D2.0.2%26dynamic%3Dtrue%26generic%3Dfalse%26interface%3Dcn.enjoy.service.UserService%26metadata-type%3Dremote%26methods%3DdoKill%2CqueryUser%26pid%3D14092%26release%3D3.0.2.1%26retries%3D7%26revision%3D1.0-SNAPSHOT%26service-name-mapping%3Dtrue%26side%3Dprovider%26threadpool%3Dfixed%26threads%3D100%26timeout%3D5000%26timestamp%3D1635058443480";
        RegistryFactory registryFactory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
        Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://127.0.0.1:2181"));
        registry.register(URL.valueOf(URL.decode(url)));
    }
}
