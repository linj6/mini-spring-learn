package org.springframework.core.io;

/**
 * 资源加载器接口
 *
 * @author derekyi
 */
public interface ResourceLoader {

    /**
     * 获取资源
     *
     * @param location 资源位置
     * @return 资源
     */
    Resource getResource(String location);

}
