package Demo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.FieldPosition;
import java.util.Random;

import javax.management.relation.Relation;



public class ExplosionOfData {
	
	public static void main(String[] args) {

	PreparedStatement stmt = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//���ض�Ӧ��jdbc����
			String url="jdbc:sqlserver://localhost:1433; DatabaseName=X";
			//���������ַ���
			String user="sa";//��������Ա
			String password="123456";//����
			Connection conn=DriverManager.getConnection(url,user,password);
			//�������ݿ����Ӷ���
			//Statement st=conn.createStatement();
			//����SQL���ִ�ж���
			
			//stmt=conn.prepareStatement(sql);
			
			String[] FPosition= {"�油","����","ǰ��","ǰ��","�Ž�"};
			String[] FName= {"��","Ǯ","��","��","��","��","֣","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��"};
			String[] LName= {"��","��","��","��","��","��","��","��","�","��","ϼ��","ޱ��","�Ĺ�","ޱ��","ϼ��","�ܰ" ,"�ſ�" ,"���","��ɼ","����","����","����","����" ,"¶�","�ش�","����","��ǿ" ,"���� ","����","����","𩺣","����" ,"����" ,"ط��","����"};
			int[] FScore={90,71,92,93,94,95,96,97,18,99};
			int[] FAge={18,17,20,21,22,23,24,25,26,27,28,29,30,31,32,33};


			Random r1=new Random();
			Random r2=new Random();
			Random rPosition=new Random();
			Random rScore=new Random();
			Random rAge=new Random();
	                               

			
			int s1,s2,s4,s5,s3;
			for(int i=0;i<=10000;i++) {
				s1=r1.nextInt(FName.length);
				s2=r2.nextInt(LName.length);
				s3=rPosition.nextInt(FPosition.length);
				s4=rScore.nextInt(FScore.length);
				s5=rAge.nextInt(FAge.length);
	                                                
				String name=FName[s1]+LName[s2];
				String position=FPosition[s3];
				int ID;
				ID=(int) Math.round(Math.random()*(95)+20190301);
				
				
				for(int j=0;j<20;j++) {
					ID=20190001+i;
			try {
				String sql2="insert into basketballmate values(?,?,?,?,?)";
				 
				stmt=conn.prepareStatement(sql2);
				
				//	stmt.executeUpdate();
					stmt.setString(1,name);
					stmt.setInt(2, s5);
					stmt.setInt(3, ID);
					stmt.setInt(4, s4);
					stmt.setString(5, position);
					stmt.executeUpdate();
					
			     	} catch (Exception e) {
				     	e.printStackTrace();
				    }
				
				}
			}
				
			
		}catch (ClassNotFoundException ex) {
			System.out.println("û���ҵ���Ӧ�����ݿ�������");
		}
		catch (SQLException e) {
			System.out.println("���ݿ����ӻ��������ݿ����ʧ��");
		}	
	
		
}
}


