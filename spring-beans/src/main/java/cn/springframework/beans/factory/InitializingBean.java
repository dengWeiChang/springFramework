package cn.springframework.beans.factory;

/**
 * 初始化bean的接口
 *
 * <p>用于自定义初始化或检查属性配置
 *
 * @author dengweichang
 */
public interface InitializingBean {

    /**
     * 在设置所有的bean属性之后，由{@linkplain BeanFactory}调用
     *
     * @throws Exception 初始化异常或者赋值异常
     */
    void afterPropertiesSet() throws Exception;
}
