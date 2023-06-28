/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : shtp

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 28/06/2023 16:05:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `admin_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `admin_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员名称',
  `admin_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', '888888');

-- ----------------------------
-- Table structure for t_chat
-- ----------------------------
DROP TABLE IF EXISTS `t_chat`;
CREATE TABLE `t_chat`  (
  `chat_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '一条消息的id',
  `u_id` int(0) NOT NULL COMMENT '发送方用户id',
  `f_id` int(0) NOT NULL COMMENT '接收方用户id',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '聊天内容',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '聊天时间戳',
  PRIMARY KEY (`chat_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_chat
-- ----------------------------
INSERT INTO `t_chat` VALUES (1, 1, 4, '这个怎么买', '1687879326');
INSERT INTO `t_chat` VALUES (2, 2, 4, '可以便宜点吗', '1687829326');
INSERT INTO `t_chat` VALUES (3, 3, 1, '你买的这个', '1682879326');
INSERT INTO `t_chat` VALUES (4, 9, 11, '现在买什么时候发货', '1687879326');
INSERT INTO `t_chat` VALUES (5, 3, 10, '包邮吗', '1687878326');
INSERT INTO `t_chat` VALUES (6, 2, 3, '有运费险吗', '1688275321');
INSERT INTO `t_chat` VALUES (7, 5, 9, '可最多可以便宜多少', '1637879326');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `goods_id` int(0) NOT NULL COMMENT '宝贝id',
  `user_id` int(0) NOT NULL COMMENT '评论的用户id',
  `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '评论的内容',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '评论时间戳',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES (1, 1, 3, '有点坑兄弟们不要上当', '1687823445');
INSERT INTO `t_comment` VALUES (2, 5, 11, '非常不错实物和图片一模一样', '1687872213');
INSERT INTO `t_comment` VALUES (3, 4, 7, '买回来没用多久就坏了', '1687871226');

-- ----------------------------
-- Table structure for t_goods_user
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_user`;
CREATE TABLE `t_goods_user`  (
  `goods_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '宝贝id',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '宝贝名称',
  `user_id` int(0) NOT NULL COMMENT '宝贝所属的用户id',
  `describe` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `picture_url` varchar(9999) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图片url (用逗号分隔)',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分类',
  `price` decimal(10, 2) NOT NULL COMMENT '价格',
  `recommend` int(0) DEFAULT NULL COMMENT '是否推荐 (1是/0否)',
  `status` int(0) DEFAULT NULL COMMENT '宝贝状态 (-1审核失败/0审核中/1正常/2下架)',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '宝贝上架时间',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods_user
-- ----------------------------
INSERT INTO `t_goods_user` VALUES (1, '苹果iPhone14', 1, '9成新, 可小刀', 'https://gd4.alicdn.com/imgextra/i4/2208892152540/O1CN01tnxzjK1UdMmmt5nC0_!!2208892152540.jpg,https://gd3.alicdn.com/imgextra/i3/2208892152540/O1CN01TjuciT1UdMmqLrzkg_!!2208892152540.png', '手机', 4000.00, 1, 1, '1687326544');
INSERT INTO `t_goods_user` VALUES (2, '华为 P40 Pro', 2, '8成新', 'https://gd1.alicdn.com/imgextra/i1/2200631747641/O1CN01ugSpk126JdApETqms_!!2200631747641.jpg,https://gd4.alicdn.com/imgextra/i4/2200631747641/O1CN01tq8gam26JdApnw6Ye_!!2200631747641.jpg,https://gd1.alicdn.com/imgextra/i1/2200631747641/O1CN01ofueLb26JdApnyS77_!!2200631747641.jpg,https://gd3.alicdn.com/imgextra/i3/2200631747641/O1CN01uGe5Ah26JdApEUWNM_!!2200631747641.jpg', '手机', 2780.00, 1, 0, '1687234442');
INSERT INTO `t_goods_user` VALUES (3, '华为 nova 6', 3, '5成新,可大刀', 'https://gd2.alicdn.com/imgextra/i4/3392500206/O1CN01s2Qm4V1DOOQbe5bTs_!!3392500206.jpg,https://gd3.alicdn.com/imgextra/i3/3392500206/O1CN012jEdlz1DOOQW1TiVM_!!3392500206.jpg,https://gd4.alicdn.com/imgextra/i4/3392500206/O1CN01hjFcUR1DOOQZWDcC8_!!3392500206.jpg,https://gd2.alicdn.com/imgextra/i2/3392500206/O1CN018VOLZP1DOOQUkrHiC_!!3392500206.jpg', '手机', 3549.00, 0, 1, '1687670442');
INSERT INTO `t_goods_user` VALUES (4, '华为 P30', 4, '9成新,可小刀', 'https://gd1.alicdn.com/imgextra/i3/3392500206/O1CN01A7wbNb1DOOQi5Hng8_!!3392500206.jpg,https://gd2.alicdn.com/imgextra/i2/3392500206/O1CN015g2nW21DOOPeKaiWO_!!3392500206.jpg,https://gd1.alicdn.com/imgextra/i1/3392500206/O1CN0118maoI1DOOQG57QT5_!!3392500206.jpg,https://gd1.alicdn.com/imgextra/i1/3392500206/O1CN015RMUfi1DOOQE8UaLU_!!3392500206.jpg', '手机', 2899.00, 1, 1, '1687880442');
INSERT INTO `t_goods_user` VALUES (5, '修身短袖', 5, '7成新', 'https://img.alicdn.com/imgextra/i3/2177391090/O1CN01jHVjzk1JvGYpu6npn_!!2177391090.jpg,https://img.alicdn.com/imgextra/i2/2177391090/O1CN01AldPpL1JvGYy1Cgah_!!2177391090.jpg,https://img.alicdn.com/imgextra/i1/2177391090/O1CN01gfBsxr1JvGYqZrhuq_!!2177391090.jpg', '衣服', 35.00, 1, 0, '1687880442');
INSERT INTO `t_goods_user` VALUES (6, '冰丝运动裤', 6, '9成新', 'https://img.alicdn.com/bao/uploaded/i3/677608399/O1CN01qRmpnn2BunOS9biIy_!!677608399.jpg,https://img.alicdn.com/imgextra/i2/677608399/O1CN01WHCFzI2BunK3pRN0M_!!677608399.jpg,https://img.alicdn.com/imgextra/i2/677608399/O1CN01cnddzz2BunOSlBgGR_!!677608399.jpg', '裤子', 65.00, 1, 1, '1687320442');
INSERT INTO `t_goods_user` VALUES (7, '遥控汽车', 7, '8成新', 'https://gd2.alicdn.com/imgextra/i4/2540603778/O1CN016Biw5G1dmN6Imy8NH_!!2540603778.jpg,https://gd2.alicdn.com/imgextra/i2/2540603778/O1CN01zL1B4E1dmN4wgLjhF_!!2540603778.jpg,https://gd3.alicdn.com/imgextra/i3/2540603778/O1CN01V9YaWZ1dmN0YnPEVM_!!2540603778.jpg,https://gd2.alicdn.com/imgextra/i2/2540603778/O1CN01APucQU1dmN0Y324By_!!2540603778.jpg', '玩具', 288.00, 0, 0, '1687880442');
INSERT INTO `t_goods_user` VALUES (8, '999纯银手镯', 8, '9成新', 'https://img.alicdn.com/imgextra/i4/864514300/O1CN01CdSxt91hdRujNnrsk_!!864514300.jpg,https://img.alicdn.com/imgextra/i4/864514300/O1CN01XcCV7z1hdRunVvmep_!!864514300.jpg,https://img.alicdn.com/imgextra/i2/864514300/O1CN010FL3vj1hdRuhVUgdM_!!864514300.jpg,https://img.alicdn.com/imgextra/i4/864514300/O1CN01cohqvD1hdRufht8Ig_!!864514300.jpg', '装饰', 369.00, 1, 1, '1687854442');
INSERT INTO `t_goods_user` VALUES (9, '智能手环', 9, '9成新,可小刀', 'https://gd4.alicdn.com/imgextra/i2/2215560912195/O1CN01ISlD9T1S5MDVN6sC5_!!2215560912195-0-picasso.jpg,https://gd4.alicdn.com/imgextra/i4/2215560912195/O1CN01FaToMm1S5MBmtTH9p_!!2215560912195.jpg,https://gd3.alicdn.com/imgextra/i3/2215560912195/O1CN01un1c8J1S5MBmUG7Da_!!2215560912195.jpg,https://gd3.alicdn.com/imgextra/i3/2215560912195/O1CN01NZjh5B1S5MBszqoBs_!!2215560912195.jpg', '手表', 128.00, 1, 1, '1687233442');
INSERT INTO `t_goods_user` VALUES (10, '海尔冰箱', 10, '6成新,可小刀', 'https://gd3.alicdn.com/imgextra/i2/649882266/O1CN01q9SDs81SbsGmfKOdc_!!649882266.jpg,https://gd3.alicdn.com/imgextra/i3/649882266/O1CN01RsNxja1SbsGlYIVlJ_!!649882266.jpg,https://gd3.alicdn.com/imgextra/i3/649882266/O1CN01RsNxja1SbsGlYIVlJ_!!649882266.jpg,https://gd4.alicdn.com/imgextra/i4/649882266/O1CN01u9arTz1SbsGh97Dx4_!!649882266.jpg,https://gd1.alicdn.com/imgextra/i1/649882266/O1CN01MVAKCN1SbsGdNDNaH_!!649882266.jpg', '家电', 2659.00, 1, 1, '1682130442');
INSERT INTO `t_goods_user` VALUES (11, '伊南电风扇台式', 11, '5成新,可小刀', 'https://img.alicdn.com/imgextra/i1/2824570903/O1CN01nFA2ep1IXcSSQKnuG_!!2824570903.jpg,https://img.alicdn.com/imgextra/i1/2824570903/O1CN01GwxYS61IXcUO8fRF8_!!2824570903.jpg,', '家电', 233.00, 0, 1, '1687322342');
INSERT INTO `t_goods_user` VALUES (12, '手持迷你风扇', 12, '9成新', 'https://img.alicdn.com/imgextra/i4/2212334096204/O1CN01czgQF31vhU1741i1K_!!2212334096204.jpg,https://img.alicdn.com/imgextra/i3/2212334096204/O1CN01R689G91vhU1ZLUX7k_!!2212334096204.jpg,https://img.alicdn.com/imgextra/i2/2212334096204/O1CN01O0cdnY1vhU0JjWZe2_!!2212334096204.jpg,https://img.alicdn.com/imgextra/i2/2212334096204/O1CN011yaMhb1vhU0MviSbh_!!2212334096204.jpg', '家电', 25.00, 1, 0, '1687884232');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `order_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单唯一值 (供客户查询)',
  `goods_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '宝贝id (用逗号分隔)',
  `goods_count` int(0) NOT NULL COMMENT '宝贝数量',
  `order_amount_total` decimal(10, 0) NOT NULL COMMENT '实际付款金额',
  `logistics_fee` decimal(10, 0) DEFAULT NULL COMMENT '运费金额',
  `order_status` int(0) NOT NULL COMMENT '0未付款,1已付款,2已发货,3已签收,-1退货申请,-2退货中,-3已退货,-4取消交易',
  `address` varchar(999) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收货地址',
  `pay_channel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '订单支付渠道',
  `escrow_tradeno` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '订单支付单号',
  `order_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '下单时间',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (1, 'asdfajfqf125479958445', '1', 1, 4000, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `t_order` VALUES (2, 'asdaf1231o12312112312', '4', 2, 6800, NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `t_order` VALUES (3, 'sdfjsndf123344jiib13134', '8', 1, 369, NULL, 2, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户昵称',
  `user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `head_url` varchar(999) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像',
  `my_favorite` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '我收藏的宝贝id  (用逗号分隔)',
  `chat_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '聊天表的chat_id (用逗号分隔)',
  `ship_address` varchar(999) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '收获地址 (用逗号分隔)',
  `credit` int(0) DEFAULT NULL COMMENT '信用值 (1-100)',
  `login_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '登录时间',
  `logout_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '退出时间 ',
  `status` int(0) DEFAULT NULL COMMENT '登录状态 (1在线/0下线/-1封禁)',
  `pay` decimal(10, 0) DEFAULT NULL COMMENT '账户余额',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
INSERT INTO `t_user_info` VALUES (1, '李响', '1232344', '男', '1223112312@qq.com', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2Fa582933e-8aa0-4b16-bbfd-f7f48a78236b%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1690392815&t=75c7659ef946c1d50bad5e433e7cb22a', '1,2', NULL, NULL, 100, '1687333332', '1682880442', 1, 1000);
INSERT INTO `t_user_info` VALUES (2, '李四', '12445322', '男', '1298475935@qq.com', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2F5b342386-43ce-4ab5-bf30-c1bb7e2d85d8%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1690440693&t=eb3c2f252ed8b5e834c4c712b382c265', '3', NULL, NULL, 56, '1687822222', '1681880442', 1, 200);
INSERT INTO `t_user_info` VALUES (3, '张三', '213434', '男', '1283756193@qq.com', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202006%2F14%2F20200614201754_UdLFQ.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1690440790&t=93cdde2fad464c97cbbe22fa8abad4b4', '5,6', NULL, NULL, 100, '1687880442', '1687880442', 1, NULL);
INSERT INTO `t_user_info` VALUES (4, '李华', '4333422', '女', '1471346813@qq.com', 'https://c-ssl.dtstatic.com/uploads/item/202008/04/20200804114535_dLa2X.thumb.1000_0.jpeg', '7,8,2', NULL, NULL, 90, '1687214221', '1687843356', 1, 9999);
INSERT INTO `t_user_info` VALUES (5, '小花', '1312311', '女', '1212412112@qq.com', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202003%2F09%2F20200309182842_FaPBY.thumb.1000_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1690440972&t=610ee8e1e7cd97c86a9067268b2d9d75', '9,10', NULL, NULL, 85, '1687222421', '1687980442', 0, 100);
INSERT INTO `t_user_info` VALUES (6, '翠花', '1234432', '女', '4587965878@qq.com', 'https://up.enterdesk.com/edpic/69/da/60/69da608c3daf05186c30bc0b5d09ca3d.jpg', '10,11', NULL, NULL, 20, '1621330442', '1678870442', 1, NULL);
INSERT INTO `t_user_info` VALUES (7, '高翔', '14143311', '男', '1724687134@qq.com', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202003%2F31%2F20200331000349_odinr.thumb.1000_0.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1690440972&t=4f4e3ea74dca6385147364878a1e1be7', '11,12', NULL, NULL, 79, '1687880442', '1687880442', 0, 50);
INSERT INTO `t_user_info` VALUES (8, '王军', '138413414', '男', '1471184611@qq.com', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202002%2F26%2F20200226204448_sZSun.thumb.1000_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1690440972&t=710257e27abad79eababd7f4fa275f93', '1,4,5', NULL, NULL, 40, '1682232242', '1687880442', 1, 600);
INSERT INTO `t_user_info` VALUES (9, '欧阳休', '1231414124', '男', '1487612412@qq.com', 'https://c-ssl.dtstatic.com/uploads/item/201907/19/20190719003223_NwVtT.thumb.1000_0.jpeg', '6,12', NULL, NULL, 50, '1682354421', '1647880442', 1, 3000);
INSERT INTO `t_user_info` VALUES (10, '杨明', '1231241241', '男', '7361874141@qq.com', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202005%2F13%2F20200513100254_rksej.thumb.1000_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1690441237&t=8486dd0c5c916b22b37ad0eebd38667b', '7,4,9,11', NULL, NULL, 100, '1687834555', '1687880442', 0, 400);
INSERT INTO `t_user_info` VALUES (11, '李昌', '1231232', '男', '1217124111@qq.com', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fblog%2F202107%2F19%2F20210719011558_492d2.thumb.1000_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1690441237&t=524587a5c57a7b2fce47a3688941d43b', '7,4,3', NULL, NULL, 10, '1682322132', '1987880442', 1, 80000);

SET FOREIGN_KEY_CHECKS = 1;
