package io.github.zhuyajie666.bookmanagesystem.form;

public class BookSaveForm {
    private Integer id;

    /**
     * 书籍名称
     */
    private String name;

    /**
     * 书籍作者
     */
    private String author;

    /**
     * 出版日期
     */
    private String pub;

    /**
     * 类别Id
     */
    private Integer categoryId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String Author() {
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {

        this.categoryId = categoryId;
    }

}
