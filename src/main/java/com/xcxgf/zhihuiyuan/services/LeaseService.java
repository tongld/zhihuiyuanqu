package com.xcxgf.zhihuiyuan.services;

import com.xcxgf.zhihuiyuan.POJO.*;
import com.xcxgf.zhihuiyuan.mapper.LeaseMapper;
import com.xcxgf.zhihuiyuan.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 租赁管理，后端与数据库的逻辑处理层
 *
 * @author zyz
 */
@Service
public class LeaseService {
    @Autowired
    private LeaseMapper lm;

    @Autowired
    private RoomMapper rm;

    public int getContractCount(HttpServletRequest request){
        String name=request.getParameter("name");
        Boolean isDelete=false;
        if(request.getParameter("isDelete").equals("true")){
            isDelete=true;
        }
        return lm.getContractCount(name,isDelete);
    }

    public List<LeaseContract> getContractList(HttpServletRequest request){
        int pageSize=Integer.parseInt(request.getParameter("pageSize"));
        int startPage=(Integer.parseInt(request.getParameter("pageCurrent"))-1)*pageSize;
        String name=request.getParameter("name");
        Boolean isDelete=false;
        if(request.getParameter("isDelete").equals("true")){
            isDelete=true;
        }
        return lm.getContractList(startPage,pageSize,name,isDelete);
    }
    /**
     * 查询满足查询条件的记录
     *
     * @param search 查询内容:楼栋名称（模糊查询），房间名称（模糊查询），业主（模糊查询）
     * @param start  记录开始位置
     * @param count  需要返回的记录条数
     * @return
     */
    public DataReturn getSearchList(String search, String start, String count,Boolean isDelete) {
        // 拼接查询字符串，limit字符串
        String searchStr;
        if("".equals(search)){
            searchStr="";
            if(isDelete){
                searchStr=searchStr+"where isDelete=true";
            }
            else{
                searchStr=searchStr+"where isDelete=false";
            }
        }
        else {
            searchStr="where (buildingName like '%" + search + "%' or roomNumber like '%" + search + "%' or owner like '%" + search + "%')";
            if(isDelete){
                searchStr=searchStr+"and isDelete=true";
            }
            else{
                searchStr=searchStr+"and isDelete=false";
            }

        }
        String limitStr = "0".equals(start) && "0".equals(count) ? "" : "limit " + start + "," + count;

        // 数据包装
        DataReturn dataReturn = new DataReturn();
        // 设置合同记录数据
        dataReturn.setLeaseContractList(lm.getSearchList(searchStr, limitStr));
        // 设置记录总条数
        dataReturn.setDataCount(lm.getSearchCount(searchStr));
        // 设置新增合同的所属楼栋
        dataReturn.setBuildingList(lm.getBuildingList());
        // 设置新增合同的房间号
        dataReturn.setRoomList(lm.getEmptyRoomList());
        // 设置合同缴费的所属楼栋
        dataReturn.setPayBuildingList(lm.getPayBuildingList());
        // 设置合同缴费的房间号
        dataReturn.setPayRoomList(lm.getPayRoomList());
        return dataReturn;
    }

    /**
     * 删除记录
     *
     * @param leaseContract 需要被删除的记录对象
     * @return int类型，0为删除失败，1为删除成功,-1为未完成所有缴费
     */
    public int deleteLeaseList(LeaseContract leaseContract) {
        int reqCode = 0;
        // 已完成所有缴费
        String state = "0";
        // 1、查询该合同是否有缴费记录，有则删除合同记录以及更新房间状态，并且删除所有缴费记录
        if (lm.hasLeaseCost(leaseContract)<24) {
            // 删除了合同记录，以及更新房间业主，还需要删除所有缴费记录
            if (lm.deleteLeaseInfo(leaseContract) > 0 && lm.deleteRoomInfoOwner(leaseContract) > 0) {
                reqCode = 1;
                // 查询是否已该企业无合同存在，是，则修改企业的状态为【已注册】
                if (lm.insertSearchSame(leaseContract) == 0) {
                    lm.updateEnterpriseStateWhenDelete(leaseContract);
                }
            }
        } else {
            reqCode = -1;
        }

        return reqCode;
    }

    /**
     * 插入合同登记记录
     *
     * @param leaseContract 需要插入的记录对象
     * @return
     */
    public int insertLeaseList(LeaseContract leaseContract) {
        // 匹配日期格式
        leaseContract = leaseDataFormat(leaseContract);
        int reqCode = 0;
        // 1.判定公司是否已登记
        if (lm.searchEnterpriseRight(leaseContract) != 0) {
            // 2.插入合同记录，并更新房间业主
            if (lm.insertLeaseContractInfo(leaseContract) > 0 && lm.updateRoomInfoOwner(leaseContract) > 0) {
                reqCode = 1;
            }
            // 判断公司目前状态是否是【已入驻】，不是，则修改登记状态
            if (lm.isInsertFirstSearch(leaseContract) > 0) {
                lm.updateEnterpriseStateWhenInsert(leaseContract);
            }
        } else {
            reqCode = -1;
        }
        return reqCode;
    }

    /**
     * 日期格式化(合同)
     *
     * @param leaseContract
     * @return
     */
    public LeaseContract leaseDataFormat(LeaseContract leaseContract) {
        // 日期格式化的格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = dateFormat.parse(leaseContract.getStartRentTime());
            Date end = dateFormat.parse(leaseContract.getEndRentTime());
            leaseContract.setStartRentTime(dateFormat.format(start));
            leaseContract.setEndRentTime(dateFormat.format(end));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return leaseContract;
    }

    /**
     * 日期格式化（缴费）
     * @param leaseCost
     * @return
     */
    public LeaseCost leaseDataFormat(LeaseCost leaseCost) {
        // 日期格式化的格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = dateFormat.parse(leaseCost.getStartPayTime());
            Date end = dateFormat.parse(leaseCost.getEndPayTime());
            leaseCost.setStartPayTime(dateFormat.format(start));
            leaseCost.setEndPayTime(dateFormat.format(end));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return leaseCost;
    }

    /**
     * 查询所有办公楼
     *
     * @return
     */
    public List<Building> getBuildingList() {
        return lm.getBuildingList();
    }

    /**
     * 获取所有未租赁的可用记录
     *
     * @return Room类型的集合，所有未租赁的可用记录
     */
    public List<Room> getEmptyRoomList() {
        return lm.getEmptyRoomList();
    }


    /**
     * 获取管理单价
     *
     * @return Setting类型，所有可用数据
     */
    public String getSettingList() {
        return lm.getSettingList();
    }

    /**
     * 获取管理单价
     *
     * @return Setting类型，所有可用数据
     */
    public String getEnergyPrice() {
        return lm.getEnergyPrice();
    }

    /**
     * 插入缴费记录
     *
     * @param leaseCost
     * @return
     */
    public int insertLeaseCostInfo(LeaseCost leaseCost) {
        leaseCost = leaseDataFormat(leaseCost);
        int reqCode = 0;
        // 1、查询缴费租期是否大于未缴费租期，是，则返回-1
        // 2、查询是否已有过往记录存在，否，则先更新合同中的【首租租金】

        // 3、插入新纪录，并更新合同中的【未缴费租期】，合同的【上一次缴费终止租】
        if (lm.searchTimeRight(leaseCost) != 0) {
            if (lm.searchLeaseCostSame(leaseCost) == 0) {
                // 更新合同中的【首租租金】
                // lm.updateRentPriceFirst(leaseCost);
            }
            if (lm.insertLeaseCostInfo(leaseCost) > 0) {
                // 更新合同中的【未缴费租期】，合同的【上一次缴费终止租】
                lm.updateNoPayPeriod(leaseCost);
                lm.updateLastPayTime(leaseCost);
                reqCode = 1;
            }
        } else {
            reqCode = -1;
        }

        return reqCode;
    }

    /**
     * 合同变更
     *
     * @param leaseContract
     * @return -1，变更公司未注册，0，未变更成功，1变更成功
     */
    public int changeLeaseContractInfo(LeaseContract leaseContract) {
        int reqCode = 0;
        // 1、判断是否公司已注册
        if (lm.searchEnterpriseRight(leaseContract) != 0) {

            //2、查询是否，合同原所属人已无合同记录,是，则修改合同原所属人的状态为【已注册】
            if (lm.hasLeaseContract(leaseContract) == 1) {
                lm.updateOldState(leaseContract);
            }
            //3、查询是否，合同变更对象为未入驻状态，是则修改登记状态【已入驻】
            if (lm.isInsertFirstSearch(leaseContract) > 0) {
                lm.updateEnterpriseStateWhenInsert(leaseContract);
            }
            //4、更改合同的所属人，以及更新所有缴费记录的【业主变更】，更新房间号
            if (lm.updateContractOwner(leaseContract) > 0 && lm.updateLeaseCostInfo(leaseContract) >= 0 && lm.updateRoomInfoOwner(leaseContract) > 0) {
                reqCode = 1;
            }

        } else {
            reqCode = -1;
        }
        return reqCode;
    }

    /**
     * 查询某合同的所有缴费记录
     *
     * @param leaseContract
     * @return
     */
    public List<LeaseCost> getLeaseCostList(LeaseContract leaseContract) {
        return lm.getLeaseCostList(leaseContract);
    }

    /**
     * 查询某合同的租金单价
     *
     * @param leaseCost
     * @return
     */
    public String getPayUnitPrice(LeaseCost leaseCost) {
        return lm.getPayUnitPrice(leaseCost);
    }


    /**
     * 查询合同联系人的信息
     * @param leaseContract
     * @return
     */
    public Enterprise getOwnerInfo(LeaseContract leaseContract){
        return lm.getOwnerInfo(leaseContract);
    }

}
