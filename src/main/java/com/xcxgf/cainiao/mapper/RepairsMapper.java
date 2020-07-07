package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Repairs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface RepairsMapper {
    @Insert("insert info repairs(companyName,person,telPhone,address,repairarea,problem,status) " +
            "values(#{companyName},#{person},#{telPhone},#{address},#{repairarea},#{problem},1)")
    public int addRepair(Repairs repairs);

    @Update("update repairs set status=#{status} where id=#{id}")
    public int updateRepairs(int status,int id);



}
