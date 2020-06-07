package org.ainy.webservice.config;

import org.ainy.webservice.service.DemoService;
import org.ainy.webservice.service.impl.DemoServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @author 阿拉丁省油的灯
 * @date 2019-07-28 10:02
 * @description 服务端Webservice配置
 */
@Configuration
public class CxfConfig {

    /**
     * 此方法作用是改变项目中服务名的前缀名
     * 访问地址为   http: http://127.0.0.1:8080/demo/service?wsdl
     * 去除此方法后 http: http://127.0.0.1:8080/services/service?wsdl
     *
     * @return ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean<?> dispatcherServlet() {
        return new ServletRegistrationBean<>(new CXFServlet(), "/demo/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    /**
     * 把实现类交给spring管理
     *
     * @return DemoService
     */
    @Bean
    public DemoService demoService() {
        return new DemoServiceImpl();
    }

    /**
     * JAX-WS 站点服务
     **/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), demoService());
        endpoint.publish("/service");
        return endpoint;
    }
}
