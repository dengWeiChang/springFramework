package cn.springframework.core;

/**
 * spring中用于嵌套运行时异常的抽象类
 *
 * <p>抽象类，需要定义子类以识别不同的异常类型，这里没有异常码之分（框架异常跟业务异常定义有一定区别）
 *
 * @author dengweichang
 */
public abstract class NestedRuntimeException extends RuntimeException {

    /**
     * 序列化id
     */
    private static final long serialVersionUID = 5439915454935047936L;

    /**
     * 构建一个带有描述信息的异常
     *
     * @param message 消息
     */
    public NestedRuntimeException(String message) {
        super(message);
    }

    /**
     * 构建一个带有描述信息及异常原因的异常
     *
     * @param message 消息
     * @param cause   异常原因
     */
    public NestedRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
