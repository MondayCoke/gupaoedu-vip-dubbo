package cn.enjoy.config;

import cn.enjoy.dubboIoc.Ioc;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @Classname ConsumerConfiguration
 * @Description TODO
 * @Author Jack
 * Date 2021/9/26 22:17
 * Version 1.0
 */
@Configuration
@EnableDubbo(scanBasePackages = "cn.enjoy")
@PropertySource("classpath:/dubbo-consumer.properties")
@Import(Ioc.class)
public class ConsumerConfiguration {
}
