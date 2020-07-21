package com.xcxgf.zhihuiyuan.POJO;

/**
 * 园区各楼栋房间的实体类
 *
 * @author zyz
 */
public class Room {
    /**
     * 所属办公楼
     */
    private String buildingName;
    /**
     * 房间号
     */
    private String roomNumber;
    /**
     * 临时房间号
     * 用于修改房间号时，记录旧的房间号
     */
    private String tempRoomNumber;
    /**
     * 业主
     */
    private String owner;
    /**
     * 计租面积
     */
    private String rentArea;
    /**
     * 建筑面积
     */
    private String buildingArea;
    /**
     * 房间类型
     */
    private String roomType;
    /**
     * 添加时间
     */
    private String insertTime;
    /**
     * 修改时间
     */
    private String updateTime;


    /**
     * 备注
     */
    private String other;
    /**
     * 跟进人
     */
    private String followUpPeople;

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRentArea() {
        return rentArea;
    }

    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }

    public String getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(String buildingArea) {
        this.buildingArea = buildingArea;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
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

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getFollowUpPeople() {
        return followUpPeople;
    }

    public void setFollowUpPeople(String followUpPeople) {
        this.followUpPeople = followUpPeople;
    }

    public String getTempRoomNumber() {
        return tempRoomNumber;
    }

    public void setTempRoomNumber(String tempRoomNumber) {
        this.tempRoomNumber = tempRoomNumber;
    }

    @Override
    public String toString() {
        return "Room{" +
                "buildingName='" + buildingName + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", tempRoomNumber='" + tempRoomNumber + '\'' +
                ", owner='" + owner + '\'' +
                ", rentArea='" + rentArea + '\'' +
                ", buildingArea='" + buildingArea + '\'' +
                ", roomType='" + roomType + '\'' +
                ", insertTime='" + insertTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", other='" + other + '\'' +
                ", followUpPeople='" + followUpPeople + '\'' +
                '}';
    }
}
