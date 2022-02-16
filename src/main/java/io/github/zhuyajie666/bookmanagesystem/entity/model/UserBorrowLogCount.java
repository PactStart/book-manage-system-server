package io.github.zhuyajie666.bookmanagesystem.entity.model;

import java.math.BigDecimal;

public class UserBorrowLogCount {

    private Integer total;

    private Integer borrowUserCount;

    private Integer borrowBookCount;

    private Integer borrowingCount;

    private BigDecimal totalFine;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getBorrowUserCount() {
        return borrowUserCount;
    }

    public void setBorrowUserCount(Integer borrowUserCount) {
        this.borrowUserCount = borrowUserCount;
    }

    public Integer getBorrowBookCount() {
        return borrowBookCount;
    }

    public void setBorrowBookCount(Integer borrowBookCount) {
        this.borrowBookCount = borrowBookCount;
    }

    public Integer getBorrowingCount() {
        return borrowingCount;
    }

    public void setBorrowingCount(Integer borrowingCount) {
        this.borrowingCount = borrowingCount;
    }

    public BigDecimal getTotalFine() {
        return totalFine;
    }

    public void setTotalFine(BigDecimal totalFine) {
        this.totalFine = totalFine;
    }
}
