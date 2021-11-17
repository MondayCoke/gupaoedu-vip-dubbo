package cn.enjoy.javaspi;

/**
 * @Classname Log4j
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/13 20:36
 * Version 1.0
 */
public class Log4j implements GLog {
    @Override
    public boolean support(String type) {
        return "log4j".equalsIgnoreCase(type);
    }

    @Override
    public void debug() {
        System.out.println("====log4j.debug======");
    }

    @Override
    public void info() {
        System.out.println("====log4j.info======");
    }
}
