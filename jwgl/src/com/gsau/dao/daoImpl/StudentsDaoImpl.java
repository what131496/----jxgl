package com.gsau.dao.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gsau.dao.StudentsDao;
import com.gsau.entity.Students;
import com.gsau.entity.Teachers;

public class StudentsDaoImpl extends HibernateDaoSupport implements StudentsDao {

	@Override
	public Students find(String stu_id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Students.class, stu_id);
	}

	@Override
	public void update(Students students) {
		this.getHibernateTemplate().update(students);
		
	}

	@Override
	public Students findById(String stu_id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Students.class, stu_id);
	}

	@Override
	public int findCount() {
		String hql="select count(*) from Students";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Students> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Students.class);
		List<Students> list=this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	public void save(Students students) {
		this.getHibernateTemplate().save(students);
	}

	@Override
	public void delete(Students students) {
		this.getHibernateTemplate().delete(students);
	}

}
