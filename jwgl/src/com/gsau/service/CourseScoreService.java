package com.gsau.service;

import java.util.List;

public interface CourseScoreService {

	void select(String stu_id, String cour_id);

	List findScore(String stu_id, String cour_id);

	void unselect(String stu_id, String cour_id);

}
