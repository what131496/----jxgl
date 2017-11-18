package com.gsau.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.gsau.dao.CoursesDao;
import com.gsau.entity.Courses;
import com.gsau.entity.PageBean;
import com.gsau.entity.Teachers;
import com.gsau.service.CoursesService;
import com.gsau.utils.SelectCourse;
import com.gsau.utils.StudentsScore;
import com.opensymphony.xwork2.ActionContext;

public class CoursesServiceImpl implements  CoursesService{
	private CoursesDao coursesDao;
	
	public CoursesDao getCoursesDao() {
		return coursesDao;
	}

	public void setCoursesDao(CoursesDao coursesDao) {
		this.coursesDao = coursesDao;
	}
	@Override
	public PageBean<Courses> findAll(int currPage) {
		PageBean<Courses> coursesPage=new PageBean<Courses>();
		coursesPage.setCurrPage(currPage);
		//每页显示记录数
		int pageSize=3;
		coursesPage.setPageSize(pageSize);
		//数据库的总记录
		int totalCount=coursesDao.findCount();
		coursesPage.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		coursesPage.setTotalPage(num.intValue());
		int begin = (currPage-1)* pageSize;
		List<Courses> lista=coursesDao.findByPage(begin,pageSize);
		coursesPage.setList(lista);
		return coursesPage;
	}

	
	@Override
	public void select(String cour_id, String stu_id) {
		coursesDao.select(cour_id,stu_id);
	}

	@Override
	public List findSelect(String stu_id) {
		List list= coursesDao.findSelect(stu_id);
		List<SelectCourse> listc=new ArrayList();
		if(list.size()>0){
		for(int i=0;i<list.size();i++){
			Object[] object = (Object[])list.get(i);
			String cour_id =  (String)object[0];
			String cour_name=(String)object[1];
			int cour_hour=(int)object[2];
			int semester=(int)object[3];
			int credit=(int)object[4];
			int type=(int)object[5];
			double score=(double)object[9];
			SelectCourse listCourse=new SelectCourse();
			listCourse.setCour_id(cour_id);
			listCourse.setCour_name(cour_name);
			listCourse.setCour_hour(cour_hour);
			listCourse.setCredit(credit);
			listCourse.setSemester(semester);
			listCourse.setType(type);
			listCourse.setScore(score);
			listc.add(listCourse);
		}
		return listc;
		}
		return null;
		}

	@Override
	public List<Courses> findTotal() {
		return coursesDao.findTotal();
	}

	@Override
	public void add(Courses courses,int lecture_time) {
		coursesDao.add(courses,lecture_time);
		
	}

	@Override
	public List<Courses> verify() {
		return coursesDao.verify();
	}

	@Override
	public void verifySuccess(String cour_id) {
		coursesDao.verifySuccess(cour_id);
	}

	@Override
	public Courses finbById(String cour_id) {
		return coursesDao.findById(cour_id);
	}

	@Override
	public void update(Courses courses) {
		coursesDao.update(courses);
	}

	@Override
	public void delete(Courses courses) {
		coursesDao.delete(courses);
	}

	@Override
	public List<Courses> findByTeacher(String stu_id) {
		List list=coursesDao.findByTeacher(stu_id);
		List<Courses> listc =new  ArrayList();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] object = (Object[])list.get(i);
				String cour_id=(String)object[0];
				String cour_name=(String)object[1];
				int cour_hour=(int)object[2];
				int semester =(int)object[3];
				int credit=(int) object[4];
				int type=(int) object[5];
				byte flag=(byte) object[6];
				Courses cour=new Courses();
				cour.setCour_id(cour_id);
				cour.setCour_name(cour_name);
				cour.setCour_hour(cour_hour);
				cour.setCredit(credit);
				cour.setSemester(semester);
				cour.setType(type);
				cour.setFlag(flag);
				listc.add(cour);
				}
		}
		return listc;
	}
}
