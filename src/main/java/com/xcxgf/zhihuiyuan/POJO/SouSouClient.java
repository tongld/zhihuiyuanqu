package com.xcxgf.zhihuiyuan.POJO;

/**
 * @author gdd
 */
public class SouSouClient {
    private int id;
    /**
     * 招商负责人
     */
    private String zsFuZeRen;
    /**
     * 城市
     */
    private String city;
    /**
     * 公司名
     */
    private String companyName;
    /**
     * 学号
     */
    private String sno;
    /**
     * 联系人姓名
     */
    private String contactPerson;
    /**
     * 职位
     */
    private String zhiWei;
    /**
     * 联系电话
     */
    private String phoneNumber;
    /**
     * 类目
     */
    private String category;
    /**
     * 主营平台
     */
    private String pingTai;
    /**
     * 营业额
     */
    private double sales;
    /**
     * 沟通情况
     */
    private String communication;
    /**
     * 录入时间
     */
    private String createTime;
    /**
     * 是否存在合同
     */
    private Boolean isContract;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZsFuZeRen() {
        return zsFuZeRen;
    }

    public void setZsFuZeRen(String zsFuZeRen) {
        this.zsFuZeRen = zsFuZeRen;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getZhiWei() {
        return zhiWei;
    }

    public void setZhiWei(String zhiWei) {
        this.zhiWei = zhiWei;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPingTai() {
        return pingTai;
    }

    public void setPingTai(String pingTai) {
        this.pingTai = pingTai;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Boolean getContract() {
        return isContract;
    }

    public void setContract(Boolean contract) {
        isContract = contract;
    }
}
