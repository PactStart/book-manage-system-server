/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50737
Source Host           : localhost:3306
Source Database       : book_system

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-02-04 20:07:02
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='书籍';

-- ----------------------------
-- Table structure for book_isbn
-- ----------------------------
DROP TABLE IF EXISTS `book_isbn`;
CREATE TABLE `book_isbn` (
  `isbn` varchar(16) NOT NULL COMMENT '国际标准书号',
  `book_id` int(11) NOT NULL COMMENT '书的id',
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='图书分类';

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `phone` char(11) NOT NULL COMMENT '电话',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `create_at` datetime NOT NULL COMMENT '创建日期',
  `update_at` datetime NOT NULL COMMENT '更新日期',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='管理员';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `phone` char(11) NOT NULL COMMENT '电话',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `create_at` datetime NOT NULL COMMENT '创建日期',
  `update_at` datetime NOT NULL COMMENT '更新日期',
  `del` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Table structure for user_borrow_log
-- ----------------------------
DROP TABLE IF EXISTS `user_borrow_log`;
CREATE TABLE `user_borrow_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `book_id` int(11) NOT NULL COMMENT '书籍id',
  `isbn` varchar(16) NOT NULL COMMENT '图书编号',
  `borrow_at` datetime NOT NULL COMMENT '借书日期',
  `borrow_days` int(11) NOT NULL COMMENT '约定借书天数',
  `is_return` bit(1) NOT NULL COMMENT '是否归还',
  `return_at` datetime NOT NULL COMMENT '归还日期',
  `over_days` int(11) NOT NULL COMMENT '截止日期',
  `fine` decimal(10,1) NOT NULL COMMENT '罚金',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='用户借书记录';
