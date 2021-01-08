package Demo;

import javax.swing.*;

import com.xzy.pojo.Basketballmate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Check extends JPanel implements ActionListener {

	JLabel Inputlabel;
	JTextField Inputtext;
	JButton Findbt;
	JLabel Namelabel;
	JLabel Agelabel;
	JLabel Scorelabel;
	JLabel Idlabel;
	JLabel Positionlabel;
	JTextField Nametext;
	JTextField Agetext;
	JTextField Scoretext;
	JTextField Idtext;
	JTextField Positiontext;

	JButton butcollection;
	JLabel Idxlabel;
	JTextField Idxtext;

	public Check() {

		this.setSize(650, 350);
		this.setLocation(100, 20);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);

		Namelabel = new JLabel("��Ա����");
		Namelabel.setSize(100, 30);
		Namelabel.setLocation(100, 120);
		this.add(Namelabel);

		Nametext = new JTextField();
		Nametext.setSize(120, 30);
		Nametext.setLocation(220, 120);
		this.add(Nametext);

		Agelabel = new JLabel("��Ա����");
		Agelabel.setSize(100, 30);
		Agelabel.setLocation(100, 160);
		this.add(Agelabel);

		Agetext = new JTextField();
		Agetext.setSize(120, 30);
		Agetext.setLocation(220, 160);
		this.add(Agetext);

		Idlabel = new JLabel("��Ա����");
		Idlabel.setSize(100, 30);
		Idlabel.setLocation(100, 200);
		this.add(Idlabel);

		Idtext = new JTextField();
		Idtext.setSize(120, 30);
		Idtext.setLocation(220, 200);
		this.add(Idtext);

		Scorelabel = new JLabel("��Ա�÷�");
		Scorelabel.setSize(100, 30);
		Scorelabel.setLocation(100, 240);
		this.add(Scorelabel);

		Scoretext = new JTextField();
		Scoretext.setSize(120, 30);
		Scoretext.setLocation(220, 240);
		this.add(Scoretext);

		Positionlabel = new JLabel("��Աλ��");
		Positionlabel.setSize(100, 30);
		Positionlabel.setLocation(100, 280);
		this.add(Positionlabel);

		Positiontext = new JTextField();
		Positiontext.setSize(120, 30);
		Positiontext.setLocation(220, 280);
		this.add(Positiontext);

		Inputlabel = new JLabel("��Ա����");
		Inputlabel.setSize(150, 50);
		Inputlabel.setLocation(100, 45);
		this.add(Inputlabel);

		Inputtext = new JTextField();
		Inputtext.setSize(160, 40);
		Inputtext.setLocation(200, 45);
		this.add(Inputtext);

		Findbt = new JButton("��ѯ");
		Findbt.setSize(90, 38);
		Findbt.setLocation(420, 45);
		this.add(Findbt);
		Findbt.addActionListener(this);

		Idxlabel = new JLabel("����Ա����");
		Idxlabel.setSize(100, 30);
		Idxlabel.setLocation(400, 200);

		this.add(Idxlabel);

		Idxtext = new JTextField(30);
		Idxtext.setSize(120, 30);
		Idxtext.setLocation(500, 200);
		this.add(Idxtext);

		butcollection = new JButton("�ղ�");
		butcollection.setSize(80, 30);
		butcollection.setLocation(400, 250);
		this.add(butcollection);
		butcollection.addActionListener(this);

		this.setVisible(true);

		butcollection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// String addPosition=Positiontext.getText();
				String inputId = Idxtext.getText();
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					// ���ض�Ӧ��jdbc����
					String url = "jdbc:sqlserver://localhost:1433; DatabaseName=X";
					// ���������ַ���
					String user = "sa";// sa��������Ա
					String password = "123456";// ����
					Connection conn = DriverManager.getConnection(url, user, password);
					// �������ݿ����Ӷ���
					Statement st = conn.createStatement();
					// ����SQL���ִ�ж���

					String strSQL = "select * from basketballmate where id='" + inputId + "'";
					ResultSet rs1 = st.executeQuery(strSQL);

					// PreparedStatement pstmt1=conn.prepareStatement("select * from basketballmate
					// where id='"+txt+"'");
					// pstmt1.setString(1, id);
					// ResultSet rs1=pstmt1.executeQuery();

					ArrayList<Basketballmate> list1 = new ArrayList<>();
					while (rs1.next()) {
						Basketballmate mate = new Basketballmate();
						mate.setName(rs1.getString(1));
						mate.setAge(rs1.getInt(2));
						mate.setId(rs1.getInt(3));
						mate.setScore(rs1.getInt(4));
						mate.setPosition(rs1.getString(5));
						list1.add(mate);
					}
					FileOutputStream fileOutputStream1 = new FileOutputStream(new File("E:\\Demo\\xzy.txt"));
					byte bt1[] = new byte[1024];
					bt1 = list1.toString().getBytes();
					fileOutputStream1.write(bt1);
					fileOutputStream1.close();

				} catch (Exception ex) {
					System.out.println("���ݿ����ӻ��������ݿ����ʧ��");
				}

			}

		});

		Findbt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String inputId = Inputtext.getText();

				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					// ���ض�Ӧ��jdbc����
					String url = "jdbc:sqlserver://localhost:1433; DatabaseName=X";
					// ���������ַ���
					String user = "sa";// sa��������Ա
					String password = "123456";// ����
					Connection conn = DriverManager.getConnection(url, user, password);
					// �������ݿ����Ӷ���
					Statement st = conn.createStatement();
					// ����SQL���ִ�ж���

					String strSQL = "select * from basketballmate where id='" + inputId + "'";
					ResultSet rs = st.executeQuery(strSQL);

					if (rs.next()) {

						Nametext.setText(rs.getString(1));
						Agetext.setText(rs.getString(2));
						Scoretext.setText(rs.getString(3));
						Idtext.setText(rs.getString(4));
						Positiontext.setText(rs.getString(5));
					} else {
						JOptionPane.showMessageDialog(null, "����ѯ����Ա�����ڣ�����������");
					}
					conn.close();

					// �ر����ݿ�����
				} catch (ClassNotFoundException ex) {
					System.out.println("û���ҵ���Ӧ�����ݿ�������");
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
					System.out.println("���ݿ����ӻ��������ݿ����ʧ��");
				}

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
