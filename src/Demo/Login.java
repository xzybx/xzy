package Demo;
import java.awt.*;
import java.awt.ActiveEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

class Text{
	public static JFrame Testframe;
	private static JButton butUser;
	private static JButton butManager;
	private static JButton butRegister;
	private static FlowLayout flo;
	
	public static void Test() {
		Testframe=new JFrame("��Ա����");
		butUser=new JButton("�û���¼");
		butRegister=new JButton("�û�ע��");
		butManager=new JButton("����Ա��½");
		flo=new FlowLayout(FlowLayout.LEFT,50,50);
		
		Testframe.setSize(800,500);
		Testframe.setLocation(500,500);
		Testframe.setLayout(flo);
		
		Testframe.add(butUser);
		Testframe.add(butManager);
		Testframe.add(butRegister);
		
		
		butUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"�û���½");
				Testframe.dispose();
				UserBus user=new UserBus();
				user.Userinit();
			}
		});
		butManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"����Ա��½");
				Testframe.dispose();
				ManagerBus manager=new ManagerBus();
				manager.Managerinit();
				
			}
		});
		butRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			    Testframe.dispose();
				Register register=new Register();
				Register.Registerinit();
			}
		});

		
		Testframe.setVisible(true);
		Testframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
public class Login{
	public static void main(String[] args) {
		new Text().Test();
	}
}