package com.qiye.dao.impl;

import org.springframework.stereotype.Component;

import com.qiye.dao.IStudentDao;
import com.qiye.entry.Student;


@Component("studentDao")	// ��ͬ��<bean id="studentDao" class="com.qiye.dao.StudentDaoImpl"></bean>
public class StudentDaoImpl implements IStudentDao{
	
	@Override
	public void addStudent(Student stu) {
		System.out.println("����ѧ��");
	}

	@Override
	public void deleteStudentById(int id) {
		System.out.println("ɾ��ѧ��");
	}
}
