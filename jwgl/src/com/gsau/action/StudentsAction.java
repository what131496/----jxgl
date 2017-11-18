package com.gsau.action;

import org.apache.log4j.Logger;

import com.gsau.entity.PageBean;
import com.gsau.entity.Students;
import com.gsau.entity.Teachers;
import com.gsau.entity.UserDetails;
import com.gsau.service.StudentsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentsAction extends ActionSupport implements ModelDriven<Students> {
	private Students students=new Students();
	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return students;
	}
	private StudentsService studentsService;
	public StudentsService getStudentsService() {
		return studentsService;
	}
	public void setStudentsService(StudentsService studentsService) {
		this.studentsService = studentsService;
	}
	String stu_id=(String) ActionContext.getContext().getSession().get("exitUser");
	//根据登录的用户名查询信息
	public String findById(){
		students=studentsService.findById(stu_id);
		return "findById";
	}
	public String find(){
		students=studentsService.find(stu_id);
		return "find";
	}
	//获取保存在session中的用户对象
	UserDetails existEm1=(UserDetails) ActionContext.getContext().getSession().get("exitUsers");
		//获取logger对象，打印输出日志文件
	Logger logger = Logger.getLogger(this.getClass());
	public String update(){
		studentsService.update(students);
		logger.fatal("使用者"+existEm1.getUserName()+": "+existEm1.getUserId()+" 修改了用户名为["+students.getStu_name()+"]的学生信息");
		return "update";
	}
	private int currPage=1;
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public String findAll(){
		PageBean<Students> students=studentsService.findAll(currPage);
		ActionContext.getContext().getValueStack().push(students);
		return "findAll";
	}
	public String edit(){
		students =studentsService.findById(students.getStu_id());
		return "edit";	
	}
	public String updateAll(){
		studentsService.update(students);
		return "updateAll";
	}

	public String saveUI(){
		return "saveUI";
	}
	public String save(){
		studentsService.save(students);
		logger.fatal("使用者"+existEm1.getUserName()+": "+existEm1.getUserId()+" 新增了用户名为["+students.getStu_name()+"]的学生信息");
		return "save";
	}
	public String delete(){
		students=studentsService.findById(students.getStu_id());
		studentsService.delete(students);
		logger.fatal("使用者"+existEm1.getUserName()+": "+existEm1.getUserId()+" 删除了用户名为[ "+students.getStu_name()+" ]的学生信息");
		return "delete";
	}
}
