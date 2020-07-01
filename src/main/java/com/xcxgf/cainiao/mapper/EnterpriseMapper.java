package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Enterprise;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 对数据库中enterpriseinfo表（园区企业信息表）的增删改查操作
 * @author zyz
 */
public interface EnterpriseMapper {
    /**
     * 查询所有满足查询条件的记录，并返回记录内容
     * @param search 查询条件
     * @param limit 需要返回的记录起始位置和终止位置
     * @return Enterprise类型的集合，所有满足条件的记录集合
     */
    @Select("select * from enterpriseinfo ${search} order by insertTime desc ${limit}")
    public List<Enterprise> getSearchList(String search, String limit);

    /**
     * 查询所有满足查询条件的记录条数
     * @param search 查询条件
     * @return int类型，记录条数
     */
    @Select("SELECT count(*) FROM enterpriseinfo ${search}")
    public int getSearchCount(String search);


    /**
     * 更新记录
     * @param enterprise 需要被更新的记录对象
     * @return int类型，更新操作影响的记录条数，0为更新失败，否则更新成功
     */
    @Update("UPDATE enterpriseinfo " +
            "SET enterprisePerson=#{enterprisePerson}," +
            "contactNumber=#{contactNumber}," +
            "state=#{state}," +
            "other=#{other}," +
            "position=#{position}," +
            "annualSales=#{annualSales}," +
            "industry=#{industry}," +
            "updateTime=#{updateTime} " +
            "WHERE enterpriseName=#{enterpriseName}")
    public int updateEnterpriseInfo(Enterprise enterprise);

    /**
     * 删除记录
     * @param enterprise 需要被删除的记录对象
     * @return int类型，删除操作影响的记录条数，0为删除失败，否则删除成功
     */
    @Delete("DELETE FROM enterpriseinfo WHERE enterpriseName =#{enterpriseName}")
    public int deleteEnterpriseInfo(Enterprise enterprise);

    /**
     * 插入记录
     * @param enterprise 需要被插入的记录对象
     * @return int类型，插入操作影响的记录条数，0为插入失败，否则插入成功
     */
    @Insert("INSERT INTO enterpriseinfo(enterpriseName,enterprisePerson,contactNumber,insertTime,state,other,position,annualSales,industry) " +
            "VALUES(#{enterpriseName}, #{enterprisePerson}, #{contactNumber},#{insertTime},#{state},#{other},#{position},#{annualSales},#{industry})")
    public int insertEnterpriseInfo(Enterprise enterprise);

    /**
     * 查询是否存在重复记录（插入记录操作时）
     * @param enterprise 需要被查询的记录对象
     * @return int类型，存在的重复记录条数，0为不存在重复记录，否则存在重复记录
     */
    @Select("select count(*) from enterpriseinfo " +
            "where enterpriseName = #{enterpriseName}")
    public int insertSearchSame(Enterprise enterprise);

    /**
     * 查询是否存在重复记录（更新记录操作时）
     * @param enterprise 需要被查询的记录对象
     * @return int类型，存在的重复记录条数，0为不存在重复记录，否则存在重复记录
     */
    @Select("SELECT COUNT(*) " +
            "FROM (SELECT * FROM enterpriseinfo WHERE id NOT in (SELECT id FROM enterpriseinfo WHERE enterpriseName = #{enterpriseName})) AS temp " +
            "WHERE enterpriseName = #{enterpriseName}")
    public int updateSearchSame(Enterprise enterprise);

}
