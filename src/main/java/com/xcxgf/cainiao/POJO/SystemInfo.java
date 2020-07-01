package com.xcxgf.cainiao.POJO;

/**
 * @author 田易
 */
public class SystemInfo {
    private int id;

    /**
     * 水单价
     */
    private float waterUnitPrice;

    /**
     * 电单价
     */
    private float electricityUnitPrice;

    /**
     * 管理单价
     */
    private float leaseUnitPrice;

    /**
     * 能耗公摊单价
     */
    private float energySharingPrice;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getWaterUnitPrice() {
        return waterUnitPrice;
    }

    public void setWaterUnitPrice(float waterUnitPrice) {
        this.waterUnitPrice = waterUnitPrice;
    }

    public float getElectricityUnitPrice() {
        return electricityUnitPrice;
    }

    public void setElectricityUnitPrice(float electricityUnitPrice) {
        this.electricityUnitPrice = electricityUnitPrice;
    }

    public float getLeaseUnitPrice() {
        return leaseUnitPrice;
    }

    public void setLeaseUnitPrice(float leaseUnitPrice) {
        this.leaseUnitPrice = leaseUnitPrice;
    }

    public float getEnergySharingPrice() {
        return energySharingPrice;
    }

    public void setEnergySharingPrice(float energySharingPrice) {
        this.energySharingPrice = energySharingPrice;
    }


}
