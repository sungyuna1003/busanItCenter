package tib;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Option extends JFrame implements ActionListener {

	JLabel lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9;
	JButton btnq, btn1, btn2, btna, btnb, btnc, btnd, btnf, labLogout, btnLogout, btnLogo;
	ImageIcon busan, background, background2, date;
	TextArea ta;
	Checkbox box[] = new Checkbox[2];
	JRadioButton rMan, rWoman;
	TextField fi1, fi2;
	Button logoutBtn;
	Vector<DesignBean> vlist;
	DesignMgr mgr;
	int idx, dcode;
	ButtonGroup group;
	Introduce duce;
	String id;

	String ra1[] = { "�Ⱓ ����", "����", "1��2��", "2��3��", "3��4��" };
	String ra2[] = { "�λ�� �� ����", "������", "������", "���屺", "����", "����", "������", "�λ�����", "�ϱ�", "���", "���ϱ�", "����", "������", "������",
			"������", "�߱�", "�ؿ�뱸" };
	String ra3[] = { "���� ����", "10��", "20��", "30��", "40��", "50���̻�" };
	String ra4[] = { "����ο� ����", "2~3��", "3~4��", "5~6��","7���̻�" };
	JComboBox<String> combo1, combo2, combo3, combo4;

	public Option() {// �� �޴� ������ Ŭ���� ������ �� �ִ� â pop up����

		mgr = new DesignMgr();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Travle in Busan");

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

		Date time = new Date();

		String time1 = format1.format(time);
		String time2 = format2.format(time);

		busan = new ImageIcon("tib/busanwhite157.png");
		JPanel panelLogo = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(busan.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};

		background2 = new ImageIcon("tib/beige.png");
		JPanel panelBackground2 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background2.getImage(), 0, 0, null);
				setOpaque(false);// �ȹ��

			}
		};

		background = new ImageIcon("tib/background800.jpg");
		JPanel panelBackground = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);// �ٱ����

			}
		};

		date = new ImageIcon("tib/date.png");
		JPanel panelKa = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(date.getImage(), 0, 0, null);
				setOpaque(false);// �ٱ����
			}
		};

////////////////// �ϴ� ��ư ����//////////////////////////////////////

		panelBackground2.add(btn2 = new JButton("�˻��ϱ�"));
		btn2.setBounds(480, 540, 150, 30);
		btn2.addActionListener(this);

		/*panelBackground2.add(btnq = new JButton("�����ϰ� �˻��ϱ�"));
		btnq.setBounds(480, 540, 300, 30);
		btnq.addActionListener(this);*/

///////////////////////////////////////////////////////////////////////
		// ������ �ΰ�//
		btnLogo = new JButton(busan);
		btnLogo.setBounds(180, 20, 180, 50);
		btnLogo.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogo);
		btnLogo.addActionListener(this);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(1190, 30, 90, 30);
		btnLogout.setBackground(new Color(0, 0, 0));
		panelBackground.add(btnLogout);
		btnLogout.addActionListener(this);

		panelBackground2.add(lab1 = new JLabel("�����ͷ� �˷��ִ� ������ ����"));
		lab1.setBounds(320, 50, 1100, 50);

		panelBackground2.add(lab2 = new JLabel("����Ⱓ�� ������õ ������ ������ �帳�ϴ�."));
		lab2.setBounds(380, 90, 1100, 50);

		panelBackground2.add(lab3 = new JLabel("�Ⱓ"));
		lab3.setBounds(320, 160, 1100, 50);

		panelBackground2.add(combo1 = new JComboBox<String>(ra1));
		combo1.setBounds(520, 170, 290, 30);

		panelBackground2.add(lab4 = new JLabel("��������"));
		lab4.setBounds(320, 220, 190, 50);
		
		panelBackground2.add(fi1 = new TextField(time1, 5));
		fi1.setBounds(520, 230, 100, 30);

		panelBackground2.add(btnc = new JButton(date));
		btnc.setBounds(630, 230, 30, 30);
		btnc.addActionListener(this);


		panelBackground2.add(lab5 = new JLabel("���� ����"));
		lab5.setBounds(320, 280, 1100, 50);

		panelBackground2.add(combo2 = new JComboBox<String>(ra2));
		combo2.setBounds(520, 290, 290, 30);

		panelBackground2.add(lab6 = new JLabel("������� ����"));
		lab6.setBounds(320, 340, 1100, 50);

		panelBackground2.add(combo3 = new JComboBox<String>(ra3));
		combo3.setBounds(520, 350, 290, 30);

		panelBackground2.add(lab7 = new JLabel("������� ����"));
		lab7.setBounds(320, 400, 1100, 50);

		panelBackground2.add(rMan = new JRadioButton("����", true));
		panelBackground2.add(rWoman = new JRadioButton("����"));
		group = new ButtonGroup();
		group.add(rMan);
		group.add(rWoman);
		rMan.setBounds(570, 410, 80, 40);
		rMan.setBackground(new Color(251, 246, 240));
		rWoman.setBounds(680, 410, 80, 40);
		rWoman.setBackground(new Color(251, 246, 240));

		panelBackground2.add(lab9 = new JLabel("����ο� ����"));
		lab9.setBounds(320, 460, 1100, 50);

		panelBackground2.add(combo4 = new JComboBox<String>(ra4));
		combo4.setBounds(520, 470, 290, 30);

		panelBackground2.setLayout(null);
		panelBackground2.setBounds(180, 80, 1100, 620);
		panelBackground2.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "��"));
		panelBackground2.setBackground(new Color(0, 0, 0, 50));
		add(panelBackground2);

		panelBackground.setLayout(null);
		panelBackground.setBounds(0, 0, 1500, 800);
		add(panelBackground);
////////////////////////////////////////////////////////////////////////////////////		
		// ��Ʈ//
		Font title = new Font("�������", Font.BOLD, 30);
		Font list = new Font("�������", Font.BOLD, 15);
		Font top = new Font("�������", Font.BOLD, 15);

		lab1.setFont(title);
		lab2.setFont(list);
		lab3.setFont(list);
		lab4.setFont(list);
		lab5.setFont(list);
		lab6.setFont(list);
		lab7.setFont(list);
		lab9.setFont(list);
		fi1.setFont(list);

		rMan.setFont(list);
		rWoman.setFont(list);

		
		btnLogout.setFont(top);
		btnLogout.setFont(top);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBackground(Color.BLACK);

		btn2.setBackground(Color.WHITE);
		combo1.setBackground(Color.WHITE);
		combo2.setBackground(Color.WHITE);
		combo3.setBackground(Color.WHITE);
		combo4.setBackground(Color.WHITE);

		btnc.setBackground(Color.WHITE);


		rMan.setForeground(Color.BLACK);
		rWoman.setForeground(Color.BLACK);

		setSize(1500, 800);
		setVisible(true);
		validate();
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (btnc == obj) {
			new SwingCalendar(this);
		} else if (btnd == obj) {
			new SwingCalendar2(this);
		} else if (btnLogout == obj) {
			this.setVisible(false);
			Login Login = new Login();
			Login.setVisible(true);
		} else if (btn2 == obj) {
			
			DesignBean bean = new DesignBean();
			bean.setIdx(idx);
			bean.setPeriod((String) combo1.getSelectedItem());
			bean.setDdate(fi1.getText());
			bean.setArea((String) combo2.getSelectedItem());
			bean.setDage((String) combo3.getSelectedItem());
			String msg = "����";
			if(!rMan.isSelected()) msg = "����";
			bean.setGender(msg);
			bean.setNump((String) combo4.getSelectedItem());
			this.setVisible(false);
			Place Place = new Place();
			Place.setVisible(true);
			//duce = new Introduce( dcode);
			//duce.setVisible(true);
			boolean flag = mgr.insertDesign(bean);
			if(flag==true) {
				//duce.updateForm(bean);
			}
		} else if (obj == btnLogo) {
			this.setVisible(false);
			Choose Choose = new Choose();
			Choose.setVisible(true);
			
		}
	}

	class MBack extends JDialog implements ActionListener {

		int width = 200;
		int height = 145;
		JButton btnu;
		JLabel msg1L;
		Frame f;

		public MBack(Frame f, String title, String msg, boolean flag) {
			super(f, title, flag);
			this.f = f;
			int xmsg = msg.length();

			setLayout(null);
			add(msg1L = new JLabel("sibar"));
			add(btnu = new JButton("Ȯ��"));
			msg1L.setBounds(40, 20, 150, 25);

			btnu.setBounds(60, 55, 60, 30);
			btnu.addActionListener(this);
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

	//// JFrame ������ ����//////////////////////////////////////////
	public static void main(String[] args) {
		new Option();
	}
}
