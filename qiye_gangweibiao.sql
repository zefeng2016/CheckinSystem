/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : qiyemingdan

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2016-05-30 13:53:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qiye_gangweibiao
-- ----------------------------
DROP TABLE IF EXISTS `qiye_gangweibiao`;
CREATE TABLE `qiye_gangweibiao` (
  `zhujian` int(11) NOT NULL,
  `tangwei` varchar(255) DEFAULT NULL,
  `qiye_gangwei` varchar(255) DEFAULT NULL,
  `qiye_gongzhi` varchar(255) DEFAULT NULL,
  `qiye_gongzuoxinzhi` varchar(255) DEFAULT NULL,
  `qiye_gongzuodizhi` varchar(255) DEFAULT NULL,
  `qiye_gongzuoneirong` text,
  `qiye_gongzuoquyu` varchar(255) DEFAULT NULL,
  `qiye_zhaopingrenshu` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`zhujian`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
