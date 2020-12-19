/*
Navicat MySQL Data Transfer

Source Server         : 00-本地
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : db_wish

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2020-12-19 14:24:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `dir_level` int(1) DEFAULT NULL COMMENT '目录深度',
  `icon_cls` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单图标',
  `menu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单名称',
  `menu_state` int(1) DEFAULT '0' COMMENT '菜单状态',
  `parent_id` int(20) DEFAULT NULL COMMENT '上级目录id',
  `sort` int(20) DEFAULT NULL COMMENT '排序',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '跳转链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('1', '2018-06-23 18:11:17', '2019-01-31 15:30:12', '1', 'fa-folder', '用户管理', '0', '0', '1', '');
INSERT INTO `tb_menu` VALUES ('2', '2018-06-23 18:11:17', '2019-01-31 15:31:26', '2', 'fa-circle-o', '用户管理', '0', '1', '3', 'user/userManage/toUserManage');
INSERT INTO `tb_menu` VALUES ('3', '2018-06-23 18:11:17', '2019-01-31 15:31:32', '2', 'fa-circle-o', '角色管理', '0', '1', '2', 'user/roleManage/toRoleManage');
INSERT INTO `tb_menu` VALUES ('4', '2018-06-23 18:11:17', '2019-01-31 15:31:37', '2', 'fa-circle-o', '菜单管理', '0', '1', '1', 'user/menuManage/toMenuManage');
INSERT INTO `tb_menu` VALUES ('5', '2018-11-09 14:31:04', '2019-01-31 15:29:45', '1', 'fa-folder', '上传下载', '0', '0', '2', null);
INSERT INTO `tb_menu` VALUES ('6', '2018-11-09 14:48:29', '2019-01-31 15:31:12', '2', 'fa-circle-o', '上传下载', '0', '5', '1', 'user/uploadDemo/toUploadDemo');

-- ----------------------------
-- Table structure for tb_menu_role_group_releation
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu_role_group_releation`;
CREATE TABLE `tb_menu_role_group_releation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `menu_id` int(20) DEFAULT NULL COMMENT '菜单id',
  `role_group_id` int(20) DEFAULT NULL COMMENT '角色组id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_menu_role_group_releation
-- ----------------------------
INSERT INTO `tb_menu_role_group_releation` VALUES ('5', '2018-11-09 14:58:25', '2018-11-09 14:58:25', '1', '1');
INSERT INTO `tb_menu_role_group_releation` VALUES ('6', '2018-11-09 14:58:25', '2018-11-09 14:58:26', '2', '1');
INSERT INTO `tb_menu_role_group_releation` VALUES ('7', '2018-11-09 14:58:25', '2018-11-09 14:58:26', '3', '1');
INSERT INTO `tb_menu_role_group_releation` VALUES ('8', '2018-11-09 14:58:25', '2018-11-09 14:58:26', '4', '1');
INSERT INTO `tb_menu_role_group_releation` VALUES ('9', '2018-11-09 14:58:25', '2018-11-09 14:58:26', '5', '1');
INSERT INTO `tb_menu_role_group_releation` VALUES ('10', '2018-11-09 14:58:25', '2018-11-09 14:58:26', '6', '1');

-- ----------------------------
-- Table structure for tb_role_group
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_group`;
CREATE TABLE `tb_role_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色名称',
  `role_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色备注',
  `role_state` int(1) DEFAULT '0' COMMENT '角色状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_role_group
-- ----------------------------
INSERT INTO `tb_role_group` VALUES ('1', '2018-07-24 11:51:57', '2018-08-26 13:55:34', '超级管理员', '超级管理员', '0');

-- ----------------------------
-- Table structure for tb_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_user`;
CREATE TABLE `tb_sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `login_name` varchar(255) DEFAULT NULL COMMENT '登录用户名',
  `role_group_id` bigint(20) DEFAULT NULL COMMENT '角色组id',
  `upwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_state` tinyint(4) DEFAULT '0' COMMENT '用户状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_sys_user
-- ----------------------------
INSERT INTO `tb_sys_user` VALUES ('1', '2020-05-01 15:37:13', '2020-05-01 15:37:27', 'superAdmin', '1', 'e10adc3949ba59abbe56e057f20f883e', '超级管理员', '0');

-- ----------------------------
-- Table structure for tb_sys_user_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_user_log`;
CREATE TABLE `tb_sys_user_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `args` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '参数',
  `ip` varchar(100) DEFAULT NULL COMMENT 'ip地址',
  `ret` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '返回',
  `url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'url地址',
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_sys_user_log
-- ----------------------------
