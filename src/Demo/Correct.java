package Demo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Correct extends JPanel implements ActionListener {
	  
	   JLabel Namelabel;
	   JLabel Agelabel;
	   JLabel Scorelabel;
	   JLabel Idlabel;
	   JLabel Positionlabel;
	   JLabel OldIdlabel;
	   JTextField Nametext;
	   JTextField Agetext;
	   JTextField Idtext;
	   JTextField Scoretext;
	   JTextField Positiontext;
	   JTextField OldIdtext;
	   JButton Updatebt;
	   JScrollPane scrollpane;
	   JTable table;
	   ResultSet rs;
		
	    public Correct() {
		   this.setSize(650,350);
		   this.setLocation(100, 20);
		   this.setLayout(null);
	       this.setBackground(Color.BLUE);//68 34
	      
	   	OldIdlabel=new JLabel("ԭ��Ա����");
		OldIdlabel.setSize(100,30);
		OldIdlabel.setLocation(330, 40);
		
		this.add(OldIdlabel);
		
		OldIdtext=new JTextField();
		OldIdtext.setSize(120,30);
		OldIdtext.setLocation(410, 40);
		this.add(OldIdtext);
	       
			Namelabel=new JLabel("�޸ĵ���Ա����");
			Namelabel.setSize(100,30);
			Namelabel.setLocation(60, 20);
			
			this.add(Namelabel);
			
			Nametext=new JTextField();
			Nametext.setSize(120,30);
			Nametext.setLocation(180, 20);
			this.add(Nametext);
			
			Agelabel=new JLabel("�޸ĵ���Ա����");
			Agelabel.setSize(100,30);
			Agelabel.setLocation(60, 60);
			this.add(Agelabel);
			
			Agetext=new JTextField();
			Agetext.setSize(120,30);
			Agetext.setLocation(180, 60);
			this.add(Agetext);
			
			
			Idlabel=new JLabel("�޸ĵ���Ա����");
			Idlabel.setSize(100,30);
			Idlabel.setLocation(60, 100);
			this.add(Idlabel);
			
			Idtext=new JTextField();
			Idtext.setSize(120,30);
			Idtext.setLocation(180, 100);
			this.add(Idtext);
		
			Scorelabel=new JLabel("�޸ĵ���Ա�÷�");
			Scorelabel.setSize(100,30);
			Scorelabel.setLocation(60, 140);
			this.add(Scorelabel);
			
			Scoretext=new JTextField();
			Scoretext.setSize(120,30);
			Scoretext.setLocation(180, 140);
			this.add(Scoretext);
			
			Positionlabel=new JLabel("�޸ĵ���Աλ��");
			Positionlabel.setSize(100,30);
			Positionlabel.setLocation(60,180);
			this.add(Positionlabel);
			
			Positiontext=new JTextField();
			Positiontext.setSize(120,30);
			Positiontext.setLocation(180, 180);
			this.add(Positiontext);
			
			 Updatebt=new JButton("�޸�");
			 Updatebt.setSize(80,30);
			 Updatebt.setLocation(350, 80);
			 this.add( Updatebt);  
			 Updatebt.addActionListener(this);
				
			this.setVisible(true);
			
		  } 
	 
		@Override
		public void actionPerformed(ActionEvent e) {
 	 try {
		
		@SuppressWarnings("unused")
		String OldIdX=OldIdtext.getText();
	    String updateName=Nametext.getText();
		String updateScore=Scoretext.getText();
		String updateAge=Agetext.getText();
		String updateId=Idtext.getText();
		String updatePosition=Positiontext.getText();
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//���ض�Ӧ��jdbc����
		String url="jdbc:sqlserver://localhost:1433; DatabaseName=X";
		//���������ַ���
		String user="sa";//��������Ա
		String password="123456";//����
		Connection conn=DriverManager.getConnection(url,user,password);
		//�������ݿ����Ӷ���
		Statement st=conn.createStatement();
		  System.out.println("aaaaaaaaaaa");
		 
		 
		  /*String sql1= "update basketballmate set name='"+updateName+"' where id='"+updateId+"'";
		  String sql2= "update basketballmate set age='"+updateAge+"' where id='"+updateId+"'";
		  String sql3= "update basketballmate set score='"+updateScore+"' where id='"+updateId+"'";
		  String sql4= "update basketballmate set name='"+updatePosition+"' where id='"+updateId+"'";*/
		  String sql1= "update basketballmate set name='"+updateName+"',age='"+updateAge+"',id='"+updateId+"',score='"+updateScore+"',position='"+updatePosition+"' where id='"+OldIdX+"'";
		  System.out.println("122222");
		  
		  
		 int rs=st.executeUpdate(sql1);

		 
		  System.out.println("9999999");
		 
		 if(rs==1) {
			 JOptionPane.showMessageDialog(null,"�γ��޸ĳɹ�");
			  System.out.println("04983796");
			 
		 }else{
			 JOptionPane.showMessageDialog(null,"�γ��޸�ʧ��");
		 
		 }        
	    conn.close();
		//�ر����ݿ�����	
		 } 
	catch (ClassNotFoundException ex) {
		System.out.println("û���ҵ���Ӧ�����ݿ�������");
	}
	catch (SQLException ex) {
		System.out.println("���ݿ����ӻ��������ݿ����ʧ��");
	}

}
}
