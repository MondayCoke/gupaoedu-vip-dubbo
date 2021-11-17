package cn.enjoy.javaspi;

/**
 * @Classname Slf4j
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/13 20:47
 * Version 1.0
 */
public class Slf4j1 implements GLog {
    @Override
    public boolean support(String type) {
        return "Slf4j1".equalsIgnoreCase(type);
    }

    @Override
    public void debug() {
        System.out.println("====Slf4j1.debug======");
    }

    @Override
    public void info() {
        System.out.println("====Slf4j1.info======");
    }
}
