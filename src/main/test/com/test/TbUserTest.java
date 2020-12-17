package com.test;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wish.Application;
import com.wish.common.util.JsonUtil;
import com.wish.data.entity.TbSysUser;
import com.wish.repository.mapper.TbSysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TbUserTest {

	@Autowired
	private TbSysUserMapper tbSysUserMapper;

	@Test
	public void testInsert() {
		// 新增，未指定主键生成策略的前提下，会按照雪花算法，生成自增id
		TbSysUser user = new TbSysUser();
		Date now = new Date();
		user.setCreateDate(now);
		user.setLastModified(now);
		user.setLoginName("admin");
		user.setRoleGroupId(1L);
		user.setUpwd("123456");
		user.setUserName("管理员");
		user.setUserState(0);
		int c = tbSysUserMapper.insert(user);
		System.out.println(c);
	}

	@Test
	public void testSelect() {
		TbSysUser user = tbSysUserMapper.selectById(1L);
		System.out.println(JsonUtil.objectToJson(user));

		List<TbSysUser> list = null;
		list = tbSysUserMapper.selectBatchIds(Arrays.asList(1L, 1338671503334653954L, 1338671722038202370L, 1338673280385798146L));
		System.out.println(JsonUtil.objectToJson(list));

		list = tbSysUserMapper.selectByUnameAndPwd("admin", "1234567");
		System.out.println(JsonUtil.objectToJson(list));
	}

	@Test
	public void testSelectPage() {
		Page<TbSysUser> page1 = new Page<>(1, 2);
		IPage<TbSysUser> iPage1 = tbSysUserMapper.selectUserPage(page1);
		System.out.println(page1 == iPage1);
		System.out.println("总记录数	：" + iPage1.getTotal());
		System.out.println("总页数	：" + iPage1.getPages());

		Page<TbSysUser> page2 = new Page<>(1, 2);
		IPage<TbSysUser> iPage2 = tbSysUserMapper.selectPageByRoleGroupId(page2, 2L);
		System.out.println(page2 == iPage2);
		System.out.println("总记录数	：" + iPage2.getTotal());
		System.out.println("总页数	：" + iPage2.getPages());
	}































}