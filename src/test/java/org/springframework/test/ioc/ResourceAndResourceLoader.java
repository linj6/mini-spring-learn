package org.springframework.test.ioc;

import cn.hutool.core.io.IoUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class ResourceAndResourceLoader {

    @Test
    public void testResourceLoader() throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        // 加载classpath下的资源
        Resource resource = resourceLoader.getResource("classpath:hello.txt");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.read(inputStream, StandardCharsets.UTF_8);
        System.out.println(content);
        Assert.assertEquals("hello world", content);

        // 加载文件系统资源
        resource = resourceLoader.getResource("src/test/resources/hello.txt");
        inputStream = resource.getInputStream();
        content = IoUtil.read(inputStream, StandardCharsets.UTF_8);
        System.out.println(content);
        Assert.assertEquals("hello world", content);

        // 加载url资源
        resource = resourceLoader.getResource("https://www.baidu.com");
        inputStream = resource.getInputStream();
        content = IoUtil.read(inputStream, StandardCharsets.UTF_8);
        System.out.println(content);
        Assert.assertTrue(content.contains("百度一下，你就知道"));
    }

}
