/*
Navicat MySQL Data Transfer

Source Server         : a
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : gd1

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2022-09-27 20:18:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cartIt` int(11) NOT NULL AUTO_INCREMENT,
  `cUserId` int(11) DEFAULT NULL,
  `cShopId` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`cartIt`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('1', null, '5', '1');
INSERT INTO `cart` VALUES ('2', '1', '6', '1');
INSERT INTO `cart` VALUES ('3', '1', '6', '1');
INSERT INTO `cart` VALUES ('4', '1', '5', '1');
INSERT INTO `cart` VALUES ('5', '1', '5', '55');
INSERT INTO `cart` VALUES ('6', '1', '5', '1');
INSERT INTO `cart` VALUES ('7', '1', '5', '1');
INSERT INTO `cart` VALUES ('8', '1', '5', '1');
INSERT INTO `cart` VALUES ('9', '1', '5', '1');
INSERT INTO `cart` VALUES ('10', '1', '5', '1');

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shopId` int(11) NOT NULL AUTO_INCREMENT,
  `shopName` varchar(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `syt` int(11) DEFAULT NULL,
  PRIMARY KEY (`shopId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', '高跟鞋', '99', null, '阿斯蒂芬', '2', '1');
INSERT INTO `shop` VALUES ('2', '皮鞋', '88', null, '阿斯蒂芬', '2', '1');
INSERT INTO `shop` VALUES ('3', '拖鞋', '66', null, '撒旦法', '2', '1');
INSERT INTO `shop` VALUES ('4', 'T恤', '88', null, '撒旦法', '1', null);
INSERT INTO `shop` VALUES ('5', '辣条', '100', null, '发过火', '5', '1');
INSERT INTO `shop` VALUES ('6', '遥控汽车', '888', null, '撒旦法', '4', '1');

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(20) DEFAULT NULL,
  `syt` int(11) DEFAULT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '衣服', '1');
INSERT INTO `type` VALUES ('2', '鞋子', null);
INSERT INTO `type` VALUES ('3', '帽子', null);
INSERT INTO `type` VALUES ('4', '玩具', null);
INSERT INTO `type` VALUES ('5', '零食', null);
INSERT INTO `type` VALUES ('6', '鱼竿', '1');
INSERT INTO `type` VALUES ('7', '手套', null);
INSERT INTO `type` VALUES ('8', '书籍', '1');
INSERT INTO `type` VALUES ('9', '电脑', '1');
INSERT INTO `type` VALUES ('10', '手机', '1');
INSERT INTO `type` VALUES ('11', '家具', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `myname` varchar(30) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '138', '超级管理员', '18');
INSERT INTO `user` VALUES ('2', 'ttt', 'ttt', '139', '涵涵', '33');
INSERT INTO `user` VALUES ('3', null, null, null, null, null);
INSERT INTO `user` VALUES ('4', null, null, null, null, null);
INSERT INTO `user` VALUES ('5', '3', '3', '3', null, null);
INSERT INTO `user` VALUES ('6', '3', '3', '3', null, null);
