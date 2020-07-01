package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.*;
import com.xcxgf.cainiao.services.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 租赁管理，前端后台交互层
 * @author zyz
 */
@RestController
@RequestMapping("lease")
public class LeaseController {

    @Autowired
    private LeaseService ls;


    /**
     * 合同总条数
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getContractCount")
    public int getContractCount(HttpServletRequest request){return ls.getContractCount(request);}

    @RequestMapping(method = RequestMethod.GET,value = "/getContractList")
    public List<LeaseContract> getContractList(HttpServletRequest request){return ls.getContractList(request);}
    /**
     * 获取符合查询条件的租赁信息数据
     *
     * @param request request中包含3个参数，search（查询内容），dataStart（返回数据的起始位置），dataEnd（返回数据的终止位置）
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getSearchList")
    public DataReturn getSearchList(HttpServletRequest request) {
        // 从request中获取各参数
        String search = request.getParameter("search");
        String start = request.getParameter("start");
        String count = request.getParameter("count");
        Boolean isDelete=false;
        if(request.getParameter("isDelete").equals("true")){
            isDelete=true;
        }
        return ls.getSearchList(search, start, count,isDelete);

    }


    /**
<<<<<<< HEAD
     * 删除记录
     *
     * @param leaseContract 需要被删除的数据
     * @return 删除结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/deleteLeaseList")
    public int deleteLeaseList(@RequestBody LeaseContract leaseContract) {
        return ls.deleteLeaseList(leaseContract);
    }

    /**
     * 插入合同记录
     *
     * @param leaseContract 需要插入的数据
     * @return 插入结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/insertLeaseList")
    public int insertLeaseList(@RequestBody LeaseContract leaseContract) {
        return ls.insertLeaseList(leaseContract);
    }


    /**
     * 查询所有办公楼数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getBuildingList")
    public List<Building> getBuildingList() {
        return ls.getBuildingList();
    }

    /**
     * 获取所有未租赁的办公室数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getEmptyRoomList")
    public List<Room> getEmptyRoomList() {
        return ls.getEmptyRoomList();
    }

    /**
     * 获取管理单价的数值
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getSettingList")
    public String getSettingList() {
        return ls.getSettingList();
    }

    /**
     * 获取能耗公摊单价的数值
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getEnergyPrice")
    public String getEnergyPrice() {
        return ls.getEnergyPrice();
    }

    /**
     * 插入缴费记录
     * @param leaseCost
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/insertLeaseCostInfo")
    public int insertLeaseCostInfo(@RequestBody LeaseCost leaseCost){
        return ls.insertLeaseCostInfo(leaseCost);
    }

    /**
     * 合同变更
     * @param leaseContract
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/changeLeaseContractInfo")
    public int changeLeaseContractInfo(@RequestBody LeaseContract leaseContract){
     return ls.changeLeaseContractInfo(leaseContract);
    }

    /**
     * 查询某合同的所有缴费记录
     * @param leaseContract
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getLeaseCostList")
    public List<LeaseCost> getLeaseCostList(@RequestBody LeaseContract leaseContract){
        return ls.getLeaseCostList(leaseContract);
    }


    /**
     * 查询某合同的租金单价
     * @param leaseCost
     * @return
<<<<<<< HEAD
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getPayUnitPrice")
    public String getPayUnitPrice(@RequestBody LeaseCost leaseCost){
        return ls.getPayUnitPrice(leaseCost);
    }

    /**
     * 查询某合同的所有缴费记录
     * @param leaseContract
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getOwnerInfo")
    public Enterprise getOwnerInfo(@RequestBody LeaseContract leaseContract){
        return ls.getOwnerInfo(leaseContract);
    }

}
