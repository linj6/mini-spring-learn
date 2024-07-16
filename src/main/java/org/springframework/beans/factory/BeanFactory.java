package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * @author derekyi
 */
public interface BeanFactory {

    /**
     * 获取bean
     *
     * @param beanName beanName
     * @return bean
     * @throws BeansException bean不存在时
     */
    Object getBean(String beanName) throws BeansException;

}
