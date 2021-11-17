package cn.enjoy.config;

import cn.enjoy.dubboIoc.Ioc;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @Classname IocConfiguration
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/10 15:28
 * Version 1.0
 */
@Configuration
@EnableDubbo(scanBasePackages = "cn.enjoy.dubboIoc")
@PropertySource("classpath:/dubbo-consumer.properties")
@Import(Ioc.class)
public class IocConfiguration {
}
