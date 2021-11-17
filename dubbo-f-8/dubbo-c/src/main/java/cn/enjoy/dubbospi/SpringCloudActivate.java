package cn.enjoy.dubbospi;

import org.apache.dubbo.common.URL;

/**
 * @Classname DubboActivate
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/13 20:54
 * Version 1.0
 */
public class SpringCloudActivate implements ActivateApi {
    @Override
    public String todo(String param, URL url) {
        return param;
    }
}
