import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введіть ім'я вхідного файлу: ");
        String inputFileName = console.nextLine();
        System.out.print("Введіть ім'я вихідного файлу: ");
        String outputFileName = console.nextLine();

        if (outputFileName.isBlank())
        {
            outputFileName = "output.txt";

        }
        else {
            outputFileName = outputFileName + ".txt";
        }

        int[] counts = new int[65536];

        try {

            FileReader reader = new FileReader(inputFileName);
            int symbol;
            while ((symbol = reader.read()) != -1) {
                char c = (char) symbol;
                if (Character.isLetter(c)) {
                    c = Character.toLowerCase(c);
                    counts[c]++;
                }
            }
            reader.close();

            PrintWriter writer = new PrintWriter(new FileWriter(outputFileName));
            writer.println("Частота букв у файлі:");

            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 0) {
                    writer.println((char)i + " -> " + counts[i]);
                }
            }
            writer.close();

            System.out.println("Результат збережено у файл: " + outputFileName);

        } catch (IOException e) {
            System.out.println("Помилка при роботі з файлами: " + e.getMessage());
        }
    }
}