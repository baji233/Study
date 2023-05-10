/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : floorposh

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2022-04-21 13:31:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `afteruser`
-- ----------------------------
DROP TABLE IF EXISTS `afteruser`;
CREATE TABLE `afteruser` (
  `userId` int(100) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `permissions` int(100) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of afteruser
-- ----------------------------
INSERT INTO `afteruser` VALUES ('1', 'jay', '111', '1');

-- ----------------------------
-- Table structure for `cd`
-- ----------------------------
DROP TABLE IF EXISTS `cd`;
CREATE TABLE `cd` (
  `cdId` int(10) NOT NULL AUTO_INCREMENT,
  `cdname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cdId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cd
-- ----------------------------
INSERT INTO `cd` VALUES ('1', '产品管理');
INSERT INTO `cd` VALUES ('2', '店铺管理');
INSERT INTO `cd` VALUES ('3', '工程管理');
INSERT INTO `cd` VALUES ('4', '信息管理');
INSERT INTO `cd` VALUES ('5', '加盟管理');
INSERT INTO `cd` VALUES ('6', '联系管理');
INSERT INTO `cd` VALUES ('10', '薪酬发放管理');
INSERT INTO `cd` VALUES ('11', '人力资源');
INSERT INTO `cd` VALUES ('12', '薪酬登记管理');

-- ----------------------------
-- Table structure for `contact`
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `ctxtId` int(100) NOT NULL AUTO_INCREMENT,
  `ctxtcompany` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `ctxtname` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `ctxttel` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `ctxtaddress` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `ctxtcontent` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ctime` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `cstate` int(100) DEFAULT NULL,
  PRIMARY KEY (`ctxtId`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES ('43', '甲方公司', '谢小傲', '2646648067@qq.com', 'xxx五一广场', '看上了你的木板', '2022-04-18 12:11:16', '1');
INSERT INTO `contact` VALUES ('45', '九华木板有限公司', '谢文', '2646648067qq.com', '九华吉利社区', '你们家的木板不错', '2022-04-18 12:15:04', null);
INSERT INTO `contact` VALUES ('46', '梵蒂冈有限公司', '小明', '2646648067@qq.com', '长沙市', '我是装修公司的希望合作', '2022-04-18 12:16:45', null);
INSERT INTO `contact` VALUES ('47', '形成的公司', '谢文', '2646648067@qq.com', '长沙市', '风格的华国锋', '2022-04-18 12:19:36', null);
INSERT INTO `contact` VALUES ('48', '蒂冈公司', '谢大文', '2646648067@qq.com', '法国巴黎', '你们家的地板很good', '2022-04-18 12:22:11', null);
INSERT INTO `contact` VALUES ('49', '九云', '谢文', '2646648067@qq.com', '的订单是否', '撒大苏打', '2022-04-18 14:09:39', null);

-- ----------------------------
-- Table structure for `erji`
-- ----------------------------
DROP TABLE IF EXISTS `erji`;
CREATE TABLE `erji` (
  `erjiId` int(11) NOT NULL AUTO_INCREMENT,
  `erjiname` varchar(20) DEFAULT NULL,
  `cdid` int(11) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`erjiId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of erji
-- ----------------------------
INSERT INTO `erji` VALUES ('1', '产品信息', '1', 'views/users.html');
INSERT INTO `erji` VALUES ('2', '店铺信息', '2', 'views/store.html');
INSERT INTO `erji` VALUES ('3', '工程信息', '3', 'views/project.html');
INSERT INTO `erji` VALUES ('4', '信息操作', '4', 'views/message.html');
INSERT INTO `erji` VALUES ('5', '加盟信息', '5', 'views/Tojoinin.html');
INSERT INTO `erji` VALUES ('6', '联系信息', '6', 'views/relation.html');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `messageId` int(100) NOT NULL AUTO_INCREMENT,
  `messageName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mtime` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `detailed` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` int(100) DEFAULT NULL,
  PRIMARY KEY (`messageId`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('29', '为什么说家有老人和小孩，木地板是首选？', '根据调查显示，1-5岁儿童意外伤害发生率最高，比较活泼好动，易发生意外伤害的场所是家里', '2022-04-17', ' 相对而言，地板没有瓷砖那么的容易打滑，但是也并不是所有的地板都防滑。为了不让地面成为家人的“溜冰场”，细心的第一印象地板，承载亿万消费用户追求安全舒适、环保天然的生活理想，将木地板表面做防滑处理，同时增加了木地板的防潮与耐磨性，不仅让保障了使用时的安全性，也大大的增强了木地板的使用寿命。\n', '1');
INSERT INTO `message` VALUES ('30', '木地板到底会不会长虫？', '成品的实木地板外要进行油漆工程 即使没有杀死虫子 也会因为没有空气窒息而亡', '2022-04-17', '由于家庭装修过程中会用到很多木工板、刨花板等材料，还有许多木质结构的家具，遇到合适的温度、湿度，再加上加工之前没有经过专业的除虫处理，都很容易长虫子。\n铺装实木地板需要使用龙骨，木龙骨通常没有经过高温加工，很可能留下虫子或虫卵的隐患，潮湿和温度适宜的时候就可能遭到虫子的侵蚀，并殃及到地板。而虫子最容易破坏的就是木材，那么木地板就会成为虫子首要侵害的对象。所以我们应该在地板出现虫子时，首先要弄清楚虫子到底是从哪来，只有弄清楚了原因，才能有效除虫。还有一种现象是，虫子确实是从地板下钻出来的', '1');
INSERT INTO `message` VALUES ('31', '踢脚线，是装修时有什么作用？', ' 装修的时候，我们往往都把注意力放在大宗物品上面去', '2022-04-17', '第一：装饰墙面，有着维持视觉平衡的作用，利用它们的线形感觉及材质、色彩等在室内相互呼应，可以起到较好的美化装饰效果。\n第二：保护作用，可以更好地使墙体和地面之间结合牢固，减少墙体变形，避免外力碰撞造成破坏。\n第三：踢脚线也比较容易擦洗，如果拖地溅上脏水，擦洗非常方便。', '1');
INSERT INTO `message` VALUES ('32', '潮湿地区如何做好木地板防潮工作？', '选购实木地板时首先就要注意其树种性能，比如柚木地板', '2022-04-17', '1、在实木地板安装的过程中，应选择木龙骨铺设法，能起到一定的防潮功能，并且要把防潮膜铺设到位。\n2、在实木地板安装的过程中一定要预留出充足的伸缩缝，以供木地板尽情舒张，当实木地板的铺贴长度超过8米时，也必须要留出伸缩缝，然后用收边条收口。', '2');
INSERT INTO `message` VALUES ('33', '什么是木蜡油？有什么作用？', '木蜡油真的有那么环保吗？', '2022-04-17', '木蜡油不仅可以作为长久保护木器的材料，也可以作为木制品保养护理的日常用品，既然是日常护理，完全可以根据消费者个人需求来进行，正如人们使用护肤品只是为了更好的保养肌肤，既可以经常使用也可以偶尔使用是同样的道理。', '2');
INSERT INTO `message` VALUES ('34', '瓷砖上可以直接铺木地板吗？', '瓷砖上可以直接铺木地板吗？', '2022-04-17', '瓷砖上肯定可以铺贴木地板的，而且一定是利大于弊的，因为木地板有地弹簧，如果地面有采暖的话，铺了木地板也不也影响采暖。\n朋友告诉我说，很多人不了解这种工艺，就误以为这种做法不对。其实在瓷砖上铺木地板的好处可是很多的。瓷砖拆改需要人工费和辅料，如果先拆掉本身的瓷砖再重铺木地板的话，只会多余浪费一笔钱。', '2');
INSERT INTO `message` VALUES ('35', '房间里铺装的木地板能用电暖器吗?', '木地板厂家需要注意事项有以下几种', '2022-04-17', '1.电暖器的散热角度，只能取朝上或者水平的角度，不能朝下对着木地板。\n2.在使用电暖器的过程中，人一旦离开，应当关闭电暖器的电源。\n3.应当选用有“跌倒断电功能”的电暖器。', '3');
INSERT INTO `message` VALUES ('36', '为什么家有老人和小孩，一定铺装木地板？', '很多人在装修的时候喜欢使用瓷砖作为地面材料', '2022-04-17', '根据调查显示，1-5岁儿童意外伤害发生率最高，比较活泼好动，易发生意外伤害的场所是家里。同时，年迈的父母身体机能逐渐下降，行动没有年轻人利索，容易发生跌倒和摔伤等事件。因此，家居地面安全，成了许多消费者选择地面材料的一个关键因素。', '3');
INSERT INTO `message` VALUES ('37', '水泥地上可以铺木地板吗？需要注意什么', '木地板能否直接铺在水泥地上，这个问题要分情况来看', '2022-04-17', '1：首先将地面用拖布抹好后干燥，满铺防潮膜再铺地板。当家里的原地面存在不平整或未抹找平层的情况下是不可以直铺木地板的，应该选择木龙骨打底的做法。\n\n2：木龙骨一般选择40mm×40mm的截面尺寸，人员活动量大的地方用40mm×60mm的截面尺寸，木龙骨片要咬口使用并加胶，与地面的固定用防腐木装在木龙骨的左右，按山字形固定木龙骨片', '3');
INSERT INTO `message` VALUES ('38', '板材企业的时尚之路究竟要如何走呢？', '    对于生态板来说，外界环境因素大大影响着它的环保程度', '2022-04-17', '随着生态板被越来越多的家庭使用，其环保程度与板材自身品质，正日益受到消费者的关注。众多商家也已经向E0级靠拢。 根据目前所知，板材含水率、外界环境湿度、温度等，都会影响着板材的环保程度。 相关数据显示，当 人造板 材的含水率从3%逐渐上升到10%时，其甲醛的释放量会明显增加，自然，意味着在一定范围以内板材的含水率越大时，环保程度会大大降低。', '1');
INSERT INTO `message` VALUES ('39', '第一印象地板：甲醛之殇，根源在哪里？', '租房平台为了高周转，刚装修完便让租客入住，这是对租客不负责任的行为', '2022-04-17', '但是，没通风不能成为甲醛超标的理由，在鱼龙混杂的家装市场，选择到环保过关的产品是非常重要的，而真正环保的产品，会在生产环节、原材料应用环节，就杜绝甲醛。就拿地板来说，在判断地板是否绿色环保的时候，除了关注地板环保等级，还可以通过消费者的口碑、以及地板的品牌等等各方面进行判断了解', '1');
INSERT INTO `message` VALUES ('40', '家装时为什么大多数人愿意选择全屋木地板？', '在我们的印象中，现在大多数人都是客厅铺瓷砖，卧室铺木地板。', '2022-04-17', '  传统的做法，都是客厅铺瓷砖。瓷砖的好处是易于打理、耐脏，但是瓷砖的舒适度远远不及木地板。,专业的强化复合地板、多层木地板认为瓷砖触感冰冷，木地板则美观大方，脚感舒适柔和，客厅铺上木地板不仅舒适，还有面子。', '1');
INSERT INTO `message` VALUES ('41', '塑胶地板为什么越来越深受人们喜欢追捧？', '   传统木地板难于打理，成本高，更有腐蚀和发霉的情况发生', '2022-04-17', '   传统木地板是由树木加工而成，因此制造木地板会采伐大量树木，不但破坏环境，更违背环保意念。木地板更要悉心打理，小心奕奕，以保持观感和性能;因为木地板容易受潮湿、白蚁、水等而使地样变形，甚至腐蚀。而第一印象地板环保塑胶地板的保养比较简单得多', '1');
INSERT INTO `message` VALUES ('42', '环境专项整治席卷南浔,地板涨价，已成定局！', '封厂、关停、涨价！严查4个月', '2022-04-17', '最彻底的新一轮大检查来了！无法升级改造达标排放的厂，9月底前一律关闭！据第一印象地板,专业的强化复合地板、多层木地板、实木地板厂家所悉近日，中国木地板之都南浔也开始木业行业环境污染专项整治行动。针对所以木业企业进行整治，希望通过整治，提高行业市场竞争力，大幅度提升企业生产工艺和管理水平，削减污染物排放总量和企业数量。', '1');
INSERT INTO `message` VALUES ('43', '木地板渠道为王大势下 如何做好家居电商？', ' 从现今的电商销售来看，总体上电商企业是在下滑的', '2022-04-17', '   家具电商发展到现阶段，可以说是相对成熟，但是纯电商销售还有许多是以往的思维，不做品质管控、不做品牌运营、不做客户管理等等，以产品单品图片销售为主，与全屋定制、整装的市场需求存在明显差异，单品销售或者是系列家具单品图片的拼图消费的缺陷被放大', '1');
INSERT INTO `message` VALUES ('44', '强化木地板会出现有色差的情况如何避免这一情况呢？', '强化地板有标准的，宽板的和窄板的，三种不同的规格优势也都不一样', '2022-04-18', '1、铺装的强化地板，要避免阳光的暴晒，防止油漆在阳光的照射下老化、开裂等。\n2、强化木地板也要避免接触水，若是平时地板上弄上了谁，要及时的擦干。\n3、建议大家可以每三个月打一次蜡，打蜡前要将地板清理干净。\n4、平时要保持强化木地板的清洁，不要破坏地板表面的光泽。', '2');
INSERT INTO `message` VALUES ('45', '为什么强化木地板走路有声音？', '木地板是用木材制成的，现在很多人的家里面也都是安装的这种木地板', '2022-04-18', '    1、安装木地板时，混凝土基层含水率过高，并且没安装防潮隔离层，这就会使龙骨吸潮，含水率增加，龙骨就会有松动，所以地板就会有声音。\n    2、大家在安装强化木地板时，如果龙骨铺装时含水率过高的话，但是干燥后含水率就会降低，这样木地板的握钉力就会降低，地板就会有声音\n    3、还有一个重要的原因是气候比较干燥，这就会使强化木地板的龙骨握钉力减弱，木地板就会松动，过度潮湿就会膨胀，因此走在地板上就会有声音。', '2');
INSERT INTO `message` VALUES ('46', '实木地板厂家支招木地板如何搭配更好', '实木地板非常的健康环保，装修效果也好，但实木地板的价格上会比较贵一些', '2022-04-18', '由于地热采暖的特殊性，对地板的要求非常严格，地热采暖地板用什么?地热专用地板必须具备热传导性能好、热稳定性能要好、环保性能要好、抗变形性好“四好”要求。\n\n价格偏高。实木地板安装比较讲究也比较繁琐，由于要铺设木龙骨，工期较长，费用较高，有些在混合施工上经常有问题出现。\n强化地板原材料属于人造板，最大的特点就是耐磨性好，是木地板种类中价格最便宜的一款地板，一般在80--300元/㎡之间，建议消费者不要买80元/㎡以下的地板，强化木地板比较适合客厅等人流比较多的场合装。\n', '2');
INSERT INTO `message` VALUES ('47', '复合地板保养需要注意什么？有哪些小窍门？', '      平时可以用吸尘器或扫帚清扫表面灰尘，再用浸湿后拧干至不滴水的抹布或拖把擦拭地板表面', '2022-04-18', '拖地后最好打开门窗，让空气流通，尽快将地板吹干。复合地板耐磨层若受损将使地板的防潮功能和光亮度受影响，因此，在复合地板上行走时，应尽量穿布拖鞋，最好赤脚。给家具的脚都贴上软底防护垫，避免家具的脚刮花地板耐磨层，第一印象地板别让很重的物品砸坏耐磨层。复合地板保养不能使用砂纸、打磨器、钢刷、强力去污粉或金属工具清理复合木地板。如果家中养猫，要想办法解决猫爪的破坏。', '2');
INSERT INTO `message` VALUES ('48', '纯实木地板能在地热环境中用吗？', '随着科技的发展的不断发展，在高科技设备和人们智慧的结合之下', '2022-04-18', '  实木地热地板，是把天然木材作为原料，从面到底都是用一种材质加工，实木地板呈现出的天然原木纹理和色彩，给人自然，柔和的质感，不仅冬暖夏凉，脚感舒适，而且无甲醛，甲苯等有害物质添加，是当之无愧的健康地板。第一印象地板,专业的强化复合地板、多层木地板、实木地板厂家但是在地热环境当中，通常都会把实木地板拒之门外好。', '2');
INSERT INTO `message` VALUES ('49', '撒打算', '委屈恶法大师傅士大夫士大夫施工规范', '2022-04-18', '但是犯得上广泛发动高峰对话和广泛国防军', '1');

-- ----------------------------
-- Table structure for `messagetp`
-- ----------------------------
DROP TABLE IF EXISTS `messagetp`;
CREATE TABLE `messagetp` (
  `tpId` int(100) NOT NULL AUTO_INCREMENT,
  `tmessageId` int(100) DEFAULT NULL,
  `tpsite` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`tpId`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of messagetp
-- ----------------------------
INSERT INTO `messagetp` VALUES ('7', '11', 'images\\16499304745336E621881-C1B2-425D-B90C-C4511953F050.png');
INSERT INTO `messagetp` VALUES ('8', '11', 'images\\16499304745357ea1b4bf15a316d48b6ee8c2bea38d55 - 副本.jpeg');
INSERT INTO `messagetp` VALUES ('9', '11', 'images\\16499304745478IZ5]QJ%)D`{_QLP~TE2PQ8.png');
INSERT INTO `messagetp` VALUES ('10', '12', 'images\\1649930498822e833ad7689e90dfc6984ad3af804dfaf.jpeg');
INSERT INTO `messagetp` VALUES ('11', '12', 'images\\1649930498824e833ad7689e90dfc6984ad3af804dfaf.jpg');
INSERT INTO `messagetp` VALUES ('12', '12', 'images\\1649930498828e833ad7689e90dfc6984ad3af804dfaf.png');
INSERT INTO `messagetp` VALUES ('13', '13', 'images\\1649930515147476b15bb0a893057ebdcd90a690dfcb8 - 副本.jpeg');
INSERT INTO `messagetp` VALUES ('14', '13', 'images\\1649930515147476b15bb0a893057ebdcd90a690dfcb8 - 副本.png');
INSERT INTO `messagetp` VALUES ('15', '13', 'images\\1649930515147476b15bb0a893057ebdcd90a690dfcb8.jpeg');
INSERT INTO `messagetp` VALUES ('16', '14', 'images\\1649930855697476b15bb0a893057ebdcd90a690dfcb8 - 副本.png');
INSERT INTO `messagetp` VALUES ('17', '14', 'images\\1649930855697476b15bb0a893057ebdcd90a690dfcb8.png');
INSERT INTO `messagetp` VALUES ('18', '14', 'images\\1649930855697576d0d5d6bcc2ed86a2ad57b916e16f9.jpeg');
INSERT INTO `messagetp` VALUES ('19', '15', 'images\\164993087487912.jpg');
INSERT INTO `messagetp` VALUES ('20', '15', 'images\\16499308748815a1398477a8e6b5e6eed9339da04a068.jpg');
INSERT INTO `messagetp` VALUES ('21', '15', 'images\\16499308748817ea1b4bf15a316d48b6ee8c2bea38d55.jpeg');
INSERT INTO `messagetp` VALUES ('22', '16', 'images\\16499308981557ea1b4bf15a316d48b6ee8c2bea38d55.jpeg');
INSERT INTO `messagetp` VALUES ('23', '16', 'images\\16499308981547ea1b4bf15a316d48b6ee8c2bea38d55 - 副本.jpeg');
INSERT INTO `messagetp` VALUES ('24', '16', 'images\\16499308981668IZ5]QJ%)D`{_QLP~TE2PQ8.png');
INSERT INTO `messagetp` VALUES ('25', '17', 'images\\16499309258086E621881-C1B2-425D-B90C-C4511953F050 - 副本.png');
INSERT INTO `messagetp` VALUES ('26', '17', 'images\\16499309258105a1398477a8e6b5e6eed9339da04a068 - 副本.jpg');
INSERT INTO `messagetp` VALUES ('27', '17', 'images\\16499309258105a1398477a8e6b5e6eed9339da04a068.jpg');
INSERT INTO `messagetp` VALUES ('28', '18', 'images\\1649930947309476b15bb0a893057ebdcd90a690dfcb8 - 副本.jpeg');
INSERT INTO `messagetp` VALUES ('29', '18', 'images\\1649930947309476b15bb0a893057ebdcd90a690dfcb8.jpeg');
INSERT INTO `messagetp` VALUES ('30', '18', 'images\\16499309473095a1398477a8e6b5e6eed9339da04a068.jpg');
INSERT INTO `messagetp` VALUES ('31', '19', 'images\\1649930967628271 - 副本.jpg');
INSERT INTO `messagetp` VALUES ('32', '19', 'images\\16499309676285a1398477a8e6b5e6eed9339da04a068 - 副本.jpg');
INSERT INTO `messagetp` VALUES ('33', '19', 'images\\16499309676415%CNULJZU9EXW]J7`RA_XLE.png');
INSERT INTO `messagetp` VALUES ('34', '20', 'images\\1649930984347271.jpg');
INSERT INTO `messagetp` VALUES ('35', '20', 'images\\1649930984347271 - 副本.jpg');
INSERT INTO `messagetp` VALUES ('36', '20', 'images\\16499309843615%CNULJZU9EXW]J7`RA_XLE.png');
INSERT INTO `messagetp` VALUES ('37', '21', 'images\\164993100472973afeeaa0108495d9e4d6b80f7773039.jpeg');
INSERT INTO `messagetp` VALUES ('38', '21', 'images\\164993100472984c7f9d0a1df9d3af5830e94ad96ad81.jpeg');
INSERT INTO `messagetp` VALUES ('39', '21', 'images\\16499310047445%CNULJZU9EXW]J7`RA_XLE.png');
INSERT INTO `messagetp` VALUES ('40', '22', 'images\\1649931026804271.jpg');
INSERT INTO `messagetp` VALUES ('41', '22', 'images\\164993102680452359975673458221001621246716054.jpg');
INSERT INTO `messagetp` VALUES ('42', '22', 'images\\164993102682263777882486122.png');
INSERT INTO `messagetp` VALUES ('43', '23', 'images\\1649931043164k.jpg');
INSERT INTO `messagetp` VALUES ('44', '23', 'images\\1649931043164271.jpg');
INSERT INTO `messagetp` VALUES ('45', '23', 'images\\164993104318363777882486122.png');
INSERT INTO `messagetp` VALUES ('46', '24', '\\images\\16501213405836E621881-C1B2-425D-B90C-C4511953F050 - 副本.png');
INSERT INTO `messagetp` VALUES ('47', '24', '\\images\\16501213405835a1398477a8e6b5e6eed9339da04a068.jpg');
INSERT INTO `messagetp` VALUES ('48', '24', '\\images\\16501213405835a1398477a8e6b5e6eed9339da04a068 - 副本.jpg');
INSERT INTO `messagetp` VALUES ('49', '25', '\\images\\1650121396191271.jpg');
INSERT INTO `messagetp` VALUES ('50', '25', '\\images\\16501213961915a1398477a8e6b5e6eed9339da04a068.jpg');
INSERT INTO `messagetp` VALUES ('51', '25', '\\images\\1650121396191476b15bb0a893057ebdcd90a690dfcb8 - 副本.jpeg');
INSERT INTO `messagetp` VALUES ('52', '26', '\\images\\1650121514114271.jpg');
INSERT INTO `messagetp` VALUES ('53', '26', '\\images\\1650121514114271 - 副本.jpg');
INSERT INTO `messagetp` VALUES ('54', '26', '\\images\\16501215141325%CNULJZU9EXW]J7`RA_XLE.png');
INSERT INTO `messagetp` VALUES ('55', '27', '\\images\\1650121570349271.jpg');
INSERT INTO `messagetp` VALUES ('56', '27', '\\images\\1650121570349476b15bb0a893057ebdcd90a690dfcb8 - 副本.jpeg');
INSERT INTO `messagetp` VALUES ('57', '27', '\\images\\16501215703505a1398477a8e6b5e6eed9339da04a068 - 副本.jpg');
INSERT INTO `messagetp` VALUES ('58', '28', '\\images\\165019609089120190528093031_20888.jpg');
INSERT INTO `messagetp` VALUES ('59', '29', '\\images\\16501961628915c0e138439958.jpg');
INSERT INTO `messagetp` VALUES ('60', '30', '\\images\\165019625510720190827161308_37924.jpg');
INSERT INTO `messagetp` VALUES ('61', '31', '\\images\\165019629268120190827161856_89671.jpg');
INSERT INTO `messagetp` VALUES ('62', '32', '\\images\\165019633446120181210152455_32496.jpg');
INSERT INTO `messagetp` VALUES ('63', '33', '\\images\\165019640131020190612141700_75066.jpg');
INSERT INTO `messagetp` VALUES ('64', '34', '\\images\\165019645294220190528093031_20888.jpg');
INSERT INTO `messagetp` VALUES ('65', '35', '\\images\\165019653841620190527094622_83122.jpg');
INSERT INTO `messagetp` VALUES ('66', '35', '\\images\\165019653841620190527094635_91265.jpg');
INSERT INTO `messagetp` VALUES ('67', '36', '\\images\\165019658796420190513092739_54486.jpg');
INSERT INTO `messagetp` VALUES ('68', '37', '\\images\\165019693483220190827161856_89671.jpg');
INSERT INTO `messagetp` VALUES ('69', '38', '\\images\\165019709087620190527094635_91265.jpg');
INSERT INTO `messagetp` VALUES ('70', '38', '\\images\\165019709087620190528093031_20888.jpg');
INSERT INTO `messagetp` VALUES ('71', '39', '\\images\\165019713773520181219151744_59121.jpg');
INSERT INTO `messagetp` VALUES ('72', '40', '\\images\\165019720749620181218152156_10144.jpg');
INSERT INTO `messagetp` VALUES ('73', '41', '\\images\\165019724405120181218152141_64726.jpg');
INSERT INTO `messagetp` VALUES ('74', '42', '\\images\\165019728496920190301171600_81368.png');
INSERT INTO `messagetp` VALUES ('75', '43', '\\images\\165019732328020190227154738_38996.jpg');
INSERT INTO `messagetp` VALUES ('76', '44', '\\images\\165025610524320181218152156_10144.jpg');
INSERT INTO `messagetp` VALUES ('77', '44', '\\images\\165025610524320181218152212_32445.jpg');
INSERT INTO `messagetp` VALUES ('78', '45', '\\images\\165025615808020181218152156_10144.jpg');
INSERT INTO `messagetp` VALUES ('79', '45', '\\images\\165025615807920181218152212_32445.jpg');
INSERT INTO `messagetp` VALUES ('80', '45', '\\images\\165025615808120181218152141_64726.jpg');
INSERT INTO `messagetp` VALUES ('81', '46', '\\images\\165025666029220181217212004_90119.jpg');
INSERT INTO `messagetp` VALUES ('82', '47', '\\images\\165025672970220181219150512_18897.jpg');
INSERT INTO `messagetp` VALUES ('83', '48', '\\images\\165025678887520181218153631_64502.jpg');
INSERT INTO `messagetp` VALUES ('84', '49', '\\images\\165026240261320181219150512_18897.jpg');
INSERT INTO `messagetp` VALUES ('85', '49', '\\images\\165026240261320181218153631_64502.jpg');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productId` int(100) NOT NULL AUTO_INCREMENT,
  `productClass` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `productName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `model` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `specifications` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `level` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `geothermal` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `place` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `trait` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `img` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `time` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `series` int(100) DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('61', '实木三层21312', '橡木大锁扣小麦色', 'DP2033', '1210*162*15 mm', '家用Ⅰ级', '可适用于地热', '江苏', '干缩膨胀系极小，具有较好的调节室内温度和湿度的能力，面层能显示出木材天然木纹，纹理自然、大方，抗变形，耐腐蚀，易清理，脚感舒适，保温性能好。\n', null, '2022-04-17 17:48:27', '2');
INSERT INTO `product` VALUES ('63', '强化复合', '欧式简约', 'YX902', '1220*198*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '哑光模压强化地板，地中海直、布纹理，既有欧式风格的雍容，也不失现代感,更适应现代生活的悠闲与舒适，适合多种装饰风格。推荐风格：现代，简约，美式。独特的纹理，高密度基材，优质装饰层，天然环保，超强耐磨。', null, '2022-04-17 17:51:28', '4');
INSERT INTO `product` VALUES ('64', '强化复合', '尚品生活', 'K006', '1220*200*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '纹理美观，时尚，层次分明，更有内涵，细节处理更为精彩，仿佛是盛夏时光中的风格，别具风韵，健康无醛净化，抗污抗老化，耐磨美观。\n推荐风格：美式，新中式，现代。', null, '2022-04-17 17:53:06', '8');
INSERT INTO `product` VALUES ('65', '强化复合', '尚品生活', 'K005', '1220*200*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '纹理美观，时尚，层次分明，更有内涵，细节处理更为精彩，仿佛是盛夏时光中的风格，别具风韵，健康无醛净化，抗污抗老化，耐磨美观。\n推荐风格：美式，新中式，现代。', null, '2022-04-17 17:54:25', '7');
INSERT INTO `product` VALUES ('66', '强化复合', '超仿实木', 'H6606', '1220*198*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '简约原木系列，纹路清晰明快实木质感强烈，空间感更强，舒适脚感，美观大方，纹理立体感强，超强耐磨，抗污抗老化。\n\n推荐风格：现代，北欧，简约。', null, '2022-04-17 17:55:18', '11');
INSERT INTO `product` VALUES ('67', '实木多层', '紫檀', 'DP9003', '1210*168*15 mm', '家用Ⅰ级', '可适用于地热', '江苏', '干缩膨胀系极小，具有较好的调节室内温度和湿度的能力，面层能显示出木材天然木纹，纹理自然、大方，抗变形，耐腐蚀，易清理，脚感舒适，保温性能好。', null, '2022-04-17 17:56:51', '5');
INSERT INTO `product` VALUES ('68', '实木多层', '橡木烟灰三拼', 'DP9044', '1210*168*15 mm', '家用Ⅰ级', '可适用于地热', '江苏', '干缩膨胀系极小，具有较好的调节室内温度和湿度的能力，面层能显示出木材天然木纹，纹理自然、大方，抗变形，耐腐蚀，易清理，脚感舒适，保温性能好。', null, '2022-04-17 17:58:30', '6');
INSERT INTO `product` VALUES ('69', '实木多层', '橡木小麦色', 'DP9018', '1210*168*15 mm', '家用Ⅰ级', '可适用于地热', '江苏', '干缩膨胀系极小，具有较好的调节室内温度和湿度的能力，面层能显示出木材天然木纹，纹理自然、大方，抗变形，耐腐蚀，易清理，脚感舒适，保温性能好。', null, '2022-04-17 18:02:07', '6');
INSERT INTO `product` VALUES ('70', 'SB306B', '橡木仿古', 'SB306B', '1210*162*15 mm', '家用Ⅰ级', '可适用于地热', '江苏', '干缩膨胀系极小，具有较好的调节室内温度和湿度的能力，面层能显示出木材天然木纹，纹理自然、大方，抗变形，耐腐蚀，易清理，脚感舒适，保温性能好。', null, '2022-04-17 18:15:53', '6');
INSERT INTO `product` VALUES ('71', '强化复合', '幻影时代', 'YX810', '1220*198*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '经典高光亮面模压强化地板，天然木质纹理，大气包容，风格多样，触感平滑，优雅内敛，多样的款式易搭配各种混搭风格，更容易营造温馨优雅的居家氛围。健康无醛净化，同步对花工艺，抗污抗老化，耐磨美观，逼真纹理，时尚花色。', null, '2022-04-17 18:17:01', '5');
INSERT INTO `product` VALUES ('72', '强化复合', '幻影时代', 'YX810', '1220*198*12 mm', '家用Ⅰ级', '不可适用于地热', '湖南', '经典高光亮面模压强化地板，天然木质纹理，大气包容，风格多样，触感平滑，优雅内敛，多样的款式易搭配各种混搭风格，更容易营造温馨优雅的居家氛围。健康无醛净化，同步对花工艺，抗污抗老化，耐磨美观，逼真纹理，时尚花色。', null, '2022-04-17 18:18:28', '2');
INSERT INTO `product` VALUES ('73', '实木地板', '柚木', 'DP093', '910*127*18 mm', '家用Ⅰ级', '可适用于地热', '江苏', '冬暖夏凉，脚感舒适，使用安全，保持了木材的本色韵味，纹理自然、气味芬芳，使人仿佛置身于森林之中，充分感受大自然的气息；健康环保，持久耐用，自然清新，耐磨美观；', null, '2022-04-17 18:19:46', '7');
INSERT INTO `product` VALUES ('74', '强化复合', '中式田园', 'YX709', '1220*170*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '经典高光亮面模压强化地板，集现代木地板优点于一体，采用家用一级优质基材，耐磨耐用，木材纹理真实立体，华丽、柔滑细腻，基调是丰收的金黄色，接近大自然的的风情，款式多样，适合现代简约，复古，中式等多种装修风格；先进加工工艺，超强冲击力，超强耐磨，超高耐水性能，精细榫槽咬合，绿色环保质量保证。\n', null, '2022-04-17 18:21:18', '1');
INSERT INTO `product` VALUES ('75', '强化复合', '中式田园', 'YX707', '1220*170*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '经典高光亮面模压强化地板，集现代木地板优点于一体，采用家用一级优质基材，耐磨耐用，木材纹理真实立体，华丽、柔滑细腻，基调是丰收的金黄色，接近大自然的的风情，款式多样，适合现代简约，复古，中式等多种装修风格；先进加工工艺，超强冲击力，超强耐磨，超高耐水性能，精细榫槽咬合，绿色环保质量保证。\n', null, '2022-04-17 18:22:25', '4');
INSERT INTO `product` VALUES ('76', '强化复合', '中式田园', 'YX703', '1220*170*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '经典高光亮面模压强化地板，集现代木地板优点于一体，采用家用一级优质基材，耐磨耐用，木材纹理真实立体，华丽、柔滑细腻，基调是丰收的金黄色，接近大自然的的风情，款式多样，适合现代简约，复古，中式等多种装修风格；先进加工工艺，超强冲击力，超强耐磨，超高耐水性能，精细榫槽咬合，绿色环保质量保证。', null, '2022-04-17 18:23:24', '5');
INSERT INTO `product` VALUES ('77', '强化复合', '幻影时代', 'YX806', '1220*198*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '经典高光亮面模压强化地板，天然木质纹理，大气包容，风格多样，触感平滑，优雅内敛，多样的款式易搭配各种混搭风格，更容易营造温馨优雅的居家氛围。健康无醛净化，同步对花工艺，抗污抗老化，耐磨美观，逼真纹理，时尚花色。', null, '2022-04-17 18:24:49', '9');
INSERT INTO `product` VALUES ('78', '强化复合', '尚品生活', 'K004', '1220*200*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '纹理美观，时尚，层次分明，更有内涵，细节处理更为精彩，仿佛是盛夏时光中的风格，别具风韵，健康无醛净化，抗污抗老化，耐磨美观。\n推荐风格：美式，新中式，现代。', null, '2022-04-17 18:38:03', '5');
INSERT INTO `product` VALUES ('79', '实木地板', '番龙眼柚木色', 'DP052', '910*127*18 mm', '家用Ⅰ级', '可适用于地热', '江苏', '冬暖夏凉，脚感舒适，使用安全，保持了木材的本色韵味，纹理自然、气味芬芳，使人仿佛置身于森林之中，充分感受大自然的气息；健康环保，持久耐用，自然清新，耐磨美观；', null, '2022-04-17 18:44:45', '2');
INSERT INTO `product` VALUES ('80', '强化复合', '中式田园', 'YX703', '1220*170*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '经典高光亮面模压强化地板，集现代木地板优点于一体，采用家用一级优质基材，耐磨耐用，木材纹理真实立体，华丽、柔滑细腻，基调是丰收的金黄色，接近大自然的的风情，款式多样，适合现代简约，复古，中式等多种装修风格；先进加工工艺，超强冲击力，超强耐磨，超高耐水性能，精细榫槽咬合，绿色环保质量保证。', null, '2022-04-17 18:45:47', '2');
INSERT INTO `product` VALUES ('81', '强化复合', '中式田园', 'YX706', '1220*170*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '经典高光亮面模压强化地板，集现代木地板优点于一体，采用家用一级优质基材，耐磨耐用，木材纹理真实立体，华丽、柔滑细腻，基调是丰收的金黄色，接近大自然的的风情，款式多样，适合现代简约，复古，中式等多种装修风格；先进加工工艺，超强冲击力，超强耐磨，超高耐水性能，精细榫槽咬合，绿色环保质量保证。 绿色环保质量保证。', null, '2022-04-17 18:49:34', '4');
INSERT INTO `product` VALUES ('82', '实木三层', '橡木大锁扣深灰', 'DP2031', '1210*162*15 mm', '家用Ⅰ级', '可适用于地热', '江苏', '干缩膨胀系极小，具有较好的调节室内温度和湿度的能力，面层能显示出木材天然木纹，纹理自然、大方，抗变形，耐腐蚀，易清理，脚感舒适，保温性能好。', null, '2022-04-17 18:51:15', '3');
INSERT INTO `product` VALUES ('83', '强化复合', '超仿实木', 'H6607', '1220*198*12 mm', '家用Ⅰ级', '不可适用于地热', '江苏', '简约原木系列，纹路清晰明快实木质感强烈，空间感更强，舒适脚感，美观大方，纹理立体感强，超强耐磨，抗污抗老化。\n', null, '2022-04-17 18:52:18', '6');
INSERT INTO `product` VALUES ('85', '强化复合', '幻影时代', 'YX806', '1220*198*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '经典高光亮面模压强化地板，天然木质纹理，大气包容，风格多样，触感平滑，优雅内敛，多样的款式易搭配各种混搭风格，更容易营造温馨优雅的居家氛围。健康无醛净化，同步对花工艺，抗污抗老化，耐磨美观，逼真纹理，时尚花色。', null, '2022-04-17 18:54:25', '5');
INSERT INTO `product` VALUES ('87', '强化复合', '超仿实木', 'H6602', '1220*198*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '简约原木系列，纹路清晰明快实木质感强烈，空间感更强，舒适脚感，美观大方，纹理立体感强，超强耐磨，抗污抗老化。', null, '2022-04-17 18:56:18', '5');
INSERT INTO `product` VALUES ('88', '强化复合', '欧式复古', 'T101', '1218*170*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '亚光复古V型槽地板，全进口耐磨纸，表面纹路真实，彰显华丽、高雅的古典美，触感强烈，层次感更好，仿佛经历了时光浸染一般。推荐风格：欧式，新中式，抗污抗老化，健康无醛净化，阻燃、防潮，抗冲击，抗变形。', null, '2022-04-17 18:57:13', '6');
INSERT INTO `product` VALUES ('89', '强化复合', '超仿实木', 'H6601', '1220*198*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '简约原木系列，纹路清晰明快实木质感强烈，空间感更强，舒适脚感，美观大方，纹理立体感强，超强耐磨，抗污抗老化。', null, '2022-04-17 18:58:42', '6');
INSERT INTO `product` VALUES ('90', '实木地板', '纽墩豆', 'DP068', '910*127*18 mm', '家用Ⅰ级', '可适用于地热', '江苏', '冬暖夏凉，脚感舒适，使用安全，保持了木材的本色韵味，纹理自然、气味芬芳，使人仿佛置身于森林之中，充分感受大自然的气息；健康环保，持久耐用，自然清新，耐磨美', null, '2022-04-17 18:59:38', '7');
INSERT INTO `product` VALUES ('91', '实木地板', '番龙眼柚木色', 'DP052', '910*127*18 mm', '家用Ⅰ级', '可适用于地热', '江苏', '冬暖夏凉，脚感舒适，使用安全，保持了木材的本色韵味，纹理自然、气味芬芳，使人仿佛置身于森林之中，充分感受大自然的气息；健康环保，持久耐用，自然清新，耐磨美观；\n\n', null, '2022-04-17 19:00:51', '6');
INSERT INTO `product` VALUES ('92', '强化复合', '中式田园', 'YX703', '1220*170*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '经典高光亮面模压强化地板，集现代木地板优点于一体，采用家用一级优质基材，耐磨耐用，木材纹理真实立体，华丽、柔滑细腻，基调是丰收的金黄色，接近大自然的的风情，款式多样，适合现代简约，复古，中式等多种装修风格；先进加工工艺，超强冲击力，超强耐磨，超高耐水性能，精细榫槽咬合，绿色环保质量保证。', null, '2022-04-17 19:01:53', '2');
INSERT INTO `product` VALUES ('93', '强化复合', '中式田园', 'YX709', '1220*170*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '经典高光亮面模压强化地板，集现代木地板优点于一体，采用家用一级优质基材，耐磨耐用，木材纹理真实立体，华丽、柔滑细腻，基调是丰收的金黄色，接近大自然的的风情，款式多样，适合现代简约，复古，中式等多种装修风格；先进加工工艺，超强冲击力，超强耐磨，超高耐水性能，精细榫槽咬合，绿色环保质量保证。', null, '2022-04-17 19:12:04', '11');
INSERT INTO `product` VALUES ('94', '强化复合', '中式田园', 'YX706', '1220*170*12 mm', '家用Ⅰ级', '可适用于地热', '江苏', '经典高光亮面模压强化地板，集现代木地板优点于一体，采用家用一级优质基材，耐磨耐用，木材纹理真实立体，华丽、柔滑细腻，基调是丰收的金黄色，接近大自然的的风情，款式多样，适合现代简约，复古，中式等多种装修风格；先进加工工艺，超强冲击力，超强耐磨，超高耐水性能，精细榫槽咬合，绿色环保质量保证。 绿色环保质量保证。', null, '2022-04-17 19:12:56', '10');
INSERT INTO `product` VALUES ('96', 'adsa', '发的夫人', '34543', '23432', '3243', '2434', '3423', '234324', null, '2022-04-18 14:10:58', '2');

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `projectId` int(100) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `pTime` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('19', '商洛市秦韵教育城', null);
INSERT INTO `project` VALUES ('20', '蓝田县老年公寓', null);
INSERT INTO `project` VALUES ('21', '合众城悦幼儿园', null);
INSERT INTO `project` VALUES ('22', 'erwee', null);

-- ----------------------------
-- Table structure for `projecttp`
-- ----------------------------
DROP TABLE IF EXISTS `projecttp`;
CREATE TABLE `projecttp` (
  `tpId` int(100) NOT NULL AUTO_INCREMENT,
  `pprojectId` int(100) DEFAULT NULL,
  `tppicture` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`tpId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of projecttp
-- ----------------------------
INSERT INTO `projecttp` VALUES ('4', '12', 'images\\16499139478625a1398477a8e6b5e6eed9339da04a068 - 副本.jpg');
INSERT INTO `projecttp` VALUES ('5', '12', 'images\\16499139478805%CNULJZU9EXW]J7`RA_XLE.png');
INSERT INTO `projecttp` VALUES ('6', '13', 'images\\16499140040687ea1b4bf15a316d48b6ee8c2bea38d55.jpeg');
INSERT INTO `projecttp` VALUES ('7', '13', 'images\\16499140040838IZ5]QJ%)D`{_QLP~TE2PQ8.png');
INSERT INTO `projecttp` VALUES ('8', '14', 'images\\1649914030421e833ad7689e90dfc6984ad3af804dfaf.jpeg');
INSERT INTO `projecttp` VALUES ('9', '14', 'images\\1649914030425e833ad7689e90dfc6984ad3af804dfaf.jpg');
INSERT INTO `projecttp` VALUES ('10', '17', '\\images\\16501956172895c17a2cec3774.jpg');
INSERT INTO `projecttp` VALUES ('11', '18', '\\images\\16501956365195c17a2931e00d.jpg');
INSERT INTO `projecttp` VALUES ('12', '19', '\\images\\165019575619320181217211936_23780.jpg');
INSERT INTO `projecttp` VALUES ('13', '19', '\\images\\16501957561935c17a2cec3774.jpg');
INSERT INTO `projecttp` VALUES ('14', '19', '\\images\\165019575619320181217211932_30038.jpg');
INSERT INTO `projecttp` VALUES ('15', '20', '\\images\\16501957800085c17a2931e00d.jpg');
INSERT INTO `projecttp` VALUES ('16', '20', '\\images\\165019578000820181217212004_90119.jpg');
INSERT INTO `projecttp` VALUES ('17', '20', '\\images\\165019578000920181217212044_59950.jpg');
INSERT INTO `projecttp` VALUES ('18', '20', '\\images\\165019578001020181217212008_57254.jpg');
INSERT INTO `projecttp` VALUES ('19', '21', '\\images\\16501958032415c17a27233fa5.jpg');
INSERT INTO `projecttp` VALUES ('20', '21', '\\images\\165019580324120181217212055_91375.jpg');
INSERT INTO `projecttp` VALUES ('21', '21', '\\images\\165019580324120181217212040_11541.jpg');
INSERT INTO `projecttp` VALUES ('22', '21', '\\images\\165019580324120181217212049_31519.jpg');
INSERT INTO `projecttp` VALUES ('23', '22', '\\images\\165026235989620181219150512_18897.jpg');
INSERT INTO `projecttp` VALUES ('24', '22', '\\images\\165026235989620181218153631_64502.jpg');

-- ----------------------------
-- Table structure for `quanx`
-- ----------------------------
DROP TABLE IF EXISTS `quanx`;
CREATE TABLE `quanx` (
  `qxId` int(10) NOT NULL AUTO_INCREMENT,
  `roleId` int(10) NOT NULL,
  `cdId` int(10) NOT NULL,
  PRIMARY KEY (`qxId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quanx
-- ----------------------------
INSERT INTO `quanx` VALUES ('1', '1', '1');
INSERT INTO `quanx` VALUES ('2', '1', '2');
INSERT INTO `quanx` VALUES ('3', '1', '3');
INSERT INTO `quanx` VALUES ('4', '1', '4');
INSERT INTO `quanx` VALUES ('5', '1', '5');
INSERT INTO `quanx` VALUES ('6', '1', '6');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(10) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理');
INSERT INTO `role` VALUES ('2', '人事经理');

-- ----------------------------
-- Table structure for `store`
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `storeId` int(100) NOT NULL AUTO_INCREMENT,
  `storeIdName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `site` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `stime` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `time` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`storeId`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('44', '西乡店qeqe', '汉中市西乡县汉白路附近', '8:30 - 18:00', '2022-04-17 19:20:37');
INSERT INTO `store` VALUES ('45', '蓝田店', '天鹅湖小区', '8:30 - 18:00', '2022-04-17 19:21:14');
INSERT INTO `store` VALUES ('46', '鄠邑店', '七一建材市场', '8:30 - 18:00', '2022-04-17 19:22:00');
INSERT INTO `store` VALUES ('47', '天水店', '天水市桥南建材市场', '8:30 - 18:00', '2022-04-17 19:22:35');
INSERT INTO `store` VALUES ('48', '略阳店', '汉中市略阳县城关镇八渡河桥头附近', '8:30 - 18:00', '2022-04-17 19:23:14');
INSERT INTO `store` VALUES ('49', '汉中店', '汉中市象山路与省道交叉口附近', '8:30 - 18:00', '2022-04-17 19:23:51');
INSERT INTO `store` VALUES ('50', '甘南舟曲店', '安康汉阴县汉阴店', '8:30 - 18:00', '2022-04-17 19:25:03');
INSERT INTO `store` VALUES ('51', '宝鸡店', '宝鸡大有联盟建材市场', '8:30 - 18:00', '2022-04-17 19:25:36');
INSERT INTO `store` VALUES ('52', '武威店', '武威大有联盟建材市场', '8:30 - 18:00', '2022-04-17 19:26:18');
INSERT INTO `store` VALUES ('53', '兰州店', '兰州156号附近', '8:30 - 18:00', '2022-04-17 19:26:56');
INSERT INTO `store` VALUES ('54', '甘南市-临潭店', '甘南市镇兴隆街156号附近', '8:30 - 18:00 ', '2022-04-17 19:27:35');
INSERT INTO `store` VALUES ('55', '东方美居工厂店', '西安市太华南路东方美居建材城E-009号', '8:30 - 18:00', '2022-04-17 19:28:02');
INSERT INTO `store` VALUES ('56', '南郑店', '汉中市南郑区汉黎路附近', '8:30 - 18:00', '2022-04-17 19:28:35');
INSERT INTO `store` VALUES ('57', '勉县店', '汉中市勉县武侯北路附近', '8:30 - 18:00 ', '2022-04-17 19:29:07');
INSERT INTO `store` VALUES ('58', '谢文', '飒飒打撒', '8:00-18:00', '2022-04-18 14:12:14');

-- ----------------------------
-- Table structure for `storetp`
-- ----------------------------
DROP TABLE IF EXISTS `storetp`;
CREATE TABLE `storetp` (
  `sId` int(100) NOT NULL AUTO_INCREMENT,
  `sstoreId` int(100) DEFAULT NULL,
  `spicture` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`sId`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of storetp
-- ----------------------------
INSERT INTO `storetp` VALUES ('10', '10', 'images\\1649897840689KTP$L{UOQ[)AXFY4Z2YONZN.png');
INSERT INTO `storetp` VALUES ('11', '11', 'images\\16498979270197ea1b4bf15a316d48b6ee8c2bea38d55.jpeg');
INSERT INTO `storetp` VALUES ('12', '11', 'images\\1649897927028e833ad7689e90dfc6984ad3af804dfaf.png');
INSERT INTO `storetp` VALUES ('13', '12', 'images\\164990665121812.jpg');
INSERT INTO `storetp` VALUES ('14', '12', 'images\\16499066512211 (1).jpg');
INSERT INTO `storetp` VALUES ('15', '5', 'images\\164990787922284c7f9d0a1df9d3af5830e94ad96ad81.jpeg');
INSERT INTO `storetp` VALUES ('16', '5', 'images\\1649907879222d.png');
INSERT INTO `storetp` VALUES ('17', '5', 'images\\164990787923763777882486122.png');
INSERT INTO `storetp` VALUES ('18', '6', 'images\\16499079620327ea1b4bf15a316d48b6ee8c2bea38d55.jpeg');
INSERT INTO `storetp` VALUES ('19', '6', 'images\\16499079620327ea1b4bf15a316d48b6ee8c2bea38d55 - 副本.jpeg');
INSERT INTO `storetp` VALUES ('20', '6', 'images\\16499079620448IZ5]QJ%)D`{_QLP~TE2PQ8.png');
INSERT INTO `storetp` VALUES ('21', '7', 'images\\16499080148705a1398477a8e6b5e6eed9339da04a068.jpg');
INSERT INTO `storetp` VALUES ('22', '7', 'images\\16499080148705a1398477a8e6b5e6eed9339da04a068 - 副本.jpg');
INSERT INTO `storetp` VALUES ('23', '7', 'images\\16499080148865%CNULJZU9EXW]J7`RA_XLE.png');
INSERT INTO `storetp` VALUES ('24', '8', 'images\\1649908101747576d0d5d6bcc2ed86a2ad57b916e16f9.jpeg');
INSERT INTO `storetp` VALUES ('25', '8', 'images\\16499081017472021—05—17—144255.png');
INSERT INTO `storetp` VALUES ('26', '8', 'images\\1649908101747476b15bb0a893057ebdcd90a690dfcb8.png');
INSERT INTO `storetp` VALUES ('27', '42', '\\images\\1650121736504476b15bb0a893057ebdcd90a690dfcb8 - 副本.jpeg');
INSERT INTO `storetp` VALUES ('28', '42', '\\images\\1650121736504476b15bb0a893057ebdcd90a690dfcb8 - 副本.png');
INSERT INTO `storetp` VALUES ('29', '42', '\\images\\1650121736504476b15bb0a893057ebdcd90a690dfcb8.jpeg');
INSERT INTO `storetp` VALUES ('30', '43', '\\images\\16501944068091.3.jpg');
INSERT INTO `storetp` VALUES ('31', '43', '\\images\\16501944068091.2.jpg');
INSERT INTO `storetp` VALUES ('32', '43', '\\images\\16501944068111.jpg');
INSERT INTO `storetp` VALUES ('33', '44', '\\images\\16501944495754.jpg');
INSERT INTO `storetp` VALUES ('34', '44', '\\images\\16501944495754.2.jpg');
INSERT INTO `storetp` VALUES ('35', '44', '\\images\\16501944495754.3.jpg');
INSERT INTO `storetp` VALUES ('36', '45', '\\images\\16501944929695.2.jpg');
INSERT INTO `storetp` VALUES ('37', '45', '\\images\\16501944929695.4.jpg');
INSERT INTO `storetp` VALUES ('38', '45', '\\images\\16501944929695.jpg');
INSERT INTO `storetp` VALUES ('39', '45', '\\images\\16501944929695.3.jpg');
INSERT INTO `storetp` VALUES ('40', '46', '\\images\\16501945307347.2.jpg');
INSERT INTO `storetp` VALUES ('41', '46', '\\images\\16501945307367.jpg');
INSERT INTO `storetp` VALUES ('42', '47', '\\images\\16501945710968.2.jpg');
INSERT INTO `storetp` VALUES ('43', '47', '\\images\\16501945710968.jpg');
INSERT INTO `storetp` VALUES ('44', '47', '\\images\\16501945710968.3.jpg');
INSERT INTO `storetp` VALUES ('45', '48', '\\images\\16501946061209.2.jpg');
INSERT INTO `storetp` VALUES ('46', '48', '\\images\\16501946061229.jpg');
INSERT INTO `storetp` VALUES ('47', '49', '\\images\\165019464323210.2.jpg');
INSERT INTO `storetp` VALUES ('48', '49', '\\images\\165019464323210.3.jpg');
INSERT INTO `storetp` VALUES ('49', '49', '\\images\\165019464323210.jpg');
INSERT INTO `storetp` VALUES ('50', '50', '\\images\\165019471256711.3.jpg');
INSERT INTO `storetp` VALUES ('51', '50', '\\images\\165019471256711.jpg');
INSERT INTO `storetp` VALUES ('52', '50', '\\images\\165019471256711.2.jpg');
INSERT INTO `storetp` VALUES ('53', '51', '\\images\\165019474774712.2.jpg');
INSERT INTO `storetp` VALUES ('54', '51', '\\images\\165019474774712.3.jpg');
INSERT INTO `storetp` VALUES ('55', '51', '\\images\\165019474774712.jpg');
INSERT INTO `storetp` VALUES ('56', '52', '\\images\\165019478620413.2.jpg');
INSERT INTO `storetp` VALUES ('57', '52', '\\images\\165019478620413.jpg');
INSERT INTO `storetp` VALUES ('58', '52', '\\images\\165019478620413.3.jpg');
INSERT INTO `storetp` VALUES ('59', '53', '\\images\\165019482586214.3.jpg');
INSERT INTO `storetp` VALUES ('60', '53', '\\images\\165019482586114.jpg');
INSERT INTO `storetp` VALUES ('61', '53', '\\images\\165019482586114.4.jpg');
INSERT INTO `storetp` VALUES ('62', '53', '\\images\\165019482586214.2.jpg');
INSERT INTO `storetp` VALUES ('63', '54', '\\images\\165019486335515.jpg');
INSERT INTO `storetp` VALUES ('64', '54', '\\images\\165019486335515.3.jpg');
INSERT INTO `storetp` VALUES ('65', '54', '\\images\\165019486335515.2.jpg');
INSERT INTO `storetp` VALUES ('66', '55', '\\images\\165019489564417.2.jpg');
INSERT INTO `storetp` VALUES ('67', '55', '\\images\\165019489564517.jpg');
INSERT INTO `storetp` VALUES ('68', '55', '\\images\\165019489564716.jpg');
INSERT INTO `storetp` VALUES ('69', '55', '\\images\\165019489564716.2.jpg');
INSERT INTO `storetp` VALUES ('70', '56', '\\images\\16501949231326.jpg');
INSERT INTO `storetp` VALUES ('71', '56', '\\images\\16501949231323.jpg');
INSERT INTO `storetp` VALUES ('72', '56', '\\images\\16501949231352.jpg');
INSERT INTO `storetp` VALUES ('73', '57', '\\images\\16501949520398.jpg');
INSERT INTO `storetp` VALUES ('74', '58', '\\images\\165026233844620181219150512_18897.jpg');
INSERT INTO `storetp` VALUES ('75', '58', '\\images\\165026233844620181218153631_64502.jpg');

-- ----------------------------
-- Table structure for `thepicturek`
-- ----------------------------
DROP TABLE IF EXISTS `thepicturek`;
CREATE TABLE `thepicturek` (
  `tId` int(100) NOT NULL AUTO_INCREMENT,
  `tproductId` int(100) DEFAULT NULL,
  `thePicture` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`tId`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of thepicturek
-- ----------------------------
INSERT INTO `thepicturek` VALUES ('19', '84', 'images\\16498116355372.png');
INSERT INTO `thepicturek` VALUES ('20', '84', 'images\\164981163553784c7f9d0a1df9d3af5830e94ad96ad81.jpeg');
INSERT INTO `thepicturek` VALUES ('21', '84', 'images\\1649811635540c3528a85d90e352a308e8f4ab9042e9.jpg');
INSERT INTO `thepicturek` VALUES ('22', '86', 'images\\16498119494662.png');
INSERT INTO `thepicturek` VALUES ('23', '86', 'images\\16498119494665a1398477a8e6b5e6eed9339da04a068 - 副本.jpg');
INSERT INTO `thepicturek` VALUES ('24', '86', 'images\\16498119494865%CNULJZU9EXW]J7`RA_XLE.png');
INSERT INTO `thepicturek` VALUES ('25', '86', 'images\\1649811969243476b15bb0a893057ebdcd90a690dfcb8 - 副本.png');
INSERT INTO `thepicturek` VALUES ('26', '86', 'images\\1649811969243271 - 副本.jpg');
INSERT INTO `thepicturek` VALUES ('27', '86', 'images\\1649811969243476b15bb0a893057ebdcd90a690dfcb8 - 副本.jpeg');
INSERT INTO `thepicturek` VALUES ('28', '1', 'images\\1649812407480271.jpg');
INSERT INTO `thepicturek` VALUES ('29', '1', 'images\\1649812407480476b15bb0a893057ebdcd90a690dfcb8 - 副本.jpeg');
INSERT INTO `thepicturek` VALUES ('30', '1', 'images\\16498124074885%CNULJZU9EXW]J7`RA_XLE.png');
INSERT INTO `thepicturek` VALUES ('31', '2', 'images\\16498166314821.png');
INSERT INTO `thepicturek` VALUES ('32', '2', 'images\\164981663148233.jpg');
INSERT INTO `thepicturek` VALUES ('33', '2', 'images\\164981663148216pic_8952841_b.jpg');
INSERT INTO `thepicturek` VALUES ('34', '3', 'images\\1649834820938476b15bb0a893057ebdcd90a690dfcb8 - 副本.jpeg');
INSERT INTO `thepicturek` VALUES ('35', '3', 'images\\1649834820938271 - 副本.jpg');
INSERT INTO `thepicturek` VALUES ('36', '3', 'images\\16498348209475%CNULJZU9EXW]J7`RA_XLE.png');
INSERT INTO `thepicturek` VALUES ('37', '32', 'images\\1650007068732271.jpg');
INSERT INTO `thepicturek` VALUES ('38', '33', 'images\\1650007086178de682859a952e2f557f195f1622255e.jpg');
INSERT INTO `thepicturek` VALUES ('39', '34', 'images\\165000710868384c7f9d0a1df9d3af5830e94ad96ad81.jpeg');
INSERT INTO `thepicturek` VALUES ('40', '58', '\\images\\16501217092205a1398477a8e6b5e6eed9339da04a068 - 副本.jpg');
INSERT INTO `thepicturek` VALUES ('41', '58', '\\images\\1650121709219476b15bb0a893057ebdcd90a690dfcb8 - 副本.png');
INSERT INTO `thepicturek` VALUES ('42', '58', '\\images\\1650121709219476b15bb0a893057ebdcd90a690dfcb8 - 副本.jpeg');
INSERT INTO `thepicturek` VALUES ('43', '59', '\\images\\1650121947848476b15bb0a893057ebdcd90a690dfcb8 - 副本.jpeg');
INSERT INTO `thepicturek` VALUES ('44', '59', '\\images\\1650121947848476b15bb0a893057ebdcd90a690dfcb8 - 副本.png');
INSERT INTO `thepicturek` VALUES ('45', '59', '\\images\\1650121947849476b15bb0a893057ebdcd90a690dfcb8.jpeg');
INSERT INTO `thepicturek` VALUES ('46', '60', '\\images\\16501888407185bf4d7e894a68.jpg');
INSERT INTO `thepicturek` VALUES ('47', '61', '\\images\\16501889169205bf4d75127cad.jpg');
INSERT INTO `thepicturek` VALUES ('48', '62', '\\images\\16501890246995bf4d3a47e503.jpg');
INSERT INTO `thepicturek` VALUES ('49', '63', '\\images\\16501890999275bf4d3fc59403.jpg');
INSERT INTO `thepicturek` VALUES ('50', '63', '\\images\\16501890999295bf4d589db012.jpg');
INSERT INTO `thepicturek` VALUES ('51', '63', '\\images\\16501890999295bf4d578dbc1f.jpg');
INSERT INTO `thepicturek` VALUES ('52', '64', '\\images\\16501891931315bf4d3a47e503.jpg');
INSERT INTO `thepicturek` VALUES ('53', '64', '\\images\\16501891931315bf4d2e12b699.jpg');
INSERT INTO `thepicturek` VALUES ('54', '65', '\\images\\16501892722675bf4d52002d6e.jpg');
INSERT INTO `thepicturek` VALUES ('55', '65', '\\images\\16501892722675bf4d4985c531.jpg');
INSERT INTO `thepicturek` VALUES ('56', '65', '\\images\\16501892722685bf4d5588ef45.jpg');
INSERT INTO `thepicturek` VALUES ('57', '66', '\\images\\16501893281945bf4d3cfaa107.jpg');
INSERT INTO `thepicturek` VALUES ('58', '66', '\\images\\16501893282015bf4d638bfb44.png');
INSERT INTO `thepicturek` VALUES ('59', '67', '\\images\\16501894270015bf4d52002d6e.jpg');
INSERT INTO `thepicturek` VALUES ('60', '67', '\\images\\16501894270035bf4d5588ef45.jpg');
INSERT INTO `thepicturek` VALUES ('61', '67', '\\images\\16501894270075bf4d638bfb44.png');
INSERT INTO `thepicturek` VALUES ('62', '68', '\\images\\165018952348420181127205113_43948.jpg');
INSERT INTO `thepicturek` VALUES ('63', '69', '\\images\\165018977240920181127204951_92620.jpg');
INSERT INTO `thepicturek` VALUES ('64', '69', '\\images\\165018977241120181127204956_31331.jpg');
INSERT INTO `thepicturek` VALUES ('65', '70', '\\images\\16501905708235bf4d537a0db5.jpg');
INSERT INTO `thepicturek` VALUES ('66', '70', '\\images\\16501905708235bf4d486b1c84.jpg');
INSERT INTO `thepicturek` VALUES ('67', '71', '\\images\\165019064347420181127171121_45918.jpg');
INSERT INTO `thepicturek` VALUES ('68', '72', '\\images\\16501907221765bf4d3a47e503.jpg');
INSERT INTO `thepicturek` VALUES ('69', '72', '\\images\\16501907221765bf4d3b439552.jpg');
INSERT INTO `thepicturek` VALUES ('70', '73', '\\images\\165019080420520181127180725_92063.jpg');
INSERT INTO `thepicturek` VALUES ('71', '74', '\\images\\165019088366920181127180122_26513.jpg');
INSERT INTO `thepicturek` VALUES ('72', '75', '\\images\\16501909575435bf4d3ec21767.jpg');
INSERT INTO `thepicturek` VALUES ('73', '75', '\\images\\16501909575435bf4d3dcdab69.jpg');
INSERT INTO `thepicturek` VALUES ('74', '76', '\\images\\16501910181605bf4d7086118a.jpg');
INSERT INTO `thepicturek` VALUES ('75', '76', '\\images\\16501910181605bf4d2cc0888c.jpg');
INSERT INTO `thepicturek` VALUES ('76', '77', '\\images\\16501911184015bf4d4985c531.jpg');
INSERT INTO `thepicturek` VALUES ('77', '77', '\\images\\165019111840220181203182734_39262.jpg');
INSERT INTO `thepicturek` VALUES ('78', '78', '\\images\\165019189339220181203182734_39262.jpg');
INSERT INTO `thepicturek` VALUES ('79', '78', '\\images\\16501918933995bf4d66857743.png');
INSERT INTO `thepicturek` VALUES ('80', '79', '\\images\\16501922949535bf4d52002d6e.jpg');
INSERT INTO `thepicturek` VALUES ('81', '79', '\\images\\16501922949535bf4d60673dfa.jpg');
INSERT INTO `thepicturek` VALUES ('82', '80', '\\images\\16501923620485bf4d7086118a.jpg');
INSERT INTO `thepicturek` VALUES ('83', '80', '\\images\\16501923620485bf4d40aefbd1.jpg');
INSERT INTO `thepicturek` VALUES ('84', '81', '\\images\\16501925843445bf4d486b1c84.jpg');
INSERT INTO `thepicturek` VALUES ('85', '81', '\\images\\16501925843455bf4d578dbc1f.jpg');
INSERT INTO `thepicturek` VALUES ('86', '82', '\\images\\16501926829265bf4d60673dfa.jpg');
INSERT INTO `thepicturek` VALUES ('87', '82', '\\images\\16501926829265bf4d52002d6e.jpg');
INSERT INTO `thepicturek` VALUES ('88', '83', '\\images\\16501927450715bf4d5ea3cf4d.jpg');
INSERT INTO `thepicturek` VALUES ('89', '83', '\\images\\16501927450795bf4d638bfb44.png');
INSERT INTO `thepicturek` VALUES ('90', '84', '\\images\\16501928048945bf4d4985c531.jpg');
INSERT INTO `thepicturek` VALUES ('91', '84', '\\images\\16501928048945bf4d3ec21767.jpg');
INSERT INTO `thepicturek` VALUES ('92', '85', '\\images\\16501928784025bf4d6c6e2441.jpg');
INSERT INTO `thepicturek` VALUES ('93', '86', '\\images\\16501929313365bf4d66857743.png');
INSERT INTO `thepicturek` VALUES ('94', '87', '\\images\\16501929843315bf4d568a42ec.jpg');
INSERT INTO `thepicturek` VALUES ('95', '88', '\\images\\16501930458715bf4d486b1c84.jpg');
INSERT INTO `thepicturek` VALUES ('96', '88', '\\images\\16501930458725bf4d2e12b699.jpg');
INSERT INTO `thepicturek` VALUES ('97', '89', '\\images\\16501931284415bf4d52002d6e.jpg');
INSERT INTO `thepicturek` VALUES ('98', '89', '\\images\\16501931284415bf4d6c6e2441.jpg');
INSERT INTO `thepicturek` VALUES ('99', '90', '\\images\\16501931943855bf4d52002d6e.jpg');
INSERT INTO `thepicturek` VALUES ('100', '90', '\\images\\16501931943865bf4d7086118a.jpg');
INSERT INTO `thepicturek` VALUES ('101', '91', '\\images\\165019326151320181127204956_31331.jpg');
INSERT INTO `thepicturek` VALUES ('102', '92', '\\images\\165019332426920181127171121_45918.jpg');
INSERT INTO `thepicturek` VALUES ('103', '93', '\\images\\165019393088520181127204956_31331.jpg');
INSERT INTO `thepicturek` VALUES ('104', '93', '\\images\\165019393088520181127205113_43948.jpg');
INSERT INTO `thepicturek` VALUES ('105', '94', '\\images\\165019398509020181127205113_43948.jpg');
INSERT INTO `thepicturek` VALUES ('106', '94', '\\images\\165019398509020181127180725_92063.jpg');
INSERT INTO `thepicturek` VALUES ('107', '95', '\\images\\165019407899720181127180122_26513.jpg');
INSERT INTO `thepicturek` VALUES ('108', '95', '\\images\\165019407899720181127171121_45918.jpg');
INSERT INTO `thepicturek` VALUES ('109', '95', '\\images\\165019407899720181127204956_31331.jpg');
INSERT INTO `thepicturek` VALUES ('110', '96', '\\images\\165026226559020181219150512_18897.jpg');
INSERT INTO `thepicturek` VALUES ('111', '96', '\\images\\165026226559020181218153631_64502.jpg');

-- ----------------------------
-- Table structure for `txt`
-- ----------------------------
DROP TABLE IF EXISTS `txt`;
CREATE TABLE `txt` (
  `txtId` int(100) NOT NULL AUTO_INCREMENT,
  `txtcompany` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `txtname` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `txttel` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `txtaddress` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `txtcontent` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `time` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `state` int(100) DEFAULT NULL,
  PRIMARY KEY (`txtId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of txt
-- ----------------------------
INSERT INTO `txt` VALUES ('21', '九云国际有限公司', '谢文', '15574776883', '湘潭市九华创新创业', '加盟3个w', '2022-04-18 11:33:01', null);
INSERT INTO `txt` VALUES ('22', '九华家具公司', '谢小文', '15574776883', '九华创新创业中心', '加盟5个w', '2022-04-18 11:56:02', null);
INSERT INTO `txt` VALUES ('23', '国防科技有限公司', '迪迦', '15574776883', 'm78星云', '为了光之国装修', '2022-04-18 11:58:27', null);
INSERT INTO `txt` VALUES ('24', '撒旦公司', '撒旦', '15574776883', '湖南省衡阳市耒阳市', '啊吧啊吧啊吧啊', '2022-04-18 12:01:11', null);
INSERT INTO `txt` VALUES ('25', '阿三公司', '阿三', '15574776883', '北京市', '公司转行卖地板了', '2022-04-18 12:03:26', null);
INSERT INTO `txt` VALUES ('26', '地板公司', '小王', '15574776883', '湘潭市雨湖区', '希望和你合作', '2022-04-18 12:06:07', null);
INSERT INTO `txt` VALUES ('27', '九云', '谢文', '13875278484', '阿斯顿撒旦', '啊大多数', '2022-04-18 14:08:18', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(100) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `mailbox` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `age` int(100) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('44', 'jay7', '7777', '2646648067@qq.com', '18');
INSERT INTO `user` VALUES ('45', 'jay8', '8888', '2646648067@qq.com', '18');
INSERT INTO `user` VALUES ('46', 'jay', '1111', '2646648067@qq.com', '18');
INSERT INTO `user` VALUES ('47', 'jay2', '2222', '2646648067@qq.com', '18');
INSERT INTO `user` VALUES ('48', 'jay3', '3333', '2646648067@qq.com', '18');
INSERT INTO `user` VALUES ('49', 'jay', '', '', null);
INSERT INTO `user` VALUES ('50', 'jay8', '8888', '2646648067@qq.com', '18');
