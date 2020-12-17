package com.wish.data.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.util.Date;

@TableName("tb_sys_user")   // 该注解，指定对应表名，默认会按照驼峰，逆向拆分实体类名
@Data
public class TbSysUser {

    // 主键 id
    @TableId(type=IdType.AUTO)      // 该注解，表示该成员是表主键字段
    @TableField("id")               // 该注解，指定该成员对应数据库表字段id，默认会按照驼峰，逆向拆分成员名
    private Long id;

    // 创建时间
    @TableField(value = "create_date")
    private Date createDate;

    // 修改时间
    @TableField("last_modified")
    private Date lastModified;

    // 登录用户名
    @TableField("login_name")
    private String loginName;

    // 用户所属用户组
    @TableField("role_group_id")
    private Long roleGroupId;

    @TableField(exist = false)  // 表示该字段，不是数据库表字段
    private String roleGroupName;

    // 登录密码
    @TableField("upwd")
    private String upwd;

    // 用户显示名
    @TableField("user_name")
    private String userName;

    // 用户状态
    @TableField("user_state")
    private Integer userState;
}