package com.xcxgf.cainiao.POJO;

import java.util.List;

/**
 * 请求返回数据的封装类，主要封装查询的记录集合，以及记录总条数
 * @author zyz
 */
public class DataReturn {
    /**
     * 查询到的记录总条数
     */
    private int dataCount;
    /**
     * 楼栋记录集合，新增合同
     */
    private List<Building> buildingList;
    /**
     * 房间记录集合，新增合同
     */
    private List<Room> roomList;
    /**
     * 楼栋记录集合，合同缴费
     */
    private List<Building> payBuildingList;
    /**
     * 房间记录集合，合同缴费
     */
    private List<Room> payRoomList;
    /**
     * 园区企业记录集合
     */
    private List<Enterprise> enterpriseList;
    /**
     * 用户信息记录集合
     */
    private List<User> userList;
    /**
     * 租赁合同记录集合
     */
    private List<LeaseContract> leaseContractList;


    public List<Building> getPayBuildingList() {
        return payBuildingList;
    }

    public void setPayBuildingList(List<Building> payBuildingList) {
        this.payBuildingList = payBuildingList;
    }

    public List<Room> getPayRoomList() {
        return payRoomList;
    }

    public void setPayRoomList(List<Room> payRoomList) {
        this.payRoomList = payRoomList;
    }

    public List<LeaseContract> getLeaseContractList() {
        return leaseContractList;
    }

    public void setLeaseContractList(List<LeaseContract> leaseContractList) {
        this.leaseContractList = leaseContractList;
    }

    public List<Building> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<Building> buildingList) {
        this.buildingList = buildingList;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(List<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
