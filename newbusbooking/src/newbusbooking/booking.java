package newbusbooking;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class booking {
	String passangerName;
    String phoneNum;
    String email;
	
	booking(){
		Scanner sc=new Scanner(System.in);
		

		System.out.print("Enter Passenger Name: ");
	    String passangername = sc.nextLine();
	    
	    System.out.print("Enter Phone: ");
	    String phoneNum = sc.nextLine();
	    
	    System.out.print("Enter Email: ");
	    String email = sc.nextLine();
		
	}

}


