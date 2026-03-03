import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelSystem {
    private final String FILE_NAME = "bookings.txt";
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public HotelSystem() {
        rooms.add(new Room(101, "Standard", 2000));
        rooms.add(new Room(102, "Deluxe", 3000));
        rooms.add(new Room(103, "Suite", 5000));
	loadFromFile();
    }

    public String getAvailableRooms() {

    StringBuilder sb = new StringBuilder();

    for (Room room : rooms) {
        if (room.isAvailable()) {
            sb.append(room.getRoomDetails()).append("\n");
        }
    }

    if (sb.length() == 0) {
        return "No rooms available.";
    }

    return sb.toString();
}

    public void bookRoom(int roomNumber, String name, String phone, String date, int days) {
    for (Room room : rooms) {
        if (room.getRoomNumber() == roomNumber && room.isAvailable()) {

            Customer customer = new Customer(name, phone);

            System.out.println("Total Amount: ₹" + (room.getPrice() * days));
	    System.out.println("Processing payment...");
	    System.out.println("Payment Successful ");

            Reservation reservation = new Reservation(room, customer, date, days);
            reservations.add(reservation);
	    saveToFile(reservation);

            System.out.println("Room booked successfully!");
            reservation.displayReservation();
            return;
        }
    }
    System.out.println("Room not available.");
}
    public void cancelReservation(int roomNumber) {
        for (Reservation res : reservations) {
            if (res.getRoom().getRoomNumber() == roomNumber) {
                res.cancelReservation();
                reservations.remove(res);
                System.out.println("Reservation cancelled successfully!");
                return;
            }
        }
        System.out.println("No reservation found for this room.");
    }
    public void viewAllReservations() {
    	if (reservations.isEmpty()) {
        	System.out.println("No reservations found.");
        		return;
    	}

    	for (Reservation res : reservations) {
        	res.displayReservation();
    	}
     }
     public void searchByBookingId(int id) {
    	for (Reservation res : reservations) {
        	if (res.getBookingId() == id) {
            		System.out.println("Reservation Found:");
            		res.displayReservation();
            		return;
        	}
    	}
    	System.out.println("No reservation found with this Booking ID.");
     }
     private void saveToFile(Reservation reservation) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
        writer.write(
            reservation.getBookingId() + "," +
            reservation.getRoom().getRoomNumber() + "," +
            reservation.getCustomer().getName() + "," +
            reservation.getCustomer().getPhone() + "," +
            reservation.getCheckInDate() + "," +
            reservation.getNumberOfDays() + "," +
            reservation.getTotalAmount()
        );
        writer.newLine();
    } catch (IOException e) {
        System.out.println("Error saving booking.");
    }
}
     public String getRevenueReport() {

    if (reservations.isEmpty()) {
        return "No bookings yet. Revenue is ₹0";
    }

    double totalRevenue = 0;

    for (Reservation res : reservations) {
        totalRevenue += res.getTotalAmount();
    }

    StringBuilder sb = new StringBuilder();
    sb.append("===== REVENUE REPORT =====\n");
    sb.append("Total Bookings: ").append(reservations.size()).append("\n");
    sb.append("Total Revenue: ₹").append(totalRevenue).append("\n");
    sb.append("Average Booking Value: ₹")
      .append(totalRevenue / reservations.size());

    return sb.toString();
}
     public void exportBookingsToCSV() {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("bookings_report.csv"))) {

        writer.write("BookingID,RoomNumber,CustomerName,Phone,CheckInDate,Days,TotalAmount");
        writer.newLine();

        for (Reservation res : reservations) {

            writer.write(
                res.getBookingId() + "," +
                res.getRoom().getRoomNumber() + "," +
                res.getCustomer().getName() + "," +
                res.getCustomer().getPhone() + "," +
                res.getCheckInDate() + "," +
                res.getNumberOfDays() + "," +
                res.getTotalAmount()
            );

            writer.newLine();
        }

        System.out.println("Bookings exported successfully to bookings_report.csv ✅");

    } catch (IOException e) {
        System.out.println("Error exporting bookings.");
    }
}
     private void loadFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");

            int bookingId = Integer.parseInt(data[0]);
            int roomNumber = Integer.parseInt(data[1]);
            String name = data[2];
            String phone = data[3];
            String date = data[4];
            int days = Integer.parseInt(data[5]);

            for (Room room : rooms) {
                if (room.getRoomNumber() == roomNumber) {

                    Customer customer = new Customer(name, phone);
                    Reservation reservation =
                        new Reservation(room, customer, date, days);

                    reservations.add(reservation);
                    break;
                }
            }
        }

    } catch (IOException e) {
        // file may not exist first time
    }
}
public void clearAllData() {

    reservations.clear();

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
        writer.write("");
    } catch (IOException e) {
        System.out.println("Error clearing file.");
    }
}
}