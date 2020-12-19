package com.wish.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户操作日志表
 * @author 
 */
@TableName("tb_sys_user_log")
@Data
public class TbSysUserLog implements Serializable {

    @TableId(type= IdType.AUTO)     // 该注解，表示该成员是表主键字段
    @TableField("id")
    private Long id;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField("last_modified")
    private Date lastModified;

    /**
     * 参数
     */
    @TableField("args")
    private String args;

    /**
     * ip地址
     */
    @TableField("ip")
    private String ip;

    /**
     * 返回
     */
    @TableField("ret")
    private String ret;

    /**
     * url地址
     */
    @TableField("url")
    private String url;

    @TableField("user_id")
    private Long userId;
}