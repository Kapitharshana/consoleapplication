package newbusbooking;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class booking_dao {
	// count booked seats 
	public int getBookedCount(int busNo, Date date) throws SQLException { 
		String query = "SELECT COUNT(passenger_name) FROM booking WHERE ID=? AND journey_date=?"; 
		Connection con = dbconnection.getConnection(); 
		PreparedStatement pst = con.prepareStatement(query); 
		java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
		pst.setInt(1, busNo);
		pst.setDate(2, sqlDate);
		ResultSet rs = pst.executeQuery();
		rs.next(); return rs.getInt(1); 
		
	}
	
	// find available seats as array 
	public List<Integer> getAvailableSeats(int busNo, Date date) throws SQLException { 
		String query = "SELECT seat_no FROM booking WHERE ID=? AND journey_date=?"; 
		Connection con = dbconnection.getConnection(); 
		PreparedStatement pst = con.prepareStatement(query); 
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		pst.setInt(1, busNo); pst.setDate(2, sqlDate); 
		ResultSet rs = pst.executeQuery(); 
		
		Set<Integer> bookedSeats = new HashSet<>(); 
		while (rs.next()) {
			bookedSeats.add(rs.getInt("seat_no")); 
			
		}
		
		busdao bd = new busdao(); 
		int totalSeats = bd.getCapacity(busNo); 
		
		List<Integer> availableSeats = new ArrayList<>(); 
		for (int i = 1; i <= totalSeats; i++) { 
			if (!bookedSeats.contains(i)) {
				availableSeats.add(i); }
			
				
		} 
				
		return availableSeats; 
		
	}
	// add booking
	public void addBooking(int busNo, int seatNo, Date date, String name, String phone, String email) throws SQLException { 
		String query = "INSERT INTO booking (ID, passenger_name, phone, email, seat_no, journey_date) VALUES (?, ?, ?, ?, ?, ?)"; 
		Connection con = dbconnection.getConnection(); 
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, busNo); pst.setString(2, name); 
		pst.setString(3, phone); pst.setString(4, email); 
		pst.setInt(5, seatNo); 
		pst.setDate(6, new java.sql.Date(date.getTime())); 
		pst.executeUpdate(); 
		
	}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}


		

}

