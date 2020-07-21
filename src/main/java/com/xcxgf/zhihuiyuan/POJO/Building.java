package com.xcxgf.zhihuiyuan.POJO;

/**
 * 楼栋管理的实体类
 *
 * @author zyz
 */
public class Building {
    /**
     * 楼栋名称
     */
    private String buildingName;
    /**
     * 楼栋类型
     */
    private String buildingType;
    /**
     * 添加时间
     */
    private String insertTime;
    /**
     * 修改时间
     */
    private String updateTime;

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
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
