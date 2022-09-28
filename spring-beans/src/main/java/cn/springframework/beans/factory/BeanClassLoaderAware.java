package cn.springframework.beans.factory;

/**
 * 透出spring类加载器
 *
 * @author dengweichang
 */
public interface BeanClassLoaderAware extends Aware {

    /**
     * spring对象实例的类加载器
     * <p>调用时机:填充java类属性之后，在初始化对象回调之前</p>
     *
     * @param classLoader 类装入器
     */
    void setBeanClassLoader(ClassLoader classLoader);
}
