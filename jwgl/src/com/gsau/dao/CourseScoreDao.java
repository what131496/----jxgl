package com.gsau.dao;

import java.util.List;

public interface CourseScoreDao {

	void select(String stu_id, String cour_id);

	List findScore(String stu_id, String cour_id);

	void unselect(String stu_id, String cour_id);

}
