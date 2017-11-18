package com.gsau.entity;

import java.io.Serializable;

public class Courses_arrange implements Serializable {
	private String  teach_id;
	private String  cour_id;
	private int lecture_time;
	public String getTeach_id() {
		return teach_id;
	}
	public void setTeach_id(String teach_id) {
		this.teach_id = teach_id;
	}
	public String getCour_id() {
		return cour_id;
	}
	public void setCour_id(String cour_id) {
		this.cour_id = cour_id;
	}
	public int getLecture_time() {
		return lecture_time;
	}
	public void setLecture_time(int lecture_time) {
		this.lecture_time = lecture_time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cour_id == null) ? 0 : cour_id.hashCode());
		result = prime * result + lecture_time;
		result = prime * result
				+ ((teach_id == null) ? 0 : teach_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Courses_arrange other = (Courses_arrange) obj;
		if (cour_id == null) {
			if (other.cour_id != null)
				return false;
		} else if (!cour_id.equals(other.cour_id))
			return false;
		if (lecture_time != other.lecture_time)
			return false;
		if (teach_id == null) {
			if (other.teach_id != null)
				return false;
		} else if (!teach_id.equals(other.teach_id))
			return false;
		return true;
	}
	
}
