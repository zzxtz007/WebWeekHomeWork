package top.haha233.DAO;

import top.haha233.entity.Score;

import java.util.ArrayList;

public interface ScoreDAO {
//	ArrayList<Score> queryAllScore(String sql, ArrayList a, int type);

	ArrayList<Score> queryAll();


	ArrayList<Score> queryAllByStuid(int id);


	ArrayList<Score> queryAllByStudentName(String name);


	ArrayList<Score> queryAllByCourseName(String name);


	Score queryByid(int id);


	int addScore(Score score);

	int updateScore(Score score);

	int deleteScore(Score score);
}
