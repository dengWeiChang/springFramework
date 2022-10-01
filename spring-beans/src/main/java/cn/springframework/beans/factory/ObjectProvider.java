package cn.springframework.beans.factory;

/**
 * {@linkplain ObjectFactory}的变体，用于获取对象
 * <p>接口扩展了{@linkplain Iterable}支持流式处理
 *
 * @param <T>
 * @author dengweichang
 */
public interface ObjectProvider<T> extends ObjectFactory<T>, Iterable<T> {

    // TODO:暂无使用的地方，等阅读到具体调用方时补充方法
}
