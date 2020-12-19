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

	// -------------------------------- 以下是进行演示的例子 --------------------------------

	// 功能：演示新增
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

	// 功能：演示基本查询
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

	// 功能：演示分页
	@Test
	public void testSelectPage() {
		Page<TbSysUser> page1 = new Page<>(1, 2);
		IPage<TbSysUser> iPage1 = tbSysUserMapper.selectUserPage(page1);
		System.out.println(page1 == iPage1);
		System.out.println("总记录数	：" + iPage1.getTotal());
		System.out.println("总页数	：" + iPage1.getPages());

		Page<TbSysUser> page2 = new Page<>(1, 2);
		IPage<TbSysUser> iPage2 = tbSysUserMapper.selectPageByRoleGroupId(page2, 1L);
		System.out.println(page2 == iPage2);
		System.out.println("总记录数	：" + iPage2.getTotal());
		System.out.println("总页数	：" + iPage2.getPages());
	}

	// 功能：演示查询返回Map list
	@Test
	public void testSelectMap() {
		List<Map<String, Object>> userMapList = tbSysUserMapper.selectLoginNameByUserStateReturnMap(0);
		System.out.println(JsonUtil.objectToJson(userMapList));
	}

	// 功能：演示查询分页 map
	@Test
	public void testSelectMapPage() {
		Page<Map<String, Object>> page1 = new Page<>(1, 2);
		IPage<Map<String, Object>> iPage1 = tbSysUserMapper.selectLoginNameByUserStateReturnMapPage(page1, 0);
		System.out.println(page1 == iPage1);
		System.out.println("总记录数	：" + iPage1.getTotal());
		System.out.println("总页数	：" + iPage1.getPages());
	}

	// 功能：演示查询时，入参是对象形式
	@Test
	public void testSelectParamObj() {
		TbSysUser param = new TbSysUser();
		param.setUserState(0);
		List<TbSysUser> userMapList = tbSysUserMapper.selectByObj(param);
		System.out.println(JsonUtil.objectToJson(userMapList));
	}

	// 功能：演示左关联查询
	@Test
	public void testSelectPageLeft() {
		Page<TbSysUser> page = new Page<>(1, 2);
		IPage<TbSysUser> iPage= tbSysUserMapper.selectUserPageByLeft(page);
		System.out.println(JsonUtil.objectToJson(iPage));

		System.out.println("=======================");

		List<TbSysUser> list = tbSysUserMapper.selectUserByLeft();
		System.out.println(JsonUtil.objectToJson(list));

		System.out.println("=======================");

		Long c = tbSysUserMapper.selectCountUserByLeft();
		System.out.println(c);
	}

	@Test
	public void testVersion() {
		TbSysUser user = new TbSysUser();
		user.setId(1L);
		user.setRoleGroupId(1L);
		user.setUpwd("11111111111");
		tbSysUserMapper.updateById(user);
	}

































}