import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int length = 6;
        Random random = new Random();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(random.nextInt(1, 10));
            }
            sb.append(random.nextInt(10));
        }
        String number = sb.toString();

        System.out.println("raw number: " + sb);
        System.out.println("processed: " + processNumber(number));
    }

    private static String processNumber(String input) {
        char[] digits = input.toCharArray();

        for (int i = 0; i < digits.length; i++) {
            int digit = Character.getNumericValue(digits[i]);

            if (digit % 2 != 0) {
                if (digit == 9) {
                    digit = 0;
                } else {
                    digit += 1;
                }
                digits[i] = Character.forDigit(digit, 10);
            }
        }

        if (digits.length > 1) {
            char temp = digits[0];
            digits[0] = digits[digits.length - 1];
            digits[digits.length - 1] = temp;
        }

        return new String(digits);
    }
}
