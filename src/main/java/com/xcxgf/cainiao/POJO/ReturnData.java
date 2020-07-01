package com.xcxgf.cainiao.POJO;

import java.util.List;
/**
 * @author 田易
 */
public class ReturnData {

    /**
     * 查询到的记录总条数
     */
    private int dataCount;

    /**
     * 水电读数集合
     */
    private List<PaymentInfo> paymentInfos;

    /**
     *诉求集合
     */
    private List<Appeal> appeals;

    /**
     * 错误条数
     */
    private int errorCount;

    /**
     * Excel状态
     */
    private int excelFlag;

    /**
     * 时间list
     */
    private List<Long> timeList;

    /**
     * 水list
     */
    private List<Float> waterList;

    /**
     * 电list
     */
    private List<Float> electricityList;
    public List<Long> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<Long> timeList) {
        this.timeList = timeList;
    }

    public List<Float> getWaterList() {
        return waterList;
    }

    public void setWaterList(List<Float> waterList) {
        this.waterList = waterList;
    }

    public List<Float> getElectricityList() {
        return electricityList;
    }

    public void setElectricityList(List<Float> electricityList) {
        this.electricityList = electricityList;
    }

    public List<Appeal> getAppeals() {
        return appeals;
    }

    public void setAppeals(List<Appeal> appeals) {
        this.appeals = appeals;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public int getExcelFlag() {
        return excelFlag;
    }

    public void setExcelFlag(int excelFlag) {
        this.excelFlag = excelFlag;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public List<PaymentInfo> getPaymentInfos() {
        return paymentInfos;
    }

    public void setPaymentInfos(List<PaymentInfo> paymentInfos) {
        this.paymentInfos = paymentInfos;
    }


}
