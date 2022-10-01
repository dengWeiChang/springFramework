package cn.springframework.beans.factory;

import cn.springframework.beans.BeansException;
import cn.springframework.core.ResolvableType;

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

    /**
     * TODO:暂时没有发现主要用途
     *
     * @param name bean名称
     * @param args 构造函数or属性注入中的参数
     * @return bean的实例
     * @throws BeansException bean包中的异常超类
     */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     * 获取指定类型的bean实例
     *
     * @param requiredType bean类型
     * @param <T>          bean类型
     * @return 如果存在则返回特定的spring bean
     * @throws BeansException bean包中的异常超类
     */
    <T> T getBean(Class<T> requiredType) throws BeansException;

    /**
     * 获取某类bean的实例提供者
     *
     * @param requiredType 指定的bean类型
     * @param <T>          class
     * @return bean的提供者
     */
    <T> ObjectProvider<T> getBeanProvider(Class<T> requiredType);

    /**
     * 获取某类bean的实例提供者
     *
     * @param requiredType 匹配的bean类型，可以是泛型
     * @return bean的提供者
     */
    <T> ObjectProvider<T> getBeanProvider(ResolvableType requiredType);

    /**
     * 工厂中是否包含指定名称的bean
     *
     * @param name bean名称或者别名
     * @return true/false
     */
    boolean containsBean(String name);

    /**
     * 指定名称的bean是否为单例bean
     *
     * @param name spring bean 名称
     * @return true/false
     * @throws NoSuchBeanDefinitionException 工厂中不存在bean定义
     */
    boolean isSingleton(String name) throws NoSuchBeanDefinitionException;

    /**
     * 指定名称的bean是否为原型bean
     *
     * @param name spring bean 名称
     * @return true/false
     * @throws NoSuchBeanDefinitionException 工厂中不存在bean定义
     */
    boolean isPrototype(String name) throws NoSuchBeanDefinitionException;

    /**
     * 检测指定名称的bean是否是某个类型
     *
     * @param name        spring bean 名称
     * @param typeToMatch 待匹配的类型
     * @return true/false
     * @throws NoSuchBeanDefinitionException 如果bean未定义则抛出
     */
    boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException;

    /**
     * 检测指定名称的bean是否与指定的类型匹配
     *
     * @param name        spring bean 名称
     * @param typeToMatch 待匹配的类型
     * @return true/false
     * @throws NoSuchBeanDefinitionException 如果bean未定义则抛出
     */
    boolean isTypeMatch(String name, Class<?> typeToMatch) throws NoSuchBeanDefinitionException;

    /**
     * 获取指定名称的bean的类型
     *
     * @param name spring bean 名称
     * @return spring bean 类类型
     * @throws NoSuchBeanDefinitionException 如果bean未定义则抛出
     */
    Class<?> getType(String name) throws NoSuchBeanDefinitionException;

    /**
     * 获取指定名称的bean的类型
     *
     * @param name                 spring bean 名称
     * @param allowFactoryBeanInit 是否允许工厂bean初始化
     * @return spring bean 类类型
     * @throws NoSuchBeanDefinitionException 如果bean未定义则抛出
     */
    Class<?> getType(String name, boolean allowFactoryBeanInit) throws NoSuchBeanDefinitionException;

    /**
     * 获取指定名称bean的别名
     *
     * @param name spring bean 名称
     * @return 别名（原始bean名称在数组第一个）
     */
    String[] getAliases(String name);
}
