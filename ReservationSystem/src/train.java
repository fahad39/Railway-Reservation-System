import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class train {
	public String fromStation ;
	public String toStation;
	public String trainName;
	public String trainTime;
	private user user;
	private int SeatsStatus;
	private String email=null;
	public String PhnNum;
	train (String userName, String email, String password, String phnNum, String gender,String fromStation,String toStation,String TrainName,String TrainTime,String tDate) {
		user=new user(userName,email,password,phnNum,gender,fromStation,toStation,TrainName,TrainTime,tDate);
		this.fromStation=fromStation;
		this.toStation=toStation;
		this.trainName=TrainName;
		this.trainTime=TrainTime;
		this.email=email;
		this.PhnNum=(phnNum);
	}
	TrainClasses tClass=new TrainClasses();
	
	public class TrainClasses {
		private String TrainClass="";
		private int TrainSeats=0;
		TrainClasses (){
			SeatsGUI seatsGUI =new SeatsGUI(PhnNum);
			seatsGUI.setLocation(550,250);
			seatsGUI.setSize(280,250);
			seatsGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			seatsGUI.setVisible(true);
			TrainClass= seatsGUI.trainClass;
			TrainSeats =seatsGUI.trainSeats;
			try {
				//String sl="SELECT "+TrainClass+"  FROM Trains  WHERE Name= "+trainName;
				Connection conn=DriverManager.getConnection("jdbc:ucanaccess://E://OOP//Railway Reservation System//Database1.accdb");
				PreparedStatement s=conn.prepareStatement("SELECT "+TrainClass+"  FROM Trains  WHERE Name=?");
				s.setString(1,trainName);
				ResultSet rs=s.executeQuery();
				while(rs.next()) {
				int a=rs.getInt(TrainClass);
					int b= a-(TrainSeats);
					String sql="UPDATE Trains SET "+TrainClass+" = "+b+" WHERE Name = "+trainName;
					PreparedStatement stmt1 = conn.prepareStatement("UPDATE Trains SET "+TrainClass +"= ? WHERE Name = ?");
                stmt1.setInt(1, b);
                stmt1.setString(2,trainName);
					stmt1.executeUpdate();
				
				PreparedStatement ps=conn.prepareStatement("INSERT INTO Traveller(Class,Seat) VALUES(?,?)");
				ps.setString(1, TrainClass);
				ps.setInt(2, TrainSeats);
				ps.executeUpdate();
				}
				
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
			Reciept reciept=new Reciept(email);
		}
		}
	public int getSeatsStatus () {
		return SeatsStatus;
	}
	
	
	
	
}














