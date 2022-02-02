package io.github.zhuyajie666.bookmanagesystem.vo;

import java.util.Date;
import java.util.List;

public class BookVo {

    private Integer id;

    /**
     * 封面图
     */
    private String url;

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
     * 类别Id
     */
    private Integer categoryId;

    /**
     * 库存
     */
    private Integer inventory;

    /**
     * 剩余库存
     */
    private Integer remainInventory;

    /**
     * 创建日期
     */
    private Date createAt;

    /**
     * 创建者
     */
    private Integer createBy;

    /**
     * 更新日期
     */
    private Date updateAt;

    /**
     * 更新者
     */
    private Integer updateBy;

    /**
     * 条形码
     */
    private Integer isbn;

    private Boolean del;

    private List<String> isbnList;

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
     * 获取书籍名称
     *
     * @return name - 书籍名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置书籍名称
     *
     * @param name 书籍名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取书籍作者
     *
     * @return author - 书籍作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置书籍作者
     *
     * @param author 书籍作者
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * 获取出版日期
     *
     * @return pub - 出版日期
     */
    public String getPub() {
        return pub;
    }

    /**
     * 设置出版日期
     *
     * @param pub 出版日期
     */
    public void setPub(String pub) {
        this.pub = pub == null ? null : pub.trim();
    }

    /**
     * 获取类别Id
     *
     * @return category_id - 类别Id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置类别Id
     *
     * @param categoryId 类别Id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取库存
     *
     * @return inventory - 库存
     */
    public Integer getInventory() {
        return inventory;
    }

    /**
     * 设置库存
     *
     * @param inventory 库存
     */
    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    /**
     * 获取剩余库存
     *
     * @return remain_inventory - 剩余库存
     */
    public Integer getRemainInventory() {
        return remainInventory;
    }

    /**
     * 设置剩余库存
     *
     * @param remainInventory 剩余库存
     */
    public void setRemainInventory(Integer remainInventory) {
        this.remainInventory = remainInventory;
    }

    /**
     * 获取创建日期
     *
     * @return create_at - 创建日期
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * 设置创建日期
     *
     * @param createAt 创建日期
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取更新日期
     *
     * @return update_at - 更新日期
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * 设置更新日期
     *
     * @param updateAt 更新日期
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取条形码
     *
     * @return isbn - 条形码
     */
    public Integer getIsbn() {
        return isbn;
    }

    /**
     * 设置条形码
     *
     * @param isbn 条形码
     */
    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public List<String> getIsbnList() {
        return isbnList;
    }

    public void setIsbnList(List<String> isbnList) {
        this.isbnList = isbnList;
    }
}