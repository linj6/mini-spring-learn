package org.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源的抽象和访问接口
 *
 * @author derekyi
 */
public interface Resource {

    /**
     * 获取资源输入流
     *
     * @return 资源输入流
     * @throws IOException 资源不存在时
     */
    InputStream getInputStream() throws IOException;

}
