/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50536
 Source Host           : localhost:3306
 Source Schema         : project2

 Target Server Type    : MySQL
 Target Server Version : 50536
 File Encoding         : 65001

 Date: 11/03/2022 11:10:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for achievement
-- ----------------------------
DROP TABLE IF EXISTS `achievement`;
CREATE TABLE `achievement`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `count` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of achievement
-- ----------------------------
INSERT INTO `achievement` VALUES (1, 5, 70);
INSERT INTO `achievement` VALUES (2, 6, 10);

-- ----------------------------
-- Table structure for day_count
-- ----------------------------
DROP TABLE IF EXISTS `day_count`;
CREATE TABLE `day_count`  (
  `id` int(11) NOT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  `taskname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` int(10) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of day_count
-- ----------------------------

-- ----------------------------
-- Table structure for default_task
-- ----------------------------
DROP TABLE IF EXISTS `default_task`;
CREATE TABLE `default_task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type_id` int(11) NULL DEFAULT NULL,
  `task_value` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of default_task
-- ----------------------------
INSERT INTO `default_task` VALUES (1, '跑步', NULL, 1, 10);
INSERT INTO `default_task` VALUES (2, '减肥', NULL, 1, 10);
INSERT INTO `default_task` VALUES (3, '早起', NULL, 1, 10);
INSERT INTO `default_task` VALUES (4, '早睡', NULL, 1, 10);
INSERT INTO `default_task` VALUES (5, '多喝水', NULL, 1, 10);
INSERT INTO `default_task` VALUES (6, '吃早餐', NULL, 1, 10);
INSERT INTO `default_task` VALUES (7, '运动半小时', NULL, 1, 10);
INSERT INTO `default_task` VALUES (8, '饭后靠墙15分钟', NULL, 1, 10);
INSERT INTO `default_task` VALUES (9, '晚上刷牙', NULL, 1, 10);
INSERT INTO `default_task` VALUES (10, '12点之前睡觉', NULL, 1, 10);
INSERT INTO `default_task` VALUES (11, '不吃宵夜', NULL, 1, 10);
INSERT INTO `default_task` VALUES (12, '俯卧撑', NULL, 1, 10);
INSERT INTO `default_task` VALUES (13, '仰卧起坐', NULL, 1, 10);
INSERT INTO `default_task` VALUES (14, '吃水果', NULL, 1, 10);
INSERT INTO `default_task` VALUES (15, '练瑜伽', NULL, 1, 10);
INSERT INTO `default_task` VALUES (16, '每天走15000步', NULL, 1, 10);
INSERT INTO `default_task` VALUES (17, '每天看书一小时', NULL, 2, 10);
INSERT INTO `default_task` VALUES (18, '每天练字一小时', NULL, 2, 10);
INSERT INTO `default_task` VALUES (19, '背单词', NULL, 2, 10);
INSERT INTO `default_task` VALUES (20, '简笔画', NULL, 2, 10);
INSERT INTO `default_task` VALUES (21, '学英语', NULL, 2, 10);
INSERT INTO `default_task` VALUES (22, '看书', NULL, 2, 10);
INSERT INTO `default_task` VALUES (23, '练习尤克里里', NULL, 2, 10);
INSERT INTO `default_task` VALUES (24, '学习强国积分', NULL, 2, 10);
INSERT INTO `default_task` VALUES (25, '亲子阅读', NULL, 2, 10);
INSERT INTO `default_task` VALUES (26, '背一首古诗', NULL, 2, 10);
INSERT INTO `default_task` VALUES (27, '练钢琴', NULL, 2, 10);
INSERT INTO `default_task` VALUES (28, '左手练字', NULL, 2, 10);
INSERT INTO `default_task` VALUES (29, '听力', NULL, 2, 10);
INSERT INTO `default_task` VALUES (30, '考研', NULL, 2, 10);
INSERT INTO `default_task` VALUES (31, '每天想一下自己做什么', NULL, 3, 10);
INSERT INTO `default_task` VALUES (32, '对一天进行回顾', NULL, 3, 10);
INSERT INTO `default_task` VALUES (33, '每天感恩', NULL, 3, 10);
INSERT INTO `default_task` VALUES (34, '冥想', NULL, 3, 10);
INSERT INTO `default_task` VALUES (35, '每日工作总结', NULL, 3, 10);
INSERT INTO `default_task` VALUES (36, '生而为人 你切修身', NULL, 3, 10);
INSERT INTO `default_task` VALUES (37, '睡前列好第二天要做的事', NULL, 3, 10);
INSERT INTO `default_task` VALUES (38, '每天记录一件自己认为幸福的事', NULL, 3, 10);
INSERT INTO `default_task` VALUES (39, '醒来喝杯水', NULL, 4, 10);
INSERT INTO `default_task` VALUES (40, '做转眼运动', NULL, 4, 10);
INSERT INTO `default_task` VALUES (41, '穿衣搭配', NULL, 4, 10);
INSERT INTO `default_task` VALUES (42, '做今日计划', NULL, 4, 10);
INSERT INTO `default_task` VALUES (43, '浇花', NULL, 4, 10);
INSERT INTO `default_task` VALUES (44, '遛狗', NULL, 4, 10);
INSERT INTO `default_task` VALUES (45, '叠被子', NULL, 4, 10);
INSERT INTO `default_task` VALUES (46, '拉伸筋骨', NULL, 4, 10);
INSERT INTO `default_task` VALUES (47, '打扫房间', NULL, 4, 10);
INSERT INTO `default_task` VALUES (48, '写日记', NULL, 5, 10);
INSERT INTO `default_task` VALUES (49, '学习', NULL, 5, 10);
INSERT INTO `default_task` VALUES (50, '一句话日记', NULL, 5, 10);
INSERT INTO `default_task` VALUES (51, '每天锻炼一个keep', NULL, 5, 10);
INSERT INTO `default_task` VALUES (52, '反省自己', NULL, 5, 10);
INSERT INTO `default_task` VALUES (53, '说我爱你', NULL, 5, 10);
INSERT INTO `default_task` VALUES (54, '日行一善', NULL, 5, 10);
INSERT INTO `default_task` VALUES (55, '英语四级单词', NULL, 5, 10);
INSERT INTO `default_task` VALUES (56, '对自己好一点', NULL, 6, 10);
INSERT INTO `default_task` VALUES (57, '探索新事物', NULL, 6, 10);
INSERT INTO `default_task` VALUES (58, '记录新idea', NULL, 6, 10);
INSERT INTO `default_task` VALUES (59, '情绪垃圾桶', NULL, 6, 10);
INSERT INTO `default_task` VALUES (60, '眉头无一事 笔下有千年', NULL, 6, 10);
INSERT INTO `default_task` VALUES (61, '存钱履行', NULL, 6, 10);
INSERT INTO `default_task` VALUES (62, '和自己的昨天比', NULL, 6, 10);
INSERT INTO `default_task` VALUES (63, '每天想他/她一次', NULL, 6, 10);
INSERT INTO `default_task` VALUES (64, '每天拍一张照片', NULL, 6, 10);
INSERT INTO `default_task` VALUES (65, '唱歌给你听', NULL, 6, 10);
INSERT INTO `default_task` VALUES (66, '控制好情绪', NULL, 6, 10);
INSERT INTO `default_task` VALUES (67, '每天存10元', NULL, 6, 10);
INSERT INTO `default_task` VALUES (68, '每周给爸妈打一次电话', NULL, 6, 10);
INSERT INTO `default_task` VALUES (69, '微笑待人', NULL, 6, 10);

-- ----------------------------
-- Table structure for deleted_task
-- ----------------------------
DROP TABLE IF EXISTS `deleted_task`;
CREATE TABLE `deleted_task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `task_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `type_id` int(11) NULL DEFAULT NULL COMMENT '任务类型',
  `begin_day` date NULL DEFAULT NULL,
  `task_day` int(3) NULL DEFAULT NULL,
  `end_day` date NULL DEFAULT NULL,
  `task_value` int(10) NULL DEFAULT NULL COMMENT '需要坚持的天数',
  `task_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tag` int(3) NULL DEFAULT NULL COMMENT '0:已删除任务 1：正在进行中 2：任务已完成',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of deleted_task
-- ----------------------------
INSERT INTO `deleted_task` VALUES (1, 6, '背20个单词', 7, '2022-02-03', 23, '2022-02-26', 10, NULL, 1);
INSERT INTO `deleted_task` VALUES (2, 6, '每天5杯水', 7, '2022-02-16', 6, '2022-02-22', 10, NULL, 1);
INSERT INTO `deleted_task` VALUES (3, 6, '嘿嘿', 1, '2022-02-03', 1, '2022-02-16', 1, NULL, 1);
INSERT INTO `deleted_task` VALUES (4, 6, '运动', 4, '2022-02-15', 1, '2022-02-24', 100, '无', 1);
INSERT INTO `deleted_task` VALUES (5, 6, '上王者', 4, '2022-02-01', 12, '2022-02-13', 12, '11111', 1);
INSERT INTO `deleted_task` VALUES (6, 6, '上钻石', 4, '2022-02-01', 12, '2022-02-13', 12, '11111', 1);
INSERT INTO `deleted_task` VALUES (7, 6, '中彩票', 4, '2022-02-16', 10, '2022-02-26', 10, '无积分卡等级师傅 ', 1);
INSERT INTO `deleted_task` VALUES (8, 6, '谈恋爱', 4, NULL, 100, NULL, 99, '很重要的事', 1);
INSERT INTO `deleted_task` VALUES (9, 6, '每月爬一次山', 4, '2022-02-24', 365, '2022-02-26', 23, NULL, 1);
INSERT INTO `deleted_task` VALUES (10, 6, '每月去一次电影院', 4, '2022-02-23', 100, '2023-02-01', 20, '感觉更好哦', 1);
INSERT INTO `deleted_task` VALUES (11, 6, '仰卧起坐', 4, '2022-02-24', 10, '2022-02-28', 10, '房价肯定是九分裤', 1);
INSERT INTO `deleted_task` VALUES (12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for ongoing_task
-- ----------------------------
DROP TABLE IF EXISTS `ongoing_task`;
CREATE TABLE `ongoing_task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `task_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `type_id` int(11) NULL DEFAULT NULL COMMENT '任务类型',
  `begin_day` date NULL DEFAULT NULL,
  `task_day` int(3) NULL DEFAULT NULL,
  `end_day` date NULL DEFAULT NULL,
  `task_value` int(10) NULL DEFAULT NULL COMMENT '需要坚持的天数',
  `task_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tag` int(3) NULL DEFAULT NULL COMMENT '0:已删除任务 1：正在进行中 2：任务已完成',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ongoing_task
-- ----------------------------
INSERT INTO `ongoing_task` VALUES (2, 6, '仰卧起坐', 7, '2022-02-15', 1, '2022-02-16', 10, NULL, 1);
INSERT INTO `ongoing_task` VALUES (3, 6, '背单词', 6, '2022-03-09', 12, '2022-04-04', 10, 'sad', 1);
INSERT INTO `ongoing_task` VALUES (4, 6, '换个名字', 7, '2021-12-31', 1, '2022-01-01', 10, '我就是个测试哈哈哈哈哈哈哈', 1);
INSERT INTO `ongoing_task` VALUES (5, 6, '徐梓皓', 7, '2022-01-01', 1, '2022-01-02', 10, '我是第二次测试啊', 2);
INSERT INTO `ongoing_task` VALUES (7, 7, '找个乐子', 7, '2022-02-23', 1, '2022-02-24', 10, '为自己打气，奥利给', 1);
INSERT INTO `ongoing_task` VALUES (8, 7, '找女朋友', 7, '2022-02-16', 7, '2022-02-23', 10, '很重要的事', 1);
INSERT INTO `ongoing_task` VALUES (9, 6, '哈哈大笑', 7, '2022-02-16', 10, '2022-02-23', 10, '嘿嘿', 1);
INSERT INTO `ongoing_task` VALUES (10, 6, '快乐', 7, '2022-02-23', 10, '2022-03-04', 10, '知识一个测试哦', 1);
INSERT INTO `ongoing_task` VALUES (11, 6, '礼拜四肯德基', 7, '2022-02-22', 2, '2022-02-24', 10, '吃吃吃', 1);
INSERT INTO `ongoing_task` VALUES (12, 6, '每天跑1000米', 4, '2022-02-14', 10, '2022-02-24', 10, '身体很重要', 1);
INSERT INTO `ongoing_task` VALUES (13, 6, '按时吃饭', 7, '2022-02-21', 3, '2022-02-24', 10, '活100岁', 1);
INSERT INTO `ongoing_task` VALUES (14, 6, '背20个单词', 7, '2022-02-20', 4, '2022-02-24', 10, '嘿嘿', 1);
INSERT INTO `ongoing_task` VALUES (15, 6, '每天练吉他', 7, '2022-02-21', 3, '2022-02-24', 10, '培养艺术细胞', 1);
INSERT INTO `ongoing_task` VALUES (16, 6, '12点之前睡觉', 6, '2022-02-24', 200, '2022-08-01', 20, '做个早睡的孩子啊', 1);
INSERT INTO `ongoing_task` VALUES (17, 6, '每天一点酒', 5, '2022-02-24', 30, '2022-03-24', 10, '来点微醺的感觉', 1);
INSERT INTO `ongoing_task` VALUES (18, 6, '练瑜伽', 6, '2022-02-24', 30, '2022-03-24', 14, '柔韧性需要练练', 1);
INSERT INTO `ongoing_task` VALUES (19, 6, '每天50个单词', 6, '2022-02-16', 10, '2022-02-26', 12, 'just', 2);

-- ----------------------------
-- Table structure for random_task
-- ----------------------------
DROP TABLE IF EXISTS `random_task`;
CREATE TABLE `random_task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '每天一个随机任务',
  `task_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type_id` int(11) NULL DEFAULT NULL,
  `time_date` date NULL DEFAULT NULL,
  `task_value` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of random_task
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name_zh` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_user', '普通用户');
INSERT INTO `role` VALUES (2, 'ROLE_admin', '系统管理员');
INSERT INTO `role` VALUES (4, 'ROLE_haha', '哈哈');

-- ----------------------------
-- Table structure for sys_day_finished
-- ----------------------------
DROP TABLE IF EXISTS `sys_day_finished`;
CREATE TABLE `sys_day_finished`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time_day` date NULL DEFAULT NULL,
  `count` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_day_finished
-- ----------------------------
INSERT INTO `sys_day_finished` VALUES (3, '2022-02-15', 2);
INSERT INTO `sys_day_finished` VALUES (4, '2022-02-16', 1);
INSERT INTO `sys_day_finished` VALUES (5, '2022-02-19', 10);
INSERT INTO `sys_day_finished` VALUES (6, '2022-02-17', 3);

-- ----------------------------
-- Table structure for task_type
-- ----------------------------
DROP TABLE IF EXISTS `task_type`;
CREATE TABLE `task_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of task_type
-- ----------------------------
INSERT INTO `task_type` VALUES (1, '健康', '保持健康');
INSERT INTO `task_type` VALUES (2, '学习', '学习永无止境');
INSERT INTO `task_type` VALUES (3, '思考', '学而不思则罔');
INSERT INTO `task_type` VALUES (4, '晨间', '早上做的事');
INSERT INTO `task_type` VALUES (5, '晚间', '晚上做的事');
INSERT INTO `task_type` VALUES (6, '有趣', '有意思的事情');
INSERT INTO `task_type` VALUES (7, '其他', '其他的事');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` tinyint(1) NULL DEFAULT NULL,
  `account_non_expired` tinyint(1) NULL DEFAULT NULL,
  `account_non_locked` tinyint(1) NULL DEFAULT NULL,
  `credentials_non_expired` tinyint(1) NULL DEFAULT NULL,
  `telephone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (6, 'admin', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', 1, 1, 1, 1, '18758860965');
INSERT INTO `user` VALUES (7, 'test', '$2a$10$i8cEfMdnxpIP8j7AcpR3n.m2YJL1GOEBLVfFAj35h.Bbuf8OXbplK', 1, 1, 1, 1, '18758860965');
INSERT INTO `user` VALUES (8, 'xuzihao', '$2a$10$nEt8Z5xIs.GADVdjhcki8OlqW0TmwxCoBVjYrypjVEs7fSvbeXUp.', 1, 1, 1, 1, '18758860965');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (6, 5, 1);
INSERT INTO `user_role` VALUES (7, 5, 4);
INSERT INTO `user_role` VALUES (8, 6, 2);
INSERT INTO `user_role` VALUES (9, 7, 1);

SET FOREIGN_KEY_CHECKS = 1;
