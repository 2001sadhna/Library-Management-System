package libraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewBookDAO {
    public void viewBooks() {
        String query = "SELECT * FROM books";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n--- LIBRARY BOOK LIST ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Title: " + rs.getString("title") +
                        " | Author: " + rs.getString("author") +
                        " | Price: " + rs.getDouble("price") +
                        " | Qty: " + rs.getInt("quantity"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}