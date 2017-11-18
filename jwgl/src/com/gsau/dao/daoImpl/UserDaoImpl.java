package com.gsau.dao.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.gsau.dao.UserDao;
import com.gsau.entity.UserDetails;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public UserDetails login(UserDetails userDetails) {
		String hql="from UserDetails where UserId=? and UserPass=? and role=?";
		List<UserDetails> list=this.getHibernateTemplate().find(hql,userDetails.getUserId(),userDetails.getUserPass(),userDetails.getRole());
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public String eidtStudents(String UserId, String oldPass, String newPass) {
		// TODO Auto-generated method stub
		UserDetails stu=this.getHibernateTemplate().get(UserDetails.class, UserId);
		System.out.println(stu.getUserPass());
		if(stu.getUserPass().equals(oldPass)){
			System.out.println("输入密码合格");
			stu.setUserPass(newPass);
			this.getHibernateTemplate().update(stu);
			return "edit";
		}else{
			System.out.println("密码不合格");
			return "edita";
		}
	}

	@Override
	public String eidtTeachers(String UserId, String oldPass, String newPass) {
		UserDetails stu=this.getHibernateTemplate().get(UserDetails.class, UserId);
		System.out.println(stu.getUserPass());
		if(stu.getUserPass().equals(oldPass)){
			System.out.println("输入密码合格");
			stu.setUserPass(newPass);
			this.getHibernateTemplate().update(stu);
			return "edit";
		}else{
			System.out.println("密码不合格");
			return "edita";
		}
	}

	@Override
	public String editAdmin(String UserId, String oldPass, String newPass) {
		UserDetails stu=this.getHibernateTemplate().get(UserDetails.class, UserId);
		System.out.println(stu.getUserPass());
		if(stu.getUserPass().equals(oldPass)){
			System.out.println("输入密码合格");
			stu.setUserPass(newPass);
			this.getHibernateTemplate().update(stu);
			return "edit";
		}else{
			System.out.println("密码不合格");
			return "edita";
		}
	}

	@Override
	public int findCount() {
		String hql="select count(*) from UserDetails";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<UserDetails> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(UserDetails.class);
		List<UserDetails> list=this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	public UserDetails findById(String UserId) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(UserDetails.class, UserId);
	}

	@Override
	public void update(UserDetails userDetails) {
		this.getHibernateTemplate().update(userDetails);
	}

	@Override
	public void delte(UserDetails userDetails) {
		this.getHibernateTemplate().delete(userDetails);
	}

	@Override
	public void save(UserDetails userDetails) {
		this.getHibernateTemplate().save(userDetails);
	}

	@Override
	public String edit(String id, String newPass) {
		UserDetails stu=this.getHibernateTemplate().get(UserDetails.class, id);
		String sql="update userDetails set UserPass=? where UserId=?";
		this.getSession().createSQLQuery(sql).setString(0, newPass).setString(1, id).executeUpdate();
		return "edit";
	}	
}
