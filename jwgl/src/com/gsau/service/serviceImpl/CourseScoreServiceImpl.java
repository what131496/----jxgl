package com.gsau.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.gsau.dao.CourseScoreDao;
import com.gsau.service.CourseScoreService;
import com.gsau.utils.StudentsScore;

public class CourseScoreServiceImpl implements CourseScoreService {

	private CourseScoreDao courseScoreDao;
	public CourseScoreDao getCourseScoreDao() {
		return courseScoreDao;
	}
	public void setCourseScoreDao(CourseScoreDao courseScoreDao) {
		this.courseScoreDao = courseScoreDao;
	}
	@Override
	public void select(String stu_id, String cour_id) {
		courseScoreDao.select(stu_id,cour_id);
	}
	@Override
	public List findScore(String stu_id, String cour_id) {
		List list=courseScoreDao.findScore(stu_id,cour_id);
		List<StudentsScore> lists=new ArrayList();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] object = (Object[])list.get(i);
				String cour_name=(String)object[1];
				String score=(String)object[17];
				int credit=(int)object[4];
				int cour_hour=(int)object[2];
				int type=(int)object[5];
				}
		}
		return lists;
	}
	@Override
	public void unselect(String stu_id, String cour_id) {
		courseScoreDao.unselect(stu_id,cour_id);
	}

}
