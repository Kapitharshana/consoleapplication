package newbusbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
	
		private static final String url="jdbc:mysql://localhost:3306/sltb";
		private static final String username="root";
		private static final String password="Kapi_*314";
		
		public static  Connection getConnection() throws SQLException{
			return DriverManager.getConnection(url,username,password);
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

	


}
