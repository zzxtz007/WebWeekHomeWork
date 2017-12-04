package top.haha233.DAO.impl.mysql;

import top.haha233.DAO.CourseDAO;
import top.haha233.entity.Course;
import top.haha233.util.MySqlJDBC;

import javax.annotation.CheckForNull;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAOImplMySql implements CourseDAO {
    @CheckForNull
    @Override
    public ArrayList<Course> queryAllCourse() {
        ArrayList<Course> a = new ArrayList<>(10);
        //language=MySQL
        String sql = "SELECT id, name FROM course WHERE isdelete = 0";

        Object o = MySqlJDBC.execute(sql, 2);
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
            MySqlJDBC.clossConnection();
        }
        return a;
    }

    @CheckForNull
    @Override
    public Course queryById(int id) {
        Course c = null;
        //language=MySQL
        String sql = "SELECT id, name FROM course WHERE isdelete = 0 AND id = ?";

        ArrayList<Object> paramList = new ArrayList<>(1);
        paramList.add(id);

        Object o = MySqlJDBC.execute(sql, paramList, 2);
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
	        MySqlJDBC.clossConnection();
        }
        return c;
    }
}
