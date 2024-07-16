package org.springframework.test.ioc.service;

/**
 * @author derekyi
 */
public class HelloService {

    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }

}
