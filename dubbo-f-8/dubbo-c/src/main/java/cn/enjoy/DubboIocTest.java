package cn.enjoy;

import cn.enjoy.config.ConsumerConfiguration;
import cn.enjoy.config.IocConfiguration;
import org.apache.dubbo.rpc.AppResponse;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.*;

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

    @Test
    public void futuretest() throws ExecutionException, InterruptedException, TimeoutException {
        System.out.println(CompletableFuture.completedFuture("1").get());

//        CompletableFuture<AppResponse> appResponseFuture =
//                currentClient.request(inv, timeout, executor).thenApply(obj -> (AppResponse) obj);



        //request 请求后端接口的   远程调用  future.complete(response.getResult)
        CompletableFuture future = new CompletableFuture();
        CompletableFuture future1 = future.thenApply(i -> i);
        new Thread(()->{
            //点后端接口，完成以后掉complete方法唤醒
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            future.complete("jack");
        }).start();
        System.out.println(future1.get(1000, TimeUnit.MILLISECONDS));
    }
}
