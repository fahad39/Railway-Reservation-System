import java.sql.*;
import java.awt.*;
import java.text.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class booking extends JFrame {
	private JLabel lblDate;
	private JLabel lblToStation;
	private JLabel lblFromStation;
	JPanel pnl1;
	JFormattedTextField tDate ;
	booking (String userName, String email, String password, String phnNum, String gender){
		super ("Booking Ticket");
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.gray);
		pnl1=new JPanel(new GridLayout(6,1));
		pnl1.setBorder(BorderFactory.createTitledBorder("Booking: "));
		pnl1.setBackground(Color.GRAY);
		lblDate =new JLabel("Departure Date ");
		lblDate.setFont(new Font("Arial", Font.ITALIC, 14));
		lblDate.setForeground(Color.BLUE);
		tDate = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
		 tDate.setValue(new Date());
		 tDate.setColumns(15);
		lblFromStation =new JLabel("From Station                                       ");
		lblFromStation.setFont(new Font("Arial", Font.ITALIC, 14));
		lblFromStation.setForeground(Color.BLUE);
		String[] str= {"Lahore","Rawalpindi","Karachi","Islamabad"};
		JComboBox fromStation=new JComboBox(str);
		String[] str2={"Lahore","Rawalpindi","Karachi","Islamabad","Quetta","Sialkot","Multan","Sargodha","Sahiwal"};
		lblToStation =new JLabel("To Station                                          ");
		lblToStation.setFont(new Font("Arial", Font.ITALIC, 14));
		lblToStation.setForeground(Color.BLUE);
		JComboBox ToStation=new JComboBox(str2);
		JButton btn= new JButton("         Submit        ");
		JButton btn2=new JButton("         Cancle Seat       ");
		btn.setForeground(Color.BLUE);
		btn2.setForeground(Color.BLUE);
		add(pnl1);
		pnl1.add(lblDate);
		pnl1.add(tDate);
		pnl1.add(lblFromStation);
		pnl1.add(fromStation);
		pnl1.add(lblToStation);
		pnl1.add(ToStation);
		add(btn);
		add(btn2);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Station station=new Station((String) fromStation.getSelectedItem(),(String) ToStation.getSelectedItem(),userName,email,password,phnNum,gender,tDate.getText());
				dispose();
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cancle cancle=new Cancle();
				cancle.setLocation(550,250);
				cancle.setSize(250,200);
				cancle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			    cancle.setVisible(true);
				dispose();
			}
		});
		
		
	}
	
	
	
	public static void main (String [] args)  {
		
		
	}
}