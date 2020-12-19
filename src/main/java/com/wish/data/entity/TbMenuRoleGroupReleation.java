package com.wish.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色菜单关联表
 * @author 
 */
@TableName("tb_menu_role_group_releation")
@Data
public class TbMenuRoleGroupReleation implements Serializable {

    @TableId(type= IdType.AUTO)     // 该注解，表示该成员是表主键字段
    @TableField("id")
    private Long id;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField("last_modified")
    private Date lastModified;

    /**
     * 菜单id
     */
    @TableField("menu_id")
    private Integer menuId;

    /**
     * 角色组id
     */
    @TableField("role_group_id")
    private Integer roleGroupId;
}