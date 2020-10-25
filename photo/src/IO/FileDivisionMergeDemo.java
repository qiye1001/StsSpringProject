package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class FileDivisionMergeDemo {

	private static void division(File targetFile, long cutSize) {
		if (targetFile == null)
			return;

		// ����ָ���ļ���
		int num = targetFile.length() % cutSize == 0 ? (int) (targetFile.length() / cutSize)
				: (int) (targetFile.length() / cutSize + 1);

		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(targetFile))) {

			BufferedOutputStream out = null;

			byte[] bytes = null; // ÿ�ζ�ȡ���ֽ���
			int count = 0; // ÿ���ļ���ȡ�Ĵ���
			int len = -1; // ÿ��ʵ�ʶ�ȡ�Ĵ���
			int defaultSize = 1024 * 1024;

			// ѭ������Ϊ���ɵ��ļ�����
			for (int i = 0; i < num; i++) {
				out = new BufferedOutputStream(
						new FileOutputStream(new File("G:\\temp\\" + (i + 1) + targetFile.getName())));

				if (cutSize <= defaultSize) {
					bytes = new byte[(int) cutSize];
					count = 1;
				} else {
					bytes = new byte[defaultSize];
					count = (int) cutSize / defaultSize;
				}

				// ��ȡ�ֽڵ�����Ҫ�ź��� �����ǰ�� ѭ������ʱ����һ��
				while (count > 0 && (len = in.read(bytes)) != -1) {
					out.write(bytes, 0, len);
					out.flush();
					count--;
				}

				// ����ÿ���ļ���С����defaultSize������ �����Ƿ��ٶ�ȡһ��
				if (cutSize % defaultSize != 0) {
					bytes = new byte[(int) cutSize % defaultSize];
					len = in.read(bytes);
					out.write(bytes, 0, len);
					out.flush();
					out.close();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void merge(Enumeration<InputStream> es) {
		// ����һ���ϲ���
		SequenceInputStream sis = new SequenceInputStream(es);
		try {
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream("G:\\temp\\Java���ļ��� ��I ����֪ʶ��ԭ���10�棩(2).pdf"));

			byte[] bytes = new byte[1024 * 1024];
			int len = -1;
			while((len = sis.read(bytes)) != -1) {
				bos.write(bytes, 0, len);
				bos.flush();
			}
			bos.close();
			sis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		division(new File("G:\\temp\\Java���ļ��� ��I ����֪ʶ��ԭ���10�棩.pdf"), 1024 * 1024 * 50);

		try {
			InputStream file1 = new FileInputStream(new File("G:\\temp\\1Java���ļ��� ��I ����֪ʶ��ԭ���10�棩.pdf"));
			InputStream file2 = new FileInputStream(new File("G:\\temp\\2Java���ļ��� ��I ����֪ʶ��ԭ���10�棩.pdf"));
			InputStream file3 = new FileInputStream(new File("G:\\temp\\3Java���ļ��� ��I ����֪ʶ��ԭ���10�棩.pdf"));
			InputStream file4 = new FileInputStream(new File("G:\\temp\\4Java���ļ��� ��I ����֪ʶ��ԭ���10�棩.pdf"));

			// ���Ϲ����࣬ �ڲ�ʵ��ʹ��������
			Vector<InputStream> v = new Vector<InputStream>();
			v.add(file1);
			v.add(file2);
			v.add(file3);
			v.add(file4);

			Enumeration<InputStream> es = v.elements();
			merge(es);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
