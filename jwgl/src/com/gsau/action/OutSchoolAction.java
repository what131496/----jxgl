package com.gsau.action;

import java.util.List;

import com.gsau.entity.Out_School;
import com.gsau.service.OutSchoolService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OutSchoolAction extends ActionSupport implements ModelDriven<Out_School> {
	private Out_School out=new Out_School();
	@Override
	public Out_School getModel() {
		// TODO Auto-generated method stub
		return out;
	}
	private OutSchoolService outSchoolService;
	public OutSchoolService getOutSchoolService() {
		return outSchoolService;
	}
	public void setOutSchoolService(OutSchoolService outSchoolService) {
		this.outSchoolService = outSchoolService;
	}
	public String save(){
		outSchoolService.save(out);
		return "save";
	}
	public String findAll(){
		List list=outSchoolService.findAll();
		ActionContext.getContext().put("listc", list);
		return "findAll";
	}
}
