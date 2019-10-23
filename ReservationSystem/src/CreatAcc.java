import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CreatAcc extends JFrame {
				private JLabel lblUserName;
				private String [] TrainName= {"ACstandars","parlor class","class"};
				private JLabel lblEmail;
				private JLabel lblPassword;
				private JLabel lblConfrmPass;
				private JLabel lblPhnNum;
				private JLabel lblGender;
				private String gender;
				JPanel pnl1;
				CreatAcc () {
					super("Creat Account");
					pnl1=new JPanel(new GridLayout(13,1));
					pnl1.setBorder(BorderFactory.createTitledBorder("Creat Account"));
					pnl1.setBackground(Color.GRAY);
					setLayout(new FlowLayout());
					getContentPane().setBackground(Color.GRAY );
					lblUserName =new JLabel("User Name ");
					TextField tu=new TextField();
					tu.setColumns(20);
					lblUserName.setForeground(Color.blue);
					lblUserName.setFont(new Font("Arial", Font.ITALIC, 14));
					lblEmail = new JLabel("E-mail ");
					TextField te=new TextField();
					te.setColumns(20);
					lblEmail.setForeground(Color.blue);
					lblEmail.setFont(new Font("Arial", Font.ITALIC, 14));
					lblPassword = new JLabel("Password ");
					JPasswordField tp=new JPasswordField();
					tp.setColumns(15);
					lblPassword.setForeground(Color.blue);
					lblPassword.setFont(new Font("Arial", Font.ITALIC, 14));
					lblConfrmPass =new JLabel("Confirm Your Password ");
					JPasswordField tc=new JPasswordField();
					tc.setColumns(15);
					lblConfrmPass.setForeground(Color.blue);
					lblConfrmPass.setFont(new Font("Arial", Font.ITALIC, 14));
					lblPhnNum =new JLabel("Phone Number");
					TextField tphn=new TextField();
					tphn.setColumns(20);
					lblPhnNum.setForeground(Color.blue);
					lblPhnNum.setFont(new Font("Arial", Font.ITALIC, 14));
					lblGender =new JLabel("Gender");
					lblGender.setForeground(Color.blue);
					lblGender.setFont(new Font("Arial", Font.ITALIC, 14));
					JRadioButton rmbtn=new JRadioButton("Mail");
					rmbtn.setBounds(75,50,100,30);
					JRadioButton rgbtn=new JRadioButton("Femail");
					ButtonGroup group=new ButtonGroup();
					JButton btn=new JButton("			Submit			");
					btn.setForeground(Color.BLUE);
					add(pnl1);
					pnl1.add(lblUserName);
					pnl1.add(tu);
					pnl1.add(lblEmail);
					pnl1.add(te);
					pnl1.add(lblPassword);
					pnl1.add(tp);
					pnl1.add(lblConfrmPass);
					pnl1.add(tc);
					pnl1.add(lblPhnNum);
					pnl1.add(tphn);
					pnl1.add(lblGender);
					group.add(rmbtn);
					group.add(rgbtn);
					pnl1.add(rmbtn);
					pnl1.add(rgbtn);
					add(btn);
					btn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e)
						{	
							
							String s1=tu.getText();
							String s2=te.getText();
							char[] s3=tp.getPassword();
							char[] s4=tc.getPassword();
							String s5=new String(s3);
							String s6=new String(s4);
							String s7=tphn.getText();
							
							if(rmbtn.isSelected())
							{
								gender=rmbtn.getText();
							}
							else if(rgbtn.isSelected())
								{
									gender=rgbtn.getText();
								}
							
							if (s5.equals(s6)) {
								try{
								Connection conn=DriverManager.getConnection("jdbc:ucanaccess://E://OOP//Railway Reservation System//Database1.accdb");
								String sql="INSERT INTO Users(Name,Email,Password,PhoneNumber,Gender) VALUES(?,?,?,?,?)";
								PreparedStatement rs=conn.prepareStatement(sql);
								rs.setString(1,s1);
								rs.setString(2,s2);
								rs.setString(3,s5);
								rs.setString(4,s7);
								rs.setString(5,gender);
								
								rs.executeUpdate();
								}
								catch(Exception r)
								{
									System.out.println(r.getMessage());
								}
							booking b=new booking(s1,s2,s5,s7,gender);
							b.setLocation(550,250);
							b.setSize(270,300);
							b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
						    b.setVisible(true);
						    dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Your Password and Confirm password Field did not Match", "Error Message", JOptionPane.ERROR_MESSAGE);
							}
						}
					});
				
				}
			} 
	