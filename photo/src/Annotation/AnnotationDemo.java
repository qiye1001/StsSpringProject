package Annotation;

import org.junit.Test;

public class AnnotationDemo {
	
	@Test
	public void test() {
		Class<Cat> cats =  Cat.class;
		// ��ȡ����Ӧ�õ�ָ��ע��
		MyAnnotation annotation = cats.getAnnotation(MyAnnotation.class);
		int age = annotation.age();
		Color color = annotation.color();
		String name = annotation.name();
		String[] like = annotation.like();
		
		try {
			Cat cat = cats.newInstance();
			cat.setAge(age);
			cat.setColor(color);
			cat.setName(name);
			cat.setLike(like);
			System.out.println(cat);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
