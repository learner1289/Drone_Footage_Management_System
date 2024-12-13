import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DroneFootageSeller[] sellers = new DroneFootageSeller[5];
        Customer[] customers = new Customer[5]; 
        Admin admin = new Admin("admin", "pass"
                + ""); 

        System.out.println("\nAerialStock ");
        System.out.println("- A trusted site for drone footages -");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerMenu(scanner, sellers, customers);
                    break;
                case 2:
                    loginMenu(scanner, sellers, customers, admin);
                    break;
                case 3:
                    adminLogin(scanner, admin);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void registerMenu(Scanner scanner, DroneFootageSeller[] sellers, Customer[] customers) {
        System.out.println("\nRegistration Menu:");
        System.out.println("1. Register as Drone Footage Seller");
        System.out.println("2. Register as Customer");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice == 1) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            DroneFootageSeller seller = new DroneFootageSeller(name, username, password);
            for (int i = 0; i < sellers.length; i++) {
                if (sellers[i] == null) {
                    sellers[i] = seller;
                    System.out.println("Drone Footage Seller registered successfully!");
                    return;
                }
            }
            System.out.println("Registration failed! No space for more sellers.");
        } else if (choice == 2) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            Customer customer = new Customer(name, username, password);
            for (int i = 0; i < customers.length; i++) {
                if (customers[i] == null) {
                    customers[i] = customer;
                    System.out.println("Customer registered successfully!");
                    return;
                }
            }
            System.out.println("Registration failed! No space for more customers.");
        } else {
            System.out.println("Invalid option. Returning to main menu.");
        }
    }

    private static void loginMenu(Scanner scanner, DroneFootageSeller[] sellers, Customer[] customers, Admin admin) {
        System.out.println("\nLogin Menu:");
        System.out.println("1. Login as Drone Footage Seller");
        System.out.println("2. Login as Customer");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice == 1) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            for (DroneFootageSeller seller : sellers) {
                if (seller != null && seller.login(username, password)) {
                    droneFootageSellerMenu(scanner, seller);
                    return;
                }
            }
            System.out.println("Invalid username or password.");
        } else if (choice == 2) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            for (Customer customer : customers) {
                if (customer != null && customer.login(username, password)) {
                    customerMenu(scanner, customer);
                    return;
                }
            }
            System.out.println("Invalid username or password.");
        } else {
            System.out.println("Invalid option. Try again.");
        }
    }

    private static void adminLogin(Scanner scanner, Admin admin) {
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (admin.login(username, password)) {
            adminMenu(scanner, admin);
        } else {
            System.out.println("Admin login failed.");
        }
    }

    private static void adminMenu(Scanner scanner, Admin admin) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. See Pending Footages");
            System.out.println("2. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                admin.approveOrRejectFootages(scanner);
            } else if (choice == 2) {
                System.out.println("Logging out...");
                return;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void droneFootageSellerMenu(Scanner scanner, DroneFootageSeller seller) {
        while (true) {
            System.out.println("\nDrone Footage Seller Menu:");
            System.out.println("1. Upload Footage");
            System.out.println("2. View Uploaded Footages");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                seller.uploadFootage(scanner);
            } else if (choice == 2) {
                seller.viewUploadedFootages();
            } else if (choice == 3) {
                System.out.println("Logging out...");
                return;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void customerMenu(Scanner scanner, Customer customer) {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Search Footages");
            System.out.println("2. View Purchased Footages");
            System.out.println("3. Purchase Footage");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                customer.searchFootages(scanner);
            } else if (choice == 2) {
                customer.viewPurchasedFootages();
            } else if (choice == 3) {
                customer.purchaseFootage(scanner);
            } else if (choice == 4) {
                System.out.println("Logging out...");
                return;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
}