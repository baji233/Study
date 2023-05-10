/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2022-10-29 10:41:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_company
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_company
-- ----------------------------
INSERT INTO `t_company` VALUES ('1', '九云教育', '职业培训', null);
INSERT INTO `t_company` VALUES ('2', '搜狐', '互联网', '最早的新闻网站');
INSERT INTO `t_company` VALUES ('8', '阿里巴巴', '互联网', '');
INSERT INTO `t_company` VALUES ('9', '腾讯', '互联网', '');
INSERT INTO `t_company` VALUES ('10', '百度', '互联网', '');
INSERT INTO `t_company` VALUES ('11', '美团', '互联网', '');
INSERT INTO `t_company` VALUES ('12', '虎牙', '互联网', '直播平台');

-- ----------------------------
-- Table structure for t_staff
-- ----------------------------
DROP TABLE IF EXISTS `t_staff`;
CREATE TABLE `t_staff` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_staff
-- ----------------------------
INSERT INTO `t_staff` VALUES ('1', '张三', '男', '43245535', '1', null);
INSERT INTO `t_staff` VALUES ('2', '李四', '男', '4325643543', '1', null);
INSERT INTO `t_staff` VALUES ('3', '王五', '男', '437298854389', '1', null);
INSERT INTO `t_staff` VALUES ('4', '郑六', '女', '4372874398', '1', null);
