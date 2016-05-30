/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : qiyemingdan

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2016-05-30 13:53:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stu_qiandao
-- ----------------------------
DROP TABLE IF EXISTS `stu_qiandao`;
CREATE TABLE `stu_qiandao` (
  `stu_name` varchar(255) NOT NULL,
  `stu_no` varchar(20) DEFAULT NULL,
  `stu_shcoolname` varchar(255) DEFAULT NULL,
  `stu_school` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
