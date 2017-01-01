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

	// 用户登录动作；
	public String login() {
		UserDAO udao = new UserDAOImpl();
		if (udao.usersLogin(user)) {
			//在session中保留登录成功的用户名；
			session.setAttribute("loginUserName",user.getUsername());
			return "login_success";
			
		} else {
			return "login_failure";
		}
	}
	@SkipValidation
	//用户注销
	public String logout(){
		if(session.getAttribute("loginUserName")!=null){
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	//表单验证功能
	@Override
	public void validate() {
		if("".equals(user.getUsername().trim())){
			this.addFieldError("usernameError","用户名不能为空");
			
		}
		if(user.getPassword().length()<6){
			this.addFieldError("passwordError","密码长度不少于6位");
		}
	}
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
