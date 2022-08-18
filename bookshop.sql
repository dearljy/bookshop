/*
 Navicat Premium Data Transfer

 Source Server         : 本机Mysql
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : bookshop2

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 18/08/2022 17:55:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(11, 2) NOT NULL,
  `sales` int(10) UNSIGNED NOT NULL,
  `stock` int(10) UNSIGNED NOT NULL,
  `img_path` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '荒野上的大师', '张泉', 20.00, 40, 162, 'assets/images/product-image/r4.jpg');
INSERT INTO `book` VALUES (2, '导演', '西德尼·吕美特', 180.00, 692, 179, 'assets/images/product-image/r5.jpg');
INSERT INTO `book` VALUES (3, '下馆子', '凯蒂·罗森', 50.00, 86, 50, 'assets/images/product-image/r6.jpg');
INSERT INTO `book` VALUES (4, '棋王', '阿城', 39.00, 238, 86, 'assets/images/product-image/r7.jpg');
INSERT INTO `book` VALUES (23, '如雪如山', '小梁', 60.00, 100, 80, 'assets/images/product-image/default.jpg');
INSERT INTO `book` VALUES (30, '如雪如山', '张天翼', 100.00, 666, 80, 'assets/images/product-image/default.jpg');
INSERT INTO `book` VALUES (32, '如雪如山', '张天翼', 39.00, 100, 80, 'assets/images/product-image/default.jpg');
INSERT INTO `book` VALUES (33, '如雪如山', '张天翼', 39.00, 100, 80, 'assets/images/product-image/default.jpg');
INSERT INTO `book` VALUES (34, '如雪如山', '张天翼', 39.00, 100, 80, 'assets/images/product-image/default.jpg');
INSERT INTO `book` VALUES (35, '如雪如山', '张天翼', 39.00, 100, 80, 'assets/images/product-image/default.jpg');
INSERT INTO `book` VALUES (36, '如雪如山', '张天翼', 39.00, 100, 80, 'assets/images/product-image/default.jpg');
INSERT INTO `book` VALUES (37, '如雪如山', '张天翼', 39.00, 100, 80, 'assets/images/product-image/default.jpg');
INSERT INTO `book` VALUES (38, '如雪如山', '张天翼', 39.00, 100, 80, 'assets/images/product-image/default.jpg');
INSERT INTO `book` VALUES (39, '如雪如山', '张天翼', 39.00, 100, 80, 'assets/images/product-image/default.jpg');
INSERT INTO `book` VALUES (41, '如雪如山', '老潘', 39.00, 666, 80, 'assets/images/product-image/default.jpg');
INSERT INTO `book` VALUES (42, '如雪如山', '张天翼', 48.00, 100, 80, 'assets/images/product-image/default.jpg');
INSERT INTO `book` VALUES (43, '如雪如山', '赵日天', 39.00, 100, 80, 'assets/images/product-image/default.jpg');

-- ----------------------------
-- Table structure for cart_item
-- ----------------------------
DROP TABLE IF EXISTS `cart_item`;
CREATE TABLE `cart_item`  (
  `memberId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(11, 2) NOT NULL,
  `count` int(11) NOT NULL,
  `totalPrice` decimal(11, 2) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart_item
-- ----------------------------
INSERT INTO `cart_item` VALUES (1, 2, '导演', 180.00, 2, 360.00);
INSERT INTO `cart_item` VALUES (8, 1, '荒野上的大师', 20.00, 1, 20.00);
INSERT INTO `cart_item` VALUES (8, 2, '导演', 180.00, 4, 720.00);
INSERT INTO `cart_item` VALUES (8, 3, '下馆子', 50.00, 2, 100.00);

-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage
-- ----------------------------
INSERT INTO `manage` VALUES (1, 'root', '670b14728ad9902aecba32e22fa4f6bd');
INSERT INTO `manage` VALUES (4, '666666', 'f379eaf3c831b04de153469d1bec345e');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'tjt@tianjuntao.net');
INSERT INTO `member` VALUES (2, 'tom', 'e10adc3949ba59abbe56e057f20f883e', 'baidu@qq.com');
INSERT INTO `member` VALUES (3, 'knight', 'e10adc3949ba59abbe56e057f20f883e', 'zll@qq.com');
INSERT INTO `member` VALUES (4, 'pan123', 'b4e367e5f88d3f5fd76efb967257411b', 'pan123@qq.com');
INSERT INTO `member` VALUES (5, 'tjtedu', 'e2b433afffd44fb57481612c9b75069f', 'tjtedu@qq.com');
INSERT INTO `member` VALUES (6, 'mary100', '5b4088a06b0768b3be01beabfd3132c3', 'mary100@qq.com');
INSERT INTO `member` VALUES (7, 'tjt666', '2d201f1bf0f3eb924794e2bdf8b9a154', 'tjt666@qq.com');
INSERT INTO `member` VALUES (8, 'tjt999', 'ad43f4c7f38ad0a5b64e5b28ff85440e', 'tjt999@qq.com');
INSERT INTO `member` VALUES (9, 'liy999', '5414ac6427fe27abb2ce6672a6dcd191', 'liy999@qq.com');
INSERT INTO `member` VALUES (10, 'wangjing77', 'cbee4ca5a0ba8636eeb802a6ad402aa7', 'wangjing77@qq.com');
INSERT INTO `member` VALUES (11, '555555', '5b1b68a9abf4d2cd155c81a9225fd158', '123@qq.com');
INSERT INTO `member` VALUES (12, '777777', 'f63f4fbc9f8c85d409f2f59f2b9e12d5', '777777@qq.com');
INSERT INTO `member` VALUES (13, '999999999', 'c8c605999f3d8352d7bb792cf3fdb25b', '999999999@qq.com');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `price` decimal(11, 2) NOT NULL,
  `state` tinyint(4) NOT NULL,
  `memberId` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('16594353744198', '2022-08-02 18:16:15', 840.00, 0, 8);
INSERT INTO `order` VALUES ('16594951953619', '2022-08-03 10:53:16', 289.00, 0, 9);
INSERT INTO `order` VALUES ('16596631899179', '2022-08-05 09:33:10', 129.00, 0, 9);
INSERT INTO `order` VALUES ('16596646820199', '2022-08-05 09:58:02', 289.00, 0, 9);
INSERT INTO `order` VALUES ('165966501913613', '2022-08-05 10:03:39', 239.00, 0, 13);

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(11, 2) NOT NULL,
  `count` int(11) NOT NULL,
  `total_price` decimal(11, 2) NOT NULL,
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES (2, '荒野上的大师', 20.00, 1, 20.00, '124342543654');
INSERT INTO `order_item` VALUES (3, '导演', 180.00, 4, 720.00, '124342543654');
INSERT INTO `order_item` VALUES (4, '下馆子', 50.00, 2, 100.00, '124342543654');
INSERT INTO `order_item` VALUES (45, '荒野上的大师', 20.00, 1, 20.00, '16594951953619');
INSERT INTO `order_item` VALUES (46, '导演', 180.00, 1, 180.00, '16594951953619');
INSERT INTO `order_item` VALUES (47, '下馆子', 50.00, 1, 50.00, '16594951953619');
INSERT INTO `order_item` VALUES (48, '棋王', 39.00, 1, 39.00, '16594951953619');
INSERT INTO `order_item` VALUES (49, '荒野上的大师', 20.00, 2, 40.00, '16596631899179');
INSERT INTO `order_item` VALUES (50, '下馆子', 50.00, 1, 50.00, '16596631899179');
INSERT INTO `order_item` VALUES (51, '棋王', 39.00, 1, 39.00, '16596631899179');
INSERT INTO `order_item` VALUES (52, '荒野上的大师', 20.00, 1, 20.00, '16596646820199');
INSERT INTO `order_item` VALUES (53, '导演', 180.00, 1, 180.00, '16596646820199');
INSERT INTO `order_item` VALUES (54, '下馆子', 50.00, 1, 50.00, '16596646820199');
INSERT INTO `order_item` VALUES (55, '棋王', 39.00, 1, 39.00, '16596646820199');
INSERT INTO `order_item` VALUES (56, '荒野上的大师', 20.00, 1, 20.00, '165966501913613');
INSERT INTO `order_item` VALUES (57, '导演', 180.00, 1, 180.00, '165966501913613');
INSERT INTO `order_item` VALUES (58, '棋王', 39.00, 1, 39.00, '165966501913613');

SET FOREIGN_KEY_CHECKS = 1;
