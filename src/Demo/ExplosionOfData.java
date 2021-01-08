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
			//加载对应的jdbc驱动
			String url="jdbc:sqlserver://localhost:1433; DatabaseName=X";
			//配置连接字符串
			String user="sa";//超级管理员
			String password="123456";//密码
			Connection conn=DriverManager.getConnection(url,user,password);
			//创建数据库连接对象
			//Statement st=conn.createStatement();
			//创建SQL语句执行对象
			
			//stmt=conn.prepareStatement(sql);
			
			String[] FPosition= {"替补","后卫","前锋","前卫","门将"};
			String[] FName= {"赵","钱","孙","李","周","吴","郑","王","刘","冯","陈","褚","卫","蒋","沈","韩","杨","朱","秦","尤","何","黄","张","胡"};
			String[] LName= {"祥","建","梓","安","欣","佳","霏","丰","璇","义","霞依","薇可","心桂","薇寒","霞丽","娅馨" ,"雅克" ,"娅旭","韵杉","婷茹","莉沛","凌柔","彩橘" ,"露璇","柏辞","坤宇","延强" ,"仕禧 ","郁槐","颜振","皓海","震宇" ,"翱澄" ,"胤俊","涛林"};
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
			System.out.println("没有找到对应的数据库驱动类");
		}
		catch (SQLException e) {
			System.out.println("数据库连接或者是数据库操作失败");
		}	
	
		
}
}


