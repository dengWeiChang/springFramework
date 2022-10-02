package cn.springframework.util;

import java.lang.reflect.Proxy;
import java.util.StringJoiner;

/**
 * java class 工具
 *
 * @author dengweichang
 */
public class ClassUtils {

    /**
     * 获取给定类型的类型描述
     *
     * @param value java bean
     * @return bean的类型
     */
    public static String getDescriptiveType(Object value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (Proxy.isProxyClass(clazz)) {
            String prefix = clazz.getName() + " implementing ";
            StringJoiner result = new StringJoiner(",", prefix, "");
            for (Class<?> ifc : clazz.getInterfaces()) {
                result.add(ifc.getName());
            }
            return result.toString();
        } else {
            return clazz.getTypeName();
        }
    }

    /**
     * 获取类的标准类型
     *
     * @param clazz java bean
     * @return {@linkplain  Class#getTypeName()}
     */
    public static String getQualifiedName(Class<?> clazz) {
        Assert.notNull(clazz, "Class must not be null");
        return clazz.getTypeName();
    }
}
