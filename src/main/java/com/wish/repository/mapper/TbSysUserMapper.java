package com.wish.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wish.data.entity.TbSysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbSysUserMapper extends BaseMapper<TbSysUser> {

    // -------------------------------- 以下是进行演示的例子 --------------------------------

    List<TbSysUser> selectByUnameAndPwd(@Param("loginName") String loginName, @Param("upwd") String upwd);

    IPage<TbSysUser> selectUserPage(Page<TbSysUser> page);

    IPage<TbSysUser> selectPageByRoleGroupId(Page<TbSysUser> page, @Param("roleGroupId") Long roleGroupId);

    List<TbSysUser> selectLoginNameByRoleGroupId(@Param("roleGroupId") Long roleGroupId);

    List<String> selectLoginNameByUserState(@Param("userState") Integer userState);

    List<Map<String, Object>> selectLoginNameByUserStateReturnMap(@Param("userState") Integer userState);

    IPage<Map<String, Object>> selectLoginNameByUserStateReturnMapPage(Page<Map<String, Object>> page, @Param("userState") Integer userState);

    List<TbSysUser> selectByObj(@Param("user") TbSysUser user);
}