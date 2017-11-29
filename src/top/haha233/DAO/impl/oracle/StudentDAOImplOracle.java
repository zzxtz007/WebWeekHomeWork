package top.haha233.DAO.impl.oracle;

import top.haha233.DAO.StudentDAO;
import top.haha233.entity.Student;
import top.haha233.util.OracleJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImplOracle implements StudentDAO {
	public ArrayList<Student> queryAll() {
		ArrayList<Student> arrayList = new ArrayList<>();
		String sql = "SELECT\n" +
				"  ID,\n" +
				"  NAME \n" +
				"FROM STUDENT WHERE STUDENT.ISDELETE = 0";
		Object o = OracleJDBC.execute(sql, 2);
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
			OracleJDBC.closeResoure(rs, null);
		}
		return arrayList;
	}

	public Student queryById(int id) {
		Student s = null;
		String sql = "SELECT\n" +
				"  ID,\n" +
				"  NAME \n" +
				"FROM STUDENT WHERE STUDENT.ID='" + id + "' AND STUDENT.ISDELETE = 0";
		Object o = OracleJDBC.execute(sql, 2);
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
			OracleJDBC.closeResoure(rs, null);
		}
		return s;
	}
}
