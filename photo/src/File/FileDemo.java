package File;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

public class FileDemo {
	public static void main(String[] args) {
		File file1 = new File("G:" + File.separator + "�½��ļ��� (4)\\������/image");
		if (file1.isDirectory()) { // �жϸ��ļ��Ƿ�ΪĿ¼

			// �г���ǰĿ¼�µ������ļ���
			String[] names = file1.list();
//			System.out.println(Arrays.toString(names));

			// �г���ǰĿ¼�µ������ļ�
			File[] fs = file1.listFiles();
			for (File f : fs) {
//				System.out.println("����·����" + f.getAbsolutePath());
//				System.out.println("���·����" + f.getPath());
//				System.out.println("�Ƿ�Ϊ�����ļ���" + f.isHidden());
//				System.out.println("�ļ����ȣ���С���ֽڣ�����" + f.length());
//				System.out.println("�Ƿ�Ϊ�ɶ��ļ���" + f.canRead());
//				System.out.println("�ļ�����޸�ʱ�䣺" + f.lastModified());
			}

			File file2 = new File("G:" + File.separator + "�½��ļ��� (4)\\������/image/01.jpg");
			// �ж��ļ��Ƿ����
			if (file2.exists()) {
//				try {
//					file2.createNewFile();
//					System.out.println("�ļ������ɹ�");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				file2.listFiles(new FileFilter() {
//					
//					@Override
//					public boolean accept(File pathname) {
//						return false;
//					}
//				});
				File[] fs2 = file2.listFiles((pathName) -> pathName.getName().endsWith(".png"));
//				
				if (fs2 != null) {
					for (File f2 : fs2) {
						// if(f2.length() < 9000) {
						// f2.delete();
						// }
						// System.out.println(f2.getAbsoluteFile());

						System.out.println(f2);

						// if(f2.getName().endsWith(".txt")) {
						// String[] s = (""+f2.getAbsoluteFile()).split("\\." ,2);
						// f2.renameTo(new File(s[0]+".jpg"));
						// };

					}
				}
			}

			File file3 = new File("G:" + File.separator + "�½��ļ��� (4)" + File.separator + "������" + "\\web/test.txt");
			if (file3.exists()) {
//				boolean f = file3.mkdirs();
//				System.out.println(f);

//				file3.mkdirs();
				boolean f = file3.renameTo(new File(String.valueOf(file3.getAbsoluteFile())));
				System.out.println(f);

				if (file3.isDirectory()) {
					try {
						System.out.println(file3.getAbsoluteFile() + File.separator);
						boolean s = new File(file3.getAbsoluteFile() + File.separator + "�½��ļ�����.txt").createNewFile();
						System.out.println(s);

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
