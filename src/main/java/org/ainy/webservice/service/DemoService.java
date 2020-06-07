package org.ainy.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author 阿拉丁省油的灯
 * @date 2019-07-28 09:49
 * @description WebService服务端
 * <p>
 * 注：此接口必须加targetNamespace，否则动态调用invoke的时候，会报找不到接口内的方法
 * </p>
 */
@WebService(targetNamespace = "http://impl.service.webservice.ainy.org")
public interface DemoService {

    /**
     * webservice接口方法
     *
     * @param param 接口参数
     * @return String
     */
    @WebMethod
    @WebResult
    String demo(@WebParam String param);
}
