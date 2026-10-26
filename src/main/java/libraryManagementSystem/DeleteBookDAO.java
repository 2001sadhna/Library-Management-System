package libraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBookDAO {
    public void deleteBook(int id) {
        String query = "DELETE FROM books WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("--> Book deleted successfully using PreparedStatement!");
            } else {
                System.out.println("--> Book ID not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}