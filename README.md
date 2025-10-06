# consoleapplication
bus booking application
🚌 Console Bus Booking System (Java + MySQL)
📖 Overview
This is a console-based bus booking system developed using Java and MySQL.Just crated to checking the logic whether it is working or not.
The system allows users to search for available buses based on route and date, book seats, and automatically update the available seat count after each booking.

⚙️ Features
✅ View available buses by entering From, To, and Journey Date
✅ Automatically checks if buses exist for the selected route
✅ Shows available seats and reduces them after booking
✅ Displays bus details such as departure time, type, and price
✅ Handles booking details including passenger name, phone number, and email
✅ Uses JDBC for database connectivity

🧠 Technologies Used
Language: Java (JDK 8 or later)
Database: MySQL
IDE: Eclipse 
Libraries: JDBC Driver for MySQL

🧩 Project Structure
src/
├── bus_dao.java            # Handles bus-related database operations
├── booking_dao.java        # Manages booking and seat count logic
├── booking.java            # Booking model class
├── bus.java                # Bus model class
├── dbConnection.java       # Database connection setup
└── main.java               # Entry point (user interaction and program flow)

📦 Future Enhancements
Ready to develop it as a web project based on React and spring boot
Add Online payment integration
Admin panel for managing buses and bookings 
Add automatically send email to the users who successfully booked the seat.
