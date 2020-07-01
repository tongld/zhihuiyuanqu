package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LoginMapper {
    @Select("select * from userinfo where account=#{account} ")
    public List<User>  getUserByAccount(String account);

}
