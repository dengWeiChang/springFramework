package cn.springframework.core;

/**
 * @author dengweichang
 * <p>
 * 这里使用abstract主要是防止派生，也可以用final修饰
 * @see NestedRuntimeException
 * spring嵌套异常类处理器
 */
public abstract class NestedExceptionUtils {

    /**
     * 指定异常提示及异常根因构建消息
     *
     * @param message 消息
     * @param cause   异常
     * @return {@link String}
     */
    public static String buildMessage(String message, Throwable cause) {
        if (cause == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(64);
        if (message != null) {
            sb.append(message).append("; ");
        }
        sb.append("nested exception is ").append(cause);
        return sb.toString();
    }

    /**
     * 获取异常根因
     *
     * @param original 初始异常
     * @return {@link Throwable}
     */
    public static Throwable getRootCause(Throwable original) {
        if (original == null) {
            return null;
        }
        Throwable rootCause = null;
        Throwable cause = original.getCause();
        while (cause != null && cause != rootCause) {
            rootCause = cause;
            cause = original.getCause();
        }
        return rootCause;
    }

    /**
     * 得到最具体原因（原始异常或者根本异常）
     *
     * @param original 原始异常
     * @return {@link Throwable}
     */
    public static Throwable getMostSpecificCause(Throwable original) {
        Throwable rootCause = getRootCause(original);
        return (rootCause != null ? rootCause : original);
    }
}
