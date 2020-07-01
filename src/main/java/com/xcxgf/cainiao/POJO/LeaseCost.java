package com.xcxgf.cainiao.POJO;

/**
 * 租赁缴费的实体类
 *
 * @author zyz
 */
public class LeaseCost {
    /**
     * 业主
     */
    private String owner;
    /**
     * 房间号
     */
    private String roomNumber;
    /**
     * 所属楼栋名称
     */
    private String buildingName;
    /**
     * 租金单价
     */
    private String unitPrice;
    /**
     * 租期周期
     */
    private String period;
    /**
     * 租期应付总额
     */
    private String rentCost;
    /**
     * 租期应付物业费
     */
    private String propertyFee;
    /**
     * 能耗公摊
     */
    private String energySharing;
    /**
     * 租费合计
     */
    private String totalCost;
    /**
     * 变更业主
     */
    private String isChangeOwner;
    /**
     * 添加时间
     */
    private String insertTime;
    /**
     * 修改时间
     */
    private String updateTime;
    /**
     * 缴费起始租期
     */
    private String startPayTime;
    /**
     * 缴费终止租期
     */
    private String endPayTime;
    /**
     * 第一年缴费租金
     */
    private String firstYear_rentCost;

    /**
     * 第二年缴费租金
     */
    private String secondYear_rentCost;

    public String getFirstYear_rentCost() {
        return firstYear_rentCost;
    }

    public void setFirstYear_rentCost(String firstYear_rentCost) {
        this.firstYear_rentCost = firstYear_rentCost;
    }

    public String getSecondYear_rentCost() {
        return secondYear_rentCost;
    }

    public void setSecondYear_rentCost(String secondYear_rentCost) {
        this.secondYear_rentCost = secondYear_rentCost;
    }

    public String getStartPayTime() {
        return startPayTime;
    }

    public void setStartPayTime(String startPayTime) {
        this.startPayTime = startPayTime;
    }

    public String getEndPayTime() {
        return endPayTime;
    }

    public void setEndPayTime(String endPayTime) {
        this.endPayTime = endPayTime;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getRentCost() {
        return rentCost;
    }

    public void setRentCost(String rentCost) {
        this.rentCost = rentCost;
    }

    public String getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(String propertyFee) {
        this.propertyFee = propertyFee;
    }

    public String getEnergySharing() {
        return energySharing;
    }

    public void setEnergySharing(String energySharing) {
        this.energySharing = energySharing;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getIsChangeOwner() {
        return isChangeOwner;
    }

    public void setIsChangeOwner(String isChangeOwner) {
        this.isChangeOwner = isChangeOwner;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
