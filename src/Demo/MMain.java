package Demo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;

import com.xzy.pojo.Basketballmate;
public class MMain extends JFrame implements ActionListener {

	 JButton bt1;
	 JButton bt2;
	 JButton bt3;
	 JButton bt4;

	 // JButton butcollection;

	 
	 
	 JPanel panel;
	 JPanel panel2;
	 JLabel label;
	 
	
	MMain(){
	this.setSize(900, 700);
	this.setTitle("球员管理系统");
	this.setLayout(null);
	this.setLocation(400,200);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	bt1=new JButton("查询球员信息");
	bt1.setSize(150, 50);
	bt1.setLocation(150, 400);
	bt1.addActionListener(this);
	bt1.setActionCommand("查询球员信息");

	bt2=new JButton("球员退会");
	bt2.setSize(150, 50);
	bt2.setLocation(150, 500);
	bt2.addActionListener(this);
	bt2.setActionCommand("球员退会");
	
	bt3=new JButton("新球员加入");
	bt3.setSize(150, 50);
	bt3.setLocation(550, 400);
	bt3.addActionListener(this);
	bt3.setActionCommand("新球员加入");
	
	
	bt4=new JButton("修改球员信息");
	bt4.setSize(150, 50);
	bt4.setLocation(550, 500);
	bt4.addActionListener(this);
	bt4.setActionCommand("修改球员信息");

	this.add(bt1);
    this.add(bt2);
	this.add(bt3);
	this.add(bt4);
	


	 panel=new JPanel();
	 panel.setLocation(100, 20);
	 panel.setLayout(null);
     panel.setBackground(Color.GRAY);
     this.add(panel);
     
     panel2=new JPanel();
     panel2.setSize(650,350);
	 panel2.setLocation(100, 20);
	 panel2.setLayout(null);
     panel2.setBackground(Color.lightGray);
     
     label=new JLabel(); 
     label.setText("欢迎登陆球员管理系统!!!!");
     label.setLocation(165,60);
     label.setSize(500, 200);
	 panel2.add(label);
	 label.setFont( (new Font("黑体",Font.BOLD,30)));
	 this.add(panel2);   
	 panel2.setVisible(true);
	
	
		
	 
	 
	this.setVisible(true);
	
	
	
	
	}
	
      
	@Override
	public void actionPerformed(ActionEvent e) {
		
		 JButton bt=(JButton )e.getSource();
		 //移除上一个面板
		 if(bt!=null)
		 {
			 this.remove(panel2);
			 this.remove(panel);
		 }
	    if(bt.getText().equals("查询球员信息"))
	     {
	    	 panel= new Check();
	    	 panel.setLocation(100, 20);
	    	 this.add(panel);
			 this.repaint();
		}
		
	    else {
	    	if(bt.getText().equals("球员退会"))
		{
			 panel=new Leave();
			 panel.setLocation(100, 20);
			 this.add(panel);
			 this.repaint();
		}   
	    
	    else {
	    	if(bt.getText().equals("新球员加入"))
		{
			 panel=new Add();
			 panel.setLocation(100, 20);
			 this.add(panel);
			 this.repaint();
		}
	 
	    else { 
	   	    	if(bt.getText().equals("修改球员信息"))
	   		{
	   			 panel=new Correct();
	   			 panel.setLocation(100, 20);
	   			 this.add(panel);
	   			 this.repaint();
	   		 }
	   	    }
	    	   
	    }	    		
	    }
	}
	    }
