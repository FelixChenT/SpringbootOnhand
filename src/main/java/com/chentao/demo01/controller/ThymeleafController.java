package com.chentao.demo01.controller;

import com.chentao.demo01.pojo.bo.BloggerBo;
import com.chentao.demo01.pojo.bo.UserBo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    /*
     * 【注】这里有个问题需要注意一下，前面的课程中我们说了微服务中会走向前后端分离
     * ，我们在 Controller 层上都是使用的 @RestController 注解，
     * 自动会把返回的数据转成 json 格式。但是在使用模板引擎时，Controller 层就不能用 @RestController 注解了，因为在使用 thymeleaf 模板时，
     * 返回的是视图文件名，比如上面的 Controller 中是返回到 index.html 页面，如果使用 @RestController 的话，会把 index 当作 String 解析了，
     * 直接返回到页面了，而不是去找 index.html 页面。
     *
     * 所以在使用模板时要用 @Controller 注解。
     * */

    @RequestMapping("/test404")
    public String test404() {
        return "index";
    }

    @GetMapping("/test500")
    public String test500() {
        int i = 1 / 0;
        return "index";
    }

    @GetMapping("/getBlogger")
    public String getBlogger(Model model) {
        BloggerBo blogger = new BloggerBo(1L, "测试", "123456");
        model.addAttribute("blogger", blogger);
        return "blogger";
    }

    @GetMapping("/getList")
    public String getList(Model model) {
        BloggerBo blogger1 = new BloggerBo(1L, "测试", "123456");
        BloggerBo blogger2 = new BloggerBo(2L, "测试课", "123456");
        List<BloggerBo> list = new ArrayList<>();
        list.add(blogger1);
        list.add(blogger2);
        model.addAttribute("list", list);
        return "list";
    }
}
