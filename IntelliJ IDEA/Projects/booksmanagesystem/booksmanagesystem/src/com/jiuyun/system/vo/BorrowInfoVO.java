package com.jiuyun.system.vo;

public class BorrowInfoVO {
	private String readerId;
	private String readerName;
	private String readerSex;
	private String bookId;
	
	private String bookName;
	private String bookPublish;
	private String bookPrice;
	private String outOfTime;//借出时间
	private String shouldReturnDate;//应还时间
	private String returnState;//归还状态，是否归还
	private String returnTime;//归还日期
	private String comment;//备注
	private String borrowId;//借阅id
	
	
	public String getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(String borrowId) {
		this.borrowId = borrowId;
	}

	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getReaderSex() {
		return readerSex;
	}

	public void setReaderSex(String readerSex) {
		this.readerSex = readerSex;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookPublish() {
		return bookPublish;
	}

	public void setBookPublish(String bookPublish) {
		this.bookPublish = bookPublish;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getOutOfTime() {
		return outOfTime;
	}

	public void setOutOfTime(String outOfTime) {
		this.outOfTime = outOfTime;
	}

	public String getShouldReturnDate() {
		return shouldReturnDate;
	}

	public void setShouldReturnDate(String shouldReturnDate) {
		this.shouldReturnDate = shouldReturnDate;
	}

	public String getReturnState() {
		return returnState;
	}

	public void setReturnState(String returnState) {
		this.returnState = returnState;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
	
	@Override
	public String toString() {
		return "BorrowInfoVO [readerId=" + readerId + ", readerName=" + readerName + ", readerSex=" + readerSex
				+ ", bookId=" + bookId + ", bookName=" + bookName + ", bookPublish=" + bookPublish + ", bookPrice="
				+ bookPrice + ", outOfTime=" + outOfTime + ", shouldReturnDate=" + shouldReturnDate + ", returnState="
				+ returnState + ", returnTime=" + returnTime + ", comment=" + comment + ", borrowId=" + borrowId + "]";
	}

	

	public BorrowInfoVO(String readerId, String readerName, String readerSex, String bookId, String bookName,
			String bookPublish, String bookPrice, String outOfTime, String shouldReturnDate, String returnState,
			String returnTime, String comment, String borrowId) {
		super();
		this.readerId = readerId;
		this.readerName = readerName;
		this.readerSex = readerSex;
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPublish = bookPublish;
		this.bookPrice = bookPrice;
		this.outOfTime = outOfTime;
		this.shouldReturnDate = shouldReturnDate;
		this.returnState = returnState;
		this.returnTime = returnTime;
		this.comment = comment;
		this.borrowId = borrowId;
	}

	public BorrowInfoVO() {
		super();
	}
	
	
}
