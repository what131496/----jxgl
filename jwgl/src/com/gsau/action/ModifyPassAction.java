package com.gsau.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.gsau.entity.Students;
import com.gsau.entity.UserDetails;
import com.gsau.service.StudentsService;
import com.gsau.service.TeachersService;
import com.gsau.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ModifyPassAction extends ActionSupport implements ModelDriven<UserDetails> {
//修改密码处理的Action
	private UserDetails userDetails =new UserDetails();
	@Override
	public UserDetails getModel() {
		// TODO Auto-generated method stub
		return userDetails;
	}
	private String  oldPass;//旧密码
	private String newPass;//新密码
	private String Id;
	private UserService userService;
	private HttpServletResponse response;
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public String getOldPass() {
		return oldPass;
	}
	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}
	public String getNewPass() {
		return newPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	//获取登陆的当前用户的id
	String UserId=(String) ActionContext.getContext().getSession().get("exitId");
	public String editStudents(){
		String exit=userService.editStudetns(UserId,oldPass,newPass);
		if(exit.equals("edit")){
			return "editStudents";
		}else{
			this.addActionError("输入的旧密码错误");
			return INPUT;
		}
	}
	public String editTeachers(){
		String exit=userService.editTeachers(UserId,oldPass,newPass);
		if(exit.equals("edit")){
			return "editTeachers";
		}else{
			this.addActionError("输入的旧密码错误");
			return "inputeach";
		}
	}
	public String editAdmin(){
		String exit=userService.editAdmin(UserId,oldPass,newPass);
		if(exit.equals("edit")){
			return "editTeachers";
		}else{
			this.addActionError("输入的旧密码错误");
			return "inputeach";
		}
	}
	public  String edit(){
		String exit=userService.edit(Id,newPass);
		if(exit.equals("edit")){
			addActionMessage("0"); 
			return "edit";
		}else{
			System.out.println("更新密码错误");
			return "";
		}
	}
}
