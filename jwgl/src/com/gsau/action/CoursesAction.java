package com.gsau.action;

import java.util.List;

import com.gsau.entity.Courses;
import com.gsau.entity.PageBean;
import com.gsau.entity.Students;
import com.gsau.entity.Teachers;
import com.gsau.service.CoursesService;
import com.gsau.service.StudentsService;
import com.gsau.utils.SelectCourse;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CoursesAction extends ActionSupport implements ModelDriven<Courses> {
	private Courses courses=new Courses();
	private Students students=new Students();
	@Override
	public Courses getModel() {
		// TODO Auto-generated method stub
		return courses;
	}
	private CoursesService courseService;
	private StudentsService studentsService;
	public CoursesService getCourseService() {
		return courseService;
	}
	public void setCourseService(CoursesService courseService) {
		this.courseService = courseService;
	}
	
	public StudentsService getStudentsService() {
		return studentsService;
	}
	public void setStudentsService(StudentsService studentsService) {
		this.studentsService = studentsService;
	}
	//分页查询课程信息
	private int currPage=1;
			
	public int getCurrPage() {
	return currPage;
	}
	public void setCurrPage(int currPage) {
	this.currPage = currPage;
	}
	private int lecture_time;
	public int getLecture_time() {
		return lecture_time;
	}
	public void setLecture_time(int lecture_time) {
		this.lecture_time = lecture_time;
	}
	public String findAll(){
		PageBean<Courses> coursesPage=courseService.findAll(currPage);
		ActionContext.getContext().getValueStack().push(coursesPage);
		return "findAll";
	}
	public String findTotal(){
		List<Courses> listc=courseService.findTotal();
		ActionContext.getContext().put("list", listc);
		return "findTotal";
	}
	//获取登陆的当前用户的id
	String stu_id=(String) ActionContext.getContext().getSession().get("exitUser");
	public String select(){
		courseService.select(courses.getCour_id(),stu_id);
		return "select";
	}
	public String findSelect(){
		List listc=courseService.findSelect(stu_id);
/*		ActionContext.getContext().getValueStack().push(listc);
*/		ActionContext.getContext().put("listc", listc);
		return "findSelect";
	}
	public String findScore(){
		students=studentsService.find(stu_id);
		ActionContext.getContext().put("students", students);
		System.out.println(students);
		List listc=courseService.findSelect(stu_id);
/*		ActionContext.getContext().getValueStack().push(listc);
*/		ActionContext.getContext().put("listc", listc);
		return "findScore";
	}
	public String add(){
		courseService.add(courses,lecture_time);
		return "add";
	}
	public String verify(){
		List<Courses> listc=courseService.verify();
		ActionContext.getContext().put("list", listc);
		return "verify";
	}
	public String verifySuccess(){
		courseService.verifySuccess(courses.getCour_id());
		return "verifySuccess";
	}
	public String modify(){
		courses=courseService.finbById(courses.getCour_id());
		return "modify";
	}
	public String update(){
		courseService.update(courses);
		return "update";
	}
	public String delete(){
		courses=courseService.finbById(courses.getCour_id());
		courseService.delete(courses);
		return "delete";
	}
	public String findByTeacher(){
		List<Courses> listc=courseService.findByTeacher(stu_id);
		ActionContext.getContext().put("listc",listc );
		return "findByTeacher";
		}
}
