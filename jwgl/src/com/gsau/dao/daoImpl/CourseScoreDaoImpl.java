package com.gsau.dao.daoImpl;

import java.util.List;

import org.hibernate.JDBCException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gsau.dao.CourseScoreDao;
import com.gsau.entity.Course_score;
import com.gsau.entity.UserDetails;

public class CourseScoreDaoImpl extends HibernateDaoSupport implements CourseScoreDao {
	@Override
	public void select(String stu_id, String cour_id) {
		String sql="select * from course_score where stu_id=? and cour_id=?";
		List list=this.getSession().createSQLQuery(sql).setString(0, stu_id).setString(1, cour_id).list();
		if(list.size()>0){
			throw new RuntimeException("不能重复选择");
		}else{
		Course_score courseScore=new Course_score();
		courseScore.setCour_id(cour_id);
		courseScore.setStu_id(stu_id);
		courseScore.setScore(0);
		this.getHibernateTemplate().save(courseScore);
		}
	}
	@Override
	public List findScore(String stu_id, String cour_id) {
		String sql="select * from Courses c,Course_score cs where c.cour_id=cs.cour_id  and cs.stu_id=?";
		List list=this.getSession().createSQLQuery(sql).setString(1, stu_id).list();
		this.getSession().close();
		return list;
		
	}
	@Override
	public void unselect(String stu_id, String cour_id) {
		String sql="delete from course_score where stu_id=? and cour_id=?";
		this.getSession().createSQLQuery(sql).setString(0, stu_id).setString(1, cour_id).executeUpdate();
		this.getSession().close();
	}
}
