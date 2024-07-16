package org.springframework.beans.factory.config;

import java.util.Objects;
import org.springframework.beans.PropertyValues;

/**
 * BeanDefinition实例保存bean的信息，包括class类型，构造参数，是否为单例等，此处简化为只包含class类型
 *
 * @author derekyi
 */
public class BeanDefinition {

    private Class beanClass;
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = Objects.nonNull(propertyValues) ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
