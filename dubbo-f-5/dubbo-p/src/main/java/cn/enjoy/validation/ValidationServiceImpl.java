package cn.enjoy.validation;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Classname ValidationServiceImpl
 * @Description TODO
 * @Author Jack
 * Date 2021/9/29 22:11
 * Version 1.0
 */
@DubboService
public class ValidationServiceImpl implements ValidationService {
    @Override
    public void save(ValidationParamter validationParamter) {
        System.out.println("ValidationServiceImpl.save");
    }

    @Override
    public void update(ValidationParamter validationParamter) {
        System.out.println("ValidationServiceImpl.update");
    }

    @Override
    public void delete(long l, String s) {
        System.out.println("ValidationServiceImpl.delete");
    }
}
