package fishDemo2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;
 
public class Ball_JP extends JPanel implements MouseMotionListener{      //ʵ�ּ������Ľӿ�
	List<Ball> balls =new ArrayList<Ball>();         //������е���
	public Ball_JP(){
		addMouseMotionListener(this);         //��Ӽ���
		for(int i=0;i<50;i++)
			add_ball();
	}
	
	void add_ball(){                      //�����������ĳ�ʼ����,��С,������ɫ��
		int x=(int) (Math.random()*700);
		int y=(int) (Math.random()*500);
		int dir=(int) (Math.random()*4);
		int d=(int) (Math.random()*30);
		int r=(int) (Math.random()*255);
		int g=(int) (Math.random()*255);
		int b=(int) (Math.random()*255);
		int sp=(int) (Math.random()*1+1);
		Color col=new Color(r,g,b);
		balls.add(new Ball(x,y,dir,d,sp,col));
	}
	public void paint(Graphics g) {
		
		super.paint(g);
		setBackground(Color.white);                 //����this ���û����ı�����ɫ
		for(int i=0;i<balls.size();i++){            //�����е��㻭����
			Ball b=balls.get(i);
			b.Draw(g);
		}
	}
	
	public void run_run(){
		new Thread(){
			public void run(){
				while(true){
					for(int i=1;i<balls.size();i++){               //�������˶�һ��
						Ball b=balls.get(i);
						b.move();
					}
					for(int i=0;i<balls.size()-1;i++){           //����forѭ���ж�����С���Ƿ���ײ
						Ball b1=balls.get(i);
						for(int j=i+1;j<balls.size();j++){
							Ball b2=balls.get(j);
						BallandBall bab=new BallandBall();
							if(bab.balldestroy(b1, b2)==1){        //������
								if(b1.d>=b2.d){
									b1.d+=b2.d/4;
									balls.remove(j);
									break;
								}
								else if(b1.d<b2.d){
									b2.d+=b1.d/4;
									balls.remove(i);
									break;
								}
							}
							
						}
					}
					repaint();                        //�ٴε���paint()
					try {
						Thread.sleep(30);            //����
					} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			}
		}.start();
	}
 
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		Ball mb=balls.get(0);              //͵����     ���Ƶ�ֻ�ǵ�0��С��
		mb.x=e.getX()-mb.d/2;              //�����������
		mb.y=e.getY()-mb.d/2;
	}
}
