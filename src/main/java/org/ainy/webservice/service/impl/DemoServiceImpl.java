package org.ainy.webservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.ainy.webservice.service.DemoService;

import javax.jws.WebService;

/**
 * @author 阿拉丁省油的灯
 * @date 2019-07-28 09:51
 * @description 服务端实现类
 * <p>
 * 注：此接口必须加targetNamespace，否则动态调用invoke的时候，会报找不到接口内的方法
 * </p>
 */
@Slf4j
@WebService(
        serviceName = "demoService",
        targetNamespace = "http://impl.service.webservice.ainy.org",
        endpointInterface = "org.ainy.webservice.service.DemoService")
public class DemoServiceImpl implements DemoService {

    @Override
    public String demo(String param) {

        log.info("请求数据--->{}", param);
        return "success";
    }
}
