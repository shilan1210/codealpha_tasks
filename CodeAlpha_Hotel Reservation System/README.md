   Hotel Management System – Java Desktop Application
📌 Project Overview

The Hotel Management System is a Java-based desktop application designed to manage hotel room bookings efficiently.The system allows users to view available rooms, book and cancel reservations, calculate total billing dynamically based on stay duration, generate revenue reports, export booking data, and maintain persistent records using file handling.
This project demonstrates strong Object-Oriented Programming (OOP) principles, GUI development using Java Swing, and data persistence using file I/O.

🎯 Features
 Room categorization (Standard, Deluxe, Suite)
 Booking with date and number of days
 Automatic total bill calculation
 Revenue analytics and profit summary
 Data persistence (file-based storage)
 CSV export of booking records
 Clear all data functionality
 Interactive GUI built with Java Swing
 Console-based version (optional execution mode)

🏗 Project Structure
Hotel_Reserve/
│
├── Room.java
├── Customer.java
├── Reservation.java
├── HotelSystem.java
├── HotelGUI.java
├── Main.java
├── bookings.txt
├── bookings.csv
└── README.md

🧠 Core Concepts Implemented
Object-Oriented Programming
  Encapsulation (private fields + getters)
     Class abstraction (Room, Customer, Reservation)
        Separation of concerns
           Modular architecture 
              Business Logic
                 Dynamic billing (price × number of days)
                     Revenue tracking
                         Booking validation
                            Room availability management 
                                File Handling
                                   Data saved to bookings.txt
                                        Automatic loading on system startup
                                           CSV export for reporting
                                               GUI Development

Java Swing interface
Event-driven programming (ActionListeners)
Structured layout using BorderLayout and panels

🖥 GUI Functionalities

View available rooms,Book room (room number, name, phone, date, days),View revenue report,Export bookings to CSV,Clear all stored data

How to Run
javac *.java

Run GUI version:
java HotelGUI

Optional console version:

java Main
Example Output

Booking:

Room booked successfully!
Total Bookings: 2
Total Revenue: Rs.7000

Revenue Report:

===== REVENUE REPORT =====
Total Bookings: 3
Total Revenue: Rs.15000

💾 Data Storage Format
  Bookings are stored in:bookings.txt
  Each record contains:RoomNumber,CustomerName,Phone,Date,Days

Technologies Used:Java (Core Java),Java Swing (GUI),OOP Principles,File I/O (BufferedReader, BufferedWriter),ArrayList & HashMap,Exception Handling
