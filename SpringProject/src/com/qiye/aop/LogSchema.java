package com.qiye.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogSchema {

	// ǰ��֪ͨ
	public void before(JoinPoint jp) {
		System.out.println("��������ǰ��֪ͨ");
	}
	
	// ����֪ͨ
	public void after(JoinPoint jp, Object returningValue) {
		System.out.println("������������֪ͨ");
	}
	
	// �쳣֪ͨ
	public void wenException(JoinPoint jp, NullPointerException e) {
		System.out.println("�������� �쳣֪ͨ");
	}
	
	// ����֪ͨ
	public Object around(ProceedingJoinPoint jp) {
		Object result = null;
		try {
			System.out.println("�������� ����֪ͨʵ�ֵ�ǰ��֪ͨ");
			result = jp.proceed();
			System.out.println("�������� ����֪ͨʵ�ֵĺ���֪ͨ");
		} catch (Throwable e) {
			System.out.println("�������� ����֪ͨʵ�ֵ��쳣֪ͨ");
		}  finally {
			System.out.println("�������� ����֪ͨʵ�ֵ�����֪ͨ");
		}
		return result;
	}
}
