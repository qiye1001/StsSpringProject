package com.qiye.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("logAnnocation")
@Aspect	// ����������һ��֪ͨ
public class LogAspectAnnotation {
	
	// ǰ��֪ͨ
	@Before("execution(public * addStudent(com.qiye.entry.Student))") // ֻҪ�Ƿ���ΪaddStudent ��������ΪString ����ֵΪ�������͵������ͻᴥ��֪ͨ
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("<<ע����ʽ>> ǰ��֪ͨ Ŀ�����"+joinPoint.getTarget()+", ���õķ�����"+joinPoint.getSignature().getName()+", �����б�"+Arrays.toString(joinPoint.getArgs()));
	}
	
	// ����֪ͨ
	@AfterReturning(returning = "returningValue", pointcut = "execution(public void com.qiye.service.impl.StudentServiceImpl.addStudent(com.qiye.entry.Student))") // ָ����StudentServiceImpl��addStudent����
	public void myAfter(JoinPoint joinPoint, Object returningValue) {
		System.out.println("<<ע����ʽ>> ����֪ͨ ����ֵ��"+returningValue+" Ŀ�����"+joinPoint.getTarget()+", ���õķ�����"+joinPoint.getSignature().getName()+", �����б�"+Arrays.toString(joinPoint.getArgs()));

	}
	
	// �쳣֪ͨ
	@AfterThrowing(pointcut = "execution(public * addStudent(..))",throwing = "e")
	public void myException(JoinPoint jp, NullPointerException e) {	// ָ���쳣����(��ָ���쳣) ���ܴ���֪ͨ
		System.out.println("<<ע����ʽ>> �쳣֪ͨ ");
	}
	
	// ����֪ͨ
	@Around("execution(public * addStudent(com.qiye.entry.Student))")
	public Object myAround(ProceedingJoinPoint jp) {
		Object result = null;
		try {
			System.out.println("<<ע����ʽ>> ����֪ͨ ʵ�� ǰ��֪ͨ");
			result = jp.proceed();
			System.out.println("<<ע����ʽ>> ����֪ͨ ʵ�� ����֪ͨ");
		} catch (Throwable e) {
			System.out.println("<<ע����ʽ>> ����֪ͨ ʵ�� �쳣֪ͨ");
		} finally {
			System.out.println("<<ע����ʽ>> ����֪ͨ ʵ�� ����֪ͨ");
		}
		return "abc";
	}
	
	// ����֪ͨ
	@After("execution(public * addStudent(com.qiye.entry.Student))")
	public void myFinally() {
		System.out.println("<<ע����ʽ>> ����֪ͨ");
	}
}
