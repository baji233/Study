package com.jiuyun.system.vo;

/**
 * 收款记录表
 */
public class CollectionRecordVO {
    private String rId;//读者编号
    private String rName;//读者姓名
    private String amountReceivable;//应收金额
    private String amountReceived;//实收金额
    private String paymentType;//收款类型
    private String collectionTime;//收款时间

    public CollectionRecordVO(){
        super();
    }

    public CollectionRecordVO(String rId, String rName, String amountReceivable, String amountReceived, String paymentType, String collectionTime) {
        super();
        this.rId = rId;
        this.rName = rName;
        this.amountReceivable = amountReceivable;
        this.amountReceived = amountReceived;
        this.paymentType = paymentType;
        this.collectionTime = collectionTime;
    }

    public String getRId() {
        return rId;
    }

    public void setRId(String rId) {
        this.rId = rId;
    }

    public String getRName() {return rName;}

    public void setRName(String rName) {
        this.rName = rName;
    }

    public String getAmountReceivable() {
        return amountReceivable;
    }

    public void setAmountReceivable(String amountReceivable) {
        this.amountReceivable = amountReceivable;
    }

    public String getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(String amountReceived) {this.amountReceived = amountReceived;}

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(String collectionTime) {
        this.collectionTime = collectionTime;
    }
}











