package com.xcxgf.cainiao.controller;


import com.xcxgf.cainiao.POJO.Building;
import com.xcxgf.cainiao.POJO.DataReturn;
import com.xcxgf.cainiao.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 办公楼管理，前端后台交互层
 * @author zyz
 */
@RestController
@RequestMapping("building")
public class BuildingController {
    @Autowired
    private BuildingService bs;


    /**
     * 获取符合查询条件的办公楼数据
     * @param request request中包含3个参数，search（查询内容），dataStart（返回数据的起始位置），dataEnd（返回数据的终止位置）
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getSearchList")
    public DataReturn getSearchList(HttpServletRequest request) {
        // 从request中获取各参数
        String search = request.getParameter("search");
        String start = request.getParameter("dataStart");
        String count = request.getParameter("dataSize");

        return bs.getSearchList(search, start,count);
    }

    /**
     * 删除记录
     * @param building 需要被删除的数据
     * @return 删除结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/deleteBuildingList")
    public int deleteBuildingList(@RequestBody Building building) {
        return bs.deleteBuildingList(building);
    }

    /**
     * 更新记录
     * @param building 需要被更新的数据
     * @return 更新结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/updateBuildingList")
    public int updateBuildingList(@RequestBody Building building) {
        return bs.updateBuildingList(building);
    }

    /**
     * 插入新记录
     * @param building 需要被插入的数据
     * @return 插入结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/insertBuildingList")
    public int insertBuildingList(@RequestBody Building building) {
        return bs.insertBuildingList(building);
    }

    /**
     * 批量插入新纪录
     * @param building 需要被插入的数据的集合
     * @return 插入结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/uploadBuildingList")
    public int insertBuildingListAll(@RequestBody List<Building> building) {
        return bs.insertBuildingListAll(building);
    }

}
