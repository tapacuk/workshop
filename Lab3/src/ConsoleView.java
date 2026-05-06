import java.time.format.DateTimeFormatter;

public class ConsoleView {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public void printProductsTable(Product[] products) {
        System.out.println(String.format("%-8s | %-15s | %-19s | %-8s | %-15s | %-10s | %-12s",
                "Рег. №", "Тип", "Модель", "Кількість", "Виробник", "Ціна ($)", "Дата виг."));
        System.out.println("-".repeat(105));

        for (Product p : products) {
            System.out.println(String.format("%-8d | %-15s | %-19s | %-8d | %-15s | %-10.2f | %-12s",
                    p.getRegistrationNumber(),
                    p.getType(),
                    p.getModel(),
                    p.getQuantity(),
                    p.getManufacturer(),
                    p.getPrice(),
                    p.getManufactureDate().format(DATE_FORMAT)));
        }

    }
public void printManufacturers(Product[] products){
    String[] temp = new String[products.length];
    int uniqueCount = 0;

    for (Product p : products) {
        boolean exists = false;
        for (int i = 0; i < uniqueCount; i++) {
            if (temp[i].equalsIgnoreCase(p.getManufacturer())) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            temp[uniqueCount] = p.getManufacturer();
            uniqueCount++;
        }
    }

    String[] result = temp;
    System.out.print("Список доступних виробників: ");
        for (String r : result) {
            if (r != null) {
                System.out.print(r + ", ");
            }
        }
        System.out.println("\n");
    }

    public void printManufacturerPriceQuantityTable(Product[] products) {
        System.out.println(String.format("%-19s | %-19s | %-10s | %-8s",
                "Модель", "Виробник", "Ціна ($)", "Кількість"));
        System.out.println("-".repeat(65));

        for (Product p : products) {
            System.out.println(String.format("%-19s | %-15s | %-10.2f | %-8d",
                    p.getModel(),
                    p.getManufacturer(),
                    p.getPrice(),
                    p.getQuantity()));
        }

    }
}