package org.springframework.test.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.ioc.bean.Person;

public class PopulateBeanWithPropertyValuesTest {

    @Test
    public void testPopulateBeanWithPropertyValues() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "昂热"));
        propertyValues.addPropertyValue(new PropertyValue("age", "100"));
        beanFactory.registerBeanDefinition("person", new BeanDefinition(Person.class, propertyValues));

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        Assert.assertEquals("昂热", person.getName());
        Assert.assertEquals(100, person.getAge());
    }

}
