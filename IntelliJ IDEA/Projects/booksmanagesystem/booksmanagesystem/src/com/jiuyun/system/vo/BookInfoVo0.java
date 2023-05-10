package com.jiuyun.system.vo;


import java.sql.Date;

public class BookInfoVo0 {
    private String BName;
    private String BId;
    private String Author;
    private String Publish;
    private String PDate;
    private String Price;
    private String cateGoryId;
    private String cateGoryName;
    private String cateGoryStructure;
    
    public BookInfoVo0(String BName,String BId,String Author,String Publish,String PDate,String Price,String categoryId,String categoryName,String explain) {
		super();
		this.BName=BName;
		this.BId=BId;
		this.Author=Author;
		this.Publish=Publish;
		this.PDate=PDate;
		this.Price=Price;
		this.cateGoryId=categoryId;
		this.cateGoryName=categoryName;
		this.cateGoryStructure=explain;
	}
    
    public BookInfoVo0() {
		// TODO 自动生成的构造函数存根
	}

	public String getBName() {
		return BName;
	}

	public void setBName(String bName) {
		BName = bName;
	}

	public String getBId() {
		return BId;
	}

	public void setBId(String bId) {
		BId = bId;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getPublish() {
		return Publish;
	}

	public void setPublish(String publish) {
		Publish = publish;
	}

	public String getPDate() {
		return PDate;
	}

	public void setPDate(String pDate) {
		PDate = pDate;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getCategoryId() {
		return cateGoryId;
	}

	public void setCategoryId(String categoryId) {
		this.cateGoryId = categoryId;
	}

	public String getCategoryName() {
		return cateGoryName;
	}

	public void setCategoryName(String categoryName) {
		this.cateGoryName = categoryName;
	}

	public String getExplain() {
		return cateGoryStructure;
	}

	public void setExplain(String explain) {
		this.cateGoryStructure = explain;
	}

	
	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return BName+"\t"+BId+"\t"+Author+"\t"+Publish+"\t"+PDate+"\t"+Price+"\t"+cateGoryId+"\t"+cateGoryName+"\t"+cateGoryStructure+"\t";
	}
}
