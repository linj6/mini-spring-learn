package org.springframework.test.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;

public class SimpleBeanContainerTest {

    @Test
    public void testGetBean() {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("helloService", new HelloService());
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        String sayHello = helloService.sayHello();
        Assert.assertNotNull(helloService);
        Assert.assertEquals("hello", sayHello);
    }

    static class HelloService {

        public String sayHello() {
            System.out.println("hello");
            return "hello";
        }
    }
}
