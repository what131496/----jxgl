package com.gsau.dao.daoImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gsau.dao.OutSchoolDao;
import com.gsau.entity.Out_School;

public class OutSchoolDaoImpl extends HibernateDaoSupport implements OutSchoolDao {

	@Override
	public void save(Out_School out) {
		this.getHibernateTemplate().save(out);
	}
	@Override
	public List findAll() {
		String hql="select * from out_school";
		List list= this.getSession().createSQLQuery(hql).list();
		this.getSession().close();
		return list;
	}

}
