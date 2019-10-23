import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Cancle extends JFrame {
	private JLabel lblPassword;
	private JLabel lblEmail;
	private JPanel pnl1;
	Cancle() {
		super("Cancle Ticket");
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.DARK_GRAY);
		pnl1 = new JPanel(new GridLayout(4,1));
		pnl1.setBorder(BorderFactory.createTitledBorder("Cancle Seats"));
		pnl1.setBackground(Color.DARK_GRAY);
		lblEmail =new JLabel("E-mail ");
		lblEmail.setFont(new Font("Arial", Font.ITALIC, 14));
		lblEmail.setForeground(Color.BLUE);
		TextField tu=new TextField();
		tu.setColumns(20);
		lblPassword = new JLabel("Password ");
		lblPassword.setFont(new Font("Arial", Font.ITALIC, 14));
		lblPassword.setForeground(Color.BLUE);
		JPasswordField te=new JPasswordField();
		te.setColumns(20);
		JButton btn =new JButton("Cancle");
		btn.setForeground(Color.blue);
		add(pnl1);
		pnl1.add(lblEmail);
		pnl1.add(tu);
		pnl1.add(lblPassword);
		pnl1.add(te);
		add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
				{
					CancleMain CancleMain=new CancleMain(tu.getText(),te.getText());
					if (CancleMain.i == 1) {
						JOptionPane.showMessageDialog(null,"Your Seats are deleted Succesfully..!","Cancle Status", JOptionPane.INFORMATION_MESSAGE);	
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"Your Have Entered a Wrong Information Please Enter Again Correctly","Cancle Status", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
					
	}
}