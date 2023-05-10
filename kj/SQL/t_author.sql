/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2022-10-29 09:32:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_author
-- ----------------------------
DROP TABLE IF EXISTS `t_author`;
CREATE TABLE `t_author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_author
-- ----------------------------
INSERT INTO `t_author` VALUES ('1', '张三', '13567890987', '长沙', '著名科幻小说家');
INSERT INTO `t_author` VALUES ('2', '李四', '13867456754', '湘潭', '著名玄幻小说家');
INSERT INTO `t_author` VALUES ('3', '王五', '13978900987', '株洲', '著名历史小说作家');
INSERT INTO `t_author` VALUES ('4', 'lacy', '134327897432', 'beijing', '科幻作家');
INSERT INTO `t_author` VALUES ('5', 'tom', '134327897432', 'xiangtan', '');
INSERT INTO `t_author` VALUES ('6', 'lacy', '13877778888', '长沙', '科幻作家');
INSERT INTO `t_author` VALUES ('7', 'tom', '13988887777', '长沙', '科幻作家');

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT '1' COMMENT '1:正常,0:不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('1', '流浪地球-后记', '科幻', '1', '2200年，地球环境已经不适合生存，世界所有科学家共同将地球打造为巨型宇宙飞船。。。', '1');
INSERT INTO `t_book` VALUES ('2', '至尊王权', '玄幻', '2', null, '0');
INSERT INTO `t_book` VALUES ('3', '明朝那些年', '历史', '3', '穿越回明朝', '1');
INSERT INTO `t_book` VALUES ('4', 'Think In Java', '学术', '4', 'java经典书籍，必读', '1');
