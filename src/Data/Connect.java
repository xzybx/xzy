package Data;


import java.sql.*;
 
public class Connect {
 public static void main(String [] args)
 {
  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
  String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=test";//testΪ������ݿ���
  String userName="sa";//������ݿ��û���
  String userPwd="123456";//�������
 try
{
    Class.forName(driverName);
    System.out.println("���������ɹ���");
}catch(Exception e){
    e.printStackTrace();
    System.out.println("��������ʧ�ܣ�");
}
try{
    Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
        System.out.println("�������ݿ�ɹ���");
}catch(Exception e)
{
    e.printStackTrace();
    System.out.print("SQL Server����ʧ�ܣ�");
}        
}
}
