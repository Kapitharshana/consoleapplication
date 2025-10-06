package newbusbooking;

public class bus {
	private int busNo; //get set method
	private String departure;
	private String arrival;
	private String time;
	private int avilable_seats;
	private boolean type;
	private float price; 
  
	    
	
	public bus(int no, String from , String to, String t, int seats, boolean ac,float p) {
		this.busNo=no;
		this.departure=from;
		this.arrival=to;
		this.time=t;
		this.avilable_seats=seats;
		this.type=ac;
		this.price=p;
				
	}
	
	public int getbusNo() {
		return busNo;
	}
	
	public void setbusNO(int no){
		busNo=no;
	}
	
	public String getdeparture() {
		return departure;
	}
	
	public void setdeparture(String from){
		departure=from;
	}
	
	public String getarrival() {
		return arrival;
	}
	
	public void setarrival(String to){
		arrival=to;
	}
	
	public String gettime() {
		return time;
	}
	
	public void settime(String t){
		time=t;
	}
	
	public int getavailable_seats() {
		return avilable_seats;
	}
	
	public void setvavilable_seats(int seats){
		avilable_seats=seats;
	}
	
	public boolean gettype() {
		return type;
	}
	
	public void settype(boolean ac){
		type=ac;
	}
	
	public float getprice() {
		return price;
	}
	
	public void setprice(float p){
		price=p;
	}

}
