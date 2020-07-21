package com.xcxgf.zhihuiyuan.controller;

import com.xcxgf.zhihuiyuan.POJO.DataReturn;
import com.xcxgf.zhihuiyuan.POJO.User;
import com.xcxgf.zhihuiyuan.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户信息存储的前端与后台交互
 * @author zyz
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询记录
     *
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getUserList")
    public DataReturn getUserList(HttpServletRequest request) {
        // 从request中获取各参数
        String search = request.getParameter("search");
        String startStr = request.getParameter("dataStart");
        String endStr = request.getParameter("dataEnd");
        int start = Integer.parseInt(startStr);
        int end = Integer.parseInt(endStr);
        // 拼接limit字符串
        String searchStr = "".equals(search) ? "" : "where account like '%" + search + "%' or userName like '%" + search + "%'";
        String limitStr = "0".equals(startStr) && "0".equals(endStr) ? "" : "limit " + start + "," + end;
        return userService.getUserList(searchStr, limitStr);
    }

    /**
     * 插入记录
     *
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/insertUserInfo")
    public int insertUserInfo(@RequestBody User user) {
        return userService.insertUserInfo(user);
    }

    /**
     * 新增记录
     *
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/updateUserInfo")
    public int updateUserInfo(@RequestBody User user) {
        return userService.updateUserInfo(user);
    }

    /**
     * 删除记录
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/deleteUserInfo")
    public int deleteUserInfo(@RequestBody User user){
        return userService.deleteUserInfo(user);
    }
}
