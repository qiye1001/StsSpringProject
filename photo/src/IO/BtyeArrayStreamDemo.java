package IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

// �ֽ��������������ڴ�������ڲ�ά����һ���ֽ����飬���ǿ����������Ķ�ȡ�����������ַ����� ����ر�

public class BtyeArrayStreamDemo {
	
	private static void byteArray() {
		String s = "fj89qjfo3q494rvg4w)^&*^g8g86t8";
		ByteArrayInputStream bais = new ByteArrayInputStream(s.getBytes());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int curr = -1;	// ÿ�ζ�ȡ���ֽ�
		while((curr = bais.read()) != -1) {
			if((curr >= 65 && curr <= 90) || (curr >= 97 && curr <= 122)) {
				baos.write(curr);
			}
		}
		
		System.out.println(baos.toString());
	}
	
	public static void main(String[] args) {
		byteArray();
	}
}
