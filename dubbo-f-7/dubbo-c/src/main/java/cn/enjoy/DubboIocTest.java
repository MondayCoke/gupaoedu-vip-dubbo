package cn.enjoy;

import cn.enjoy.config.ConsumerConfiguration;
import cn.enjoy.config.IocConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @Classname DubboIocTest
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/10 15:22
 * Version 1.0
 */
public class DubboIocTest {
    public static void main(String[] args) throws InterruptedException {
        new AnnotationConfigApplicationContext(IocConfiguration.class);
        System.out.println("dubbo service started.");
        new CountDownLatch(1).await();
    }
}
