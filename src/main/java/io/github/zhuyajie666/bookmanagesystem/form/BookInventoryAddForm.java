package io.github.zhuyajie666.bookmanagesystem.form;

import java.util.List;

public class BookInventoryAddForm {

    private Integer bookId;

    private List<String> isbnList;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public List<String> getIsbnList() {
        return isbnList;
    }

    public void setIsbnList(List<String> isbnList) {
        this.isbnList = isbnList;
    }
}
