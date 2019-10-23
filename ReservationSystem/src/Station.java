

import java.sql.*;

import javax.swing.JFrame;
public class Station {
	private String toStation;
	private String fromStation;
	private train Train;
	private String [] TrainNames=new String [10];
	private String trainName;
	private String time;
	Station (String fromstation,String tostation,String userName, String email, String password, String phnNum, String gender,String tDate)
	{
		setToStation(tostation);
		setFromStation(fromstation);
		
		try {
			Connection conn=DriverManager.getConnection("jdbc:ucanaccess://E://OOP//Railway Reservation System//Database1.accdb");
		    PreparedStatement s=conn.prepareStatement("SELECT * FROM Trains WHERE Origin=? AND Destination=? ");
		    s.setString(1, getFromStation());
		    s.setString(2, getToStation());
		    
		    ResultSet rs=s.executeQuery();
		    while (rs.next()) {
		    	int i=0;
		    	TrainNames [i]=rs.getString(2);
		    	i++;
		    	
		   
		    }
		}
		catch(Exception e) {
				System.out.println(e.getMessage());
		}
		 StationGUI stationGUI=new StationGUI(TrainNames,fromStation,toStation,userName,email,password,phnNum,gender,tDate);
		    stationGUI.setLocation(550,250);
		    stationGUI.setSize(180,150);
		    stationGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		    stationGUI.setVisible(true);
		    trainName=stationGUI.getTrainName(); 
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	
	public String getTrainName() {
		return trainName ;
	}
	public String getTrainTime() {
		return time ;
	}
	
	
	
	
	
	
	
}