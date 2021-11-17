package cn.enjoy;

import cn.enjoy.config.ProviderConfiguration;
import cn.enjoy.config.SpringConfiguration;
import cn.enjoy.zk.ZKTools;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @Classname SpringIocTest
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/10 15:11
 * Version 1.0
 */
public class SpringIocTest {
    public static void main(String[] args) throws InterruptedException {
        new AnnotationConfigApplicationContext(SpringConfiguration.class);
        new CountDownLatch(1).await();
    }
}
