package photo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
	public static void main(String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		try {
			Socket socket = new Socket("localhost", 9999);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			// ��¼ ע��
			Scanner sc = new Scanner(System.in);
			System.out.println("�������˺�");
			Message message = new Message(sc.nextLine(), "", "", MessageType.login);
			System.out.println(message.getInfoType());
			oos.flush();
			oos.writeObject(message);
			
			message = (Message)ois.readObject();
			System.out.println(message.getInfo());
			
			// ������Ϣ
			newFixedThreadPool.execute(new Show(ois));
			
			// ������Ϣ
			newFixedThreadPool.execute(new SignIn(message, oos));
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}


class SignIn implements Runnable{
	Scanner sc;
	Message message;
	ObjectOutputStream oos;
	public SignIn(Message message, ObjectOutputStream oos) {
		sc = new Scanner(System.in);
		this.message = new Message(message.getFrom(), "", "", MessageType.send);
		this.oos = oos;
	}

	@Override
	public void run() {
		while(true) {
			System.out.println("to:");
			message.setTo(sc.nextLine());
			System.out.println("info:");
			message.setInfo(sc.nextLine());
			try {
				oos.writeObject(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}


class Show implements Runnable{
	boolean flag = true;
	ObjectInputStream ois;
	
	public Show(ObjectInputStream ois) {
		this.ois = ois;
	}

	@Override
	public void run() {
		Message message;
		try {
			while(flag) {
				message = (Message)ois.readObject();
				System.out.println("["+message.getFrom()+"->" + message.getTo()+"]:"+message.getInfo());
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}