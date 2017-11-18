package com.gsau.service.serviceImpl;

import java.util.List;

import com.gsau.dao.UserDao;
import com.gsau.entity.PageBean;
import com.gsau.entity.UserDetails;
import com.gsau.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDetails login(UserDetails userDetails) {
		// TODO Auto-generated method stub
		UserDetails ExitEm=userDao.login(userDetails);
		return ExitEm;
	}

	@Override
	public String editStudetns(String userId, String oldPass, String newPass) {
		return userDao.eidtStudents(userId,oldPass,newPass);
	
	}

	@Override
	public String editTeachers(String userId, String oldPass, String newPass) {
		// TODO Auto-generated method stub
		return userDao.eidtTeachers(userId,oldPass,newPass);
	}

	@Override
	public String editAdmin(String userId, String oldPass, String newPass) {
		// TODO Auto-generated method stub
		return userDao.editAdmin(userId,oldPass,newPass);
	}

	@Override
	public PageBean<UserDetails> findByPage(int currPage) {
		// TODO Auto-generated method stub
		PageBean<UserDetails> users=new PageBean<UserDetails>();
		users.setCurrPage(currPage);
		//每页显示记录数
		int pageSize=3;
		users.setPageSize(pageSize);
		//数据库的总记录数
		int totalCount=userDao.findCount();
		users.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		users.setTotalPage(num.intValue());
		//每页显示的数据
		int begin = (currPage-1)* pageSize;
		List<UserDetails> lista=userDao.findByPage(begin,pageSize);
		users.setList(lista);
		return users;
	}
	@Override
	public UserDetails findById(String userId) {
		// TODO Auto-generated method stub
		return userDao.findById(userId);
	}

	@Override
	public void update(UserDetails userDetails) {
		 userDao.update(userDetails);
	}

	@Override
	public void delete(UserDetails userDetails) {
		userDao.delte(userDetails);
	}

	@Override
	public void save(UserDetails userDetails) {
		userDao.save(userDetails);
		
	}

	@Override
	public String edit(String id, String newPass) {
		return userDao.edit(id,newPass);
	}

}
