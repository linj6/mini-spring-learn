package org.springframework.beans.factory.support;

import java.lang.reflect.Constructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @author derekyi
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    /**
     * 简单bean实例化策略，根据bean的无参构造函数实例化对象
     *
     * @param beanDefinition beanDefinition
     * @return 实例化的bean
     * @throws BeansException 实例化失败时
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            Constructor constructor = beanClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }

}
