package com.gsau.dao;

import java.util.List;

import com.gsau.entity.Out_School;

public interface OutSchoolDao {

	void save(Out_School out);

	List findAll();

}
