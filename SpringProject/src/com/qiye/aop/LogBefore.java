package com.qiye.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

// ��ͨ�� --> ǰ��֪ͨ
public class LogBefore implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("ǰ��֪ͨ  ���õķ�������"+arg0.getName()+", �����Ĳ�������: "+arg1.length+", Ŀ�����"+arg2);
		
	}
	
}
