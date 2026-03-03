public class Reservation {
    private static int counter = 1;   // auto-increment ID
    private int bookingId;
    private Room room;
    private Customer customer;
    private String checkInDate;
    private int numberOfDays;
    private double totalAmount;

    public Reservation(Room room, Customer customer, String checkInDate, int numberOfDays) {
    	this.bookingId = counter++;
    	this.room = room;
    	this.customer = customer;
    	this.checkInDate = checkInDate;
    	this.numberOfDays = numberOfDays;
    	this.totalAmount = room.getPrice() * numberOfDays;
    	room.bookRoom();
}

    public int getBookingId() {
        return bookingId;
    }

    public Room getRoom() {
        return room;
    }
    public double getTotalAmount() {
    	return totalAmount;
    }
    public void displayReservation() {
    	System.out.println("Booking ID: " + bookingId +
            	" | Customer: " + customer.getName() +
            	" | Room: " + room.getRoomNumber() +
            	" | Check-in: " + checkInDate +
            	" | Days: " + numberOfDays +
            	" | Total: " + totalAmount);
    }

    public void cancelReservation() {
        room.cancelBooking();
    }
    public Customer getCustomer() {
    return customer;
}

public String getCheckInDate() {
    return checkInDate;
}

public int getNumberOfDays() {
    return numberOfDays;
}
}