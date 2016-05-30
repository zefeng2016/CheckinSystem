/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : qiyemingdan

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2016-05-30 13:53:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qiyemingdan
-- ----------------------------
DROP TABLE IF EXISTS `qiyemingdan`;
CREATE TABLE `qiyemingdan` (
  `xuhao` varchar(8) NOT NULL,
  `qiyemingcheng` varchar(255) NOT NULL,
  `qiyexinzhi` varchar(255) DEFAULT NULL,
  `xingming` varchar(255) DEFAULT NULL,
  `shouji` varchar(255) DEFAULT NULL,
  `qiandao` varchar(255) DEFAULT NULL,
  `gsjj` text,
  `quyu` varchar(255) DEFAULT NULL,
  `dizhi` varchar(255) DEFAULT NULL,
  `beizhu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`xuhao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
