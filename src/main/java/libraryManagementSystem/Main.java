package libraryManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AddBookDAO addDAO = new AddBookDAO();
        ViewBookDAO viewDAO = new ViewBookDAO();
        UpdateBookDAO updateDAO = new UpdateBookDAO();
        DeleteBookDAO deleteDAO = new DeleteBookDAO();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== MODULAR LIBRARY SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Buffer clear

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    addDAO.addBook(title, author, price, quantity);
                    break;

                case 2:
                    viewDAO.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to update: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();
                    System.out.print("Enter new quantity: ");
                    int newQty = sc.nextInt();

                    updateDAO.updateBook(updateId, newPrice, newQty);
                    break;

                case 4:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteId = sc.nextInt();
                    deleteDAO.deleteBook(deleteId);
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting application. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
        sc.close();
    }
}