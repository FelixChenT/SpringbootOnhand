package com.chentao.demo01.controller;

import com.chentao.demo01.pojo.bo.UserBo;
import com.chentao.demo01.util.JsonResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jsonResult")
public class JsonResultController {

    private final static Logger logger = LoggerFactory.getLogger(JsonResultController.class.getName());

        @GetMapping("/user")
        public JsonResultUtils<UserBo> getUser() {
            UserBo user = new UserBo();
            return new JsonResultUtils<>(user);
        }

        @GetMapping("/list")
        public JsonResultUtils<List> getUserList() {
            List<UserBo> userList = new ArrayList<>();
            UserBo user1 = new UserBo();
            UserBo user2 = new UserBo();
            userList.add(user1);
            userList.add(user2);
            return new JsonResultUtils<>(userList, "获取用户列表成功");
        }

        @GetMapping("/map")
        public JsonResultUtils<Map> getMap() {
            Map<String, Object> map = new HashMap<>(3);
            UserBo user = new UserBo();
            map.put("作者信息", user);
            map.put("博客地址", "http://felixchen.top");
            map.put("CSDN地址", null);
            map.put("粉丝数量", 4153);
            return new JsonResultUtils<>(map);
        }


}
