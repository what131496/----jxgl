package com.gsau.dao.daoImpl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gsau.dao.ScoreDao;

public class ScoreDaoImpl extends HibernateDaoSupport implements ScoreDao {

	@Override
	public void save(String stu_id, String cour_id, double score) {
		System.out.println("获得参数为--------"+stu_id+cour_id+score);
		String sql="update course_score set score=? where stu_id=? and cour_id=?";
		this.getSession().createSQLQuery(sql).setString(1, stu_id).setString(2, cour_id).setDouble(0, score).executeUpdate();
		this.getSession().close();
	}

	@Override
	public void update(String[] stus, String[] cours, String[] scores) {
		for(int i=0;i<stus.length;i++){
			String sql="update course_score set score=? where stu_id=? and cour_id=?";
			this.getSession().createSQLQuery(sql).setString(1, stus[i]).setString(2, cours[i]).setString(0, scores[i]).executeUpdate();
			this.getSession().close();
		}
	}
}
