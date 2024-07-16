package org.springframework.test.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.ioc.bean.Car;
import org.springframework.test.ioc.bean.Person;

public class PopulateBeanWithPropertyValuesTest {

    /**
     * 为bean注入普通属性
     */
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

    /**
     * 为bean注入bean
     */
    @Test
    public void testPopulateBeanWithBean() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册Car实例
        PropertyValues propertyValuesForCar = new PropertyValues();
        propertyValuesForCar.addPropertyValue(new PropertyValue("brand", "tesla"));
        BeanDefinition carBeanDefinition = new BeanDefinition(Car.class, propertyValuesForCar);
        beanFactory.registerBeanDefinition("car", carBeanDefinition);


        // 注册Person实例
        PropertyValues propertyValuesForPerson = new PropertyValues();
        propertyValuesForPerson.addPropertyValue(new PropertyValue("name", "昂热"));
        propertyValuesForPerson.addPropertyValue(new PropertyValue("age", 100));
        // Person实例依赖Car实例
        propertyValuesForPerson.addPropertyValue(new PropertyValue("car", new BeanReference("car")));
        beanFactory.registerBeanDefinition("person", new BeanDefinition(Person.class, propertyValuesForPerson));

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);

        Assert.assertEquals("昂热", person.getName());
        Assert.assertEquals(100, person.getAge());
        Assert.assertNotNull(person.getCar());
        Assert.assertEquals("tesla", person.getCar().getBrand());

    }

}
