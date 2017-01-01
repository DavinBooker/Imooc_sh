package com.imooc.service;

import java.util.List;

import com.imooc.entity.Students;

public interface StudentsDAO {
	// ��ѯ����ѧ������
	public List<Students> queryAllStudents();

	// ����ѧ����Ų�ѯѧ������
	public Students queryStudentsBySid(String sid);

	// ���ѧ������
	public boolean addStudents(Students s);

	// ɾ��ѧ������
	public boolean deleteStudents(String sid);

	// �޸�ѧ������
	public boolean updateStudents(Students s);

}
