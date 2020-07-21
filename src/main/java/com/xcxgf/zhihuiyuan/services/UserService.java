package com.xcxgf.zhihuiyuan.services;

import com.xcxgf.zhihuiyuan.POJO.DataReturn;
import com.xcxgf.zhihuiyuan.POJO.User;
import com.xcxgf.zhihuiyuan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户管理，后台与数据库的逻辑处理层
 * @author zyz
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询记录
     *
     * @return 封装数据，包含需要返回的记录，和记录总条数
     */
    public DataReturn getUserList(String search, String limit) {
        DataReturn dataReturn = new DataReturn();
        dataReturn.setUserList(userMapper.getUserList(search, limit));
        dataReturn.setDataCount(userMapper.getUserCount());
        return dataReturn;
    }

    /**
     * 插入记录，在插入前先做判重操作，0为没有重复
     *
     * @param user
     * @return 1为添加成功，-1为已有重复,0为添加失败
     */
    public int insertUserInfo(User user) {
        int reqCode = 0;
        String search = "account";
        if (userMapper.isSearchSame(search, user.getAccount()) == 0) {
            if (userMapper.insertUserInfo(user) > 0) {
                reqCode = 1;
            }
        } else {
            reqCode = -1;
        }
        return reqCode;
    }

    /**
     * 更新记录
     *
     * @param user 需要被更新的记录对象
     * @return 0为更新失败，-1为不存在该账户，1为更新成功
     */
    public int updateUserInfo(User user) {
        int reqCode = 0;
        String search = "account";
        if (userMapper.isSearchSame(search, user.getAccount()) == 0) {
            reqCode = -1;
        } else {
            if (userMapper.updateUserInfo(user) > 0) {
                reqCode = 1;
            }
        }
        return reqCode;
    }

    /**
     * 删除记录
     *
     * @param user 需要被删除的对象
     * @return 0为删除失败，1为删除成功
     */
    public int deleteUserInfo(User user) {
        int reqCode = 0;
        if (userMapper.deleteUserInfo(user) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

}
