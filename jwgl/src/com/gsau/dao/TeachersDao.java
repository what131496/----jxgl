package com.gsau.dao;

import java.util.List;

import com.gsau.entity.Teachers;

public interface TeachersDao {

	Teachers findById(String teach_id);

	void update(Teachers teachers);

	Teachers find(String teach_id);

	int findCount();

	List<Teachers> findByPage(int begin, int pageSize);

	void delete(Teachers teachers);

	void save(Teachers teachers);

	List thisScore(String teach_id, String cour_ids);

	List thisCourses(String teach_id);

}
