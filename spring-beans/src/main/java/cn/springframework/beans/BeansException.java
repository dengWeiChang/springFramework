package cn.springframework.beans;

import cn.springframework.core.NestedRuntimeException;

/**
 * Bean包所有异常的超类,不可实例化
 *
 * @author dengweichang
 */
public abstract class BeansException extends NestedRuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
