package com.xcxgf.zhihuiyuan.POJO;

/**
 * @author 田易
 */
public class PaymentInfo {

    /**
     * id
     */
    private int id;

    /**
     * 楼栋名
     */
    private String buildingName;

    /**
     * 房号
     */
    private String roomNumber;
    /**
     * 公司
     */
    private String owner;

    /**
     * 水表读数
     */
    private float waterNumber;

    /**
     * 电表读数
     */
    private float electricityNumber;

    /**
     * 上期水表读数
     */
    private float waterNumberPrevious;

    /**
     * 上期电表读数
     */
    private float electricityNumberPrevious;

    /**
     * 水差值
     */
    private float waterDifference;

    /**
     * 电差值
     */
    private float electricityDifference;

    /**
     * 水费
     */
    private float waterCost;

    /**
     * 电费
     */
    private float electricityCost;

    /**
     * 总金额
     */
    private float total;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 创建时间
     */
    private String establishTime;

    /**
     * 更新时间
     */
    private String updateTime;
    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public float getWaterNumber() {
        return waterNumber;
    }

    public void setWaterNumber(float waterNumber) {
        this.waterNumber = waterNumber;
    }

    public float getElectricityNumber() {
        return electricityNumber;
    }

    public void setElectricityNumber(float electricityNumber) {
        this.electricityNumber = electricityNumber;
    }

    public float getWaterNumberPrevious() {
        return waterNumberPrevious;
    }

    public void setWaterNumberPrevious(float waterNumberPrevious) {
        this.waterNumberPrevious = waterNumberPrevious;
    }

    public float getElectricityNumberPrevious() {
        return electricityNumberPrevious;
    }

    public void setElectricityNumberPrevious(float electricityNumberPrevious) {
        this.electricityNumberPrevious = electricityNumberPrevious;
    }

    public float getWaterDifference() {
        return waterDifference;
    }

    public void setWaterDifference(float waterDifference) {
        this.waterDifference = waterDifference;
    }

    public float getElectricityDifference() {
        return electricityDifference;
    }

    public void setElectricityDifference(float electricityDifference) {
        this.electricityDifference = electricityDifference;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }


    public String getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(String establishTime) {
        this.establishTime = establishTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public float getWaterCost() {
        return waterCost;
    }

    public void setWaterCost(float waterCost) {
        this.waterCost = waterCost;
    }

    public float getElectricityCost() {
        return electricityCost;
    }

    public void setElectricityCost(float electricityCost) {
        this.electricityCost = electricityCost;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
