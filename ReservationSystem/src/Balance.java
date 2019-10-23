public class Balance {
	private String trainSeats;
	private String trainClass="Economy";
	private double balance=2000.0;
	public 	String getTrainSeats() {
		return trainSeats;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setTrainSeats(String trainSeats) {
		this.trainSeats = trainSeats;
	}
	public String getTrainClass() {
		return trainClass;
	}
	public void setTrainClass(String trainClass) {
		this.trainClass = trainClass;
	}
	public Balance(String trainSeats, String trainClass) {
		super();
		this.trainSeats = trainSeats;
		this.trainClass = trainClass;
	}
	public double getBalance() {
		if (trainClass.equals("Parlor")) {
			balance=Integer.parseInt(trainSeats)*5000*200;
		}
		else if (trainClass.equals("Business")) {
			balance=Integer.parseInt(trainSeats)*4000*150;
		}
		else if (trainClass.equals("ACstandard")) {
			balance=Integer.parseInt(trainSeats)*3000;
		}
		else if(trainClass.equals("Economy")) {
			balance=Integer.parseInt(trainSeats)*2000*250;
		}
		return balance;
	}
	
	
}