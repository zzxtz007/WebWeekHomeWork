package top.haha233.DAO;

import top.haha233.DAO.impl.mysql.CourseDAOImplMySql;
import top.haha233.DAO.impl.mysql.ScoreDAOImplMySql;
import top.haha233.DAO.impl.mysql.StudentDAOImplMySql;
import top.haha233.DAO.impl.oracle.CourseDAOImplOracle;
import top.haha233.DAO.impl.oracle.ScoreDAOImplOracle;
import top.haha233.DAO.impl.oracle.StudentDAOImplOracle;

import javax.annotation.CheckForNull;

public class DAOFactory {
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;

	@CheckForNull
	public static CourseDAO getCourseDao(int type) {
		switch (type) {
			case MYSQL:
				return new CourseDAOImplMySql();
			case ORACLE:
				return new CourseDAOImplOracle();
			default:
				return null;
		}

	}

	@CheckForNull
	public static StudentDAO getStudentDao(int type) {
		switch (type) {
			case MYSQL:
				return new StudentDAOImplMySql();
			case ORACLE:
				return new StudentDAOImplOracle();
			default:
				return null;
		}

	}

	@CheckForNull
	public static ScoreDAO getScoreDao(int type) {
		switch (type) {
			case MYSQL:
				return new ScoreDAOImplMySql();
			case ORACLE:
				return new ScoreDAOImplOracle();
			default:
				return null;
		}
	}

}
