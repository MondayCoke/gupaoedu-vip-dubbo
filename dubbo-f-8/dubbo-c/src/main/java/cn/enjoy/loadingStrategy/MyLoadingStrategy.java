package cn.enjoy.loadingStrategy;

import org.apache.dubbo.common.extension.LoadingStrategy;

/**
 * @Classname MyLoadingStrategy
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/13 21:25
 * Version 1.0
 */
public class MyLoadingStrategy implements LoadingStrategy {
    @Override
    public String directory() {
        return "META-INF/gp";
    }
}
