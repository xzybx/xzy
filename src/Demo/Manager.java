package Demo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;

import com.xzy.pojo.Basketballmate;

class ManagerBus{
	public static JFrame Managerframe;
	private static JTextField txtid;
	private static JTextField txtpass;
	private static FlowLayout flo;
	private static JLabel LabelManagerid;
	private static JLabel LabelManagerpass;
	private static JButton butManager;
	
	

	public static void Managerinit() {
		Managerframe=new JFrame("����Ա��¼");
		txtid=new JTextField(10);
		txtpass=new JTextField(10);
		LabelManagerid=new JLabel("�����˺�");
		LabelManagerpass=new JLabel("�˺�����");
		flo=new FlowLayout(FlowLayout.LEFT,50,50);
		butManager=new JButton("ȷ��");
		
		Managerframe.setSize(600,300);
		Managerframe.setLocation(500,500);
		Managerframe.setLayout(flo);
		
		Managerframe.add(LabelManagerid);
		Managerframe.add(txtid);
		Managerframe.add(LabelManagerpass);
		Managerframe.add(txtpass);
		Managerframe.add(butManager);

	
		
		
		
		

		
		
			butManager.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String Maname=txtid.getText();
					
					String Mapass=txtpass.getText();
	
					int bx=0;
					
					if(Maname.equals("xzy")&&Mapass.contentEquals("xxx")) {
						Managerframe.dispose();
						bx=1;
					}
					if(bx==1) {
						JOptionPane.showMessageDialog(null,"����Ա��¼�ɹ�!!!!");
						 new Manager().MMain();
						 new MMain();
					}else {
						JOptionPane.showMessageDialog(null, "����Ա��½ʧ��!!!");
						Managerframe.dispose();
						new UserBus().Userinit();
					}
				}
			});
		
		Managerframe.setVisible(true);
		Managerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*butManager.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Managerframe.dispose();
				new MMain();
			}
			
		});*/
	} 
	
	
}

public class Manager {
	public static void main(String[]args) {
		new ManagerBus();
		ManagerBus.Managerinit();
		
	}

	public void MMain() {
		// TODO Auto-generated method stub
		
	}
}



