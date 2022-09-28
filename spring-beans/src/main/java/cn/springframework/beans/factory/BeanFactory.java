package cn.springframework.beans.factory;

import cn.springframework.beans.BeansException;

/**
 * bean工厂,spring bean容器的根接口
 * <p>
 * 返回基于原型模式或单例模式等设计模式产生的对象
 * 工厂的实现需要尽量符合如下标准
 * <ol>
 * <li>BeanNameAware's {@code setBeanName}
 * <li>BeanClassLoaderAware's {@code setBeanClassLoader}
 * <li>BeanFactoryAware's {@code setBeanFactory}
 * <li>EnvironmentAware's {@code setEnvironment}
 * <li>EmbeddedValueResolverAware's {@code setEmbeddedValueResolver}
 * <li>ResourceLoaderAware's {@code setResourceLoader}
 * (only applicable when running in an application context)
 * <li>ApplicationEventPublisherAware's {@code setApplicationEventPublisher}
 * (only applicable when running in an application context)
 * <li>MessageSourceAware's {@code setMessageSource}
 * (only applicable when running in an application context)
 * <li>ApplicationContextAware's {@code setApplicationContext}
 * (only applicable when running in an application context)
 * <li>ServletContextAware's {@code setServletContext}
 * (only applicable when running in a web application context)
 * <li>{@code postProcessBeforeInitialization} methods of BeanPostProcessors
 * <li>InitializingBean's {@code afterPropertiesSet}
 * <li>a custom {@code init-method} definition
 * <li>{@code postProcessAfterInitialization} methods of BeanPostProcessors
 * </ol>
 *
 * <p>
 *     销毁bean时需要符合以下标准
 * <ol>
 * <li>{@code postProcessBeforeDestruction} methods of DestructionAwareBeanPostProcessors
 * <li>DisposableBean's {@code destroy}
 * <li>a custom {@code destroy-method} definition
 * </ol>
 *
 * @author dengweichang
 */
public interface BeanFactory {

    /**
     * 工厂bean前缀,
     * 若有此前缀，则从容器中根据名称获取到的bean是产生该bean的一个工厂
     */
    String FACTORY_BEAN_PREFIX = "&";

    /**
     * 获取bean实例
     *
     * @param name bean名称
     * @return {@link Object}
     * @throws BeansException bean包中的异常超类
     */
    Object getBean(String name) throws BeansException;

    /**
     * 获取bean实例
     * <p>
     * 与{@link #getBean(String)}类似，但是会校验获取到的bean是否是指定类型
     * </p>
     *
     * @param name         名字
     * @param requiredType 所需类型
     * @return {@link T}
     * @throws BeansException 如果没有找到类，则抛出
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
