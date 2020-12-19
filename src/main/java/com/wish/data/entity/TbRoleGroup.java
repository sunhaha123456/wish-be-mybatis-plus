package com.wish.data.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户角色表
 * @author
 */
@TableName("tb_role_group")
@Data
public class TbRoleGroup implements Serializable {

    @TableId(type= IdType.AUTO)
    @TableField("id")
    private Long id;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField(value = "last_modified")
    private Date lastModified;

    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 角色备注
     */
    @TableField("role_remark")
    private String roleRemark;

    /**
     * 角色状态
     */
    @TableField("role_state")
    private Integer roleState;
}