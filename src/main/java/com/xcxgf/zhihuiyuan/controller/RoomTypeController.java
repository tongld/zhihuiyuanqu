package com.xcxgf.zhihuiyuan.controller;

import com.xcxgf.zhihuiyuan.POJO.RoomType;
import com.xcxgf.zhihuiyuan.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("RoomType")
public class RoomTypeController {
    @Autowired
    RoomTypeService roomTypeService;

    /**
     * 获取房型信息
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getRoomTypes")
    public List<RoomType> getRoomType(){
        return roomTypeService.getRoomType();
    }

    /**
     * 添加新房型
     * @param roomType
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/insertRoomType")
    public int insertRoomType(@RequestBody RoomType roomType){
        return roomTypeService.insertRoomType(roomType);
    }

    /**
     * 删除房型
     * @param roomType
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/deleteRoomType")
    public int deleteRoomType(@RequestBody RoomType roomType){
        return roomTypeService.deleteRoomType(roomType);
    }

    /**
     * 更新租金
     * @param roomType
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/updateMonthRent")
    public int updateMonthRent(@RequestBody RoomType roomType){
        return roomTypeService.updateMonthRent(roomType);
    }

    /**
     * 获取每月租金
     * @param roomTypes
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getMonthRent")
    public float getMonthRent(@RequestBody RoomType roomTypes){
        return roomTypeService.getMonthRent(roomTypes);
    }
}
