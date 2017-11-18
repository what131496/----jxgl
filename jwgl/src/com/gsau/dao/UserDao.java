package com.gsau.dao;

import java.util.List;

import com.gsau.entity.UserDetails;

public interface UserDao{
	public UserDetails login(UserDetails userDetails);

	public String eidtStudents(String UserName, String oldPass, String newPass);

	public String eidtTeachers(String userId, String oldPass, String newPass);

	public String editAdmin(String userId, String oldPass, String newPass);

	public int findCount();

	public List<UserDetails> findByPage(int begin, int pageSize);

	public UserDetails findById(String userId);

	public void update(UserDetails userDetails);

	public void delte(UserDetails userDetails);

	public void save(UserDetails userDetails);

	public String edit(String id, String newPass);


}
