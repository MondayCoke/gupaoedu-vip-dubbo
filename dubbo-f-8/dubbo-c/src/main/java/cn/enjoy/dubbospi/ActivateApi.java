package cn.enjoy.dubbospi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @Classname ActivateApi
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/13 20:52
 * Version 1.0
 */
//这个是必须的
@SPI("spring")
public interface ActivateApi {
    @Adaptive
    String todo(String param, URL url);
}
