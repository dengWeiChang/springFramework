package cn.springframework.beans.factory;

import cn.springframework.beans.BeansException;
import cn.springframework.core.ResolvableType;

public class NoSuchBeanDefinitionException extends BeansException {

    /**
     * spring bean名称
     */
    private final String beanName;

    /**
     * spring bean类型
     */
    private final ResolvableType resolvableType;

    /**
     * 构造函数
     *
     * @param name spring bean名称
     */
    public NoSuchBeanDefinitionException(String name) {
        super("No bean named '" + name + "' available");
        this.beanName = name;
        this.resolvableType = null;
    }

    /**
     * 构造函数
     *
     * @param name    spring bean名称
     * @param message 描述信息
     */
    public NoSuchBeanDefinitionException(String name, String message) {
        super("No bean named '" + name + "' available: " + message);
        this.beanName = name;
        this.resolvableType = null;
    }
}
