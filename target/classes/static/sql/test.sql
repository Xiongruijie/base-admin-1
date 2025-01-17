/*
Navicat MySQL Data Transfer

Source Server         : MyConnect
Source Server Version : 80029
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80029
File Encoding         : 65001

Date: 2022-09-02 10:15:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for biochemical_test_table
-- ----------------------------
DROP TABLE IF EXISTS `biochemical_test_table`;
CREATE TABLE `biochemical_test_table` (
  `biochemical_id` int NOT NULL AUTO_INCREMENT,
  `biochemical_name` varchar(255) DEFAULT NULL,
  `biochemical_shorthand` varchar(255) DEFAULT NULL,
  `biochemical_ch` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`biochemical_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of biochemical_test_table
-- ----------------------------
INSERT INTO `biochemical_test_table` VALUES ('1', 'Indole production', 'Ind', '吲哚');
INSERT INTO `biochemical_test_table` VALUES ('2', 'Methyl red', 'MR', 'MR');
INSERT INTO `biochemical_test_table` VALUES ('3', 'Voges-Proskauer', null, 'VP');
INSERT INTO `biochemical_test_table` VALUES ('4', 'Citrate', 'Cit', '柠檬酸盐');
INSERT INTO `biochemical_test_table` VALUES ('5', 'Hydrogen sulfide', 'H2S', 'TSI');
INSERT INTO `biochemical_test_table` VALUES ('6', 'Urea hydrolysis', 'Ure', '尿酶');
INSERT INTO `biochemical_test_table` VALUES ('7', 'Phenylalanine deaminase', 'Phe', '苯丙氨酸\r\n脱氨酶');
INSERT INTO `biochemical_test_table` VALUES ('8', 'Lysine decarboxylase', 'Lys', '赖氨酸脱羧酶');
INSERT INTO `biochemical_test_table` VALUES ('9', 'Arginine dihydrolase', null, '精\r\n氨酸双水解酶');
INSERT INTO `biochemical_test_table` VALUES ('10', 'Ornithine decarboxylase', 'Orn', '鸟氨酸脱羧酶');
INSERT INTO `biochemical_test_table` VALUES ('11', 'Motility', null, '动力');
INSERT INTO `biochemical_test_table` VALUES ('12', 'Gelatin hydrolysis', null, '明胶');
INSERT INTO `biochemical_test_table` VALUES ('13', 'Growth in KCN', null, '氰化钾生长');
INSERT INTO `biochemical_test_table` VALUES ('14', 'Malonate utilization', 'Malo', '丙二酸盐');
INSERT INTO `biochemical_test_table` VALUES ('15', 'Esculin hydrolysis', 'Esc', '七叶苷水解');
INSERT INTO `biochemical_test_table` VALUES ('16', 'Tartrate Jordan’s', null, '酒石酸盐琼脂');
INSERT INTO `biochemical_test_table` VALUES ('17', 'Acetate utilization', null, '醋酸盐');
INSERT INTO `biochemical_test_table` VALUES ('18', 'Lipase (corn oil)', null, '酯酶');
INSERT INTO `biochemical_test_table` VALUES ('19', 'DNase', null, 'DNA 酶');
INSERT INTO `biochemical_test_table` VALUES ('20', 'Nitrate oxidized to nitrite', null, '硝酸盐还原');
INSERT INTO `biochemical_test_table` VALUES ('21', 'Oxidase, Kovacs', 'Ox', '氧化酶');
INSERT INTO `biochemical_test_table` VALUES ('22', 'ONPG', 'ONPG', 'ONPG');
INSERT INTO `biochemical_test_table` VALUES ('23', 'Yellow pigment', null, '黄色素');
INSERT INTO `biochemical_test_table` VALUES ('24', 'D-Glucose, acid', null, '产酸');
INSERT INTO `biochemical_test_table` VALUES ('25', 'D-Glucose, gas', null, '产气');
INSERT INTO `biochemical_test_table` VALUES ('26', 'Adonitol', null, '侧金盏花醇');
INSERT INTO `biochemical_test_table` VALUES ('27', 'L-Arabinose', 'Ara', '阿拉伯糖');
INSERT INTO `biochemical_test_table` VALUES ('28', 'D-Arabitol', null, '阿拉伯糖醇');
INSERT INTO `biochemical_test_table` VALUES ('29', 'Cellobiose', 'Cel', '纤维二糖');
INSERT INTO `biochemical_test_table` VALUES ('30', 'Dulcitol', 'Dul', '卫矛醇');
INSERT INTO `biochemical_test_table` VALUES ('31', 'Erythritol', null, '丁四醇');
INSERT INTO `biochemical_test_table` VALUES ('32', 'Glycerol', null, '甘油');
INSERT INTO `biochemical_test_table` VALUES ('33', 'myo-Inositol', null, '肌醇');
INSERT INTO `biochemical_test_table` VALUES ('34', 'Lactose', 'Lac', '乳糖');
INSERT INTO `biochemical_test_table` VALUES ('35', 'Maltose', 'Malt', '麦芽糖');
INSERT INTO `biochemical_test_table` VALUES ('36', 'D-Mannitol', null, '甘露醇');
INSERT INTO `biochemical_test_table` VALUES ('37', 'D-Mannose', null, '甘露糖');
INSERT INTO `biochemical_test_table` VALUES ('38', 'Melibiose', 'Mel', '蜜\r\n二糖');
INSERT INTO `biochemical_test_table` VALUES ('39', 'α-Methyl-D-glucoside', null, 'α-D-甲基葡萄糖');
INSERT INTO `biochemical_test_table` VALUES ('40', 'Mucate', null, '粘液酸');
INSERT INTO `biochemical_test_table` VALUES ('41', 'Raffinose', 'Raf', '棉子糖');
INSERT INTO `biochemical_test_table` VALUES ('42', 'L-Rhamnose', 'Rha', '鼠李糖');
INSERT INTO `biochemical_test_table` VALUES ('43', 'Salicin', null, '水杨苷');
INSERT INTO `biochemical_test_table` VALUES ('44', 'D-Sorbitol', 'Sor', '山梨醇');
INSERT INTO `biochemical_test_table` VALUES ('45', 'Sucrose', 'Suc', '蔗糖');
INSERT INTO `biochemical_test_table` VALUES ('46', 'Trehalose', 'Tre', '海藻糖');
INSERT INTO `biochemical_test_table` VALUES ('47', 'D-\r\nXylose', 'Xyl', '木糖');

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `series` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'id',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '登陆账号',
  `token` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'cookie令牌',
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT COMMENT='persistent_logins表，用户实现记住我功能';

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins` VALUES ('0ja9lGXC4Iy9511a5qLh6g==', 'sa', 'BMOC9IVj+b2sq02cgJ9PeQ==', '2022-08-25 06:19:51');
INSERT INTO `persistent_logins` VALUES ('0jpeihOWDxrOW/f7eCIttg==', 'sa', 'BxETYdNb8QZnpYaf4hm56A==', '2022-08-25 06:47:32');
INSERT INTO `persistent_logins` VALUES ('NoU0JmA8NTaSzoaPEAf1Ww==', 'sa', 'SKoqM/3+sznMZKYi6j4URA==', '2022-09-01 19:21:24');
INSERT INTO `persistent_logins` VALUES ('VL9NMrDbL7wvc6o3dxjrng==', 'sa', 'DRiv6JQCIrJ2ERGBTOlAAA==', '2022-07-28 10:47:50');

-- ----------------------------
-- Table structure for query
-- ----------------------------
DROP TABLE IF EXISTS `query`;
CREATE TABLE `query` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `input_date` varchar(50) DEFAULT NULL,
  `sample_type` varchar(50) DEFAULT NULL,
  `sample_number` varchar(50) DEFAULT NULL,
  `sample_source` varchar(50) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `Phe` varchar(50) DEFAULT NULL,
  `Xyl` varchar(50) DEFAULT NULL,
  `Raf` varchar(50) DEFAULT NULL,
  `Ind` varchar(50) DEFAULT NULL,
  `Suc` varchar(50) DEFAULT NULL,
  `Orn` varchar(50) DEFAULT NULL,
  `Lac` varchar(50) DEFAULT NULL,
  `ONPG` varchar(50) DEFAULT NULL,
  `Ure` varchar(50) DEFAULT NULL,
  `Cit` varchar(50) DEFAULT NULL,
  `Malt` varchar(50) DEFAULT NULL,
  `Lys` varchar(50) DEFAULT NULL,
  `Malo` varchar(50) DEFAULT NULL,
  `Sor` varchar(50) DEFAULT NULL,
  `Dul` varchar(50) DEFAULT NULL,
  `Ara` varchar(50) DEFAULT NULL,
  `Mel` varchar(50) DEFAULT NULL,
  `Rha` varchar(50) DEFAULT NULL,
  `Esc` varchar(50) DEFAULT NULL,
  `MR` varchar(50) DEFAULT NULL,
  `H2S` varchar(50) DEFAULT NULL,
  `Tre` varchar(50) DEFAULT NULL,
  `Cel` varchar(50) DEFAULT NULL,
  `Ox` varchar(50) DEFAULT NULL,
  `result` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `query_table_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of query
-- ----------------------------
INSERT INTO `query` VALUES ('45', '544065797@qq.com', '2022-08-31 19:08:56', '3', null, '3', '3', '+', '+', '-', '+', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Providencia rustigianii');
INSERT INTO `query` VALUES ('46', '544065797@qq.com', '2022-08-31 19:08:07', '3', null, '3', '3', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '+', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Enterobacter cloacae');
INSERT INTO `query` VALUES ('47', '544065797@qq.com', '2022-08-31 20:08:08', '3', null, '3', '3', '+', '+', '-', '+', '+', '-', '+', '+', '-', '+', '+', '-', '+', '+', '-', '+', '+', '-', '+', '+', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Pantoea agglomerans');
INSERT INTO `query` VALUES ('48', '544065797@qq.com', '2022-09-01 14:09:52', '2', null, '2', '', '+', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Tatumella ptyseos');
INSERT INTO `query` VALUES ('49', '544065797@qq.com', '2022-09-01 14:09:01', '2', null, '2', '', '+', '+', '+', '+', '+', '+', '+', '+', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Morganella morganii biogroup 1');
INSERT INTO `query` VALUES ('50', '544065797@qq.com', '2022-09-01 14:09:10', '2', null, '2', '', '+', '+', '+', '+', '+', '-', '+', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Pantoea agglomerans');
INSERT INTO `query` VALUES ('51', '544065797@qq.com', '2022-09-01 14:09:52', '2', null, '2', '', '-', '+', '-', '-', '+', '-', '-', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 可接受的鉴定结果: Tatumella ptyseos');
INSERT INTO `query` VALUES ('52', '544065797@qq.com', '2022-09-01 14:09:04', '2', null, '2', '', '+', '+', '-', '+', '+', '-', '+', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Pantoea agglomerans');
INSERT INTO `query` VALUES ('53', '544065797@qq.com', '2022-09-01 14:09:10', '2', null, '2', '', '+', '-', '-', '+', '+', '-', '+', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Pantoea agglomerans');
INSERT INTO `query` VALUES ('54', '544065797@qq.com', '2022-09-01 14:09:27', '3', null, '3', '', '+', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Tatumella ptyseos');
INSERT INTO `query` VALUES ('55', '544065797@qq.com', '2022-09-01 14:09:52', '3', null, '3', '', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Tatumella ptyseos');
INSERT INTO `query` VALUES ('56', '544065797@qq.com', '2022-09-01 14:09:33', '3', null, '3', '', '+', '+', '-', '+', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Providencia rustigianii');
INSERT INTO `query` VALUES ('57', '544065797@qq.com', '2022-09-01 14:09:12', '3', null, '3', '', '+', '+', '-', '+', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Providencia rustigianii');
INSERT INTO `query` VALUES ('58', '544065797@qq.com', '2022-09-01 15:09:05', '2', null, '2', '2', '+', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Tatumella ptyseos');
INSERT INTO `query` VALUES ('59', '544065797@qq.com', '2022-09-01 15:09:06', '2', null, '2', '2', '+', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Tatumella ptyseos');
INSERT INTO `query` VALUES ('60', '544065797@qq.com', '2022-09-01 15:09:07', '2', null, '2', '2', '+', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Tatumella ptyseos');
INSERT INTO `query` VALUES ('61', '544065797@qq.com', '2022-09-01 15:09:34', '3', null, '3', '3', '+', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Tatumella ptyseos');
INSERT INTO `query` VALUES ('62', '544065797@qq.com', '2022-09-01 16:09:11', '22', null, '2', '2', '-', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Tatumella ptyseos');
INSERT INTO `query` VALUES ('63', '544065797@qq.com', '2022-09-01 16:09:38', '2', null, '2', '23', '+', '+', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '结果评价: 不可接受的鉴定结果: Tatumella ptyseos');

-- ----------------------------
-- Table structure for strain_table
-- ----------------------------
DROP TABLE IF EXISTS `strain_table`;
CREATE TABLE `strain_table` (
  `strain_id` int NOT NULL,
  `strain_name` varchar(255) DEFAULT NULL,
  `strain_ch_name` varchar(255) DEFAULT NULL,
  `strain_class` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`strain_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Records of strain_table
-- ----------------------------
INSERT INTO `strain_table` VALUES ('1', 'Escherichia coli', '大肠埃希氏菌', 'Escherichia');
INSERT INTO `strain_table` VALUES ('2', 'Escherichia col,inactive', '无活力大肠埃希氏菌', 'Escherichia');
INSERT INTO `strain_table` VALUES ('3', 'Escherichia blattae', '蟑螂埃希氏菌', 'Escherichia');
INSERT INTO `strain_table` VALUES ('4', 'Escherichia fergusanii', '弗格森埃希氏菌', 'Escherichia');
INSERT INTO `strain_table` VALUES ('5', 'Escherichia hermannii', '赫氏埃希氏菌', 'Escherichia');
INSERT INTO `strain_table` VALUES ('6', 'Escherichia vulneris', '伤口埃希氏菌', 'Escherichia');
INSERT INTO `strain_table` VALUES ('7', 'Budvicia aquatia', '水生布戴约维采菌', 'Budvicia');
INSERT INTO `strain_table` VALUES ('8', 'Buttiauxella agrestis', '乡间布丘氏菌', 'Buttiauxella');
INSERT INTO `strain_table` VALUES ('9', 'Buttiauxella brennerae', null, 'Buttiauxella');
INSERT INTO `strain_table` VALUES ('10', 'Buttiauxella ferragutiae', '布丘氏菌属', 'Buttiauxella');
INSERT INTO `strain_table` VALUES ('11', 'Buttiauxella gaviniae', null, 'Buttiauxella');
INSERT INTO `strain_table` VALUES ('12', 'Buttiauxella izardii', null, 'Buttiauxella');
INSERT INTO `strain_table` VALUES ('13', 'Buttiauxella noackiae', null, 'Buttiauxella');
INSERT INTO `strain_table` VALUES ('14', 'Buttiauxella warmboldiae', null, 'Buttiauxella');
INSERT INTO `strain_table` VALUES ('15', 'cedecea davisae', '戴氏西地西菌', 'cedecea');
INSERT INTO `strain_table` VALUES ('16', 'cedecea lapagei', '拉氏西地西菌', 'cedecea');
INSERT INTO `strain_table` VALUES ('17', 'cedecea neteri', '奈氏西地西菌', 'cedecea');
INSERT INTO `strain_table` VALUES ('18', 'cedecea species 3', null, 'cedecea');
INSERT INTO `strain_table` VALUES ('19', 'cedecea species 5', null, 'cedecea');
INSERT INTO `strain_table` VALUES ('20', 'Citrobacter amalonaticu', '无丙二酸盐柠檬酸杆菌', 'Citrobacter');
INSERT INTO `strain_table` VALUES ('21', 'Citrobacter freundii', '弗氏柠檬酸杆菌', 'Citrobacter');
INSERT INTO `strain_table` VALUES ('22', 'Citrobacter braakii', '布氏柠檬酸杆菌', 'Citrobacter');
INSERT INTO `strain_table` VALUES ('23', 'Citrobacter farmeri', '法氏柠檬酸杆菌', 'Citrobacter');
INSERT INTO `strain_table` VALUES ('24', 'Citrobacter gillenii', null, 'Citrobacter');
INSERT INTO `strain_table` VALUES ('25', 'Citrobacter koseri(C.diversus)', '差异柠檬酸杆菌', 'Citrobacter');
INSERT INTO `strain_table` VALUES ('26', 'Citrobacter murliniae', null, 'Citrobacter');
INSERT INTO `strain_table` VALUES ('27', 'Citrobacter rodentium', '腐蚀柠檬酸杆菌', 'Citrobacter');
INSERT INTO `strain_table` VALUES ('28', 'Citrobacter sedlakii', '塞氏柠檬酸杆菌', 'Citrobacter');
INSERT INTO `strain_table` VALUES ('29', 'Citrobacter werkmanii', '魏氏柠檬酸杆菌', 'Citrobacter');
INSERT INTO `strain_table` VALUES ('30', 'Citrobacter youngae', '杨氏柠檬酸杆菌', 'Citrobacter');
INSERT INTO `strain_table` VALUES ('31', 'Edwardsiella tarda', '迟钝爱德华氏菌', 'Edwardsiella');
INSERT INTO `strain_table` VALUES ('32', 'Edwardsiella tarda biogroup 1', null, 'Edwardsiella');
INSERT INTO `strain_table` VALUES ('33', 'Edwardsiella hoshinae', '保科爱德华氏菌', 'Edwardsiella');
INSERT INTO `strain_table` VALUES ('34', 'Edwardsiella ictaluri', '鲶鱼爱德华氏菌', 'Edwardsiella');
INSERT INTO `strain_table` VALUES ('35', 'Enterobacter cloacae', '阴沟肠杆菌', 'Enterobacter');
INSERT INTO `strain_table` VALUES ('36', 'Enterobacter aerogenes', '产气肠杆菌', 'Enterobacter');
INSERT INTO `strain_table` VALUES ('37', 'Enterobacter amnigenus biogroup 1', '河生肠杆菌 1', 'Enterobacter');
INSERT INTO `strain_table` VALUES ('38', 'Enterobacter amnigenus biogroup 2', '河生肠杆菌 2', 'Enterobacter');
INSERT INTO `strain_table` VALUES ('39', 'Enterobacter asburiae', '阿氏肠杆菌', 'Enterobacter');
INSERT INTO `strain_table` VALUES ('40', 'Enterobacter cancerogenus(E.taylorae)', '生癌肠杆菌', 'Enterobacter');
INSERT INTO `strain_table` VALUES ('41', 'Enterobacter dissolvens', '溶解肠杆菌', 'Enterobacter');
INSERT INTO `strain_table` VALUES ('42', 'Enterobacter gergoviae', '热戈尔维肠杆菌', 'Enterobacter');
INSERT INTO `strain_table` VALUES ('43', 'Enterobacter hormaechei', '霍氏肠杆菌', 'Enterobacter');
INSERT INTO `strain_table` VALUES ('44', 'Enterobacter intermedius', '中间肠杆菌', 'Enterobacter');
INSERT INTO `strain_table` VALUES ('45', 'Enterobacter nimipressuralis', '超压肠杆菌', 'Enterobacter');
INSERT INTO `strain_table` VALUES ('46', 'Enterobacter pyrinus', '梨形肠杆菌', 'Enterobacter');
INSERT INTO `strain_table` VALUES ('47', 'Enterobacter sakazakii', '坂崎肠杆菌', 'Enterobacter');
INSERT INTO `strain_table` VALUES ('48', 'Ewingella americana', '美洲爱文氏菌', 'Ewingella');
INSERT INTO `strain_table` VALUES ('49', 'Hafnia alvei', '蜂房哈夫尼菌', 'Hafnia');
INSERT INTO `strain_table` VALUES ('50', 'Hafnia alvei biogroup 1', null, 'Hafnia');
INSERT INTO `strain_table` VALUES ('51', 'Klebsiella pneumoniae subsp. Ozaenae', '鼻炎克雷伯氏菌', 'Klebsiella');
INSERT INTO `strain_table` VALUES ('52', 'Klebsiella pneumoniae subsp. Pneumoniae', '肺炎克雷伯氏菌', 'Klebsiella');
INSERT INTO `strain_table` VALUES ('53', 'Klebsiella pneumoniae subsp. Rhinoscleromatis', '鼻硬结克雷伯氏菌', 'Klebsiella');
INSERT INTO `strain_table` VALUES ('54', 'Klebsiella oxytoca', '产酸克雷伯氏菌', 'Klebsiella');
INSERT INTO `strain_table` VALUES ('55', 'Klebsiella oxytoca orithine positive', '产酸克雷伯氏菌鸟氨酸阳性', 'Klebsiella');
INSERT INTO `strain_table` VALUES ('56', 'Klebsiella planticola', '植生克雷伯氏菌', 'Klebsiella');
INSERT INTO `strain_table` VALUES ('57', 'Klebsiella terrigena', '土生克雷伯氏菌', 'Klebsiella');
INSERT INTO `strain_table` VALUES ('58', 'Kluyvera ascorbata', '抗坏血酸克吕沃尔氏菌', 'Kluyvera');
INSERT INTO `strain_table` VALUES ('59', 'Kluyvera cryocrescens', '栖冷克吕沃尔氏菌', 'Kluyvera');
INSERT INTO `strain_table` VALUES ('60', 'Kluyvera genrgiana', null, 'Kluyvera');
INSERT INTO `strain_table` VALUES ('61', 'Leclercia adecarboxylata', '非脱羧勒克氏菌', 'Leclercia');
INSERT INTO `strain_table` VALUES ('62', 'Leminorella grimontii', '格氏勒米诺氏菌', 'Leminorella');
INSERT INTO `strain_table` VALUES ('63', 'Leminorella richardii', '理氏勒米诺氏菌', 'Leminorella');
INSERT INTO `strain_table` VALUES ('64', 'Moellerella wisconsensis', '威斯康星米勒氏菌', 'Moellerella');
INSERT INTO `strain_table` VALUES ('65', 'Morganella morganii subsp. Morganii', '摩氏摩根氏菌摩根氏亚种', 'Morganella');
INSERT INTO `strain_table` VALUES ('66', 'Morganella morganii subsp. Sibonii', '摩氏摩根氏菌塞氏亚种', 'Morganella');
INSERT INTO `strain_table` VALUES ('67', 'Morganella morganii biogroup 1', null, 'Morganella');
INSERT INTO `strain_table` VALUES ('68', 'Obesumbacterium proteus biogroup 2', '变形黄杆菌', 'Obesumbacterium');
INSERT INTO `strain_table` VALUES ('69', 'Pantoea agglomerans', '', 'Pantoea');
INSERT INTO `strain_table` VALUES ('70', 'Pantoea dispersa', '分散泛菌', 'Pantoea');
INSERT INTO `strain_table` VALUES ('71', 'Photorhabdus luminescens', '发光光杆状菌', 'Photorhabdus');
INSERT INTO `strain_table` VALUES ('72', 'Photorhabdus DNA hybridization group 5', '非共生光杆菌', 'Photorhabdus');
INSERT INTO `strain_table` VALUES ('73', 'Pragia fontium', '泉水布拉格菌', 'Pragia');
INSERT INTO `strain_table` VALUES ('74', 'Proteus vulgaris', '变通变形杆菌', 'Proteus');
INSERT INTO `strain_table` VALUES ('75', 'Proteus mirabilis', '奇异变形杆菌', 'Proteus');
INSERT INTO `strain_table` VALUES ('76', 'Proteus myxofaciens', '产粘变形菌', 'Proteus');
INSERT INTO `strain_table` VALUES ('77', 'Proteus penneri', '彭氏变形菌', 'Proteus');
INSERT INTO `strain_table` VALUES ('78', 'Providencia alcalifaciens', '产碱普罗威登斯菌', 'Providencia');
INSERT INTO `strain_table` VALUES ('79', 'Providencia heimbachae', '海氏普罗威登斯菌', 'Providencia');
INSERT INTO `strain_table` VALUES ('80', 'Providencia rettgeri', '雷氏普罗威登斯菌', 'Providencia');
INSERT INTO `strain_table` VALUES ('81', 'Providencia rustigianii', '拉氏普罗威登斯菌', 'Providencia');
INSERT INTO `strain_table` VALUES ('82', 'Providencia stuarlii', '斯氏普罗威登斯菌', 'Providencia');
INSERT INTO `strain_table` VALUES ('83', 'Rahnella aquatilis', '水生拉恩氏菌', 'Rahnella');
INSERT INTO `strain_table` VALUES ('84', 'Salmonella bongori', '邦戈尔沙门氏菌', 'Salmonella');
INSERT INTO `strain_table` VALUES ('85', 'Salmonella enterica subsp. Enterica', '肠道沙门氏菌 Ⅰ', 'Salmonella');
INSERT INTO `strain_table` VALUES ('86', 'Salmonella enterica subsp.arizonae', '亚利桑那沙门氏菌 Ⅲa', 'Salmonella');
INSERT INTO `strain_table` VALUES ('87', 'Salmonella enterica subsp.diarizonae', '双相亚利桑那沙门氏菌 Ⅲb', 'Salmonella');
INSERT INTO `strain_table` VALUES ('88', 'Salmonella enterica subsp.houtenae', '豪顿沙门氏菌 Ⅳ', 'Salmonella');
INSERT INTO `strain_table` VALUES ('89', 'Salmonella enterica subsp.indica', '印度沙门氏菌 Ⅴ', 'Salmonella');
INSERT INTO `strain_table` VALUES ('90', 'Salmonella enterica subsp.salamae', '萨拉姆沙门氏菌 Ⅱ', 'Salmonella');
INSERT INTO `strain_table` VALUES ('91', 'Salmonella serovar choleraesuis', '猪霍乱沙门氏菌', 'Salmonella');
INSERT INTO `strain_table` VALUES ('92', 'Salmonella serovar Gallinarum', '鸡伤寒沙门氏菌', 'Salmonella');
INSERT INTO `strain_table` VALUES ('93', 'Salmonella serovar paratyphi A', '甲型副伤寒沙门氏菌', 'Salmonella');
INSERT INTO `strain_table` VALUES ('94', 'Salmonella serovar pullorum', '鸡白痢沙门氏菌', 'Salmonella');
INSERT INTO `strain_table` VALUES ('95', 'Salmonella serovar typhi', '伤寒沙门氏菌', 'Salmonella');
INSERT INTO `strain_table` VALUES ('96', 'Serratia marcescens', '粘质沙雷氏菌', 'Serratia');
INSERT INTO `strain_table` VALUES ('97', 'Serratia entomophila', '嗜虫沙雷氏菌', 'Serratia');
INSERT INTO `strain_table` VALUES ('98', 'Serratia ficaria', '无花果沙雷氏菌', 'Serratia');
INSERT INTO `strain_table` VALUES ('99', 'Serratia fonticola', '居泉沙雷氏菌', 'Serratia');
INSERT INTO `strain_table` VALUES ('100', 'Serratia liquefaciens', '液化沙雷氏菌', 'Serratia');
INSERT INTO `strain_table` VALUES ('101', 'Serratia marcescens biogroup 1', '粘质沙雷氏菌 1型', 'Serratia');
INSERT INTO `strain_table` VALUES ('102', 'Serratia odorifera biogroup 1', '气味沙雷氏菌 1型', 'Serratia');
INSERT INTO `strain_table` VALUES ('103', 'Serratia odorifera biogroup 2', '气味沙雷氏菌 2型', 'Serratia');
INSERT INTO `strain_table` VALUES ('104', 'Serratia plymuthica', '普利茅斯沙雷氏菌', 'Serratia');
INSERT INTO `strain_table` VALUES ('105', 'Serratia rubidaea', '深红沙雷氏菌', 'Serratia');
INSERT INTO `strain_table` VALUES ('106', 'Shigella dysenteriae', '痢疾志贺氏菌，Group A', 'Shigella');
INSERT INTO `strain_table` VALUES ('107', 'Shigella boydii', '鲍氏志贺氏菌，Group C', 'Shigella');
INSERT INTO `strain_table` VALUES ('108', 'Shigella flexneri', '弗氏志贺氏菌，Group B', 'Shigella');
INSERT INTO `strain_table` VALUES ('109', 'Shigella sonnei', '宋内志贺氏菌，Group D', 'Shigella');
INSERT INTO `strain_table` VALUES ('110', 'Tatumella ptyseos', '痰塔特姆氏菌', 'Tatumella');
INSERT INTO `strain_table` VALUES ('111', 'Trabulsiella guamensis', '关岛特拉布斯氏菌', 'Trabulsiella');
INSERT INTO `strain_table` VALUES ('112', 'Xenorhabdus nematophilus', '嗜线虫致病杆菌', 'Xenorhabdus');
INSERT INTO `strain_table` VALUES ('113', 'Yersinia pestis', '鼠疫耶尔森氏菌', 'Yersinia');
INSERT INTO `strain_table` VALUES ('114', 'Yersinia aldovae', null, 'Yersinia');
INSERT INTO `strain_table` VALUES ('115', 'Yersinia bercovieri', '伯氏耶尔森氏菌', 'Yersinia');
INSERT INTO `strain_table` VALUES ('116', 'Yersinia enterocolitica', '小肠结肠炎耶尔森氏菌', 'Yersinia ');
INSERT INTO `strain_table` VALUES ('117', 'Yersinia frederiksenii', '弗氏耶尔森氏菌', 'Yersinia');
INSERT INTO `strain_table` VALUES ('118', 'Yersinia intermedia', '中间耶尔森氏菌', 'Yersinia');
INSERT INTO `strain_table` VALUES ('119', 'Yersinia kristensenii', '克氏耶尔森氏菌', 'Yersinia');
INSERT INTO `strain_table` VALUES ('120', 'Yersinia mollaretii', '莫氏耶尔森氏菌', 'Yersinia');
INSERT INTO `strain_table` VALUES ('121', 'Yersinia pseudotubercttlosis', '假结核耶尔森氏菌', 'Yersinia');
INSERT INTO `strain_table` VALUES ('122', 'Yersinia rohdei', '罗氏耶尔森氏菌', 'Yersinia');
INSERT INTO `strain_table` VALUES ('123', 'Yersinia ruckeri', '鲁氏耶尔森氏菌', 'Yersinia');
INSERT INTO `strain_table` VALUES ('124', 'Yokenella regensburgei', '雷金斯堡预研菌', 'Yokenella');
INSERT INTO `strain_table` VALUES ('125', 'Enteric Group 58', null, 'Enteric');
INSERT INTO `strain_table` VALUES ('126', 'Enteric Group 60', null, 'Enteric');
INSERT INTO `strain_table` VALUES ('127', 'Enteric Group 68', null, 'Enteric');
INSERT INTO `strain_table` VALUES ('128', 'Enteric Group 69', null, 'Enteric');

-- ----------------------------
-- Table structure for strain_test_table
-- ----------------------------
DROP TABLE IF EXISTS `strain_test_table`;
CREATE TABLE `strain_test_table` (
  `strain_id` int NOT NULL,
  `test_1` int DEFAULT NULL,
  `test_2` int DEFAULT NULL,
  `test_3` int DEFAULT NULL,
  `test_4` int DEFAULT NULL,
  `test_5` int DEFAULT NULL,
  `test_6` int DEFAULT NULL,
  `test_7` int DEFAULT NULL,
  `test_8` int DEFAULT NULL,
  `test_9` int DEFAULT NULL,
  `test_10` int DEFAULT NULL,
  `test_11` int DEFAULT NULL,
  `test_12` int DEFAULT NULL,
  `test_13` int DEFAULT NULL,
  `test_14` int DEFAULT NULL,
  `test_15` int DEFAULT NULL,
  `test_16` int DEFAULT NULL,
  `test_17` int DEFAULT NULL,
  `test_18` int DEFAULT NULL,
  `test_19` int DEFAULT NULL,
  `test_20` int DEFAULT NULL,
  `test_21` int DEFAULT NULL,
  `test_22` int DEFAULT NULL,
  `test_23` int DEFAULT NULL,
  `test_24` int DEFAULT NULL,
  `test_25` int DEFAULT NULL,
  `test_26` int DEFAULT NULL,
  `test_27` int DEFAULT NULL,
  `test_28` int DEFAULT NULL,
  `test_29` int DEFAULT NULL,
  `test_30` int DEFAULT NULL,
  `test_31` int DEFAULT NULL,
  `test_32` int DEFAULT NULL,
  `test_33` int DEFAULT NULL,
  `test_34` int DEFAULT NULL,
  `test_35` int DEFAULT NULL,
  `test_36` int DEFAULT NULL,
  `test_37` int DEFAULT NULL,
  `test_38` int DEFAULT NULL,
  `test_39` int DEFAULT NULL,
  `test_40` int DEFAULT NULL,
  `test_41` int DEFAULT NULL,
  `test_42` int DEFAULT NULL,
  `test_43` int DEFAULT NULL,
  `test_44` int DEFAULT NULL,
  `test_45` int DEFAULT NULL,
  `test_46` int DEFAULT NULL,
  `test_47` int DEFAULT NULL,
  PRIMARY KEY (`strain_id`),
  CONSTRAINT `strain_id` FOREIGN KEY (`strain_id`) REFERENCES `strain_table` (`strain_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of strain_test_table
-- ----------------------------
INSERT INTO `strain_test_table` VALUES ('1', '98', '99', '0', '1', '1', '1', '0', '90', '17', '65', '95', '0', '3', '0', '35', '95', '90', '0', '0', '100', '0', '95', '0', '100', '95', '5', '99', '5', '2', '60', '0', '75', '1', '95', '95', '98', '98', '75', '0', '95', '50', '80', '40', '94', '50', '98', '95');
INSERT INTO `strain_test_table` VALUES ('2', '80', '95', '0', '1', '1', '1', '0', '40', '3', '20', '5', '0', '1', '0', '5', '85', '40', '0', '0', '98', '0', '45', '0', '100', '5', '3', '85', '5', '2', '40', '0', '65', '1', '25', '80', '93', '97', '40', '0', '30', '15', '65', '10', '75', '15', '90', '70');
INSERT INTO `strain_test_table` VALUES ('3', '0', '100', '0', '50', '0', '0', '0', '100', '0', '100', '0', '0', '0', '100', '0', '50', '0', '0', '0', '100', '0', '0', '0', '100', '100', '0', '100', '0', '0', '0', '0', '100', '0', '0', '100', '0', '100', '0', '0', '50', '0', '100', '0', '0', '0', '75', '100');
INSERT INTO `strain_test_table` VALUES ('4', '98', '100', '0', '17', '0', '0', '0', '95', '5', '100', '93', '0', '0', '35', '46', '96', '96', '0', '0', '100', '0', '83', '0', '100', '95', '98', '98', '100', '96', '60', '0', '20', '0', '0', '96', '98', '100', '0', '0', '0', '0', '92', '65', '0', '0', '96', '96');
INSERT INTO `strain_test_table` VALUES ('5', '99', '100', '0', '1', '0', '0', '0', '6', '0', '100', '99', '0', '94', '0', '40', '35', '78', '0', '0', '100', '0', '98', '98', '100', '97', '0', '100', '8', '97', '19', '0', '3', '0', '45', '100', '100', '100', '0', '0', '97', '40', '97', '40', '0', '45', '100', '100');
INSERT INTO `strain_test_table` VALUES ('6', '0', '100', '0', '0', '0', '0', '0', '85', '30', '0', '100', '0', '15', '85', '20', '2', '30', '0', '0', '100', '0', '100', '50', '100', '97', '0', '100', '0', '100', '0', '0', '25', '0', '15', '100', '100', '100', '100', '25', '78', '99', '93', '30', '1', '8', '100', '100');
INSERT INTO `strain_test_table` VALUES ('7', '0', '93', '0', '0', '80', '33', '0', '0', '0', '0', '27', '0', '0', '0', '0', '27', '0', '0', '0', '100', '0', '93', '0', '100', '53', '0', '80', '27', '0', '0', '0', '0', '0', '87', '0', '60', '0', '0', '0', '20', '0', '100', '0', '0', '0', '0', '93');
INSERT INTO `strain_test_table` VALUES ('8', '0', '100', '0', '100', '0', '0', '0', '0', '0', '100', '100', '0', '80', '60', '100', '60', '0', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '0', '0', '60', '0', '100', '100', '100', '100', '100', '0', '100', '100', '100', '100', '0', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('9', '0', '100', '0', '0', '0', '0', '0', '0', '0', '33', '100', '0', '100', '100', '100', '0', '0', '0', '0', '100', '0', '100', '0', '100', '100', '67', '100', '67', '100', '0', '0', '67', '0', '0', '100', '100', '100', '100', '0', '67', '100', '33', '100', '0', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('10', '0', '100', '0', '0', '0', '0', '0', '100', '0', '80', '60', '0', '40', '0', '100', '0', '0', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '0', '0', '0', '0', '0', '100', '100', '100', '0', '40', '60', '0', '100', '100', '100', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('11', '0', '100', '0', '20', '0', '0', '0', '0', '20', '0', '80', '0', '60', '100', '100', '40', '0', '0', '0', '100', '0', '100', '0', '100', '40', '100', '100', '80', '100', '0', '0', '0', '0', '60', '60', '100', '100', '0', '0', '80', '0', '100', '100', '0', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('12', '0', '100', '0', '0', '0', '0', '0', '0', '0', '100', '100', '0', '67', '100', '100', '67', '0', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '0', '0', '33', '0', '100', '100', '100', '100', '67', '0', '100', '33', '100', '100', '0', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('13', '33', '100', '0', '33', '0', '0', '100', '0', '67', '0', '100', '0', '100', '100', '100', '100', '0', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '0', '0', '0', '0', '0', '100', '100', '100', '0', '33', '100', '0', '100', '100', '0', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('14', '0', '100', '0', '33', '0', '0', '100', '0', '0', '0', '100', '0', '33', '100', '100', '0', '0', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '0', '0', '0', '67', '0', '100', '100', '100', '0', '0', '0', '0', '100', '100', '0', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('15', '0', '100', '50', '95', '0', '0', '0', '0', '50', '95', '95', '0', '85', '91', '45', '0', '0', '91', '0', '100', '0', '90', '0', '100', '70', '0', '0', '100', '100', '0', '0', '0', '0', '19', '100', '100', '100', '0', '5', '0', '10', '0', '99', '0', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('16', '0', '40', '80', '99', '0', '0', '0', '0', '80', '0', '80', '0', '100', '99', '100', '0', '60', '100', '0', '100', '0', '99', '0', '100', '100', '0', '0', '100', '100', '0', '0', '0', '0', '60', '100', '100', '100', '0', '0', '0', '0', '0', '100', '0', '0', '100', '0');
INSERT INTO `strain_test_table` VALUES ('17', '0', '100', '50', '100', '0', '0', '0', '0', '100', '0', '100', '0', '65', '100', '100', '0', '0', '100', '0', '100', '0', '100', '0', '100', '100', '0', '0', '100', '100', '0', '0', '0', '0', '35', '100', '100', '100', '0', '0', '0', '0', '0', '100', '100', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('18', '0', '100', '50', '100', '0', '0', '0', '0', '100', '0', '100', '0', '100', '0', '100', '0', '50', '100', '0', '100', '0', '100', '0', '100', '100', '0', '0', '100', '100', '0', '0', '0', '0', '0', '100', '100', '100', '100', '50', '0', '100', '0', '100', '0', '50', '100', '100');
INSERT INTO `strain_test_table` VALUES ('19', '0', '100', '50', '100', '0', '0', '0', '0', '50', '50', '100', '0', '100', '0', '100', '0', '50', '50', '0', '100', '0', '100', '0', '100', '100', '0', '0', '100', '100', '0', '0', '0', '0', '0', '100', '100', '100', '100', '0', '0', '100', '0', '100', '100', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('20', '100', '100', '0', '95', '5', '85', '0', '0', '85', '95', '95', '0', '99', '1', '5', '96', '86', '0', '0', '99', '0', '97', '0', '100', '97', '0', '99', '0', '100', '1', '0', '60', '0', '35', '99', '100', '100', '0', '2', '96', '5', '100', '30', '99', '9', '100', '99');
INSERT INTO `strain_test_table` VALUES ('21', '33', '100', '0', '78', '78', '44', '0', '0', '67', '0', '89', '0', '89', '11', '0', '100', '44', '0', '0', '100', '0', '89', '0', '100', '89', '0', '100', '0', '44', '11', '0', '100', '0', '78', '100', '100', '100', '100', '11', '100', '44', '100', '0', '100', '89', '100', '89');
INSERT INTO `strain_test_table` VALUES ('22', '33', '100', '0', '87', '60', '47', '0', '0', '67', '93', '87', '0', '100', '0', '0', '93', '53', '0', '0', '100', '0', '80', '0', '100', '93', '0', '100', '0', '73', '33', '0', '87', '0', '80', '100', '100', '100', '80', '33', '100', '7', '100', '0', '100', '7', '100', '100');
INSERT INTO `strain_test_table` VALUES ('23', '100', '100', '0', '10', '0', '59', '0', '0', '85', '100', '97', '0', '93', '0', '0', '93', '80', '0', '0', '100', '0', '100', '0', '100', '96', '0', '100', '0', '100', '2', '0', '65', '0', '15', '100', '100', '100', '100', '75', '100', '100', '100', '9', '98', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('24', '0', '100', '0', '33', '67', '0', '0', '0', '33', '0', '67', '0', '100', '100', '0', '100', '0', '0', '0', '100', '0', '67', '0', '100', '100', '0', '100', '0', '67', '0', '0', '67', '0', '67', '100', '100', '100', '67', '0', '67', '0', '100', '0', '100', '33', '100', '100');
INSERT INTO `strain_test_table` VALUES ('25', '99', '100', '0', '99', '0', '75', '0', '0', '80', '99', '95', '0', '0', '95', '1', '90', '75', '0', '0', '100', '0', '99', '0', '100', '98', '99', '99', '98', '99', '40', '0', '99', '0', '50', '100', '99', '100', '0', '40', '95', '0', '99', '15', '99', '40', '100', '100');
INSERT INTO `strain_test_table` VALUES ('26', '100', '100', '0', '100', '67', '67', '0', '0', '67', '0', '100', '0', '100', '0', '0', '100', '33', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '100', '0', '100', '0', '67', '100', '100', '100', '33', '0', '100', '33', '100', '33', '100', '33', '100', '100');
INSERT INTO `strain_test_table` VALUES ('27', '0', '100', '0', '0', '0', '100', '0', '0', '0', '100', '0', '0', '0', '100', '0', '100', '0', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '0', '0', '0', '0', '100', '100', '100', '100', '0', '0', '100', '0', '100', '0', '100', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('28', '83', '100', '0', '83', '0', '100', '0', '0', '100', '100', '100', '0', '100', '100', '17', '100', '83', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '100', '0', '83', '0', '100', '100', '100', '100', '100', '0', '100', '0', '100', '17', '100', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('29', '0', '100', '0', '100', '100', '100', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '100', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '0', '0', '0', '100', '0', '17', '100', '100', '100', '0', '0', '100', '0', '100', '0', '100', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('30', '15', '100', '0', '75', '65', '80', '0', '0', '50', '5', '95', '0', '95', '5', '5', '100', '65', '0', '0', '85', '0', '90', '0', '100', '75', '0', '100', '5', '45', '85', '0', '90', '5', '25', '95', '100', '100', '10', '0', '100', '10', '100', '10', '100', '20', '100', '100');
INSERT INTO `strain_test_table` VALUES ('31', '99', '100', '0', '1', '100', '0', '0', '100', '0', '100', '98', '0', '0', '0', '0', '25', '0', '0', '0', '100', '0', '0', '0', '100', '100', '0', '9', '0', '0', '0', '0', '30', '0', '0', '100', '0', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `strain_test_table` VALUES ('32', '100', '100', '0', '0', '0', '0', '0', '100', '0', '100', '100', '0', '0', '0', '0', '0', '0', '0', '0', '100', '0', '0', '0', '100', '50', '0', '100', '0', '0', '0', '0', '0', '0', '0', '100', '100', '100', '0', '0', '0', '0', '0', '0', '0', '100', '0', '0');
INSERT INTO `strain_test_table` VALUES ('33', '50', '100', '0', '0', '0', '0', '0', '100', '0', '95', '100', '0', '0', '100', '0', '0', '0', '0', '0', '100', '0', '0', '0', '100', '35', '0', '13', '0', '0', '0', '0', '65', '0', '0', '100', '100', '100', '0', '0', '0', '0', '0', '50', '0', '100', '100', '0');
INSERT INTO `strain_test_table` VALUES ('34', '0', '0', '0', '0', '0', '0', '0', '100', '0', '65', '0', '0', '0', '0', '0', '0', '0', '0', '0', '100', '0', '0', '0', '100', '50', '0', '0', '0', '0', '0', '0', '0', '0', '0', '100', '0', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `strain_test_table` VALUES ('35', '0', '5', '100', '100', '0', '65', '0', '0', '97', '96', '95', '0', '98', '75', '30', '30', '75', '0', '0', '99', '0', '99', '0', '100', '100', '25', '100', '15', '99', '15', '0', '40', '15', '93', '100', '100', '100', '90', '85', '75', '97', '92', '75', '95', '97', '100', '99');
INSERT INTO `strain_test_table` VALUES ('36', '0', '5', '98', '95', '0', '2', '0', '98', '0', '98', '97', '0', '98', '95', '98', '95', '50', '0', '0', '100', '0', '100', '0', '100', '100', '98', '100', '100', '100', '5', '0', '98', '95', '95', '99', '100', '95', '99', '95', '90', '96', '99', '100', '100', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('37', '0', '7', '100', '70', '0', '0', '0', '0', '9', '55', '92', '0', '100', '91', '91', '9', '0', '0', '0', '100', '0', '91', '0', '100', '100', '100', '100', '0', '100', '0', '0', '0', '100', '70', '100', '100', '100', '100', '55', '35', '100', '100', '91', '9', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('38', '0', '65', '100', '100', '0', '0', '0', '0', '35', '100', '100', '0', '100', '100', '100', '0', '0', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '0', '0', '0', '0', '35', '100', '100', '100', '100', '100', '100', '0', '100', '100', '100', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('39', '0', '100', '2', '100', '0', '60', '0', '0', '21', '95', '0', '0', '97', '3', '95', '30', '87', '0', '0', '100', '0', '100', '0', '100', '95', '0', '100', '0', '100', '0', '0', '11', '0', '75', '100', '100', '100', '0', '95', '21', '70', '5', '100', '100', '100', '100', '97');
INSERT INTO `strain_test_table` VALUES ('40', '0', '5', '100', '100', '0', '1', '0', '0', '94', '99', '99', '0', '98', '100', '90', '0', '35', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '0', '0', '1', '0', '10', '99', '100', '100', '0', '1', '75', '0', '100', '92', '1', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('41', '0', '0', '100', '100', '0', '100', '0', '0', '100', '100', '0', '0', '100', '100', '100', '0', '100', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '0', '0', '0', '0', '0', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('42', '0', '5', '100', '99', '0', '93', '0', '90', '0', '100', '90', '0', '0', '96', '97', '97', '93', '0', '0', '99', '0', '97', '0', '100', '98', '0', '99', '97', '99', '0', '0', '100', '0', '55', '100', '99', '100', '97', '2', '2', '97', '99', '99', '0', '98', '100', '99');
INSERT INTO `strain_test_table` VALUES ('43', '0', '57', '100', '96', '0', '87', '4', '0', '78', '91', '52', '0', '100', '100', '0', '13', '74', '0', '0', '100', '0', '95', '0', '100', '83', '0', '100', '0', '100', '87', '0', '4', '0', '9', '100', '100', '100', '0', '83', '96', '0', '100', '44', '0', '100', '100', '96');
INSERT INTO `strain_test_table` VALUES ('44', '0', '100', '100', '65', '0', '0', '0', '0', '0', '89', '89', '0', '65', '100', '100', '100', '0', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100', '65', '100', '100');
INSERT INTO `strain_test_table` VALUES ('45', '0', '100', '100', '0', '0', '0', '0', '0', '0', '100', '0', '0', '100', '100', '100', '0', '0', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '0', '0', '0', '0', '0', '100', '100', '100', '100', '100', '100', '0', '100', '100', '100', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('46', '0', '29', '86', '0', '0', '86', '0', '100', '0', '100', '43', '0', '0', '86', '100', '0', '0', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '0', '0', '0', '100', '14', '100', '100', '100', '0', '0', '0', '0', '100', '100', '0', '100', '100', '0');
INSERT INTO `strain_test_table` VALUES ('47', '11', '5', '100', '99', '0', '1', '50', '0', '99', '91', '96', '0', '99', '18', '100', '1', '96', '0', '0', '99', '0', '100', '98', '100', '98', '0', '100', '0', '100', '5', '0', '15', '75', '99', '100', '100', '100', '100', '96', '1', '99', '100', '99', '0', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('48', '0', '84', '95', '95', '0', '0', '0', '0', '0', '0', '60', '0', '5', '0', '50', '35', '10', '0', '0', '97', '0', '85', '0', '100', '0', '0', '0', '99', '10', '0', '0', '24', '0', '70', '16', '100', '99', '0', '0', '0', '0', '23', '80', '0', '0', '99', '13');
INSERT INTO `strain_test_table` VALUES ('49', '0', '40', '85', '10', '0', '4', '0', '100', '6', '98', '85', '0', '95', '50', '7', '70', '15', '0', '0', '100', '0', '90', '0', '100', '98', '0', '95', '0', '15', '0', '0', '95', '0', '5', '100', '99', '100', '0', '0', '0', '2', '97', '13', '0', '10', '95', '98');
INSERT INTO `strain_test_table` VALUES ('50', '0', '85', '70', '0', '0', '0', '0', '100', '0', '45', '0', '0', '0', '45', '0', '30', '0', '0', '0', '100', '0', '30', '0', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '55', '100', '0', '0', '0', '0', '0', '55', '0', '0', '70', '0');
INSERT INTO `strain_test_table` VALUES ('51', '0', '98', '0', '30', '0', '10', '0', '40', '6', '3', '0', '0', '88', '3', '80', '50', '2', '0', '0', '80', '0', '80', '0', '100', '50', '97', '98', '95', '92', '2', '0', '65', '55', '30', '95', '100', '100', '97', '70', '25', '90', '55', '97', '65', '20', '98', '95');
INSERT INTO `strain_test_table` VALUES ('52', '0', '10', '98', '98', '0', '95', '0', '98', '0', '0', '0', '0', '98', '93', '99', '95', '75', '0', '0', '99', '0', '99', '0', '100', '97', '90', '99', '98', '98', '30', '0', '97', '95', '98', '98', '99', '99', '99', '90', '90', '99', '99', '99', '99', '99', '99', '99');
INSERT INTO `strain_test_table` VALUES ('53', '0', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '80', '95', '30', '50', '0', '0', '0', '100', '0', '0', '0', '100', '0', '100', '100', '100', '100', '0', '0', '50', '95', '0', '100', '100', '100', '100', '0', '0', '90', '96', '98', '100', '75', '100', '100');
INSERT INTO `strain_test_table` VALUES ('54', '99', '20', '95', '95', '0', '90', '1', '99', '0', '0', '0', '0', '97', '98', '100', '98', '90', '0', '0', '100', '0', '100', '1', '100', '97', '99', '98', '98', '100', '55', '2', '99', '98', '100', '100', '99', '100', '99', '98', '93', '100', '100', '100', '99', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('55', '100', '96', '70', '100', '0', '100', '0', '100', '0', '100', '0', '0', '100', '100', '100', '100', '95', '0', '0', '100', '0', '100', '0', '100', '100', '100', '100', '100', '100', '10', '0', '100', '95', '100', '100', '100', '100', '100', '100', '96', '100', '100', '100', '100', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('56', '20', '100', '98', '100', '0', '98', '0', '100', '0', '0', '0', '0', '100', '100', '100', '100', '62', '0', '0', '100', '0', '100', '1', '100', '100', '100', '100', '100', '100', '15', '0', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100', '92', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('57', '0', '60', '100', '40', '0', '0', '0', '100', '0', '20', '0', '0', '100', '100', '100', '100', '20', '0', '0', '100', '0', '100', '0', '100', '80', '100', '100', '100', '100', '20', '0', '100', '80', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('58', '92', '100', '0', '96', '0', '0', '0', '97', '0', '100', '98', '0', '92', '96', '99', '35', '50', '0', '0', '100', '0', '100', '0', '100', '93', '0', '100', '0', '100', '25', '0', '40', '0', '98', '100', '100', '100', '99', '98', '90', '98', '100', '100', '40', '98', '100', '99');
INSERT INTO `strain_test_table` VALUES ('59', '90', '100', '0', '80', '0', '0', '0', '23', '0', '100', '90', '0', '86', '86', '100', '19', '86', '0', '0', '100', '0', '100', '0', '100', '95', '0', '100', '0', '100', '0', '0', '5', '0', '95', '100', '95', '100', '100', '95', '81', '100', '100', '100', '45', '81', '100', '91');
INSERT INTO `strain_test_table` VALUES ('60', '100', '100', '0', '100', '0', '0', '0', '100', '0', '100', '100', '0', '83', '50', '100', '50', '83', '0', '0', '100', '0', '100', '0', '100', '17', '0', '100', '0', '100', '33', '0', '33', '0', '83', '100', '100', '100', '100', '100', '83', '100', '83', '100', '0', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('61', '100', '100', '0', '0', '0', '48', '0', '0', '0', '0', '79', '0', '97', '93', '100', '83', '28', '0', '0', '100', '0', '100', '37', '100', '97', '93', '100', '96', '100', '86', '0', '3', '0', '93', '100', '100', '100', '100', '0', '93', '66', '100', '100', '0', '66', '100', '100');
INSERT INTO `strain_test_table` VALUES ('62', '0', '100', '0', '100', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '100', '0', '0', '0', '100', '0', '0', '0', '100', '33', '0', '100', '0', '0', '83', '0', '17', '0', '0', '0', '0', '0', '0', '0', '100', '0', '0', '0', '0', '0', '0', '83');
INSERT INTO `strain_test_table` VALUES ('63', '0', '0', '0', '0', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '100', '0', '0', '0', '100', '0', '0', '0', '100', '0', '0', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '50', '0', '0', '0', '0', '0', '0', '100');
INSERT INTO `strain_test_table` VALUES ('64', '0', '100', '0', '80', '0', '0', '0', '0', '0', '0', '0', '0', '70', '0', '0', '30', '10', '0', '0', '90', '0', '90', '0', '100', '0', '100', '0', '75', '0', '0', '0', '10', '0', '100', '30', '60', '100', '100', '0', '0', '100', '0', '0', '0', '100', '0', '0');
INSERT INTO `strain_test_table` VALUES ('65', '95', '95', '0', '0', '20', '95', '95', '1', '0', '95', '95', '0', '98', '1', '0', '95', '0', '0', '0', '90', '0', '10', '0', '99', '90', '0', '0', '0', '0', '0', '0', '5', '0', '1', '0', '0', '98', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `strain_test_table` VALUES ('66', '50', '86', '0', '0', '7', '100', '93', '29', '0', '64', '79', '0', '79', '0', '0', '100', '0', '0', '0', '100', '0', '0', '0', '100', '86', '0', '0', '0', '0', '0', '0', '7', '0', '0', '0', '0', '100', '0', '0', '7', '0', '0', '0', '0', '7', '100', '0');
INSERT INTO `strain_test_table` VALUES ('67', '100', '95', '0', '0', '15', '100', '100', '100', '0', '80', '0', '0', '90', '5', '0', '100', '0', '0', '0', '90', '0', '20', '0', '100', '93', '0', '0', '0', '0', '0', '0', '100', '0', '0', '0', '0', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `strain_test_table` VALUES ('68', '0', '15', '0', '0', '0', '0', '0', '100', '0', '100', '0', '0', '0', '0', '0', '15', '0', '0', '0', '100', '0', '0', '0', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '50', '0', '85', '0', '0', '0', '0', '15', '0', '0', '0', '85', '15');
INSERT INTO `strain_test_table` VALUES ('69', '20', '50', '70', '50', '0', '20', '20', '0', '0', '0', '85', '2', '35', '65', '60', '25', '30', '0', '0', '85', '0', '90', '75', '100', '20', '7', '95', '50', '55', '15', '0', '30', '15', '40', '89', '100', '98', '50', '7', '40', '30', '85', '65', '30', '75', '97', '93');
INSERT INTO `strain_test_table` VALUES ('70', '0', '82', '64', '100', '0', '0', '9', '0', '0', '0', '100', '0', '82', '9', '0', '9', '100', '0', '0', '91', '0', '91', '27', '100', '0', '0', '100', '100', '55', '0', '0', '27', '0', '0', '82', '100', '100', '0', '0', '0', '0', '91', '0', '0', '1', '100', '100');
INSERT INTO `strain_test_table` VALUES ('71', '50', '0', '0', '50', '0', '25', '0', '0', '0', '0', '100', '50', '0', '0', '0', '50', '0', '0', '0', '0', '0', '0', '50', '75', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '25', '0', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `strain_test_table` VALUES ('72', '0', '0', '0', '20', '0', '60', '0', '0', '0', '0', '100', '80', '20', '0', '0', '60', '20', '0', '0', '0', '0', '0', '60', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `strain_test_table` VALUES ('73', '0', '100', '0', '89', '89', '0', '22', '0', '0', '0', '100', '0', '0', '0', '78', '0', '0', '0', '0', '100', '0', '0', '0', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '78', '0', '0', '0', '0');
INSERT INTO `strain_test_table` VALUES ('74', '98', '95', '0', '15', '95', '95', '99', '0', '0', '0', '95', '91', '99', '0', '50', '80', '25', '80', '80', '98', '0', '1', '0', '100', '85', '0', '0', '0', '0', '0', '1', '60', '0', '2', '97', '0', '0', '0', '60', '0', '1', '5', '50', '0', '97', '30', '95');
INSERT INTO `strain_test_table` VALUES ('75', '2', '97', '50', '65', '98', '98', '98', '0', '0', '99', '95', '90', '98', '2', '0', '87', '20', '92', '50', '95', '0', '0', '0', '100', '96', '0', '0', '0', '1', '0', '0', '70', '0', '2', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '15', '98', '98');
INSERT INTO `strain_test_table` VALUES ('76', '0', '100', '100', '50', '0', '100', '100', '0', '0', '0', '100', '100', '100', '0', '0', '100', '0', '100', '50', '100', '0', '0', '0', '100', '100', '0', '0', '0', '0', '0', '0', '100', '0', '0', '100', '0', '0', '0', '100', '0', '0', '0', '0', '0', '100', '100', '0');
INSERT INTO `strain_test_table` VALUES ('77', '0', '100', '0', '0', '30', '100', '99', '0', '0', '0', '85', '50', '99', '0', '0', '85', '5', '45', '40', '90', '0', '1', '0', '100', '45', '0', '0', '0', '0', '0', '0', '55', '0', '1', '100', '0', '0', '0', '80', '0', '1', '0', '0', '0', '100', '55', '100');
INSERT INTO `strain_test_table` VALUES ('78', '99', '99', '0', '98', '0', '0', '98', '0', '0', '1', '96', '0', '100', '0', '0', '90', '40', '0', '0', '100', '0', '1', '0', '100', '85', '98', '1', '0', '0', '0', '0', '15', '1', '0', '1', '2', '100', '0', '0', '0', '1', '0', '1', '1', '15', '2', '1');
INSERT INTO `strain_test_table` VALUES ('79', '0', '85', '0', '0', '0', '0', '100', '0', '0', '0', '46', '0', '8', '0', '0', '69', '0', '0', '0', '100', '0', '0', '0', '100', '0', '92', '0', '92', '0', '0', '0', '0', '46', '0', '54', '0', '100', '0', '0', '0', '0', '100', '0', '0', '0', '0', '8');
INSERT INTO `strain_test_table` VALUES ('80', '99', '93', '0', '95', '0', '98', '98', '0', '0', '0', '94', '0', '97', '0', '35', '95', '60', '0', '0', '100', '0', '5', '0', '100', '10', '100', '0', '100', '3', '0', '75', '60', '90', '5', '2', '100', '100', '5', '2', '0', '5', '70', '50', '1', '15', '0', '10');
INSERT INTO `strain_test_table` VALUES ('81', '98', '65', '0', '15', '0', '0', '100', '0', '0', '0', '30', '0', '100', '0', '0', '50', '25', '0', '0', '100', '0', '0', '0', '100', '35', '0', '0', '0', '0', '0', '0', '5', '0', '0', '0', '0', '100', '0', '0', '0', '0', '0', '0', '0', '35', '0', '0');
INSERT INTO `strain_test_table` VALUES ('82', '98', '100', '0', '93', '0', '30', '95', '0', '0', '0', '85', '0', '100', '0', '0', '90', '75', '0', '10', '100', '0', '10', '0', '100', '0', '5', '1', '0', '5', '0', '0', '50', '95', '2', '1', '10', '100', '0', '0', '0', '7', '0', '2', '1', '50', '98', '7');
INSERT INTO `strain_test_table` VALUES ('83', '0', '88', '100', '94', '0', '0', '95', '0', '0', '0', '6', '0', '0', '100', '100', '6', '6', '0', '0', '100', '0', '100', '0', '100', '98', '0', '100', '0', '100', '88', '0', '13', '0', '100', '94', '100', '100', '100', '0', '30', '94', '94', '100', '94', '100', '100', '94');
INSERT INTO `strain_test_table` VALUES ('84', '0', '100', '0', '94', '100', '0', '0', '100', '94', '100', '100', '0', '100', '0', '0', '0', '100', '0', '0', '100', '0', '94', '0', '100', '94', '0', '94', '0', '0', '94', '0', '0', '0', '0', '100', '100', '100', '94', '0', '88', '0', '88', '0', '100', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('85', '1', '100', '0', '95', '95', '1', '0', '98', '70', '97', '95', '0', '0', '0', '5', '90', '90', '0', '2', '100', '0', '2', '0', '100', '96', '0', '99', '0', '5', '96', '0', '5', '35', '1', '97', '100', '100', '95', '2', '90', '2', '95', '0', '95', '1', '99', '97');
INSERT INTO `strain_test_table` VALUES ('86', '1', '100', '0', '99', '99', '0', '0', '99', '70', '99', '99', '0', '1', '95', '1', '5', '90', '0', '2', '100', '0', '100', '0', '100', '99', '0', '99', '1', '1', '0', '0', '10', '0', '15', '98', '100', '100', '95', '1', '90', '1', '99', '0', '99', '1', '99', '100');
INSERT INTO `strain_test_table` VALUES ('87', '2', '100', '0', '98', '99', '0', '0', '99', '70', '99', '99', '0', '1', '95', '1', '20', '75', '0', '2', '100', '0', '92', '0', '100', '99', '0', '99', '1', '1', '1', '0', '10', '0', '85', '98', '100', '100', '95', '1', '30', '1', '99', '0', '99', '5', '99', '100');
INSERT INTO `strain_test_table` VALUES ('88', '0', '100', '0', '98', '100', '2', '0', '100', '70', '100', '98', '0', '95', '0', '0', '65', '70', '0', '0', '100', '0', '0', '0', '100', '100', '5', '100', '5', '50', '0', '0', '0', '0', '0', '100', '98', '100', '100', '0', '0', '0', '98', '60', '100', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('89', '0', '100', '0', '89', '100', '0', '0', '100', '67', '100', '100', '0', '0', '0', '0', '100', '89', '0', '0', '100', '0', '44', '0', '100', '100', '0', '100', '0', '0', '67', '0', '33', '0', '22', '100', '100', '100', '89', '0', '89', '0', '100', '0', '0', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('90', '2', '100', '0', '100', '100', '0', '0', '100', '90', '100', '98', '2', '0', '95', '15', '50', '95', '0', '0', '100', '0', '15', '0', '100', '100', '0', '100', '0', '0', '90', '0', '25', '5', '1', '100', '100', '95', '8', '8', '96', '0', '100', '5', '100', '1', '100', '100');
INSERT INTO `strain_test_table` VALUES ('91', '0', '100', '0', '25', '50', '0', '0', '95', '55', '100', '95', '0', '0', '0', '0', '85', '1', '0', '0', '98', '0', '0', '0', '100', '95', '0', '0', '1', '0', '5', '1', '0', '0', '0', '95', '98', '95', '45', '0', '0', '1', '100', '0', '90', '0', '0', '98');
INSERT INTO `strain_test_table` VALUES ('92', '0', '100', '0', '0', '100', '0', '0', '90', '10', '1', '0', '0', '0', '0', '0', '100', '0', '0', '10', '100', '0', '0', '0', '100', '0', '0', '80', '0', '10', '90', '1', '0', '0', '0', '90', '100', '100', '0', '0', '50', '10', '10', '0', '1', '0', '50', '70');
INSERT INTO `strain_test_table` VALUES ('93', '0', '100', '0', '0', '10', '0', '0', '0', '15', '95', '95', '0', '0', '0', '0', '0', '0', '0', '0', '100', '0', '0', '0', '100', '99', '0', '100', '0', '5', '90', '0', '10', '0', '0', '95', '100', '100', '95', '0', '0', '0', '100', '0', '95', '0', '100', '0');
INSERT INTO `strain_test_table` VALUES ('94', '0', '90', '0', '0', '90', '0', '0', '100', '10', '95', '0', '0', '0', '0', '0', '0', '0', '0', '0', '100', '0', '0', '0', '100', '90', '0', '100', '0', '5', '0', '0', '0', '0', '0', '5', '100', '100', '0', '0', '0', '1', '100', '0', '10', '0', '90', '90');
INSERT INTO `strain_test_table` VALUES ('95', '0', '100', '0', '0', '97', '0', '0', '98', '3', '0', '97', '0', '0', '0', '0', '100', '0', '0', '0', '100', '0', '0', '0', '100', '0', '0', '2', '0', '0', '0', '0', '20', '0', '1', '97', '100', '100', '100', '0', '0', '0', '0', '0', '99', '0', '100', '82');
INSERT INTO `strain_test_table` VALUES ('96', '1', '20', '98', '98', '0', '15', '0', '99', '0', '99', '97', '90', '95', '3', '95', '75', '50', '98', '98', '98', '0', '95', '0', '100', '55', '40', '0', '0', '5', '0', '1', '95', '75', '2', '96', '99', '99', '0', '0', '0', '2', '0', '95', '99', '99', '99', '7');
INSERT INTO `strain_test_table` VALUES ('97', '0', '20', '100', '100', '0', '0', '0', '0', '0', '0', '100', '100', '100', '0', '100', '100', '80', '20', '100', '100', '0', '100', '0', '100', '0', '0', '0', '60', '0', '0', '0', '0', '0', '0', '100', '100', '100', '0', '0', '0', '0', '0', '100', '0', '100', '100', '40');
INSERT INTO `strain_test_table` VALUES ('98', '0', '75', '75', '100', '0', '0', '0', '0', '0', '0', '100', '100', '55', '0', '100', '17', '40', '77', '100', '92', '8', '100', '0', '100', '0', '0', '100', '100', '100', '0', '0', '0', '55', '15', '100', '100', '100', '40', '8', '0', '70', '35', '100', '100', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('99', '0', '100', '9', '91', '0', '13', '0', '100', '0', '97', '91', '0', '70', '88', '100', '58', '15', '0', '0', '100', '0', '100', '0', '100', '79', '100', '100', '100', '6', '91', '0', '88', '30', '97', '97', '100', '100', '98', '91', '0', '100', '76', '100', '100', '21', '100', '85');
INSERT INTO `strain_test_table` VALUES ('100', '1', '93', '93', '90', '0', '3', '0', '95', '0', '95', '95', '90', '90', '2', '97', '75', '40', '85', '85', '100', '0', '93', '0', '100', '75', '5', '98', '0', '5', '0', '0', '95', '60', '10', '98', '100', '100', '75', '5', '0', '85', '15', '97', '95', '98', '100', '100');
INSERT INTO `strain_test_table` VALUES ('101', '0', '100', '60', '30', '0', '0', '0', '55', '4', '65', '17', '30', '70', '0', '96', '50', '4', '75', '82', '83', '0', '75', '0', '100', '0', '30', '0', '0', '4', '0', '0', '92', '30', '4', '70', '96', '100', '0', '0', '0', '0', '0', '92', '92', '100', '100', '0');
INSERT INTO `strain_test_table` VALUES ('102', '60', '100', '50', '100', '0', '5', '0', '100', '0', '100', '100', '95', '60', '0', '95', '100', '60', '35', '100', '100', '0', '100', '0', '100', '0', '50', '100', '0', '100', '0', '0', '40', '100', '70', '100', '100', '100', '100', '0', '5', '100', '95', '98', '100', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('103', '50', '60', '100', '97', '0', '0', '0', '94', '0', '0', '100', '94', '19', '0', '40', '100', '65', '65', '100', '100', '0', '100', '0', '100', '13', '55', '100', '0', '100', '0', '7', '50', '100', '97', '100', '97', '100', '96', '0', '0', '7', '94', '45', '100', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('104', '0', '94', '80', '75', '0', '0', '0', '0', '0', '0', '50', '60', '30', '0', '81', '100', '55', '70', '100', '100', '0', '70', '0', '100', '40', '0', '100', '0', '88', '0', '0', '50', '50', '80', '94', '100', '100', '93', '70', '0', '94', '0', '94', '65', '100', '100', '94');
INSERT INTO `strain_test_table` VALUES ('105', '0', '20', '100', '95', '0', '2', '0', '55', '0', '0', '85', '90', '25', '94', '94', '70', '80', '99', '99', '100', '0', '100', '0', '100', '30', '99', '100', '85', '94', '0', '0', '20', '20', '100', '99', '100', '100', '99', '1', '0', '99', '1', '99', '1', '99', '100', '99');
INSERT INTO `strain_test_table` VALUES ('106', '45', '99', '0', '0', '0', '0', '0', '0', '2', '0', '0', '0', '0', '100', '0', '75', '0', '0', '0', '99', '0', '30', '0', '0', '0', '0', '45', '0', '0', '0', '0', '10', '0', '0', '15', '100', '100', '0', '0', '0', '0', '30', '0', '30', '1', '90', '4');
INSERT INTO `strain_test_table` VALUES ('107', '25', '100', '0', '0', '0', '0', '0', '0', '18', '2', '0', '0', '0', '0', '0', '50', '0', '0', '0', '100', '0', '10', '0', '100', '0', '0', '94', '0', '0', '5', '0', '50', '0', '1', '20', '97', '100', '15', '0', '0', '0', '1', '0', '43', '0', '85', '11');
INSERT INTO `strain_test_table` VALUES ('108', '50', '100', '0', '0', '0', '0', '0', '0', '5', '0', '0', '0', '100', '0', '0', '30', '8', '0', '0', '99', '0', '1', '0', '100', '3', '0', '60', '1', '0', '1', '0', '10', '0', '1', '30', '95', '100', '55', '0', '0', '40', '5', '0', '29', '1', '65', '2');
INSERT INTO `strain_test_table` VALUES ('109', '0', '100', '0', '0', '0', '0', '0', '0', '2', '98', '0', '0', '0', '0', '0', '90', '0', '0', '0', '100', '0', '90', '0', '100', '0', '0', '95', '0', '5', '0', '0', '15', '0', '2', '90', '99', '100', '25', '0', '10', '3', '75', '0', '2', '1', '100', '2');
INSERT INTO `strain_test_table` VALUES ('110', '0', '0', '5', '2', '0', '0', '90', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '98', '0', '0', '0', '100', '0', '0', '0', '0', '0', '0', '0', '7', '0', '0', '0', '0', '100', '25', '0', '0', '11', '0', '55', '0', '98', '93', '9');
INSERT INTO `strain_test_table` VALUES ('111', '40', '100', '0', '88', '100', '0', '0', '100', '50', '100', '100', '0', '100', '0', '40', '50', '88', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '0', '0', '0', '0', '0', '100', '100', '100', '0', '0', '100', '0', '100', '13', '100', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('112', '40', '0', '0', '0', '0', '0', '0', '0', '0', '0', '100', '80', '0', '0', '0', '60', '0', '0', '20', '20', '0', '0', '60', '80', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '80', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `strain_test_table` VALUES ('113', '0', '80', '0', '0', '0', '5', '0', '0', '0', '0', '0', '0', '0', '0', '50', '0', '0', '0', '0', '85', '0', '50', '0', '100', '0', '0', '100', '0', '0', '0', '0', '50', '0', '0', '80', '97', '100', '20', '0', '0', '0', '1', '70', '50', '0', '100', '90');
INSERT INTO `strain_test_table` VALUES ('114', '0', '80', '0', '0', '0', '60', '0', '0', '0', '40', '0', '0', '0', '0', '0', '100', '0', '0', '0', '100', '0', '0', '0', '100', '0', '0', '60', '0', '0', '0', '0', '0', '0', '0', '0', '80', '100', '0', '0', '0', '0', '0', '0', '60', '20', '80', '40');
INSERT INTO `strain_test_table` VALUES ('115', '0', '100', '0', '0', '0', '60', '0', '0', '0', '80', '0', '0', '0', '0', '20', '100', '0', '0', '0', '100', '0', '80', '0', '100', '0', '0', '100', '0', '100', '0', '0', '0', '0', '20', '100', '100', '100', '0', '0', '0', '0', '0', '20', '100', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('116', '50', '97', '2', '0', '0', '75', '0', '0', '0', '95', '2', '0', '2', '0', '25', '85', '15', '55', '5', '98', '0', '95', '0', '100', '5', '0', '98', '40', '75', '0', '0', '90', '30', '5', '75', '98', '100', '1', '0', '0', '5', '1', '20', '99', '95', '98', '70');
INSERT INTO `strain_test_table` VALUES ('117', '100', '100', '0', '15', '0', '70', '0', '0', '0', '95', '5', '0', '0', '0', '85', '55', '15', '55', '0', '100', '0', '100', '0', '100', '40', '0', '100', '100', '100', '0', '0', '85', '20', '40', '100', '100', '100', '0', '0', '5', '30', '99', '92', '100', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('118', '100', '100', '5', '5', '0', '80', '0', '0', '0', '100', '5', '0', '10', '5', '100', '88', '18', '12', '0', '94', '0', '90', '0', '100', '18', '0', '100', '45', '96', '0', '0', '60', '15', '35', '100', '100', '100', '80', '77', '6', '45', '100', '100', '100', '100', '100', '100');
INSERT INTO `strain_test_table` VALUES ('119', '30', '92', '0', '0', '0', '77', '0', '0', '0', '92', '5', '0', '0', '0', '0', '40', '8', '0', '0', '100', '0', '70', '0', '100', '23', '0', '77', '45', '100', '0', '0', '70', '15', '8', '100', '100', '100', '0', '0', '0', '0', '0', '15', '100', '0', '100', '85');
INSERT INTO `strain_test_table` VALUES ('120', '0', '100', '0', '0', '0', '20', '0', '0', '0', '80', '0', '0', '0', '0', '0', '100', '0', '0', '0', '100', '0', '20', '0', '100', '0', '0', '100', '0', '100', '0', '0', '20', '0', '40', '60', '100', '100', '0', '0', '0', '0', '0', '20', '100', '100', '100', '60');
INSERT INTO `strain_test_table` VALUES ('121', '0', '100', '0', '0', '0', '95', '0', '0', '0', '0', '0', '0', '0', '0', '95', '50', '0', '0', '0', '95', '0', '70', '0', '100', '0', '0', '50', '0', '0', '0', '0', '50', '0', '0', '95', '100', '100', '70', '0', '0', '15', '70', '25', '0', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('122', '0', '62', '0', '0', '0', '62', '0', '0', '0', '25', '0', '0', '0', '0', '0', '100', '0', '0', '0', '88', '0', '50', '0', '100', '0', '0', '100', '0', '25', '0', '0', '38', '0', '0', '0', '100', '100', '50', '0', '0', '62', '0', '0', '100', '100', '100', '38');
INSERT INTO `strain_test_table` VALUES ('123', '0', '97', '10', '0', '0', '0', '0', '50', '5', '100', '0', '30', '15', '0', '0', '30', '0', '30', '0', '75', '0', '50', '0', '100', '5', '0', '5', '0', '5', '0', '0', '30', '0', '0', '95', '100', '100', '0', '0', '0', '5', '0', '0', '50', '0', '95', '0');
INSERT INTO `strain_test_table` VALUES ('124', '0', '100', '0', '92', '0', '0', '0', '100', '8', '100', '100', '0', '92', '0', '67', '0', '25', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '0', '0', '0', '0', '0', '100', '100', '100', '92', '0', '0', '25', '100', '8', '0', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('125', '0', '100', '0', '85', '0', '70', '0', '100', '0', '85', '100', '0', '100', '85', '0', '60', '45', '0', '0', '100', '0', '100', '0', '100', '85', '0', '100', '0', '100', '85', '0', '30', '0', '30', '100', '100', '100', '0', '55', '0', '0', '100', '100', '100', '0', '100', '100');
INSERT INTO `strain_test_table` VALUES ('126', '0', '100', '0', '0', '0', '50', '0', '0', '0', '100', '75', '0', '0', '100', '0', '75', '0', '0', '0', '100', '0', '100', '0', '100', '100', '0', '25', '0', '0', '0', '0', '75', '0', '0', '0', '50', '100', '0', '0', '0', '0', '75', '0', '0', '0', '100', '0');
INSERT INTO `strain_test_table` VALUES ('127', '0', '100', '50', '0', '0', '0', '0', '0', '0', '0', '0', '0', '100', '0', '0', '0', '0', '0', '100', '100', '0', '0', '0', '100', '0', '0', '0', '0', '0', '0', '0', '50', '0', '0', '50', '100', '100', '0', '0', '0', '0', '0', '50', '0', '100', '100', '0');
INSERT INTO `strain_test_table` VALUES ('128', '0', '0', '100', '100', '0', '0', '0', '0', '100', '100', '100', '0', '100', '100', '100', '0', '25', '0', '0', '100', '0', '100', '0', '100', '100', '0', '100', '0', '100', '100', '0', '0', '0', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100', '25', '100', '100');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `stuname` varchar(50) DEFAULT NULL,
  `math` int DEFAULT NULL,
  `PE` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('4', null, '80', '80');

-- ----------------------------
-- Table structure for sys_authority
-- ----------------------------
DROP TABLE IF EXISTS `sys_authority`;
CREATE TABLE `sys_authority` (
  `authority_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '权限id',
  `authority_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称，ROLE_开头，全大写',
  `authority_remark` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '权限描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `authority_content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '权限内容，可访问的url，多个时用,隔开',
  PRIMARY KEY (`authority_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='系统权限表';

-- ----------------------------
-- Records of sys_authority
-- ----------------------------
INSERT INTO `sys_authority` VALUES ('3fb1c570496d4c09ab99b8d31b06ccc', 'ROLE_USER', '普通用户', '2019-09-10 10:08:58', '2019-09-10 10:08:58', '');
INSERT INTO `sys_authority` VALUES ('3fb1c570496d4c09ab99b8d31b06xxx', 'ROLE_SA', '超级管理员', '2019-09-10 10:08:58', '2019-09-10 10:08:58', '/sys/**,/logging');
INSERT INTO `sys_authority` VALUES ('3fb1c570496d4c09ab99b8d31b06zzz', 'ROLE_ADMIN', '管理员', '2019-09-10 10:08:58', '2019-09-10 10:08:58', '/sys/**');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '菜单id',
  `menu_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `menu_path` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '菜单路径',
  `menu_parent_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上级id',
  `sort_weight` int DEFAULT NULL COMMENT '同级排序权重：0-10',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='系统菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('2d676108b871460991df57ab3995fec6', 'Numide 查询', '/numide/query', '', '2', '2022-08-25 06:57:13', '2022-08-25 16:30:11');
INSERT INTO `sys_menu` VALUES ('35cb950cebb04bb18bb1d8b742a02005', 'Numide', '/numide/index', '', '1', '2019-09-11 18:05:21', '2022-08-25 06:56:58');
INSERT INTO `sys_menu` VALUES ('35cb950cebb04bb18bb1d8b742a02xaa', '权限管理', '/sys/sysAuthority/authority', '35cb950cebb04bb18bb1d8b742a02xxx', '1', '2019-09-10 10:08:58', '2019-09-10 10:08:58');
INSERT INTO `sys_menu` VALUES ('35cb950cebb04bb18bb1d8b742a02xcc', '菜单管理', '/sys/sysMenu/menu', '35cb950cebb04bb18bb1d8b742a02xxx', '2', '2019-09-10 10:08:58', '2019-09-10 10:08:58');
INSERT INTO `sys_menu` VALUES ('35cb950cebb04bb18bb1d8b742a02xxx', '系统管理', '/sys', '', '0', '2019-09-10 10:08:58', '2019-09-10 10:08:58');
INSERT INTO `sys_menu` VALUES ('35cb950cebb04bb18bb1d8b742a02xzz', '用户管理', '/sys/sysUser/user', '35cb950cebb04bb18bb1d8b742a02xxx', '3', '2019-09-10 10:08:58', '2019-09-10 10:08:58');
INSERT INTO `sys_menu` VALUES ('74315e162f524a4d88aa931f02416f26', '实时监控', '/monitor', '35cb950cebb04bb18bb1d8b742a02xxx', '4', '2020-06-10 15:07:07', '2020-06-10 15:07:07');
INSERT INTO `sys_menu` VALUES ('8a0791ba66c44c80883ded2e4928620d', '未命名', '/query', '35cb950cebb04bb18bb1d8b742a02xxx', '0', '2022-08-25 06:23:57', '2022-08-25 06:23:57');
INSERT INTO `sys_menu` VALUES ('914aa22c78af4327822061f3eada4067', '实时日志', '/logging', '35cb950cebb04bb18bb1d8b742a02xxx', '5', '2019-09-11 11:19:52', '2019-09-11 11:19:52');
INSERT INTO `sys_menu` VALUES ('bcf17dc0ce304f0ba02d64ce21ddb4f9', '系统设置', '/sys/sysSetting/setting', '35cb950cebb04bb18bb1d8b742a02xxx', '0', '2019-09-17 10:46:11', '2019-09-17 10:46:11');

-- ----------------------------
-- Table structure for sys_setting
-- ----------------------------
DROP TABLE IF EXISTS `sys_setting`;
CREATE TABLE `sys_setting` (
  `id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '表id',
  `sys_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系统名称',
  `sys_logo` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系统logo图标',
  `sys_bottom_text` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系统底部信息',
  `sys_notice_text` longtext CHARACTER SET utf8mb3 COLLATE utf8_general_ci COMMENT '系统公告',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `user_init_password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户管理：初始、重置密码',
  `sys_color` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系统颜色',
  `sys_api_encrypt` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'API加密 Y/N',
  `sys_open_api_limiter_encrypt` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'OpenAPI限流 Y/N',
  `sys_check_pwd_encrypt` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '检查密码复杂度 Y/N',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='系统设置表';

-- ----------------------------
-- Records of sys_setting
-- ----------------------------
INSERT INTO `sys_setting` VALUES ('1', '微生物研究所', 'http://p0.itc.cn/images01/20200529/d17751af582d4a599dc6423becc20bcd.jpeg', '© 2021 - 2023  广东微生物所', '<ol class=\"breadcrumb list-paddingleft-2\" style=\"list-style-type: none;\"><li><p><br/></p></li></ol><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 18px; padding: 0px; overflow-wrap: break-word;\"><img src=\"http://www.gdim.cn/about/skjj/202106/W020210623382511584038.jpg\" alt=\"\"/></p><p><span style=\"box-sizing: border-box; margin: 0px; padding: 0px; overflow-wrap: break-word;\"><span style=\"box-sizing: border-box; margin: 0px; padding: 0px; overflow-wrap: break-word;\"><span style=\"\"></span></span></span></p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 18px; padding: 0px; overflow-wrap: break-word; line-height: 28px;\">&nbsp; &nbsp; &nbsp; &nbsp;广东省科学院微生物研究所(原广东省微生物研究所)前身为中科院中南真菌研究室，于1964年5月19日经国家科委批准成立，1972年改为广东省微生物研究所，隶属于广东省科学院，2021年1月更名为广东省科学院微生物研究所。依托研究所，广东省微生物分析检测中心于1999年经广东省编办批准成立。现有员工446人，在读博士和硕士研究生166人，在站博士后13人。其中专业技术人员414人，博士101人，硕士110人。具有正高级职称30人，副高级职称33人。已建成由中国工程院院士、国家“万人计划”科技创新领军人才、国家百千万人才工程入选者、国家优秀青年基金获得者、“珠江人才计划”青年拔尖人才、广东“特支计划”杰出人才、科技创新领军人才和青年拔尖人才等为领军科学家的六大研究中心，在微生物应用基础研究、行业共性关键技术创新及科技服务、微生物高技术成果转移转化方面，研究所己成为国内领军科研机构。</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 18px; padding: 0px; overflow-wrap: break-word; line-height: 28px;\">　　作为具有热带亚热带区域特色与优势的微生物学专业科研机构，广东省科学院微生物研究所面向国家和广东省社会经济发展对微生物学的重大需求，长期重点致力于具有热带亚热带特色的微生物资源、微生物与生态环境、食品安全及健康等相关基础、应用基础及公益性研究，开展为支撑生物技术相关行业可持续发展的共性关键技术研究及储备性前沿技术探索;形成了资源微生物学、环境微生物学、分析微生物学和霉腐微生物学等四大国内优势学科，具备硕、博士研究生培养能力，拥有博士后科研工作站。依托研究所建成了华南应用微生物国家重点实验室、国家专利菌种保藏机构—广东省微生物菌种保藏中心、国家广州化学品生态环境安全评价服务中心、国家生物产业基地公共实验中心、广东省菌种保藏与应用重点实验室、广东省微生物安全与健康重点实验室、广东省微生物应用新技术公共实验室、广东省微生物芯片工程技术研究中心、广东省环境微生物工程技术研究中心、广东省抗微生物材料与抗菌检测工程技术研究中心、广东省微生物资源工程技术研究中心、广东省饮用水安全应急技术研究中心以及华南地区最大(全国第二大)的大型真菌标本馆等一大批国家和省部级科技创新平台。目前，研究所是国家微生物种业产业技术创新战略联盟理事长单位、中国食品科学技术学会副理事长单位、中国食用菌协会副会长单位，是广东省微生物学会、广东省食用菌行业协会、广东省生物技术生产力促进中心的挂靠单位。</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 18px; padding: 0px; overflow-wrap: break-word; line-height: 28px;\">　　建所五十多年来，研究所在科技创新、行业共性关键技术与科技服务，以及科技成果转移转化等方面取得了显著成绩。在科技创新方面，先后承担了国家重点研发计划、国家“973”计划、国家“863”计划、国家重大科技攻关、国家科技支撑、国家基金重点项目、国家基金重大研究计划、国家生物高新技术产业化示范工程、国际合作、广东省基础与应用基础重大专项、省重点领域研发计划、省重大重点科技攻关、省应用型科技研发专项以及科技援藏等国家和省部级科技项目。共取得科技创新成果157项，其中国际先进、领先水平的81项;获得国家及省部级成果奖118项，其中国家级成果奖8项、省部级一等奖19项;共申请专利840件，授权专利343件，其中发明专利320件。2010年被认定为“广东省知识产权示范事业单位”和“全国企事业知识产权试点单位”，2020年通过科研机构知识产权管理体系认证;主持和参与国家、行业、地方和团体标准的制修订工作152个，其中国家标准项目76个;在国内外核心学术刊物发表论文2700多篇，出版科技专著46部。获“十一·五”国家科技计划执行优秀团队奖。</p><p style=\"box-sizing: border-box; margin-top: 0px; margin-bottom: 0px; padding: 0px; overflow-wrap: break-word; line-height: 28px;\">　　依托研究所建设的广东省菌种保藏与应用重点实验室成立于1987年，于2000年、2003年、2006年和2010年连续四次被评为广东省优秀重点实验室;广东省微生物安全与健康重点实验室于2020年获批组建。华南应用微生物国家重点实验室成立于2009年，2013年通过科技部论证(其中2009-2013年为培育期)，主要研究方向为“热带亚热带微生物资源多样性与利用、环境微生物与区域生态安全、有害微生物监测与防控”。目前实验室拥有实验面积11000平方米，包括公共实验室、大型仪器室、菌种保藏库、华南微生物资源中心(含标本库)、环境微生物实验室、微生物检测与控制实验室、霉腐微生物实验室、食药用菌生理功能及分子机理实验室、工业化前期实验室及动物实验技术公共服务平台等;拥有10万元以上各类仪器设备261台套，原值1.17亿元，其中30万元以上设备127台套，原值9176万元，包括液相色谱-超高分辨蛋白鉴定质谱联用系统(Thermo QE Plus)、液相色谱串联四极杆高分辨质谱联用仪(Thermo QE Fucus)、高通量基因测序仪(Illumina Nextseq 550、Illumina Miseq等)、细胞能量代谢分析仪、流式细胞仪、透射电子显微镜、扫描电子显微镜、激光共聚焦显微镜、原子力显微镜、分子相互作用仪、数字PCR系统、微生物电解呼吸仪、气相色谱仪、电感耦合等离子体质谱仪、高速冷冻离心机、全自动微生物鉴定系统等，整体仪器设备达到国际先进水平，以上实验室及设备完全具备基因组学、蛋白组学、代谢组学及转录组学等多组学的研究能力。</p><p><br/></p><p><br/></p>', '2019-09-17 10:15:38', '2022-08-25 00:37:53', '123456', 'rgba(54, 123, 183,  0.73)', 'N', 'N', 'N');
INSERT INTO `sys_setting` VALUES ('3b5fc81705524cd5b3f939d1a49f87af', null, null, null, null, '2022-08-25 00:37:53', '2022-08-25 00:37:53', null, null, null, null, null);
INSERT INTO `sys_setting` VALUES ('fab7802064a244428283f4442302d2ba', null, null, null, null, '2022-08-25 00:37:53', '2022-08-25 00:37:53', null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_shortcut_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_shortcut_menu`;
CREATE TABLE `sys_shortcut_menu` (
  `shortcut_menu_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '用户快捷菜单id',
  `shortcut_menu_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '用户快捷菜单名称',
  `shortcut_menu_path` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '用户快捷菜单路径',
  `user_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `shortcut_menu_parent_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上级id',
  `sort_weight` int DEFAULT NULL COMMENT '同级排序权重：0-10',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`shortcut_menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='用户快捷菜单表';

-- ----------------------------
-- Records of sys_shortcut_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `login_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `user_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `valid` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '软删除标识，Y/N',
  `limited_ip` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '限制允许登录的IP集合',
  `expired_time` datetime DEFAULT NULL COMMENT '账号失效时间，超过时间将不能登录系统',
  `last_change_pwd_time` datetime NOT NULL COMMENT '最近修改密码时间，超出时间间隔，提示用户修改密码',
  `last_login_time` datetime NOT NULL COMMENT '最近登录时间，最后活跃时间',
  `limit_multi_login` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '是否允许账号同一个时刻多人在线，Y/N',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  KEY `login_name` (`login_name`),
  KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'sa', '超级管理员', 'E10ADC3949BA59ABBE56E057F20F883E', 'Y', '', null, '2019-09-17 12:00:36', '2022-09-01 19:21:24', 'Y', '2019-07-19 16:36:03', '2022-08-25 06:57:49');
INSERT INTO `sys_user` VALUES ('2', 'admin', '用户', 'E10ADC3949BA59ABBE56E057F20F883E', 'Y', '', null, '2019-09-17 12:00:36', '2022-07-25 21:03:43', 'N', '2019-07-19 16:36:03', '2022-07-28 10:36:36');
INSERT INTO `sys_user` VALUES ('37763ff974984a439b973739db8a71f9', 'user', '111', 'E10ADC3949BA59ABBE56E057F20F883E', 'Y', '', null, '2022-07-25 20:58:07', '2022-07-25 21:02:26', 'N', '2022-07-25 20:58:07', '2022-07-25 21:02:06');

-- ----------------------------
-- Table structure for sys_user_authority
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_authority`;
CREATE TABLE `sys_user_authority` (
  `user_authority_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '用户权限表id',
  `user_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `authority_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '权限id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_authority_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='用户权限表';

-- ----------------------------
-- Records of sys_user_authority
-- ----------------------------
INSERT INTO `sys_user_authority` VALUES ('138c10d8d45346628e375717485d2c29', '2', '3fb1c570496d4c09ab99b8d31b06ccc', '2022-07-28 10:36:37', '2022-07-28 10:36:37');
INSERT INTO `sys_user_authority` VALUES ('20d536830e7a45e18d910753b5291bfd', '1', '3fb1c570496d4c09ab99b8d31b06zzz', '2022-08-25 06:57:49', '2022-08-25 06:57:49');
INSERT INTO `sys_user_authority` VALUES ('2537db5d513f4f4d8048c28a2b492d1a', '2', '3fb1c570496d4c09ab99b8d31b06xxx', '2022-07-28 10:36:37', '2022-07-28 10:36:37');
INSERT INTO `sys_user_authority` VALUES ('338d756665464f82b004f9823b936062', '1', '3fb1c570496d4c09ab99b8d31b06xxx', '2022-08-25 06:57:49', '2022-08-25 06:57:49');
INSERT INTO `sys_user_authority` VALUES ('61918aa48bfc4de2acd9dd42becbf01b', '2', '3fb1c570496d4c09ab99b8d31b06zzz', '2022-07-28 10:36:37', '2022-07-28 10:36:37');
INSERT INTO `sys_user_authority` VALUES ('72b723909bec45309131e37537a19f3b', '37763ff974984a439b973739db8a71f9', '3fb1c570496d4c09ab99b8d31b06ccc', '2022-07-25 21:02:06', '2022-07-25 21:02:06');
INSERT INTO `sys_user_authority` VALUES ('e05be63908f645eb9b5d5f757217b6e4', '1', '3fb1c570496d4c09ab99b8d31b06ccc', '2022-08-25 06:57:49', '2022-08-25 06:57:49');

-- ----------------------------
-- Table structure for sys_user_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_menu`;
CREATE TABLE `sys_user_menu` (
  `user_menu_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '用户菜单表id',
  `user_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `menu_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL COMMENT '菜单id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='用户菜单表';

-- ----------------------------
-- Records of sys_user_menu
-- ----------------------------
INSERT INTO `sys_user_menu` VALUES ('0b80119b6465425fa46bdf35fb056c10', '1', '914aa22c78af4327822061f3eada4067', '2022-08-25 06:57:49', '2022-08-25 06:57:49');
INSERT INTO `sys_user_menu` VALUES ('10306b2999384098ac029064f1e55ae0', '2', '35cb950cebb04bb18bb1d8b742a02xzz', '2022-07-28 10:36:37', '2022-07-28 10:36:37');
INSERT INTO `sys_user_menu` VALUES ('170ec56f318246e8aa2605adb79e7b61', '1', '35cb950cebb04bb18bb1d8b742a02xxx', '2022-08-25 06:57:49', '2022-08-25 06:57:49');
INSERT INTO `sys_user_menu` VALUES ('262bca6945f448aab0b3567f1466fede', '1', '35cb950cebb04bb18bb1d8b742a02xcc', '2022-08-25 06:57:49', '2022-08-25 06:57:49');
INSERT INTO `sys_user_menu` VALUES ('37b1335c1f084a148816a65f93580d1d', '2', 'bcf17dc0ce304f0ba02d64ce21ddb4f9', '2022-07-28 10:36:37', '2022-07-28 10:36:37');
INSERT INTO `sys_user_menu` VALUES ('4a48e2eb8ec448e69c4373dcd27e1d98', '2', '914aa22c78af4327822061f3eada4067', '2022-07-28 10:36:37', '2022-07-28 10:36:37');
INSERT INTO `sys_user_menu` VALUES ('5139ba7f9bd44d96a770b2f4ff7ede54', '1', '2d676108b871460991df57ab3995fec6', '2022-08-25 06:57:49', '2022-08-25 06:57:49');
INSERT INTO `sys_user_menu` VALUES ('7b2d3bdcbf604e709f446b147e18cd3b', '37763ff974984a439b973739db8a71f9', 'bcf17dc0ce304f0ba02d64ce21ddb4f9', '2022-07-25 21:02:06', '2022-07-25 21:02:06');
INSERT INTO `sys_user_menu` VALUES ('869e5ec2a3964d4eb07ab609a423dc12', '37763ff974984a439b973739db8a71f9', '35cb950cebb04bb18bb1d8b742a02005', '2022-07-25 21:02:06', '2022-07-25 21:02:06');
INSERT INTO `sys_user_menu` VALUES ('8d762c9c79474dbaaa0becd0392a06bf', '37763ff974984a439b973739db8a71f9', '35cb950cebb04bb18bb1d8b742a02xxx', '2022-07-25 21:02:06', '2022-07-25 21:02:06');
INSERT INTO `sys_user_menu` VALUES ('8e88fbff37eb4e63a4d1118b3c7ff6ac', '1', '35cb950cebb04bb18bb1d8b742a02xzz', '2022-08-25 06:57:49', '2022-08-25 06:57:49');
INSERT INTO `sys_user_menu` VALUES ('9f1df30c36314bc99eeb5fc0f3ff9e3e', '1', '35cb950cebb04bb18bb1d8b742a02005', '2022-08-25 06:57:49', '2022-08-25 06:57:49');
INSERT INTO `sys_user_menu` VALUES ('b5f625eba7e944179243b4afa8fe4439', '2', '35cb950cebb04bb18bb1d8b742a02xcc', '2022-07-28 10:36:37', '2022-07-28 10:36:37');
INSERT INTO `sys_user_menu` VALUES ('bc111aea97084a1e9ad03c85eae737ad', '2', '74315e162f524a4d88aa931f02416f26', '2022-07-28 10:36:37', '2022-07-28 10:36:37');
INSERT INTO `sys_user_menu` VALUES ('bf6122c1f02c4ec7a783521d33dcfd79', '1', '74315e162f524a4d88aa931f02416f26', '2022-08-25 06:57:49', '2022-08-25 06:57:49');
INSERT INTO `sys_user_menu` VALUES ('c2c23c8525e547f2bcd9211a9a9c888a', '1', 'bcf17dc0ce304f0ba02d64ce21ddb4f9', '2022-08-25 06:57:49', '2022-08-25 06:57:49');
INSERT INTO `sys_user_menu` VALUES ('cd3418e977dd43bf83f239073652ae2f', '2', '35cb950cebb04bb18bb1d8b742a02xxx', '2022-07-28 10:36:37', '2022-07-28 10:36:37');
INSERT INTO `sys_user_menu` VALUES ('d6ac7682c8804d81b2fdd044565b4bd8', '1', '35cb950cebb04bb18bb1d8b742a02xaa', '2022-08-25 06:57:49', '2022-08-25 06:57:49');
INSERT INTO `sys_user_menu` VALUES ('d8db689fba594168899970304cd43c46', '2', '35cb950cebb04bb18bb1d8b742a02xaa', '2022-07-28 10:36:37', '2022-07-28 10:36:37');
INSERT INTO `sys_user_menu` VALUES ('e24ec49fb0a7492a9512418bdd399db6', '2', '35cb950cebb04bb18bb1d8b742a02005', '2022-07-28 10:36:37', '2022-07-28 10:36:37');
SET FOREIGN_KEY_CHECKS=1;
