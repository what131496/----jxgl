package com.gsau.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gsau.dao.OutSchoolDao;
import com.gsau.entity.Out_School;
import com.gsau.service.OutSchoolService;
import com.gsau.utils.StudentsScore;

public class OutSchoolServiceImpl implements OutSchoolService {
	private OutSchoolDao outSchoolDao;

	public OutSchoolDao getOutSchoolDao() {
		return outSchoolDao;
	}

	public void setOutSchoolDao(OutSchoolDao outSchoolDao) {
		this.outSchoolDao = outSchoolDao;
	}

	@Override
	public void save(Out_School out) {
		outSchoolDao.save(out);
	}

	@Override
	public List findAll() {
		List list=outSchoolDao.findAll();
		List<Out_School> listc=new ArrayList();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				Object[] object = (Object[])list.get(i);
				int id=(int)object[0];
				String name=(String)object[1];
				String sex=(String)object[2];
				String phone=(String)object[3];
				String reason=(String) object[4];
				String place=(String) object[5];
				String your_phone=(String)object[6];
				String relationship =(String)object[7];
				String re_phone=(String) object[8];
				String leave_time=(String) object[9];
				String back_time=(String) object[10];
				Out_School out=new Out_School();
				out.setId(id);
				out.setName(name);
				out.setSex(sex);
				out.setPhone(phone);
				out.setReason(reason);
				out.setPlace(place);
				out.setYour_phone(your_phone);
				out.setRelationship(relationship);
				out.setRe_phone(re_phone);
				out.setLeave_time(leave_time);
				out.setBack_time(back_time);
				listc.add(out);
			}
		}
		return listc;
	}
	
}
