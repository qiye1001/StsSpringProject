package fishDemo2;

import javax.swing.JFrame;
public class Ball_JF extends JFrame {
	public Ball_JF(){
		this.setTitle("�߼�����ͼ");       
		this.setBounds(100,100,800,600);        //�����С
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //�رմ���ֹͣ����
		Ball_JP jp=new Ball_JP();
		jp.run_run();       //��ʼ���ж��߳�
		this.add(jp);       //������ӵ�����
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ball_JF();
 
	}
 
}