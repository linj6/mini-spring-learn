package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * BeanDefinition注册表接口
 *
 * @author derekyi
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册BeanDefinition
     *
     * @param beanName       beanName
     * @param beanDefinition beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 获取beanDefinition
     *
     * @param beanName beanName
     * @return beanDefinition
     * @throws BeansException BeanDefinition不存在时
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
