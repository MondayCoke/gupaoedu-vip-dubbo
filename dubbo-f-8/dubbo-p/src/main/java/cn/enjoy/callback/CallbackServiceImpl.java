package cn.enjoy.callback;

import org.apache.dubbo.config.annotation.Argument;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname CallbackServiceImpl
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/9 20:38
 * Version 1.0
 */
@DubboService(methods = {@Method(name = "addListener",arguments = {@Argument(index = 1,callback = true)})})
public class CallbackServiceImpl implements CallbackService {

    @Override
    public void addListener(String s, CallbackListener callbackListener) {
        //1、支付操作
        System.out.println("===支付操作===");

        //2、回调客户端
        callbackListener.changed(getChanged(s));
    }

    private String getChanged(String key) {
        return "Changed : " + new SimpleDateFormat("yyyy-MM-dd:mm:ss").format(new Date());
    }
}
