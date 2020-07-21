package com.xcxgf.zhihuiyuan.controller;

import com.xcxgf.zhihuiyuan.POJO.Repairs;
import com.xcxgf.zhihuiyuan.services.RepairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class RepairsController {
    @Autowired
    RepairsService repairsService;

    /**
     * 插入维修信息
     * @param repairs
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/addRepairs")
    public int addRepairs(@RequestBody Repairs repairs){
        return repairsService.addRepairs(repairs);
    }

    /**
     * 分页查询当前状态下的维修信息
     * @param status
     * @param startPage
     * @param pageSize
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getRepairData")
    public List<Repairs> getRepairData(@RequestParam int status,@RequestParam int startPage,@RequestParam int pageSize){
        return repairsService.getRepairData(status,startPage,pageSize);
    }

    /**
     * 统计当前状态下的维修信息条数
     * @param status
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getRepairCount")
    public int getRepairCount(@RequestParam int status){
        return repairsService.getRepairCount(status);
    }

    /**
     * 跟新维修人
     * @param repairman 维修人
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/updateRepairman")
    public int updateRepairman(String repairman,int id){
        return repairsService.updateRepairman(repairman,id);
    }

    /**
     * 分页，根据公司名和信息状态获取数据
     * @param companyName 公司名
     * @param status 当前状态
     * @param startPage 起始页
     * @param pageSize 每页数据条数
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getOwnRepairs")
    public List<Repairs> getOwnRepairs(@RequestParam String companyName,@RequestParam int status,@RequestParam int startPage,@RequestParam int pageSize){
        return repairsService.getOwnRepairs(companyName,status,startPage,pageSize);
    }

    /**
     * 按公司名和信息状态统计数据
     * @param companyName
     * @param status
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getOwnCount")
    public int getOwnCount(String companyName,int status){
        return repairsService.getOwnCount(companyName,status);
    }

    /**
     * 更新维修的状态
     * @param status
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value="/updateRepairsStatus")
    public int updateRepairsStatus(@RequestParam int status,@RequestParam int id){
        return repairsService.updateRepairsStatus(status,id);
    }

}
