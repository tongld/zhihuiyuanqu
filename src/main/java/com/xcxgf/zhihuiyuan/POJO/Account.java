package com.xcxgf.zhihuiyuan.POJO;

public class Account {
    private int id;
    private String contractId;
    private String buildingName;
    private String owner;
    private String roomNumber;
    private int rentPeriod;
    private String startRentTime;
    private String endRentTime;
    private float totalCost;
    private int totalPeriod;
    private String insertTime;
    private String updateTime;
    private Boolean isDelete;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
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

    public int getRentPeriod() {
        return rentPeriod;
    }

    public void setRentPeriod(int rentPeriod) {
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

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public int getTotalPeriod() {
        return totalPeriod;
    }

    public void setTotalPeriod(int totalPeriod) {
        this.totalPeriod = totalPeriod;

    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
