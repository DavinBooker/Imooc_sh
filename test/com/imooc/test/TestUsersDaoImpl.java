package com.imooc.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.imooc.entity.Users;
import com.imooc.service.UserDAO;
import com.imooc.service.impl.UserDAOImpl;


public class TestUsersDaoImpl {

	@Test
	public void testUsersLogin() {
       Users u=new Users(1,"zhangsan","123456");
	   UserDAO udao=new UserDAOImpl();
       Assert.assertEquals(true, udao.usersLogin(u));
	}

}
