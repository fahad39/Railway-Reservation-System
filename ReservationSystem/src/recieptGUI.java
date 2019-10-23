import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class recieptGUI  extends JFrame {
		private JLabel lbl1;
		private JLabel lbl2;
		private JLabel lbl3;
		private JLabel lbl4;
		private JLabel lbl5;
		private JLabel lbl6;
		private JLabel lbl7;
		private JLabel lbl8;
		private JLabel lbl9;
		private JLabel lbl10;
		private JPanel pnl;
		recieptGUI(String name, String phnNumb, String fromStation, String toStation, String classType,
				String seatsNumbers, String trainName, String trainTime, String trainDate,double balance) {
			super ("Reciept");
			setLayout(new GridLayout(1,1));
			pnl=new JPanel(new GridLayout(10,1));
			pnl.setBorder(BorderFactory.createTitledBorder("Reciept: "));
			pnl.setBackground(Color.lightGray);
			lbl1=new JLabel("Name:         "+name);
			lbl1.setFont(new Font("Arial", Font.ITALIC, 14));
			lbl1.setForeground(Color.BLUE);
			lbl2=new JLabel("Phone Number: "+phnNumb);
			lbl2.setFont(new Font("Arial", Font.ITALIC, 14));
			lbl2.setForeground(Color.BLUE);
			lbl6=new JLabel("From Station: "+fromStation);
			lbl6.setFont(new Font("Arial", Font.ITALIC, 14));
			lbl6.setForeground(Color.BLUE);
			lbl7=new JLabel("To Station:   "+toStation);
			lbl7.setFont(new Font("Arial", Font.ITALIC, 14));
			lbl7.setForeground(Color.BLUE);
			lbl4=new JLabel("Train Name:   "+classType);
			lbl4.setFont(new Font("Arial", Font.ITALIC, 14));
			lbl4.setForeground(Color.BLUE);
			lbl5=new JLabel("Train Timing: "+seatsNumbers);
			lbl5.setFont(new Font("Arial", Font.ITALIC, 14));
			lbl5.setForeground(Color.BLUE);
			lbl3=new JLabel("Dparture Date:"+trainName);
			lbl3.setFont(new Font("Arial", Font.ITALIC, 14));
			lbl3.setForeground(Color.BLUE);
			lbl8=new JLabel("Train Class:  "+trainTime);
			lbl8.setFont(new Font("Arial", Font.ITALIC, 14));
			lbl8.setForeground(Color.BLUE);
			lbl9=new JLabel("Train Seats:  "+trainDate);
			lbl9.setFont(new Font("Arial", Font.ITALIC, 14));
			lbl9.setForeground(Color.BLUE);
			lbl10=new JLabel("Balance:      "+balance);
			lbl10.setFont(new Font("Arial", Font.ITALIC, 14));
			lbl10.setForeground(Color.BLUE);
			JButton btn=new JButton("Ok");
			add(pnl);
			pnl.add(lbl1);
			pnl.add(lbl2);
			pnl.add(lbl3);
			pnl.add(lbl4);
			pnl.add(lbl5);
			pnl.add(lbl6);
			pnl.add(lbl7);
			pnl.add(lbl8);
			pnl.add(lbl9);
			pnl.add(lbl10);
			btn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					dispose();
				}
			});
			
			
		}
		
		
	}
