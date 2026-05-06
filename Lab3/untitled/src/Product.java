import java.time.LocalDate;

public class Product {
    private final int registrationNumber;
    private final String type;
    private final String model;
    private final int quantity;
    private final String manufacturer;
    private final double price;
    private final LocalDate manufactureDate;

    public Product(int registrationNumber, String type, String model, int quantity, String manufacturer, double price, LocalDate manufactureDate) {
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.model = model;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
        this.price = price;
        this.manufactureDate = manufactureDate;
    }

    public int getRegistrationNumber() { return registrationNumber; }
    public String getType() { return type; }
    public String getModel() { return model; }
    public int getQuantity() { return quantity; }
    public String getManufacturer() { return manufacturer; }
    public double getPrice() { return price; }
    public LocalDate getManufactureDate() { return manufactureDate; }
}