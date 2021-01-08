package Demo;


import java.sql.*;
 
public class GetConnect {
 public static void main(String [] args)
 {
  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
  String dbURL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=X";//test为你的数据库名
  String userName="sa";//你的数据库用户名
  String userPwd="123456";//你的密码
 try
{
    Class.forName(driverName);
    Connection conn=DriverManager.getConnection(dbURL,userName,userPwd);
}catch(Exception e){
    e.printStackTrace();

}        
}
}
