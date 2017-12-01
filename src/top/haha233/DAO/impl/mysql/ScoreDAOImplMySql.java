package top.haha233.DAO.impl.mysql;

import top.haha233.DAO.ScoreDAO;
import top.haha233.entity.Course;
import top.haha233.entity.Score;
import top.haha233.entity.Student;
import top.haha233.util.MySqlJdbc;

import javax.annotation.CheckForNull;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScoreDAOImplMySql implements ScoreDAO {
    @Override
    public ArrayList<Score> queryAll() {
        //language=MySQL
        String sql = "SELECT id, student_id, course_id, score FROM score WHERE isdelete = 0";
        return queryAllScore(sql, null, 3);
    }

    @Override
    public ArrayList<Score> queryAllByStuid(int id) {
        //language=MySQL
        String sql = "SELECT id, student_id, course_id, score FROM score WHERE student_id = ? AND"
            + " isdelete = 0";
        ArrayList<Object> a = new ArrayList<>(10);
        a.add(id);
        return queryAllScore(sql, a, 1);
    }

    @Override
    public ArrayList<Score> queryAllByStudentName(String name) {
        //language=MySQL
        String sql = "SELECT score.id, student_id, course_id, score FROM score INNER JOIN student"
            + " ON score.student_id = student.id WHERE score.isdelete =0 AND student.name LIKE ?";

        ArrayList<Object> paramList = new ArrayList<>(1);
        paramList.add(name + '%');

        return queryAllScore(sql, paramList, 3);
    }

    @Override
    public ArrayList<Score> queryAllByCourseName(String name) {
        //language=MySQL
        String sql = "SELECT score.id, student_id, course_id, score FROM score INNER JOIN course "
            + "ON score.course_id = course.id WHERE course.isdelete = 0 AND score.isdelete = 0 "
            + "AND course.name LIKE ?";

        ArrayList<Object> paramList = new ArrayList<>(1);
        paramList.add(name + '%');

        return queryAllScore(sql, paramList, 3);
    }

    @CheckForNull
    @Override
    public Score queryByid(int id) {
        //language=MySQL
        String sql = "SELECT id, student_id, course_id, score FROM score WHERE id = ?";

        ArrayList<Object> paramList = new ArrayList<>(1);
        paramList.add(id);

        Object o = MySqlJdbc.execute(sql, paramList, 2);
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

    @Override
    public int addScore(Score score) {
        //language=MySQL
        String sql = "INSERT INTO score (student_id, course_id, score) VALUES (?, ?, ?)";

        ArrayList<Object> paramList = new ArrayList<>(3);
        paramList.add(score.getStudent().getId());
        paramList.add(score.getCourse().getId());
        paramList.add(score.getScore());

        Object o = MySqlJdbc.execute(sql, paramList, 1);
        if (o == null) {
            return -1;
        }
        return o.hashCode();
    }

    @Override
    public int updateScore(Score score) {
        //language=MySQL
        String sql = "UPDATE score SET score = ? WHERE id=?";

        ArrayList<Object> paramList = new ArrayList<>(2);
        paramList.add(score.getScore());
        paramList.add(score.getId());

        Object o = MySqlJdbc.execute(sql, paramList, 1);
        if (o == null) {
            return -1;
        }
        return o.hashCode();
    }

    @Override
    public int deleteScore(Score score) {
        //language=MySQL
        String sql = "DELETE FROM score WHERE id =?";

        ArrayList<Object> paramList = new ArrayList<>(1);
        paramList.add(score.getId());

        Object o = MySqlJdbc.execute(sql, paramList, 1);
        if (o == null) {
            return -1;
        }
        return o.hashCode();
    }

    private ArrayList<Score> queryAllScore(String sql, ArrayList<Object> paramList, int type) {
        Object o = null;

        switch (type) {
            //1根据stuid查
            case 1:
                o = MySqlJdbc.execute(sql, paramList, 2);
                break;
            //2根据Courseid查
            case 2:
                o = MySqlJdbc.execute(sql, paramList, 2);
                break;
            //查询所有
            case 3:
                o = MySqlJdbc.execute(sql, 2);
                break;
            default:
                break;
        }

        if (o == null) {
            return null;
        }

        ArrayList<Score> arrayList = new ArrayList<>(10);
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
}
