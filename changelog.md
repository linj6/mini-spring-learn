 # IOC
 ## 最简单的bean容器
 > 分支：simple-bean-container

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





