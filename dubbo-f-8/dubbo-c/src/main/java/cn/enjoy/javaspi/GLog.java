package cn.enjoy.javaspi;

public interface GLog {
    boolean support(String type);
    void debug();
    void info();
}
