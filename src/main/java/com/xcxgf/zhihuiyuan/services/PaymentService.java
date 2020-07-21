package com.xcxgf.zhihuiyuan.services;




import com.xcxgf.zhihuiyuan.POJO.Enumeration;
import com.xcxgf.zhihuiyuan.POJO.PaymentInfo;
import com.xcxgf.zhihuiyuan.POJO.ReturnData;
import com.xcxgf.zhihuiyuan.POJO.SystemInfo;
import com.xcxgf.zhihuiyuan.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;


/**
 * @author 田易
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    /**
     * 得到指定数据
     * @param searchValue
     * @param selectValue
     * @param limit
     * @return
     */
    public ReturnData getSearchList(String searchValue,String selectValue,String limit){
        ReturnData dataReturn = new ReturnData();
        try {

            if (selectValue.equals(Enumeration.search.getName())){
                dataReturn.setPaymentInfos(paymentMapper.getSearchRoomNumberList(searchValue,limit));
                dataReturn.setDataCount(paymentMapper.getSearchRoomCount(searchValue));
            }else {
                dataReturn.setPaymentInfos(paymentMapper.getSearchBuildingNameList(searchValue,limit));
                dataReturn.setDataCount(paymentMapper.getSearchOwnerCount(searchValue));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataReturn;
    }

    /**
     * 批量导入excel
     * @param paymentInfo
     */
    public void batInfoAdd(List<PaymentInfo> paymentInfo){
        //单价
        float waterUnitPrice = 1,electricityUnitPrice = 1;
        List<PaymentInfo> list =new ArrayList<>();
        //得到单价
        for(SystemInfo si: paymentMapper.getSystemInfoList()){
            waterUnitPrice= si.getWaterUnitPrice();
            electricityUnitPrice = si.getElectricityUnitPrice();
        }
        for (PaymentInfo pi : paymentInfo){
            pi.setWaterCost(Math.abs(pi.getWaterNumber()*waterUnitPrice));
            pi.setElectricityCost(Math.abs(pi.getElectricityNumber()*electricityUnitPrice));
            pi.setWaterNumberPrevious(pi.getWaterNumber());
            pi.setWaterDifference(pi.getWaterNumber());
            pi.setElectricityNumberPrevious(pi.getElectricityNumber());
            pi.setElectricityDifference(pi.getElectricityNumber());
            pi.setTotal(pi.getWaterCost()+pi.getElectricityCost());
            list.add(pi);
        }
        paymentMapper.batInfoAdd(list);
    }

    /**
     * 获取系统设置
     * @return
     */
    public SystemInfo getSystemInfo(){
        //获取系统设置中的水电单价
        List<SystemInfo> systemInfoList = paymentMapper.getSystemInfoList();
        SystemInfo systemInfo = new SystemInfo();
        //得到单价
        for(SystemInfo si: systemInfoList){
            systemInfo.setWaterUnitPrice(si.getWaterUnitPrice());
            systemInfo.setElectricityUnitPrice(si.getElectricityUnitPrice());
        }
        return systemInfo;
    }

    /**
     * 新增表数据的判断逻辑
     * @param paymentInfo
     * @param startTime
     * @param endTime
     * @param waterUnitPrice
     * @param electricityUnitPrice
     * @return
     */
    public int timeSetting(PaymentInfo paymentInfo,String startTime,String endTime,float waterUnitPrice,float electricityUnitPrice){
        //状态
        int flagTwo = 0;
        int id;
        //设置开始时间
        paymentInfo.setStartTime(startTime);
        //设置结束时间
        paymentInfo.setEndTime(endTime);
        //费用
        float waterCost = 0,electricityCost = 0;
        PaymentInfo pi;

        String flag = paymentMapper.repeatData(paymentInfo);


        //不存在的数据执行插入
        if ( flag == null) {
            try {
                //计算
                waterCost = paymentInfo.getWaterNumber() * waterUnitPrice;
                electricityCost = paymentInfo.getElectricityNumber() * electricityUnitPrice;
                //存入实体类
                paymentInfo.setWaterCost(waterCost);
                paymentInfo.setWaterNumberPrevious(paymentInfo.getWaterNumber());
                paymentInfo.setWaterDifference(paymentInfo.getWaterNumber());
                paymentInfo.setElectricityCost(electricityCost);
                paymentInfo.setElectricityNumberPrevious(paymentInfo.getElectricityNumber());
                paymentInfo.setElectricityDifference(paymentInfo.getElectricityNumber());
                paymentInfo.setTotal(waterCost+electricityCost);
                //执行mysql插入语句
                paymentMapper.insertPaymentInfo(paymentInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            flagTwo=1;
        }
        //存在执行更新
        else if(flag.equals(Enumeration.flags.getName())){
            //获取到id
            id = paymentMapper.selectPaymentInfoId(paymentInfo);
            //查出水电读数
            PaymentInfo info = paymentMapper.selectPaymentInfo(id);
            //判断导入数据是否大于原数据
            if(info.getWaterNumber()<paymentInfo.getWaterNumber() && info.getElectricityNumber()<paymentInfo.getElectricityNumber()){
                //数据暂存
                pi = paymentInfo;
                //设置id
                pi.setId(id);
                //将查出来的水电读数设置为上期水电数据
                pi.setWaterNumberPrevious(info.getWaterNumber());
                pi.setElectricityNumberPrevious(info.getElectricityNumber());
                //设置差值
                pi.setWaterDifference(Math.abs(paymentInfo.getWaterNumber()-pi.getWaterNumberPrevious()));
                pi.setElectricityDifference(Math.abs(paymentInfo.getElectricityNumber()-pi.getElectricityNumberPrevious()));
                //设置单个金额
                pi.setWaterCost(pi.getWaterDifference() * waterUnitPrice);
                pi.setElectricityCost(pi.getElectricityDifference() * electricityUnitPrice);
                //设置总金额
                pi.setTotal(pi.getWaterCost()+pi.getElectricityCost());
                //更新
                paymentMapper.updataPaymentInfo(pi);
                flagTwo=1;
            }else {
                flagTwo = 0;
            }
        }
        return flagTwo;
    }

    /**
     * 新增系统设置单价
     * @param systemInfo
     * @return
     */
    public int insertSystemInfo(SystemInfo systemInfo){
        return paymentMapper.insertSystemInfo(systemInfo);
    }

    /**
     * 查询公司
     * @param building
     * @param room
     * @return
     */
    public String getEnterpriseNumber(String building,String room){
        return paymentMapper.getEnterpriseNumber(building,room);
    }

    /**
     * 查询所有楼栋
     * @return
     */
    public List<String> getBuilingList(){
        return paymentMapper.getBuildingList();
    }

    /**
     * 查询所属楼栋的未使用的房号
     * @param building
     * @return
     */
    public List<Long> getBuildingRoomList(String building){
        return paymentMapper.getBuildingRoomList(building);
    }

    /**
     * 查询水电表已存在的房号
     * @param building
     * @return
     */
    public List<Long> getPaymentinfoRoomList(String building){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
        return paymentMapper.getPaymentinfoRoomList(building,df.format(new Date()));
    }

    /**
     * 查询去重的房号
     * @param building
     * @return
     */
    public List<Long> getRoomList(String building){
        List list1 =getBuildingRoomList(building);
        List list2 =getPaymentinfoRoomList(building);
        return PaymentUtil.removeAll(list1,list2);
    }

    /**
     * 新增paymentInfo表数据
     * @param paymentInfo
     * @param waterUnitPrice
     * @param electricityUnitPrice
     * @return
     */
    public int insert(PaymentInfo paymentInfo,float waterUnitPrice,float electricityUnitPrice){
        int flagTwo = 0 ,length=10;
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String start = paymentInfo.getStartTime();
        String end = paymentInfo.getEndTime();
        String startTime = null;
        String endTime = null;

        try {
            if (start.length()>=length && end.length()>=length){
                startTime=PaymentUtil.subDay(df.format(df.parse(start)));
                endTime=PaymentUtil.subDay(df.format(df.parse(end)));
                flagTwo = timeSetting(paymentInfo,startTime,endTime,waterUnitPrice,electricityUnitPrice);
            }
            if (start.length()<length && end.length()<length){
                startTime=PaymentUtil.formatDate(start);
                endTime=PaymentUtil.formatDate(end);
                flagTwo = timeSetting(paymentInfo,startTime,endTime,waterUnitPrice,electricityUnitPrice);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flagTwo;
    }

    /**
     * 得到paymentInfo表数据
     * @param limit
     * @return
     */
    public ReturnData getPaymentList(String limit){
        ReturnData dataReturn = new ReturnData();
        try {
            dataReturn.setDataCount(paymentMapper.getCount());
            dataReturn.setPaymentInfos(paymentMapper.getPaymentList(limit));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataReturn;
    }

    /**
     * 判断系统设置中是否有数据
     * @return
     */
    public int systemInfoIsNull(){return paymentMapper.systemInfoIsNull();}

    /**
     * 得到系统单价数据
     * @return
     */
    public List<SystemInfo> getSystemInfoList(){
        return paymentMapper.getSystemInfoList();
    }

    /**
     * 更新系统单价数据
     * @param systemInfo
     * @return
     */
    public int updateSystemInfo(SystemInfo systemInfo){
        return paymentMapper.updateSystemInfo(systemInfo);
    }

    /**
     * 得到所有年份
     * @return
     */
    public List<Long> getYearsList(){
        return paymentMapper.getYearsList();
    }

    /**
     *得到年份水费数据
     * @return
     */
    public List<Float> getYearsWaterCostList(){
        return paymentMapper.getYearsWaterCostList();
    }

    /**
     * 得到年份电费数据
     * @return
     */
    public List<Float> getYearsElectricityCostList(){
        return paymentMapper.getYearsElectricityCostList();
    }

    /**
     * 得到本年月份
     * @return
     */
    public List<Long> getMonthList(){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        return paymentMapper.getMonthList(df.format(new Date()));
    }

    /**
     * 得到本年月份水费数据
     * @return
     */
    public List<Float> getMonthWaterCostList(){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        return paymentMapper.getMonthWaterCostList(df.format(new Date()));
    }

    /**
     * 得到本年月份电费数据
     * @return
     */
    public List<Float> getMonthElectricityCostList(){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        return paymentMapper.getMonthElectricityCostList(df.format(new Date()));
    }

    /**
     * 得到本年季度
     * @return
     */
    public List<Long> getQuarterList(){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        return paymentMapper.getQuarterList(df.format(new Date()));
    }

    /**
     * 得到本年季度月份水费数据
     * @return
     */
    public List<Float> getQuarterWaterCostList(){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        return paymentMapper.getQuarterWaterCostList(df.format(new Date()));
    }

    /**
     * 得到本年季度月份电费数据
     * @return
     */
    public List<Float> getQuarterElectricityCostList(){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        return paymentMapper.getQuarterElectricityCostList(df.format(new Date()));
    }

    /**
     * 判断paymentinfo表是否为空
     * @return
     */
    public int tableIsNull(){
        return  paymentMapper.tableIsNull();
    }
}

/**
 * 工具类
 */
class PaymentUtil{
    /**
     * 时间类型转换
     * @param inDate
     * @return
     */
    public static String formatDate(String inDate) {
        SimpleDateFormat in = new SimpleDateFormat("mm/dd/yy");
        SimpleDateFormat out = new SimpleDateFormat("yyyy-mm-dd");
        String outDate = "";
        if (inDate != null) {
            try {
                Date date = in.parse(inDate);
                outDate = out.format(date);
            } catch (ParseException ex){
            }
        }
        return outDate;
    }

    /**
     * 时间天数加一天处理
     * @param date
     * @return
     * @throws ParseException
     */
    public static String subDay(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.DAY_OF_MONTH, 1);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        return reStr;
    }

    /**
     * 时间月份减一个月
     * @param date
     * @return
     * @throws ParseException
     */
    public static String subMonth(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, -1);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        return reStr;
    }

    /**
     * list集合去重 返回的是list1
     * @param list1
     * @param list2
     * @return
     */
    public static List<String> removeAll(List<String> list1,List<String> list2){
        LinkedList<String> result = new LinkedList<>(list1);
        HashSet<String> set = new HashSet<>(list2);
        Iterator<String> itor = result.iterator();
        while(itor.hasNext()){
            if(set.contains(itor.next())){
                itor.remove();
            }
        }
        return result;
    }

}

