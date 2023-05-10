package com.jiuyun.bean;

/**
 * @author cj
 * @create 2022年10月29日 09:34:04
 */
public class Book {
    private Integer bookId;
    private String bookName;
    private String type;
    private String remark;
    private Integer state;
    private Author author;

    public Book() {
    }

    public Book(Integer bookId, String bookName, String type, String remark, Integer state, Author author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.type = type;
        this.remark = remark;
        this.state = state;
        this.author = author;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", state=" + state +
                ", author=" + author +
                '}';
    }
}
