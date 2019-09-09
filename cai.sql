/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : cai

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 22/05/2019 15:59:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for achievement
-- ----------------------------
DROP TABLE IF EXISTS `achievement`;
CREATE TABLE `achievement`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examID` int(11) NULL DEFAULT NULL,
  `studentID` int(11) NULL DEFAULT NULL,
  `score1` double(11, 0) NULL DEFAULT NULL,
  `score2` double(11, 0) NULL DEFAULT NULL,
  `score3` double(11, 0) NULL DEFAULT NULL,
  `score4` double(11, 0) NULL DEFAULT NULL,
  `score5` double(11, 0) NULL DEFAULT NULL,
  `total` double(11, 0) NULL DEFAULT NULL,
  `classesID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_examID_achievement`(`examID`) USING BTREE,
  INDEX `fk_studentID_achievement`(`studentID`) USING BTREE,
  INDEX `fk_classesID_achievement`(`classesID`) USING BTREE,
  CONSTRAINT `fk_classesID_achievement` FOREIGN KEY (`classesID`) REFERENCES `classes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_examID_achievement` FOREIGN KEY (`examID`) REFERENCES `exam` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_studentID_achievement` FOREIGN KEY (`studentID`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of achievement
-- ----------------------------
INSERT INTO `achievement` VALUES (1, 1, 5, 0, 1, 0, 0, 0, 1, 1);
INSERT INTO `achievement` VALUES (2, 1, 6, 0, 0, 0, 0, 0, 0, 1);

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'cdbadec63804299672f2ff620b95b0c7');

-- ----------------------------
-- Table structure for assignment
-- ----------------------------
DROP TABLE IF EXISTS `assignment`;
CREATE TABLE `assignment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createtime` datetime NULL DEFAULT NULL,
  `fileName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `week` int(4) NULL DEFAULT NULL,
  `classesID` int(11) NULL DEFAULT NULL,
  `studentID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_classesID_assignment`(`classesID`) USING BTREE,
  INDEX `fk_studentID_assignment`(`studentID`) USING BTREE,
  CONSTRAINT `fk_classesID_assignment` FOREIGN KEY (`classesID`) REFERENCES `classes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_studentID_assignment` FOREIGN KEY (`studentID`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of assignment
-- ----------------------------
INSERT INTO `assignment` VALUES (1, '2019-05-18 00:20:49', '(日期20190518002049+7926121)第一行代码 Android 第2版-郭霖.pdf', '20', 1, 1, 5);

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `week` int(11) NULL DEFAULT NULL,
  `classesID` int(11) NULL DEFAULT NULL,
  `studentID` int(11) NULL DEFAULT NULL,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_studentID_attendance`(`studentID`) USING BTREE,
  INDEX `fk_classesID_attendance`(`classesID`) USING BTREE,
  CONSTRAINT `fk_classesID_attendance` FOREIGN KEY (`classesID`) REFERENCES `classes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_studentID_attendance` FOREIGN KEY (`studentID`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courseID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_courseID_chapter`(`courseID`) USING BTREE,
  CONSTRAINT `fk_courseID_chapter` FOREIGN KEY (`courseID`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES (1, '计算机基础', 1);

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courseID` int(11) NULL DEFAULT NULL,
  `collegeID` int(11) NULL DEFAULT NULL,
  `teacherID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_courseID_classes`(`courseID`) USING BTREE,
  INDEX `fk_collegeID_classes`(`collegeID`) USING BTREE,
  INDEX `fk_teacherID_classes`(`teacherID`) USING BTREE,
  CONSTRAINT `fk_collegeID_classes` FOREIGN KEY (`collegeID`) REFERENCES `college` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_courseID_classes` FOREIGN KEY (`courseID`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_teacherID_classes` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1, '16计算机基础(黄蔚)', 1, 2, 2);
INSERT INTO `classes` VALUES (2, '16计算机基础', 1, 3, 2);

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES (2, '东吴商学院');
INSERT INTO `college` VALUES (3, '计算机学院');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `collegeID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_collegeID_course`(`collegeID`) USING BTREE,
  CONSTRAINT `fk_collegeID_course` FOREIGN KEY (`collegeID`) REFERENCES `college` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '计算机基础', 3);
INSERT INTO `course` VALUES (2, '微观经济学', 2);
INSERT INTO `course` VALUES (3, 'python', 3);

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseID` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score1` double(11, 0) NULL DEFAULT NULL,
  `score2` double(11, 0) NULL DEFAULT NULL,
  `score3` double(11, 0) NULL DEFAULT NULL,
  `score4` double(11, 0) NULL DEFAULT NULL,
  `score5` double(11, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_courseID_exam`(`courseID`) USING BTREE,
  CONSTRAINT `fk_courseID_exam` FOREIGN KEY (`courseID`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES (1, 1, '16计算机基础考试', 1, 1, 1, 1, 1);
INSERT INTO `exam` VALUES (2, 1, '16计算机基础考试2', 2, 2, 2, 2, 2);

-- ----------------------------
-- Table structure for examcontent
-- ----------------------------
DROP TABLE IF EXISTS `examcontent`;
CREATE TABLE `examcontent`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examID` int(11) NULL DEFAULT NULL,
  `problemID` int(11) NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_examID_examcontent`(`examID`) USING BTREE,
  INDEX `fk_problemID_examcontent`(`problemID`) USING BTREE,
  CONSTRAINT `fk_examID_examcontent` FOREIGN KEY (`examID`) REFERENCES `exam` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_problemID_examcontent` FOREIGN KEY (`problemID`) REFERENCES `problem` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of examcontent
-- ----------------------------
INSERT INTO `examcontent` VALUES (1, 1, 2, 1);
INSERT INTO `examcontent` VALUES (2, 1, 3, 2);
INSERT INTO `examcontent` VALUES (3, 1, 4, 4);
INSERT INTO `examcontent` VALUES (4, 1, 5, 5);
INSERT INTO `examcontent` VALUES (5, 2, 2, 1);
INSERT INTO `examcontent` VALUES (6, 2, 3, 2);

-- ----------------------------
-- Table structure for examstudent
-- ----------------------------
DROP TABLE IF EXISTS `examstudent`;
CREATE TABLE `examstudent`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examID` int(11) NULL DEFAULT NULL,
  `studentID` int(11) NULL DEFAULT NULL,
  `joinexam` int(4) NULL DEFAULT NULL,
  `inquiry` int(4) NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT NULL,
  `duration` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deadtime` datetime NULL DEFAULT NULL,
  `classesID` int(11) NULL DEFAULT NULL,
  `type` int(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_examID_examstudent`(`examID`) USING BTREE,
  INDEX `fk_studentID_examstudent`(`studentID`) USING BTREE,
  INDEX `fk_classesID_examstudent`(`classesID`) USING BTREE,
  CONSTRAINT `fk_classesID_examstudent` FOREIGN KEY (`classesID`) REFERENCES `classes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_examID_examstudent` FOREIGN KEY (`examID`) REFERENCES `exam` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_studentID_examstudent` FOREIGN KEY (`studentID`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of examstudent
-- ----------------------------
INSERT INTO `examstudent` VALUES (1, 1, 5, 1, 0, NULL, '0', NULL, 1, 0);
INSERT INTO `examstudent` VALUES (2, 1, 6, 1, 0, '2019-05-13 16:17:19', '120', '2019-05-13 18:17:19', 1, 1);
INSERT INTO `examstudent` VALUES (3, 2, 5, 1, 0, '2019-05-21 00:41:06', '10', '2019-05-21 00:51:06', 1, 1);

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `collegeID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_collegeID`(`collegeID`) USING BTREE,
  CONSTRAINT `fk_collegeID` FOREIGN KEY (`collegeID`) REFERENCES `college` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for knowledgepoint
-- ----------------------------
DROP TABLE IF EXISTS `knowledgepoint`;
CREATE TABLE `knowledgepoint`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseID` int(11) NULL DEFAULT NULL,
  `chapterID` int(11) NULL DEFAULT NULL,
  `point` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_courseID_knowledgepoint`(`courseID`) USING BTREE,
  INDEX `fk_chapterID_knowledgepoint`(`chapterID`) USING BTREE,
  CONSTRAINT `fk_chapterID_knowledgepoint` FOREIGN KEY (`chapterID`) REFERENCES `chapter` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_courseID_knowledgepoint` FOREIGN KEY (`courseID`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of knowledgepoint
-- ----------------------------
INSERT INTO `knowledgepoint` VALUES (1, 1, 1, '1.1 计算机');

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classesID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_classesID_material`(`classesID`) USING BTREE,
  CONSTRAINT `fk_classesID_material` FOREIGN KEY (`classesID`) REFERENCES `classes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES (1, '(日期20190510185958+4947693)图解机器学习.docx', 1);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `createtime` datetime NULL DEFAULT NULL,
  `back` int(4) NULL DEFAULT NULL,
  `studentID` int(11) NULL DEFAULT NULL,
  `classesID` int(11) NULL DEFAULT NULL,
  `fileName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `send` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_studentID_message`(`studentID`) USING BTREE,
  INDEX `fk_classesID_message`(`classesID`) USING BTREE,
  CONSTRAINT `fk_classesID_message` FOREIGN KEY (`classesID`) REFERENCES `classes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_studentID_message` FOREIGN KEY (`studentID`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (2, '您好', '老师', '2019-05-10 18:52:59', 1, 5, 1, '(日期20190510185259+7075610)图解机器学习.docx', 0);
INSERT INTO `message` VALUES (3, '你好', '12313', '2019-05-20 19:40:39', 0, 5, 1, '(日期20190520194039+3143394)需求.docx', 1);

-- ----------------------------
-- Table structure for online
-- ----------------------------
DROP TABLE IF EXISTS `online`;
CREATE TABLE `online`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseID` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `teacherID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_courseID_online`(`courseID`) USING BTREE,
  INDEX `fk_teacherID_online`(`teacherID`) USING BTREE,
  CONSTRAINT `fk_courseID_online` FOREIGN KEY (`courseID`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_teacherID_online` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of online
-- ----------------------------
INSERT INTO `online` VALUES (1, 1, '计算机基础（黄蔚）', 2);

-- ----------------------------
-- Table structure for problem
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `courseID` int(11) NULL DEFAULT NULL,
  `chapterID` int(11) NULL DEFAULT NULL,
  `knowledgepointID` int(11) NULL DEFAULT NULL,
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `questionFileName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `text1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `text2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `text3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `text4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `answerFileName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `difficulty` int(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_knowledgepointID_problem`(`knowledgepointID`) USING BTREE,
  INDEX `fk_courseID_problem`(`courseID`) USING BTREE,
  INDEX `fk_chapterID_problem`(`chapterID`) USING BTREE,
  CONSTRAINT `fk_chapterID_problem` FOREIGN KEY (`chapterID`) REFERENCES `chapter` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_courseID_problem` FOREIGN KEY (`courseID`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_knowledgepointID_problem` FOREIGN KEY (`knowledgepointID`) REFERENCES `knowledgepoint` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of problem
-- ----------------------------
INSERT INTO `problem` VALUES (1, 'admin', 3, 1, 1, 1, '1+1=2', NULL, '', '', '', '', 'true', NULL, '', 1);
INSERT INTO `problem` VALUES (2, 'admin', 1, 1, 1, 1, '1+1=?', NULL, '1', '2', '3', '4', 'B', NULL, '', 1);
INSERT INTO `problem` VALUES (3, 'admin', 2, 1, 1, 1, '1+1=?', NULL, '', '', '', '', '2', NULL, '', 1);
INSERT INTO `problem` VALUES (4, 'admin', 4, 1, 1, 1, '1+1=?', NULL, '', '', '', '', '2', NULL, '', 1);
INSERT INTO `problem` VALUES (5, 'admin', 5, 1, 1, 1, '', '5question登陆界面.zip', '', '', '', '', '', '5answer登陆界面.zip', '', 1);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuid` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `collegeID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_collegeID_student`(`collegeID`) USING BTREE,
  CONSTRAINT `fk_collegeID_student` FOREIGN KEY (`collegeID`) REFERENCES `college` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (5, 1610401024, '孙艳阳', 'd371cf183545c9ecb9684520ca3c93e2', 2);
INSERT INTO `student` VALUES (6, 1610401030, '苇名一心', 'd371cf183545c9ecb9684520ca3c93e2', 2);
INSERT INTO `student` VALUES (7, 1630343231, '结城理', 'd371cf183545c9ecb9684520ca3c93e2', 3);

-- ----------------------------
-- Table structure for student_classes
-- ----------------------------
DROP TABLE IF EXISTS `student_classes`;
CREATE TABLE `student_classes`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentID` int(11) NULL DEFAULT NULL,
  `classesID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_studentID`(`studentID`) USING BTREE,
  INDEX `fk_classesID`(`classesID`) USING BTREE,
  CONSTRAINT `fk_classesID` FOREIGN KEY (`classesID`) REFERENCES `classes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_studentID` FOREIGN KEY (`studentID`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student_classes
-- ----------------------------
INSERT INTO `student_classes` VALUES (1, 5, 1);

-- ----------------------------
-- Table structure for studentanswer
-- ----------------------------
DROP TABLE IF EXISTS `studentanswer`;
CREATE TABLE `studentanswer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examID` int(11) NULL DEFAULT NULL,
  `studentID` int(11) NULL DEFAULT NULL,
  `problemID` int(11) NULL DEFAULT NULL,
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classesID` int(11) NULL DEFAULT NULL,
  `score` double(11, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_examID_studentanswer`(`examID`) USING BTREE,
  INDEX `fk_studentID_studentanswer`(`studentID`) USING BTREE,
  INDEX `fk_problemID_studentanswer`(`problemID`) USING BTREE,
  INDEX `fk_classesID_studentanswer`(`classesID`) USING BTREE,
  CONSTRAINT `fk_classesID_studentanswer` FOREIGN KEY (`classesID`) REFERENCES `classes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_examID_studentanswer` FOREIGN KEY (`examID`) REFERENCES `exam` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_problemID_studentanswer` FOREIGN KEY (`problemID`) REFERENCES `problem` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_studentID_studentanswer` FOREIGN KEY (`studentID`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of studentanswer
-- ----------------------------
INSERT INTO `studentanswer` VALUES (1, 1, 5, 2, 'A', '1', 1, 0);
INSERT INTO `studentanswer` VALUES (2, 1, 5, 3, '2', '2', 1, 1);
INSERT INTO `studentanswer` VALUES (3, 1, 5, 4, '2', '4', 1, 0);
INSERT INTO `studentanswer` VALUES (4, 1, 5, 5, '4工作.xlsx', '5', 1, 0);
INSERT INTO `studentanswer` VALUES (5, 2, 5, 2, NULL, '1', 1, 0);
INSERT INTO `studentanswer` VALUES (6, 2, 5, 3, NULL, '2', 1, 0);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `collegeID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_collegeID_teacher`(`collegeID`) USING BTREE,
  CONSTRAINT `fk_collegeID_teacher` FOREIGN KEY (`collegeID`) REFERENCES `college` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (2, '黄蔚', 'd371cf183545c9ecb9684520ca3c93e2', 3);
INSERT INTO `teacher` VALUES (3, '莫言', 'd371cf183545c9ecb9684520ca3c93e2', 2);
INSERT INTO `teacher` VALUES (4, '明智五郎', 'd371cf183545c9ecb9684520ca3c93e2', 2);
INSERT INTO `teacher` VALUES (5, '袁丽华', 'd371cf183545c9ecb9684520ca3c93e2', 2);
INSERT INTO `teacher` VALUES (6, '叶圣陶', 'd371cf183545c9ecb9684520ca3c93e2', 2);

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `onlineID` int(11) NULL DEFAULT NULL,
  `knowledgepointID` int(11) NULL DEFAULT NULL,
  `filename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `teacherID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_onlineID_video`(`onlineID`) USING BTREE,
  INDEX `fk_knowledgepointID_video`(`knowledgepointID`) USING BTREE,
  INDEX `fk_teacherID_video`(`teacherID`) USING BTREE,
  CONSTRAINT `fk_knowledgepointID_video` FOREIGN KEY (`knowledgepointID`) REFERENCES `knowledgepoint` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_onlineID_video` FOREIGN KEY (`onlineID`) REFERENCES `online` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_teacherID_video` FOREIGN KEY (`teacherID`) REFERENCES `video` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (2, 1, 1, '女神异闻录3ED キミの記憶 中文字幕 - 1.女神异闻录3 ED キミの記憶(Av27008457,P1).mp4', 2);

SET FOREIGN_KEY_CHECKS = 1;
