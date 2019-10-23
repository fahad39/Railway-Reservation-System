import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class user {
	private String UserName;
	private String Email;
	private String Password;
	private String PhnNum;
	private String Gender;
	private String trainName;
	private String trainTime;
	private String fromStation;
	private String toStation;
	private String tDate;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPhnNum() {
		return PhnNum;
	}
	public void setPhnNum(String phnNum) {
		PhnNum = phnNum;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	user (){
		
	};
	public user(String userName, String email, String password, String phnNum, String gender,String fromStation,String toStation,String trainName,String TrainTime,String tDate) {
		super();
		setUserName( userName);
		setEmail(email);
		setPassword(password);
		setPhnNum(phnNum);
		setGender(gender);
		this.trainName= trainName;
		trainTime=TrainTime;
		this.fromStation=fromStation;
		this.toStation=toStation;
		this.tDate=tDate;
		try {
			Connection conn=DriverManager.getConnection("jdbc:ucanaccess://E://OOP//Railway Reservation System//Database1.accdb");
			PreparedStatement s=conn.prepareStatement("INSERT INTO Traveller(Name,Train,Date,Phoneno,Email,Time) VALUES(?,?,?,?,?,?)");
			s.setString(1,userName);
			s.setString(2,trainName);
			s.setString(3,tDate);
			s.setString(4,phnNum);
			s.setString(5,email);
			s.setString(6,trainTime);
			s.executeUpdate();
		}
		catch (Exception e) {
			System.out.println (e.getMessage());
		}
		
	}
	
	
	
	
	
}