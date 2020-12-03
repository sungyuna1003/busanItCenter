


package tib;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.Clock;
import java.util.Date;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


import oracle.net.aso.v;
import tib.Introduce.MDialog;
import tib.Place.MBack;

//��һ��� ������ : 417 * 320

public class Mate extends JFrame implements ActionListener {

	JLabel labWelcome, labLogout, lab0, lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, labelInfo1, labelClock1,
			labelDate1, labelD1, labelAge1, labGender1, labCount1, labelInfo2, labelClock2, labelDate2, labelD2,
			labelAge2, labGender2, labCount2, labelInfo3, labelClock3, labelDate3, labelD3, labelAge3, labGender3,
			labCount3;

	JButton btn, btnA, btnB, btnM1, btnM2, btnM3, btnDate, btnSearch, btnLogo,
			btnLogout;
	
	Button welcomeBtn;

	ImageIcon busan, background, background2, friends, clock, date, age, gender, array, search, profile1, profile2, profile3;

	TextArea ta;

	TextArea ta1, ta2, ta3, taInfo1, taClock1, taDate1, taD1, taAge1, taGender1, taCount1, taInfo2, taClock2, taDate2,
			taD2, taAge2, taGender2, taCount2, taLab1, taLab2, taLab3, taLab4, taLab5, taLab6, taLab7, taLab8;

	List li1, li2, li3, li4, li5;// ������ �ɼ� ���� ���� ���
	
	int mode = 0;
	
	String ra1[] = {"�Ⱓ","���ڿ���","1��2��","2��3��","3��4��"}; 
	String ra2[] = {"����","������","������","���屺","����","����","������","�λ�����","�ϱ�","���","���ϱ�","����","������","������","������","�߱�","�ؿ�뱸"};
	String ra3[] = {"����","10��","20��","30��","40��","50���̻�"};
	String ra4[] = {"����","����","����","�������"};
	String ra5[] = {"���ı���","��ϼ�","�����ȼ�","���ƿ��","�����"};
	JComboBox<String> combo1,combo2,combo3,combo4,combo5;
	

	public Mate() {//��ư ���� ���� ĭ�� �־����.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");
		busan = new ImageIcon("tib/busanwhite157.png");
		JPanel panelLogo = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(busan.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		friends = new ImageIcon("tib/friends.png");
		JPanel panelF = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(friends.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		clock = new ImageIcon("tib/clock.png");
		JPanel panelC = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(clock.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		date = new ImageIcon("tib/date.png");
		JPanel panelD = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(date.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		age = new ImageIcon("tib/age.png");
		JPanel panelA = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(age.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		gender = new ImageIcon("tib/gender.png");
		JPanel panelG = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(gender.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		array = new ImageIcon("tib/array.png");
		JPanel panelArray = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(array.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		search = new ImageIcon("tib/search.png");
		JPanel panelSearch = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(array.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		profile1 = new ImageIcon("tib/profile1.jpg");
		JPanel panelP1 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(profile1.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		profile2 = new ImageIcon("tib/profile2.jpg");
		JPanel panelP2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(profile2.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		background2 = new ImageIcon("tib/beige.png");
		JPanel panelBackground2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background2.getImage(), 0, 0, null);
				g.drawLine(10,135, 1090,135);
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
///////////////////////////////////�̹��� ��ġ////////////////////////////////////////////
		btnLogo = new JButton(busan);
		btnLogo.setBounds(180, 20, 180, 50);
		btnLogo.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogo);
		btnLogo.addActionListener(this);
		
		welcomeBtn = new Button();
		panelBackground.add(welcomeBtn = new Button("Welcome"));
		welcomeBtn.setBounds(1070,30,100,30);
		welcomeBtn.setBackground(new Color(0, 0, 0));
		welcomeBtn.setForeground(Color.WHITE);
		welcomeBtn.addActionListener(this);

		panelF.setLayout(null);
		panelF.setBounds(200, 80, 100, 100);
		panelF.setBackground(new Color(251,246,240));
		add(panelF);
		
		panelC.setLayout(null);
		panelC.setBounds(225, 180, 30, 30);
		add(panelC);
		
		panelA.setLayout(null);
		panelA.setBounds(735, 180, 30, 30);
		add(panelA);
		
		panelG.setLayout(null);
		panelG.setBounds(910, 180, 30, 30);
		add(panelG);
		
		panelArray.setLayout(null);
		panelArray.setBounds(1110, 180, 30, 30);
		add(panelArray);

		panelP1.setLayout(null);
		panelP1.setBounds(200, 230, 200, 200);
		add(panelP1);

		panelP2.setLayout(null);
		panelP2.setBounds(200, 450, 200, 200);
		add(panelP2);
///////////////////////////////// ���� ���/////////////////////////////////////////
		

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(1200, 30, 90, 30);
		btnLogout.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogout);
		btnLogout.addActionListener(this);
///////////////////////////////////////�޴��� �� ��ġ/////////////////////////////////
		Label lab0 = new Label();
		panelBackground2.add(lab0 = new Label("����� ���� ģ���� ã�ƺ�����"));
		lab0.setBounds(150, 20, 800, 50);
		lab0.setBackground(new Color(251, 246, 240));

		Label lab1 = new Label();
		panelBackground2.add(lab1 = new Label("�Ⱓ"));
		lab1.setBounds(10, 100, 33, 30);
		lab1.setBackground(new Color(251, 246, 240));

	
		
		panelBackground2.add(combo1 = new JComboBox<String>(ra1));
		combo1.setBounds(85,100,80,25);
		combo1.setBackground(Color.WHITE);
		
		Label lab2 = new Label();
		panelBackground2.add(lab2 = new Label("��¥"));
		lab2.setBounds(175, 100, 33, 30);
		lab2.setBackground(new Color(251, 246, 240));
		
		btnDate = new JButton(date);
		btnDate.setBounds(210, 100, 33, 30);
		btnDate.setBackground(new Color(251, 246, 240));
		panelBackground2.add(btnDate);
		btnDate.addActionListener(this);


		panelBackground2.add(taLab2 = new TextArea("�����ϼ���", 5, 5, TextArea.SCROLLBARS_NONE));
		taLab2.setBounds(250, 100, 80, 25);
		taLab2.setFocusable(false);

		
	
	
		Label lab3 = new Label();
		panelBackground2.add(lab3 = new Label("���� ������"));
		lab3.setBounds(340, 100, 90, 30);
		lab3.setBackground(new Color(251, 246, 240));

		panelBackground2.add(combo2 = new JComboBox<String>(ra2));
		combo2.setBounds(430,100,80,25);
		combo2.setBackground(Color.WHITE);
		
		Label lab4 = new Label();
		panelBackground2.add(lab4 = new Label("����"));
		lab4.setBounds(520, 100, 33, 30);
		lab4.setBackground(new Color(251, 246, 240));



		panelBackground2.add(combo3 = new JComboBox<String>(ra3));
		combo3.setBounds(600,100,80,25);
		combo3.setBackground(Color.WHITE);

		Label lab5 = new Label();
		panelBackground2.add(lab5 = new Label("����"));
		lab5.setBounds(690, 100, 33, 30);
		lab5.setBackground(new Color(251, 246, 240));

		
		panelBackground2.add(combo4 = new JComboBox<String>(ra4));
		combo4.setBounds(770,100,80,25);
		combo4.setBackground(Color.WHITE);


		Label lab6 = new Label();
		panelBackground2.add(lab6 = new Label("���ı���"));
		lab6.setBounds(860, 100, 70, 30);
		lab6.setBackground(new Color(251, 246, 240));

		panelBackground2.add(combo5 = new JComboBox<String>(ra5));
		combo5.setBounds(970,100,80,25);
		combo5.setBackground(Color.WHITE);
		
		btnSearch = new JButton(search);
		btnSearch.setBounds(1060, 100, 30, 30);
		btnSearch.setBackground(new Color(251, 246, 240));
		panelBackground2.add(btnSearch);
		btnSearch.addActionListener(this);
	
		
///////////////////////////////////1° ��� �ι�///////////////////////////////////////////////////////////
		Label labelinfo1 = new Label();
		panelBackground2.add(labelinfo1 = new Label("ID"));
		labelinfo1.setBounds(250, 150, 50, 23);
		labelinfo1.setBackground(new Color(251, 246, 240));

		panelBackground2.add(taInfo1 = new TextArea("���� �����", 5, 5, TextArea.SCROLLBARS_NONE));
		taInfo1.setBounds(310, 150, 140, 23);
		taInfo1.setFocusable(false);

		Label labelclock1 = new Label();
		panelBackground2.add(labelclock1 = new Label("�Ⱓ"));
		labelclock1.setBounds(250, 180, 50, 23);
		labelclock1.setBackground(new Color(251, 246, 240));

		panelBackground2.add(taClock1 = new TextArea("���� �����", 5, 5, TextArea.SCROLLBARS_NONE));
		taClock1.setBounds(310, 180, 140, 23);
		taClock1.setFocusable(false);

		Label labeldate1 = new Label();
		panelBackground2.add(labeldate1 = new Label("��������"));
		labeldate1.setBounds(250, 210, 50, 23);
		labeldate1.setBackground(new Color(251, 246, 240));

		panelBackground2.add(taDate1 = new TextArea("���� �����", 5, 5, TextArea.SCROLLBARS_NONE));
		taDate1.setBounds(310, 210, 140, 23);
		taDate1.setFocusable(false);

		Label labeld1 = new Label();
		panelBackground2.add(labeld1 = new Label("����"));
		labeld1.setBounds(250, 240, 50, 23);
		labeld1.setBackground(new Color(251, 246, 240));

		panelBackground2.add(taD1 = new TextArea("���� �����", 5, 5, TextArea.SCROLLBARS_NONE));
		taD1.setBounds(310, 240, 140, 23);
		taD1.setFocusable(false);

		Label labelage1 = new Label();
		panelBackground2.add(labelage1 = new Label("����"));
		labelage1.setBounds(250, 270, 50, 23);
		labelage1.setBackground(new Color(251, 246, 240));

		panelBackground2.add(taAge1 = new TextArea("���� �����", 5, 5, TextArea.SCROLLBARS_NONE));
		taAge1.setBounds(310, 270, 140, 23);
		taAge1.setFocusable(false);

		Label labgender1 = new Label();
		panelBackground2.add(labgender1 = new Label("����"));
		labgender1.setBounds(250, 300, 50, 23);
		labgender1.setBackground(new Color(251, 246, 240));

		panelBackground2.add(taGender1 = new TextArea("���� �����", 5, 5, TextArea.SCROLLBARS_NONE));
		taGender1.setBounds(310, 300, 140, 23);
		taGender1.setFocusable(false);

		Label labcount = new Label();
		panelBackground2.add(labcount = new Label("����ο�"));
		labcount.setBounds(250, 330, 50, 23);
		labcount.setBackground(new Color(251, 246, 240));

		panelBackground2.add(taCount1 = new TextArea("���� �����", 5, 5, TextArea.SCROLLBARS_NONE));
		taCount1.setBounds(310, 330, 140, 23);
////////////////////////////////////2° ��� �ι�///////////////////////////////////////////////////////////
		Label labelinfo2 = new Label();
		panelBackground2.add(labelinfo2 = new Label("ID"));
		labelinfo2.setBounds(250, 370, 50, 23);
		labelinfo2.setBackground(new Color(251, 246, 240));

		panelBackground2.add(taInfo2 = new TextArea("���� �����", 5, 5, TextArea.SCROLLBARS_NONE));
		taInfo2.setBounds(310, 370, 140, 23);
		taInfo2.setFocusable(false);

		Label labelclock2 = new Label();
		panelBackground2.add(labelclock2 = new Label("�Ⱓ"));
		labelclock2.setBounds(250, 400, 50, 23);
		labelclock2.setBackground(new Color(251, 246, 240));

		panelBackground2.add(taClock2 = new TextArea("���� �����", 5, 5, TextArea.SCROLLBARS_NONE));
		taClock2.setBounds(310, 400, 140, 23);
		taClock2.setFocusable(false);

		Label labeldate2 = new Label();
		panelBackground2.add(labeldate2 = new Label("��������"));
		labeldate2.setBounds(250, 430, 50, 23);
		labeldate2.setBackground(new Color(251, 246, 240));

		panelBackground2.add(taDate2 = new TextArea("���� �����", 5, 5, TextArea.SCROLLBARS_NONE));
		taDate2.setBounds(310, 430, 140, 23);
		taDate2.setFocusable(false);

		Label labeld2 = new Label();
		panelBackground2.add(labeld2 = new Label("����"));
		labeld2.setBounds(250, 460, 50, 23);
		labeld2.setBackground(new Color(251, 246, 240));

		panelBackground2.add(taD2 = new TextArea("���� �����", 5, 5, TextArea.SCROLLBARS_NONE));
		taD2.setBounds(310, 460, 140, 23);
		taD2.setFocusable(false);

		Label labelage2 = new Label();
		panelBackground2.add(labelage2 = new Label("����"));
		labelage2.setBounds(250, 490, 50, 23);
		labelage2.setBackground(new Color(251, 246, 240));

		panelBackground2.add(taAge2 = new TextArea("���� �����", 5, 5, TextArea.SCROLLBARS_NONE));
		taAge2.setBounds(310, 490, 140, 23);
		taAge2.setFocusable(false);

		Label labelgender2 = new Label();
		panelBackground2.add(labelgender2 = new Label("����"));
		labelgender2.setBounds(250, 520, 50, 23);
		labelgender2.setBackground(new Color(251, 246, 240));

		panelBackground2.add(taGender2 = new TextArea("���� �����", 5, 5, TextArea.SCROLLBARS_NONE));
		taGender2.setBounds(310, 520, 140, 23);
		taGender2.setFocusable(false);

		Label labcount2 = new Label();
		panelBackground2.add(labcount2 = new Label("����ο�"));
		labcount2.setBounds(250, 550, 50, 23);
		labcount2.setBackground(new Color(251, 246, 240));

		panelBackground2.add(taCount2 = new TextArea("���� �����", 5, 5, TextArea.SCROLLBARS_NONE));
		taCount2.setBounds(310, 550, 140, 23);
///////////////////////////////////////////////////////////////////////////////		
		panelBackground2.add(ta1 = new TextArea("�������"));
		ta1.setBounds(480, 190, 500, 130);
		ta1.setFocusable(false);

		btnM1 = new JButton("������");
		btnM1.setBounds(1005, 230, 75, 30);
		btnM1.setBackground(new Color(251, 246, 240));
		panelBackground2.add(btnM1);
		btnM1.addActionListener(this);

		panelBackground2.add(ta2 = new TextArea("�������"));
		ta2.setBounds(480, 410, 500, 130);
		ta2.setFocusable(false);

		btnM2 = new JButton("������");
		btnM2.setBounds(1005, 450, 75, 30);
		btnM2.setBackground(new Color(251, 246, 240));
		panelBackground2.add(btnM2);
		btnM2.addActionListener(this);
/////////////////////////////�ϴ� ��ư 2��////////////////////////////////////////
		btnA = new JButton("����");
		btnA.setBounds(450, 580, 80, 30);
		btnA.setBackground(new Color(251, 246, 240));
		panelBackground2.add(btnA);
		btnA.addActionListener(this);

		btnB = new JButton("����");
		btnB.setBounds(600, 580, 80, 30);
		btnB.setBackground(new Color(251, 246, 240));
		panelBackground2.add(btnB);
		btnB.addActionListener(this);
/////////////////////////////////////////////////////////////////////////////////	
		panelBackground2.setLayout(null);
		panelBackground2.setBounds(180, 80, 1100, 620);
		add(panelBackground2);

		panelBackground.setLayout(null);
		panelBackground.setBounds(0, 0, 1500, 800);
		add(panelBackground);
////////////////////////////////////////////////////////////////////////////////////		
		// ��Ʈ//
		Font title = new Font("�������", Font.BOLD, 30);
		Font list = new Font("�������", Font.BOLD, 15);
		Font top = new Font("�������", Font.BOLD, 15); // logout, welcome


		btnLogout.setFont(top);

		btnLogout.setForeground(Color.WHITE);

		lab0.setFont(title);
		lab1.setFont(list);
		lab2.setFont(list);
		lab3.setFont(list);
		lab4.setFont(list);
		lab5.setFont(list);
		lab6.setFont(list);

		setSize(1500, 800);
		setVisible(true);
		validate();
		setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (btnDate == obj) {
			new SwingCalendar3(this);
		}else if (btnLogo == obj) {  // �ΰ��ư ������ ������������ �̵�
			 JFrame frame = new Choose(); 
			  frame.setVisible(true);	
		} else if (btnLogout == obj) { // �α׾ƿ� ��ư
			new MDialog(this, "�˸�", "", true);
			 this.setVisible(false);
			 Login Login = new Login();
			 Login.setVisible(true);
		}
		 else if (btnM1 == obj) { 
			  JFrame frame = new More(); 
			  frame.setVisible(true);	 
		} else if (btnM2 == obj) {
			  JFrame frame = new More(); 
			  frame.setVisible(true);
		} else if (btnA == obj) { 
			  JFrame frame = new Mate(); 
			  frame.setVisible(true);	 
		} else if (btnB == obj) { 
			  JFrame frame = new Mate(); 
			  frame.setVisible(true);	 
		} else if (welcomeBtn == obj) { //choose �������� �ȳѾ��...
			this.setVisible(false);
			Choose Choose = new Choose();
			Choose.setVisible(true);
			
		}
	}

//////////////////////��������//////////////////////////////////////////////
	class MDialog extends JDialog implements ActionListener {

		int width = 200;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;

		public MDialog(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			int xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("Logout �Ͻðڽ��ϱ�?"));
			add(btnu = new JButton("yes"));

			msg1L.setBounds(30, 20, 150, 25);
			Font top = new Font("�������", Font.BOLD, 13);
			msg1L.setFont(new Font("�������", Font.BOLD, 13));
			btnu.setBackground(Color.WHITE);

			btnu.setBounds(60, 65, 60, 30);
			btnu.addActionListener(this);

			/*
			 * JButton btnExit = new JButton("no"); btnExit.addActionListener(new
			 * ActionListener() { public void actionPerformed(ActionEvent arg0) {
			 * System.exit(0); } }); btnExit.setBounds(20, 55, 60, 30);
			 * getContentPane().add(btnExit); btnExit.setBackground(Color.WHITE);
			 */

			layset();
		}

		public void layset() {
			int px = f.getX();
			int py = f.getY();
			int x = px + f.getWidth() / 2;
			int y = py + f.getHeight() / 2;
			setBounds(x, y, width, height);
			setVisible(true);
			// validate();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		new Mate();
	}
}
