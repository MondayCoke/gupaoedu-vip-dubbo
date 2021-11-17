package cn.enjoy.javaspi;

import org.junit.Test;

import java.util.*;

/**
 * @Classname MyTest
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/13 20:38
 * Version 1.0
 */
public class MyTest {

    //不同的入参，对应调用的逻辑是不一样的
    public static void main(String[] args) {
        //这个是我们业务的核心代码，核心代码会根据外部的参数决定要掉哪一个实例的路径
        //可以去读配置文件 properties配置，去决定掉哪个实例
        //jdk api  加载配置文件配置实例
        ServiceLoader<GLog> all = ServiceLoader.load(GLog.class);
        Iterator<GLog> iterator = all.iterator();

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        while (iterator.hasNext()) {
            GLog next = iterator.next();
            //这个实例是不是我们需要掉的
            // 策略模式  当前实例是不是跟入参匹配
            if(next.support(s)) {
                next.debug();
            }
        }
    }

    @Test
    public void test() {
        //入参
        String type = "slf4j1";

        //加载外部的东西，SPI，加载文件
        Map<String,GLog> map = new HashMap<>();
        map.put("log4j",new Log4j());
        map.put("logback",new Logback());
        map.put("slf4j",new Slf4j());
        map.put("slf4j1",new Slf4j1());
        //

        for (String s : map.keySet()) {
            if(map.get(s).support(type)) {
                map.get(s).debug();
            }
            /*if(type.equalsIgnoreCase("log4j")) {
                new Log4j().debug();
            } else if(type.equalsIgnoreCase("logback")) {
                new Logback().debug();
            } else if(type.equalsIgnoreCase("slf4j")) {
                new Slf4j().debug();
            } else if(type.equalsIgnoreCase("slf4j")) {
                new Slf4j().debug();
            }*/
       }
    }
}
