package cn.springframework.beans;

import cn.springframework.util.Assert;
import cn.springframework.util.ClassUtils;

import java.beans.PropertyChangeEvent;

/**
 * 为属性赋值时，匹配不到类型的异常
 *
 * @author dengweichang
 */
public class TypeMismatchException extends PropertyAccessException {

    /**
     * 特定的异常码
     */
    public static final String ERROR_CODE = "typeMismatch";


    /**
     * 属性名
     */
    private String propertyName;

    /**
     * 要注入的值
     */
    private final transient Object value;

    /**
     * 需要的目标类型
     */
    private final Class<?> requiredType;

    /**
     * 生成一个类型不匹配异常实例
     *
     * @param propertyChangeEvent 属性变更事件
     * @param requiredType        目标类型
     * @param cause               异常原因
     */
    public TypeMismatchException(PropertyChangeEvent propertyChangeEvent, Class<?> requiredType,
                                 Throwable cause) {

        super(propertyChangeEvent,
                "Failed to convert property value of type '" +
                        ClassUtils.getDescriptiveType(propertyChangeEvent.getNewValue()) + "'" +
                        (requiredType != null ?
                                " to required type '" + ClassUtils.getQualifiedName(requiredType) + "'" : "") +
                        (propertyChangeEvent.getPropertyName() != null ?
                                " for property '" + propertyChangeEvent.getPropertyName() + "'" : ""),
                cause);
        this.propertyName = propertyChangeEvent.getPropertyName();
        this.value = propertyChangeEvent.getNewValue();
        this.requiredType = requiredType;
    }

    /**
     * 生成一个没有异常根因的异常实例
     *
     * @param value        要注入的值
     * @param requiredType 目标类型
     */
    public TypeMismatchException(Object value, Class<?> requiredType) {
        this(value, requiredType, null);
    }

    /**
     * 生成一个异常实例
     *
     * @param value        要注入的值
     * @param requiredType 目标类型
     * @param cause        异常原因
     */
    public TypeMismatchException(Object value, Class<?> requiredType, Throwable cause) {
        super("Failed to convert value of type '" + ClassUtils.getDescriptiveType(value) + "'" +
                        (requiredType != null ? " to required type '" + ClassUtils.getQualifiedName(requiredType) + "'" : ""),
                cause);
        this.value = value;
        this.requiredType = requiredType;
    }

    /**
     * 初始化属性名称
     *
     * @param propertyName 属性名称
     */
    public void initPropertyName(String propertyName) {
        Assert.state(this.propertyName == null, "Property name already initialized");
        this.propertyName = propertyName;
    }

    @Override
    public String getErrorCode() {
        return null;
    }
}
