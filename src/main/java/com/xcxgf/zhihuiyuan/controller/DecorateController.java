package com.xcxgf.zhihuiyuan.controller;

import com.xcxgf.zhihuiyuan.POJO.Decorate;
import com.xcxgf.zhihuiyuan.services.DecorateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DecorateController {
    @Autowired
    DecorateService decorateService;

    /**
     * 新增装修申请信息
     * @param decorate
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/applydecorate")
    public int applyDecorate(@RequestBody Decorate decorate){
        return decorateService.applyDecorate(decorate);
    }

    /**
     * 当前公司根据分页查询申请
     * @param companyName
     * @param startPage
     * @param pageSize
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getListByCname")
    public List<Decorate> getSurrenderListByCname(@RequestParam String companyName,@RequestParam int startPage,@RequestParam int pageSize){
        return decorateService.getSurrenderListByCname(companyName,startPage,pageSize);
    }

    /**
     * 统计该公司共有多少申请
     * @param companyName
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getCountByCname")
    public int getCountByCname(@RequestParam String companyName){
        return decorateService.getCountByCname(companyName);
    }

    /**
     * 根据审核状态分页获取信息
     * @param status
     * @param startPage
     * @param pageSize
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getDecoraterList")
    public List<Decorate> getDecoraterList(@RequestParam Boolean status,@RequestParam int startPage,@RequestParam int pageSize){
        return decorateService.getDecoraterList(status,startPage,pageSize);
    }

    /**
     * 根据状态统计信息总条数
     * @param status
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getCountByStatus")
    public int getCountByStatus(@RequestParam Boolean status){
        return decorateService.getCountByStatus(status);
    }

    /**
     * 是否通过装修申请
     * @param audit
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/istopass")
    public int istopass(@RequestParam Boolean audit,@RequestParam int id){
        return decorateService.istopass(audit,id);
    }
}
