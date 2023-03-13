/**
 * 响应用户需求，决定用什么视图，需要准备什么数据来显示。Controller层负责前后端交互，接收前端请求，调用Service层，接收Service层返回的数据，最后返回具体的数据和页面到客户端
 */

package com.design.weidesignservice.controller;
import com.design.weidesignservice.annotation.PassToken;
import com.design.weidesignservice.entity.User;
import com.design.weidesignservice.result.ResultDTO;
import com.design.weidesignservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RestController
@RequestMapping("design/api/user")
public class UserController {

    @Autowired
    UserService userService;

    //实现注册功能
    @PostMapping("/register")
    @PassToken
    public ResultDTO register(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        String showName = user.getShowName();
        return userService.Insert(username, password, showName);
    }

    /**
     *
     * @param params
     * @return
     */
    @PostMapping("/login")
    @PassToken
    public ResultDTO login(@RequestBody Map<String, String> params){
        return userService.login(params.get("username"), params.get("password"));
    }

    @GetMapping("/hello")
    public String getMessage(){
        return "你好哇，我是小码仔";
    }
}
