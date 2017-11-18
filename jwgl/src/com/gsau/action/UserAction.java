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
	//�����userDetails��ֱ�ӱ�ҳ�洫������ֵ��ֵ
	private UserDetails userDetails=new UserDetails();
	@Override
	public UserDetails getModel() {
		return userDetails;
	}
	//ע�봦���service
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
	//��֤��
	private String code;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	Logger logger = Logger.getLogger(this.getClass());
	//	ִ�е�¼
	public String login(){
		System.out.println("�û�login����ִ��---------------------");
//		����ҵ������
		UserDetails existEm=userService.login(userDetails);
		//��session��ȡ��RandomAction.java �����ɵ���֤��random 
		String arandom=(String)(ActionContext.getContext().getSession().get("random")); 
		if(arandom.equals(getCode())){
		if(existEm==null){
			//��¼ʧ��
			this.addActionError("�û����������������Ȩ������");
			return INPUT;
		}else if(userDetails.getRole()==0){
			//ѧ����¼�ɹ�
			ActionContext.getContext().getSession().put("exitUsers", existEm);
			ActionContext.getContext().getSession().put("exitUser", existEm.getUserId());
			//ʹ����־��¼��������־��¼��Ϣ 
			logger.fatal(existEm.getUserName()+existEm.getUserId()+"��ͨ�û���¼���ʱ�ϵͳ");
			return SUCCESS;
		}else if(userDetails.getRole()==1){
			//��ʦ��¼�ɹ�
			ActionContext.getContext().getSession().put("exitUsers", existEm);
			ActionContext.getContext().getSession().put("exitUser", existEm.getUserId());
			logger.fatal(existEm.getUserName()+existEm.getUserId()+"��ʦ��¼���ʱ�ϵͳ");
			return "teacher";
		}else{
			//����Ա��¼�ɹ�
			ActionContext.getContext().getSession().put("exitUsers", existEm);
			ActionContext.getContext().getSession().put("exitUser", existEm.getUserId());
			logger.fatal(existEm.getUserName()+existEm.getUserId()+"����Ա�û���¼���ʱ�ϵͳ");
			return "admin";
		}
		}else{
			this.addActionError("��֤�����");
			return INPUT;
		}
	}
	//��ҳ��ѯ�û���Ϣ
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
		logger.fatal(existEm1.getUserName()+": "+existEm1.getUserId()+" �޸���"+userDetails.getUserName()+"���û���Ϣ");
		return "update";
	}
	public String delete() throws IOException{
		userDetails=userService.findById(userDetails.getUserId());
		userService.delete(userDetails);
		logger.fatal(existEm1.getUserName()+": "+existEm1.getUserId()+" ɾ����"+userDetails.getUserName()+"�û���Ϣ");
		addActionMessage("<script>alert('ѡ�γɹ���');</script>");
		return "delete";
	}
	//��ת�����ҳ��
	public String saveUI(){
		return "saveUI";
	}
	public String save(){
		userService.save(userDetails);
		logger.fatal(existEm1.getUserName()+": "+existEm1.getUserId()+" ����һ��"+userDetails.getUserName()+"�û���Ϣ");
		return "save";
	}
}
