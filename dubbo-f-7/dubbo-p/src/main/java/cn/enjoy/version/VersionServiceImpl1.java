package cn.enjoy.version;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Classname VersionServiceImpl1
 * @Description TODO
 * @Author Jack
 * Date 2021/9/29 22:04
 * Version 1.0
 */
@DubboService(version = "1.0.0")
public class VersionServiceImpl1 implements VersionService {
    @Override
    public String version(String s) {
        return "VersionServiceImpl1";
    }
}
