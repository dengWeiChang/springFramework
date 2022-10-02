package cn.springframework.util;

/**
 * 程序中用于断言的工具
 *
 * @author dengweichang
 */
public class Assert {

    /**
     * 非空断言
     *
     * @param object  检测的bean
     * @param message 异常描述
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 条件断言
     *
     * @param expression true/false表达式
     * @param message    异常描述
     */
    public static void state(boolean expression, String message) {
        if (!expression) {
            throw new IllegalStateException(message);
        }
    }
}
