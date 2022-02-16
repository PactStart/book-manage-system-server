package io.github.zhuyajie666.bookmanagesystem.dto;

public class BookQueryDto extends PageQueryDto {

    private Integer categoryId;

    private String keyword;

    private String isbn;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getKeyword(){
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
