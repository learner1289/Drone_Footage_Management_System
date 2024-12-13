import java.util.Scanner;

public class Admin {
    private final String username;
    private final String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void approveOrRejectFootages(Scanner scanner) {
        System.out.println("\nPending Footages:");
        
        System.out.println("1. Approve Footage");
        System.out.println("2. Reject Footage");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Footage approved!");
        } else if (choice == 2) {
            System.out.println("Footage rejected!");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}