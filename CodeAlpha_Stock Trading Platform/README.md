📈 Stock Trading Platform – Java-Based Simulation System
📌 Project Overview

The Stock Trading Platform is a Java-based application that simulates a real-world stock trading environment.The system allows users to view live market data, buy and sell stocks, track portfolio performance, calculate profit/loss dynamically, and maintain persistent records using file handling.
The application demonstrates strong Object-Oriented Programming principles, financial calculation logic, multi-user management, and GUI development using Java Swing.

🎯 Features

Live market simulation with dynamic price updates
Buy and sell stock functionality
Real-time balance tracking
Profit/Loss calculation (amount + percentage)
Transaction history tracking
Portfolio performance summary
Multi-user login system
Data persistence (separate file per user)
Graphical User Interface (Swing-based)
Input validation and exception handling

🏗 Project Structure
Stock_Trading/
│
├── Stock.java              → Stock model
├── StockMarket.java        → Market simulation engine
├── Portfolio.java          → Portfolio management logic
├── User.java               → User account class
├── StockTradingGUI.java    → GUI interface
├── Main.java               → Console version
├── portfolio_username.txt  → User data files
└── README.md               → Documentation

🧠 Core Concepts Implemented
 Object-Oriented Programming,Encapsulation of stock and portfolio data,Class abstraction (Stock, Portfolio, StockMarket, User),Modular architecture,Separation of business logic and UI
Financial Logic,Average buy price calculation,Real-time profit/loss computation,Profit percentage calculation,Net worth calculation,Market price fluctuation simulation

Data Persistence,File-based storage per user:portfolio_username.txt
Automatic load on startup
Auto-save after buy/sell operations
Multi-User System
Login prompt at startup
Separate portfolio per user
Isolated financial records

GUI Development

Java Swing-based interface
Event-driven programmin
Real-time updates in output panel

🖥 GUI Functionalities
View Market Stocks
Update Market Prices
Buy Stocks
Sell Stocks
View Portfolio
View Transaction History
Portfolio Performance Summary
Multi-user login system

 How to Run
javac *.java 

Run GUI version:
java StockTradingGUI

java Main
📊 Example Portfolio Output
TCS | Shares: 10 | Buy Avg: Rs.3500 | Current: Rs.3600
P/L: Rs.1000 (2.85%)

Total Investment: Rs.35000
Current Value: Rs.36000
Overall P/L: Rs.1000 (2.85%)

💾 Data Storage Format
Each user has a file:
portfolio_shilan.txt

Format:
BALANCE=95000
TCS=10=3500
INFY=5=1500

Structure:
StockSymbol=Quantity=AverageBuyPrice

Technologies Used
Java (Core Java),Java Swing (GUI),Object-Oriented Programming,File I/O (FileReader, PrintWriter),HashMap & ArrayList,Random class (market simulation),Exception handling





Optional console version:
