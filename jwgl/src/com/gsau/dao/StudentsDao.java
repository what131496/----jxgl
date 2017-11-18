package com.gsau.dao;

import java.util.List;

import com.gsau.entity.Students;

public interface StudentsDao {

	Students find(String stu_id);

	void update(Students students);

	Students findById(String stu_id);

	int findCount();

	List<com.gsau.entity.Students> findByPage(int begin, int pageSize);

	void save(Students students);

	void delete(Students students);

}
