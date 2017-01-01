package com.imooc.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class SpuerAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected HttpServletResponse response;//��Ӧ����
	protected HttpServletRequest request;//�������
	protected ServletContext application;//ȫ�ֶ���;
	protected HttpSession session;//�Ự����
	@Override
	public void setServletContext(ServletContext application) {
		// TODO Auto-generated method stub
		this.application=application;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
		this.session=this.request.getSession();
	}

}
