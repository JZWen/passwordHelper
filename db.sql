/*
MySQL Backup
Database: passwordhelper
Backup Time: 2018-11-05 14:56:49
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `passwordhelper`.`passwordinfo`;
DROP TABLE IF EXISTS `passwordhelper`.`user`;
CREATE TABLE `passwordinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自己添加的id',
  `accountNumber` varchar(30) NOT NULL COMMENT '添加密码信息中的账号',
  `password` varchar(50) NOT NULL COMMENT '添加密码信息中的密码',
  `phoneNum` varchar(11) NOT NULL COMMENT '所属人的电话号码',
  `remark` varchar(200) NOT NULL COMMENT '自己添加的备注信息',
  `time` datetime NOT NULL COMMENT '添加或修改信息时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
CREATE TABLE `user` (
  `phoneNum` varchar(11) NOT NULL COMMENT '电话号码',
  `password` varchar(30) NOT NULL,
  `userName` varchar(20) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`phoneNum`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
BEGIN;
LOCK TABLES `passwordhelper`.`passwordinfo` WRITE;
DELETE FROM `passwordhelper`.`passwordinfo`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `passwordhelper`.`user` WRITE;
DELETE FROM `passwordhelper`.`user`;
INSERT INTO `passwordhelper`.`user` (`phoneNum`,`password`,`userName`) VALUES ('1', 'c5c3689290af05c96bcd', 'jzw'),('111', '123456', '1'),('1111', 'c5c3689290af05c96bcd', 'jzw');
UNLOCK TABLES;
COMMIT;
