package com.jiuyun.bean;

/**
 * @author cj
 * @create 2022年10月29日 09:31:20
 */
public class Author {
    private Integer authorId;
    private String authorName;
    private String tel;
    private String address;
    private String remark;

    public Author() {
    }

    public Author(Integer authorId, String authorName, String tel, String address, String remark) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.tel = tel;
        this.address = address;
        this.remark = remark;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
