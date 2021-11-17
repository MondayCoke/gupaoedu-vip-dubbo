package cn.enjoy.async;

import org.apache.dubbo.config.annotation.DubboService;

import java.util.concurrent.CompletableFuture;

/**
 * @Classname AsyncServiceImpl
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/9 21:43
 * Version 1.0
 */
@DubboService
public class AsyncServiceImpl implements AsyncService {

    //异步调用
    @Override
    public String asynctoDo(String s) {
        for (int i = 0; i < 10; i++) {
            System.out.println("=========AsyncServiceImpl.asynctoDo");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "OK," + s;
    }

    @Override
    public CompletableFuture<String> doOne(String s) {
        return CompletableFuture.supplyAsync(()->{
            System.out.println("=======doOne 的业务执行=========");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "doOne--OK";
        });
    }

    @Override
    public String doTwo(String s) {
        return null;
    }
}
