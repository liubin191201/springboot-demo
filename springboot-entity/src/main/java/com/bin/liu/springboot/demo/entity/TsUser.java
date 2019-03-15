package com.bin.liu.springboot.demo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author bin.liu123
 * @since 2019-03-15
 */
@TableName("ts_user")
public class TsUser extends Model<TsUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 创建日期
     */
    @TableField("create_date")
    private Date createDate;
    /**
     * 修改日期
     */
    @TableField("modify_date")
    private Date modifyDate;
    private String name;
    private String icon;
    private Integer sex;
    @TableField("login_ip")
    private String loginIp;
    @TableField("login_date")
    private Date loginDate;
    private Integer level;
    private Integer point;


    public Long getId() {
        return id;
    }

    public TsUser setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public TsUser setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public TsUser setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }

    public String getName() {
        return name;
    }

    public TsUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public TsUser setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public TsUser setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public TsUser setLoginIp(String loginIp) {
        this.loginIp = loginIp;
        return this;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public TsUser setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public TsUser setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Integer getPoint() {
        return point;
    }

    public TsUser setPoint(Integer point) {
        this.point = point;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TsUser{" +
        ", id=" + id +
        ", createDate=" + createDate +
        ", modifyDate=" + modifyDate +
        ", name=" + name +
        ", icon=" + icon +
        ", sex=" + sex +
        ", loginIp=" + loginIp +
        ", loginDate=" + loginDate +
        ", level=" + level +
        ", point=" + point +
        "}";
    }
}
