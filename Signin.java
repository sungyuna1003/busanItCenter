package tib;

import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


///Ŭ���� "����������" ��ư�� ������ id�� �г����� ��Ȱ��ȭ ���ѳ��ƾ���
//����SigninŬ������ ������ �Ұ� ����
public class Signin extends JFrame implements ActionListener {
	Vector<MemberBean> vlist1;
	
	ImageIcon background, busan, background2,profil,date;
	Button login, logoutBtn;
	JButton btnLogo;
	
	JLabel proL;
	JButton proCallBtn, proReBtn, proChBtn;
	FileDialog getImg;//�̹����������� 
	ImagePanel panelProfil;
	
	JLabel lavel[];
	String lavelStr[] = {"�г���","ID �Է�", "PASS �Է�","PASS ���Է�","����","�������","Email �ּ�","�ڵ�����ȣ"};
	JTextField nameTf;//�г���
	JButton checkNBtn;//�г��� �ߺ�Ȯ��
	
	JTextField idTf; //id�Է��ϴ� �ؽ�Ʈ �ʵ� ����
	JButton checkIBtn;//id �ߺ�Ȯ��
	
	JTextField passTf; //password�Է��ϴ� �ؽ�Ʈ �ʵ� ����
	JButton checkPBtn;//password Ȯ��
	JLabel passL;//�н����� ���� �˷��ִ� ���̺�
	
	JTextField passTf2; //password ���Է��ϴ� �ؽ�Ʈ �ʵ� ����
	JButton checkPBtn2;//password ��Ȯ��
	
	Choice genderC;
	String sGen[]= {"��","��"};
	
	JTextField birthTf; //������� �Է��ϴ� �ؽ�Ʈ �ʵ� ����
	JButton calBtn;//������� �����ϴ� ��ư
	Image calImg;//�޷±׸�
	
	
	JTextField emailTf; //email �Է��ϴ� �ؽ�Ʈ �ʵ� ����
	
	
	JComboBox comboTel;//�ڵ��� ��ȣ �Է�
	JTextField telTf2; 
	JTextField telTf3; 
	JLabel bar1, bar2;
	
	JButton saveSiBtn,reInfoBtn;

	JPanel pMain;
	JPanel[] p;
	
	Signin signin;
	
	//db�Է¿� �ʿ��� ����
	Vector<MemberBean> vlist;
	MemberMgr mgr;
	int idx;
	String id;

	
	public Signin(String id) {
		this.id=id;
		
		mgr = new MemberMgr(); 
		MemberBean bean = mgr.getMember(id);
		//System.out.println(bean.getEmail());
		idx = bean.getIdx();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");

		busan = new ImageIcon("tib/busanwhite157.png");
		JPanel panellogo = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(busan.getImage(), 0, 0, null);
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
		

		background2 = new ImageIcon("tib/beige.png");
		JPanel panelBackground2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background2.getImage(), 0, 0, null);
				setOpaque(false);

			}
		};

		/// logo ������ ���� �����;���//
		panellogo.setLayout(null);
		panellogo.setBounds(180, 20, 180, 50);
		
		add(panellogo);
		
		Font top = new Font("�������",Font.BOLD,15);
		Font top2 = new Font("�������",Font.BOLD,12);
		Font top3 = new Font("�������",Font.BOLD,12);
		Font top4 = new Font("���� ���" ,Font.BOLD,9 );
		
		btnLogo = new JButton(busan);
		btnLogo.setBounds(180, 20, 180, 50);
		btnLogo.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogo);
		btnLogo.addActionListener(this);
		
		login = new Button();
		panelBackground.add(login = new Button("Login"));
		login.setBounds(1070,30, 90, 30); 
		login.setBackground(new Color(0, 0, 0));
		login.setFont(top);
		login.setForeground(Color.WHITE);
		
		
		logoutBtn = new Button();
		panelBackground.add(logoutBtn = new Button("Logout"));
		logoutBtn.setBounds(1190, 30, 90, 30);
		logoutBtn.setBackground(new Color(0, 0, 0));
		logoutBtn.setFont(top);
		logoutBtn.setForeground(Color.WHITE);
		
		
		
		// background2 ��ġ//
		panelBackground2.setLayout(null);
		panelBackground2.setBounds(180, 80, 1100, 620);
		add(panelBackground2);

		// background �г� ��ġ�� ���� �ϴܿ� ��ġ//
		panelBackground.setLayout(null);
		panelBackground.setBounds(0, 0, 1500, 800);
		add(panelBackground);
		
		panelBackground2.add(proL=new JLabel("���� ��������� 200 X 200"));
		proL.setBounds(120, 330, 200,30);
		proL.setFont(top2);
		
		panelBackground2.add(proCallBtn = new JButton("�̹��� �ҷ�����"));
		proCallBtn.setBounds(70, 375, 125,30);
		proCallBtn.setBackground(Color.WHITE);
		
		panelBackground2.add(proReBtn = new JButton("��  ��  ��  ��"));
		proReBtn.setBounds(200, 375, 125,30);
		proReBtn.setFont(top2);
		proReBtn.setBackground(Color.WHITE);

		
		
		int j = 100;
		lavel = new JLabel[8];
		for (int i = 0; i < lavel.length; i++) {
			panelBackground2.add(lavel[i] = new JLabel(lavelStr[i]));
			lavel[i].setBounds(470,j, 140, 30);
			lavel[i].setFont(top);
			j += 40;
		}
		
		panelBackground2.add(nameTf=new JTextField(bean.getName()));
		panelBackground2.add(checkNBtn= new JButton("�ߺ�Ȯ��"));
		nameTf.setBounds(610,100,200, 30);
		//nameTf.setEditable(false);
		checkNBtn.setBounds(820, 100, 100,30);
		checkNBtn.setBackground(Color.WHITE);
		//checkNBtn.setEnabled(false);

		nameTf.setFont(top2);
		nameTf.setForeground(Color.GRAY);
		checkNBtn.setFont(top2);
		
		
		
		panelBackground2.add(idTf=new JTextField(bean.getId()));
		panelBackground2.add(checkIBtn= new JButton("�ߺ�Ȯ��"));
		idTf.setBounds(610,140 ,200, 30);
		checkIBtn.setBounds(820, 140, 100,30);
		idTf.setFont(top2);
		idTf.setForeground(Color.GRAY);
		idTf.setEditable(false);
		checkIBtn.setFont(top2);
		checkIBtn.setBackground(Color.WHITE);
		checkIBtn.setEnabled(false);

		
		
		panelBackground2.add(passTf=new JTextField(bean.getPassword()));
		//passTf.setEchoChar('#');
		panelBackground2.add(checkPBtn= new JButton("Ȯ      ��"));
		passTf.setBounds(610,179 ,200, 30);
		checkPBtn.setBounds(820, 179, 100,30);
		passTf.setFont(top2);
		checkPBtn.setFont(top2);
		checkPBtn.setBackground(Color.WHITE);

		panelBackground2.add( passL = new JLabel("��й�ȣ�� Ư������ �����빮�� 1���̻� ���"));
		passL.setFont(top4);
		passL.setBounds(610,210, 300,10);
		
		
		panelBackground2.add(passTf2=new JTextField(bean.getPassword()));
		panelBackground2.add(checkPBtn2= new JButton("Ȯ      ��"));
		passTf2.setBounds(610,221 ,200, 30);
		checkPBtn2.setBounds(820, 220, 100,30);
		passTf2.setFont(top2);
		checkPBtn2.setFont(top2);
		checkPBtn2.setBackground(Color.WHITE);

		
		genderC = new Choice();
		String gen = bean.getGender();                     //�����ֱ�
		if (gen.equals("��") ) {
			genderC.add(sGen[0]);
			genderC.add(sGen[1]);
			}else {genderC.add(sGen[1]);
			          genderC.add(sGen[0]);	}
		panelBackground2.add(genderC);
		genderC.setBounds(610,260,200,30);
		genderC.setFont(top2);
		genderC.setBackground(Color.WHITE);

		panelBackground2.add(birthTf=new JTextField(bean.getBirth()));//�ؽ�Ʈ �ʵ� �߰��� ��ġ�ϰ� �ϴ� ���?
		birthTf.setBounds(610,300 ,170, 30);
		birthTf.setFont(top2);
				
		panelBackground2.add(calBtn = new JButton(new ImageIcon("tib/date.png")));
		calBtn.setBounds(780,300,30,30);
		calBtn.setFont(top2);
		calBtn.setBackground(Color.WHITE);
		
		panelBackground2.add(emailTf=new JTextField(bean.getEmail()));
		emailTf.setBounds(610,340 ,200, 30);
		emailTf.setFont(top2);
				
		JPanel p = new JPanel();
		p.setLayout(null);
		String ph = bean.getPhone();//�ڵ�����ȣ �ֱ�
		String arr[] = ph.split("-");
		String[] tel1 = { arr[0],"010", "011", "016", "017", "018", "019" };
		comboTel = new JComboBox(tel1);
		//String[] tel1 = { "010", "011", "016", "017", "018", "019" };
		//comboTel = new JComboBox(tel1);
		p.add(comboTel);
		comboTel.setBounds(0,0,60,30);
		comboTel.setBackground(Color.WHITE);
		comboTel.setFont(top2);
		
		p.add( bar1 =new JLabel("-"));
		bar1.setBounds(65,0,5,30);
		bar1.setBackground(Color.WHITE);
		bar1.setFont(top2);
		
		telTf2 = new JTextField(arr[1]);
		p.add(telTf2);
		telTf2.setBounds(75,0,55,30);
		telTf2.setBackground(Color.WHITE);
		telTf2.setFont(top2);
		
		p.add( bar2 =new JLabel("-"));
		bar2.setBounds(135,0,5,30);
		bar2.setBackground(Color.WHITE);
		bar2.setFont(top2);
		
		telTf3 = new JTextField(arr[2]);
		p.add(telTf3);
		telTf3.setBounds(145,0,55,30);
		telTf3.setBackground(Color.WHITE);
		telTf3.setFont(top2);
		
		panelBackground2.add(p);
		p.setBounds(610, 380, 200, 30);
		p.setBackground(Color.WHITE);
					
		panelBackground2.add(saveSiBtn = new JButton("�� �� �� �� �� �� ��"));
		saveSiBtn.setBounds(350, 500, 200,40);
		saveSiBtn.setFont(top);
		saveSiBtn.setBackground(Color.WHITE);
		saveSiBtn.setEnabled(false);
		
		panelBackground2.add(reInfoBtn = new JButton("�� �� �� �� �� �� ��"));
		reInfoBtn.setBounds(570, 500, 200,40);
		reInfoBtn.setFont(top);
		reInfoBtn.setBackground(Color.WHITE);
		
		//////////////�̹��� ���� �����ͼ� �ֱ�///////////////////
		panelProfil = new ImagePanel();
		panelBackground2.add(panelProfil);
		panelProfil.setBounds(95,110, 200, 200);
		
		String s="tib/user.png";
		 panelProfil.setPath(s);//�̹��� �ǳڿ� �̹����� �����´�
		 panelProfil.repaint();//�̹��� �ǳڿ� �̹����� �׸���.
		
		getImg = new FileDialog(this,"�̹��� ����",FileDialog.LOAD);
		
		///////////////////////////�̹�Ʈ ����//////////////////////
		proCallBtn.addActionListener(this);
		proReBtn.addActionListener(this);
		
		login.addActionListener(this);
		logoutBtn.addActionListener(this);
		
		calBtn.addActionListener(this);
		
		/////////////////diallog â ���� ����/////////////////////////////////////
       	checkNBtn.addActionListener(this);
		//checkIBtn.addActionListener(this);
		checkPBtn.addActionListener(this);
		checkPBtn2.addActionListener(this);
		reInfoBtn.addActionListener(this);
		
		setSize(1500, 800);
		setVisible(true);
		validate();
		setLocationRelativeTo(null);//�ǳ��� �߰��� ��ġ ��Ų��. 
	}
	
	public Signin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");

		busan = new ImageIcon("tib/busanwhite157.png");
		JPanel panellogo = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(busan.getImage(), 0, 0, null);
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
		
		background2 = new ImageIcon("tib/beige.png");
		JPanel panelBackground2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background2.getImage(), 0, 0, null);
				setOpaque(false);

			}
		};
	//////////////////////////////////////////////////////////////////////////////////////////
			/// logo ������ ���� �����;���//
		panellogo.setLayout(null);
		panellogo.setBounds(180, 20, 180, 50);
		
		add(panellogo);
		
		Font top = new Font("�������",Font.BOLD,15);
		Font top2 = new Font("�������",Font.BOLD,12);
		Font top3 = new Font("�������",Font.BOLD,12);
		Font top4 = new Font("���� ���" ,Font.BOLD,9 );
		
		btnLogo = new JButton(busan);
		btnLogo.setBounds(180, 20, 180, 50);
		btnLogo.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogo);
		btnLogo.addActionListener(this);
		
		login = new Button();
		panelBackground.add(login = new Button("Login"));
		login.setBounds(1070,30, 90, 30); 
		login.setBackground(new Color(0, 0, 0));
		login.setFont(top);
		login.setForeground(Color.WHITE);
				
		logoutBtn = new Button();
		panelBackground.add(logoutBtn = new Button("Logout"));
		logoutBtn.setBounds(1190, 30, 90, 30);
		logoutBtn.setBackground(new Color(0, 0, 0));
		logoutBtn.setFont(top);
		logoutBtn.setForeground(Color.WHITE);
				
		// background2 ��ġ//
		panelBackground2.setLayout(null);
		panelBackground2.setBounds(180, 80, 1100, 620);
		add(panelBackground2);

		// background �г� ��ġ�� ���� �ϴܿ� ��ġ//
		panelBackground.setLayout(null);
		panelBackground.setBounds(0, 0, 1500, 800);
		add(panelBackground);
		
		panelBackground2.add(proL=new JLabel("���� ��������� 200 X 200"));
		proL.setBounds(120, 330, 200,30);
		proL.setFont(top2);
		
		panelBackground2.add(proCallBtn = new JButton("�̹��� �ҷ�����"));
		proCallBtn.setBounds(70, 375, 125,30);
		proCallBtn.setBackground(Color.WHITE);
		
		panelBackground2.add(proReBtn = new JButton("��  ��  ��  ��"));
		proReBtn.setBounds(200, 375, 125,30);
		proReBtn.setFont(top2);
		proReBtn.setBackground(Color.WHITE);
		
		int j = 100;
		lavel = new JLabel[8];
		for (int i = 0; i < lavel.length; i++) {
			panelBackground2.add(lavel[i] = new JLabel(lavelStr[i]));
			lavel[i].setBounds(470,j, 140, 30);
			lavel[i].setFont(top);
			j += 40;
		}
		
		panelBackground2.add(nameTf=new JTextField("  10�� �̳�"));
		panelBackground2.add(checkNBtn= new JButton("�ߺ�Ȯ��"));
		nameTf.setBounds(610,100,200, 30);
		checkNBtn.setBounds(820, 100, 100,30);
		checkNBtn.setBackground(Color.WHITE);

		nameTf.setFont(top2);
		nameTf.setForeground(Color.GRAY);
		checkNBtn.setFont(top2);
		nameTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				nameTf.setText("");
			}
		});
				
		panelBackground2.add(idTf=new JTextField("  10�� �̳�"));
		panelBackground2.add(checkIBtn= new JButton("�ߺ�Ȯ��"));
		idTf.setBounds(610,140 ,200, 30);
		checkIBtn.setBounds(820, 140, 100,30);
		idTf.setFont(top2);
		idTf.setForeground(Color.GRAY);
		checkIBtn.setFont(top2);
		checkIBtn.setBackground(Color.WHITE);

		idTf.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				idTf.setText("");
			}
		});
		
		panelBackground2.add(passTf=new JTextField());
		//passTf.setEchoChar('#');
		panelBackground2.add(checkPBtn= new JButton("Ȯ      ��"));
		passTf.setBounds(610,179 ,200, 30);
		checkPBtn.setBounds(820, 179, 100,30);
		passTf.setFont(top2);
		checkPBtn.setFont(top2);
		checkPBtn.setBackground(Color.WHITE);

		panelBackground2.add( passL = new JLabel("��й�ȣ�� Ư������ �����빮�� 1���̻� ���"));
		passL.setFont(top4);
		passL.setBounds(610,210, 300,10);
				
		panelBackground2.add(passTf2=new JTextField());
		panelBackground2.add(checkPBtn2= new JButton("Ȯ      ��"));
		passTf2.setBounds(610,221 ,200, 30);
		checkPBtn2.setBounds(820, 220, 100,30);
		passTf2.setFont(top2);
		checkPBtn2.setFont(top2);
		checkPBtn2.setBackground(Color.WHITE);
		
		genderC = new Choice();
		genderC.add(sGen[0]);
		genderC.add(sGen[1]);
		panelBackground2.add(genderC);
		genderC.setBounds(610,260,200,30);
		genderC.setFont(top2);
		genderC.setBackground(Color.WHITE);

		panelBackground2.add(birthTf=new JTextField("2020-11-11"));//�ؽ�Ʈ �ʵ� �߰��� ��ġ�ϰ� �ϴ� ���?
		birthTf.setBounds(610,300 ,170, 30);
		birthTf.setFont(top2);
		
		//�ؽ�Ʈ �ʵ����� ��� �޷� �̹����� �̾� ��ư �ִ��� �𸣰��� - ������
		panelBackground2.add(calBtn = new JButton(new ImageIcon("tib/date.png")));
		calBtn.setBounds(780,300,30,30);
		calBtn.setFont(top2);
		calBtn.setBackground(Color.WHITE);

		
		panelBackground2.add(emailTf=new JTextField(""));
		emailTf.setBounds(610,340 ,200, 30);
		emailTf.setFont(top2);
		
		
		JPanel p = new JPanel();
		p.setLayout(null);
		//p.setBackground(new Color(251, 246, 240));  ----> ���� ��� ����� �ڲ� ����µ� �Ⱦ�������
		String[] tel1 = { "010", "011", "016", "017", "018", "019" };
		comboTel = new JComboBox(tel1);
		p.add(comboTel);
		comboTel.setBounds(0,0,60,30);
		comboTel.setBackground(Color.WHITE);
		comboTel.setFont(top2);
		
		p.add( bar1 =new JLabel("-"));
		bar1.setBounds(65,0,5,30);
		bar1.setBackground(Color.WHITE);
		bar1.setFont(top2);
		

		telTf2 = new JTextField(4);
		p.add(telTf2);
		telTf2.setBounds(75,0,55,30);
		telTf2.setBackground(Color.WHITE);
		telTf2.setFont(top2);

		
		p.add( bar2 =new JLabel("-"));
		bar2.setBounds(135,0,5,30);
		bar2.setBackground(Color.WHITE);
		bar2.setFont(top2);
		
		telTf3 = new JTextField(4);
		p.add(telTf3);
		telTf3.setBounds(145,0,55,30);
		telTf3.setBackground(Color.WHITE);
		telTf3.setFont(top2);
		
		panelBackground2.add(p);
		p.setBounds(610, 380, 200, 30);
		p.setBackground(Color.WHITE);
				
		
		
		
		panelBackground2.add(saveSiBtn = new JButton("�� �� �� �� �� �� ��"));
		saveSiBtn.setBounds(350, 500, 200,40);
		saveSiBtn.setFont(top);
		saveSiBtn.setBackground(Color.WHITE);


		panelBackground2.add(reInfoBtn = new JButton("�� �� �� �� �� �� ��"));
		reInfoBtn.setBounds(570, 500, 200,40);
		reInfoBtn.setFont(top);
		reInfoBtn.setBackground(Color.WHITE);
		reInfoBtn.setEnabled(false);


		
		
		
		//////////////�̹��� ���� �����ͼ� �ֱ�///////////////////
		panelProfil = new ImagePanel();
		panelBackground2.add(panelProfil);
		panelProfil.setBounds(95,110, 200, 200);
		
		String s="tib/user.png";
		 panelProfil.setPath(s);//�̹��� �ǳڿ� �̹����� �����´�
		 panelProfil.repaint();//�̹��� �ǳڿ� �̹����� �׸���.
		
		getImg = new FileDialog(this,"�̹��� ����",FileDialog.LOAD);
		
		///////////////////////////�̹�Ʈ ����//////////////////////
		proCallBtn.addActionListener(this);
		proReBtn.addActionListener(this);
		
		login.addActionListener(this);
		logoutBtn.addActionListener(this);
		
		calBtn.addActionListener(this);
		
		/////////////////diallog â ���� ����/////////////////////////////////////
       	checkNBtn.addActionListener(this);
		checkIBtn.addActionListener(this);
		checkPBtn.addActionListener(this);
		checkPBtn2.addActionListener(this);
		saveSiBtn.addActionListener(this);
		
		
		setSize(1500, 800);
		setVisible(true);
		validate();
		setLocationRelativeTo(null);//�ǳ��� �߰��� ��ġ ��Ų��. 
	}
/////////////�̹��� �������� Ŭ����////////
		
	class ImagePanel extends JPanel{
	
		Image image;
		Toolkit toolkit = getToolkit();//�̹����� �������� ���ؼ� 
		
		public void setPath(String src) {
			image = toolkit.getImage(src);//��μ���
		}
		
		public void paint(Graphics g) {
			g.clearRect(0,0,200,200);
			if(image != null)
				g.drawImage(image ,0,0,this);//��ΰ� �������� ���
		}
	
	}//ImagePanelŬ����
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		
		if(proCallBtn==obj||proReBtn==obj) {//������ �̹��� ��������
			 getImg.setVisible(true);
			 String s=getImg.getDirectory()+getImg.getFile();
			 panelProfil.setPath(s);//�̹��� �ǳڿ� �̹����� �����´�
			 panelProfil.repaint();//�̹��� �ǳڿ� �̹����� �׸���.
			 return;
		} else if (login==obj){//welcome ��ư�� ������ choose Ŭ������ �Ѿ��.
			this.setVisible(false);
			JFrame frame = new Login();
			frame.setVisible(true);
			return;
	   } else if (logoutBtn == obj){//logout ��ư�� ������ ����ȴ�.
		   this.setVisible(false);
		    Login Login = new Login();
		    Login.setVisible(true);
	   }else if (calBtn == obj){// �޷� ��ư�� ������ ���� ������ �����Ҽ� �ִ�. 
		    new SwingCalendar4(this);//�̷��Ը� �ص� JDatePicker�� ȣ���
		   
	//////////////////////////dialogâ ����///////////////////////////////////////////////		
	   } else if (saveSiBtn == obj ||checkNBtn == obj||checkIBtn == obj||checkPBtn == obj
			   ||checkPBtn2 == obj||reInfoBtn==obj) {
		   String title="�˸�", msg1="", msg2="",
				 nameitem=nameTf.getText(),  iditem=idTf.getText(), passitem=passTf.getText(),
				 pass2item=passTf2.getText(), emailitem=emailTf.getText(),
				 tel1item=telTf2.getText(), tel2item=telTf3.getText(),birthItem=birthTf.getText();
		 
	        if(checkNBtn == obj) {   		
			   	 if (nameitem.trim().length() >10 || nameitem.trim().length() == 0 || nameitem.trim().equals("bean.name")
			   			 ||nameitem.equals("  10�� �̳�")){//�г��� �ߺ� Ȯ��
			   		msg1 = "����� �� ���� �г����Դϴ�.";
			   		msg2 = "�ٽ� ����� �ߺ�Ȯ�� ���ּ���";
		   			nameTf.requestFocus();
		   			}else {
		   				msg1 = "��� ������";
				   		msg2 = "�г��� �Դϴ�. ";
				   		idTf.requestFocus();	
		   			}
			
			}else if(checkIBtn == obj) {	   	
			   	   if (iditem.trim().length() >10 || iditem.trim().length() == 0 ||iditem.trim().equals("bean.name")
			   			 ||iditem.equals("  10�� �̳�")){//ID �ߺ� Ȯ��
			   		   msg1 = "����� �� ���� ID�Դϴ�.";
			   		   msg2 = "�ٽ� ����� �ߺ�Ȯ�� ���ּ���";
			   		   idTf.requestFocus();
		   			}else {
		   				msg1 = "��� ������";
				   		msg2 = "ID�Դϴ�.";
				   		passTf.requestFocus();	
		   			}
			}else if(checkPBtn == obj) {   	   
			   	 if(passitem.trim().length() == 0) {//�н�����κ� �������� Ȯ��
			   		msg1 = "�н����带 ";
			   		msg2 = "�Է��� �ּ���";
			   		passTf.requestFocus();
			   	 } else {//�빮�ڿ� Ư������ ��� Ȯ��
			   		int count = 0;
			   		for(int i=0; i<passitem.length();i++ ) {//�н�����κ� Ư�������ִ��� Ȯ��
			   			char c = passitem.charAt(i);
			   			if(c=='~'||c=='@'||c=='#'||c=='$'||c=='%'||c=='^'||c=='&'||c=='*'||c=='!') {
			   			count ++;
			   			if(count == 1) break; //Ư������ 1�� ��������� Ư������ for�� ����
			   			}//Ư������ if
			   		}//Ư������for
			   		if(count ==0) {//Ư�����ڰ� ������ �ʾ�����
			   			msg1 = " Ư�����ڸ�";
			   			msg2 = "1���̻� ����� �ּ���";
			   			passTf.requestFocus();
			   		}	else {//Ư�����ڸ� 1���̻� ��������� �빮�� ��� üũ
				   			count =0;
				   			for(int j=0; j< passitem.length() ;j++) {
			   					char c= passitem.charAt(j);
			   					if('A'<= c && c<='Z') { // �νľȉ�
			   						count ++;
			   						if(count ==1) break;
			   					}//�빮�� �����ϸ� for�� ���
			   				}//�빮�� for
					   		if(count==0)  {//�빮�ڸ� ������� �ʾ�����
					   			msg1 = "���� �빮�ڸ� ";
					   			msg2 = "1���̻� ����� �ּ���.";
					   			passTf.requestFocus();
					   			}else {
						   		msg1 = "��� ������";
						   		msg2 = "��й�ȣ �Դϴ�. ";
						   		passTf2.requestFocus();
						   		}	
				   		}//Ư�����ڸ� ����
			   	 
			  }//�н����尡 �ԷµǾ����	 
			} else if(checkPBtn2==obj) { 
				if(pass2item.trim().length() == 0) {//�н�����κ� �������� Ȯ��
			   		msg1 = "�н����带 ";
			   		msg2 = "�Է��� �ּ���";
			   		passTf2.requestFocus();
			   	 }
				else if( !passitem.equals(pass2item)) {
			   		msg1 = "��й�ȣ��";
		   			msg2 = "��ġ���� �ʽ��ϴ�.";
		   			passTf2.requestFocus();
			   	 }else {
			   		 msg1 = "��й�ȣ��";
			   		 msg2 = "�ٸ��� �ԷµǾ����ϴ�. ";
			   		genderC.requestFocus();
			   	 }
			}else if(saveSiBtn == obj) {
				 if (nameitem.trim().length() >10 || nameitem.trim().length() == 0 || nameitem.trim().equals("bean.name")
						 ||nameitem.equals("  10�� �̳�")){//�г��� �ߺ� Ȯ��
				   		msg1 = "����� �� ���� �г����Դϴ�.";
				   		msg2 = "�ٽ� ����� �ߺ�Ȯ�� ���ּ���";
			   			nameTf.requestFocus();
			   	}else if (iditem.trim().length() >10 || iditem.trim().length() == 0 ||iditem.trim().equals("bean.name")
			   		 ||iditem.equals("  10�� �̳�")){//ID �ߺ� Ȯ��
					   msg1 = "����� �� ���� ID�Դϴ�.";
					   msg2 = "�ٽ� ����� �ߺ�Ȯ�� ���ּ���";
					   idTf.requestFocus();
				}else	 if(passitem.trim().length() == 0) {//�н�����κ� �������� Ȯ��
			   		msg1 = "�н����带 ";
			   		msg2 = "�Է��� �ּ���";
			   		passTf.requestFocus();
				} else  if(passitem.trim().length() != 0)  {//�빮�ڿ� Ư������ ��� Ȯ��
				   		int count = 0;
				   		for(int i=0; i<passitem.length();i++ ) {//�н�����κ� Ư�������ִ��� Ȯ��
				   			char c = passitem.charAt(i);
				   			if(c=='~'||c=='@'||c=='#'||c=='$'||c=='%'||c=='^'||c=='&'||c=='*'||c=='!') {
				   			count ++;
				   			if(count == 1) break; //Ư������ 1�� ��������� Ư������ for�� ����
				   			}//Ư������ if
				   		}//Ư������for
				   		if(count ==0) {//Ư�����ڰ� ������ �ʾ�����
				   			msg1 = " Ư�����ڸ�";
				   			msg2 = "1���̻� ����� �ּ���";
				   			passTf.requestFocus();
				   		}	else {//Ư�����ڸ� 1���̻� ��������� �빮�� ��� üũ
					   			count =0;
					   			for(int j=0; j< passitem.length() ;j++) {
				   					char c= passitem.charAt(j);
				   					if('A'<= c && c<='Z') { // �νľȉ�
				   						count ++;
				   						if(count ==1) break;
				   					}//�빮�� �����ϸ� for�� ���
				   				}//�빮�� for
						   		if(count==0)  {//�빮�ڸ� ������� �ʾ�����
						   			msg1 = "���� �빮�ڸ� ";
						   			msg2 = "1���̻� ����� �ּ���.";
						   			passTf.requestFocus();
						   			}else if(pass2item.trim().length() == 0) {//�н�����κ� �������� Ȯ��
								   		msg1 = "�н����带 ";
								   		msg2 = "���Է��� �ּ���";
								   		passTf2.requestFocus();
								   	 }	else if( !passitem.equals(pass2item)) {
								   		msg1 = "��й�ȣ��";
							   			msg2 = "��ġ���� �ʽ��ϴ�.";
							   			passTf2.requestFocus();
								   	 } else	 if(birthItem.trim().length() == 0) {
									   		msg1 = "���������";
									   		msg2 = "�Է��� �ּ���";
									   		calBtn.requestFocus();
								   	}	else	 if(emailitem.trim().length() == 0) {
								   		msg1 = "�̸��� �ּҸ�";
								   		msg2 = "�Է��� �ּ���";
								   		emailTf.requestFocus();
							   		} else if(tel1item.trim().length() == 0) {
								   		msg1 = "��ȭ��ȣ��";
								   		msg2 = "�Է��� �ּ���";
								   		telTf2.requestFocus();
							   		} else if(tel2item.trim().length() == 0) {
								   		msg1 = "��ȭ��ȣ��";
								   		msg2 = "�Է��� �ּ���";
								   		telTf3.requestFocus();
							   		} else if(tel2item.trim().length() == 0) {
								   		msg1 = "��ȭ��ȣ��";
								   		msg2 = "�Է��� �ּ���";
							   		} else {
							   			MemberBean  bean;
							   			mgr = new MemberMgr();
							   			bean = new MemberBean();
							   			
							   			bean.setName(nameTf.getText());
							   			bean.setId(idTf.getText());
							   			bean.setPassword(passTf.getText());
							   			bean.setPassword(passTf2.getText());
							   			bean.setGender(genderC.getSelectedItem());
							   			bean.setBirth(birthTf.getText());
							   			bean.setEmail(emailTf.getText());
							   			bean.setPhone(comboTel.getSelectedItem()+"-"+telTf2.getText()+ "-"+telTf3.getText());
							   			//bean.setImg(img);
							   			if (mgr.insertMember(bean)) {
							   				System.out.println("�����Ϸ�");
							   			}
							   				
							   			//}
							   			msg1 = "�������� ����������";
								   		msg2 = "�����Ͽ����ϴ�.";
								   		this.setVisible(false);
										JFrame frame = new Login();
										frame.setVisible(true);
									}
								     
					   		}//Ư�����ڸ� ����
	            	  //�н����尡 �ԷµǾ����	 
			     } 
	   		}else if(reInfoBtn == obj) {
	   			if (nameitem.trim().length() >10 || nameitem.trim().length() == 0 || nameitem.trim().equals("bean.name")
						 ||nameitem.equals("  10�� �̳�")){//�г��� �ߺ� Ȯ��
				   		msg1 = "����� �� ���� �г����Դϴ�.";
				   		msg2 = "�ٽ� ����� �ߺ�Ȯ�� ���ּ���";
			   			nameTf.requestFocus();
			   	}else if (passitem.trim().length() == 0) {//�н�����κ� �������� Ȯ��
			   		msg1 = "�н����带 ";
			   		msg2 = "�Է��� �ּ���";
			   		passTf.requestFocus();
				} else  if(passitem.trim().length() != 0)  {//�빮�ڿ� Ư������ ��� Ȯ��
				   		int count = 0;
				   		for(int i=0; i<passitem.length();i++ ) {//�н�����κ� Ư�������ִ��� Ȯ��
				   			char c = passitem.charAt(i);
				   			if(c=='~'||c=='@'||c=='#'||c=='$'||c=='%'||c=='^'||c=='&'||c=='*'||c=='!') {
				   			count ++;
				   			if(count == 1) break; //Ư������ 1�� ��������� Ư������ for�� ����
				   			}//Ư������ if
				   		}//Ư������for
				   		if(count ==0) {//Ư�����ڰ� ������ �ʾ�����
				   			msg1 = " Ư�����ڸ�";
				   			msg2 = "1���̻� ����� �ּ���";
				   			passTf.requestFocus();
				   		}	else {//Ư�����ڸ� 1���̻� ��������� �빮�� ��� üũ
					   			count =0;
					   			for(int j=0; j< passitem.length() ;j++) {
				   					char c= passitem.charAt(j);
				   					if('A'<= c && c<='Z') { // �νľȉ�
				   						count ++;
				   						if(count ==1) break;
				   					}//�빮�� �����ϸ� for�� ���
				   				}//�빮�� for
						   		if(count==0)  {//�빮�ڸ� ������� �ʾ�����
						   			msg1 = "���� �빮�ڸ� ";
						   			msg2 = "1���̻� ����� �ּ���.";
						   			passTf.requestFocus();
						   			}else if(pass2item.trim().length() == 0) {//�н�����κ� �������� Ȯ��
								   		msg1 = "�н����带 ";
								   		msg2 = "���Է��� �ּ���";
								   		passTf2.requestFocus();
								   	 }	else if( !passitem.equals(pass2item)) {
								   		msg1 = "��й�ȣ��";
							   			msg2 = "��ġ���� �ʽ��ϴ�.";
							   			passTf2.requestFocus();
								   	 } else	 if(birthItem.trim().length() == 0) {
									   		msg1 = "���������";
									   		msg2 = "�Է��� �ּ���";
									   		calBtn.requestFocus();
								   	}	else	 if(emailitem.trim().length() == 0) {
								   		msg1 = "�̸��� �ּҸ�";
								   		msg2 = "�Է��� �ּ���";
								   		emailTf.requestFocus();
							   		} else if(tel1item.trim().length() == 0) {
								   		msg1 = "��ȭ��ȣ��";
								   		msg2 = "�Է��� �ּ���";
								   		telTf2.requestFocus();
							   		} else if(tel2item.trim().length() == 0) {
								   		msg1 = "��ȭ��ȣ��";
								   		msg2 = "�Է��� �ּ���";
								   		telTf3.requestFocus();
							   		} else if(tel2item.trim().length() == 0) {
								   		msg1 = "��ȭ��ȣ��";
								   		msg2 = "�Է��� �ּ���";
							   		} else {
							   			MemberBean  bean;
							   			mgr = new MemberMgr();
							   			bean = new MemberBean();
							   			
							   			bean.setIdx(idx);
							   			bean.setName(nameTf.getText());
							   			bean.setId(idTf.getText());
							   			bean.setPassword(passTf.getText());
							   			bean.setPassword(passTf2.getText());
							   			bean.setGender(genderC.getSelectedItem());
							   			bean.setBirth(birthTf.getText());
							   			bean.setEmail(emailTf.getText());
							   			bean.setPhone(comboTel.getSelectedItem()+"-"+telTf2.getText()+ "-"+telTf3.getText());
							   			
							   			if (mgr.updateMember(bean)) {
							   				System.out.println(123);
							   			}
							   										   			
							   			msg1 = "�������� ����������";
								   		msg2 = "�����Ͽ����ϴ�.";
								   		this.setVisible(false);
								   		Choose frame = new Choose();
								   		frame.setVisible(true);
									}
				   				}     
					   		}//Ư�����ڸ� ����
	            	  //�н����尡 �ԷµǾ����	 
			     }   					   
		   MDialog md = new MDialog(this, title, msg1, msg2, true);
			int width = 250;
			int height = 200;
			int x = getX() + getWidth() / 2 - width / 2;
			int y = getY() + getHeight() / 2 - height / 2;
			md.setBounds(x, y, width, height);
			md.setVisible(true);
					   
		 }//��� ������ �Է��� ���	   		
		
		
		}//action
	
	


	class MDialog extends JDialog implements ActionListener{
		JButton btnu;
		JLabel msg1L;
		JLabel msg2L;
		
		public MDialog(Frame f,String title, String msg1,String msg2, boolean flag) {
			super(f, title, flag);
							
			setLayout(null);
			add(msg1L = new JLabel(msg1));
			add(msg2L = new JLabel(msg2));
		     			
			add(btnu = new JButton("Ȯ��"));
			
								
			msg1L.setBounds(30,20,200,30);
			msg2L.setBounds(30,60,200,30);
			btnu.setBounds(80,100,70,30);
			btnu.addActionListener(this);
		    }
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			}
		}//MDialog Ŭ����
		
		

	
	public static void main(String[] args) {
		
		new Signin();
	}
}