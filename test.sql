/*
 Navicat Premium Data Transfer

 Source Server         : 121.196.151.249-3313
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 121.196.151.249:3313
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 28/11/2020 11:07:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for group_labels
-- ----------------------------
DROP TABLE IF EXISTS `group_labels`;
CREATE TABLE `group_labels`  (
  `group_id` int(11) NOT NULL COMMENT '产品id',
  `label_id` int(11) NOT NULL COMMENT '类型id',
  PRIMARY KEY (`group_id`, `label_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_labels
-- ----------------------------
INSERT INTO `group_labels` VALUES (1, 1);
INSERT INTO `group_labels` VALUES (1, 2);
INSERT INTO `group_labels` VALUES (1, 3);
INSERT INTO `group_labels` VALUES (2, 1);
INSERT INTO `group_labels` VALUES (2, 2);
INSERT INTO `group_labels` VALUES (3, 2);
INSERT INTO `group_labels` VALUES (4, 1);
INSERT INTO `group_labels` VALUES (5, 3);

-- ----------------------------
-- Table structure for labels
-- ----------------------------
DROP TABLE IF EXISTS `labels`;
CREATE TABLE `labels`  (
  `label_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签类型id',
  `label_type` int(11) NOT NULL COMMENT '1表示热门,2表示推荐,3表示新品',
  PRIMARY KEY (`label_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '类型标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of labels
-- ----------------------------
INSERT INTO `labels` VALUES (1, 1);
INSERT INTO `labels` VALUES (2, 2);
INSERT INTO `labels` VALUES (3, 3);

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group`  (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `status` int(11) NOT NULL COMMENT '1表示上架中,2表示待下架,3表示仓库中,4不表示草稿箱,5表示回收站',
  `group_type` int(11) NOT NULL COMMENT '1表示团建旅游,2表示拓展团建,3表示常规旅游,4表示奖励旅游',
  `attractions` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主要景点',
  `route_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '线路名称',
  `stale_date` datetime(0) NOT NULL COMMENT '过期时间',
  `price` decimal(10, 0) NOT NULL COMMENT '价格',
  `update_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `worker_id` int(11) NOT NULL COMMENT '更新人id',
  `score` int(11) NOT NULL COMMENT '分数',
  `click` int(11) NOT NULL COMMENT '点击',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `version` int(11) NOT NULL DEFAULT 0,
  `is_del` int(11) NULL DEFAULT 0 COMMENT '0表示为删除,1表示删除',
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '团建列表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_group
-- ----------------------------
INSERT INTO `t_group` VALUES (1, 2, 2, '354354', '13254', '2020-12-27 15:39:05', 1220, '2020-11-27 15:39:25', 2, 100, 55, '2020-11-27 15:39:25', 0, 0);
INSERT INTO `t_group` VALUES (2, 1, 1, '1231', '12223', '2020-11-30 15:40:22', 1992, '2020-11-27 15:41:45', 4, 98, 100, '2020-11-27 15:41:45', 0, 0);
INSERT INTO `t_group` VALUES (3, 2, 3, '1231', '123387', '2020-12-24 15:40:26', 1220, '2020-11-27 15:41:45', 1, 88, 12, '2020-11-27 15:41:45', 0, 0);
INSERT INTO `t_group` VALUES (4, 3, 1, '1343', '353453', '2020-12-15 15:40:33', 1445, '2020-11-27 15:41:46', 1, 79, 66, '2020-11-27 15:41:46', 0, 0);
INSERT INTO `t_group` VALUES (5, 2, 2, '1235', '354521', '2020-12-27 15:40:38', 5558, '2020-11-27 15:41:46', 2, 55, 440, '2020-11-27 15:41:46', 0, 0);
INSERT INTO `t_group` VALUES (6, 2, 1, '54345', '334534', '2020-11-28 11:06:09', 4420, '2020-11-28 11:06:36', 3, 90, 130, '2020-11-28 11:06:36', 0, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `sex` tinyint(1) NULL DEFAULT 1 COMMENT '性别 1 表示男 0 表示女',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `mark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `last_login` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最后一次登录时间',
  `login_ip` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录ip',
  `head` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '/img/default.png' COMMENT '头像图片路径',
  `reg_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '注册时间',
  `locked` tinyint(1) NULL DEFAULT 0 COMMENT '账号是否被锁定 1 表示未锁定 0 表示锁定',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  UNIQUE INDEX `uk_u_name`(`username`) USING BTREE,
  UNIQUE INDEX `uk_u_email`(`email`) USING BTREE,
  UNIQUE INDEX `uk_u_phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zs', '123456', '110', 1, '120@163.com', NULL, '2020-11-25 11:43:40', NULL, '/img/default.png', '2020-11-25 11:43:40', 0);
INSERT INTO `user` VALUES (2, 'demoData', 'demoData', 'demoData', 1, 'demoData', NULL, '2020-11-26 17:37:38', NULL, 'demoData', '2020-11-26 17:37:38', 0);
INSERT INTO `user` VALUES (5, '2235', 'demoData', '53332', 1, '565455', NULL, '2020-11-26 17:39:52', NULL, 'demoData', '2020-11-26 17:39:52', 0);
INSERT INTO `user` VALUES (6, '4587', 'demoData', '7676672', 1, '8876654', NULL, '2020-11-26 17:59:24', NULL, 'demoData', '2020-11-26 17:59:24', 0);
INSERT INTO `user` VALUES (7, 'dsasfgg', 'gsdgd', 'sfaeg', 1, 'gdgaeae', NULL, '2020-11-26 19:40:36', NULL, 'demoData', '2020-11-26 19:40:36', 0);
INSERT INTO `user` VALUES (8, '4543211', 'demoData', '122132344', 1, '55555555', NULL, '2020-11-26 19:54:59', NULL, 'demoData', '2020-11-26 19:54:59', 0);

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker`  (
  `worker_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `worker_name` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '姓名',
  `worker_password` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '密码',
  `create_date` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `is_del` int(11) NULL DEFAULT 0 COMMENT '0表示为删除,1表示删除',
  PRIMARY KEY (`worker_id`) USING BTREE,
  UNIQUE INDEX `worker_name`(`worker_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES (1, 'zs', '123456', '2020-11-27 15:47:30', 0);
INSERT INTO `worker` VALUES (2, 'ls', '110', '2020-11-27 15:47:30', 0);
INSERT INTO `worker` VALUES (3, 'ww', '789', '2020-11-27 15:47:31', 0);

SET FOREIGN_KEY_CHECKS = 1;
