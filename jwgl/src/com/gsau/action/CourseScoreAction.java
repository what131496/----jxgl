package com.gsau.action;

import java.util.List;

import com.gsau.entity.Course_score;
import com.gsau.service.CourseScoreService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CourseScoreAction extends ActionSupport implements ModelDriven<Course_score> {
	private Course_score courseScore=new Course_score();
	@Override
	public Course_score getModel() {
		// TODO Auto-generated method stub
		return courseScore;
	}
	private CourseScoreService courseScoreService;

	public CourseScoreService getCourseScoreService() {
		return courseScoreService;
	}
	public void setCourseScoreService(CourseScoreService courseScoreService) {
		this.courseScoreService = courseScoreService;
	}
	//获取登录用户的id
	String stu_id=(String) ActionContext.getContext().getSession().get("exitUser");
	public String  select(){
		courseScoreService.select(stu_id,courseScore.getCour_id());
		return "select";
	}
	public String findScore(){
		List lists=courseScoreService.findScore(stu_id,courseScore.getCour_id());
		ActionContext.getContext().put("lists", lists);
		return "findSCore";
	}
	public String unselect(){
		courseScoreService.unselect(stu_id,courseScore.getCour_id());
		return "unselect";
	}
}
