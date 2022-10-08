package cn.springframework.beans;

/**
 * bean元数据元素超接口
 *
 * @author dengweichang
 */
public interface BeanMetadataElement {

    /**
     * 用于获取附带此元素的源数据
     *
     * @return 可能为空
     */
    default Object getSource() {
        return null;
    }
}
