package com.gsau.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.gsau.dao.UserDao;
import com.gsau.entity.PageBean;
import com.gsau.entity.UserDetails;
import com.gsau.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<UserDetails> {
	//这里的userDetails会直接被页面传过来的值赋值
	private UserDetails userDetails=new UserDetails();
	@Override
	public UserDetails getModel() {
		return userDetails;
	}
	//注入处理的service
	private UserService userService;
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//验证码
	private String code;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	Logger logger = Logger.getLogger(this.getClass());
	//	执行登录
	public String login(){
		System.out.println("用户login方法执行---------------------");
//		调用业务层的类
		UserDetails existEm=userService.login(userDetails);
		//从session中取出RandomAction.java 中生成的验证码random 
		String arandom=(String)(ActionContext.getContext().getSession().get("random")); 
		if(arandom.equals(getCode())){
		if(existEm==null){
			//登录失败
			this.addActionError("用户名密码错误或者身份权限有误");
			return INPUT;
		}else if(userDetails.getRole()==0){
			//学生登录成功
			ActionContext.getContext().getSession().put("exitUsers", existEm);
			ActionContext.getContext().getSession().put("exitUser", existEm.getUserId());
			//使用日志记录器产生日志记录信息 
			logger.fatal(existEm.getUserName()+existEm.getUserId()+"普通用户登录访问本系统");
			return SUCCESS;
		}else if(userDetails.getRole()==1){
			//教师登录成功
			ActionContext.getContext().getSession().put("exitUsers", existEm);
			ActionContext.getContext().getSession().put("exitUser", existEm.getUserId());
			logger.fatal(existEm.getUserName()+existEm.getUserId()+"教师登录访问本系统");
			return "teacher";
		}else{
			//管理员登录成功
			ActionContext.getContext().getSession().put("exitUsers", existEm);
			ActionContext.getContext().getSession().put("exitUser", existEm.getUserId());
			logger.fatal(existEm.getUserName()+existEm.getUserId()+"管理员用户登录访问本系统");
			return "admin";
		}
		}else{
			this.addActionError("验证码错误");
			return INPUT;
		}
	}
	//分页查询用户信息
	private int currPage=1;
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public String findAll() {
		PageBean<UserDetails> users= userService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(users);
		return "findAll";
	}
	UserDetails existEm1=(UserDetails) ActionContext.getContext().getSession().get("exitUsers");
	public String edit(){
		userDetails=userService.findById(userDetails.getUserId());
		return "edit";
	}
	public String update(){
		userService.update(userDetails);
		logger.fatal(existEm1.getUserName()+": "+existEm1.getUserId()+" 修改了"+userDetails.getUserName()+"的用户信息");
		return "update";
	}
	public String delete() throws IOException{
		userDetails=userService.findById(userDetails.getUserId());
		userService.delete(userDetails);
		logger.fatal(existEm1.getUserName()+": "+existEm1.getUserId()+" 删除了"+userDetails.getUserName()+"用户信息");
		addActionMessage("<script>alert('选课成功！');</script>");
		return "delete";
	}
	//跳转到添加页面
	public String saveUI(){
		return "saveUI";
	}
	public String save(){
		userService.save(userDetails);
		logger.fatal(existEm1.getUserName()+": "+existEm1.getUserId()+" 新增一个"+userDetails.getUserName()+"用户信息");
		return "save";
	}
}
