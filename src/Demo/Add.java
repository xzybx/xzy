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
          
		Namelabel=new JLabel("球员名字");
		Namelabel.setSize(100,30);
		Namelabel.setLocation(60, 20);
		
		this.add(Namelabel);
		
		Nametext=new JTextField();
		Nametext.setSize(120,30);
		Nametext.setLocation(180, 20);
		
		this.add(Nametext);
		
	    Agelabel=new JLabel("球员年龄");
		Agelabel.setSize(100,30);
		Agelabel.setLocation(60, 60);
		
		this.add(Agelabel);
		
		Agetext=new JTextField();
		Agetext.setSize(120,30);
		Agetext.setLocation(180, 60);
		
		this.add(Agetext);
		
		Scorelabel=new JLabel("球员得分");
		Scorelabel.setSize(100,30);
		Scorelabel.setLocation(60, 100);
		
		this.add(Scorelabel);
				
		Scoretext=new JTextField();
		Scoretext.setSize(120,30);
		Scoretext.setLocation(180, 100);
		
		this.add(Scoretext);
		//Scorelabel.add(Scoretext);
		
		
		Idlabel=new JLabel("球员号码");
		Idlabel.setSize(100,30);
		Idlabel.setLocation(60, 140);
		
		this.add(Idlabel);
		
		Idtext=new JTextField();
		Idtext.setSize(120,30);
		Idtext.setLocation(180, 140);
		
		this.add(Idtext);
		

		Positionlabel=new JLabel("球员位置 ");
		Positionlabel.setSize(90,30);
		Positionlabel.setLocation(80, 200);
		
		this.add(Positionlabel);
		
		Positiontext=new JTextField();
		Positiontext.setSize(120,30);
		Positiontext.setLocation(180,180);
		
		this.add(Positiontext);
		
		Addbt=new JButton("添加");
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
		//加载对应的jdbc驱动
		String url="jdbc:sqlserver://localhost:1433; DatabaseName=X";
		//配置连接字符串
		String user="sa";//sa超级管理员
		String password="123456";//密码
		Connection conn=DriverManager.getConnection(url,user,password);
		//创建数据库连接对象
		Statement st=conn.createStatement();
		//创建SQL语句执行对象
     
	   String  strSQL="insert into  basketballmate values('"+addName+"','"+addAge+"','"+addScore+"','"+addId+"','"+addPosition+"')";
	   String  strSQL1="select* from  basketballmate where name='"+addName+"'";
	   
	  if(!addName.trim().equals("")&&!addAge.trim().equals("")&&!addScore.trim().equals(""))
	   {
		 ResultSet rs1=st.executeQuery(strSQL1);
		 
	     if(rs1.next())	 
	      {
		     JOptionPane.showMessageDialog(null,"该球员已存在"); 
		   }
	     else {
	         int rs=st.executeUpdate(strSQL);
		  
	        if(rs==1) {
			      JOptionPane.showMessageDialog(null,"球员信息添加成功");
		        }
		    else{
			    JOptionPane.showMessageDialog(null,"球员信息添加失败");
		      }
	     }
	   }
	  else
	  { 
		  JOptionPane.showMessageDialog(null,"请输入球员信息");
	  }
	   
	  
	    conn.close();
	   
		//关闭数据库连接	
	} 
	
	catch (ClassNotFoundException ex) {
		System.out.println("没有找到对应的数据库驱动类");
	}
	catch (SQLException ex) {
		System.out.println("数据库连接或者是数据库操作失败");
	}

}
}



