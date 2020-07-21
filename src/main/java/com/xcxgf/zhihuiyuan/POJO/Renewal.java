package com.xcxgf.zhihuiyuan.POJO;

public class Renewal {
    private int id;
    private String owner;
    private String contractId;
    private String contractType;
    private String continueStartTime;
    private String continueEndTime;
    private int continuePeriod;
    private float totalCost;
    private String insertTime;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getContinueStartTime() {
        return continueStartTime;
    }

    public void setContinueStartTime(String continueStartTime) {
        this.continueStartTime = continueStartTime;
    }

    public String getContinueEndTime() {
        return continueEndTime;
    }

    public void setContinueEndTime(String continueEndTime) {
        this.continueEndTime = continueEndTime;
    }

    public int getContinuePeriod() {
        return continuePeriod;
    }

    public void setContinuePeriod(int continuePeriod) {
        this.continuePeriod = continuePeriod;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }


    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }
}
