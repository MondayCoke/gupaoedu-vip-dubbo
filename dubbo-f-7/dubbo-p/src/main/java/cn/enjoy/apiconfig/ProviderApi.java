package cn.enjoy.apiconfig;

import cn.enjoy.service.UserService;
import cn.enjoy.service.UserServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.io.IOException;

/**
 * @Classname ProviderApi
 * @Description TODO
 * @Author Jack
 * Date 2021/9/29 20:43
 * Version 1.0
 */
public class ProviderApi {
    public static void main(String[] args) throws IOException {
        UserServiceImpl userService = new UserServiceImpl();

        // 1、应用信息
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo_provider");

        //2、注册信息
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");

        //3、协议信息
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        protocolConfig.setThreads(200);

        //服务发布
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registry);
        serviceConfig.setProtocol(protocolConfig);

        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
//        serviceConfig.setVersion("1.0.0");

        //服务发布
        serviceConfig.export();

        System.in.read();
    }
}
