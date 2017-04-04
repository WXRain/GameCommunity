/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : gamecommunity

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 04/03/2017 23:33:03 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `game`
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `size` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `buildDate` datetime DEFAULT NULL,
  `introduce` text,
  `price` double DEFAULT NULL,
  `cutOff` double DEFAULT NULL,
  `systemTypeNum` int(11) DEFAULT NULL,
  `version` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `path` varchar(60) CHARACTER SET latin1 DEFAULT NULL,
  `sectionId` int(11) DEFAULT NULL,
  `picturePath` varchar(60) CHARACTER SET latin1 DEFAULT NULL,
  `gamename` varchar(300) DEFAULT NULL,
  `gameType` bigint(20) DEFAULT NULL,
  `downloadNum` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `game`
-- ----------------------------
BEGIN;
INSERT INTO `game` VALUES ('1', '56MB', '2017-03-05 21:26:17', 'This is a very good game.', '15.23', '1', '1', '1.6.5', '/download/dontstarve/1.6.5/dontstarve.exe', '1', '/download/dont stave/1.6.5/pictures', '饥荒', '1', '6'), ('2', '56MB', '2017-03-05 21:26:17', 'This is a very bad game.', '24', '0.5', '1', '2.8.7', '/download/run/2.8.7/run.exe', '2', '/download/run/2.8.7/pictures', '天天酷跑', '2', '0');
COMMIT;

-- ----------------------------
--  Table structure for `game_type`
-- ----------------------------
DROP TABLE IF EXISTS `game_type`;
CREATE TABLE `game_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(120) DEFAULT NULL,
  `manager` varchar(120) DEFAULT NULL,
  `introduce` varchar(240) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `game_type`
-- ----------------------------
BEGIN;
INSERT INTO `game_type` VALUES ('1', '生存', '1', 'survive', '2017-03-18 12:54:41'), ('2', '冒险', '1', 'maoxian', '2017-03-18 16:03:25');
COMMIT;

-- ----------------------------
--  Table structure for `order_copy`
-- ----------------------------
DROP TABLE IF EXISTS `order_copy`;
CREATE TABLE `order_copy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `payTime` datetime DEFAULT NULL,
  `money` double DEFAULT NULL,
  `gameIds` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `order_copy`
-- ----------------------------
BEGIN;
INSERT INTO `order_copy` VALUES ('8', '1', '2017-04-01 16:12:13', '2017-04-01 16:13:35', '27.23', '1,2'), ('9', '1', '2017-04-01 16:12:13', '2017-04-01 16:13:39', '27.23', '1,2'), ('10', '1', '2017-04-03 12:41:14', '2017-04-03 12:41:15', '15.23', '1'), ('11', '1', '2017-04-03 12:41:44', '2017-04-03 12:41:45', '12', '2'), ('12', '1', '2017-04-03 19:39:25', '2017-04-03 19:39:27', '12', '2'), ('13', '1', '2017-04-03 19:52:42', '2017-04-03 19:52:43', '12', '2');
COMMIT;

-- ----------------------------
--  Table structure for `section`
-- ----------------------------
DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `introduce` text,
  `topicNum` int(11) DEFAULT NULL,
  `sectionManager` varchar(12000) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `gameId` bigint(20) DEFAULT NULL,
  `gameType` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `section`
-- ----------------------------
BEGIN;
INSERT INTO `section` VALUES ('1', '饥荒版面', '喜欢饥荒的玩家请来这里。', '1', '1,3', '2017-03-06 19:46:31', '1', '1'), ('2', '天天酷跑', 'run！', '1', '1', '2017-03-19 14:24:05', '2', '2');
COMMIT;

-- ----------------------------
--  Table structure for `shopping_cart`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL,
  `gameIds` varchar(120) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `systemsupport`
-- ----------------------------
DROP TABLE IF EXISTS `systemsupport`;
CREATE TABLE `systemsupport` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `memoria` varchar(1000) DEFAULT NULL,
  `system` varchar(1000) DEFAULT NULL,
  `disk` varchar(1000) DEFAULT NULL,
  `voice` varchar(1000) DEFAULT NULL,
  `network` char(2) DEFAULT NULL,
  `cpu` varchar(1000) DEFAULT NULL,
  `display` varchar(1000) DEFAULT NULL,
  `note` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `systemsupport`
-- ----------------------------
BEGIN;
INSERT INTO `systemsupport` VALUES ('1', '2 GB RAM', 'Windows® 7 32/64-bit / Vista 32/64 / XP', '需要 13 GB 可用空间', 'DirectX 9.0c compatible sound card', '1', 'Pentium 4 3.0GHz', 'Video card with 128 MB, Shader model 2.0. ATI X800, NVidia 6600 or better', 'please notice your cpu!');
COMMIT;

-- ----------------------------
--  Table structure for `topic`
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `sectionId` bigint(20) DEFAULT NULL,
  `clickNum` int(11) DEFAULT NULL,
  `replyNum` int(11) DEFAULT NULL,
  `topicName` varchar(12000) DEFAULT NULL,
  `topicText` text,
  `createTime` datetime DEFAULT NULL,
  `lastReplyTime` datetime DEFAULT NULL,
  `isTop` char(2) DEFAULT NULL,
  `isFine` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `topic`
-- ----------------------------
BEGIN;
INSERT INTO `topic` VALUES ('1', '1', '1', '1', '1', '来组队', '玩饥荒的一起来组队啊！', '2017-03-06 19:50:21', '2017-03-06 19:50:36', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(120) DEFAULT NULL,
  `passwords` varchar(360) DEFAULT NULL,
  `registerTime` datetime DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `levels` int(11) DEFAULT NULL,
  `exp` int(11) DEFAULT NULL,
  `isManager` char(2) DEFAULT NULL,
  `introduce` text,
  `head` varchar(12000) DEFAULT NULL,
  `games` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '1', '1', '2017-03-06 19:47:14', '1', '1', '1', '1', 'Admin', '/users/head', '1,2'), ('3', '2', '1', '2017-03-29 21:29:04', null, null, null, '1', null, null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
