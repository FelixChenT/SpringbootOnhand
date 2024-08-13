package com.chentao.demo01.controller;

import com.chentao.demo01.pojo.bo.MicroServiceUrlBo;
import com.chentao.demo01.util.JsonResultUtils;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class.getName());

    @RequestMapping("/testLog")
    public JsonResultUtils<String> testLog() {
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");

        // 可以使用占位符打印出一些参数信息FFDF
        String str1 = "www.felixchen.top";
        String str2 = "kirby";
        logger.info("======测试：{} {}", str1, str2);

        return new JsonResultUtils<>("Success");
    }

    @Value("${url.orderUrl}")
    private String orderUrl;

    @RequestMapping("/testReadYml")
    public JsonResultUtils<String> testReadYml() {
        logger.info("====获取的订单服务地址为: {}",orderUrl);
        return new JsonResultUtils<>("====获取的订单服务地址为: "+ orderUrl);
    }


    @Resource
    private MicroServiceUrlBo microServiceUrl;

    @RequestMapping("/testConfig")
    public JsonResultUtils<String> testConfig() {
        logger.info("=====获取的订单服务地址为：{}", microServiceUrl.getOrderUrl());
        logger.info("=====获取的用户服务地址为：{}", microServiceUrl.getUserUrl());
        logger.info("=====获取的购物车服务地址为：{}", microServiceUrl.getShoppingUrl());
        return new JsonResultUtils<>("Success");
    }

}
