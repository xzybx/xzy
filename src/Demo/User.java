package Demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.DataBuffer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.*;
import javax.swing.text.Segment;

class UserBus{
		public static JFrame Userframe;
		private static JTextField txtid;
		private static JTextField txtpass;
		private static JLabel LabelUserid;
		private static JLabel LabelUserpass;
		private static JPanel PanelUser;
		private static JButton butUser;
		
		

		public static  void Userinit() {
			Userframe=new JFrame("用户登录");
			txtid=new JTextField(10);
			txtpass=new JTextField(10);
			LabelUserid=new JLabel("用户账号");
			LabelUserpass=new JLabel("账号密码");
			butUser=new JButton("确认");
			PanelUser=new JPanel();
		
			Userframe.setSize(750,300);
			Userframe.setLocation(500,500);
			Userframe.setLayout(new BorderLayout());
			
			PanelUser.add(LabelUserid);
			PanelUser.add(txtid);
			PanelUser.add(LabelUserpass);
			PanelUser.add(txtpass);
			PanelUser.add(butUser);
			PanelUser.setBackground(Color.RED);
			Userframe.add(PanelUser,BorderLayout.CENTER);
			
			
			
			
		butUser.addActionListener(new ActionListener() {
						
				public  void actionPerformed(ActionEvent e) {	
					
					Userframe.dispose();
					
					String xname=txtid.getText();
					
					String xpass=txtpass.getText();
					
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
				     
					   String  strSQL="(select * from useone where account='"+xname+"'and password='"+xpass+"')";   
					  if(!xname.trim().equals("")&&!xpass.trim().equals(""))
					   {
						  ResultSet rs1=st.executeQuery(strSQL);
							 
						     if(rs1.next())	 
						      {
							     JOptionPane.showMessageDialog(null,"登陆成功"); 
							     new UMain();
							   } 
						     else {
								    JOptionPane.showMessageDialog(null,"登陆失败");
								    new Register().Registerinit();						      
						     }
						      
						   }
					     
					
					  
				}catch (SQLException | ClassNotFoundException ex) {
					System.out.println("数据库连接或者是数据库操作失败");
				}
				}
	});
		
		Userframe.setVisible(true);
		Userframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		}	
}

class Register{
	public static JFrame Registerframe;
	private static JTextField txtpass;
	private static FlowLayout flo;
	private static JLabel LabelRegisterpass;
	private static JLabel LabelRegisterCue;
	private static JLabel Registerid;
	private static JButton butRegister;
	
	public static void Registerinit() {
		Registerframe=new JFrame("用户注册");
		txtpass=new JTextField(50);
		butRegister=new JButton("确认");
		
		LabelRegisterpass=new JLabel("请输入密码:");
		LabelRegisterCue=new JLabel("账号注册成功，你的账号为：");
		Random r=new Random();
		int ran=r.nextInt(100);
		String newId=String.valueOf(ran);
		
		Registerid=new JLabel(newId);
		flo=new FlowLayout(FlowLayout.LEFT,50,50);
		
		Registerframe.setSize(750,300);
		Registerframe.setLocation(500,500);
		Registerframe.setLayout(flo);
		
		Registerframe.add(LabelRegisterCue);
		Registerframe.add(Registerid);
		Registerframe.add(LabelRegisterpass);
		Registerframe.add(txtpass);
		Registerframe.add(butRegister);
		
		butRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
							
				String yname=newId;				
				String ypass=txtpass.getText();
				
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
			     
				   String  strSQL1="insert into useone values ('"+yname+"','"+ypass+"')";  
				   String   strSQL="(select* from  useone where account='"+password+"')";
				   if(!yname.trim().equals("")&&!ypass.trim().equals(""))
				   {
					 ResultSet rs1=st.executeQuery(strSQL);
					 
				     if(rs1.next())	 
				      {
					     JOptionPane.showMessageDialog(null,"该用户已存在");
					     Registerframe.dispose();
					     new UserBus().Userinit();
					   }
				     else {
				         int rs=st.executeUpdate(strSQL1);
					  
				        if(rs==1) {
						      JOptionPane.showMessageDialog(null,"用户信息添加成功");
						      Registerframe.dispose();
						      new UserBus().Userinit();
					        }
					    else{
						    JOptionPane.showMessageDialog(null,"用户信息添加失败");
						     Registerframe.dispose();
						      new Register().Registerinit();
					      }
				     }
				   }
				
				  
			}catch (SQLException | ClassNotFoundException ex) {
				System.out.println("数据库连接或者是数据库操作失败");
			}
				
			}	
		});
		
		Registerframe.setVisible(true);
		Registerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
}


public class User {
	public static void main(String[]args) {
		new Register().Registerinit();
	}
}
