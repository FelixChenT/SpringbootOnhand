package com.chentao.demo01.controller;

import com.chentao.demo01.util.JsonResultUtils;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Api(tags  = "startSpringBoot")
@RestController
@RequestMapping("/start")
public class StartController {

    private final static Logger logger = LoggerFactory.getLogger(StartController.class.getName());

    @RequestMapping("/startSpringBoot")
    public JsonResultUtils<String> startSpringBoot() {
        return new JsonResultUtils<>("Felix Chen","500","Hello SpringBoot");
    }
}
