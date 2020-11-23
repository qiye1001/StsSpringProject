package com.qiye.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAround implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Object result = null;
		try {
			
			System.out.println("��[[����֪ͨ]]ʵ�ֵ�ǰ��֪ͨ");
			
			// invocation.proceed() ֮ǰ����ǰ��֪ͨ
			result = invocation.proceed();	// ������Ŀ�귽����ִ�� ����ֵΪ�����ķ���ֵ
			// invocation.proceed() ֮����Ǻ���֪ͨ
			 
			System.out.println("��[[����֪ͨ]]ʵ�ֵĺ���֪ͨ  Ŀ�����"+invocation.getThis()+", ���õķ�����"+invocation.getMethod()+", �����Ĳ���������"+invocation.getArguments().length+", �����ķ���ֵ��"+result);
			
		}catch(Exception e){
			// �쳣֪ͨ
			System.out.println("��[[����֪ͨ]]ʵ�ֵ��쳣֪ͨ");
		} finally{
			// ����֪ͨ
			System.out.println("��[[����֪ͨ]]ʵ�ֵ�����֪ͨ");
		};
		
		return result;
	}

}
