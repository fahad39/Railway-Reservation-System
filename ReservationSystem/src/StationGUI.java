import java.awt.*;
import java.text.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
public class StationGUI extends JFrame{
	public JLabel  lbl1;
	JPanel pnl1;
	private String TrainName;
	private String time;
	
	StationGUI (String [] trainNames,String fromstation,String tostation,String userName, String email, String password, String phnNum, String gender,String tDate){
		super("Available Trains");
		setLayout(new FlowLayout ());
		getContentPane().setBackground(Color.GRAY);
		pnl1 =new JPanel(new GridLayout(2,1));
		pnl1.setBorder(BorderFactory.createTitledBorder("Select Train"));
		pnl1.setBackground(Color.gray);
		lbl1 =new JLabel("Available Trains ");
		JComboBox comboBox=new JComboBox(trainNames);
		lbl1.setFont(new Font("Arial", Font.ITALIC, 14));
		lbl1.setForeground(Color.BLUE);
		comboBox.setSize(3, 10);
		JButton btn=new JButton("       OK      ");
		btn.setForeground(Color.BLUE);
		add(pnl1);
		pnl1.add(lbl1);
		pnl1.add(comboBox);
		add(btn);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setTrainName((String)comboBox.getSelectedItem());
				try {
					Connection conn=DriverManager.getConnection("jdbc://E://OOP//Railway Reservation System//Database1.accdb");
				    PreparedStatement s=conn.prepareStatement("SELECT * FROM Trains WHERE Origin=? AND Destination=? AND Name=?");
				    s.setString(1, fromstation);
				    s.setString(2, tostation);
				    s.setString(3, TrainName);
				    ResultSet rs=s.executeQuery();
				    while (rs.next()) {
				    	time=rs.getString("Time");
				    }
				   
			    }
			    catch(Exception r) {
					System.out.println(r.getMessage());
			}
				String use=userName;
				String mail=email;
				String Password=password;
				String no=phnNum;
				String gen=gender;
			train Train =new train(use,mail,password,phnNum,gender,fromstation,tostation,TrainName,time,tDate);  
				dispose();
			}
		});
		
	}
	public String getTrainName() {
		return TrainName;
	}
	public void setTrainName(String trainName) {
		TrainName = trainName;
	}

}