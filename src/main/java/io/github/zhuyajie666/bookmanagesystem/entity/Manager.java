package io.github.zhuyajie666.bookmanagesystem.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建日期
     */
    @Column(name = "creat_at")
    private Date creatAt;

    /**
     * 更新日期
     */
    @Column(name = "update_at")
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
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取创建日期
     *
     * @return creat_at - 创建日期
     */
    public Date getCreatAt() {
        return creatAt;
    }

    /**
     * 设置创建日期
     *
     * @param creatAt 创建日期
     */
    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
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

    public void setCreateAt(Date date) {
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }
}