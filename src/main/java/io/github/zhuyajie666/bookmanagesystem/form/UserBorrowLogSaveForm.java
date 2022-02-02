package io.github.zhuyajie666.bookmanagesystem.form;

import javax.persistence.Column;
import java.math.BigDecimal;

public class UserBorrowLogSaveForm {
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 书籍id
     */
    @Column(name = "book_id")
    private Integer bookId;
    private Integer borrowDays;

    /**
     * 是否归还
     */
    @Column(name = "is_return")
    private Integer isReturn;

    /**
     * 截止日期
     */
    @Column(name = "over_days")
    private Integer overDays;

    /**
     * 罚金
     */
    private BigDecimal fine;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Integer isReturn) {
        this.isReturn = isReturn;
    }

    public Integer getOverDays() {
        return overDays;
    }

    public void setOverDays(Integer overDays) { this.overDays = overDays; }


}
