package com.gsau.service;

import java.util.List;

import com.gsau.entity.Courses;
import com.gsau.entity.PageBean;
import com.gsau.utils.StudentsScore;

public interface ScoreService {

	void save(String stu_id, String cour_id, double score);

	void update(String[] stus, String[] cours, String[] scores);

	
}
