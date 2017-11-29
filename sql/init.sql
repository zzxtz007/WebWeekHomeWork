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
CREATE TABLE student
(
  id       NUMBER(10) PRIMARY KEY,
  name     VARCHAR2(64 CHAR)     NOT NULL,
  isdelete NUMBER(1) DEFAULT (0) NOT NULL
);

-- 2、课程表  课程号  名称
CREATE TABLE course
(
  id       NUMBER(10) PRIMARY KEY,
  name     VARCHAR2(64 CHAR)     NOT NULL,
  isdelete NUMBER(1) DEFAULT (0) NOT NULL
);
-- 3、成绩表  学号  课程号  成绩
CREATE TABLE score
(
  id         NUMBER(10) PRIMARY KEY,
  student_id NUMBER(10) REFERENCES student (id)        NOT NULL,
  course_id  NUMBER(10) REFERENCES course (id)         NOT NULL,
  score      NUMBER(3) CHECK (score BETWEEN 0 AND 100) NOT NULL,
  isdelete   NUMBER(1) DEFAULT (0)                     NOT NULL
);

ALTER TABLE score
  ADD
  CONSTRAINT Uq_stu_cour UNIQUE (student_id, course_id);
