package io.github.zhuyajie666.bookmanagesystem.entity.model;

import io.github.zhuyajie666.bookmanagesystem.entity.UserBorrowLog;

public class UserBorrowLogEx extends UserBorrowLog {

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
