package cn.springframework.beans.factory.config;

import cn.springframework.beans.BeanMetadataElement;
import cn.springframework.core.AttributeAccessor;

/**
 * spring bean 定义的一个封装接口，封装了属性值、构造函数参数值等
 *
 * @author dengweichang
 */
public interface BeanDefinition extends AttributeAccessor, BeanMetadataElement {
}
