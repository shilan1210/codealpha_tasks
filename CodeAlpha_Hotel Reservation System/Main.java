import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelSystem hotel = new HotelSystem();
	
	System.out.println("===== HOTEL MANAGEMENT SYSTEM =====");

	System.out.print("Enter Admin Username: ");
	String username = sc.nextLine();

	System.out.print("Enter Admin Password: ");
	String password = sc.nextLine();

	if (!username.equals("shilan") || !password.equals("1234")) {
    		System.out.println("Invalid credentials. Access denied.");
    		System.exit(0);
	}

	System.out.println("Login Successful !!");

        while (true) {
    	System.out.println("\n1. View Rooms");
System.out.println("2. Book Room");
System.out.println("3. Cancel Booking");
System.out.println("4. View All Reservations");
System.out.println("5. Search by Booking ID");
System.out.println("6. Revenue Report");
System.out.println("7. Export Bookings to CSV");
System.out.println("8. Exit");

    int choice = sc.nextInt();

    switch (choice) {
        case 1:
            System.out.println(hotel.getAvailableRooms());
            break;

        case 2:
            System.out.print("Enter Room Number: ");
            int roomNo = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();
            
	    System.out.print("Enter Check-in Date (DD-MM-YYYY): ");
	    String date = sc.nextLine();

	    System.out.print("Enter Number of Days: ");
	    int days = sc.nextInt();
            sc.nextLine();

	    hotel.bookRoom(roomNo, name, phone, date, days);
            break;

        case 3:
            System.out.print("Enter Room Number to Cancel: ");
            int cancelRoom = sc.nextInt();
            hotel.cancelReservation(cancelRoom);
            break;

        case 4:
    	    hotel.viewAllReservations();
    	    break;

	case 5:
       	    System.out.print("Enter Booking ID: ");
   	    int searchId = sc.nextInt();
  	    hotel.searchByBookingId(searchId);
  	    break;

	case 6:
    System.out.println(hotel.getRevenueReport());
    break;

case 7:
    hotel.exportBookingsToCSV();
    break;

case 8:
    System.exit(0);
    }
}
    }
}