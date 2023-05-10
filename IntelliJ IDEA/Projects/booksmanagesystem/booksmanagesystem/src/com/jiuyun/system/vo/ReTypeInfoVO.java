package com.jiuyun.system.vo;

public class ReTypeInfoVO {
    String reTypeId;
    String reTypename;
    String maxBook;
    String borrowTime;
    String validTime;

    public ReTypeInfoVO(){

    }

    public ReTypeInfoVO(String reTypeId, String reTypename, String maxBook, String borrowTime, String validTime) {
        this.reTypeId = reTypeId;
        this.reTypename = reTypename;
        this.maxBook = maxBook;
        this.borrowTime = borrowTime;
        this.validTime = validTime;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }



    public String getReTypeId() {
        return reTypeId;
    }

    public void setReTypeId(String reTypeId) {
        this.reTypeId = reTypeId;
    }

    public String getReTypename() {
        return reTypename;
    }

    public void setReTypename(String reTypename) {
        this.reTypename = reTypename;
    }

    public String getMaxBook() {
        return maxBook;
    }

    public void setMaxBook(String maxBook) {
        this.maxBook = maxBook;
    }
}
