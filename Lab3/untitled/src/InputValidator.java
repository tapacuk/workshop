import java.util.Scanner;

public class InputValidator {
    private final Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = scanner.nextLine().trim();
                int value = Integer.parseInt(input);
                if (value < min || value > max) {
                    throw new IllegalArgumentException("Значення повинно бути в межах від " + min + " до " + max + ".");
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Помилка: Введено не ціле число! Спробуйте ще раз.");
            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }
}