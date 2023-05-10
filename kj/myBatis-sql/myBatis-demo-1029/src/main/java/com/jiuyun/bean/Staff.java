package com.jiuyun.bean;

/**
 * @author cj
 * @create 2022年10月29日 10:42:01
 */
public class Staff {
    private Integer staffId;
    private String staffName;
    private String sex;
    private String tel;
    private Integer companyId;
    private String remark;

    public Staff() {
    }

    public Staff(Integer staffId, String staffName, String sex, String tel, Integer companyId, String remark) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.sex = sex;
        this.tel = tel;
        this.companyId = companyId;
        this.remark = remark;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", companyId=" + companyId +
                ", remark='" + remark + '\'' +
                '}';
    }
}
