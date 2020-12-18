package com.wish.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wish.data.entity.TbSysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSysUserMapper extends BaseMapper<TbSysUser> {

    // -------------------------------- 进行演示的例子 --------------------------------

    List<TbSysUser> selectByUnameAndPwd(@Param("loginName") String loginName, @Param("upwd") String upwd);

    IPage<TbSysUser> selectUserPage(Page<TbSysUser> page);

    IPage<TbSysUser> selectPageByRoleGroupId(Page<TbSysUser> page, @Param("roleGroupId") Long roleGroupId);

    List<TbSysUser> selectLoginNameByRoleGroupId(@Param("roleGroupId") Long roleGroupId);

    List<String> selectLoginNameByUserState(@Param("userState") Integer userState);
}