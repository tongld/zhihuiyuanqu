package com.xcxgf.zhihuiyuan.mapper;

import com.xcxgf.zhihuiyuan.POJO.SouSouClient;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author gdd
 */
public interface SouSouClientMapper {

    /**
     * 获取全部嗖嗖鸟意向客户信息
     * @return
     */
    @Select("select * from sousouclientinfo where companyName like CONCAT('%',#{name},'%') or zsFuZeRen like CONCAT('%',#{name},'%') order by createTime desc limit #{startPage},#{pageSize}")
    public List<SouSouClient> getClientList(int startPage,int pageSize,String name);

    /**
     * 搜索某公司是否已经存在记录
     * @param companyName
     * @return
     */
    @Select("select count(*) from sousouclientinfo where companyName=#{companyName}")
    public int selectClientByName(String companyName);
    /**
     * 获取意向客户总条数
     * @return
     */
    @Select("select count(*) from sousouclientinfo where companyName like CONCAT('%',#{name},'%') or zsFuZeRen like CONCAT('%',#{name},'%')")
    public int getClientCount(String name);

    /**
     * 更新客户信息
     * @param souSouClient 客户信息类
     * @return
     */
    @Update("update sousouclientinfo set " +
            "contactPerson=#{contactPerson}," +
            "zhiWei=#{zhiWei}," +
            "phoneNumber=#{phoneNumber}," +
            "sales=#{sales}," +
            "zsFuZeRen=#{zsFuZeRen}," +
            "communication=#{communication}" +
            "where companyName=#{companyName}")
    public int updateClient(SouSouClient souSouClient);

    /**
     * 插入新的意向客户
     * @param souSouClient
     * @return
     */
    @Insert("insert into sousouclientinfo(companyName," +
            "city," +
            "contactPerson," +
            "zhiWei," +
            "phoneNumber," +
            "category," +
            "pingTai," +
            "sales," +
            "zsFuZeRen," +
            "communication," +
            "createTime)" +
            "Values(#{companyName}," +
            "#{city}," +
            "#{contactPerson}," +
            "#{zhiWei}," +
            "#{phoneNumber}," +
            "#{category}," +
            "#{pingTai}," +
            "#{sales}," +
            "#{zsFuZeRen}," +
            "#{communication}," +
            "#{createTime})")
    public int insertClient(SouSouClient souSouClient);

    /**
     * 删除意向客户
     * @param companyName
     * @return
     */
    @Delete("delete from sousouclientinfo where companyName=#{companyName}")
    public int deleteClient(String companyName);

    /**
     * 获取全部意向客户信息
     * @param name
     * @return
     */
    @Select("select * from sousouclientinfo where companyName like CONCAT('%',#{name},'%')")
    public List<SouSouClient> getAllClient(String name);
}
