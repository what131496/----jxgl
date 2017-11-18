package com.gsau.service;

import java.util.List;

import com.gsau.entity.PageBean;
import com.gsau.entity.Teachers;

public interface TeachersService {

	Teachers findById(String teach_id);

	void update(Teachers teachers);

	Teachers find(String teach_id);

	PageBean<Teachers> findAll(int currPage);


	void delete(Teachers teachers);

	void save(Teachers teachers);

	List thisScore(String teach_id, String cour_id);

	List thisCourses(String teach_id);
	
}
