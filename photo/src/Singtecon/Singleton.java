package Singtecon;

import java.io.Serializable;

public class Singleton implements Serializable{
	/**
	 * 	����ģʽ
	 *  1�����̷߳��ʵİ�ȫ����
	 *  2��volatile�ؼ��ֱ�֤������һ����
	 *  3����ֹ�������˽�й��췽��
	 *  4���õ�������Ա����л�
	 */
	
	/**
	 * volatile:
	 * vloatile�ؼ������ѱ���������ı������ܸı䣬��˱������ڴ洢���ȡ�������ʱ��
	 * 	����ֱ�Ӵ���������ĵ�ַ��ȡ���ݣ� ���û��volatile�ؼ��֣����������ܻ��Ż���ȡ�ʹ洢��
	 * 	������ʱʹ�üĴ����е�ֵ�������������ڱ�ĵط������ˣ�������ֲ�һ�µ�����-
	 */
	
	private volatile static Singleton singleton = null;
	
	private Singleton() {
		if(singleton != null) {
			throw new RuntimeException("�˶���Ϊ����ģʽ���Ѿ���ʵ������");
		}
	}
	
	public static Singleton getInstance() {
		if(singleton == null) {
			synchronized (Singleton.class) {
				if(singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
