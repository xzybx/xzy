package Demo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
public  class Leave extends JPanel implements ActionListener{
	   JLabel Idlabel;
	   JTextField Idtext;
	   JButton Delbt;
	   JTable table;
	  
	   public Leave() {
		   
		   this.setSize(650,350);
		   this.setLocation(100, 20);
		   this.setLayout(null);
	       this.setBackground(Color.RED);
	    

			Idlabel=new JLabel("请输入退会球员id");
			Idlabel.setSize(150,50);
			Idlabel.setLocation(100, 280);
			this.add(Idlabel);
			
			Idtext=new JTextField();
			Idtext.setSize(160,40);
			Idtext.setLocation(200, 280);
			this.add(Idtext);
			
			Delbt=new JButton("确认退选");
			Delbt.setSize(90,38);
			Delbt.setLocation(420, 280);
			this.add(Delbt); 
			Delbt.addActionListener(this);
			
		
			this.setVisible(true);
	   }
       
	
	
		
		
			@Override
			public void actionPerformed(ActionEvent e) {
				String delId=Idtext.getText();
				
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
				   String strSQL="delete from basketballmate where Id='"+delId+"' ";
				  
				    int rs=st.executeUpdate(strSQL);
					if(rs==1) {
						JOptionPane.showMessageDialog(null,"球员信息删除成功");
					}
					else{
						JOptionPane.showMessageDialog(null,"球员信息删除失败");
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
