package top.haha233.service.impl;

import top.haha233.DAO.DAOFactory;
import top.haha233.entity.Course;
import top.haha233.entity.Score;
import top.haha233.entity.Student;
import top.haha233.service.ScoreService;
import top.haha233.service.util.SuperInfo;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ScoreServiceImpl implements ScoreService {
	private static int sqlType = DAOFactory.MYSQL;

	@Override
	public int addScore(String stuid, String courseid, String score) {
		try {
			Integer.valueOf(stuid);
			Integer.valueOf(score);
		} catch (NumberFormatException e) {
			return 0;
		} catch (Exception e) {
			return 0;
		}
		if ("".equals(stuid) || "".equals(score)) {
			return 0;
		}
		Score s = new Score();
		Course c = new Course();
		Student student = new Student();
		c.setId(Integer.valueOf(courseid));
		student.setId(Integer.valueOf(stuid));
		s.setStudent(student);
		s.setCourse(c);
		s.setScore(Integer.valueOf(score));
		return DAOFactory.getScoreDao(sqlType).addScore(s);
	}

	@Override
	public int deleteScore(String id) {
		int Scoreid = 0;
		try {
			Scoreid = Integer.valueOf(id);
		} catch (Exception e) {
			return 0;
		}
		Score score = new Score();
		score.setId(Scoreid);
		return DAOFactory.getScoreDao(sqlType).deleteScore(score);
	}

	/**
	 * @param key
	 * @return SuperInfo ret 为0时正常 1时key值为空
	 */
	@Override
	public SuperInfo query(String key) {
		SuperInfo si = new SuperInfo();
		Map<Integer, Score> scoreMap = new TreeMap<>();

		if (key == null) {
			//ret设置为1
			si.ret = 1;
		}
		if ("".equals(key)) {
			//查询全部
			ArrayList<Score> a = DAOFactory.getScoreDao(sqlType).queryAll();
			for (Score s : a) {
				scoreMap.put(s.getId(), s);
			}
			//转发至原先的queryScore.jsp 查询页面
			si.retMap = scoreMap;
			return si;
//			System.out.println("不可能会出现");
		}
		System.out.println(key);
		//按条件查询
		Pattern pattern = Pattern.compile("^\\d{1,10}$");
		Matcher m = pattern.matcher(key);
		if (m.find()) {
			System.out.println("进入数字查询");
			//查询数字
			ArrayList<Score> a = DAOFactory.getScoreDao(sqlType).queryAllByStuid(Integer.valueOf(key));
			for (Score s : a) {
				scoreMap.put(s.getId(), s);
			}
		} else {
			System.out.println("进入模糊查询");
			ArrayList<Score> a = DAOFactory.getScoreDao(sqlType).queryAllByStudentName(key);
			System.out.println(a);
			for (Score s : a) {
				scoreMap.put(s.getId(), s);
			}
			a = DAOFactory.getScoreDao(sqlType).queryAllByCourseName(key);
			System.out.println(a);
			for (Score s : a) {
				scoreMap.put(s.getId(), s);
			}
		}
		si.retMap = scoreMap;
		return si;
	}

	@Override
	public Score queryById(String id) {
		int scoreId = -1;
		try {
			scoreId = Integer.parseInt(id);
		} catch (Exception e) {
			return null;
		}
		Score score = DAOFactory.getScoreDao(sqlType).queryByid(scoreId);
		return score;
	}

	@Override
	public int update(String score, String id) {
		Score s = new Score();
		try {
			s.setId(Integer.valueOf(id));
			s.setScore(Integer.valueOf(score));
		} catch (Exception e) {
			return 0;
		}
		return DAOFactory.getScoreDao(sqlType).updateScore(s);
	}

}
