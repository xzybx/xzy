package Demo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public   class UMain extends JFrame implements ActionListener {

	 JButton bt1;
	 JPanel panel;
	 JPanel panel2;
	 JLabel label;
	 
	
	UMain(){
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

	
	this.add(bt1);
   
	 panel=new JPanel();
	 panel.setLocation(90, 20);
	 panel.setLayout(null);
     panel.setBackground(Color.darkGray);
     this.add(panel);
     
     panel2=new JPanel();
     panel2.setSize(650,350);
	 panel2.setLocation(100, 20);
	 panel2.setLayout(null);
     panel2.setBackground(Color.orange);
     
     label=new JLabel(); 
     label.setText("欢迎登陆球员管理系统!!!!");
     label.setLocation(165,60);
     label.setSize(500, 200);
	 panel2.add(label);
	 label.setFont( (new Font("仿宋",Font.BOLD,30)));
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
		
	 
	    }
}


