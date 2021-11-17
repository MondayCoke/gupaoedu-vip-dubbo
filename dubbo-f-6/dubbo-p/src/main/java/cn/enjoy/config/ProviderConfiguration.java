package cn.enjoy.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Classname ProviderConfiguration
 * @Description TODO
 * @Author Jack
 * Date 2021/9/26 21:58
 * Version 1.0
 */
@Configuration
//作用 扫描 @DubboService注解  @DubboRef
@EnableDubbo(scanBasePackages = "cn.enjoy")
@PropertySource("classpath:/dubbo-provider.properties")
public class ProviderConfiguration {
}
