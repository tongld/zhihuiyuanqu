package com.xcxgf.zhihuiyuan.services;

import com.xcxgf.zhihuiyuan.POJO.Login;
import com.xcxgf.zhihuiyuan.POJO.User;
import com.xcxgf.zhihuiyuan.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    LoginMapper loginMapper;
    public int getUserByAccount(Login login){
        String account=login.getUsername();
        String password=login.getPassword();
        
        List<User> users=loginMapper.getUserByAccount(account);
        if(users.toArray().length<=0){
            return 404;
        }
        if(!users.get(0).getPassword().equals(password))
        {
            return 500;
        }
        return 100;
    }
}
