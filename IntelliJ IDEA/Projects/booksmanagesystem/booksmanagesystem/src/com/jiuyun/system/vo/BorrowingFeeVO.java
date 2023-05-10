package com.jiuyun.system.vo;

/**
 * 还书信息表
 */
public class BorrowingFeeVO {
    String bId;//图书编号
    String bName;//图书名称
    String rId;//读者编号
    String rName;//读者姓名
    String loanDate;//借出日期
    String dueDate;//应还日期
    String returnDate;//归还日期

    public BorrowingFeeVO(){
        super();
    }

    public BorrowingFeeVO(String bId, String bName, String rId, String rName, String loanDate, String dueDate, String returnDate) {
        this.bId = bId;
        this.bName = bName;
        this.rId = rId;
        this.rName = rName;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public String getBId() {
        return bId;
    }

    public void setBId(String bId) {
        this.bId = bId;
    }

    public String getBName() {
        return bName;
    }

    public void setBName(String bName) {
        this.bName = bName;
    }

    public String getRId() {
        return rId;
    }

    public void setRId(String rId) {
        this.rId = rId;
    }

    public String getRName() {
        return rName;
    }

    public void setRName(String rName) {
        this.rName = rName;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
