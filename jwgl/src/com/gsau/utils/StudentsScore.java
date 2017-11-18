package com.gsau.utils;

import java.util.Date;

public class StudentsScore {
	private String stu_id;
	private String stu_name;
	private String stu_sex;
	private Date stu_birth;
	private String stu_birthplace;
	private String stu_email;
	private String stu_telephone;
	private String cour_id;
	private String cour_name;
	private int cour_hour;
	private int semester;
	private int credit;
	private int type;
	private double score;
	private String scored;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}
	public Date getStu_birth() {
		return stu_birth;
	}
	public void setStu_birth(Date stu_birth) {
		this.stu_birth = stu_birth;
	}
	public String getStu_birthplace() {
		return stu_birthplace;
	}
	public void setStu_birthplace(String stu_birthplace) {
		this.stu_birthplace = stu_birthplace;
	}
	public String getStu_email() {
		return stu_email;
	}
	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}
	public String getStu_telephone() {
		return stu_telephone;
	}
	public void setStu_telephone(String stu_telephone) {
		this.stu_telephone = stu_telephone;
	}
	public String getCour_id() {
		return cour_id;
	}
	public void setCour_id(String cour_id) {
		this.cour_id = cour_id;
	}
	public String getCour_name() {
		return cour_name;
	}
	public void setCour_name(String cour_name) {
		this.cour_name = cour_name;
	}
	public int getCour_hour() {
		return cour_hour;
	}
	public void setCour_hour(int cour_hour) {
		this.cour_hour = cour_hour;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getScored() {
		return scored;
	}
	public void setScored(String scored) {
		this.scored = scored;
	}
	
}
