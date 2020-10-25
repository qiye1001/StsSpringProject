package Mina;

import java.net.InetSocketAddress;
import java.util.Scanner;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class Client {
	public static void main(String[] args) {
		// ����NioSocketConnector���ӷ���˲���������
		NioSocketConnector connector = new NioSocketConnector();
		// ����һ��������
		DefaultIoFilterChainBuilder chain = connector.getFilterChain();
		// ����һ��������
//		chain.addLast("myChain", new ProtocolCodecFilter(new TextLineCodecFactory()));
		// ���ù������Զ���Ϊ��λ��ȡ����
		chain.addLast("ojectChain", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
		// ������Ϣ������
		connector.setHandler(new MinaClientHandler());
		
		// ���ӷ�����
		ConnectFuture cf = connector.connect(new InetSocketAddress("localhost", 9999));
		cf.awaitUninterruptibly();	// �ȴ����ӳɹ�
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
//			System.out.println("������:");
//			String info = sc.nextLine();
//			cf.getSession().write(info);
			
			Message msg = new Message();
			System.out.println("form:");
			String form  = sc.nextLine();
			msg.setFrom(form);
			System.out.println("to:");
			String to = sc.nextLine();
			msg.setTo(to);
			System.out.println("info:");
			String info = sc.nextLine();
			msg.setInfo(info);
			
			msg.setType("send");
			cf.getSession().write(msg);
		}
		
		// �ȴ����������ӹر� ����������
//		cf.getSession().getCloseFuture().awaitUninterruptibly(); 
//		connector.dispose();
	}
}
