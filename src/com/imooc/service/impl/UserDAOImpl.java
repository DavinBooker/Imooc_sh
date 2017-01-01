package com.imooc.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.imooc.service.UserDAO;

import com.imooc.db.MyhibernateSessionFactory;
import com.imooc.entity.Users;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean usersLogin(Users u) {
		// TODO Auto-generated method stub
		// 事物对象
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyhibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx =session.beginTransaction();
			hql = "from Users where username=? and password=? ";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list = query.list();
			tx.commit(); //提交事物；
			if (list.size() > 0) {
				return true;

			} else {
				return false;

			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (tx != null) {
//				tx.commit();
				tx = null;
			}
		}
		
	}

}
