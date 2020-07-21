package com.xcxgf.zhihuiyuan.controller;


import com.xcxgf.zhihuiyuan.POJO.Enumeration;
import com.xcxgf.zhihuiyuan.POJO.PaymentInfo;
import com.xcxgf.zhihuiyuan.POJO.ReturnData;
import com.xcxgf.zhihuiyuan.POJO.SystemInfo;
import com.xcxgf.zhihuiyuan.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;


/**
 * @author 田易
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService ps;

    /**
     *查询表格数据
     * @param request request中包含3个参数，dataStart（返回数据的起始位置），dataEnd（返回数据的终止位置）
     * @return
     */
    @GetMapping("/getSearchList")
    public ReturnData getSearchList(HttpServletRequest request) {
        // 从request中获取各参数
        String startStr = request.getParameter("dataStart");
        String endStr = request.getParameter("dataEnd");
        String searchValue = request.getParameter("searchValue");
        String selectValue = request.getParameter("selectValue");
        int start = Integer.parseInt(startStr);
        int end = Integer.parseInt(endStr);
        // 拼接查询字符串，limit字符串
        String limit = "0".equals(startStr) && "0".equals(endStr) ? "" : "limit " + start + "," + end;

        return ps.getSearchList(searchValue,selectValue,limit);
    }

    /**
     * 得到折线图报表数据
     * @param request
     * @return
     */
    @GetMapping("/getReportList")
    public ReturnData getReportList(HttpServletRequest request){
        String reportState = request.getParameter("reportState");
        ReturnData returnData = new ReturnData();
        if(reportState.equals(Enumeration.years.getName())){
            returnData.setTimeList(ps.getYearsList());
            returnData.setWaterList(ps.getYearsWaterCostList());
            returnData.setElectricityList(ps.getYearsElectricityCostList());
        }else if(reportState.equals(Enumeration.quarter.getName())){
            returnData.setTimeList(ps.getQuarterList());
            returnData.setWaterList(ps.getQuarterWaterCostList());
            returnData.setElectricityList(ps.getQuarterElectricityCostList());
        }else if(reportState.equals(Enumeration.month.getName())){
            returnData.setTimeList(ps.getMonthList());
            returnData.setWaterList(ps.getMonthWaterCostList());
            returnData.setElectricityList(ps.getMonthElectricityCostList());
        }

        return returnData;
    }

    /**
     * 查询公司
     * @param request
     * @return
     */
    @GetMapping("/getEnterpriseNumber")
    public String getEnterpriseNumber(HttpServletRequest request){
        String building = request.getParameter("building");
        String room = request.getParameter("room");
        return ps.getEnterpriseNumber(building,room);
    }

    /**
     * 查询房间
     * @param request
     * @return
     */
    @GetMapping("/getRoomList")
    public List<Long> roomList(HttpServletRequest request){
        String building = request.getParameter("building");
        return ps.getRoomList(building);
    }

    /**
     * 查询楼栋
     * @return
     */
    @GetMapping("/getBuildingList")
    public List<String> builingList(){
       return ps.getBuilingList();
    }

    /**
     * 增加paymentInfo表格数据
     * @param paymentInfo
     * @return
     */
    @PostMapping("/insertPaymentData")
    public int insert(@RequestBody PaymentInfo paymentInfo) {
        float water,electricity;
        SystemInfo systemInfo= ps.getSystemInfo();
        water = systemInfo.getWaterUnitPrice();
        electricity = systemInfo.getElectricityUnitPrice();
        return ps.insert(paymentInfo,water,electricity);
    }

    /**
     * 导入Excel
     * @param paymentInfo
     * @return
     */
    @PostMapping("/insertPaymentDataExcel")
    public ReturnData insertExcel(@RequestBody List<PaymentInfo> paymentInfo) {
        int flag=0,i=0,j=0;
        int t;
        float water,electricity;
        ReturnData returnData = new ReturnData();
        List<PaymentInfo> addList = new ArrayList<>();
        List<PaymentInfo> updateList=new ArrayList<>();
        SystemInfo systemInfo= ps.getSystemInfo();
        water = systemInfo.getWaterUnitPrice();
        electricity = systemInfo.getElectricityUnitPrice();
        if (ps.tableIsNull()>=1){

            for (PaymentInfo pi:paymentInfo)
            {
                t = ps.insert(pi,water,electricity);
                i++;
                if (t==1){
                    if (i==paymentInfo.size()){
                        flag=1;
                        returnData.setExcelFlag(flag);
                    }
                }
                if(t==0){
                    j++;
                    if (i==paymentInfo.size()){
                        returnData.setErrorCount(j);
                    }
                }
            }
        }else {
            ps.batInfoAdd(paymentInfo);
        }

        return returnData;
    }

    /**
     * 判断系统设置是否有数据
     * @return
     */
    @GetMapping("/systemInfoIsNull")
    public int systemInfoIsNull(){
        return ps.systemInfoIsNull();
    }

    /**
     * 新增系统设置单价
     * @param systemInfo
     * @return
     */
    @PostMapping("/addSystemInfo")
    public int insertSystemInfo(@RequestBody SystemInfo systemInfo){
        return ps.insertSystemInfo(systemInfo);
    }

    /**
     * 查询系统设置单价
     * @return
     */
    @GetMapping("/getSystemInfoList")
    public List<SystemInfo> getSystemInfoList(){
        return ps.getSystemInfoList();
    }


    /**
     * 更新系统设置单价
     * @param systemInfo
     * @return
     */
    @PostMapping("/updateSystemInfo")
    public int updateSystemInfo(@RequestBody SystemInfo systemInfo) {
        return ps.updateSystemInfo(systemInfo);
    }

    /**
     *查询表格数据
     * @param request request中包含3个参数，dataStart（返回数据的起始位置），dataEnd（返回数据的终止位置）
     * @return
     */
    @GetMapping("/getPaymentList")
    public ReturnData getPaymentList(HttpServletRequest request) {
        // 从request中获取各参数
        String startStr = request.getParameter("dataStart");
        String endStr = request.getParameter("dataEnd");
        int start = Integer.parseInt(startStr);
        int end = Integer.parseInt(endStr);
        // 拼接查询字符串，limit字符串
        String limit = "0".equals(startStr) && "0".equals(endStr) ? "" : "limit " + start + "," + end;

        return ps.getPaymentList(limit);
    }
}
