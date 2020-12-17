/*
Navicat MySQL Data Transfer

Source Server         : 00-本地
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : db_wish

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2020-12-14 19:14:51
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_sys_user
-- ----------------------------
