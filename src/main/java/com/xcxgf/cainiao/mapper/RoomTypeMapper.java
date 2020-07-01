package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.RoomType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoomTypeMapper {
    /**
     * 获取全部房间类型的信息
     * @return
     */
    @Select("select * from roomtypeinfo")
    public List<RoomType> getRoomType();

    /**
     * 获取当前房型的每月租金
     * @param roomType
     * @return
     */
    @Select("select monthRent from roomtypeinfo where roomType=#{roomType}")
    public float getMonthRent(String roomType);

    /**
     * 新增房型
     * @param roomType
     * @return
     */
    @Insert("insert into roomtypeinfo(roomType,monthRent) values(#{roomType},#{monthRent})")
    public int insertRoomType(RoomType roomType);

    /**
     * 删除房型
     * @param id
     * @return
     */
    @Delete("delete from roomtypeinfo where id=#{id}")
    public int deleteRoomType(int id);

    /**
     * 更新房型
     * @param roomType
     * @return
     */
    @Update("update roomtypeinfo set monthRent=#{monthRent} where id=#{id}")
    public int updateMonthRent(RoomType roomType);
}
