package com.gsau.dao;

import java.util.List;

import com.gsau.entity.Courses;

public interface CoursesDao {

	int findCount();

	List<Courses> findByPage(int begin, int pageSize);

	void select(String cour_id, String stu_id);

	List<Courses> findSelect(String stu_id);

	List<Courses> findTotal();

	void add(Courses courses, int lecture_time);

	List<Courses> verify();


	void verifySuccess(String cour_id);

	Courses findById(String cour_id);

	void update(Courses courses);

	void delete(Courses courses);

	List<Courses> findByTeacher(String stu_id);

}
