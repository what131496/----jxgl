package com.gsau.dao.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gsau.dao.CoursesDao;
import com.gsau.entity.Courses;
import com.gsau.entity.Courses_arrange;
import com.gsau.entity.Teachers;
import com.gsau.entity.UserDetails;
import com.opensymphony.xwork2.ActionContext;

public class CoursesDaoImpl extends HibernateDaoSupport implements CoursesDao {

	@Override
	public int findCount() {
		String hql="select count(*) from Courses";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	@Override
	public List<Courses> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Courses.class);
		List<Courses> list=this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}
	@Override
	public void select(String cour_id, String stu_id) {
		String hql=" ";
	}
	@Override
	public List findSelect(String st_id) {
		String sql="select * from courses c ,Course_score cs where c.cour_id=cs.cour_id and cs.stu_id= ?";
		/*String hql="from Course_score";*/
		List list=this.getSession().createSQLQuery(sql).setString(0, st_id).list();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] object = (Object[])list.get(i);
				
			}
			return list;
		}
		return null;
	}
	@Override
	public List<Courses> findTotal() {
		return this.getHibernateTemplate().find("from Courses where flag=1");
	}
	@Override
	public void add(Courses courses,int lecture_time) {
		String cour_id=courses.getCour_id();
		this.getHibernateTemplate().save(courses);
		String teach_id=(String) ActionContext.getContext().getSession().get("exitUser");
		Courses_arrange cours=new Courses_arrange();
		cours.setCour_id(cour_id);
		cours.setTeach_id(teach_id);
		cours.setLecture_time(lecture_time);
		this.getHibernateTemplate().save(cours);
	}
	@Override
	public List<Courses> verify() {
		return this.getHibernateTemplate().find("from Courses where flag=0");
	}
	@Override
	public void verifySuccess(String cour_id) {
		String sql="update Courses set flag=1 where cour_id=?";
		this.getSession().createSQLQuery(sql).setString(0, cour_id).executeUpdate();
		this.getSession().close();
	}
	@Override
	public Courses findById(String cour_id) {
		return this.getHibernateTemplate().get(Courses.class, cour_id);
	}
	@Override
	public void update(Courses courses) {
		this.getHibernateTemplate().update(courses);
		
	}
	@Override
	public void delete(Courses courses) {
		this.getHibernateTemplate().delete(courses);
	}
	@Override
	public List<Courses> findByTeacher(String stu_id) {
		String sql="select * from courses c, courses_arrange ca where c.cour_id=ca.cour_id and ca.teach_id=?";
		List lists=this.getSession().createSQLQuery(sql).setString(0, stu_id).list();
		this.getSession().close();
		return lists;
	}
	
}
