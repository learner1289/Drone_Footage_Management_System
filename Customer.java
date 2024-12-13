import java.util.Scanner;

public class Customer {
    private String name;
    private String username;
    private String password;
    private DroneFootage[] purchasedFootages = new DroneFootage[5];

    public Customer(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void searchFootages(Scanner scanner) {
        System.out.println("Enter location to search for footages: ");
        String location = scanner.nextLine();
        System.out.println("Searching footages for location: " + location);
        System.out.println("Results found!");
    }

    public void viewPurchasedFootages() {
        System.out.println("\nPurchased Footages:");
        for (DroneFootage footage : purchasedFootages) {
            if (footage != null) {
                System.out.println(footage);
            }
        }
    }

    public void purchaseFootage(Scanner scanner) {
        System.out.println("Enter footage description to purchase: ");
        String description = scanner.nextLine();
        // Assume we find the footage based on description
        DroneFootage footage = new DroneFootage(description, "Himchori", 100.0);
        for (int i = 0; i < purchasedFootages.length; i++) {
            if (purchasedFootages[i] == null) {
                purchasedFootages[i] = footage;
                System.out.println("Purchased Footage: " + footage);
                return;
            }
        }
        System.out.println("Failed to purchase. Max limit reached.");
    }
}
