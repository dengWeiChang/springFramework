package cn.springframework.core;

/**
 * 别名注册器
 *
 * @author dengweichang
 */
public interface AliasRegistry {

    /**
     * 注册一个别名
     *
     * @param name  标准的java bean名称
     * @param alias 别名
     */
    void registerAlias(String name, String alias);

    /**
     * 从注册表中移除别名
     *
     * @param alias 别名
     */
    void removeAlias(String alias);

    /**
     * 检查给定的名称是否是注册的别名
     *
     * @param name 预期的别名
     * @return true/false
     */
    boolean isAlias(String name);

    /**
     * 获取标准java bean的别名
     *
     * @param name java bean
     * @return 别名的数组
     */
    String[] getAliases(String name);
}
