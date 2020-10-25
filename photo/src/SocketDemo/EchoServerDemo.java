package SocketDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerDemo {
	public static void main(String[] args) {
		// ����һ����������Socket��1024 - 65535��
		try {
			ServerSocket server = new ServerSocket(6666);	// �˿ں�
			System.out.println("�����������������ڵȴ�����...");
			// �ȴ��ͻ����ӣ��������������ɹ����ӣ���������һ��Socket����
			Socket socket = server.accept();
			System.out.println("���������ӳɹ�"+socket.getInetAddress().getHostAddress());
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			// ͨ����������ȡ�������ݶ��� û�л�ȡ���� Ҳ���������
			String info = br.readLine();
			// ��ȡ������ ��ͻ��˷�����Ϣ
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println("echo:"+info);
			ps.flush();
			ps.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
