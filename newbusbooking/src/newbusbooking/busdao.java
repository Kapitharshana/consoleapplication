package newbusbooking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

	public class busdao {
		
		// Display buses filtered by from/to 
		public List<Integer> displayinfo(String from, String to) throws SQLException { 
			String query = "SELECT * FROM buses WHERE departure=? AND arrival=?"; 
			Connection con = dbconnection.getConnection(); 
			PreparedStatement pst = con.prepareStatement(query); 
			pst.setString(1, from); pst.setString(2, to); 
			ResultSet rs = pst.executeQuery(); 
			
			List<Integer> busList = new ArrayList<>(); 
			System.out.println("Bus details...");
			System.out.println(" ");
			
			while (rs.next()) { 
				busList.add(rs.getInt("ID"));
				String type = rs.getInt("bus_type") == 0 ? "Normal" : "AC";
				System.out.println("Bus ID : " + rs.getInt(1) + 
						" | Departure: " + rs.getString(2) + 
						" | Arrival: " + rs.getString(3) + 
						" | Time: " + rs.getString(4) + 
						" | Seats Left: " + rs.getInt(5) + 
						" | Type: " + type + 
						" | Price: " + rs.getFloat(6)); System.out.println("---------------------------------------");
						}
			
			return busList; 
			}
		
		// Get total capacity 
		public int getCapacity(int bsNo) throws SQLException { 
			String query = "SELECT available_seats FROM buses WHERE ID = ?"; 
			Connection con = dbconnection.getConnection(); 
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, bsNo);
			ResultSet rs = pst.executeQuery(); 
			
			if (rs.next()) {
				return rs.getInt(1); 
				}
			return 0; }
		
		// Update available seats after booking 
		public void updateAvailableSeats(int busId, java.util.Date date) throws SQLException {
			int totalSeats = getCapacity(busId);
			booking_dao bdao = new booking_dao(); 
			int booked = bdao.getBookedCount(busId, date); 
			int available = totalSeats - booked;
			
			String query = "UPDATE buses SET available_seats=? WHERE ID=?"; 
			Connection con = dbconnection.getConnection(); 
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, available); 
			pst.setInt(2, busId); 
			pst.executeUpdate();
			}
		
	}


