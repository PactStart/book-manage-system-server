package io.github.zhuyajie666.bookmanagesystem.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_borrow_log")
public class UserBorrowLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 书籍id
     */
    @Column(name = "book_id")
    private Integer bookId;

    /**
     * 书籍isbn
     */
    private String isbn;

    /**
     * 借书日期
     */
    @Column(name = "borrow_at")
    private Date borrowAt;

    /**
     * 约定借书天数
     */
    @Column(name = "borrow_days")
    private Integer borrowDays;

    /**
     * 是否归还
     */
    @Column(name = "is_return")
    private Boolean isReturn;

    /**
     * 归还日期
     */
    @Column(name = "return_at")
    private Date returnAt;

    /**
     * 截止日期
     */
    @Column(name = "over_days")
    private Integer overDays;

    /**
     * 罚金
     */
    private BigDecimal fine;

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
}