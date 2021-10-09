package cn.enjoy.merger;

import org.apache.dubbo.rpc.cluster.Merger;

/**
 * @Classname StringMerger
 * @Description TODO
 * @Author Jack
 * Date 2021/9/29 21:55
 * Version 1.0
 */
public class StringMerger implements Merger<String> {
    @Override
    public String merge(String... items) {
        if(items.length == 0) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (String item : items) {
            if(item != null) {
                builder.append(item).append("-");
            }
        }
        return builder.toString();
    }
}
