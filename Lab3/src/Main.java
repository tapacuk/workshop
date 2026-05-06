import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputValidator input = new InputValidator(scanner);
        ConsoleView view = new ConsoleView();

        Product[] initialProducts = {
                new Product(101, "Ноутбук", "NOTE-15", 10, "ABC inc.", 1500.50, LocalDate.of(2023, 5, 10)),
                new Product(102, "Смартфон", "PhnE A12", 25, "Factur", 999.99, LocalDate.of(2023, 8, 15)),
                new Product(103, "Монітор", "UltraRGB IPS 144hz", 15, "qwerty", 450.00, LocalDate.of(2022, 11, 20)),
                new Product(104, "Смартфон", "iPhone 15", 30, "Apple", 1099.00, LocalDate.of(2023, 9, 10)),
                new Product(105, "Клавіатура", "Keychron K8", 50, "Keychron", 120.00, LocalDate.of(2023, 1, 5)),
                new Product(105, "Клавіатура", "Keychron K9", 55, "Keychron", 129.00, LocalDate.of(2023, 1, 5)),
                new Product(101, "Ноутбук", "MacBook", 10, "Apple", 2300.0, LocalDate.of(2023, 5, 10)),
        };

        Warehouse warehouse = new Warehouse(initialProducts);



        boolean running = true;
        while (running) {
            System.out.println("--- БАЗА ДАНИХ СКЛАДУ ---");
            view.printProductsTable(warehouse.getAllProducts());
            System.out.println("\nОберіть дію:");
            System.out.println("1 - Знайти товари заданої фірми-виробника");
            System.out.println("2 - Знайти інформацію (фірма, ціна, кількість) за назвою товару");
            System.out.println("0 - Вихід");

            int choice = input.readInt("Ваш вибір: ", 0, 2);
            System.out.println("\n".repeat(25));
            switch (choice) {
                case 1:
                    view.printManufacturers(initialProducts);

                    String manufacturer = input.readString("Введіть назву фірми-виробника: ");
                    Product[] byManufacturer = warehouse.getProductsByManufacturer(manufacturer);
                    System.out.println("\n".repeat(25));
                    if (byManufacturer.length > 0) {
                        view.printProductsTable(byManufacturer);
                    } else {
                        System.out.println("! Товарів фірми '" + manufacturer + "' не знайдено.");
                    }
                    break;
                case 2:
                    String productName = input.readString("Введіть тип товару (наприклад, Смартфон): ");
                    Product[] byName = warehouse.getProductsByName(productName);
                    System.out.println("\n".repeat(25));

                    if (byName.length > 0) {
                        view.printManufacturerPriceQuantityTable(byName);
                    } else {
                        System.out.println("! Товарів за типом '" + productName + "' не знайдено.");
                    }
                    break;
                case 0:
                    running = false;
                    System.out.println("Роботу завершено.");
                    break;
            }
        }
        scanner.close();
    }
}