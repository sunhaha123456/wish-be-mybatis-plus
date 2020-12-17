import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wish.Application;
import com.wish.common.util.JsonUtil;
import com.wish.data.entity.TbSysUser;
import com.wish.repository.mapper.TbSysUserMapper;
import com.wish.repository.mapper.custom.TbSysUserMapperCustom;
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
	@Autowired
	private TbSysUserMapperCustom tbSysUserMapperCustom;

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
		System.out.println("=============== 1、根据id查询 ===============");
		// Preparing : SELECT id,create_date,last_modified,login_name,role_group_id,upwd,user_name,user_state FROM tb_sys_user WHERE id=?
		// Parameters: 1(Long)
		TbSysUser user = tbSysUserMapper.selectById(1L);
		System.out.println(JsonUtil.objectToJson(user));

		System.out.println("=============== 2、根据id批量查询 ===============");
		// Preparing : SELECT id,create_date,last_modified,login_name,role_group_id,upwd,user_name,user_state FROM tb_sys_user WHERE id IN ( ? , ? , ? , ? )
		// Parameters: 1(Long), 1338671503334653954(Long), 1338671722038202370(Long), 1338673280385798146(Long)
		List<TbSysUser> list = null;
		list = tbSysUserMapper.selectBatchIds(Arrays.asList(1L, 1338671503334653954L, 1338671722038202370L, 1338673280385798146L));
		System.out.println(JsonUtil.objectToJson(list));

		System.out.println("=============== 3、根据map查询 ===============");
		// Preparing : SELECT id,create_date,last_modified,login_name,role_group_id,upwd,user_name,user_state FROM tb_sys_user WHERE login_name = ? AND role_group_id = ?
		// Parameters: admin(String), 1(Long)
		Map<String, Object> columnMap = new HashMap<>();
		columnMap.put("login_name", "admin");
		columnMap.put("role_group_id", 1L);
		list = tbSysUserMapper.selectByMap(columnMap);
		System.out.println(JsonUtil.objectToJson(list));
	}

	@Test
	public void testSelectByMapperXml() {
		System.out.println("=============== 1、mapper XML方式 ===============");
		List<TbSysUser> list = tbSysUserMapper.listByUnameAndPwd("admin", "1234567");
		System.out.println(JsonUtil.objectToJson(list));
	}

	// 功能：分页查询，使用selectPage 和 selectMapsPage，通过使用QueryWrapper
	@Test
	public void testSelectPageByQueryWrapper() {
		System.out.println("=============== 1、分页查询，使用selectPage，通过使用QueryWrapper ===============");

		QueryWrapper<TbSysUser> queryWrapper = null;
		queryWrapper = Wrappers.<TbSysUser>query();
		queryWrapper.like("login_name", "ad").gt("id", 0);

		Page<TbSysUser> page = new Page<TbSysUser>(1, 2);
		IPage<TbSysUser> iPage = tbSysUserMapper.selectPage(page, queryWrapper);

		System.out.println("总页数	：" + iPage.getPages());
		System.out.println("总记录数	：" + iPage.getTotal());
		List<TbSysUser> list = iPage.getRecords();

		System.out.println(JsonUtil.objectToJson(list));

		System.out.println("=============== 2、分页查询，使用selectMapsPage，通过使用QueryWrapper ===============");

		Page<TbSysUser> pageMap = new Page<TbSysUser>(1, 2);
		IPage<Map<String, Object>> iPageMap = tbSysUserMapper.selectMapsPage(pageMap, queryWrapper);

		System.out.println("总页数	：" + iPageMap.getPages());
		System.out.println("总记录数	：" + iPageMap.getTotal());
		List<Map<String, Object>> listMap = iPageMap.getRecords();

		System.out.println(JsonUtil.objectToJson(listMap));
	}

	// 功能：分页查询，使用Mapper 自定义方法
	@Test
	public void testSelectPageByMapper() {
		System.out.println("============= 1、分页查询，使用Mapper 自定义方法 =============");
		QueryWrapper<TbSysUser> queryWrapper = null;
		queryWrapper = Wrappers.<TbSysUser>query();
		queryWrapper.like("login_name", "ad").gt("id", 0);

		Page<TbSysUser> page = new Page<TbSysUser>(2, 2);

		IPage<TbSysUser> iPage = tbSysUserMapper.selectUserPage(page, queryWrapper);

		System.out.println("总页数	：" + iPage.getPages());
		System.out.println("总记录数	：" + iPage.getTotal());
		List<TbSysUser> list = iPage.getRecords();

		System.out.println(JsonUtil.objectToJson(list));

		System.out.println("============= 2、分页查询，使用Mapper 自定义方法，并通过custom方式 =============");

		iPage = tbSysUserMapperCustom.selectUserPage(page, 1L);

		System.out.println("总页数	：" + iPage.getPages());
		System.out.println("总记录数	：" + iPage.getTotal());
		list = iPage.getRecords();

		System.out.println(JsonUtil.objectToJson(list));
	}

	@Test
	public void testSelectPage2() {
		System.out.println("============= 1、分页 调Mapper 自定义方法 =============");
		QueryWrapper<TbSysUser> queryWrapper = null;
		queryWrapper = Wrappers.<TbSysUser>query();
		queryWrapper.like("login_name", "ad").gt("id", 0);

		Page<TbSysUser> page = new Page<TbSysUser>(2, 2);

		IPage<TbSysUser> iPage = tbSysUserMapper.selectUserPage(page, queryWrapper);

		System.out.println("总页数	：" + iPage.getPages());
		System.out.println("总记录数	：" + iPage.getTotal());
		List<TbSysUser> list = iPage.getRecords();

		System.out.println(JsonUtil.objectToJson(list));

		System.out.println("============= 2、分页 调Mapper 自定义方法，但通过custom方式调用 =============");

		iPage = tbSysUserMapperCustom.selectUserPage(page, 1L);

		System.out.println("总页数	：" + iPage.getPages());
		System.out.println("总记录数	：" + iPage.getTotal());
		list = iPage.getRecords();

		System.out.println(JsonUtil.objectToJson(list));
	}

	@Test
	public void testSelectWrapper1() {
		System.out.println("=============== 根据wrapper查询 ===============");
		// Preparing : SELECT id,create_date,last_modified,login_name,role_group_id,upwd,user_name,user_state FROM tb_sys_user WHERE (login_name LIKE ? AND id < ?)
		// Parameters: %ad%(String), 2(Integer)
		// 有两种创建Wrapper的方式，两种方式的结果都是一样的：
		// 1、QueryWrapper<TbSysUser> queryWrapper = new QueryWrapper<TbSysUser>();
		// 2、QueryWrapper<TbSysUser> queryWrapper = Wrappers.<TbSysUser>query();
		QueryWrapper<TbSysUser> queryWrapper = null;
		queryWrapper = Wrappers.<TbSysUser>query();
		queryWrapper.like("login_name", "ad").lt("id", 2);
		List<TbSysUser> list = null;
		list = tbSysUserMapper.selectList(queryWrapper);
		System.out.println(JsonUtil.objectToJson(list));

		// Preparing : SELECT id,create_date,last_modified,login_name,role_group_id,upwd,user_name,user_state FROM tb_sys_user WHERE (login_name LIKE ? AND id BETWEEN ? AND ? AND user_name IS NOT NULL)
		// Parameters: %ad%(String), 1(Long), 2(Long)
		queryWrapper = Wrappers.<TbSysUser>query();
		queryWrapper.like("login_name", "ad").between("id", 1L, 2L).isNotNull("user_name");
		list = tbSysUserMapper.selectList(queryWrapper);
		System.out.println(JsonUtil.objectToJson(list));

		// Preparing : SELECT id,create_date,last_modified,login_name,role_group_id,upwd,user_name,user_state FROM tb_sys_user WHERE (login_name LIKE ? OR id >= ?) ORDER BY id DESC,role_group_id ASC
		// Parameters: ad%(String), 1(Long)
		queryWrapper = Wrappers.<TbSysUser>query();
		queryWrapper.likeRight("login_name", "ad").or().ge("id", 1L).orderByDesc("id").orderByAsc("role_group_id");
		list = tbSysUserMapper.selectList(queryWrapper);
		System.out.println(JsonUtil.objectToJson(list));
	}

	@Test
	public void testSelectWrapper2() {
		System.out.println("=============== 根据wrapper查询 ===============");
		// Preparing : SELECT id,create_date,last_modified,login_name,role_group_id,upwd,user_name,user_state FROM tb_sys_user WHERE (date_format(create_date, '%Y-%m-%d')=? AND id IN (select role_group_id from tb_sys_user))
		// Parameters: 2020-12-15(String)
		// 有两种创建Wrapper的方式，两种方式的结果都是一样的：
		// 1、QueryWrapper<TbSysUser> queryWrapper = new QueryWrapper<TbSysUser>();
		// 2、QueryWrapper<TbSysUser> queryWrapper = Wrappers.<TbSysUser>query();
		QueryWrapper<TbSysUser> queryWrapper = null;
		queryWrapper = Wrappers.<TbSysUser>query();

		queryWrapper.apply("date_format(create_date, '%Y-%m-%d')={0}", "2020-12-15").
				inSql("id", "select role_group_id from tb_sys_user");

		List<TbSysUser> list = null;
		list = tbSysUserMapper.selectList(queryWrapper);
		System.out.println(JsonUtil.objectToJson(list));
	}






































}