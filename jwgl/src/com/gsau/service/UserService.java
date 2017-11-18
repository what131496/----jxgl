package com.gsau.service;

import com.gsau.entity.PageBean;
import com.gsau.entity.UserDetails;

public interface UserService {

	UserDetails login(UserDetails userDetails);

	String editStudetns(String userId, String oldPass, String newPass);

	String editTeachers(String userId, String oldPass, String newPass);

	String editAdmin(String userId, String oldPass, String newPass);

	PageBean<UserDetails> findByPage(int currPage);

	UserDetails findById(String userId);

	void update(UserDetails userDetails);

	void delete(UserDetails userDetails);

	void save(UserDetails userDetails);

	String edit(String id, String newPass);

   
}
