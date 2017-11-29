package top.haha233.service;

import top.haha233.entity.Score;
import top.haha233.service.util.SuperInfo;


public interface ScoreService {
	int addScore(String stuid, String courseid, String score);

	int deleteScore(String id);

	SuperInfo query(String key);

	Score queryById(String id);

	int update(String score, String id);
}
