package Demo;

import java.awt.Color;
import java.awt.LayoutManager;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public  class Add extends JPanel implements ActionListener{
 
JLabel Namelabel;
   JLabel Agelabel;
   JLabel Idlabel;
   JLabel Scorelabel;
   JLabel Positionlabel;
   JTextField Nametext;
   JTextField Agetext;
   JTextField Scoretext;
   JTextField Idtext;
   JTextField Positiontext;
      
   JButton Addbt;
   JScrollPane scrollpane;
   JTable table;

	
    public Add() {
	   this.setSize(650,350);
	   this.setLocation(150, 30);
	   this.setLayout(null);
       this.setBackground(Color.GREEN);
          
		Namelabel=new JLabel("��Ա����");
		Namelabel.setSize(100,30);
		Namelabel.setLocation(60, 20);
		
		this.add(Namelabel);
		
		Nametext=new JTextField();
		Nametext.setSize(120,30);
		Nametext.setLocation(180, 20);
		
		this.add(Nametext);
		
	    Agelabel=new JLabel("��Ա����");
		Agelabel.setSize(100,30);
		Agelabel.setLocation(60, 60);
		
		this.add(Agelabel);
		
		Agetext=new JTextField();
		Agetext.setSize(120,30);
		Agetext.setLocation(180, 60);
		
		this.add(Agetext);
		
		Scorelabel=new JLabel("��Ա�÷�");
		Scorelabel.setSize(100,30);
		Scorelabel.setLocation(60, 100);
		
		this.add(Scorelabel);
				
		Scoretext=new JTextField();
		Scoretext.setSize(120,30);
		Scoretext.setLocation(180, 100);
		
		this.add(Scoretext);
		//Scorelabel.add(Scoretext);
		
		
		Idlabel=new JLabel("��Ա����");
		Idlabel.setSize(100,30);
		Idlabel.setLocation(60, 140);
		
		this.add(Idlabel);
		
		Idtext=new JTextField();
		Idtext.setSize(120,30);
		Idtext.setLocation(180, 140);
		
		this.add(Idtext);
		

		Positionlabel=new JLabel("��Աλ�� ");
		Positionlabel.setSize(90,30);
		Positionlabel.setLocation(80, 200);
		
		this.add(Positionlabel);
		
		Positiontext=new JTextField();
		Positiontext.setSize(120,30);
		Positiontext.setLocation(180,180);
		
		this.add(Positiontext);
		
		Addbt=new JButton("���");
		Addbt.setSize(80,30);
		Addbt.setLocation(350, 80);
		this.add(Addbt);  
		Addbt.addActionListener(this);
		
		this.setVisible(true);
		
    }	
	

		


		@Override
		public void actionPerformed(ActionEvent e) {
			
			String addName=Nametext.getText();
			String addAge=Agetext.getText();
			String addScore=Scoretext.getText();
			String addId=Idtext.getText();
			String addPosition=Positiontext.getText();
		
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//���ض�Ӧ��jdbc����
		String url="jdbc:sqlserver://localhost:1433; DatabaseName=X";
		//���������ַ���
		String user="sa";//sa��������Ա
		String password="123456";//����
		Connection conn=DriverManager.getConnection(url,user,password);
		//�������ݿ����Ӷ���
		Statement st=conn.createStatement();
		//����SQL���ִ�ж���
     
	   String  strSQL="insert into  basketballmate values('"+addName+"','"+addAge+"','"+addScore+"','"+addId+"','"+addPosition+"')";
	   String  strSQL1="select* from  basketballmate where name='"+addName+"'";
	   
	  if(!addName.trim().equals("")&&!addAge.trim().equals("")&&!addScore.trim().equals(""))
	   {
		 ResultSet rs1=st.executeQuery(strSQL1);
		 
	     if(rs1.next())	 
	      {
		     JOptionPane.showMessageDialog(null,"����Ա�Ѵ���"); 
		   }
	     else {
	         int rs=st.executeUpdate(strSQL);
		  
	        if(rs==1) {
			      JOptionPane.showMessageDialog(null,"��Ա��Ϣ��ӳɹ�");
		        }
		    else{
			    JOptionPane.showMessageDialog(null,"��Ա��Ϣ���ʧ��");
		      }
	     }
	   }
	  else
	  { 
		  JOptionPane.showMessageDialog(null,"��������Ա��Ϣ");
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



