package com.taira.box.bean.model;

import java.util.Date;

public class VertificationCode {
    private Integer id;
    private String mobile;
    private String vcode;
    private Date createTime;

    @Override
    public String toString() {
        return "VertificationCode{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", vcode='" + vcode + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
