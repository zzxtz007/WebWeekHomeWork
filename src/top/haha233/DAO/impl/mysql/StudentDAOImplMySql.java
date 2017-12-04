package top.haha233.DAO.impl.mysql;

import top.haha233.DAO.StudentDAO;
import top.haha233.entity.Student;
import top.haha233.util.MySqlJDBC;

import javax.annotation.CheckForNull;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentDAOImplMySql implements StudentDAO {
    @Override
    @CheckForNull
    public ArrayList<Student> queryAll() {
        ArrayList<Student> arrayList = new ArrayList<>(10);
        String sql = "SELECT id, name FROM student WHERE student.isdelete = 0";
        Object o = MySqlJDBC.execute(sql, 2);
        if (o == null) {
            return null;
        }
        ResultSet rs = (ResultSet) o;
        try {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                arrayList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlJDBC.clossConnection();
        }
        return arrayList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Student queryById(int id) {
        Student s = null;
        String sql = "SELECT id, name FROM student WHERE student.id = ? AND student.isdelete = 0";

        ArrayList<Object> paramList = new ArrayList<>(1);
        paramList.add(id);

        Object o = MySqlJDBC.execute(sql, paramList, 2);
        if (o == null) {
            return null;
        }
        ResultSet rs = (ResultSet) o;
        try {
            if (rs.next()) {
                s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlJDBC.clossConnection();
        }
        return s;
    }
}
