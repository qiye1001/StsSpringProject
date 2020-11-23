package com.qiye.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfter implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("����֪ͨ ����ֵ��"+arg0+", ���õķ�������"+arg1.getName()+", �����Ĳ�������: "+arg2.length+", Ŀ�����"+arg3);
	}
}
