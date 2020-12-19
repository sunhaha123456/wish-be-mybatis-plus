package com.wish.data.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 菜单表
 * @author 
 */
@TableName("tb_menu")
@Data
public class TbMenu implements Serializable {

    @TableId(type= IdType.AUTO)     // 该注解，表示该成员是表主键字段
    @TableField("id")               // 该注解，指定该成员对应数据库表字段id，默认会按照驼峰，逆向拆分成员名
    private Long id;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField("last_modified")
    private Date lastModified;

    /**
     * 目录深度
     */
    @TableField("dir_level")
    private Integer dirLevel;

    /**
     * 菜单图标
     */
    @TableField("icon_cls")
    private String iconCls;

    /**
     * 菜单名称
     */
    @TableField("menu_name")
    private String menuName;

    /**
     * 菜单状态
     */
    @TableField("menu_state")
    private Integer menuState;

    /**
     * 上级目录id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 跳转链接
     */
    @TableField("url")
    private String url;
}