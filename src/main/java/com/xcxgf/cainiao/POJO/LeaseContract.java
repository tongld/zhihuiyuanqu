package com.xcxgf.cainiao.POJO;


/**
 * 合同登记实体类
 *
 * @author zyz
 */
public class LeaseContract {
    private int id;

    /**
     * 业主
     */
    private String owner;
    /**
     * 房号
     */
    private String roomNumber;
    /**
     * 所属楼栋名称
     */
    private String buildingName;
    /**
     * 合同保证金
     */
    private String depositOnContracts;
    /**
     * 租金单价
     */
    private String unitPrice;
    /**
     * 租期
     */
    private String rentPeriod;
    /**
     * 起租期
     */
    private String startRentTime;
    /**
     * 终止期
     */
    private String endRentTime;
    /**
     * 未缴费租期
     */
    private String noPayPeriod;
    /**
     * 租金总计
     */
    private String totalRent;
    /**
     * 首期租金
     */
    private String firstRent;
    /**
     * 添加时间
     */
    private String insertTime;
    /**
     * 修改时间
     */
    private String updateTime;
    /**
     * 上一次缴费结束租期
     */
    private String lastPayTime;

    /**
     * 第一年租金单价
     */
    private String firstYear_unitPrice;

    /**
     * 第一年管理单价
     */
    private String firstYear_managePrice;

    /**
     * 第一年能耗公摊单价
     */
    private String firstYear_energyPrice;

    /**
     * 第二年租金单价
     */
    private String secondYear_unitPrice;

    /**
     * 第二年管理单价
     */
    private String secondYear_managePrice;

    /**
     * 第二年能耗公摊单价
     */
    private String secondYear_energyPrice;

    /**
     * 第一年租金总计
     */
    private String firstYear_rentCost;

    /**
     * 第二年租金总计
     */
    private String secondYear_rentCost;

    /**
     * 合同租金总计
     */
    private String totalRentCost;

    /**
     * 退款
     */
    private String refund;

    private Boolean isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefund() {
        return refund;
    }

    public void setRefund(String refund) {
        this.refund = refund;
    }

    public String getFirstYear_unitPrice() {
        return firstYear_unitPrice;
    }

    public void setFirstYear_unitPrice(String firstYear_unitPrice) {
        this.firstYear_unitPrice = firstYear_unitPrice;
    }

    public String getFirstYear_managePrice() {
        return firstYear_managePrice;
    }

    public void setFirstYear_managePrice(String firstYear_managePrice) {
        this.firstYear_managePrice = firstYear_managePrice;
    }

    public String getFirstYear_energyPrice() {
        return firstYear_energyPrice;
    }

    public void setFirstYear_energyPrice(String firstYear_energyPrice) {
        this.firstYear_energyPrice = firstYear_energyPrice;
    }

    public String getSecondYear_unitPrice() {
        return secondYear_unitPrice;
    }

    public void setSecondYear_unitPrice(String secondYear_unitPrice) {
        this.secondYear_unitPrice = secondYear_unitPrice;
    }

    public String getSecondYear_managePrice() {
        return secondYear_managePrice;
    }

    public void setSecondYear_managePrice(String secondYear_managePrice) {
        this.secondYear_managePrice = secondYear_managePrice;
    }

    public String getSecondYear_energyPrice() {
        return secondYear_energyPrice;
    }

    public void setSecondYear_energyPrice(String secondYear_energyPrice) {
        this.secondYear_energyPrice = secondYear_energyPrice;
    }

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

    public String getTotalRentCost() {
        return totalRentCost;
    }

    public void setTotalRentCost(String totalRentCost) {
        this.totalRentCost = totalRentCost;
    }

    public String getLastPayTime() {
        return lastPayTime;
    }

    public void setLastPayTime(String lastPayTime) {
        this.lastPayTime = lastPayTime;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
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

    public String getDepositOnContracts() {
        return depositOnContracts;
    }

    public void setDepositOnContracts(String depositOnContracts) {
        this.depositOnContracts = depositOnContracts;
    }

    public String getRentPeriod() {
        return rentPeriod;
    }

    public void setRentPeriod(String rentPeriod) {
        this.rentPeriod = rentPeriod;
    }

    public String getStartRentTime() {
        return startRentTime;
    }

    public void setStartRentTime(String startRentTime) {
        this.startRentTime = startRentTime;
    }

    public String getEndRentTime() {
        return endRentTime;
    }

    public void setEndRentTime(String endRentTime) {
        this.endRentTime = endRentTime;
    }

    public String getNoPayPeriod() {
        return noPayPeriod;
    }

    public void setNoPayPeriod(String noPayPeriod) {
        this.noPayPeriod = noPayPeriod;
    }

    public String getTotalRent() {
        return totalRent;
    }

    public void setTotalRent(String totalRent) {
        this.totalRent = totalRent;
    }

    public String getFirstRent() {
        return firstRent;
    }

    public void setFirstRent(String firstRent) {
        this.firstRent = firstRent;
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

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

}
