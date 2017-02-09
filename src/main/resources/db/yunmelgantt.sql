/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : yunmelgantt

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2017-02-09 15:34:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for biz_auth
-- ----------------------------
DROP TABLE IF EXISTS `biz_auth`;
CREATE TABLE `biz_auth` (
  `ID` varchar(40) NOT NULL COMMENT '编号id',
  `TYPE` int(2) DEFAULT NULL COMMENT '类型',
  `FLAG` varchar(100) DEFAULT NULL COMMENT '标识',
  `VALUE` varchar(255) DEFAULT NULL COMMENT '值',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  `CREATE_BY` varchar(100) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(100) DEFAULT NULL COMMENT '修改人',
  `UPDATE_DATE` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `DEL_FLAG` varchar(1) DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Table structure for plan_assignment
-- ----------------------------
DROP TABLE IF EXISTS `plan_assignment`;
CREATE TABLE `plan_assignment` (
  `id` varchar(32) NOT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `user_id` varchar(32) NOT NULL,
  `task_id` varchar(32) NOT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  `wkldone` bigint(20) DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `CREATE_BY` varchar(100) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(100) DEFAULT NULL COMMENT '修改人',
  `UPDATE_DATE` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `DEL_FLAG` varchar(1) DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for plan_role
-- ----------------------------
DROP TABLE IF EXISTS `plan_role`;
CREATE TABLE `plan_role` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `last_modifier` varchar(255) DEFAULT NULL,
  `last_modified` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(100) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(100) DEFAULT NULL COMMENT '修改人',
  `UPDATE_DATE` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `DEL_FLAG` varchar(1) DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for plan_schedule
-- ----------------------------
DROP TABLE IF EXISTS `plan_schedule`;
CREATE TABLE `plan_schedule` (
  `id` varchar(32) NOT NULL,
  `discriminator` varchar(1) NOT NULL,
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `start_time` int(11) DEFAULT NULL,
  `duration` bigint(20) DEFAULT NULL,
  `freq` int(11) DEFAULT NULL,
  `repeatx` int(11) DEFAULT NULL,
  `only_working_days` bit(1) DEFAULT NULL,
  `day_of_week` int(11) DEFAULT NULL,
  `week_of_month` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(100) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(100) DEFAULT NULL COMMENT '修改人',
  `UPDATE_DATE` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `DEL_FLAG` varchar(1) DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for plan_task
-- ----------------------------
DROP TABLE IF EXISTS `plan_task`;
CREATE TABLE `plan_task` (
  `id` varchar(32) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type_id` varchar(32) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `relevancex` int(11) DEFAULT NULL,
  `progress` double DEFAULT NULL COMMENT '工作进度',
  `tags` varchar(1024) DEFAULT NULL,
  `progress_by_worklog` bit(1) DEFAULT NULL COMMENT '根据工作记录自动计算进度',
  `total_worklog_done` bigint(20) DEFAULT NULL COMMENT '工作完成时长',
  `total_worklog_estimated` bigint(20) DEFAULT NULL,
  `total_costs_done` double DEFAULT NULL,
  `total_costs_estimated` double DEFAULT NULL,
  `total_issues` int(11) DEFAULT NULL,
  `total_issues_open` int(11) DEFAULT NULL,
  `total_issues_score_open` int(11) DEFAULT NULL,
  `total_issues_score_closed` int(11) DEFAULT NULL,
  `total_estimated_from_issues` bigint(20) DEFAULT NULL,
  `schedule` int(11) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `forum_entry` int(11) DEFAULT NULL,
  `external_code` varchar(50) DEFAULT NULL,
  `cost_center` varchar(15) DEFAULT NULL,
  `notes` varchar(2000) DEFAULT NULL,
  `order_factor` varchar(255) DEFAULT NULL,
  `start_is_milestone` bit(1) DEFAULT NULL,
  `end_is_milestone` bit(1) DEFAULT NULL,
  `forecasted` double DEFAULT NULL,
  `custom_field1` varchar(255) DEFAULT NULL,
  `custom_field2` varchar(255) DEFAULT NULL,
  `custom_field3` varchar(255) DEFAULT NULL,
  `custom_field4` varchar(255) DEFAULT NULL,
  `custom_field5` varchar(255) DEFAULT NULL,
  `custom_field6` varchar(255) DEFAULT NULL,
  `budget_custom_field1` varchar(255) DEFAULT NULL,
  `budget_custom_field2` varchar(255) DEFAULT NULL,
  `budget_custom_field3` varchar(255) DEFAULT NULL,
  `budget_custom_field4` varchar(255) DEFAULT NULL,
  `last_modified` datetime DEFAULT NULL,
  `last_modifier` varchar(255) DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `hidden` bit(1) DEFAULT NULL,
  `hidden_on` datetime DEFAULT NULL,
  `hidden_by` varchar(255) DEFAULT NULL,
  `ancestorids` varchar(255) DEFAULT NULL,
  `parent` varchar(15) DEFAULT NULL,
  `ownerx` int(11) DEFAULT NULL,
  `area` bigint(20) DEFAULT NULL,
  `inherit` bit(1) DEFAULT NULL,
  `propagate` bit(1) DEFAULT NULL,
  `json_data` text,
  `level` int(11) DEFAULT NULL COMMENT '等级',
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `CREATE_BY` varchar(100) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(100) DEFAULT NULL COMMENT '修改人',
  `UPDATE_DATE` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `DEL_FLAG` varchar(1) DEFAULT NULL COMMENT '删除标识',
  `project_id` varchar(32) DEFAULT NULL COMMENT '项目id',
  `depends` varchar(15) DEFAULT NULL COMMENT '依赖',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for plan_type
-- ----------------------------
DROP TABLE IF EXISTS `plan_type`;
CREATE TABLE `plan_type` (
  `type_id` varchar(32) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `color` varchar(10) DEFAULT NULL,
  `CREATE_BY` varchar(100) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(100) DEFAULT NULL COMMENT '修改人',
  `UPDATE_DATE` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `DEL_FLAG` varchar(1) DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for plan_user
-- ----------------------------
DROP TABLE IF EXISTS `plan_user`;
CREATE TABLE `plan_user` (
  `id` varchar(32) NOT NULL,
  `last_modified` datetime DEFAULT NULL,
  `last_modifier` varchar(255) DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `parent` varchar(15) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `my_photo` varchar(255) DEFAULT NULL,
  `notes` varchar(2000) DEFAULT NULL,
  `courtesy_title` varchar(255) DEFAULT NULL,
  `CREATE_BY` varchar(100) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(100) DEFAULT NULL COMMENT '修改人',
  `UPDATE_DATE` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `DEL_FLAG` varchar(1) DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
