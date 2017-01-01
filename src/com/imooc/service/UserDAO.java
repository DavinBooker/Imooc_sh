package com.imooc.service;

import com.imooc.entity.Users;

//用户业务逻辑接口
public interface UserDAO {
	//用户登录方法
	public boolean usersLogin(Users u);
	
}
