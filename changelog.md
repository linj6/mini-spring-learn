# IOC

## 最简单的bean容器

> 代码分支：simple-bean-container

定义一个简单的BeanFactory，内部包含一个map，用来存储bean的实例。内部只有注册bean和获取bean两个方法

```
public class BeanFactory {

    private final Map<String, Object> beanMap = new HashMap<>();

    public void registerBean(String name, Object bean) {
        beanMap.put(name, bean);
    }

    public Object getBean(String name) {
        return beanMap.get(name);
    }
}
```

测试：

```
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
```

## BeanDefinition和BeanDefinitionRegistry

> 代码分支：bean-definition-and-bean-definition-registry

主要增加如下类：

- BeanDefinition：用来描述bean的定义信息，包含bean的class类型、构造参数、属性值等信息，每个bean对应一个BeanDefinition实例。 简化BeanDefinition仅包含bean的class类型。
- BeanDefinitionRegistry: BeanDefinition注册表接口，定义注册和获取BeanDefinition的方法。
- SingletonBeanRegistry及其实现类DefaultSingletonBeanRegistry，定义注册单例Bean和获取单例bean的方法。

bean容器作为BeanDefinitionRegistry和SingletonBeanRegistry的实现类，具备两者的能力。向bean容器注册BeanDefinition后，使用 bean时才会实例化。

![](./assets/bean-definition-and-bean-definition-registry.png)

测试：

```
public class BeanDefinitionAndBeanDefinitionRegistryTest {

    @Test
    public void testBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.sayHello();
    }
}

public class HelloService {

    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }

}

```

## Bean实例化策略InstantiationStrategy

> 代码分支：instantiation-strategy 现在bean是在AbstractAutowireCapableBeanFactory#doCreateBean方法中用beanClass.newInstance()来实例化，仅适用于bean有无参构造函数的情况。

![](./assets/instantiation-stratety.png)
针对bean的实例化，抽象出一个实例化策略的接口InstantiationStrategy，有两个实现类：
- SimpleInstantiationStrategy：使用bean的构造函数来实例化
- CglibSubclassInstantiationStrategy：使用Cglib动态代理来实例化
