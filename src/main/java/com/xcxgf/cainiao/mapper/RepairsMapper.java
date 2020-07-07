package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Repairs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RepairsMapper {
    @Insert("insert into repair(companyName,person,telPhone,address,repairarea,problem,status) " +
            "values(#{companyName},#{person},#{telPhone},#{address},#{repairarea},#{problem},1)")
    public int addRepair(Repairs repairs);

    @Update("update repairs set status=#{status} where id=#{id}")
    public int updateRepairs(int status,int id);

    @Select("select * from repair where status=#{status} limit #{startPage},#{pageSize}")
    public List<Repairs> getRepairData();
    


}
