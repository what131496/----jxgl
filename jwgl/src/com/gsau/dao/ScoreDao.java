package com.gsau.dao;

public interface ScoreDao {

	void save(String stu_id, String cour_id, double score);

	void update(String[] stus, String[] cours, String[] scores);

}
