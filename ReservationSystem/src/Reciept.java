import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Reciept {
	private String Name;
	private String PhnNumb;
	private String fromStation;
	private String toStation;
	private String ClassType;
	private String SeatsNumbers;
	private String TrainName;
	private String TrainTime;
	private String TrainDate;
	private Balance balance;
	
	public Reciept(String Phoneno) {
		super();
		try {
			Connection conn=DriverManager.getConnection("jdbc:ucanaccess://E://OOP//Railway Reservation System//Database1.accdb");
			Statement s=conn.createStatement();
			ResultSet rs=s.executeQuery("SELECT * FROM Traveller WHERE Phoneno="+Phoneno);
			while (rs.next()){
				Name=rs.getString(1);
				PhnNumb=rs.getString(8);
				
				ClassType=rs.getString(4);
			
				TrainName=rs.getString(3);
				TrainDate=rs.getString(5);
				
				ResultSet ra=s.executeQuery("SELECT FROM Trains WHERE Name = "+TrainName);
				while(ra.next())
				{
				fromStation=ra.getString(3);
				toStation=rs.getString(4);
				TrainTime=rs.getString(5);
				
				SeatsNumbers=rs.getString(6);
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		balance =new Balance (SeatsNumbers,ClassType);
		recieptGUI recieptGUI=new recieptGUI(Name,PhnNumb,fromStation,toStation,ClassType,SeatsNumbers,TrainName,TrainTime,TrainDate,balance.getBalance());
		recieptGUI.setLocation(550,250);
		recieptGUI.setSize(330,430);
		recieptGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		recieptGUI.setVisible(true);
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhnNumb() {
		return PhnNumb;
	}
	public void setPhnNumb(String phnNumb) {
		PhnNumb = phnNumb;
	}
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	public String getClassType() {
		return ClassType;
	}
	public void setClassType(String classType) {
		ClassType = classType;
	}
	public String getSeatsNumbers() {
		return SeatsNumbers;
	}
	public void setSeatsNumbers(String seatsNumbers) {
		SeatsNumbers = seatsNumbers;
	}
	public String getTrainName() {
		return TrainName;
	}
	public void setTrainName(String trainName) {
		TrainName = trainName;
	}
	public String getTrainTime() {
		return TrainTime;
	}
	public void setTrainTime(String trainTime) {
		TrainTime = trainTime;
	}
	public String getTrainDate() {
		return TrainDate;
	}
	public void setTrainDate(String trainDate) {
		TrainDate = trainDate;
	}
	

	
}