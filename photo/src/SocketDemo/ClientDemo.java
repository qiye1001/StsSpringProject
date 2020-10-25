package SocketDemo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientDemo {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 7777);
			ExecutorService es = Executors.newSingleThreadExecutor();
			System.out.println("���������ӳɹ�");
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			// ����������͵�¼��Ϣ
			Scanner sc = new Scanner(System.in);
			System.out.println("������������");
			String name = sc.nextLine();
			Message msg = new Message(name, "", "", MessageType.TYPE_LOGIN);
			oos.writeObject(msg);
			msg = (Message) ois.readObject();
			System.out.println(msg.getFrom() + msg.getInfo());
			// ������ȡ��Ϣ���߳�
			es.execute(new ReadInfoThread(ois));
			
			// ʹ�����߳���������Ϣ
			boolean flag = true;
			while (flag) {
				msg = new Message("", "", "", MessageType.TYPE_SEND);
				msg.setFrom(name);
				msg.setType(MessageType.TYPE_SEND);
				System.out.println("to:");
				String to = sc.nextLine();
				msg.setTo(to);
				System.out.println("info:");
				msg.setInfo(sc.nextLine());
				oos.writeObject(msg);
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class ReadInfoThread implements Runnable {
	ObjectInputStream ois;
	boolean flag = true;

	public ReadInfoThread(ObjectInputStream ois) {
		this.ois = ois;
	}

	public ReadInfoThread(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		try {
			while (flag) {
				Message msg = (Message) ois.readObject();
				System.out.println("[" + msg.getFrom() + "]:" + msg.getInfo());
			}
			if (ois != null) {
				ois.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}