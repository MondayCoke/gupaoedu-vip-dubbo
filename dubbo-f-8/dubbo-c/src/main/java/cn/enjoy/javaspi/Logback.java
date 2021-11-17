package cn.enjoy.javaspi;

/**
 * @Classname Log4j
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/13 20:36
 * Version 1.0
 */
public class Logback implements GLog {
    @Override
    public boolean support(String type) {
        return "Logback".equalsIgnoreCase(type);
    }

    @Override
    public void debug() {
        System.out.println("====Logback.debug======");
    }

    @Override
    public void info() {
        System.out.println("====Logback.info======");
    }
}
