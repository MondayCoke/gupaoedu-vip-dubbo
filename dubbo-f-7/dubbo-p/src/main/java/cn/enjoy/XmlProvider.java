package cn.enjoy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @Classname XmlProvider
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/10 11:31
 * Version 1.0
 */
public class XmlProvider {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationProvider.xml");
        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
}
