  package com.qiye.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class LogException implements ThrowsAdvice{
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
		System.out.println("�쳣֪ͨ Ŀ�����"+target+"����������"+method.getName()+", ����������"+args.length+", �쳣���ͣ�"+ex.getMessage());
	}
}
