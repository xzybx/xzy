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
	      
	   	OldIdlabel=new JLabel("原球员号码");
		OldIdlabel.setSize(100,30);
		OldIdlabel.setLocation(330, 40);
		
		this.add(OldIdlabel);
		
		OldIdtext=new JTextField();
		OldIdtext.setSize(120,30);
		OldIdtext.setLocation(410, 40);
		this.add(OldIdtext);
	       
			Namelabel=new JLabel("修改的球员名字");
			Namelabel.setSize(100,30);
			Namelabel.setLocation(60, 20);
			
			this.add(Namelabel);
			
			Nametext=new JTextField();
			Nametext.setSize(120,30);
			Nametext.setLocation(180, 20);
			this.add(Nametext);
			
			Agelabel=new JLabel("修改的球员年龄");
			Agelabel.setSize(100,30);
			Agelabel.setLocation(60, 60);
			this.add(Agelabel);
			
			Agetext=new JTextField();
			Agetext.setSize(120,30);
			Agetext.setLocation(180, 60);
			this.add(Agetext);
			
			
			Idlabel=new JLabel("修改的球员号码");
			Idlabel.setSize(100,30);
			Idlabel.setLocation(60, 100);
			this.add(Idlabel);
			
			Idtext=new JTextField();
			Idtext.setSize(120,30);
			Idtext.setLocation(180, 100);
			this.add(Idtext);
		
			Scorelabel=new JLabel("修改的球员得分");
			Scorelabel.setSize(100,30);
			Scorelabel.setLocation(60, 140);
			this.add(Scorelabel);
			
			Scoretext=new JTextField();
			Scoretext.setSize(120,30);
			Scoretext.setLocation(180, 140);
			this.add(Scoretext);
			
			Positionlabel=new JLabel("修改的球员位置");
			Positionlabel.setSize(100,30);
			Positionlabel.setLocation(60,180);
			this.add(Positionlabel);
			
			Positiontext=new JTextField();
			Positiontext.setSize(120,30);
			Positiontext.setLocation(180, 180);
			this.add(Positiontext);
			
			 Updatebt=new JButton("修改");
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
		//加载对应的jdbc驱动
		String url="jdbc:sqlserver://localhost:1433; DatabaseName=X";
		//配置连接字符串
		String user="sa";//超级管理员
		String password="123456";//密码
		Connection conn=DriverManager.getConnection(url,user,password);
		//创建数据库连接对象
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
			 JOptionPane.showMessageDialog(null,"课程修改成功");
			  System.out.println("04983796");
			 
		 }else{
			 JOptionPane.showMessageDialog(null,"课程修改失败");
		 
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
