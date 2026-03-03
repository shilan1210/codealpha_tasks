public class Room {
    private int roomNumber;
    private String category;
    private double price;
    private boolean isAvailable;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }
    public String getRoomDetails() {
    return "Room: " + roomNumber +
           " | Category: " + category +
           " | Price: ₹" + price;
}

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        isAvailable = false;
    }

    public void cancelBooking() {
        isAvailable = true;
    }

    public void displayRoom() {
        System.out.println("Room: " + roomNumber +
                " | Category: " + category +
                " | Price: " + price +
                " | Available: " + isAvailable);
    }
}