package top.haha233.service;

import top.haha233.service.impl.CourseServiceImpl;
import top.haha233.service.impl.ScoreServiceImpl;
import top.haha233.service.impl.StudentServiceImpl;

public class ServiceFactory {
	private static ScoreService scoreService;
	private static StudentService studentService;
	private static CourseService courseService;

	public static ScoreService getScoreService() {
		if (scoreService == null) {
			scoreService = new ScoreServiceImpl();
		}
		return scoreService;
	}

	public static StudentService getStudentService() {
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}

	public static CourseService getCourseService() {
		if (courseService == null) {
			courseService = new CourseServiceImpl();
		}
		return courseService;
	}
}
