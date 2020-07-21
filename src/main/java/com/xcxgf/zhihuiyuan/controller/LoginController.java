package com.xcxgf.zhihuiyuan.controller;

import com.xcxgf.zhihuiyuan.POJO.Login;
import com.xcxgf.zhihuiyuan.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(method = RequestMethod.POST,value="/log")
    public int getUserByAccount(@RequestBody Login login){
        return loginService.getUserByAccount(login);
    }
}
