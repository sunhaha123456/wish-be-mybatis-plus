package com.wish.repository.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wish.data.entity.TbSysUser;
import com.wish.repository.mapper.TbSysUserMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class TbSysUserMapperCustom {
    @Resource
    private TbSysUserMapper tbSysUserMapper;

//    public IPage<TbSysUser> selectUserPage(Page<TbSysUser> page, Long roleGroupId) {
//        QueryWrapper<TbSysUser> queryWrapper = null;
//        queryWrapper = Wrappers.<TbSysUser>query();
//        queryWrapper.like("login_name", "ad").eq("role_group_id", roleGroupId);
//        return tbSysUserMapper.selectp.selectUserPage(page, queryWrapper);
//    }
}