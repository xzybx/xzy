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
	    

			Idlabel=new JLabel("�������˻���Աid");
			Idlabel.setSize(150,50);
			Idlabel.setLocation(100, 280);
			this.add(Idlabel);
			
			Idtext=new JTextField();
			Idtext.setSize(160,40);
			Idtext.setLocation(200, 280);
			this.add(Idtext);
			
			Delbt=new JButton("ȷ����ѡ");
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
					//���ض�Ӧ��jdbc����
					String url="jdbc:sqlserver://localhost:1433; DatabaseName=X";
					//���������ַ���
					String user="sa";//sa��������Ա
					String password="123456";//����
					Connection conn=DriverManager.getConnection(url,user,password);
					//�������ݿ����Ӷ���
					Statement st=conn.createStatement();
					//����SQL���ִ�ж���
				   String strSQL="delete from basketballmate where Id='"+delId+"' ";
				  
				    int rs=st.executeUpdate(strSQL);
					if(rs==1) {
						JOptionPane.showMessageDialog(null,"��Ա��Ϣɾ���ɹ�");
					}
					else{
						JOptionPane.showMessageDialog(null,"��Ա��Ϣɾ��ʧ��");
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
