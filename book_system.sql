/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50737
Source Host           : localhost:3306
Source Database       : book_system

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-02-16 14:23:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(100) NOT NULL COMMENT '书籍名称',
  `pinyin` varchar(100) NOT NULL,
  `pinyin_abbr` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL COMMENT '书籍作者',
  `pub` varchar(100) NOT NULL COMMENT '出版日期',
  `category_id` int(11) NOT NULL COMMENT '类别Id',
  `inventory` int(11) NOT NULL COMMENT '库存',
  `remain_inventory` int(11) NOT NULL COMMENT '剩余库存',
  `create_at` datetime NOT NULL COMMENT '创建日期',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `update_at` datetime NOT NULL COMMENT '更新日期',
  `update_by` int(11) NOT NULL COMMENT '更新者',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='书籍';

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '', '宇宙超度指南', 'yuzhouchaoduzhinan', 'YZCDZN', '李诞2', '笑果文化2', '0', '2', '2', '2022-02-14 07:18:44', '1', '2022-02-14 07:18:51', '1', '\0');
INSERT INTO `book` VALUES ('5', '', '斗罗大陆', 'douluodalu', 'DLDL', '唐家三少2', '阅文集团2', '0', '4', '3', '2022-02-16 08:14:42', '1', '2022-02-16 08:14:42', '1', '\0');
INSERT INTO `book` VALUES ('6', '', '完美世界', 'wanmeishijie', 'WMSJ', '天蚕土豆', '阅文集团', '0', '0', '0', '2022-02-16 08:15:59', '1', '2022-02-16 08:15:59', '1', '\0');

-- ----------------------------
-- Table structure for book_isbn
-- ----------------------------
DROP TABLE IF EXISTS `book_isbn`;
CREATE TABLE `book_isbn` (
  `isbn` varchar(16) NOT NULL COMMENT '国际标准书号',
  `book_id` int(11) NOT NULL COMMENT '书的id',
  `is_borrowed` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否借出',
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of book_isbn
-- ----------------------------
INSERT INTO `book_isbn` VALUES ('d1', '5', '\0');
INSERT INTO `book_isbn` VALUES ('d2', '5', '');
INSERT INTO `book_isbn` VALUES ('d3', '5', '\0');
INSERT INTO `book_isbn` VALUES ('d4', '5', '\0');
INSERT INTO `book_isbn` VALUES ('haha', '1', '\0');
INSERT INTO `book_isbn` VALUES ('haha2', '1', '\0');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `name` varchar(100) NOT NULL COMMENT '分类名称',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '父类id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='图书分类';

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '分类1', '1', '0');
INSERT INTO `category` VALUES ('2', '分类2', '2', '0');
INSERT INTO `category` VALUES ('3', '分类3', '3', '0');
INSERT INTO `category` VALUES ('4', '分类1-1', '1', '1');
INSERT INTO `category` VALUES ('5', '分类1-2', '2', '1');
INSERT INTO `category` VALUES ('6', '分类1-3', '3', '1');
INSERT INTO `category` VALUES ('7', '分类2-1', '1', '2');
INSERT INTO `category` VALUES ('8', '分类2-2', '2', '2');
INSERT INTO `category` VALUES ('9', '分类3-1', '1', '3');
INSERT INTO `category` VALUES ('10', '分类3-1-1', '1', '9');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `avatar` varchar(255) NOT NULL DEFAULT '' COMMENT '头像',
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `phone` char(11) NOT NULL COMMENT '电话',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `create_at` datetime NOT NULL COMMENT '创建日期',
  `update_at` datetime NOT NULL COMMENT '更新日期',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='管理员';

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', '朱雅洁32', '', '12032@qq.com', '1500', '123456', '2022-02-11 08:35:56', '2022-02-11 08:35:59', '\0');
INSERT INTO `manager` VALUES ('3', 'wangwu', '', '120@qq.com', '120', '123456', '2022-02-15 12:11:35', '2022-02-15 12:11:35', '\0');
INSERT INTO `manager` VALUES ('4', '赵六', '', '120asd', '110', '123456', '2022-02-15 12:53:40', '2022-02-15 12:53:40', '\0');
INSERT INTO `manager` VALUES ('5', 'ha222222', '', 'sdasdfa', 'asfa', 'asdfasd', '2022-02-15 12:55:08', '2022-02-15 12:55:08', '\0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `phone` char(11) NOT NULL COMMENT '电话',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `create_at` datetime NOT NULL COMMENT '创建日期',
  `update_at` datetime NOT NULL COMMENT '更新日期',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', 'zhangsan@gmail.com', '110000', '123456', '2022-02-15 08:58:38', '2022-02-15 08:58:40', '\0');
INSERT INTO `user` VALUES ('2', 'lisi', 'lisi@gmail.com', '120', '123456', '2022-02-15 08:58:38', '2022-02-15 08:58:40', '\0');
INSERT INTO `user` VALUES ('13', 'zhaoliu', 'asdfas', 'asdfa', '1asfd', '2022-02-15 14:33:26', '2022-02-15 14:33:26', '\0');

-- ----------------------------
-- Table structure for user_borrow_log
-- ----------------------------
DROP TABLE IF EXISTS `user_borrow_log`;
CREATE TABLE `user_borrow_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `book_id` int(11) NOT NULL COMMENT '书籍id',
  `isbn` varchar(16) NOT NULL COMMENT '图书编号',
  `borrow_at` datetime NOT NULL COMMENT '借书日期',
  `borrow_days` int(11) NOT NULL COMMENT '约定借书天数',
  `is_return` bit(1) NOT NULL COMMENT '是否归还',
  `return_at` datetime NOT NULL COMMENT '归还日期',
  `over_days` int(11) NOT NULL COMMENT '超时天数',
  `fine` decimal(10,1) NOT NULL COMMENT '罚金',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户借书记录';

-- ----------------------------
-- Records of user_borrow_log
-- ----------------------------
INSERT INTO `user_borrow_log` VALUES ('1', '1', 'zhangsan', '1', 'haha', '2022-02-15 09:59:44', '7', '\0', '2022-02-15 10:39:04', '0', '0.0');
INSERT INTO `user_borrow_log` VALUES ('2', '2', 'lisi', '1', 'haha2', '2022-02-15 09:59:44', '7', '', '2022-02-15 09:59:52', '0', '1.0');
INSERT INTO `user_borrow_log` VALUES ('6', '13', 'zhaoliu', '5', 'd2', '2022-02-16 14:03:10', '7', '\0', '2022-02-16 14:03:10', '0', '0.0');
