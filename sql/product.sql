/*
MySQL Data Transfer
Source Host: localhost
Source Database: product
Target Host: localhost
Target Database: product
Date: 2017/2/24 14:56:35
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for T_SYS_AUTHORITIES
-- ----------------------------
CREATE TABLE `T_SYS_AUTHORITIES` (
  `AUTHORITIES_ID` varchar(32) NOT NULL COMMENT '权限ID',
  `AUTHORITIES_NAME` varchar(64) DEFAULT NULL COMMENT '权限名称',
  `AUTHORITIES_DESC` varchar(256) DEFAULT NULL COMMENT '权限描述',
  `AUTHORITIES_ISSYS` decimal(1,0) DEFAULT NULL COMMENT '是否超级管理员 0不是1是',
  `AUTHORITIES_ENABLED` decimal(1,0) DEFAULT NULL COMMENT '是否启用0禁用1启用',
  PRIMARY KEY (`AUTHORITIES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限';

-- ----------------------------
-- Table structure for T_SYS_AUTHORITIES_RESOURCES
-- ----------------------------
CREATE TABLE `T_SYS_AUTHORITIES_RESOURCES` (
  `AUTHORITIES_RESOURCES_ID` varchar(32) NOT NULL,
  `AUTHORITIES_ID` varchar(32) DEFAULT NULL,
  `AUTHORITY_RESOURCES_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`AUTHORITIES_RESOURCES_ID`),
  KEY `FK_Reference_5` (`AUTHORITIES_ID`),
  KEY `FK_Reference_6` (`AUTHORITY_RESOURCES_ID`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`AUTHORITIES_ID`) REFERENCES `sys_authorities` (`AUTHORITIES_ID`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`AUTHORITY_RESOURCES_ID`) REFERENCES `sys_authority_resources` (`AUTHORITY_RESOURCES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_authority_resources
-- ----------------------------
CREATE TABLE `T_SYS_AUTHORITY_RESOURCES` (
  `AUTHORITY_RESOURCES_ID` varchar(32) NOT NULL COMMENT '资源ID',
  `AUTHORITY_RESOURCES_NAME` varchar(64) DEFAULT NULL COMMENT '资源名称',
  `AUTHORITY_RESOURCES_DESC` varchar(256) DEFAULT NULL COMMENT '资源描述',
  `AUTHORITY_RESOURCES_TYPE` varchar(2) DEFAULT NULL COMMENT '资源类型',
  `AUTHORITY_RESOURCES_SORT` int(11) DEFAULT NULL COMMENT '资源排序',
  `AUTHORITY_RESOURCES_URL` varchar(128) DEFAULT NULL COMMENT '资源URL',
  `AUTHORITY_RESOURCES_ISSYS` decimal(1,0) DEFAULT NULL COMMENT '是否超级管理员 0不是1是',
  `AUTHORITY_RESOURCES_ENABLED` decimal(1,0) DEFAULT NULL COMMENT '是否启用0禁用1启用',
  PRIMARY KEY (`AUTHORITY_RESOURCES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源';

-- ----------------------------
-- Table structure for T_SYS_AUTHORITY_ROLES
-- ----------------------------
CREATE TABLE `T_SYS_AUTHORITY_ROLES` (
  `AUTHORITY_ROLES_ID` varchar(32) NOT NULL COMMENT '角色id',
  `AUTHORITY_ROLES_NAME` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `AUTHORITY_ROLES_DESC` varchar(256) DEFAULT NULL COMMENT '角色描述',
  `AUTHORITY_ROLES_ISSYS` decimal(1,0) DEFAULT NULL COMMENT '是否超级管理员 0不是1是',
  `AUTHORITY_ROLES_ENABLED` decimal(1,0) DEFAULT NULL COMMENT '是否启用0禁用1启用',
  PRIMARY KEY (`AUTHORITY_ROLES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for T_SYS_AUTHORITY_ROLES_AUTHORITIES
-- ----------------------------
CREATE TABLE `T_SYS_AUTHORITY_ROLES_AUTHORITIES` (
  `AUTHORITY_ROLES_AUTHORITIES_ID` varchar(32) NOT NULL,
  `AUTHORITY_ROLES_ID` varchar(32) DEFAULT NULL,
  `AUTHORITIES_ID` varchar(32) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`AUTHORITY_ROLES_AUTHORITIES_ID`),
  KEY `FK_Reference_3` (`AUTHORITY_ROLES_ID`),
  KEY `FK_Reference_4` (`AUTHORITIES_ID`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`AUTHORITY_ROLES_ID`) REFERENCES `sys_authority_roles` (`AUTHORITY_ROLES_ID`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`AUTHORITIES_ID`) REFERENCES `sys_authorities` (`AUTHORITIES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for T_SYS_AUTHORITY_USER
-- ----------------------------
CREATE TABLE `T_SYS_AUTHORITY_USER` (
  `AUTHORITY_USER_ID` varchar(32) NOT NULL COMMENT '主健',
  `AUTHORITY_USER_ACCOUNT` varchar(32) DEFAULT NULL COMMENT '账号',
  `AUTHORITY_USER_NAME` varchar(64) DEFAULT NULL COMMENT '名称',
  `AUTHORITY_USER_PASSWORD` varchar(64) DEFAULT NULL COMMENT '密码',
  `AUTHORITY_USER_DESC` varchar(256) DEFAULT NULL COMMENT '描述',
  `AUTHORITY_USER_ISSYS` decimal(1,0) DEFAULT NULL COMMENT '是否超级管理员0不是 1是',
  `AUTHOORITY_USER_ENABLED` decimal(1,0) DEFAULT NULL COMMENT '是否被禁用0禁用 1启用',
  PRIMARY KEY (`AUTHORITY_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Table structure for T_SYS_AUTHORITY_USER_ROLE
-- ----------------------------
CREATE TABLE `T_SYS_AUTHORITY_USER_ROLE` (
  `AUTHORITY_USER_ROLE_ID` varchar(32) NOT NULL,
  `AUTHORITY_USER_ID` varchar(32) DEFAULT NULL,
  `AUTHORITY_ROLES_ID` varchar(32) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`AUTHORITY_USER_ROLE_ID`),
  KEY `FK_Reference_1` (`AUTHORITY_USER_ID`),
  KEY `FK_Reference_2` (`AUTHORITY_ROLES_ID`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`AUTHORITY_USER_ID`) REFERENCES `sys_authority_user` (`AUTHORITY_USER_ID`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`AUTHORITY_ROLES_ID`) REFERENCES `sys_authority_roles` (`AUTHORITY_ROLES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Table structure for t_biz_code
-- ----------------------------
CREATE TABLE `T_BIZ_CODE` (
  `ID` varchar(32) NOT NULL COMMENT '主健',
  `CID` varchar(32) NOT NULL COMMENT '',
  `NAME` varchar(50) DEFAULT NULL COMMENT '',
  `KEYWORD` varchar(50) DEFAULT NULL COMMENT '',
  `TYPE` varchar(50) DEFAULT NULL COMMENT '',
  `DETAIL` varchar(256) DEFAULT NULL COMMENT '',
  `USED` varchar(1) DEFAULT NULL COMMENT '',
  PRIMARY KEY (`ID`),
  KEY `FK_BIZ_CODE_R_CODE_CATALOG` (`CID`),
  CONSTRAINT `FK_BIZ_CODE_R_CODE_CATALOG` FOREIGN KEY (`CID`) REFERENCES `t_biz_code_catalog` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_biz_code_catalog
-- ----------------------------
CREATE TABLE `T_BIZ_CODE_CATALOG` (
  `ID` varchar(32) NOT NULL COMMENT '主健',
  `NAME` varchar(50) DEFAULT NULL COMMENT '',
  `DETAIL` varchar(256) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_biz_code_item
-- ----------------------------
CREATE TABLE `T_BIZ_CODE_ITEM` (
  `ID` varchar(32) NOT NULL COMMENT '主健',
  `BUSICODEID` varchar(32) NOT NULL COMMENT '',
  `PID` varchar(32) DEFAULT NULL COMMENT '',
  `NAME` varchar(256) DEFAULT NULL COMMENT '',
  `VALUE` varchar(50) DEFAULT NULL COMMENT '',
  `POS` varchar(50) DEFAULT NULL COMMENT '',
  `DETAIL` varchar(256) DEFAULT NULL COMMENT '',
  `SELECT_CODE` varchar(128) DEFAULT NULL,
  `VIEW_TYPE` varchar(128) DEFAULT NULL,
  `DATA_TYPE` varchar(128) DEFAULT NULL,
  `USED` varchar(1) DEFAULT NULL COMMENT '',
  PRIMARY KEY (`ID`),
  KEY `FK_BIZ_CODE_ITEM_R_BIZ_CODE` (`BUSICODEID`),
  KEY `FK_BIZ_CODE_R_BIZ_CODE_ITEM` (`PID`),
  CONSTRAINT `FK_BIZ_CODE_ITEM_R_BIZ_CODE` FOREIGN KEY (`BUSICODEID`) REFERENCES `t_biz_code` (`ID`),
  CONSTRAINT `FK_BIZ_CODE_R_BIZ_CODE_ITEM` FOREIGN KEY (`PID`) REFERENCES `t_biz_code_item` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_code
-- ----------------------------
CREATE TABLE `T_CODE` (
  `CODE_ID` varchar(32) NOT NULL,
  `B_CODE` varchar(64) NOT NULL,
  `CODE_NUM` varchar(32) DEFAULT NULL,
  `SORT_NUM` int(11) DEFAULT NULL,
  `CODE_SORT_NUM` varchar(32) DEFAULT NULL,
  `STATUS` varchar(1) DEFAULT NULL,
  `CODE_FIRST` varchar(32) DEFAULT NULL,
  `CODE_SECOND` varchar(32) DEFAULT NULL,
  `CODE_THREE` varchar(32) DEFAULT NULL,
  `CODE_FOUR` varchar(32) DEFAULT NULL,
  `CODE_FIVE` varchar(32) DEFAULT NULL,
  `CODE_SIX` varchar(32) DEFAULT NULL,
  `CREATETIMESTAMP` timestamp NULL DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `CREATEDATE` date DEFAULT NULL,
  PRIMARY KEY (`CODE_ID`,`B_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
