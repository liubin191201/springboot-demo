package com.bin.liu.springboot.demo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
