package io.github.zhuyajie666.bookmanagesystem.vo;

import java.util.List;

public class PageResult<T> {

    private int currentPage;

    private int totalPages;

    private int totalRows;

    private boolean hasPreviousPage;

    private boolean hasNextPage;

    private List<T> result;

    public PageResult(int currentPage, int totalPages, int totalRows, boolean hasPreviousPage, boolean hasNextPage, List<T> result) {
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalRows = totalRows;
        this.hasPreviousPage = hasPreviousPage;
        this.hasNextPage = hasNextPage;
        this.result = result;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
