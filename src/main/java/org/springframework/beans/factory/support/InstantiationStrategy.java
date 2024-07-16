package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * Bean的实例化策略
 *
 * @author derekyi
 */
public interface InstantiationStrategy {

    /**
     * 实例化bean
     *
     * @param beanDefinition beanDefinition
     * @return 实例化的bean
     * @throws BeansException 实例化失败时
     */
    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
