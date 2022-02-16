package io.github.zhuyajie666.bookmanagesystem.vo;

import java.math.BigDecimal;
import java.util.Date;

public class UserBorrowLogVo {

    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    private String userName;

    /**
     * 书籍id
     */
    private Integer bookId;

    /**
     * 书籍isbn
     */
    private String isbn;

    /**
     * 借书日期
     */
    private Date borrowAt;

    /**
     * 约定借书天数
     */
    private Integer borrowDays;

    /**
     * 是否归还
     */
    private Boolean isReturn;

    /**
     * 归还日期
     */
    private Date returnAt;

    /**
     * 截止日期
     */
    private Integer overDays;

    /**
     * 罚金
     */
    private BigDecimal fine;

    /**
     * 书籍名称
     */
    private String name;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 拼音缩略
     */
    private String pinyinAbbr;

    /**
     * 书籍作者
     */
    private String author;

    /**
     * 出版日期
     */
    private String pub;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取书籍id
     *
     * @return book_id - 书籍id
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * 设置书籍id
     *
     * @param bookId 书籍id
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * 获取借书日期
     *
     * @return borrow_at - 借书日期
     */
    public Date getBorrowAt() {
        return borrowAt;
    }

    /**
     * 设置借书日期
     *
     * @param borrowAt 借书日期
     */
    public void setBorrowAt(Date borrowAt) {
        this.borrowAt = borrowAt;
    }

    /**
     * 获取约定借书天数
     *
     * @return borrow_days - 约定借书天数
     */
    public Integer getBorrowDays() {
        return borrowDays;
    }

    /**
     * 设置约定借书天数
     *
     * @param borrowDays 约定借书天数
     */
    public void setBorrowDays(Integer borrowDays) {
        this.borrowDays = borrowDays;
    }

    /**
     * 获取是否归还
     *
     * @return is_return - 是否归还
     */
    public Boolean getIsReturn() {
        return isReturn;
    }

    /**
     * 设置是否归还
     *
     * @param isReturn 是否归还
     */
    public void setIsReturn(Boolean isReturn) {
        this.isReturn = isReturn;
    }

    /**
     * 获取归还日期
     *
     * @return return_at - 归还日期
     */
    public Date getReturnAt() {
        return returnAt;
    }

    /**
     * 设置归还日期
     *
     * @param returnAt 归还日期
     */
    public void setReturnAt(Date returnAt) {
        this.returnAt = returnAt;
    }

    /**
     * 获取截止日期
     *
     * @return over_days - 截止日期
     */
    public Integer getOverDays() {
        return overDays;
    }

    /**
     * 设置截止日期
     *
     * @param overDays 截止日期
     */
    public void setOverDays(Integer overDays) {
        this.overDays = overDays;
    }

    /**
     * 获取罚金
     *
     * @return fine - 罚金
     */
    public BigDecimal getFine() {
        return fine;
    }

    /**
     * 设置罚金
     *
     * @param fine 罚金
     */
    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Boolean getReturn() {
        return isReturn;
    }

    public void setReturn(Boolean aReturn) {
        isReturn = aReturn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getPinyinAbbr() {
        return pinyinAbbr;
    }

    public void setPinyinAbbr(String pinyinAbbr) {
        this.pinyinAbbr = pinyinAbbr;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }
}