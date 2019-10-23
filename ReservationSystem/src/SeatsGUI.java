import java.awt.*;
import java.text.*;
import java.awt.event.*;
import javax.swing.*;

public class SeatsGUI extends JFrame {
	private JLabel lblClass;
	private JLabel lblSeat;
	JPanel pnl1; 
	public String trainClass;
	public int trainSeats;
	SeatsGUI (String phnNum) {
	super ("Seats Booking");
	setLayout(new FlowLayout());
	getContentPane().setBackground(Color.gray);
	pnl1 =new JPanel(new GridLayout(4,1));
	pnl1.setBorder(BorderFactory.createTitledBorder("Select Train Class and Enter Seats :"));
	pnl1.setBackground(Color.GRAY);
	lblClass =new JLabel("Class Type                                       ");
	lblClass.setFont(new Font("Arial", Font.ITALIC, 14));
	lblClass.setForeground(Color.BLUE);
	String[] str2= {"Business","ACstandard","Economy","Parlor"};
	JComboBox classType=new JComboBox(str2);
	lblSeat =new JLabel("Enter Seats Number: ");
	lblSeat.setFont(new Font("Arial", Font.ITALIC, 14));
	lblSeat.setForeground(Color.BLUE);
	JTextField tSeats=new JTextField();
	tSeats.setText("0");
	tSeats.setColumns(5);
	JButton btn=new JButton("    Submit     ");
	btn.setForeground(Color.blue);
	add(pnl1);
	pnl1.add(lblClass);
	pnl1.add(classType);
	pnl1.add(lblSeat);
	pnl1.add(tSeats);
	add(btn);
	System.out.println(tSeats.getText());
	btn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			trainSeats=Integer.parseInt(tSeats.getText());
			trainClass=(String) classType.getSelectedItem();
			Reciept reciept=new Reciept(phnNum);
		}
	});
	}
	
	
	
}