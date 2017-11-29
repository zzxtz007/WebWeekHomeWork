package top.haha233.DAO;

import top.haha233.entity.Course;

import java.util.ArrayList;

public interface CourseDAO {
	ArrayList<Course> queryAllCourse();

	Course queryById(int id);
}
