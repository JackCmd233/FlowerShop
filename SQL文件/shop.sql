/*
 Navicat Premium Data Transfer

 Source Server         : localMySql
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 14/09/2019 10:17:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ausertable
-- ----------------------------
DROP TABLE IF EXISTS `ausertable`;
CREATE TABLE `ausertable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `apwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ausertable
-- ----------------------------
INSERT INTO `ausertable` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for buseraddress
-- ----------------------------
DROP TABLE IF EXISTS `buseraddress`;
CREATE TABLE `buseraddress`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `busertable_id` int(11) NOT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `receiver` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `receiverphone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(4) NOT NULL DEFAULT 1 COMMENT '1表示这个地址还没有被删除, 0表示这个地址已经被删除了',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `busertable_id_idx`(`busertable_id`) USING BTREE,
  CONSTRAINT `bid1` FOREIGN KEY (`busertable_id`) REFERENCES `busertable` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buseraddress
-- ----------------------------
INSERT INTO `buseraddress` VALUES (1, 1, '湖南衡阳', '龙先生', '15697401234', 0);
INSERT INTO `buseraddress` VALUES (2, 2, '湖南长沙', '刘先生', '15697404444', 0);
INSERT INTO `buseraddress` VALUES (3, 1, '湖南衡阳', '龙基佬', '15697401234', 1);
INSERT INTO `buseraddress` VALUES (4, 1, '湖南岳阳', '李23', '15697401234', 1);
INSERT INTO `buseraddress` VALUES (5, 2, '9', '7', '8', 0);
INSERT INTO `buseraddress` VALUES (6, 2, '2', '2', '2', 0);
INSERT INTO `buseraddress` VALUES (7, 2, '3', '23', '23', 1);
INSERT INTO `buseraddress` VALUES (8, 2, '湖南娄底', '李四', '188', 0);
INSERT INTO `buseraddress` VALUES (9, 2, '789', '789', '789', 0);
INSERT INTO `buseraddress` VALUES (10, 2, '湖南长沙', '刘先生', '15697404444', 0);
INSERT INTO `buseraddress` VALUES (11, 2, '中国', '王五', '123654', 0);
INSERT INTO `buseraddress` VALUES (12, 2, '2', '2', '2', 1);
INSERT INTO `buseraddress` VALUES (13, 3, '湖南娄底', '刘', '15697404444', 0);
INSERT INTO `buseraddress` VALUES (14, 3, '7', '7', '7', 0);
INSERT INTO `buseraddress` VALUES (15, 3, 'zg.cs.wcq', '456', '15697404561', 0);
INSERT INTO `buseraddress` VALUES (16, 3, '123', '789', '456', 0);
INSERT INTO `buseraddress` VALUES (17, 3, '4231111', '789', '444', 0);
INSERT INTO `buseraddress` VALUES (18, 3, '66666', '44', '555', 0);
INSERT INTO `buseraddress` VALUES (19, 3, '66666', '44', '555', 0);
INSERT INTO `buseraddress` VALUES (20, 3, '理工学院第九次', '袁麻第九次', '15697404567第九次', 0);
INSERT INTO `buseraddress` VALUES (21, 3, '湖南2号', 'ym2号', '15697403698', 0);
INSERT INTO `buseraddress` VALUES (22, 3, 'cs3号', 'ym3号', '45698732112', 0);
INSERT INTO `buseraddress` VALUES (23, 3, 'hnLIU第4次测试', '刘某人第4次测试', '18890234567第4次测试', 0);
INSERT INTO `buseraddress` VALUES (24, 3, '湖南LIU2', 'LIU2', '123456789369', 0);
INSERT INTO `buseraddress` VALUES (25, 3, '市民一号的家,AAA区BBB栋CCC层', '市民一号', '15697404299', 1);
INSERT INTO `buseraddress` VALUES (26, 3, '????? 123', '?? ??? 123', '45636985214??? 123', 0);
INSERT INTO `buseraddress` VALUES (27, 3, '这个地方网络不好啊', '零零', '15697405698', 1);
INSERT INTO `buseraddress` VALUES (28, 3, '97ll', '66', '789', 0);
INSERT INTO `buseraddress` VALUES (29, 3, '66', 'liu', '18890394561', 0);
INSERT INTO `buseraddress` VALUES (30, 3, '湖南长沙望城区456', '你想干嘛', '18890396653', 1);
INSERT INTO `buseraddress` VALUES (31, 3, '顶顶顶', '流量', '15697404266', 0);
INSERT INTO `buseraddress` VALUES (32, 3, '云上贵州,真的假的啊', '刘某人', '18845699321', 0);
INSERT INTO `buseraddress` VALUES (33, 3, '哇哇哇哇哇', '啊啊啊啊', '18890394563', 0);
INSERT INTO `buseraddress` VALUES (34, 3, '新疆', '  ddd', '188 9039 6682', 1);

-- ----------------------------
-- Table structure for busertable
-- ----------------------------
DROP TABLE IF EXISTS `busertable`;
CREATE TABLE `busertable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bphone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bpwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bfocus` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bcanlogin` int(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `bphone_UNIQUE`(`bphone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of busertable
-- ----------------------------
INSERT INTO `busertable` VALUES (1, '1', '123456', '3025|4568|2|6|8|28', 1);
INSERT INTO `busertable` VALUES (2, '2', '2', '', 1);
INSERT INTO `busertable` VALUES (3, '15697404444', '123', '31|', 1);
INSERT INTO `busertable` VALUES (4, '18890394563', '123456789', '', 1);
INSERT INTO `busertable` VALUES (5, '18890398523', '123456', '', 1);

-- ----------------------------
-- Table structure for goodsdiscount
-- ----------------------------
DROP TABLE IF EXISTS `goodsdiscount`;
CREATE TABLE `goodsdiscount`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodstable_id` int(11) NOT NULL,
  `gdprice` double NOT NULL,
  `gdnow` int(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goodstable_id_idx`(`goodstable_id`) USING BTREE,
  CONSTRAINT `gno1` FOREIGN KEY (`goodstable_id`) REFERENCES `goodstable` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodsdiscount
-- ----------------------------
INSERT INTO `goodsdiscount` VALUES (25, 28, 28, 0);
INSERT INTO `goodsdiscount` VALUES (26, 29, 29, 0);
INSERT INTO `goodsdiscount` VALUES (27, 30, 30, 0);
INSERT INTO `goodsdiscount` VALUES (28, 31, 31, 0);
INSERT INTO `goodsdiscount` VALUES (29, 32, 32, 0);
INSERT INTO `goodsdiscount` VALUES (30, 33, 33, 0);
INSERT INTO `goodsdiscount` VALUES (31, 32, 32, 0);
INSERT INTO `goodsdiscount` VALUES (32, 31, 31, 0);
INSERT INTO `goodsdiscount` VALUES (33, 32, 32, 0);
INSERT INTO `goodsdiscount` VALUES (34, 31, 31, 0);
INSERT INTO `goodsdiscount` VALUES (35, 32, 32, 1);
INSERT INTO `goodsdiscount` VALUES (36, 31, 31, 1);
INSERT INTO `goodsdiscount` VALUES (37, 29, 29, 1);
INSERT INTO `goodsdiscount` VALUES (38, 28, 28, 1);
INSERT INTO `goodsdiscount` VALUES (39, 33, 33, 1);
INSERT INTO `goodsdiscount` VALUES (40, 30, 30, 1);

-- ----------------------------
-- Table structure for goodstable
-- ----------------------------
DROP TABLE IF EXISTS `goodstable`;
CREATE TABLE `goodstable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goprice` double NOT NULL,
  `gunit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gstore` int(11) NOT NULL,
  `gpicture` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodstype_tid` int(11) NOT NULL,
  `gfocusnum` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goodstype_tid_idx`(`goodstype_tid`) USING BTREE,
  CONSTRAINT `typeid` FOREIGN KEY (`goodstype_tid`) REFERENCES `goodstype` (`tid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodstable
-- ----------------------------
INSERT INTO `goodstable` VALUES (28, '时间赛季', 80, '枝', 782, '20190730141408790.jpg', 3025, 1);
INSERT INTO `goodstable` VALUES (29, '鲜花', 80, '斤', 500, '20190730141402623.png', 3025, 0);
INSERT INTO `goodstable` VALUES (30, '仙人球', 90, '串', 800, '20190730141438500.jpg', 3025, 0);
INSERT INTO `goodstable` VALUES (31, '鲜花', 20, '枝', 68, '20190730141355184.jpg', 3025, 1);
INSERT INTO `goodstable` VALUES (32, '水仙', 80, '斤', 0, '20190730141345686.jpg', 3025, 1);
INSERT INTO `goodstable` VALUES (33, '狗尾巴草', 80, '斤', 900, '20190730141416536.jpg', 3025, 0);

-- ----------------------------
-- Table structure for goodstype
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) NOT NULL,
  `typename` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `describ` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `tid_UNIQUE`(`tid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO `goodstype` VALUES (1, 3025, '鲜花', '整束包装');
INSERT INTO `goodstype` VALUES (2, 4568, '永生花', '礼盒式');
INSERT INTO `goodstype` VALUES (3, 8956, '花篮', '篮子');
INSERT INTO `goodstype` VALUES (5, 4123, '干花', '很干');
INSERT INTO `goodstype` VALUES (6, 7412, '小花', '很小');

-- ----------------------------
-- Table structure for noticetable
-- ----------------------------
DROP TABLE IF EXISTS `noticetable`;
CREATE TABLE `noticetable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ntitle` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ncontent` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ntime` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of noticetable
-- ----------------------------
INSERT INTO `noticetable` VALUES (7, '1', '1', '2019-07-18 20:24:22');
INSERT INTO `noticetable` VALUES (8, '2', '2', '2019-07-20 14:36:36');
INSERT INTO `noticetable` VALUES (9, '3', '3', '2019-07-20 14:36:41');
INSERT INTO `noticetable` VALUES (10, '4', '4', '2019-07-20 14:36:45');
INSERT INTO `noticetable` VALUES (11, '5', '5', '2019-07-20 14:36:48');
INSERT INTO `noticetable` VALUES (12, '6', '6', '2019-07-20 14:36:51');
INSERT INTO `noticetable` VALUES (13, '7', '7', '2019-07-20 14:36:55');
INSERT INTO `noticetable` VALUES (14, '8', '8', '2019-07-20 14:36:59');
INSERT INTO `noticetable` VALUES (15, '9', '9', '2019-07-20 14:37:02');
INSERT INTO `noticetable` VALUES (16, '10', '10', '2019-07-20 14:37:06');
INSERT INTO `noticetable` VALUES (17, '11', '11', '2019-07-20 14:37:10');
INSERT INTO `noticetable` VALUES (18, '情人节狂欢', '通通九块八', '2019-07-20 17:51:00');

-- ----------------------------
-- Table structure for orderbasetable
-- ----------------------------
DROP TABLE IF EXISTS `orderbasetable`;
CREATE TABLE `orderbasetable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `busertable_id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `status` int(1) NOT NULL,
  `orderdate` datetime(0) NOT NULL,
  `payway` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buseraddress_id` int(11) NOT NULL,
  `deletestatus` int(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `busertable_id_idx`(`busertable_id`) USING BTREE,
  INDEX `buseraddress_id_idx`(`buseraddress_id`) USING BTREE,
  CONSTRAINT `addrid` FOREIGN KEY (`buseraddress_id`) REFERENCES `buseraddress` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `bid2` FOREIGN KEY (`busertable_id`) REFERENCES `busertable` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderbasetable
-- ----------------------------
INSERT INTO `orderbasetable` VALUES (1, 1, 50, 1, '2019-06-18 17:45:35', '支付宝', 1, 1);
INSERT INTO `orderbasetable` VALUES (2, 1, 100, 0, '2019-07-18 17:45:35', '微信', 1, 1);
INSERT INTO `orderbasetable` VALUES (3, 1, 10, 1, '2019-06-25 17:45:35', '微信', 1, 1);
INSERT INTO `orderbasetable` VALUES (4, 1, 193, 0, '2019-07-18 19:45:35', '支付宝', 1, 1);
INSERT INTO `orderbasetable` VALUES (5, 3, 150, 0, '2019-07-20 17:45:35', NULL, 26, 1);
INSERT INTO `orderbasetable` VALUES (6, 3, 200, 0, '2019-07-27 12:04:45', NULL, 25, 0);
INSERT INTO `orderbasetable` VALUES (7, 3, 341, 0, '2019-07-27 12:06:00', NULL, 26, 0);
INSERT INTO `orderbasetable` VALUES (8, 3, 31, 0, '2019-07-27 14:03:55', NULL, 26, 0);
INSERT INTO `orderbasetable` VALUES (9, 3, 31, 0, '2019-07-27 14:06:46', NULL, 27, 1);
INSERT INTO `orderbasetable` VALUES (10, 3, 310, 0, '2019-07-27 14:11:24', NULL, 27, 1);
INSERT INTO `orderbasetable` VALUES (11, 3, 630, 0, '2019-07-27 14:16:59', NULL, 26, 1);
INSERT INTO `orderbasetable` VALUES (12, 3, 1734, 0, '2019-07-27 14:21:35', NULL, 26, 1);
INSERT INTO `orderbasetable` VALUES (13, 3, 59, 0, '2019-07-27 14:46:45', NULL, 27, 1);
INSERT INTO `orderbasetable` VALUES (14, 3, 31, 0, '2019-07-27 15:36:27', NULL, 26, 1);
INSERT INTO `orderbasetable` VALUES (15, 3, 372, 0, '2019-07-30 09:26:18', NULL, 27, 1);
INSERT INTO `orderbasetable` VALUES (16, 3, 1280, 0, '2019-07-30 09:34:18', NULL, 28, 1);
INSERT INTO `orderbasetable` VALUES (17, 3, 160, 0, '2019-07-30 09:40:15', NULL, 27, 1);
INSERT INTO `orderbasetable` VALUES (18, 3, 448, 0, '2019-07-30 09:57:22', NULL, 27, 1);
INSERT INTO `orderbasetable` VALUES (19, 3, 128, 0, '2019-07-30 11:23:39', NULL, 27, 1);
INSERT INTO `orderbasetable` VALUES (20, 3, 28, 0, '2019-07-30 11:48:43', NULL, 27, 1);
INSERT INTO `orderbasetable` VALUES (21, 3, 60, 0, '2019-07-30 14:17:22', NULL, 27, 1);

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail`  (
  `orderbasetable_id` int(11) NOT NULL,
  `goodstable_id` int(11) NOT NULL,
  `orderprice` double NOT NULL,
  `shoppingnum` int(11) NOT NULL,
  `ordercount` double NOT NULL,
  PRIMARY KEY (`orderbasetable_id`, `goodstable_id`) USING BTREE,
  INDEX `goodstable_id_idx`(`goodstable_id`) USING BTREE,
  CONSTRAINT `gno2` FOREIGN KEY (`goodstable_id`) REFERENCES `goodstable` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `obid` FOREIGN KEY (`orderbasetable_id`) REFERENCES `orderbasetable` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES (3, 31, 31, 1, 31);
INSERT INTO `orderdetail` VALUES (6, 31, 20, 10, 200);
INSERT INTO `orderdetail` VALUES (10, 31, 31, 10, 310);
INSERT INTO `orderdetail` VALUES (11, 31, 31, 10, 310);
INSERT INTO `orderdetail` VALUES (11, 32, 32, 10, 320);
INSERT INTO `orderdetail` VALUES (12, 31, 31, 26, 806);
INSERT INTO `orderdetail` VALUES (12, 32, 32, 29, 928);
INSERT INTO `orderdetail` VALUES (13, 28, 28, 1, 28);
INSERT INTO `orderdetail` VALUES (13, 31, 31, 1, 31);
INSERT INTO `orderdetail` VALUES (14, 31, 31, 1, 31);
INSERT INTO `orderdetail` VALUES (15, 31, 31, 12, 372);
INSERT INTO `orderdetail` VALUES (16, 32, 32, 40, 1280);
INSERT INTO `orderdetail` VALUES (17, 32, 32, 5, 160);
INSERT INTO `orderdetail` VALUES (18, 28, 28, 16, 448);
INSERT INTO `orderdetail` VALUES (19, 32, 32, 4, 128);
INSERT INTO `orderdetail` VALUES (20, 28, 28, 1, 28);
INSERT INTO `orderdetail` VALUES (21, 28, 28, 1, 28);
INSERT INTO `orderdetail` VALUES (21, 32, 32, 1, 32);

SET FOREIGN_KEY_CHECKS = 1;
