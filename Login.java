package tib;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import jdk.jshell.Diag;
import tib.Introduce.MDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Login extends JFrame implements ActionListener{///
	
	ImageIcon  background, busanwhite;
	JLabel labWelcome,labLogout;
	JLabel idL, pwL;//id�󺧺�����, pass �� ������
	TextField idTx, pwTx;//id�ؽ�Ʈ �ʵ� ������, pass�ؽ�Ʈ�ʵ� ������
	JButton logBtn,mrBtn, btnLogo;//�α��� ��ư ������, ȸ������(member registration) ��ư ������
	///////DB���ắ��/////////
	Vector<MemberBean> vlist;

	public static String id;//aaa
	List list;
	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");

		
		busanwhite = new ImageIcon("tib/busanwhite350.png");//travel in busan
		
		JPanel panelLogowhite  = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(busanwhite.getImage(), 0, 0, null);		
				setOpaque(false);
			}
		};
		
		background = new ImageIcon("tib/background800.jpg");
		
		JPanel panelBackground = new JPanel() {
			
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);		
				setOpaque(false);
				
			}
		};
		
		btnLogo = new JButton(busanwhite);
		btnLogo.setBounds(50, 50, 350, 100);
		btnLogo.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogo);
		btnLogo.addActionListener(this);
		
		///logo ������ ���� �����;���//
		panelLogowhite .setLayout(null);
		panelLogowhite .setBounds(50, 50, 350, 100);
		add(panelLogowhite );
		
		
		
	
		
		
		//background �г� ��ġ�� ���� �ϴܿ� ��ġ//
		panelBackground.setLayout(null);
		panelBackground.setBounds(0,0,1500,800);
		add(panelBackground);
		
		
		
		
		panelBackground.add(idL=new JLabel("ID"));
		panelBackground.add(pwL=new JLabel("PASS"));
		panelBackground.add(idTx=new TextField(""));
		panelBackground.add(pwTx=new TextField(""));
		pwTx.setEchoChar('#');

				
		///��Ʈ ��ġ, ��, ũ��//////////////////////////////////////
		Font top = new Font("�������",Font.BOLD,25);
		Font top2 = new Font("�������",Font.BOLD,15);
		Font top3 = new Font("�������",Font.BOLD,15);
		idL.setFont(top);
		idTx.setFont(top3);
		idL.setBounds(600,600, 100,30);
		idTx.setBounds(730, 600,200,30);
		idL.setForeground(Color.WHITE);
		
		
		pwL.setFont(top);
		pwTx.setFont(top3);
		pwL.setBounds(600,640, 100,30);
		pwTx.setBounds(730, 640,200,30);
		idL.setForeground(Color.WHITE);
		pwL.setForeground(Color.WHITE);
		
		
		
		
		
		
		logBtn = new JButton("�α���");
		mrBtn = new JButton("ȸ������");
		logBtn.setBackground(Color.WHITE);
		mrBtn.setBackground(Color.WHITE);
		logBtn.setBounds(650,690, 100,30);
		mrBtn.setBounds(770,690, 100, 30);
		panelBackground.add(logBtn);
		panelBackground.add(mrBtn);
		logBtn.setFont(top2);
		mrBtn.setFont(top2);
		
		//////////////////////dialog â ����//////////////////
		logBtn.addActionListener(this);
		mrBtn.addActionListener(this);

		
		setSize(1500,800);
		setVisible(true);
		validate();
		setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//////�ؽ�Ʈ�ʵ� �پ�α�///////////////////
		String  iditem= idTx.getText(), psitem= pwTx.getText();
		MemberMgr mgr;
		mgr = new MemberMgr();
		if (logBtn == e.getSource()) {//login��ư Ŭ���� üũ
				MemberBean bean = new MemberBean();//���� vlist�� ����� ù��° bean�� �����ͼ� �־� �ش�.--����ÿ��� MemberMgr97���ε� ����ÿ���
				bean = mgr.getMember( iditem, psitem);//�Է��� id,password ���� ���� �������� ���Ϳ� �����ؼ� �����´�. �ϳ������� ���Ͱ� �ƴ� bean�� �����͵� �ɰ� ���� 
				String s1 = bean.getId();
				String s2 = bean.getPassword();
				//System.out.println(s1);
				//System.out.println(s2);
								
				if(iditem.trim().equals(s1) && psitem.trim().equals(s2)){//�α����� �������� ���
					//System.out.println("���̵� ��ġ�մϴ�");
					this.setVisible(false);
					id = iditem;
					Choose frame = new Choose();
					frame.setVisible(true);
				}else {
					System.out.println("���̵� ���ų� ����ġ�մϴ�.");
					MDialog md = new MDialog(this, "�˸�", "���̵� ��������?","ȸ�������� ���ּ���", true);
					int width = 250;
					int height = 200;
					int x = getX() + getWidth() / 2 - width / 2;
					int y = getY() + getHeight() / 2 - height / 2;
					md.setBounds(x, y, width, height);
					md.setVisible(true);
						
						
					}
					
		}else if(mrBtn==e.getSource()) {
			this.setVisible(false);
			JFrame frame = new Signin();
			frame.setVisible(true);
		}
	 

	}// action
	
	class MDialog extends JDialog implements ActionListener{
		JButton btnu;
		JLabel msg1L;
		JLabel msg2L;
		
		public MDialog(Frame f,String title, String msg1,String msg2, boolean flag) {
			super(f, title, flag);
			int xmsg = msg1.length();
				
				
			setLayout(null);
			add(msg1L = new JLabel(msg1));
			add(msg2L = new JLabel(msg2));
		     			
			add(btnu = new JButton("Ȯ��"));
			
								
			msg1L.setBounds(60,20,200,30);
			msg2L.setBounds(60,60,200,30);
			btnu.setBounds(80,100,70,30);
			btnu.addActionListener(this);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			
		}
	}	
		
	
	

	public static void main(String[] args) {
		new Login();
	}
}	
