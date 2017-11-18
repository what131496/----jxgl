package com.gsau.service.serviceImpl;

import java.util.List;

import com.gsau.dao.StudentsDao;
import com.gsau.entity.PageBean;
import com.gsau.entity.Students;
import com.gsau.entity.Teachers;
import com.gsau.service.StudentsService;

public class StudentsServiceImpl implements StudentsService {
	
	private StudentsDao studentsDao;
	public StudentsDao getStudentsDao() {
		return studentsDao;
	}
	public void setStudentsDao(StudentsDao studentsDao) {
		this.studentsDao = studentsDao;
	}


	@Override
	public Students find(String stu_id) {
		
		return studentsDao.find(stu_id);
	}
	@Override
	public void update(Students students) {
		studentsDao.update(students);
		
	}
	@Override
	public Students findById(String stu_id) {
		return studentsDao.findById(stu_id);
	}
	@Override
	public PageBean<Students> findAll(int currPage) {
		PageBean<Students> Students=new PageBean<Students>();
		Students.setCurrPage(currPage);
		//ÿҳ��ʾ��¼��
		int pageSize=3;
		Students.setPageSize(pageSize);
		//���ݿ���ܼ�¼��
		int totalCount=studentsDao.findCount();
		Students.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		Students.setTotalPage(num.intValue());
		//ÿҳ��ʾ������
		int begin = (currPage-1)* pageSize;
		List<Students> lista=studentsDao.findByPage(begin,pageSize);
		Students.setList(lista);
		return Students;
	}
	@Override
	public void save(Students students) {
		studentsDao.save(students);
	}
	@Override
	public void delete(Students students) {
		studentsDao.delete(students);		
	}

}
