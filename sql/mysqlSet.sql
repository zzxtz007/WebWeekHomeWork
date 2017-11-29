-- 创建用户
GRANT USAGE
ON *.* TO 'stu_table'@'localhost' IDENTIFIED BY 'stu123456' WITH GRANT OPTION;

--添加权限


GRANT all ON students.* TO 'stu_table'@'localhost' IDENTIFIED BY 'stu123456';

--刷新权限
  FLUSH PRIVILEGES;

--添加数据库
CREATE DATABASE IF NOT EXISTS students DEFAULT CHARSET utf8 COLLATE utf8_general_ci;