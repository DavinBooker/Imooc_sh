package com.imooc.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.imooc.entity.Students;
import com.imooc.service.StudentsDAO;
import com.imooc.service.impl.StudentsDAOimpl;


//ѧ����Action
public class StudentsAction extends SpuerAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//��ѯ����ѧ������
	public String query() {
		StudentsDAO sdao = new StudentsDAOimpl();
		List<Students> list = sdao.queryAllStudents();

		if (list != null && list.size() > 0) {
			session.setAttribute("students_list", list);
		}
		return "query_Success";
	}
	
	//ɾ��ѧ������
	public String delete(){
		StudentsDAO sdao = new StudentsDAOimpl();
		String sid =request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	//�޸�ѧ�����϶���
	public String  modify(){
		//��ô��ݹ�����ѧ�����
		String sid =request.getParameter("sid");
		StudentsDAO sdao = new StudentsDAOimpl();
		Students s = sdao.queryStudentsBySid(sid);
		//�����ڻỰ��
		session.setAttribute("modify_students", s);
		return "modify_seccess";
		
	}
	//���ѧ�����϶���
	public String add() throws Exception{
		Students s =new Students ();
//		s.setSid(sid);
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		s.setAddress(request.getParameter("address"));
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		StudentsDAO sdao =new StudentsDAOimpl();
		sdao.addStudents(s);
		return "add_success";
		
	}
	//�����޸ĺ��ѧ�����϶���
	public String save() throws Exception{
		Students s =new Students ();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		s.setAddress(request.getParameter("address"));
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		StudentsDAO sdao =new StudentsDAOimpl();
		sdao.updateStudents(s);
		return "save_success";
		
	}
}
