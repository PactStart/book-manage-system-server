package io.github.zhuyajie666.bookmanagesystem.entity;

import javax.persistence.*;

@Table(name = "book_isbn")
public class BookIsbn {
    /**
     * 国际标准书号
     */
    @Id
    private String isbn;

    /**
     * 书的id
     */
    @Column(name = "book_id")
    private Integer bookId;

    /**
     * 是否借出
     */
    @Column(name = "is_borrowed")
    private Boolean isBorrowed;

    /**
     * 获取国际标准书号
     *
     * @return isbn - 国际标准书号
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * 设置国际标准书号
     *
     * @param isbn 国际标准书号
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    /**
     * 获取书的id
     *
     * @return book_id - 书的id
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * 设置书的id
     *
     * @param bookId 书的id
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Boolean getBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        isBorrowed = borrowed;
    }
}