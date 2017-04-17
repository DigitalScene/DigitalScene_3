/*
Navicat MySQL Data Transfer

Source Server         : JAVAMySQL
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : digitalscene

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-03-22 18:22:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ds_dataintegration
-- ----------------------------
DROP TABLE IF EXISTS `ds_dataintegration`;
CREATE TABLE `ds_dataintegration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataIntegrationFinishDate` datetime DEFAULT NULL,
  `dataIntegrationPeople` varchar(255) DEFAULT NULL,
  `dataIntegrationPeople_reason` varchar(255) DEFAULT NULL,
  `dataIntegrationToAppointDate` datetime DEFAULT NULL,
  `dataIntegrationToAppointPeople` varchar(255) DEFAULT NULL,
  `is_dataIntegrationPeople` int(11) DEFAULT NULL,
  `is_dataIntegrationPeopleDate` datetime DEFAULT NULL,
  `dataIntegrationCheckDate` datetime DEFAULT NULL,
  `dataIntegrationToCheckPeople` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_dataintegration
-- ----------------------------
INSERT INTO `ds_dataintegration` VALUES ('6', '2017-03-17 20:28:52', 'user2(小黑2)', '不想干活', '2017-03-17 20:28:36', 'admin(小白)', '1', null, '2017-03-17 20:29:00', 'admin(小白)');
INSERT INTO `ds_dataintegration` VALUES ('7', '2017-03-22 18:18:13', 'admin(小白)', '', '2017-03-22 18:16:28', 'admin(小白)', '1', null, '2017-03-22 18:19:39', 'admin(小白)');

-- ----------------------------
-- Table structure for ds_dataupload
-- ----------------------------
DROP TABLE IF EXISTS `ds_dataupload`;
CREATE TABLE `ds_dataupload` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataUploadFinishDate` datetime DEFAULT NULL,
  `dataUploadPeople` varchar(255) DEFAULT NULL,
  `dataUploadPeople_reason` varchar(255) DEFAULT NULL,
  `dataUploadToAppointDate` datetime DEFAULT NULL,
  `dataUploadToAppointPeople` varchar(255) DEFAULT NULL,
  `is_dataUploadPeople` int(11) DEFAULT NULL,
  `dataUploadCheckDate` datetime DEFAULT NULL,
  `dataUploadToCheckPeople` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_dataupload
-- ----------------------------
INSERT INTO `ds_dataupload` VALUES ('6', '2017-03-16 15:16:37', 'user2(小黑2)', '', '2017-03-15 20:53:51', 'admin(小白)', '1', '2017-03-16 15:22:45', 'admin(小白)');
INSERT INTO `ds_dataupload` VALUES ('7', '2017-03-22 18:11:44', 'user1(小黑)', '', '2017-03-20 19:39:44', 'admin(小白)', '1', '2017-03-22 18:12:37', 'admin(小白)');

-- ----------------------------
-- Table structure for ds_mp3edit
-- ----------------------------
DROP TABLE IF EXISTS `ds_mp3edit`;
CREATE TABLE `ds_mp3edit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_mp3EditPeople` int(11) DEFAULT NULL,
  `is_mp3EditPeopleDate` datetime DEFAULT NULL,
  `mp3EditFinishDate` datetime DEFAULT NULL,
  `mp3EditPeople` varchar(255) DEFAULT NULL,
  `mp3EditPeople_reason` varchar(255) DEFAULT NULL,
  `mp3EditToAppointDate` datetime DEFAULT NULL,
  `mp3EditToAppointPeople` varchar(255) DEFAULT NULL,
  `mp3EditCheckDate` datetime DEFAULT NULL,
  `mp3EditToCheckPeople` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_mp3edit
-- ----------------------------
INSERT INTO `ds_mp3edit` VALUES ('8', '1', null, '2017-03-22 17:00:12', 'admin(小白)', '不想干活', '2017-03-22 16:54:03', 'admin(小白)', '2017-03-22 17:59:06', 'admin(小白)');

-- ----------------------------
-- Table structure for ds_photoedit
-- ----------------------------
DROP TABLE IF EXISTS `ds_photoedit`;
CREATE TABLE `ds_photoedit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_photoEditPeople` int(11) DEFAULT NULL,
  `is_photoEditPeopleDate` datetime DEFAULT NULL,
  `photoEditFinishDate` datetime DEFAULT NULL,
  `photoEditPeople` varchar(255) DEFAULT NULL,
  `photoEditPeople_reason` varchar(255) DEFAULT NULL,
  `photoEditToAppointDate` datetime DEFAULT NULL,
  `photoEditToAppointPeople` varchar(255) DEFAULT NULL,
  `photoEditCheckDate` datetime DEFAULT NULL,
  `photoEditToCheckPeople` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_photoedit
-- ----------------------------
INSERT INTO `ds_photoedit` VALUES ('6', '1', null, '2017-03-16 18:17:22', 'user1(小黑)', '不想干活', '2017-03-16 18:17:06', 'admin(小白)', '2017-03-16 18:25:18', 'admin(小白)');
INSERT INTO `ds_photoedit` VALUES ('7', '1', null, '2017-03-22 18:13:36', 'admin(小白)', '', '2017-03-22 18:13:02', 'admin(小白)', '2017-03-22 18:13:46', 'admin(小白)');

-- ----------------------------
-- Table structure for ds_photomade
-- ----------------------------
DROP TABLE IF EXISTS `ds_photomade`;
CREATE TABLE `ds_photomade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_photoMadePeople` int(11) DEFAULT NULL,
  `is_photoMadePeopleDate` datetime DEFAULT NULL,
  `photoMadeFinishDate` datetime DEFAULT NULL,
  `photoMadePeople` varchar(255) DEFAULT NULL,
  `photoMadePeople_reason` varchar(255) DEFAULT NULL,
  `photoMadeToAppointDate` datetime DEFAULT NULL,
  `photoMadeToAppointPeople` varchar(255) DEFAULT NULL,
  `photoMadeCheckDate` datetime DEFAULT NULL,
  `photoMadeToCheckPeople` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_photomade
-- ----------------------------
INSERT INTO `ds_photomade` VALUES ('6', '1', null, '2017-03-16 23:18:01', 'user2(小黑2)', '不想干活', '2017-03-16 23:17:54', 'admin(小白)', '2017-03-16 23:18:05', 'admin(小白)');
INSERT INTO `ds_photomade` VALUES ('7', '1', null, '2017-03-22 18:14:40', 'admin(小白)', '', '2017-03-22 18:13:57', 'admin(小白)', '2017-03-22 18:15:05', 'admin(小白)');

-- ----------------------------
-- Table structure for ds_project
-- ----------------------------
DROP TABLE IF EXISTS `ds_project`;
CREATE TABLE `ds_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `isDel` int(11) DEFAULT NULL,
  `is_dataIntegrationStatus` int(11) DEFAULT NULL,
  `is_dataUploadStatus` int(11) DEFAULT NULL,
  `is_mp3EditStatus` int(11) DEFAULT NULL,
  `is_photoEditStatus` int(11) DEFAULT NULL,
  `is_photoMadeStatus` int(11) DEFAULT NULL,
  `is_sceneMadeStatus` int(11) DEFAULT NULL,
  `is_subtitleEditStatus` int(11) DEFAULT NULL,
  `is_thrDModelMadeStatus` int(11) DEFAULT NULL,
  `is_videoEditStatus` int(11) DEFAULT NULL,
  `projectName` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `dataintegration_id` int(11) DEFAULT NULL,
  `dataupload_id` int(11) DEFAULT NULL,
  `mp3edit_id` int(11) DEFAULT NULL,
  `photoedit_id` int(11) DEFAULT NULL,
  `photomade_id` int(11) DEFAULT NULL,
  `scenemade_id` int(11) DEFAULT NULL,
  `subtitleedit_id` int(11) DEFAULT NULL,
  `thrdmodelmade_id` int(11) DEFAULT NULL,
  `videoedit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3ju7j0ltbu3leb2nrkrcu7bxs` (`dataintegration_id`),
  KEY `FK_k19tn6tqifns9caghhdyg32fd` (`dataupload_id`),
  KEY `FK_o2cow72jl9efeps1awsj8sglp` (`mp3edit_id`),
  KEY `FK_nm3203llp6ylhaerbcnlr7tl` (`photoedit_id`),
  KEY `FK_eupj8k5ufmktxbd28h1ahmaw6` (`photomade_id`),
  KEY `FK_hlfvla1pl848o626yaooa6lvw` (`scenemade_id`),
  KEY `FK_df175aa62moig1s5y4mj446pe` (`subtitleedit_id`),
  KEY `FK_prh0fcklpq3clk467bcs75hdy` (`thrdmodelmade_id`),
  KEY `FK_i20ssa88gygop0kl5mi5nr2n2` (`videoedit_id`),
  CONSTRAINT `FK_3ju7j0ltbu3leb2nrkrcu7bxs` FOREIGN KEY (`dataintegration_id`) REFERENCES `ds_dataintegration` (`id`),
  CONSTRAINT `FK_df175aa62moig1s5y4mj446pe` FOREIGN KEY (`subtitleedit_id`) REFERENCES `ds_subtitleedit` (`id`),
  CONSTRAINT `FK_eupj8k5ufmktxbd28h1ahmaw6` FOREIGN KEY (`photomade_id`) REFERENCES `ds_photomade` (`id`),
  CONSTRAINT `FK_hlfvla1pl848o626yaooa6lvw` FOREIGN KEY (`scenemade_id`) REFERENCES `ds_scenemade` (`id`),
  CONSTRAINT `FK_i20ssa88gygop0kl5mi5nr2n2` FOREIGN KEY (`videoedit_id`) REFERENCES `ds_videoedit` (`id`),
  CONSTRAINT `FK_k19tn6tqifns9caghhdyg32fd` FOREIGN KEY (`dataupload_id`) REFERENCES `ds_dataupload` (`id`),
  CONSTRAINT `FK_nm3203llp6ylhaerbcnlr7tl` FOREIGN KEY (`photoedit_id`) REFERENCES `ds_photoedit` (`id`),
  CONSTRAINT `FK_o2cow72jl9efeps1awsj8sglp` FOREIGN KEY (`mp3edit_id`) REFERENCES `ds_mp3edit` (`id`),
  CONSTRAINT `FK_prh0fcklpq3clk467bcs75hdy` FOREIGN KEY (`thrdmodelmade_id`) REFERENCES `ds_thrdmodelmade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_project
-- ----------------------------
INSERT INTO `ds_project` VALUES ('5', '2017-03-15 20:35:12', '杨圣陶', '好艺术馆', '0', '5', '5', '5', '5', '5', '5', '6', '6', '5', '武汉理工艺术馆', '5', '6', '6', '8', '6', '6', '6', null, null, '6');
INSERT INTO `ds_project` VALUES ('6', '2017-03-17 19:51:18', '杨小白', '好学校', '0', '5', '5', '6', '5', '5', '5', '5', '5', '6', '武汉理工西苑', '5', '7', '7', null, '7', '7', '7', '1', '1', null);

-- ----------------------------
-- Table structure for ds_role
-- ----------------------------
DROP TABLE IF EXISTS `ds_role`;
CREATE TABLE `ds_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_73w5titujsc77snshrgv5y88e` (`user_id`),
  CONSTRAINT `FK_73w5titujsc77snshrgv5y88e` FOREIGN KEY (`user_id`) REFERENCES `ds_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_role
-- ----------------------------
INSERT INTO `ds_role` VALUES ('39', 'user', '9');
INSERT INTO `ds_role` VALUES ('45', 'admin', '10');
INSERT INTO `ds_role` VALUES ('52', 'admin', '11');
INSERT INTO `ds_role` VALUES ('53', 'user', '11');

-- ----------------------------
-- Table structure for ds_scenemade
-- ----------------------------
DROP TABLE IF EXISTS `ds_scenemade`;
CREATE TABLE `ds_scenemade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_sceneMadePeople` int(11) DEFAULT NULL,
  `is_sceneMadePeopleDate` datetime DEFAULT NULL,
  `sceneMadeFinishDate` datetime DEFAULT NULL,
  `sceneMadePeople` varchar(255) DEFAULT NULL,
  `sceneMadePeople_reason` varchar(255) DEFAULT NULL,
  `sceneMadeToAppointDate` datetime DEFAULT NULL,
  `sceneMadeToAppointPeople` varchar(255) DEFAULT NULL,
  `sceneMadeCheckDate` datetime DEFAULT NULL,
  `sceneMadeToCheckPeople` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_scenemade
-- ----------------------------
INSERT INTO `ds_scenemade` VALUES ('6', '1', null, '2017-03-17 18:32:32', 'user1(小黑)', '不想干活', '2017-03-17 18:32:23', 'admin(小白)', '2017-03-17 18:32:39', 'admin(小白)');
INSERT INTO `ds_scenemade` VALUES ('7', '1', null, '2017-03-22 18:16:07', 'admin(小白)', '', '2017-03-22 18:15:13', 'admin(小白)', '2017-03-22 18:16:19', 'admin(小白)');

-- ----------------------------
-- Table structure for ds_subtitleedit
-- ----------------------------
DROP TABLE IF EXISTS `ds_subtitleedit`;
CREATE TABLE `ds_subtitleedit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_subtitleEditPeople` int(11) DEFAULT NULL,
  `is_subtitleEditPeopleDate` datetime DEFAULT NULL,
  `subtitleEditFinishDate` datetime DEFAULT NULL,
  `subtitleEditPeople` varchar(255) DEFAULT NULL,
  `subtitleEditPeople_reason` varchar(255) DEFAULT NULL,
  `subtitleEditToAppointDate` datetime DEFAULT NULL,
  `subtitleEditToAppointPeople` varchar(255) DEFAULT NULL,
  `subtitleEditCheckDate` datetime DEFAULT NULL,
  `subtitleEditToCheckPeople` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_subtitleedit
-- ----------------------------
INSERT INTO `ds_subtitleedit` VALUES ('1', '1', null, '2017-03-22 16:51:46', 'admin(小白)', '不想干活', '2017-03-21 13:40:36', 'admin(小白)', '2017-03-22 17:59:19', 'admin(小白)');

-- ----------------------------
-- Table structure for ds_thrdmodelmade
-- ----------------------------
DROP TABLE IF EXISTS `ds_thrdmodelmade`;
CREATE TABLE `ds_thrdmodelmade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_thrDModelMadePeople` int(11) DEFAULT NULL,
  `is_thrDModelMadePeopleDate` datetime DEFAULT NULL,
  `thrDModelMadeFinishDate` datetime DEFAULT NULL,
  `thrDModelMadePeople` varchar(255) DEFAULT NULL,
  `thrDModelMadePeople_reason` varchar(255) DEFAULT NULL,
  `thrDModelMadeToAppointDate` datetime DEFAULT NULL,
  `thrDModelMadeToAppointPeople` varchar(255) DEFAULT NULL,
  `thrDModelMadeCheckDate` datetime DEFAULT NULL,
  `thrDModelMadeToCheckPeople` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_thrdmodelmade
-- ----------------------------
INSERT INTO `ds_thrdmodelmade` VALUES ('1', '1', null, '2017-03-22 16:53:42', 'admin(小白)', '不想干活', '2017-03-22 16:52:23', 'admin(小白)', '2017-03-22 17:59:16', 'admin(小白)');

-- ----------------------------
-- Table structure for ds_uploadfile
-- ----------------------------
DROP TABLE IF EXISTS `ds_uploadfile`;
CREATE TABLE `ds_uploadfile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(255) DEFAULT NULL,
  `moduleId` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_uploadfile
-- ----------------------------
INSERT INTO `ds_uploadfile` VALUES ('1', 'piano.zip', 'subtitleEditId_1', 'uploads/subtitleEdit/20170322142830/71916c4f078844cf936f952f6df0556e.zip');
INSERT INTO `ds_uploadfile` VALUES ('9', 'piano.zip', 'subtitleEditId_1', 'uploads/subtitleEdit/20170322155216/9b61484df5cc4c7495d7b81d66b6f8bf.zip');
INSERT INTO `ds_uploadfile` VALUES ('10', 'piano.zip', 'subtitleEditId_1', 'uploads/subtitleEdit/20170322165100/d4097f25745d4d1a867fee3ea6e97370.zip');
INSERT INTO `ds_uploadfile` VALUES ('11', 'piano.zip', 'thrDModelMadeId_1', 'uploads/thrDModelMade/20170322165245/fa6a7be61f3047e0870094d9388a724f.zip');
INSERT INTO `ds_uploadfile` VALUES ('13', 'piano.zip', 'thrDModelMadeId_1', 'uploads/thrDModelMade/20170322165315/f51ed6b2f1f74735a0a78f4cc4be4e32.zip');
INSERT INTO `ds_uploadfile` VALUES ('14', 'piano.zip', 'mp3EditId_8', 'uploads/mp3Edit/20170322165920/b632c88858ed46e897b466ac143222ac.zip');
INSERT INTO `ds_uploadfile` VALUES ('15', 'piano.zip', 'mp3EditId_8', 'uploads/mp3Edit/20170322165930/442d7582cf7447d295248bbb5aa84a75.zip');
INSERT INTO `ds_uploadfile` VALUES ('16', 'piano.zip', 'mp3EditId_8', 'uploads/mp3Edit/20170322165946/6bd214d7fcad4937a6649f515174ac80.zip');
INSERT INTO `ds_uploadfile` VALUES ('17', 'piano.zip', 'videoEditId_6', 'uploads/videoEdit/20170322170022/fb5f88dd704c484ca417e423765496b6.zip');
INSERT INTO `ds_uploadfile` VALUES ('18', 'piano.zip', 'videoEditId_6', 'uploads/videoEdit/20170322170036/67205e139d9749fa8014a79e4855a14a.zip');
INSERT INTO `ds_uploadfile` VALUES ('19', 'piano.zip', 'dataUploadId_7', 'uploads/dataUpload/20170322181128/568bbf5cd8e843919764eeb336785573.zip');
INSERT INTO `ds_uploadfile` VALUES ('20', 'piano.zip', 'dataUploadId_7', 'uploads/dataUpload/20170322181135/08838d103a4649498e9d0f7a552689e3.zip');
INSERT INTO `ds_uploadfile` VALUES ('21', 'piano.zip', 'photoEditId_7', 'uploads/photoEdit/20170322181329/af8ea983e17b48338b44feed270697ed.zip');
INSERT INTO `ds_uploadfile` VALUES ('22', 'piano.zip', 'photoMadeId_7', 'uploads/photoMade/20170322181429/6941d081f46f4bbbaa2a03876bfad109.zip');
INSERT INTO `ds_uploadfile` VALUES ('23', 'piano.zip', 'sceneMadeId_7', 'uploads/sceneMade/20170322181559/10e46d811a6a47a5a02014c4b450088a.zip');
INSERT INTO `ds_uploadfile` VALUES ('24', 'piano.zip', 'dataIntegrationId_7', 'uploads/dataIntegration/20170322181654/801fa7bc9a814b6e9a84c0afea0e9e26.zip');
INSERT INTO `ds_uploadfile` VALUES ('25', 'piano.zip', 'dataIntegrationId_7', 'uploads/dataIntegration/20170322181726/b05dc8fdcdc9426abaaf5b404555bcdf.zip');

-- ----------------------------
-- Table structure for ds_user
-- ----------------------------
DROP TABLE IF EXISTS `ds_user`;
CREATE TABLE `ds_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `isDel` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_user
-- ----------------------------
INSERT INTO `ds_user` VALUES ('9', '小黑', 'E10ADC3949BA59ABBE56E057F20F883E', '0', 'user1', '0');
INSERT INTO `ds_user` VALUES ('10', '小黑2', 'E10ADC3949BA59ABBE56E057F20F883E', '0', 'user2', '0');
INSERT INTO `ds_user` VALUES ('11', '小白', 'E10ADC3949BA59ABBE56E057F20F883E', '0', 'admin', '0');
INSERT INTO `ds_user` VALUES ('12', '你好', 'E10ADC3949BA59ABBE56E057F20F883E', '0', 'hello', '0');

-- ----------------------------
-- Table structure for ds_videoedit
-- ----------------------------
DROP TABLE IF EXISTS `ds_videoedit`;
CREATE TABLE `ds_videoedit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_videoEditPeople` int(11) DEFAULT NULL,
  `is_videoEditPeopleDate` datetime DEFAULT NULL,
  `mp3EditToAppointDate` datetime DEFAULT NULL,
  `mp3EditToAppointPeople` varchar(255) DEFAULT NULL,
  `videoEditFinishDate` datetime DEFAULT NULL,
  `videoEditPeople` varchar(255) DEFAULT NULL,
  `videoEditPeople_reason` varchar(255) DEFAULT NULL,
  `videoEditCheckDate` datetime DEFAULT NULL,
  `videoEditToAppointDate` datetime DEFAULT NULL,
  `videoEditToAppointPeople` varchar(255) DEFAULT NULL,
  `videoEditToCheckPeople` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ds_videoedit
-- ----------------------------
INSERT INTO `ds_videoedit` VALUES ('6', '1', null, null, '', '2017-03-22 17:00:55', 'admin(小白)', '不想干活', '2017-03-22 17:59:12', '2017-03-22 16:54:09', 'admin(小白)', 'admin(小白)');
