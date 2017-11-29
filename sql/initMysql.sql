-- 1）成绩管理系统
-- 1、学生表  学号  名称
-- 2、课程表  课程号  名称
-- 3、成绩表  学号  课程号  成绩
--
-- 功能需求
-- A）录入成绩  学号输入  课程（选择） 成绩输入   验证
-- B）查询成绩  学号   姓名  支持模糊查询
-- C）成绩维护  修改、删除成绩

-- 1、学生表  学号  名称
CREATE TABLE `student`
(
`id`       INT(10) PRIMARY KEY AUTO_INCREMENT,
`name`     VARCHAR(64)      NOT NULL,
`isdelete` INT(1) DEFAULT 0 NOT NULL
)DEFAULT CHARSET = `UTF8`;


-- 2、课程表  课程号  名称
CREATE TABLE `course`
(
`id`       INT(10) PRIMARY KEY AUTO_INCREMENT,
`name`     VARCHAR(64)      NOT NULL,
`isdelete` INT(1) DEFAULT 0 NOT NULL
)DEFAULT CHARSET = `UTF8`;
-- 3、成绩表  学号  课程号  成绩
CREATE TABLE `score`
(
`id`         INT(10) PRIMARY KEY AUTO_INCREMENT,
`student_id` INT(10)                       NOT NULL,
`course_id`  INT(10)                       NOT NULL,
`score`      INT(3) CHECK (`score` >= 0 AND
`score` <= 100) ,
`isdelete`   INT(1) DEFAULT 0              NOT NULL,
CONSTRAINT `fk_student_id` FOREIGN KEY (student_id)
REFERENCES student (id),
CONSTRAINT `fk_course_id` FOREIGN KEY (course_id)
REFERENCES `course` (`id`)
)DEFAULT CHARSET = `UTF8`;

ALTER TABLE score
ADD
CONSTRAINT uq_stu_cour UNIQUE (student_id, course_id);
