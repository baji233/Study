package com.jiuyun.bean;

import java.util.List;

/**
 * @author cj
 * @create 2022年10月29日 10:43:48
 */
public class Company {
    private Integer companyId;
    private String companyName;
    private String type;
    private String remark;
    private List<Staff> staffList;

    public Company() {
    }

    public Company(Integer companyId, String companyName, String type, String remark, List<Staff> staffList) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.type = type;
        this.remark = remark;
        this.staffList = staffList;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", staffList=" + staffList +
                '}';
    }
}
