package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.Enterprise;
import com.xcxgf.cainiao.POJO.Login;
import com.xcxgf.cainiao.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
