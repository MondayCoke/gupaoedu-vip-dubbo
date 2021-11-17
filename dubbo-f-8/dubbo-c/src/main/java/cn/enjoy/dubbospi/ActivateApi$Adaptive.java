package cn.enjoy.dubbospi;

/**
 * @Classname ActivateApi$Adaptive
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/13 22:10
 * Version 1.0
 */
import org.apache.dubbo.common.extension.ExtensionLoader;
public class ActivateApi$Adaptive implements cn.enjoy.dubbospi.ActivateApi {
    public java.lang.String todo(java.lang.String arg0, org.apache.dubbo.common.URL arg1)  {
        if (arg1 == null) throw new IllegalArgumentException("url == null");
        org.apache.dubbo.common.URL url = arg1;
        String extName = url.getParameter("activate.api", "spring");
        if(extName == null) throw new IllegalStateException("Failed to get extension (cn.enjoy.dubbospi.ActivateApi) name from url (" + url.toString() + ") use keys([activate.api])");
        cn.enjoy.dubbospi.ActivateApi extension = (cn.enjoy.dubbospi.ActivateApi)ExtensionLoader.getExtensionLoader(cn.enjoy.dubbospi.ActivateApi.class).getExtension(extName);
        return extension.todo(arg0, arg1);
    }
}
