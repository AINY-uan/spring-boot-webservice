# Spring-Boot-Webservice

SpringBoot整合Webservice

## 注意事项

### 版本问题
Springboot依赖版本：2.0.1.RELEASE

Webservice依赖版本：3.2.4

分别选择此版本的原因是因为SpringBoot整合Webservice有严格的版本限制，如果版本不一致，可能导致服务无法启动

可登录maven中央仓库查看版本

### 其他问题
SpringBoot依赖版本在2.0.6.RELEASE之和，不需要在CxfConfig配置文件中编写dispatcherServlet()方法

如果有，请删除，否则服务将无法启动并报错

<code>
Parameter 1 of constructor in org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration required a bean of type 'org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath' that could not be found.
</code>

仅需在配置文件中加入 cxf.path=/xxx配置即可