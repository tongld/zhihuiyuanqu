package com.xcxgf.zhihuiyuan.mapper;

import com.xcxgf.zhihuiyuan.POJO.Repairs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RepairsMapper {
    /**
     * 插入维修信息
     * @param repairs
     * @return
     */
    @Insert("insert into repair(companyName,person,telPhone,address,repairarea,problem,status) " +
            "values(#{companyName},#{person},#{telPhone},#{address},#{repairarea},#{problem},1)")
    public int addRepair(Repairs repairs);

    /**
     * 更新维修的状态
     * @param status
     * @param id
     * @return
     */
    @Update("update repair set status=#{status} where id=#{id}")
    public int updateRepairsStatus(int status,int id);

    /**
     * 更新维修人
     * @param repairman
     * @param id
     * @return
     */
    @Update("update repair set repairman=#{repairman} where id=#{id}")
    public int updateRepairman(String repairman,int id);


    /**
     * 分页查询当前状态下的维修信息
     * @param status
     * @param startPage
     * @param pageSize
     * @return
     */
    @Select("select * from repair where status=#{status} limit #{startPage},#{pageSize}")
    public List<Repairs> getRepairData(int status,int startPage,int pageSize);

    /**
     * 统计当前状态下的维修信息条数
     * @param status
     * @return
     */
    @Select("select count(*) from repair where status=#{status}")
    public int getRepairCount(int status);

    /**
     * 按公司名和状态查询
     * @param companyName
     * @param status
     * @param startPage
     * @param pageSize
     * @return
     */
    @Select("select * from repair where companyName=#{companyName} and status=#{status} limit #{startPage},#{pageSize}")
    public List<Repairs> getOwnRepairs(String companyName,int status,int startPage,int pageSize);


    /**
     * 根据公司名和状态统计
     * @param status
     * @return
     */
    @Select("select count(*) from repair where companyName=#{companyName} and status=#{status}")
    public int getOwnCount(String companyName,int status);

    
}
