public class DroneFootage {
    private String description;
    private String location;
    private double price;

    public DroneFootage(String description, String location, double price) {
        this.description = description;
        this.location = location;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Description: " + description + ", Location: " + location + ", Price: $" + price;
    }
}