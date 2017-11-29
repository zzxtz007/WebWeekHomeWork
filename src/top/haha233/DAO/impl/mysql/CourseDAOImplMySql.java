package top.haha233.DAO.impl.mysql;

import top.haha233.DAO.CourseDAO;
import top.haha233.entity.Course;
import top.haha233.util.MySqlJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAOImplMySql implements CourseDAO {
	public ArrayList<Course> queryAllCourse() {
		ArrayList<Course> a = new ArrayList<>();
		String sql = "SELECT\n" +
				"  ID,\n" +
				"  NAME \n" +
				"FROM COURSE WHERE ISDELETE = 0";
		Object o = MySqlJdbc.execute(sql, 2);
		if (o == null) {
			return null;
		}
		ResultSet rs = (ResultSet) o;
		try {
			while (rs.next()) {
				Course c = new Course();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				a.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySqlJdbc.closeResoure(rs, null);
		}
		return a;
	}

	public Course queryById(int id) {
		Course c = null;
		String sql = "SELECT\n" +
				"  ID,\n" +
				"  NAME\n" +
				"FROM COURSE WHERE ISDELETE=0 AND id=" + id;
		Object o = MySqlJdbc.execute(sql, 2);
		if (o == null) {
			return null;
		}
		ResultSet rs = (ResultSet) o;
		try {
			if (rs.next()) {
				c = new Course();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySqlJdbc.closeResoure(rs, null);
		}
		return c;
	}
}
