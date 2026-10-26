package libraryManagementSystem;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class AddBookDAO {
    public void addBook(String title, String author, double price, int quantity) {
        String query = "{CALL sp_add_book(?, ?, ?, ?)}";

        try (Connection con = DBConnection.getConnection();
             CallableStatement cstmt = con.prepareCall(query)) {

            cstmt.setString(1, title);
            cstmt.setString(2, author);
            cstmt.setDouble(3, price);
            cstmt.setInt(4, quantity);

            cstmt.execute();
            System.out.println("--> Book added successfully using CallableStatement!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}