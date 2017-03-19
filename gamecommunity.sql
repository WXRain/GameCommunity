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

 Date: 03/19/2017 11:58:22 AM
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `game`
-- ----------------------------
BEGIN;
INSERT INTO `game` VALUES ('1', '56MB', '2017-03-05 21:26:17', 'This is a very good game.', '15.23', '1', '1', '1.6.5', '/download/dont starve/1.6.5', '1', '/download/dont stave/1.6.5/pictures', '饥荒', '1');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `section`
-- ----------------------------
BEGIN;
INSERT INTO `section` VALUES ('1', '饥荒版面', '喜欢饥荒的玩家请来这里。', '1', '1', '2017-03-06 19:46:31', '1', '1');
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '王', '1', '2017-03-06 19:47:14', '1', '1', '1', '1', 'Admin', '/users/head', '1'), ('3', '1', '1', null, null, null, null, '1', null, null, null), ('5', '123', 'wang', null, '-1', '0', '0', '0', '', '', ''), ('6', '123456', 'wang', null, '-1', '0', '0', '0', '', '', ''), ('9', '1234568', '123', '2017-03-18 12:02:25', '-1', '0', '0', '0', '', '', '');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
