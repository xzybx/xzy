package Data;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public  class Username extends JFrame{
	//��ǩ
	private JLabel lable1;
	private JLabel lable2;

	//�ı���
	private JTextField text1;
	private JTextField text2;

	//��ť
	private JButton bt1;
	private JButton bt2;  
	private JButton bt3;
	//���캯��
	public Username()
	{
		this.init();
		this.addComponent();
		this.addListener();
	}
	
	public void init()
	{
		this.setSize(500,400);
		this.setVisible(true);
		this.setTitle("��¼����");
		this.setLayout(null);
		this.setLocation(700, 300);
	}
	private void addComponent()
	{
		lable1 = new JLabel("�û�");
		lable1.setSize(100,70);
		lable1.setLocation(100,80);
		this.add(lable1);
		lable2 = new JLabel("��    ��");
		lable2.setSize(100,70);
		lable2.setLocation(100,130);
		this.add(lable2);
		
		
		text1 = new JTextField();
		text1.setSize(150,30);
		text1.setLocation(160,100);
		this.add(text1);
		text2 = new JTextField();
		text2.setSize(150,30);
		text2.setLocation(160,150);
		this.add(text2);
	
	
		bt1 = new JButton("��¼");
		bt1.setSize(70,30); 
		bt1.setLocation(140,195);
		this.add(bt1);
		bt2 = new JButton("�˳�");
		bt2.setSize(70,30);
		bt2.setLocation(250,195);
		this.add(bt2);
		
		
		this.setBackground(Color.blue);
		//���õ����رհ�ťʱ��Ĭ�ϲ���
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void addListener()
	{
		bt1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(text1.getText().equals("123")&&text2.getText().equals("123"))
				{
					new Username();
				    dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "��½�������");
				}
			}
		});
		
		bt2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});

	}

public static void main(String[] args) {
	 new Username();
	}
	}