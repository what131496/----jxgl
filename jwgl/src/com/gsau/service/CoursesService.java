package com.gsau.service;

import java.util.List;

import com.gsau.entity.Courses;
import com.gsau.entity.PageBean;

public interface CoursesService {

	PageBean<Courses> findAll(int currPage);

	void select(String cour_id, String stu_id);

	List findSelect(String stu_id);

	List<Courses> findTotal();

	void add(Courses courses, int lecture_time);

	List<Courses> verify();

	void verifySuccess(String cour_id);

	Courses finbById(String cour_id);

	void update(Courses courses);

	void delete(Courses courses);

	List<Courses> findByTeacher(String stu_id);


}
