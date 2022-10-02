package cn.springframework.beans;

import cn.springframework.core.MethodParameter;
import cn.springframework.core.convert.TypeDescriptor;

import java.lang.reflect.Field;

/**
 * 类型转换器的超接口
 *
 * @author dengweichang
 */
public interface TypeConverter {

    /**
     * 将一个值转为指定的类型
     *
     * @param value        要转换的值
     * @param requiredType 目标类型
     * @return 转换后的值
     * @throws TypeMismatchException 类型转换失败时抛出
     */
    <T> T convertIfNecessary(Object value, Class<T> requiredType) throws TypeMismatchException;

    /**
     * 将一个值转为指定的类型
     *
     * @param value        要转换的值
     * @param requiredType 目标类型
     * @param methodParam  目标的方法参数,暂时不清楚用途
     * @return 转换后的值
     * @throws TypeMismatchException 类型转换失败时抛出
     */
    <T> T convertIfNecessary(Object value, Class<T> requiredType, MethodParameter methodParam) throws TypeMismatchException;

    /**
     * 将一个值转为指定的类型
     *
     * @param value        要转换的值
     * @param requiredType 目标类型
     * @param field        目标的反射字段
     * @return 转换后的值
     * @throws TypeMismatchException 类型转换失败时抛出
     */
    <T> T convertIfNecessary(Object value, Class<T> requiredType, Field field) throws TypeMismatchException;

    /**
     * 将一个值转为指定的类型
     *
     * @param value          要转换的值
     * @param requiredType   目标类型
     * @param typeDescriptor 目标对象的类型描述，支持数组或集合的泛型
     * @return 转换后的值
     * @throws TypeMismatchException 类型转换失败时抛出
     */
    default <T> T convertIfNecessary(Object value, Class<T> requiredType, TypeDescriptor typeDescriptor) throws TypeMismatchException {
        throw new UnsupportedOperationException("TypeDescriptor resolution not supported");
    }
}
