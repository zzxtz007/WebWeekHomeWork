package top.haha233.DAO;

import top.haha233.entity.Student;
import top.haha233.util.MySqlJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDAO {
	ArrayList<Student> queryAll();

	Student queryById(int id);
}
