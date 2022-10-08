package cn.springframework.beans.factory.config;

/**
 * 单例bean注册器
 *
 * @author dengweichang
 */
public interface SingletonBeanRegistry {

    /**
     * 注册一个单例bean
     *
     * @param beanName        bean名称
     * @param singletonObject 现有的bean实例
     */
    void registerSingleton(String beanName, Object singletonObject);
}
