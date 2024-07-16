package org.springframework.beans.factory.config;

/**
 * 单例对象注册表
 *
 * @author derekyi
 */
public interface SingletonBeanRegistry {

    /**
     * 注册单例对象
     *
     * @param beanName        beanName
     * @param singletonObject 单例对象
     */
    void registerSingleton(String beanName, Object singletonObject);

    /**
     * 获取单例对象
     *
     * @param beanName beanName
     * @return 单例对象
     */
    Object getSingleton(String beanName);

}
