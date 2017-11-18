package com.gsau.service;

import com.gsau.entity.Courses;
import com.gsau.entity.PageBean;
import com.gsau.entity.Students;
import com.gsau.entity.Teachers;

public interface StudentsService {

	Students find(String stu_id);

	void update(Students students);

	Students findById(String stu_id);

	PageBean<Students> findAll(int currPage);

	void save(Students students);

	void delete(Students students);


}
