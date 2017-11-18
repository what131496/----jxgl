package com.gsau.action;

import java.io.ByteArrayInputStream;
import com.gsau.entity.RandomNumUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CodeAction extends ActionSupport {
		/**
	 * 
	 */
	private static final long serialVersionUID = 7054341295900356767L;
		private ByteArrayInputStream inputStream; 
		public String execute() throws Exception{ 
		RandomNumUtil rdnu=RandomNumUtil.Instance(); 
		this.setInputStream(rdnu.getImage());//ȡ�ô�������ַ�����ͼƬ 
		ActionContext.getContext().getSession().put("random", rdnu.getString());//ȡ������ַ�������HttpSession 
		return SUCCESS; 
		} 
		public void setInputStream(ByteArrayInputStream inputStream) { 
		this.inputStream = inputStream; 
		} 
		public ByteArrayInputStream getInputStream() { 
		return inputStream; 
		} 
	}