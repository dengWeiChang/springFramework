package cn.springframework.core.convert;

/**
 * 类型转换服务入口
 *
 * @author dengweichang
 */
public interface ConversionService {

    /**
     * 是否可以将某个类型转为指定类型
     *
     * @param sourceType 待转换的类型
     * @param targetType 目标类型
     * @return true/false
     */
    boolean canConvert(Class<?> sourceType, Class<?> targetType);

    /**
     * 是否可以将某个类型转为指定类型
     *
     * @param sourceType 待转换的类型描述符
     * @param targetType 目标类型描述符
     * @return true/false
     */
    boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType);

    /**
     * 是否可以将某个资源转为指定类型
     *
     * @param source     待转换的对象
     * @param targetType 目标class类型
     * @return 转换成功的class对象
     */
    <T> T convert(Object source, Class<T> targetType);

    /**
     * 是否可以将某个资源转为指定类型
     *
     * @param source     待转换的对象
     * @param sourceType 待转换对象的类型描述符
     * @param targetType 目标类型描述符
     * @return 转换成功的class对象
     */
    Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType);
}
