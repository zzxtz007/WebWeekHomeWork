package top.haha233.service.impl;

import top.haha233.DAO.DAOFactory;
import top.haha233.entity.Course;
import top.haha233.service.CourseService;

import java.util.ArrayList;

public class CourseServiceImpl implements CourseService {
	private static int sqlType = DAOFactory.MYSQL;

	@Override
	public ArrayList<Course> addScoreBefore() {
		return DAOFactory.getCourseDao(sqlType).queryAllCourse();
	}

}
