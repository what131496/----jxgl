package com.gsau.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.gsau.dao.TeachersDao;
import com.gsau.entity.PageBean;
import com.gsau.entity.Teachers;
import com.gsau.entity.UserDetails;
import com.gsau.service.TeachersService;
import com.gsau.utils.SelectCourse;
import com.gsau.utils.StudentsScore;

public class TeachersServiceImpl implements TeachersService {
	private TeachersDao teachersDao;
	public TeachersDao getTeachersDao() {
		return teachersDao;
	}
	public void setTeachersDao(TeachersDao teachersDao) {
		this.teachersDao = teachersDao;
	}
	@Override
	public Teachers findById(String teach_id) {
		// TODO Auto-generated method stub
		return teachersDao.findById(teach_id);
	}
	@Override
	public void update(Teachers teachers) {
		 teachersDao.update(teachers);
	}
	@Override
	public Teachers find(String teach_id) {
		// TODO Auto-generated method stub
		return teachersDao.find(teach_id);
	}
	@Override
	public PageBean<Teachers> findAll(int currPage) {
		PageBean<Teachers> teachers=new PageBean<Teachers>();
		teachers.setCurrPage(currPage);
		//每页显示记录数
		int pageSize=3;
		teachers.setPageSize(pageSize);
		//数据库的总记录数
		int totalCount=teachersDao.findCount();
		teachers.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		teachers.setTotalPage(num.intValue());
		//每页显示的数据
		int begin = (currPage-1)* pageSize;
		List<Teachers> lista=teachersDao.findByPage(begin,pageSize);
		teachers.setList(lista);
		return teachers;
	}
	@Override
	public void delete(Teachers teachers) {
		teachersDao.delete(teachers);
		
	}
	@Override
	public void save(Teachers teachers) {
		teachersDao.save(teachers);
		
	}
	@Override
	public List thisScore(String teach_id,String cour_ids) {
		List list=teachersDao.thisScore(teach_id,cour_ids);
		List<StudentsScore> listc=new ArrayList();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] object = (Object[])list.get(i);
				String stu_name=(String)object[0];
				String stu_id=(String)object[1];
				String stu_sex=(String)object[2];
				double score=(double)object[3];
				String stu_telephone=(String) object[4];
				String cour_id=(String) object[5];
				StudentsScore Sscore=new StudentsScore();
				Sscore.setStu_name(stu_name);
				Sscore.setStu_id(stu_id);
				Sscore.setStu_sex(stu_sex);
				Sscore.setStu_telephone(stu_telephone);
				Sscore.setScore(score);
				Sscore.setCour_id(cour_id);
				listc.add(Sscore);
			}
		}
		return listc;
	}
	@Override
	public List thisCourses(String teach_id) {
		List list=teachersDao.thisCourses(teach_id);
		List<StudentsScore> listc=new ArrayList();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] object = (Object[])list.get(i);
				String cour_id=(String)object[3];
				String cour_name=(String)object[4];
				int cour_hour=(int)object[5];
				int semester =(int)object[6];
				int credit=(int) object[7];
				int type=(int) object[8];
				StudentsScore Sscore=new StudentsScore();
				Sscore.setCour_id(cour_id);
				Sscore.setCour_name(cour_name);
				Sscore.setCour_hour(cour_hour);
				Sscore.setCredit(credit);
				Sscore.setSemester(semester);
				Sscore.setType(type);
				listc.add(Sscore);
			}
		}
		return listc;
}
}