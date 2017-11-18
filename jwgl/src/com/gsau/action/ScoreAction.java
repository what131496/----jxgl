package com.gsau.action;

import java.rmi.server.ExportException;

import com.gsau.entity.Students;
import com.gsau.service.ScoreService;
import com.gsau.service.StudentsService;
import com.gsau.utils.StudentsScore;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ScoreAction extends ActionSupport implements ModelDriven<StudentsScore>{
	private StudentsScore grade=new StudentsScore();

	@Override
	public StudentsScore getModel() {
		// TODO Auto-generated method stub
		return grade;
	}
	private ScoreService scoreService;
	public ScoreService getScoreService() {
		return scoreService;
	}
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	public String edit(){
		
		return "edit";
	}
	public String save(){
		scoreService.save(grade.getStu_id(),grade.getCour_id(),grade.getScore());
		return "save";
	}
	public String update(){
		String[] stus=grade.getStu_id().split(", ");
		String[] cours=grade.getCour_id().split(", ");
		String[] scores=grade.getScored().split(", ");
		for(int i=0;i<stus.length;i++){
			System.out.println("获取的值为--------"+scores[i]);
		}
		scoreService.update(stus,cours,scores);
		return "update";
	}
	public String excel(){
		return "";
	}
}
