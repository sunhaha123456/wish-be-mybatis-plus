package com.wish.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wish.data.entity.TbSysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbSysUserMapper extends BaseMapper<TbSysUser> {

    List<TbSysUser> selectByUnameAndPwd(@Param("loginName") String loginName, @Param("upwd") String upwd);

    IPage<TbSysUser> selectUserPage(Page<TbSysUser> page);

    IPage<TbSysUser> selectPageByRoleGroupId(Page<TbSysUser> page, @Param("roleGroupId") Long roleGroupId);
}