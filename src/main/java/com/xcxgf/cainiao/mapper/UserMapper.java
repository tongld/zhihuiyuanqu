package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 用户信息的后台和数据库的交互
 * @author zyz
 */
public interface UserMapper {

    /**
     * 查询记录
     *
     * @param limit 记录位置
     * @param search 查询条件
     * @return
     */
    @Select("select * from userinfo ${search} ORDER BY insertTime desc ${limit}")
    public List<User> getUserList(String search, String limit);

    /**
     * 查询记录
     *
     * @return 记录总条数
     */
    @Select("select count(*) from userinfo ORDER BY insertTime")
    public int getUserCount();

    /**
     * 插入新纪录
     *
     * @param user 需要被插入的记录对象
     * @return
     */
    @Insert("insert into userinfo " +
            "(account,password,userName,sex,telephone,department,insertTime) " +
            "value(#{account},#{password},#{userName},#{sex},#{telephone},#{department},#{insertTime})")
    public int insertUserInfo(User user);

    /**
     * 单一字段查询是否有重复数据
     *
     * @param search 查询字段
     * @param value  查询值
     * @return 0为无重复，否则为重复
     */
    @Select("select count(*) " +
            "from userinfo " +
            "where ${search} = '${value}'")
    public int isSearchSame(String search, String value);

    /**
     * 更新记录
     *
     * @param user 需要被更新的记录对象
     * @return
     */
    @Update("update userinfo " +
            "set password=#{password}," +
            "userName=#{userName}," +
            "sex=#{sex}," +
            "telephone=#{telephone}," +
            "department=#{department}," +
            "updateTime=#{updateTime} " +
            "where account=#{account}")
    public int updateUserInfo(User user);

    /**
     * 删除记录
     * @param user 需要删除的记录对象
     * @return
     */
    @Delete("delete from userinfo " +
            "where account = #{account}")
    public int deleteUserInfo(User user);
}
