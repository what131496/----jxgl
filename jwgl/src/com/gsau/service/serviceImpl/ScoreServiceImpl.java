package com.gsau.service.serviceImpl;

import java.util.List;

import com.gsau.dao.ScoreDao;
import com.gsau.entity.Courses;
import com.gsau.entity.PageBean;
import com.gsau.service.ScoreService;
import com.gsau.utils.StudentsScore;

public class ScoreServiceImpl implements ScoreService {
	private ScoreDao scoreDao;
	
	public ScoreDao getScoreDao() {
		return scoreDao;
	}

	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}

	@Override
	public void save(String stu_id, String cour_id, double score) {
		scoreDao.save(stu_id,cour_id,score);
	}

	@Override
	public void update(String[] stus, String[] cours, String[] scores) {
		scoreDao.update(stus,cours,scores);
	}
}
