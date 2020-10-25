package Regex;

import org.junit.Test;

public class RegexDemo {
	
	@Test
	public void test() {
		String phoneNumber = "010-38389438";
		boolean b = phoneNumber.matches("\\d{3,4}-\\d{7,8}");  // \d(����)  3~4λ     -(ԭ��)    \d(����) 7~8λ			
		System.out.println(b);
		
		// ƥ���ֻ�����
		String phone = "13812345674";
		System.out.println(phone.matches("[1][3-9]\\d{9}"));
		
		// �û����� ��ĸ��ͷ��������ĸ�»������
		String username = "abc123";
		System.out.println(username.matches("[a-zA-Z]+[\\w|_]*"));	//[a-zA-Z]��ĸ��ͷ    +(����һ�λ���)  \w(�����ַ� 0-9) |(��)  *(0�λ���)
		
		// ƥ��IP��ַ
		String IP = "20.10.20.123";
		System.out.println(IP.matches("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}"));
		
		// ƥ����ַ
		String address = "http://www.baidu.com";
		System.out.println(address.matches("http://\\w+.\\w.\\S*"));
		
		// ƥ������
		String age = "18";
		System.out.println(age.matches("\\d{1,3}"));
		
		// ƥ����
		String price = "19.8";
		System.out.println(price.matches("\\d+.\\d*"));
	}
}
