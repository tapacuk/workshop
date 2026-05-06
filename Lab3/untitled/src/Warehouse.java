public class Warehouse {
    private final Product[] products;

    public Warehouse(Product[] products) {
        this.products = products;
    }

    public Product[] getAllProducts() {
        return products;
    }

    // Завдання 1: Отримати список товарів заданої фірми виробника
    public Product[] getProductsByManufacturer(String manufacturer) {
        int count = 0;
        for (Product p : products) {
            if (p.getManufacturer().equalsIgnoreCase(manufacturer)) count++;
        }

        Product[] result = new Product[count];
        int index = 0;
        for (Product p : products) {
            if (p.getManufacturer().equalsIgnoreCase(manufacturer)) {
                result[index++] = p;
            }
        }
        return result;
    }

    // Завдання 2: Метод для отримання товарів за назвою
    public Product[] getProductsByName(String name) {
        int count = 0;
        for (Product p : products) {
            if (p.getType().equalsIgnoreCase(name)) count++;
        }

        Product[] result = new Product[count];
        int index = 0;
        for (Product p : products) {
            if (p.getType().equalsIgnoreCase(name)) {
                result[index++] = p;
            }
        }
        return result;
    }
}