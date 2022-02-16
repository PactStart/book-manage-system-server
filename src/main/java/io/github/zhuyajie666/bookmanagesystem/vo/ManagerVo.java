package io.github.zhuyajie666.bookmanagesystem.vo;

import java.util.Date;

public class ManagerVo {

    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 创建日期
     */
    private Date createAt;

    /**
     * 更新日期
     */
    private Date updateAt;

    private Boolean del;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取创建日期
     *
     * @return creat_at - 创建日期
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

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

}