import java.util.Scanner;

public class DroneFootageSeller {
    private String name;
    private String username;
    private String password;
    private DroneFootage[] uploadedFootages = new DroneFootage[5];

    public DroneFootageSeller(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void uploadFootage(Scanner scanner) {
        System.out.print("Enter footage description: ");
        String description = scanner.nextLine();
        System.out.print("Enter footage location: ");
        String location = scanner.nextLine();
        System.out.print("Enter footage price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        DroneFootage footage = new DroneFootage(description, location, price);
        for (int i = 0; i < uploadedFootages.length; i++) {
            if (uploadedFootages[i] == null) {
                uploadedFootages[i] = footage;
                System.out.println("Footage uploaded successfully!");
                return;
            }
        }
        System.out.println("Failed to upload footage. Max limit reached.");
    }

    public void viewUploadedFootages() {
        System.out.println("\nUploaded Footages:");
        for (DroneFootage footage : uploadedFootages) {
            if (footage != null) {
                System.out.println(footage);
            }
        }
    }
}