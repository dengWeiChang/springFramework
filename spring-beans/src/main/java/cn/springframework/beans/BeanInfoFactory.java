package cn.springframework.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;

/**
 * 为spring bean创建bean info的顶层接口.
 * 可以插入自定义的bean属性解析策略
 *
 * @author dengweichang
 */
public interface BeanInfoFactory {

    /**
     * 返回给定类的Bean信息，如果不支持则返回null
     *
     * @param beanClass bean类
     * @return {@link BeanInfo}
     * @throws IntrospectionException 内省异常
     */
    BeanInfo getBeanInfo(Class<?> beanClass) throws IntrospectionException;
}
