package cn.springframework.beans;

import java.beans.PropertyChangeEvent;

/**
 * 属性访问异常超类
 * 如类型不匹配，调用目标异常等
 *
 * @author dengweichang
 */
public abstract class PropertyAccessException extends BeansException {

    /**
     * java bean 属性变更事件
     *
     * @see PropertyChangeEvent
     */
    private final PropertyChangeEvent propertyChangeEvent;

    /**
     * 构造一个属性访问异常
     *
     * @param propertyChangeEvent javaBean属性变更事件
     * @param message             描述信息
     * @param cause               异常原因
     */
    public PropertyAccessException(PropertyChangeEvent propertyChangeEvent, String message, Throwable cause) {
        super(message, cause);
        this.propertyChangeEvent = propertyChangeEvent;
    }

    /**
     * 构造一个属性访问异常
     *
     * @param message 描述信息
     * @param cause   异常原因
     */
    public PropertyAccessException(String message, Throwable cause) {
        super(message, cause);
        this.propertyChangeEvent = null;
    }

    /**
     * 获取当前属性变更的事件信息
     *
     * @return 仅在bean被实际更改时才会返回
     */
    public PropertyChangeEvent getPropertyChangeEvent() {
        return propertyChangeEvent;
    }

    /**
     * @return 获取变更的属性名
     */
    public String getPropertyName() {
        return propertyChangeEvent != null ? propertyChangeEvent.getPropertyName() : null;
    }

    /**
     * @return 被变更的属性值(预期的)
     */
    public Object getValue() {
        return propertyChangeEvent != null ? propertyChangeEvent.getNewValue() : null;
    }

    /**
     * @return 对应的异常码
     */
    public abstract String getErrorCode();
}
