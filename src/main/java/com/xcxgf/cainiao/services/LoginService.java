package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Login;
import com.xcxgf.cainiao.POJO.User;
import com.xcxgf.cainiao.mapper.LoginMapper;
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
