package cn.springframework.beans.factory;

import cn.springframework.beans.BeansException;

/**
 * 这是一个通用工厂的封装类，用于派生出可以获取一个object实例的工厂
 * <p>和factoryBean有所差异，这个工厂通常作为api来为其他springBean提供服务
 * <p>这是一个SAM(single abstract method)接口,专注于对象的获取
 *
 * @param <T>
 * @author dengweichang
 */
@FunctionalInterface
public interface ObjectFactory<T> {

    /**
     * 返回一个由ObjectFactory派生出的工厂实例产生出来的对象
     *
     * @return 对象实例
     * @throws BeansException 当创建bean失败时将抛出一个bean异常超类
     */
    T getObject() throws BeansException;
}
