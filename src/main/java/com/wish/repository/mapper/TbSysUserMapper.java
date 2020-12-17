package com.wish.repository.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wish.data.entity.TbSysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSysUserMapper extends BaseMapper<TbSysUser> {

    List<TbSysUser> listByUnameAndPwd(@Param("loginName") String loginName, @Param("upwd") String upwd);

    IPage<TbSysUser> selectUserPage(Page<TbSysUser> page, @Param(Constants.WRAPPER) Wrapper<TbSysUser> wrappers);
}