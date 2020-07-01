package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Room;
import com.xcxgf.cainiao.POJO.RoomType;
import com.xcxgf.cainiao.mapper.RoomTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class RoomTypeService {
    @Autowired
    RoomTypeMapper roomTypeMapper;

    /**
     * 获取房型信息
     * @return
     */
    public List<RoomType> getRoomType(){
        return roomTypeMapper.getRoomType();
    }

    /**
     * 添加新房型
     * @param roomType
     * @return
     */
    public int insertRoomType(RoomType roomType){
        return roomTypeMapper.insertRoomType(roomType);
    }

    /**
     * 删除房型
     * @param roomType
     * @return
     */
    public int deleteRoomType(RoomType roomType){
        int id=roomType.getId();
        return roomTypeMapper.deleteRoomType(id);
    }

    /**
     * 更新租金
     * @param roomType
     * @return
     */
    public int updateMonthRent(RoomType roomType){
        return roomTypeMapper.updateMonthRent(roomType);
    }

    /**
     * 获取每月租金
     * @param roomType
     * @return
     */
    public float getMonthRent(RoomType roomType){
        String roomTypes=roomType.getRoomType();
        return roomTypeMapper.getMonthRent(roomTypes);
    }
}
