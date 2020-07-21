package com.xcxgf.zhihuiyuan.mapper;

import com.xcxgf.zhihuiyuan.POJO.Renewal;
import com.xcxgf.zhihuiyuan.POJO.Room;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RenewalMapper {
    /**
     * 获取合同详细信息
     * @param contractId
     * @return
     */
    @Select("select * from dormitorycontinueinfo where contractId=#{contractId} order by continueEndTime desc,insertTime desc")
    public List<Renewal> getRenewalList(String contractId);

    /**
     * 获取合同详情总条数
     * @param dormitoryMid
     * @return
     */
    @Select("select count(*) from dormitorycontinueinfo where contractId=#{dormitoryMid}  ")
    public int getCount(int dormitoryMid);

    /**
     * 新增合同详情
     * @param entityReneweal
     * @return
     */
    @Insert("insert into dormitorycontinueinfo (owner," +
            "contractId," +
            "contractType," +
            "continueStartTime," +
            "continueEndTime," +
            "continuePeriod," +
            "totalCost," +
            "insertTime) " +
            "values(#{owner}," +
            "#{contractId}," +
            "#{contractType}," +
            "#{continueStartTime}," +
            "#{continueEndTime}," +
            "#{continuePeriod}," +
            "#{totalCost}," +
            "#{insertTime})")
    public int insertRenewals(Renewal entityReneweal);

    /**
     * 合同变更更新房间业主
     * @param room
     * @return
     */
    @Update("update roominfo set owner=#{owner} where buildingName=#{buildingName} and roomNumber=#{roomNumber}")
    public int updateRoom(Room room);
}
