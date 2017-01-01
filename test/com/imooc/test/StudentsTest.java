package com.imooc.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.imooc.entity.Students;

public class StudentsTest {

	@Test
	public void testSchemaExport() {

		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		// 创建会话工厂对象
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		// 创建会话对象
		Session session = sessionFactory.openSession();
		//创建SchemaEcport对象
		SchemaExport export=new SchemaExport(config);
		//第一个true是生成表结构，第二个true是在控制台输出SQL语句
		export.create(true,true);
	}
}
