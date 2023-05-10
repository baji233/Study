package com.jiuyun.system.vo;

public class BookInfoVO {
	private String bookName;//书籍名称
	private String bookId;//书籍id
	private String author;//作者
	private String publish;//出版社
	private String pDate;//出版时间
	private String price;//单价
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getpDate() {
		return pDate;
	}
	public void setpDate(String pDate) {
		this.pDate = pDate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookInfoVO [bookName=" + bookName + ", bookId=" + bookId + ", author=" + author + ", publish=" + publish
				+ ", pDate=" + pDate + ", price=" + price + "]";
	}
	public BookInfoVO(String bookName, String bookId, String author, String publish, String pDate, String price) {
		super();
		this.bookName = bookName;
		this.bookId = bookId;
		this.author = author;
		this.publish = publish;
		this.pDate = pDate;
		this.price = price;
	}
	public BookInfoVO() {
		super();
	}
	
	
	
}
