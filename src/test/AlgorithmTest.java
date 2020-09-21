
package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


class Poin{
	int x;
	int y;
	
	public Poin(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Panel1 extends JPanel{
	private JButton jbutton1;
	private JButton jbuttonExit;
	private MFrame frame;
	public static Poin[] pArr = new Poin[1000];
	static public int[] aRR;

	
	public static boolean[] visited = new boolean[1000];
	public static int[][] indexN;
	
	int x, y;
	static int i=0;
	static int count;
	static boolean flag;
	
	public Panel1(MFrame frame) {
		this.frame = frame;
		
		addMouseListener(new MouseAdapter( ) {
			public void mousePressed(MouseEvent e) {
				System.out.println("mousepressed");
				x=e.getX();
				y=e.getY(); //���콺�� ��ġ�� ����Ѵ�
				System.out.println("x��ǥ :" + x + " " +
				"Y��ǥ : " + y);
				
				flag = true;
				
				pArr[i++] = new Poin(x,y);
				count++;

				repaint();
			}
		});

		jbutton1 = new JButton("CLICK");
		jbutton1.setSize(100,30);
		add(jbutton1);
		jbuttonExit = new JButton("EXIT");
		jbuttonExit.setSize(100,30);
		add(jbuttonExit);
		
		jbutton1.addActionListener(new MyActionListener());
		
		
		
		jbuttonExit.addActionListener(new MyActionListenerExit());
	
		

	}
	
	public void paint(Graphics g) {
		
		System.err.println("paint ȣ��");
		
		if(flag) {
			g.fillOval(x, y, 4, 4);
		}
	}
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			indexN = new int[1000000][Panel1.count]; //index ���� ���� 2���� �迭
			
			aRR = new int[count];
			for(int j=0; j<Panel1.count; j++) {
				aRR[j] = j; 
				System.err.println("81��");
			}
			
			Panel2.perm(aRR, Panel2.output, Panel1.visited, 0, Panel1.count, Panel1.count); 
			System.err.println("Panel2.outputN   " + Panel2.outputN );
			frame.change("panel2");
		}
		
	}
	class MyActionListenerExit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(1);
		}
		
	}
}



//class Panel2 start

class Panel2 extends JPanel {
	private JButton jbutton2;
	private JButton jbuttonExit;
	private JButton jbutton3;
	private MFrame frame;
	static int outputN=0;
	int number=0;
	int ccound =0;
	
	
  
	static public int[] output = new int[1000];
	
	
	public Panel2(MFrame frame) {
	
		this.frame = frame;
		
		jbutton2 = new JButton("Next");
		jbutton2.setSize(100,30);
		add(jbutton2);
		
		jbutton2.addActionListener(new MyActionListener());
		
		jbutton3 = new JButton("New Game");
		jbutton3.setSize(100,30);
		add(jbutton3);
		jbutton3.addActionListener(new MyActionListener2());
		
		jbuttonExit = new JButton("EXIT");
		jbuttonExit.setSize(100,30);
		add(jbuttonExit);
		jbuttonExit.addActionListener(new MyActionListenerExit());
		
		
	}
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
		
	}
	class MyActionListener2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Panel1.count =0;
			Panel1.flag = false;
			Panel1.i = 0;
			number = 0;
			ccound = 0;
			outputN = 0;
			frame.change("panel1");
		}
		
	}
	
	class MyActionListenerExit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(1);
		}
		
	}
	


	public void paint(Graphics g) {
		super.paint(g);
		
		System.err.println("paint2 ȣ��");
		
		if(number<=outputN) {
		
			if(Panel1.count<=3) {
				for(int i=0; i<Panel1.count-1; i++) {
					
					g.drawLine(Panel1.pArr[Panel1.indexN[number][i]].x,Panel1.pArr[Panel1.indexN[number][i]].y,
							Panel1.pArr[Panel1.indexN[number][i+1]].x,Panel1.pArr[Panel1.indexN[number][i+1]].y);
					
				
				}
				number++;
				return;
			}
		
			if(isIntersect(Panel1.pArr,number) == false) {
				for(int i=0; i<Panel1.count-1; i++) {
						g.drawLine(Panel1.pArr[Panel1.indexN[number][i]].x,Panel1.pArr[Panel1.indexN[number][i]].y,
								Panel1.pArr[Panel1.indexN[number][i+1]].x,Panel1.pArr[Panel1.indexN[number][i+1]].y);
						System.err.println(Panel1.pArr[Panel1.indexN[number][i]].x + " " +
								Panel1.pArr[Panel1.indexN[number][i+1]].x);
					
				}
				number++;
				ccound++;
				System.err.println(ccound);
			}
			else {
				number++;
				repaint();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Push the 'New Game' button ");
		}

	}
	
	
	public static void perm(int[] aRR, int[] output, boolean[] visited, int depth, int n, int r){
		
		System.err.println("perm�Լ� ����");
		 if(depth == r) {
			 inputResult(output);
			
	         return;
	     }
	 
	     for(int i=0; i<n; i++) {
	         if(visited[i] != true) {
	             visited[i] = true;
	             output[depth] = aRR[i];
	             perm(aRR, output, visited, depth + 1, n, r);       
	             output[depth] = 0; // �� ���� ��� ��
	             visited[i] = false;;
	         }
	     }
	}
	
	public static void inputResult(int[] output) {
		
		for(int i=0; i<Panel1.count; i++) {
			Panel1.indexN[outputN][i] = output[i];
			System.out.println(Panel1.indexN[outputN][i]+ "   ");
		}
		
		
		outputN++; //������ �迭 �� �ٲٱ����� ����
	}
	
	
	
	
	
	
	
	//
	
	
	

	
	
	static int ccw(Poin a, Poin b, Poin c) {
		int tmp = (int) (a.x*b.y + b.x*c.y + c.x*a.y);
		tmp -= (a.y*b.x + b.y*c.x+c.y*a.x);
		
		if(tmp < 0)
			return -1; //�ð����
		if(tmp > 0)
			return 1; // �ݽð����
		return 0; //������ ����
	}
	
	static boolean isIntersect(Poin[] arr, int number) {
		System.err.println("isIntersect ȣ��");
		
		
		Poin comN1, comN2;
		int result1 = 0, result2 = 0; //��������Ϸ��� ���ľ���
		
		comN1 = Panel1.pArr[Panel1.indexN[number][0]];
		comN2 = Panel1.pArr[Panel1.indexN[number][1]];
		
		if(Panel1.count > 3) {
			
			for(int k=1; k+2 <= Panel1.count-1; k++) {
				for(int i=k+1; i<Panel1.count-1; i++) {
					
					result1 = ccw(comN1,comN2,Panel1.pArr[Panel1.indexN[number][i]])
							* ccw(comN1,comN2,Panel1.pArr[Panel1.indexN[number][i+1]]);
						
					result2 = ccw(Panel1.pArr[Panel1.indexN[number][i]],Panel1.pArr[Panel1.indexN[number][i+1]],comN1)
							* ccw(Panel1.pArr[Panel1.indexN[number][i]],Panel1.pArr[Panel1.indexN[number][i+1]],comN2);
						
					if(result1 < 0 && result2 < 0)
						return true;
					
				}
				
				comN1 = Panel1.pArr[Panel1.indexN[number][k]];
				comN2 = Panel1.pArr[Panel1.indexN[number][k+1]];
				
			}
		}
		
		
		return false;
		
	
		
		
		

		
	}
	
	
	
	
	
	static void swap(Poin a, Poin b) {
		Poin tmp;
		tmp = a;
		a=b;
		b = tmp;
		System.err.println("�ٲ������? " + a.x +"  "+ b.x);
		
	}
	static boolean compa(Poin c, Poin d) {
		
		if(c.x>=d.x)
			return true;
		else if(c.x==d.x && c.y>d.y)
			return true;
		else
			return false;
	}

	
	
	
	
	
	//
	
	
	
}

class MFrame extends JFrame {
	public Panel1 panel1 = null;
	public Panel2 panel2 = null;
	
	public void change(String panelName) {
		if(panelName.equals("panel1")) {
			getContentPane().removeAll();
			getContentPane().add(panel1);
			revalidate();
			repaint();
		}
		else {
			getContentPane().removeAll();
			getContentPane().add(panel2);
			revalidate();
			repaint();
		}
	}
	
}

public class AlgorithmTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MFrame frame = new MFrame();
		
		frame.setTitle("TEST");
		
		frame.panel1 = new Panel1(frame);
		frame.panel2 = new Panel2(frame);
		
		frame.add(frame.panel1);
		

		frame.pack();
		frame.setPreferredSize(new Dimension(840,840/12*9));
		frame.setSize(840, 840/12*9);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}

}