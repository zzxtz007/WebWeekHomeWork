package top.haha233.DAO.impl.mysql;

import top.haha233.DAO.ScoreDAO;
import top.haha233.entity.Course;
import top.haha233.entity.Score;
import top.haha233.entity.Student;
import top.haha233.util.MySqlJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScoreDAOImplMySql implements ScoreDAO {
	private ArrayList<Score> queryAllScore(String sql, ArrayList a, int type) {
		Object o = null;
		switch (type) {
			//1根据stuid查
			case 1:
				o = MySqlJdbc.execute(sql, a, 2);
				break;
			//2根据Courseid查
			case 2:
				o = MySqlJdbc.execute(sql, a, 2);
				break;
			//查询所有
			case 3:
				o = MySqlJdbc.execute(sql, 2);
				break;
		}
		if (o == null) {
			return null;
		}
		ArrayList arrayList = new ArrayList();
		ResultSet rs = (ResultSet) o;
		try {
			while (rs.next()) {
				Score score = new Score();
				score.setId(rs.getInt(1));
				Student s = new StudentDAOImplMySql().queryById(rs.getInt(2));
				score.setStudent(s);
				Course c = new CourseDAOImplMySql().queryById(rs.getInt(3));
				score.setCourse(c);
				score.setScore(rs.getInt(4));
				arrayList.add(score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	public ArrayList<Score> queryAll() {
		String sql = "SELECT\n" +
				"  ID,\n" +
				"  STUDENT_ID,\n" +
				"  COURSE_ID,\n" +
				"  SCORE\n" +
				"FROM SCORE WHERE ISDELETE=0";
		return queryAllScore(sql, null, 3);
	}

	public ArrayList<Score> queryAllByStuid(int id) {
		String sql = "SELECT\n" +
				"  ID,\n" +
				"  STUDENT_ID,\n" +
				"  COURSE_ID,\n" +
				"  SCORE\n" +
				"FROM SCORE WHERE STUDENT_ID = ? AND ISDELETE=0";
		ArrayList a = new ArrayList();
		a.add(id);
		return queryAllScore(sql, a, 1);
	}

	public ArrayList<Score> queryAllByStudentName(String name) {
		String sql = "SELECT\n" +
				"  score.id,\n" +
				"  student_id,\n" +
				"  course_id,\n" +
				"  score \n" +
				"FROM score\n" +
				"  INNER JOIN student\n" +
				"    ON score.student_id = student.id\n" +
				" WHERE score.isdelete =0 AND student.name LIKE '" + name + "%'";
		return queryAllScore(sql, null, 3);
	}

	public ArrayList<Score> queryAllByCourseName(String name) {
		String sql = "SELECT\n" +
				"  SCORE.ID,\n" +
				"  STUDENT_ID,\n" +
				"  COURSE_ID,\n" +
				"  SCORE\n" +
				"FROM SCORE\n" +
				"  INNER JOIN COURSE\n" +
				"    ON SCORE.COURSE_ID = COURSE.ID\n" +
				"WHERE COURSE.ISDELETE = 0 AND\n" +
				"      SCORE.ISDELETE = 0 AND COURSE.NAME LIKE '" + name + "%'";
		return queryAllScore(sql, null, 3);
	}

	public Score queryByid(int id) {
		String sql = "SELECT\n" +
				"  ID,\n" +
				"  STUDENT_ID,\n" +
				"  COURSE_ID,\n" +
				"  SCORE\n" +
				"FROM SCORE WHERE ID = " + id;
		Object o = MySqlJdbc.execute(sql, 2);
		if (o == null) {
			return null;
		}
		ResultSet rs = (ResultSet) o;
		Score score = null;
		try {
			if (rs.next()) {
				score = new Score();
				score.setId(rs.getInt(1));
				Student s = new StudentDAOImplMySql().queryById(rs.getInt(2));
				score.setStudent(s);
				Course c = new CourseDAOImplMySql().queryById(rs.getInt(3));
				score.setCourse(c);
				score.setScore(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySqlJdbc.closeResoure(rs, null);
		}
		return score;
	}

	public int addScore(Score score) {
		String sql = "INSERT INTO SCORE (STUDENT_ID, COURSE_ID, SCORE)\n" +
				"VALUES (?,?,?)";
		ArrayList a = new ArrayList();
		a.add(score.getStudent().getId());
		a.add(score.getCourse().getId());
		a.add(score.getScore());
		Object o = MySqlJdbc.execute(sql, a, 1);
		if (o == null) {
			return -1;
		}
		return o.hashCode();
	}

	public int updateScore(Score score) {
		String sql = "UPDATE SCORE SET SCORE = ? WHERE ID=?";
		ArrayList a = new ArrayList();
		a.add(score.getScore());
		a.add(score.getId());
		Object o = MySqlJdbc.execute(sql, a, 1);
		if (o == null) {
			return -1;
		}
		return o.hashCode();
	}

	public int deleteScore(Score score) {
		String sql = "DELETE FROM SCORE WHERE ID =?";
		ArrayList a = new ArrayList();
		a.add(score.getId());
		Object o = MySqlJdbc.execute(sql, a, 1);
		if (o == null) {
			return -1;
		}
		return o.hashCode();
	}
}
