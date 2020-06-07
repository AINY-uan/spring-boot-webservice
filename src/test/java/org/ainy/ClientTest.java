package org.ainy;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

/**
 * @author 阿拉丁省油的灯
 * @description 客户端测试
 * @date 2020-06-07 14:15
 */
@Slf4j
public class ClientTest {

    @Test
    public void ex() {

        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://127.0.0.1:8080/demo/service?wsdl");
        // 需要密码的情况需要加上用户名和密码
        /*client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));*/
        try {
            // invoke("方法名" ,参数1, 参数2, 参数3....);
            Object[] objects = client.invoke("demo", "哈哈哈");
            log.info("返回数据--->{}", objects[0]);
        } catch (Exception e) {
            log.error("[ERROR]", e);
        }
    }
}
