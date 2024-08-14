package com.chentao.demo01.controller;

import com.chentao.demo01.util.JsonResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/start")
public class StartController {

    private final static Logger logger = LoggerFactory.getLogger(StartController.class.getName());

    @GetMapping("/startSpringBoot")
    public JsonResultUtils<String> startSpringBoot() {
        return new JsonResultUtils<>("Felix Chen","500","Hello SpringBoot");
    }
}
