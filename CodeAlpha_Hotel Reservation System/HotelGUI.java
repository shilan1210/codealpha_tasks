import javax.swing.*;
import java.awt.*;

public class HotelGUI {

    private HotelSystem hotel = new HotelSystem();

    public HotelGUI() {

        JFrame frame = new JFrame("Hotel Management System");
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // ===== Buttons =====
        JButton viewRoomsBtn = new JButton("View Rooms");
        JButton revenueBtn = new JButton("Revenue Report");
        JButton exportBtn = new JButton("Export CSV");
        JButton clearBtn = new JButton("Clear All Data");
        JButton bookBtn = new JButton("Book Room");

        // ===== Top Panel (Buttons) =====
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(viewRoomsBtn);
        topPanel.add(revenueBtn);
        topPanel.add(exportBtn);
        topPanel.add(clearBtn);

        frame.add(topPanel, BorderLayout.NORTH);

        // ===== Form Panel =====
        JTextField roomField = new JTextField(8);
        JTextField nameField = new JTextField(10);
        JTextField phoneField = new JTextField(10);
        JTextField dateField = new JTextField(10);
        JTextField daysField = new JTextField(5);


JPanel formPanel = new JPanel();
formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
row1.add(new JLabel("Room:"));
row1.add(roomField);
row1.add(new JLabel("Name:"));
row1.add(nameField);

JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
row2.add(new JLabel("Phone:"));
row2.add(phoneField);
row2.add(new JLabel("Date:"));
row2.add(dateField);

JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
row3.add(new JLabel("Days:"));
row3.add(daysField);

JPanel row4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
row4.add(bookBtn);

formPanel.add(row1);
formPanel.add(row2);
formPanel.add(row3);
formPanel.add(row4);

        frame.add(formPanel, BorderLayout.CENTER);

        // ===== Output Area =====
        JTextArea outputArea = new JTextArea(8, 60);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        frame.add(scrollPane, BorderLayout.SOUTH);

        // ===== Button Actions =====

        viewRoomsBtn.addActionListener(e ->
            outputArea.setText(hotel.getAvailableRooms())
        );

        revenueBtn.addActionListener(e ->
            outputArea.setText(hotel.getRevenueReport())
        );

        exportBtn.addActionListener(e -> {
            hotel.exportBookingsToCSV();
            outputArea.setText("CSV Exported Successfully!");
        });

        clearBtn.addActionListener(e -> {
            hotel.clearAllData();
            outputArea.setText("All data cleared successfully!");
        });

        bookBtn.addActionListener(e -> {
            try {
                int roomNo = Integer.parseInt(roomField.getText());
                String name = nameField.getText();
                String phone = phoneField.getText();
                String date = dateField.getText();
                int days = Integer.parseInt(daysField.getText());

                hotel.bookRoom(roomNo, name, phone, date, days);

                outputArea.setText("Booking Successful!\n\n" +
                        hotel.getRevenueReport());

            } catch (Exception ex) {
                outputArea.setText("Invalid Input! Please check values.");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new HotelGUI();
    }
}