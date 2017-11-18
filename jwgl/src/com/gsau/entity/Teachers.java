package com.gsau.entity;

import java.util.Date;

//老师类的bean
public class Teachers {
	private String teach_id;
	private String teach_name;
	private String teach_sex;
	private String dept_id;
	private Date teach_birth;
	private String teach_birthplace;
	private String teach_telephone;
	private String teach_email;
	private String teach_professional;//专业
	private String teach_research;//研究方向
	public String getTeach_id() {
		return teach_id;
	}
	public void setTeach_id(String teach_id) {
		this.teach_id = teach_id;
	}
	public String getTeach_name() {
		return teach_name;
	}
	public void setTeach_name(String teach_name) {
		this.teach_name = teach_name;
	}
	public String getTeach_sex() {
		return teach_sex;
	}
	public void setTeach_sex(String teach_sex) {
		this.teach_sex = teach_sex;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	
	public Date getTeach_birth() {
		return teach_birth;
	}
	public void setTeach_birth(Date teach_birth) {
		this.teach_birth = teach_birth;
	}
	public String getTeach_birthplace() {
		return teach_birthplace;
	}
	public void setTeach_birthplace(String teach_birthplace) {
		this.teach_birthplace = teach_birthplace;
	}
	public String getTeach_telephone() {
		return teach_telephone;
	}
	public void setTeach_telephone(String teach_telephone) {
		this.teach_telephone = teach_telephone;
	}
	public String getTeach_email() {
		return teach_email;
	}
	public void setTeach_email(String teach_email) {
		this.teach_email = teach_email;
	}
	public String getTeach_professional() {
		return teach_professional;
	}
	public void setTeach_professional(String teach_professional) {
		this.teach_professional = teach_professional;
	}
	public String getTeach_research() {
		return teach_research;
	}
	public void setTeach_research(String teach_research) {
		this.teach_research = teach_research;
	}
	
	
}
