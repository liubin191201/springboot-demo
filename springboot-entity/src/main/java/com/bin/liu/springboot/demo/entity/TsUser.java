package com.bin.liu.springboot.demo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.bin.liu.springboot.demo.common.annotation.FileName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 
 * </p>
 *
 * @author bin.liu123
 * @since 2019-03-15
 */
@TableName("ts_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class TsUser extends Model<TsUser> {

    private static final long serialVersionUID = 1L;

    @FileName(value = "用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 创建日期
     */
    @FileName(value = "创建时间")
    @TableField("create_date")
    private Date createDate;
    /**
     * 修改日期
     */
    @FileName(value = "修改时间")
    @TableField("modify_date")
    private Date modifyDate;
    @FileName(value = "用户名称")
    private String name;

    @FileName(value = "用户头像")
    private String icon;
    @FileName(value = "用户性别")
    private Integer sex;
    @FileName(value = "登录IP")
    @TableField("login_ip")
    private String loginIp;
    @FileName(value = "登录时间")
    @TableField("login_date")
    private Date loginDate;

    @FileName(value = "用户级别")
    private Integer level;
    @FileName(value = "用户经验")
    private Integer point;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
