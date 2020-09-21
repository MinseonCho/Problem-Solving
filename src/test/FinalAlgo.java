package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import test.Panel1.MyActionListener;

class Po {
	public int x;
	public int y;
	Po(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class FPanel extends JPanel{
	private TFrame teFrame;
	private JButton button;
	private JLabel[] numberOfNodes = new JLabel[10];
	private TextField[] weightOf = new TextField[100];
	private int x,y;
	private boolean flag=false;
	private boolean ha =false;
	public Po[] point = new Po[10];
	static int count=0;
	static int i = 0;
	
	public FPanel(TFrame teFrame) {
		this.teFrame = teFrame;
		setLayout(null);
		JPanel panel1 = new JPanel();
		
		addMouseListener(new MouseAdapter( ) {
			public void mousePressed(MouseEvent e) {
				System.out.println("mousepressed");
				x=e.getX();
				y=e.getY(); //마우스의 위치를 기억
				System.out.println("x좌표 :" + x + " " +
				"Y좌표 : " + y);
	
				add(new JButton("1"));
				point[count++] = new Po(x,y);
				flag = true;
				repaint();
			}
		});
		
		add(panel1);
		
		button = new JButton("Click");
		add(button);
		button.setBounds(100, 100, 100, 20);
		button.addActionListener(new MyActionListener());
		
		TextField text1 = new TextField(1);
		text1.setText("1");
		add(text1);
		text1.setBounds(50, 50, 30, 30);
		
	}
	
	public void paint(Graphics g) {
			
			System.err.println("paint 호출");
			setBackground(Color.GRAY);
			if(flag) {
				g.drawRect(point[count-1].x, point[count-1].y, 20, 20);
				if(count>=2) {
					for(int k=0; k<count; k++) {
						if(point[k].x<= x && x <= point[k].x+20 && 
								point[k].y<=y && y <=point[k].y+20) {
							ha = true;
							
							if(ha) {
								weightOf[i] = new TextField("1");
								add(weightOf[i]);
								weightOf[i].setBounds((point[k].x+point[count-1].x)/2,(point[k].y+point[count-1].y)/2, 20, 20);
								i++;
								flag = true;
							}
							else {
								g.drawLine(x, y, point[count-2].x, point[count-2].y);
								if(i<=count) {
									weightOf[i] = new TextField("1");
									add(weightOf[i]);
									weightOf[i].setBounds((x+point[count-2].x)/2,(y+point[count-2].y)/2, 20, 20);
									i++;
							}
							
						}
					
							
//						g.drawLine(x, y, point[count-2].x, point[count-2].y);
//						if(i<=count) {
//						weightOf[i] = new TextField("1");
//						add(weightOf[i]);
//						weightOf[i].setBounds((x+point[count-2].x)/2,(y+point[count-2].y)/2, 20, 20);
//						i++;
					}
					}
				}
			}
			
	}
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
		}
		
	}
}

class SPanel extends JPanel{
	private TFrame teFrame;
	JLabel jLabel;
	JButton button;
	public SPanel(TFrame teFrame) {
		this.teFrame = teFrame;
		button = new JButton("click");
		
		setBackground(Color.GRAY);
		button.addActionListener(new MyActionListener());
	}
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
		}
		
	}

}

class TPanel extends JPanel{
	public TPanel(TFrame teFrame) {
		setBackground(Color.BLUE);
	}
}

class TFrame extends JFrame{
	public FPanel firstPanel = null;
	public SPanel secondPanel = null;
	public TPanel thirdPanel = null;
	public TFrame(){
		 
	 }
	
}

public class FinalAlgo {

	public static void main(String[] args) {
		TFrame tFrame = new TFrame();
		JPanel jPanel = new JPanel();
		
		 tFrame.setTitle("Algorithm Second Test");
		 
		 tFrame.firstPanel = new FPanel(tFrame);
		 tFrame.secondPanel = new SPanel(tFrame);
		 tFrame.thirdPanel = new TPanel(tFrame);
		
		 jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
		 jPanel.add(tFrame.firstPanel);
		 jPanel.add(tFrame.secondPanel);
		 jPanel.add(tFrame.thirdPanel);
		 
		 tFrame.add(jPanel);
		 tFrame.pack();
		 tFrame.setSize(1000, 500);
		 tFrame.getContentPane().setBackground(Color.GRAY);
		 tFrame.setLocationRelativeTo(null);
		 tFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 tFrame.setVisible(true);
	}

	
}
