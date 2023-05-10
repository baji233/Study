/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2022-10-28 14:58:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=316 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', 'Jack', '计算机', '男', '20', '长沙');
INSERT INTO `t_student` VALUES ('2', 'tom', '计算机', '男', '19', '湘潭');
INSERT INTO `t_student` VALUES ('3', 'lacy', '计算机', '女', '20', '华盛顿');
INSERT INTO `t_student` VALUES ('4', 'mary', '金融', '女', '17', '纽约');
INSERT INTO `t_student` VALUES ('5', 'mark', '计算机', '男', '20', '洛杉矶');
INSERT INTO `t_student` VALUES ('6', '黄蓉', '软件工程', '女', '19', '长沙');
INSERT INTO `t_student` VALUES ('7', '张三', '历史', '男', '18', '湘潭');
INSERT INTO `t_student` VALUES ('8', '王五', '计算机', '男', '18', '长沙');
INSERT INTO `t_student` VALUES ('9', '郑六', '计算机', '男', '19', '长沙');
INSERT INTO `t_student` VALUES ('10', '刘德华', '土木工程', '男', '19', '长沙');
INSERT INTO `t_student` VALUES ('11', '关羽', '金融', '男', '32', '枣庄');
INSERT INTO `t_student` VALUES ('12', '郭靖', '计算机', '男', '20', '襄阳');
INSERT INTO `t_student` VALUES ('13', '黄药师', '财经', '男', '29', '桃花岛');
INSERT INTO `t_student` VALUES ('14', '周伯通', '财经', '男', '29', '昆明');
INSERT INTO `t_student` VALUES ('15', '欧阳锋', '金融', '男', '39', '新疆');
INSERT INTO `t_student` VALUES ('16', '梅超风', '财经', '女', '21', '厦门');
INSERT INTO `t_student` VALUES ('17', '洪七公', '财经', '男', '29', '太原');
INSERT INTO `t_student` VALUES ('18', '郭襄', '计算机', '女', '16', '襄阳');
INSERT INTO `t_student` VALUES ('19', '杨过', '计算机', '男', '19', '太原');
INSERT INTO `t_student` VALUES ('20', '郭芙', '会计', '女', '19', '襄阳');
INSERT INTO `t_student` VALUES ('21', '亚瑟', '财经', '男', '29', '桃花岛');
INSERT INTO `t_student` VALUES ('22', '曜', '计算机', '男', '19', '昆明');
INSERT INTO `t_student` VALUES ('23', '李白', '金融', '男', '39', '新疆');
INSERT INTO `t_student` VALUES ('24', '安其拉', '财经', '女', '21', '厦门');
INSERT INTO `t_student` VALUES ('25', '亚索', '财经', '男', '29', '太原');
INSERT INTO `t_student` VALUES ('26', '露露', '计算机', '女', '16', '襄阳');
INSERT INTO `t_student` VALUES ('27', '卡扎克', '计算机', '男', '19', '太原');
INSERT INTO `t_student` VALUES ('28', 'tom', '计算机', '男', '19', '长沙');
INSERT INTO `t_student` VALUES ('29', 'tom', '计算机', '男', '19', '长沙');
INSERT INTO `t_student` VALUES ('30', '李靖', '计算机', '男', '19', '陈塘关');
INSERT INTO `t_student` VALUES ('200', '张三', '计算机', '男', '17', '长沙');
INSERT INTO `t_student` VALUES ('201', '李四', '金融', '男', '19', '湘潭');
INSERT INTO `t_student` VALUES ('202', '杨过', '计算机', '男', '19', '襄阳');
INSERT INTO `t_student` VALUES ('208', '张飞', '计算机', '男', '19', '燕国');
INSERT INTO `t_student` VALUES ('209', '马超', '金融', '男', '18', '西凉');
INSERT INTO `t_student` VALUES ('216', '田七', '软件工程', '男', '19', 'changsha');
INSERT INTO `t_student` VALUES ('217', '哪吒', '计算机', '男', '18', '东海');
INSERT INTO `t_student` VALUES ('219', '李靖', '管理', '男', '1100', '陈塘关');
INSERT INTO `t_student` VALUES ('300', '李连杰', '武术', '男', '29', '嵩山');
INSERT INTO `t_student` VALUES ('302', '张三', '计算机', '男', '19', '湘潭');
INSERT INTO `t_student` VALUES ('303', '李四', '计算机', '女', '19', '湘潭');
INSERT INTO `t_student` VALUES ('304', '王五', '会计', '男', '19', '南昌');
INSERT INTO `t_student` VALUES ('305', '郑六', '计算机', '女', '19', '长沙');
INSERT INTO `t_student` VALUES ('306', '田七', '金融', '男', '19', '湘潭');
INSERT INTO `t_student` VALUES ('308', '李四', '计算机', '女', '19', '湘潭');
INSERT INTO `t_student` VALUES ('313', '鲁智深', '计算机', '男', '40', '关西');
INSERT INTO `t_student` VALUES ('314', 'mark', '计算机', '男', '19', '长沙');
INSERT INTO `t_student` VALUES ('315', 'tom', '计算机', '男', '18', '南昌');
