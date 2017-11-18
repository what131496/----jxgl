package com.gsau.dao.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gsau.dao.TeachersDao;
import com.gsau.entity.Teachers;
import com.gsau.entity.UserDetails;
import com.gsau.service.TeachersService;

public class TeachersDaoImpl extends HibernateDaoSupport implements TeachersDao {

	@Override
	public Teachers findById(String teach_id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Teachers.class, teach_id);
	}

	@Override
	public void update(Teachers teachers) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(teachers);
	}

	@Override
	public Teachers find(String teach_id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Teachers.class, teach_id);
	}

	@Override
	public int findCount() {
		String hql="select count(*) from Teachers";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Teachers> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Teachers.class);
		List<Teachers> list=this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	public void delete(Teachers teachers) {
		this.getHibernateTemplate().delete(teachers);
		
	}

	@Override
	public void save(Teachers teachers) {
		this.getHibernateTemplate().save(teachers);
	}

	@Override
	public List thisScore(String teach_id,String cour_id) {
		String sql="select stu_name,s.stu_id,stu_sex,score,stu_telephone,cs.cour_id from courses_arrange ca,course_score cs,students s where ca.cour_id=cs.cour_id and cs.stu_id=s.stu_id and ca.teach_id=? and ca.cour_id=?";
		List list=this.getSession().createSQLQuery(sql).setString(0, teach_id).setString(1, cour_id).list();
		return list;
	}

	@Override
	public List thisCourses(String teach_id) {
		String sql="select * from courses_arrange ca,courses c where ca.cour_id=c.cour_id and ca.teach_id=? and flag=1";
		List list=this.getSession().createSQLQuery(sql).setString(0, teach_id).list();
		return list;
	}
}
