package com.gsau.entity;

import java.io.Serializable;

public class Course_score implements Serializable {
	private String stu_id;
	private String cour_id;
	private float score;
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getCour_id() {
		return cour_id;
	}
	public void setCour_id(String cour_id) {
		this.cour_id = cour_id;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cour_id == null) ? 0 : cour_id.hashCode());
		result = prime * result + Float.floatToIntBits(score);
		result = prime * result + ((stu_id == null) ? 0 : stu_id.hashCode());
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
		Course_score other = (Course_score) obj;
		if (cour_id == null) {
			if (other.cour_id != null)
				return false;
		} else if (!cour_id.equals(other.cour_id))
			return false;
		if (Float.floatToIntBits(score) != Float.floatToIntBits(other.score))
			return false;
		if (stu_id == null) {
			if (other.stu_id != null)
				return false;
		} else if (!stu_id.equals(other.stu_id))
			return false;
		return true;
	}
	
}
