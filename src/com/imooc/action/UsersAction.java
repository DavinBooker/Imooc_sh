package com.imooc.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.imooc.entity.Users;
import com.imooc.service.UserDAO;
import com.imooc.service.impl.UserDAOImpl;
import com.opensymphony.xwork2.ModelDriven;

public class UsersAction extends SpuerAction implements ModelDriven<Users> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user = new Users();

	// �û���¼������
	public String login() {
		UserDAO udao = new UserDAOImpl();
		if (udao.usersLogin(user)) {
			//��session�б�����¼�ɹ����û�����
			session.setAttribute("loginUserName",user.getUsername());
			return "login_success";
			
		} else {
			return "login_failure";
		}
	}
	@SkipValidation
	//�û�ע��
	public String logout(){
		if(session.getAttribute("loginUserName")!=null){
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	//����֤����
	@Override
	public void validate() {
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError","�û�������Ϊ��");
			
		}
		if(user.getPassword().length()<6){
			this.addFieldError("passwordError","���볤�Ȳ�����6λ");
		}
	}
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
