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

		// �������ö���
		Configuration config = new Configuration().configure();
		// ��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		// �����Ự��������
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		// �����Ự����
		Session session = sessionFactory.openSession();
		//����SchemaEcport����
		SchemaExport export=new SchemaExport(config);
		//��һ��true�����ɱ�ṹ���ڶ���true���ڿ���̨���SQL���
		export.create(true,true);
	}
}
