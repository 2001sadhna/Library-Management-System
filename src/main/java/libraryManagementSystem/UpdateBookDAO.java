package libraryManagementSystem;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class UpdateBookDAO {
    public void updateBook(int id, double price, int quantity) {
        String query = "{CALL sp_update_book(?, ?, ?)}";

        try (Connection con = DBConnection.getConnection();
             CallableStatement cstmt = con.prepareCall(query)) {

            cstmt.setInt(1, id);
            cstmt.setDouble(2, price);
            cstmt.setInt(3, quantity);

            int rows = cstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("--> Book updated successfully using CallableStatement!");
            } else {
                System.out.println("--> Book ID not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}