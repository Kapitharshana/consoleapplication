package newbusbooking;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

	public class busdemo {
	    public static void main(String[] args) throws SQLException {

	        System.out.println("Welcome to bus booking system");

	        Scanner sc = new Scanner(System.in);

	        System.out.print("From: ");
	        String from = sc.next();

	        System.out.print("To: ");
	        String to = sc.next();

	        Date date = null;
	        System.out.print("Enter the date in this format dd-MM-yyyy: ");
	        String sdate = sc.next();

	        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

	        try {
	            date = dateformat.parse(sdate);
	            Date today = new Date();
	            if (date.before(today)) {
	                System.out.println("Error: You cannot enter a past date!");
	                return;
	            }
	        } catch (ParseException e) {
	            System.out.println("Invalid date format. Please enter in dd-MM-yyyy format.");
	            return;
	        }

	        System.out.println("\nAvailable Buses: ");

	        busdao bdo = new busdao();

	        // Display buses by route and date
	        List<Integer> busList = bdo.displayinfo(from, to);

	        if (busList.isEmpty()) {
	            System.out.println("❌ No buses available for this route!");
	            return;
	        }

	        System.out.println(" ");

	        try {
	            int userOpt = 1;
	            while (userOpt == 1) {
	                System.out.print("Enter 1 to book, 2 to exit: ");
	                userOpt = sc.nextInt();

	                if (userOpt == 1) {
	                    System.out.print("Enter the bus ID that you are going to book: ");
	                    int id = sc.nextInt();

	                    booking_dao bgd = new booking_dao();
	                    List<Integer> seats = bgd.getAvailableSeats(id, date);

	                    if (seats.isEmpty()) {
	                        System.out.println("❌ No seats available for this bus.");
	                        return;
	                    }

	                    System.out.println("Available seat numbers: " + seats);

	                    System.out.print("Choose a seat number: ");
	                    int seatNo = sc.nextInt();

	                    sc.nextLine(); // flush

	                    // Collect passenger info
	                    System.out.print("Enter Passenger Name: ");
	                    String name = sc.nextLine();

	                    System.out.print("Enter Phone: ");
	                    String phone = sc.nextLine();

	                    System.out.print("Enter Email: ");
	                    String email = sc.nextLine();

	                    bgd.addBooking(id, seatNo, date, name, phone, email);

	                    // update available seats count in ctob
	                    bdo.updateAvailableSeats(id, date);

	                    System.out.println("✅ Booking confirmed for " + name + " | Seat: " + seatNo);
	                }
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	}


		