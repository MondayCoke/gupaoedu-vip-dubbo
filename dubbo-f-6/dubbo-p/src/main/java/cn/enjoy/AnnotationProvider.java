package cn.enjoy;

import cn.enjoy.config.ProviderConfiguration;
import cn.enjoy.zk.ZKTools;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @Classname AnnotationProvider
 * @Description TODO
 * @Author Jack
 * Date 2021/9/26 22:09
 * Version 1.0
 */
public class AnnotationProvider {
    public static void main(String[] args) throws InterruptedException {
        ZKTools.generateDubboProperties();
        new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        System.out.println("dubbo service started.");
        new CountDownLatch(1).await();
    }
}
