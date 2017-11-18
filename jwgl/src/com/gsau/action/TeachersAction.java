package com.gsau.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.gsau.entity.PageBean;
import com.gsau.entity.Teachers;
import com.gsau.entity.UserDetails;
import com.gsau.service.TeachersService;
import com.gsau.utils.StudentsScore;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeachersAction extends ActionSupport implements ModelDriven<Teachers> {
	private Teachers teachers=new Teachers();

	@Override
	public Teachers getModel() {
		// TODO Auto-generated method stub
		return teachers;
	}
	private TeachersService teachersService;
	public TeachersService getTeachersService() {
		return teachersService;
	}
	public void setTeachersService(TeachersService teachersService) {
		this.teachersService = teachersService;
	}
	private String cour_id;
	
	public String getCour_id() {
		return cour_id;
	}
	public void setCour_id(String cour_id) {
		this.cour_id = cour_id;
	}
	String teach_id=(String) ActionContext.getContext().getSession().get("exitUser");
	//���ݵ�¼���û�����ѯ��Ϣ
	public String findById(){
		teachers=teachersService.findById(teach_id);
		return "findById";
	}
	public String find(){
		teachers=teachersService.find(teach_id);
		return "find";
	}
	//��ȡ������session�е��û�����
	UserDetails existEm1=(UserDetails) ActionContext.getContext().getSession().get("exitUsers");
	//��ȡlogger���󣬴�ӡ�����־�ļ�
	Logger logger = Logger.getLogger(this.getClass());
	public  String update(){
		teachersService.update(teachers);
		logger.fatal("ʹ����"+existEm1.getUserName()+": "+existEm1.getUserId()+" �޸����û���Ϊ"+teachers.getTeach_name()+"�Ľ�ʦ��Ϣ");
		return "update";
	}
	//��ҳ��ѯ�û���Ϣ
		private int currPage=1;
		
		public int getCurrPage() {
			return currPage;
		}
		public void setCurrPage(int currPage) {
			this.currPage = currPage;
		}
	public String findAll(){
		PageBean<Teachers> teachers=teachersService.findAll(currPage);
		ActionContext.getContext().getValueStack().push(teachers);
		return "findAll";
	}
	public String saveUI(){
		return "saveUI";
	}
	public String edit(){
		teachers =teachersService.findById(teachers.getTeach_id());
		return "edit";		
	}
	public String delete(){
		teachers=teachersService.findById(teachers.getTeach_id());
		teachersService.delete(teachers);
		logger.fatal("����Ա"+existEm1.getUserName()+": "+existEm1.getUserId()+" ɾ����"+teachers.getTeach_name()+"�Ľ�ʦ��Ϣ");
		return "delete";
	}
	public String save(){
		teachersService.save(teachers);
		logger.fatal(existEm1.getUserName()+": "+existEm1.getUserId()+" ��������"+teachers.getTeach_name()+"�Ľ�ʦ��Ϣ");
	    return "save";
	}
	public String updateAll(){
		teachersService.update(teachers);
		return "updateAll";
	}
	public String thisScore(){
		List listc=teachersService.thisScore(teach_id,cour_id);
		ActionContext.getContext().put("thisScore", listc);
		return "thisScore";
	}
	public String thisCourses(){
		List listc=teachersService.thisCourses(teach_id);
		ActionContext.getContext().put("thisCourses", listc);
		return "thisCourses";
	}
	public String addScore(){
		List listc=teachersService.thisScore(teach_id,cour_id);
		ActionContext.getContext().put("addScore", listc);
		return "addScore";
	}
	public String addScores(){
		List listc=teachersService.thisScore(teach_id,cour_id);
		ActionContext.getContext().put("addScores", listc);
		return "addScores";
	}
}
