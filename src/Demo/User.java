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
			Userframe=new JFrame("�û���¼");
			txtid=new JTextField(10);
			txtpass=new JTextField(10);
			LabelUserid=new JLabel("�û��˺�");
			LabelUserpass=new JLabel("�˺�����");
			butUser=new JButton("ȷ��");
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
						//���ض�Ӧ��jdbc����
						String url="jdbc:sqlserver://localhost:1433; DatabaseName=X";
						//���������ַ���
						String user="sa";//sa��������Ա
						String password="123456";//����
						Connection conn=DriverManager.getConnection(url,user,password);
						//�������ݿ����Ӷ���
						Statement st=conn.createStatement();
						//����SQL���ִ�ж���
				     
					   String  strSQL="(select * from useone where account='"+xname+"'and password='"+xpass+"')";   
					  if(!xname.trim().equals("")&&!xpass.trim().equals(""))
					   {
						  ResultSet rs1=st.executeQuery(strSQL);
							 
						     if(rs1.next())	 
						      {
							     JOptionPane.showMessageDialog(null,"��½�ɹ�"); 
							     new UMain();
							   } 
						     else {
								    JOptionPane.showMessageDialog(null,"��½ʧ��");
								    new Register().Registerinit();						      
						     }
						      
						   }
					     
					
					  
				}catch (SQLException | ClassNotFoundException ex) {
					System.out.println("���ݿ����ӻ��������ݿ����ʧ��");
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
		Registerframe=new JFrame("�û�ע��");
		txtpass=new JTextField(50);
		butRegister=new JButton("ȷ��");
		
		LabelRegisterpass=new JLabel("����������:");
		LabelRegisterCue=new JLabel("�˺�ע��ɹ�������˺�Ϊ��");
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
					//���ض�Ӧ��jdbc����
					String url="jdbc:sqlserver://localhost:1433; DatabaseName=X";
					//���������ַ���
					String user="sa";//sa��������Ա
					String password="123456";//����
					Connection conn=DriverManager.getConnection(url,user,password);
					//�������ݿ����Ӷ���
					Statement st=conn.createStatement();
					//����SQL���ִ�ж���
			     
				   String  strSQL1="insert into useone values ('"+yname+"','"+ypass+"')";  
				   String   strSQL="(select* from  useone where account='"+password+"')";
				   if(!yname.trim().equals("")&&!ypass.trim().equals(""))
				   {
					 ResultSet rs1=st.executeQuery(strSQL);
					 
				     if(rs1.next())	 
				      {
					     JOptionPane.showMessageDialog(null,"���û��Ѵ���");
					     Registerframe.dispose();
					     new UserBus().Userinit();
					   }
				     else {
				         int rs=st.executeUpdate(strSQL1);
					  
				        if(rs==1) {
						      JOptionPane.showMessageDialog(null,"�û���Ϣ��ӳɹ�");
						      Registerframe.dispose();
						      new UserBus().Userinit();
					        }
					    else{
						    JOptionPane.showMessageDialog(null,"�û���Ϣ���ʧ��");
						     Registerframe.dispose();
						      new Register().Registerinit();
					      }
				     }
				   }
				
				  
			}catch (SQLException | ClassNotFoundException ex) {
				System.out.println("���ݿ����ӻ��������ݿ����ʧ��");
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
