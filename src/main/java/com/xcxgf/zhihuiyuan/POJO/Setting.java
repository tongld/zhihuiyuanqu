package com.xcxgf.zhihuiyuan.POJO;

/**
 * 系统设置的实体类
 */
public class Setting {
    private int id; // id标识
    private String manageExpense; // 管理单价
    private int state; // 记录状态，1为可用，-1为不可用

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManageExpense() {
        return manageExpense;
    }

    public void setManageExpense(String manageExpense) {
        this.manageExpense = manageExpense;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
