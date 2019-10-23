import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class CancleMain {
	private String Email; 
	private String Password;
	public  int i=0;
	CancleMain (String Email,String Password) {
	try {
		Connection conn=DriverManager.getConnection("jdbc:ucanaccess://E://OOP//Railway Reservation System//Database1.accdb");
		String sql2="DELETE FROM Traveller WHERE Email=?";
		PreparedStatement dels=conn.prepareStatement(sql2);
		dels.setString(1,Email);
		if (dels.executeUpdate()==1)
		{
			
				i=1;
			}
		
	}
	catch(Exception r) {
		System.out.println(r.getMessage());
	}
}
}