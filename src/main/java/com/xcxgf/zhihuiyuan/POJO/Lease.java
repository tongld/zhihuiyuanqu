package com.xcxgf.zhihuiyuan.POJO;

/**
 * 租赁信息的实体类
 */
public class Lease {
    private int id; // id标识
    private String owner; // 业主
    private String roomNumber; // 办公室房号
    private String buildingName; // 所属办公楼名称
    private String depositOnContracts; // 合同保证金
    private String rentPeriod; // 租期
    private String startRentTime; // 起租期
    private String endRentTime; // 终止期
    private String unitPrice1; // 首期租金单价
    private String period1; // 首期租期周期
    private String rentCost1; // 首期租期应付总额
    private String propertyFee1; // 首期租期应付物业费
    private String energySharing1; // 首期能耗公摊
    private String totalCost1; // 首期租费合计
    private String unitPrice2; // 第2期租金单价
    private String period2; // 第2期租期周期
    private String rentCost2; // 第2期租期应付总额
    private String propertyFee2; // 第2期租期应付物业费
    private String energySharing2; // 第2期能耗公摊
    private String totalCost2; // 第2期租费合计
    private String unitPrice3; // 第3期租金单价
    private String period3; // 第3期租期周期
    private String rentCost3; // 第3期租期应付总额
    private String propertyFee3; // 第3期租期应付物业费
    private String energySharing3; // 第3期能耗公摊
    private String totalCost3; // 第3期租费合计
    private String unitPrice4; // 第4期租金单价
    private String period4; // 第4期租期周期
    private String rentCost4; // 第4期租期应付总额
    private String propertyFee4; // 第4期租期应付物业费
    private String energySharing4; // 第4期能耗公摊
    private String totalCost4; // 第4期租费合计
    private String unitPrice5; // 第5期租金单价
    private String period5; // 第5期租期周期
    private String rentCost5; // 第5期租期应付总额
    private String propertyFee5; // 第5期租期应付物业费
    private String energySharing5; // 第5期能耗公摊
    private String totalCost5; // 第5期租费合计
    private String unitPrice6; // 第6期租金单价
    private String period6; // 第6期租期周期
    private String rentCost6; // 第6期租期应付总额
    private String propertyFee6; // 第6期租期应付物业费
    private String energySharing6; // 第6期能耗公摊
    private String totalCost6; // 第6期租费合计
    private String isPayBond; // 保证金是否支付
    private String isPayFirst; // 首年租金是否支付
    private String isPaySecond; // 第二年租金是否支付
    private String rentCount; // 出租单元数
    private String yearTurnoverRange; // 年成交额区间
    private String dayAverageRange; // 日均单量区间
    private String register; // 注册
    private String rentNumber; // 租期期数标识，仅用于前后端交互，不存入数据库
    private String insertTime; // 添加时间
    private String updateTime; // 修改时间

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

    public String getUnitPrice1() {
        return unitPrice1;
    }

    public void setUnitPrice1(String unitPrice1) {
        this.unitPrice1 = unitPrice1;
    }

    public String getPeriod1() {
        return period1;
    }

    public void setPeriod1(String period1) {
        this.period1 = period1;
    }

    public String getRentCost1() {
        return rentCost1;
    }

    public void setRentCost1(String rentCost1) {
        this.rentCost1 = rentCost1;
    }

    public String getPropertyFee1() {
        return propertyFee1;
    }

    public void setPropertyFee1(String propertyFee1) {
        this.propertyFee1 = propertyFee1;
    }

    public String getEnergySharing1() {
        return energySharing1;
    }

    public void setEnergySharing1(String energySharing1) {
        this.energySharing1 = energySharing1;
    }

    public String getTotalCost1() {
        return totalCost1;
    }

    public void setTotalCost1(String totalCost1) {
        this.totalCost1 = totalCost1;
    }

    public String getUnitPrice2() {
        return unitPrice2;
    }

    public void setUnitPrice2(String unitPrice2) {
        this.unitPrice2 = unitPrice2;
    }

    public String getPeriod2() {
        return period2;
    }

    public void setPeriod2(String period2) {
        this.period2 = period2;
    }

    public String getRentCost2() {
        return rentCost2;
    }

    public void setRentCost2(String rentCost2) {
        this.rentCost2 = rentCost2;
    }

    public String getPropertyFee2() {
        return propertyFee2;
    }

    public void setPropertyFee2(String propertyFee2) {
        this.propertyFee2 = propertyFee2;
    }

    public String getEnergySharing2() {
        return energySharing2;
    }

    public void setEnergySharing2(String energySharing2) {
        this.energySharing2 = energySharing2;
    }

    public String getTotalCost2() {
        return totalCost2;
    }

    public void setTotalCost2(String totalCost2) {
        this.totalCost2 = totalCost2;
    }

    public String getUnitPrice3() {
        return unitPrice3;
    }

    public void setUnitPrice3(String unitPrice3) {
        this.unitPrice3 = unitPrice3;
    }

    public String getPeriod3() {
        return period3;
    }

    public void setPeriod3(String period3) {
        this.period3 = period3;
    }

    public String getRentCost3() {
        return rentCost3;
    }

    public void setRentCost3(String rentCost3) {
        this.rentCost3 = rentCost3;
    }

    public String getPropertyFee3() {
        return propertyFee3;
    }

    public void setPropertyFee3(String propertyFee3) {
        this.propertyFee3 = propertyFee3;
    }

    public String getEnergySharing3() {
        return energySharing3;
    }

    public void setEnergySharing3(String energySharing3) {
        this.energySharing3 = energySharing3;
    }

    public String getTotalCost3() {
        return totalCost3;
    }

    public void setTotalCost3(String totalCost3) {
        this.totalCost3 = totalCost3;
    }

    public String getUnitPrice4() {
        return unitPrice4;
    }

    public void setUnitPrice4(String unitPrice4) {
        this.unitPrice4 = unitPrice4;
    }

    public String getPeriod4() {
        return period4;
    }

    public void setPeriod4(String period4) {
        this.period4 = period4;
    }

    public String getRentCost4() {
        return rentCost4;
    }

    public void setRentCost4(String rentCost4) {
        this.rentCost4 = rentCost4;
    }

    public String getPropertyFee4() {
        return propertyFee4;
    }

    public void setPropertyFee4(String propertyFee4) {
        this.propertyFee4 = propertyFee4;
    }

    public String getEnergySharing4() {
        return energySharing4;
    }

    public void setEnergySharing4(String energySharing4) {
        this.energySharing4 = energySharing4;
    }

    public String getTotalCost4() {
        return totalCost4;
    }

    public void setTotalCost4(String totalCost4) {
        this.totalCost4 = totalCost4;
    }

    public String getUnitPrice5() {
        return unitPrice5;
    }

    public void setUnitPrice5(String unitPrice5) {
        this.unitPrice5 = unitPrice5;
    }

    public String getPeriod5() {
        return period5;
    }

    public void setPeriod5(String period5) {
        this.period5 = period5;
    }

    public String getRentCost5() {
        return rentCost5;
    }

    public void setRentCost5(String rentCost5) {
        this.rentCost5 = rentCost5;
    }

    public String getPropertyFee5() {
        return propertyFee5;
    }

    public void setPropertyFee5(String propertyFee5) {
        this.propertyFee5 = propertyFee5;
    }

    public String getEnergySharing5() {
        return energySharing5;
    }

    public void setEnergySharing5(String energySharing5) {
        this.energySharing5 = energySharing5;
    }

    public String getTotalCost5() {
        return totalCost5;
    }

    public void setTotalCost5(String totalCost5) {
        this.totalCost5 = totalCost5;
    }

    public String getUnitPrice6() {
        return unitPrice6;
    }

    public void setUnitPrice6(String unitPrice6) {
        this.unitPrice6 = unitPrice6;
    }

    public String getPeriod6() {
        return period6;
    }

    public void setPeriod6(String period6) {
        this.period6 = period6;
    }

    public String getRentCost6() {
        return rentCost6;
    }

    public void setRentCost6(String rentCost6) {
        this.rentCost6 = rentCost6;
    }

    public String getPropertyFee6() {
        return propertyFee6;
    }

    public void setPropertyFee6(String propertyFee6) {
        this.propertyFee6 = propertyFee6;
    }

    public String getEnergySharing6() {
        return energySharing6;
    }

    public void setEnergySharing6(String energySharing6) {
        this.energySharing6 = energySharing6;
    }

    public String getTotalCost6() {
        return totalCost6;
    }

    public void setTotalCost6(String totalCost6) {
        this.totalCost6 = totalCost6;
    }

    public String getIsPayBond() {
        return isPayBond;
    }

    public void setIsPayBond(String isPayBond) {
        this.isPayBond = isPayBond;
    }

    public String getIsPayFirst() {
        return isPayFirst;
    }

    public void setIsPayFirst(String isPayFirst) {
        this.isPayFirst = isPayFirst;
    }

    public String getIsPaySecond() {
        return isPaySecond;
    }

    public void setIsPaySecond(String isPaySecond) {
        this.isPaySecond = isPaySecond;
    }

    public String getRentCount() {
        return rentCount;
    }

    public void setRentCount(String rentCount) {
        this.rentCount = rentCount;
    }

    public String getYearTurnoverRange() {
        return yearTurnoverRange;
    }

    public void setYearTurnoverRange(String yearTurnoverRange) {
        this.yearTurnoverRange = yearTurnoverRange;
    }

    public String getDayAverageRange() {
        return dayAverageRange;
    }

    public void setDayAverageRange(String dayAverageRange) {
        this.dayAverageRange = dayAverageRange;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getRentNumber() {
        return rentNumber;
    }

    public void setRentNumber(String rentNumber) {
        this.rentNumber = rentNumber;
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
