/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50549
 Source Host           : localhost:3306
 Source Schema         : gp_api

 Target Server Type    : MySQL
 Target Server Version : 50549
 File Encoding         : 65001

 Date: 06/04/2020 19:30:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for advertising
-- ----------------------------
DROP TABLE IF EXISTS `advertising`;
CREATE TABLE `advertising`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for coupons
-- ----------------------------
DROP TABLE IF EXISTS `coupons`;
CREATE TABLE `coupons`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contents` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1.红包优惠2.折扣优惠3.满减优惠4.首单优惠5系统红包',
  `user_id` int(11) DEFAULT NULL,
  `all_type` int(11) DEFAULT 0 COMMENT '1店铺优惠、2客户端优惠',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `discount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `end` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `start` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of coupons
-- ----------------------------
INSERT INTO `coupons` VALUES (1, NULL, 1, 1, NULL, 1, NULL, NULL, '5', '20', NULL);
INSERT INTO `coupons` VALUES (2, NULL, 1, 2, NULL, 1, NULL, '0.85', NULL, NULL, NULL);
INSERT INTO `coupons` VALUES (3, NULL, 1, 3, NULL, 1, NULL, NULL, '18', '20', NULL);
INSERT INTO `coupons` VALUES (4, '首单优惠', 1, 4, NULL, 1, '15', NULL, NULL, NULL, NULL);
INSERT INTO `coupons` VALUES (5, NULL, 2, 1, NULL, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `coupons` VALUES (6, NULL, 3, 2, NULL, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `coupons` VALUES (7, NULL, 1, 3, NULL, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `coupons` VALUES (8, NULL, 1, 4, NULL, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `coupons` VALUES (9, NULL, 2, 2, NULL, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `coupons` VALUES (10, NULL, 2, 4, NULL, 1, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for evaluation
-- ----------------------------
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of evaluation
-- ----------------------------
INSERT INTO `evaluation` VALUES (1, '不错不错', NULL, 1, NULL);
INSERT INTO `evaluation` VALUES (2, '味道好极了', NULL, 2, NULL);
INSERT INTO `evaluation` VALUES (3, '你妈嗨', NULL, 3, NULL);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` decimal(19, 2) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  `sum` int(11) DEFAULT 0,
  `type` int(11) DEFAULT 1,
  `use_status` int(11) DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (4, 'store1.jpg', '炒菜一号', 6.30, 2, 0, 1, 0);
INSERT INTO `goods` VALUES (5, 'store2.jpg', '二号', 9.80, 2, 0, 1, 0);
INSERT INTO `goods` VALUES (6, 'store3.jpg', 'tm三号', 15.00, 2, 0, 1, 0);

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `grade_goods` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0',
  `grade_taste` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0',
  `graderide` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0',
  `order_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (1, '4.2', '3.6', '4.5', 1, 1);
INSERT INTO `grade` VALUES (2, '4.6', '4.5', '4.6', 2, 2);
INSERT INTO `grade` VALUES (3, '4.1', '4.6', '5', 3, 2);

-- ----------------------------
-- Table structure for members
-- ----------------------------
DROP TABLE IF EXISTS `members`;
CREATE TABLE `members`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `price` decimal(19, 2) DEFAULT NULL,
  `price_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_time` datetime DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `delivery_man` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `delivery_man_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` decimal(19, 2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '1.备餐中2.已配送3.已完成4.已取消',
  `store_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `rider_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '2020-04-02 16:14:55', '送到学校来', '宋外卖', '1885262223', NULL, 23.36, 3, 2, 1, 8);
INSERT INTO `orders` VALUES (2, '2020-04-03 11:14:06', NULL, NULL, NULL, NULL, 23.00, 3, 2, 2, 8);
INSERT INTO `orders` VALUES (3, '2020-04-02 11:14:10', NULL, NULL, NULL, NULL, 56.00, 3, 2, 2, 8);

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `evaluation_id` int(11) DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for rider_detail
-- ----------------------------
DROP TABLE IF EXISTS `rider_detail`;
CREATE TABLE `rider_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for store_detail
-- ----------------------------
DROP TABLE IF EXISTS `store_detail`;
CREATE TABLE `store_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `disable_status` int(11) DEFAULT 0 COMMENT '0为启用1为禁用',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '1.美食2.超市3.水果4.晚餐5.汉堡6速食7蔬菜8大牌9炸鸡10粥铺',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `use_status` int(11) DEFAULT 1,
  `user_id` int(11) DEFAULT NULL,
  `latitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `shipping_fee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `shipping_time_length` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `start_fee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of store_detail
-- ----------------------------
INSERT INTO `store_detail` VALUES (1, '冷底村', 'test', 0, 'store1.jpg', '第一店铺', '18852986629', '1-3-5-9', 1, 3, '27.385212', '105.66223', '5', '40', '25');
INSERT INTO `store_detail` VALUES (2, '东园小区', 'test2', 0, 'store2.jpg', '第二店铺', '15121491723', '1-2-4-6', 1, 4, '27.30276', '105.299632', '5', '60', '25');
INSERT INTO `store_detail` VALUES (3, '达溪镇冷底小学', 'test3', 0, 'store3.jpg', '第三店铺', '15269386953', '1-7-8-10', 1, 5, '27.387093', '105.662926', '5', '40', '25');
INSERT INTO `store_detail` VALUES (4, 'test2', NULL, 0, 's2.png', '发热分', NULL, NULL, 1, 6, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (5, '的', NULL, 0, 's3.png', '打的费', NULL, NULL, 1, 7, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (6, '3434', NULL, 0, 's4.png', '从DVD', NULL, NULL, 1, 8, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (7, '656', NULL, 0, 's5.png', '猜测女', NULL, NULL, 1, 9, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (8, '89', NULL, 0, 's6.png', '吃饭吧', NULL, NULL, 1, 10, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (9, '0-', NULL, 0, 's7.png', '恶女', NULL, NULL, 1, 11, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (10, '09', NULL, 0, 's8.png', 'VRVRv1', NULL, NULL, 1, 12, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (11, 'deeffe', NULL, 0, 's9.png', '的v额额', NULL, NULL, 1, 13, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (12, '434', NULL, 0, 's10.png', '侧女', NULL, NULL, 1, 14, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (13, '4f4f', NULL, 0, 's1.png', '1发错人', NULL, NULL, 1, 15, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (14, '5gh6', NULL, 0, 's2.png', NULL, NULL, NULL, 1, 16, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (15, 'ewf', NULL, 0, 's3.png', '发热分', NULL, NULL, 1, 17, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (16, 'ewfe', NULL, 0, 's4.png', '插入测', NULL, NULL, 1, 18, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (17, 'dewf', NULL, 0, 's5.png', '融入', NULL, NULL, 1, 19, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (18, 'dwef', NULL, 0, 's6.png', '发热分', NULL, NULL, 1, 20, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (19, 'dwe', NULL, 0, 's7.png', '策略', NULL, NULL, 1, 21, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (20, 'dewf', NULL, 0, 's8.png', '额VR方法', NULL, NULL, 1, 23, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `store_detail` VALUES (21, 'fefr', NULL, 0, 's9.png', '发热分', NULL, NULL, 1, 24, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `disable_status` int(11) DEFAULT 0,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1小程序2商家3骑手4管理员',
  `open_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '小程序用户唯一标识...',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, NULL, 0, NULL, NULL, NULL, NULL, 1, 'oBcVO5RU4H-EtJkRbqu4EW7CecX0');
INSERT INTO `user` VALUES (2, '123456', 0, NULL, NULL, NULL, NULL, 1, 'oBcVO5bWnpF-UnlqkKSnxDoerkgA');
INSERT INTO `user` VALUES (3, '123456', 0, NULL, '3', '123456', NULL, 2, NULL);
INSERT INTO `user` VALUES (4, NULL, 0, NULL, '4', 'vfgbg', NULL, 2, NULL);
INSERT INTO `user` VALUES (5, NULL, 0, NULL, '5', '123f', NULL, 2, NULL);
INSERT INTO `user` VALUES (6, NULL, 0, NULL, '6', 'vf456', NULL, 2, NULL);
INSERT INTO `user` VALUES (7, NULL, 0, NULL, '7', 'vfvg45', NULL, 2, NULL);
INSERT INTO `user` VALUES (8, NULL, 0, NULL, '8', 'hhjkj', NULL, 3, NULL);
INSERT INTO `user` VALUES (9, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (10, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (11, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (12, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (13, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (14, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (15, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (16, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (17, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (18, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (19, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (20, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (21, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (22, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (23, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (24, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);
INSERT INTO `user` VALUES (25, NULL, 0, NULL, NULL, NULL, NULL, 2, NULL);

-- ----------------------------
-- Table structure for user_adderss
-- ----------------------------
DROP TABLE IF EXISTS `user_adderss`;
CREATE TABLE `user_adderss`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `latitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_adderss
-- ----------------------------
INSERT INTO `user_adderss` VALUES (90, '毕节市七星关区人民政府', '27.29847', '105.30504', '杨志学', '188529866269', '大方县', 1);
INSERT INTO `user_adderss` VALUES (97, '三江依山雅苑', '27.2996', '105.30303', '刘亦菲', '10085', '河边', 1);
INSERT INTO `user_adderss` VALUES (98, '冷底村', '27.385212', '105.66223', '杨志学手机', '15388', '家里', 1);
INSERT INTO `user_adderss` VALUES (99, '冷底村(毕节市大方县)', '27.38902', '105.66356', '阿鲁', '55859', '看看图', 2);
INSERT INTO `user_adderss` VALUES (100, '美国史密斯', '27.15212', '105.60181', '杨境', '5201314', NULL, 2);
INSERT INTO `user_adderss` VALUES (101, '东园小区', '27.30276', '105.299632', 'test', '123', '详细', 1);
INSERT INTO `user_adderss` VALUES (102, '三江依山雅苑', '27.2996', '105.30303', '1', '18852986629', NULL, 1);
INSERT INTO `user_adderss` VALUES (103, '达溪镇冷底小学', '27.387093', '105.662926', '地址1', '18856329632', '四层', 1);

SET FOREIGN_KEY_CHECKS = 1;
