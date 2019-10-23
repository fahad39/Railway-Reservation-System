import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SingIn extends JFrame {
	private JLabel lblEmail;
	private JLabel lblPassword;
	JPanel pnl1;
	SingIn (){
	super("Sing in Form");
	pnl1 =new JPanel(new GridLayout(4,1));
	pnl1.setBorder(BorderFactory.createTitledBorder("Sing In: "));
	pnl1.setBackground(Color.LIGHT_GRAY);
	setLayout(new FlowLayout());
	getContentPane().setBackground(Color.LIGHT_GRAY );
	lblEmail = new JLabel("Email :");
	lblEmail.setForeground(Color.blue);
	lblEmail.setFont(new Font("Arial", Font.ITALIC, 14));
	TextField tu=new TextField();
	tu.setColumns(20);
	lblPassword = new JLabel("Password:");
	lblPassword.setForeground(Color.blue);
	lblPassword.setFont(new Font("Arial", Font.ITALIC, 14));;
	JPasswordField tp=new JPasswordField();
	tp.setColumns(15);
	JButton btn1=new JButton("      Sing In    ");
	btn1.setForeground(Color.BLUE);
	JButton btn2=new JButton("   Creat an account  ");
	btn2.setForeground(Color.BLUE);
	add(pnl1);
	pnl1.add(lblEmail);
	pnl1.add(tu);
	pnl1.add(lblPassword);
	pnl1.add(tp);
	add(btn1);
	add(btn2);
	btn1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
			{

			String user=tu.getText();
			char[] p1=tp.getPassword();
			String p2=new String(p1);
				try {
						Connection conn= DriverManager.getConnection("jdbc:ucanaccess://E://OOP//Railway Reservation System//Database1.accdb") ;
						String sql="SELECT * from Users WHERE Email=? AND Password=?";
						PreparedStatement rs=conn.prepareStatement(sql);
						rs.setString(1,user);
						rs.setString(2,p2);
						
						ResultSet stm=rs.executeQuery();
						if(stm!=null)
						{
							
							while(stm.next())
							{
								System.out.println("Successfully logged in");
								String name;
								String phnNum;
								String Gender;
								name=stm.getString(2);
								phnNum=stm.getString("PhoneNumber");
								Gender=stm.getString("Gender");
								booking b=new booking(name,user,p2,phnNum,Gender);
								b.setLocation(550,250);
								b.setSize(270,300);
								b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
							    b.setVisible(true);
							    dispose();
							}
						}
					     else {
								JOptionPane.showMessageDialog(new JFrame(),"Email or Password is incorrect", "Dialog",
								        JOptionPane.ERROR_MESSAGE);
							}

						rs.close();
						stm.close();
						conn.close();

							
						
							
						
				}
				catch(Exception r) {
					System.out.println(r.getMessage());
				}
				dispose();
			}
		});
	btn2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{	
			CreatAcc creatAcc=new CreatAcc(); 
			creatAcc.setLocation(550,250);
			creatAcc.setSize(260,450);
			creatAcc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			creatAcc.setVisible(true);
			dispose();
		}
	});

	
	}
	public static void main (String [] args) {
		SingIn sing=new SingIn();
		sing.setLocation(550,250);
		sing.setSize(250,250);
		sing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    sing.setVisible(true); 	
			
		}
}	
	
	
	
	
	
	
