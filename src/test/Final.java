package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Coordi {
	int x;
	int y;
	
	Coordi(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class JPanelOne extends JPanel {
	
	JFrameBack jFrame;
	JButton button;
	static Coordi point[] = new Coordi[100];
	static int x,y,cnt=0, i =0 , j=0;
	boolean flag = false;
	boolean caseOne = false;
	boolean caseTwo = false;
//	static int number;
	JDialog dialog;
	String weight[] = new String[100];
	int wnum=0;
	static int table[][] = new int[20][20];
	Coordi forWeight[] = new Coordi[2];
	int resultNode[] = new int[2];
	
	boolean f = false;
	
	
	
	//생성자
	JPanelOne(JFrameBack jFrame){
		this.jFrame = jFrame;
		addMouseListener(new MyMouseAdapter());
	
			button = new JButton("click");
			add(button, BorderLayout.SOUTH);
			button.addActionListener(new MyActionListener());

			System.out.println("JPANELONE 생성자");
	}
	
	class MyActionListener implements ActionListener {
		
				@Override
				public void actionPerformed(ActionEvent e) {
					
					removeAll();
					revalidate();
					x=0;
					y=0;
					flag = false;
					f=true;
					jFrame.change();
		
				}
		}

	
	
	class MyMouseAdapter extends MouseAdapter{
		
		public void mouseClicked(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			
			
			if(caseOne) {
			
				for(int k=0; k<cnt; k++) {
					if(point[k].x<= x && x <= point[k].x+20 && 
							point[k].y<=y && y <=point[k].y+20) {
						forWeight[j] = new Coordi(x,y);
						resultNode[j] = k;
						System.out.println("forWeight[j] = " + forWeight[j]);
						j++;
						
					}
				}
				
				if(j>=2) {
					caseTwo = true;
					j=0;
				}
			}
			else {
				for(int k=0; k<cnt; k++) {
					if(point[k].x<= x && x <= point[k].x+20 && 
							point[k].y<=y && y <=point[k].y+20) {
						caseOne = true;
						flag = false;
					}
				}
			    
				if(caseOne == false) {
					flag = true;
					point[cnt] = new Coordi(x,y);
					cnt++;
				}
				
			}
			
			repaint();
			System.out.println("마우스 클릭 실행");
		}
	}
	
	public void repaint() {
		System.out.println("repaint()호출");
		super.repaint();
	}
	public void paintComponent(Graphics g) {
		System.out.println("paintComponent 실행");
		if(caseOne && caseTwo) {
			flag = false;
			g.drawLine(forWeight[0].x, forWeight[0].y, forWeight[1].x, forWeight[1].y);
			String inputWeight = JOptionPane.showInputDialog(null, "가중치를 입력하세요");
			
			table[resultNode[0]][resultNode[1]] = Integer.parseInt(inputWeight);
			table[resultNode[1]][resultNode[0]] = Integer.parseInt(inputWeight);
			g.drawString(inputWeight,(forWeight[0].x + forWeight[1].x)/2
					, (forWeight[0].y + forWeight[1].y)/2);
			
			caseTwo = false;
		}
		if(flag) {
			g.drawRect(point[cnt-1].x,point[cnt-1].y, 20, 20);
			g.drawString(Integer.toString(i),point[cnt-1].x+6, point[cnt-1].y+14);
			i++;
		}
		
		if(f) {
			for(int i=0; i<cnt; i++) {
				g.drawRect(point[i].x,point[i].y, 20, 20);
				g.drawString(Integer.toString(i),point[i].x+4, point[i].y+12);
				g.drawLine(point[i].x, point[i].y, 
						point[JPanelThree.tree[i]].x, point[JPanelThree.tree[i]].y );
				
				for(int j=0; j<cnt; j++) {
					if(table[i][j] != 0) {
						g.drawLine(point[i].x, point[i].y, point[j].x, point[j].y);
						g.drawString(Integer.toString(table[i][j]),(point[i].x+point[j].x)/2
								, (point[i].y+point[j].y)/2);
					}
				}
				
			}
		}
	}
	
}
class JPanelTwo extends JPanel {
	
	
	JFrameBack jFrame;
	int wid, hei;
	int num1 = 0, num2 =0;
	int i =0;
	JLabel label[] = new JLabel[100];
	
	
	
	JPanelTwo(JFrameBack jFrame){
		this.jFrame = jFrame;
		this.setLayout(null);
		setBackground(Color.BLUE);
		System.out.println(JPanelOne.cnt);
	}
	
	
	
	public void paintComponent(Graphics g) {

		System.out.println("paint안의 : "+JPanelOne.cnt);
		for(int i =0; i<JPanelOne.cnt; i++) {
			for(int j=0; j<JPanelOne.cnt; j++) {
				g.drawRect(30+num2, 100 + num1, 30, 30);
				num2+=30;
			}
			num2=0;
			num1 = num1+30;
		}
		num2=0;
		num1=0;
		for(int i=0; i<JPanelOne.cnt; i++) {
			g.drawString(Integer.toString(i), 40+num2, 93);
			g.drawString(Integer.toString(i), 17, 120+num2);
			num2+=30;
		}
		num2=0;
		num1=0;
		for(int i=0; i<JPanelOne.cnt; i++) {
			
			for(int j=0; j<JPanelOne.cnt; j++) {
				g.drawString(Integer.toString(JPanelOne.table[i][j]), 40+num2, 120+num1);
				num2+=30;
			}
			num2=0;
			num1+=30;
		}
	}
}
class JPanelThree extends JPanel {
	
	JFrameBack jFrame;
	boolean[] visit;
	int sum=0;
	PriorityQueue<Edge> pQueue = new PriorityQueue<>();
	Queue<Integer> queue = new LinkedList<>();
	//정점방문 스케줄 처리를 위한 큐
	static ArrayList<Edge>[] nodeList;
	static int tree[];
	int num1, num2;
	
	JPanelThree(JFrameBack jFrame){
//		setBackground(Color.GREEN);
		this.jFrame = jFrame;
		
	}
	
	
	public void PrimMST() {
		
		nodeList = new ArrayList[JPanelOne.cnt];
		tree = new int[JPanelOne.cnt];
		
		for(int i=0; i<JPanelOne.cnt; i++) {
			nodeList[i] = new ArrayList<Edge>();
		}
		
		for(int i=0; i<JPanelOne.cnt; i++) {
			
			for(int j=i; j<JPanelOne.cnt; j++) {
				
				if(JPanelOne.table[i][j] != 0) {
					nodeList[i].add(new Edge(i, j, JPanelOne.table[i][j]));
					nodeList[j].add(new Edge(j, i, JPanelOne.table[i][j]));
				}
			}
		}
		queue.add(1);
		
		visit = new boolean[JPanelOne.cnt];
		
		while(!queue.isEmpty()) {
			
			ArrayList<Edge> tempList;
			Edge tempNode;
			int current = queue.poll();
			visit[current] = true;
			tempList = nodeList[current];
			
			for(int i=0; i<tempList.size(); i++) {
				if(!visit[tempList.get(i).end]) { //현재정점에서 연결된 간선들 중
					pQueue.add(tempList.get(i));  //방문한적 없는 정점으로 가는 간선들을 우선순위 큐에 넣는다
				}
			}
			while(!pQueue.isEmpty()) {
				tempNode = pQueue.poll();//간선들 중 제일짧은애가 나옴
				if(!visit[tempNode.end]) { //방금나온 간선 써도되는지, 미방문 정점인지
					if(tempNode.end == 0) {
						tree[tempNode.end] = 0;
					}
					else {
						tree[tempNode.end] = tempNode.start;
					}
					visit[tempNode.end] = true;//확인됐으면 정점 방문처리
					sum+=tempNode.value; 
					queue.add(tempNode.end); // 해당 간선 끝 정점을 방문 스케줄에 추가
					break;
					
				}
			}
		}
		System.out.println("최소비용:   " + sum);
		
//		repaint();
		
	}
	
	public void paintComponent(Graphics g) {
		
//		this.setBackground(Color.GRAY);
		for(int i=0; i<JPanelOne.cnt; i++) {
			System.out.println(tree[i]);
		}
		for(int i =0; i<JPanelOne.cnt; i++) {
			g.drawRect(JPanelOne.point[i].x,JPanelOne.point[i].y, 20, 20);
			g.drawString(Integer.toString(i),29+num1, 335);
			g.drawString(Integer.toString(tree[i]),29+num1, 353);
			g.drawString("tree", 0, 354);
			g.drawRect(24 +num1,340, 20, 20);
			num1+=20;
			g.drawLine(JPanelOne.point[i].x, JPanelOne.point[i].y,
					JPanelOne.point[tree[i]].x, JPanelOne.point[tree[i]].y);
			
			if(i==0) {
				g.drawString(Integer.toString(0),JPanelOne.point[i].x+4, JPanelOne.point[i].y+12);
			}
			g.drawString(Integer.toString(JPanelOne.table[tree[i]][i]),
					JPanelOne.point[i].x+4, JPanelOne.point[i].y+12);
		}
		
	}
	
}


class JFrameBack extends JFrame {
	JPanelOne jPanelOne = null;
	JPanelTwo jPaneltwo = null;
	JPanelThree jPanelthree = null;
	Container contentPane;
	JFrameBack(){
		contentPane = getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		contentPane.setBackground(Color.ORANGE);
	}
	public void change() {
		
		
		jPaneltwo.repaint();
		jPanelthree.PrimMST();

	}
}

class Edge implements Comparable<Edge>{
	int start, end, value;

    Edge(int s, int e, int v) {
    	super();
        this.start = s;
        this.end = e;
        this.value = v;
    }
    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
    @Override
    public String toString() {
        return "Edge [start=" + start + ", end=" + end + ", value=" + value + "]\n";
    }
}

public class Final extends JFrame {

	public static void main(String[] args) {
		JFrameBack jFrame = new JFrameBack();
		JPanel jPanel = new JPanel();
		
		jFrame.jPanelOne = new JPanelOne(jFrame);
		jFrame.jPaneltwo = new JPanelTwo(jFrame);
		jFrame.jPanelthree = new JPanelThree(jFrame);

		
//		jFrame.contentPane.add(jFrame.jPanelOne);
		
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

//		jPanel.add(jPanelfour);
		jPanel.add(jFrame.jPanelOne);
		jPanel.add(jFrame.jPaneltwo);
		jPanel.add(jFrame.jPanelthree);
		jFrame.contentPane.add(jPanel);
//		jFrame.contentPane.add(jFrame.jPaneltwo);
//		jFrame.contentPane.add(jFrame.jPanelthree);
		
//		jFrame.add(jPanel);
		jFrame.pack();
		jFrame.setSize(800, 450);
//		jFrame.getContentPane().setBackground(Color.BLUE);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		
	}

}