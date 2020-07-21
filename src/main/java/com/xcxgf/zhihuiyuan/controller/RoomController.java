package com.xcxgf.zhihuiyuan.controller;

import com.xcxgf.zhihuiyuan.POJO.Building;
import com.xcxgf.zhihuiyuan.POJO.DataReturn;
import com.xcxgf.zhihuiyuan.POJO.Room;
import com.xcxgf.zhihuiyuan.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 办公室管理，前端后台交互层
 * @author zyz
 */
@RestController
@RequestMapping("room")
public class RoomController {
    @Autowired
    private RoomService rs;

    /**
     * 获取符合查询条件的办公室数据
     *
     * @param request request中包含3个参数，search（查询内容），dataStart（返回数据的起始位置），dataEnd（返回数据的终止位置）
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getSearchList")
    public DataReturn getSearchList(HttpServletRequest request) {
        // 从request中获取各参数
        String search = request.getParameter("search");
        String start = request.getParameter("dataStart");
        String count = request.getParameter("dataSize");
        String dataType = request.getParameter("dataType");

        return rs.getSearchList(search, start, count, dataType);
    }

    /**
     * 删除数据
     *
     * @param room 需要被删除的数据
     * @return 删除结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/deleteRoomList")
    public int deleteRoomList(@RequestBody Room room) {
        return rs.deleteRoomList(room);
    }

    /**
     * 插入记录
     *
     * @param room 需要被插入的数据
     * @return 插入结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/insertRoomList")
    public int insertRoomList(@RequestBody Room room) {
        return rs.insertRoomList(room);
    }

    /**
     * 更新记录
     *
     * @param room 需要被更新的数据
     * @return 更新结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/updateRoomList")
    public int updateRoomList(@RequestBody Room room) {
        return rs.updateRoomList(room);
    }

    /**
     * 批量插入记录（上传记录）
     *
     * @param roomList 需要被插入的数据的集合
     * @return 插入结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/uploadRoomList")
    public int uploadRoomList(@RequestBody List<Room> roomList) {
        return rs.uploadRoomList(roomList);
    }

    /**
     * 查询办公楼数据
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getBuildingList")
    public List<Building> getBuildingList(HttpServletRequest request){
        String dataType = request.getParameter("dataType");
        return rs.getBuildingList(dataType);
    }


}
