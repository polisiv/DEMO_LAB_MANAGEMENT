import src.GUI.UI;
import src.database.Database;
import src.mainFunctions.*;
import src.types.Experiment;
import src.types.Long_term;
import src.types.Short_term;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        chooseOption();
    }

    private static void chooseOption() {
        boolean looping = true;
        while(looping) {
            try {
                displayOptions();
                switch (getOption()) {
                    case 1 -> {
                        new Insert();
                        clearScreen();
                    }
                    case 2 -> {
                        new Delete();
                        clearScreen();
                    }
                    case 3 -> {
                        new Update();
                        clearScreen();
                    }
                    case 4 -> {
                        new Search();
                        clearScreen();
                    }
                    case 5 -> {
                        new Display();
                        clearScreen();
                    }
                    case 6 -> {
                        System.out.println("Quiting...");
                        looping = false;
                    }
                    default -> {
                        System.out.println("Invalid option");
                        clearScreen();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please try again!");
                scanner.nextLine();
            }
        }
    }

    private static void clearScreen() {
        System.out.printf("%n".repeat(1));
        System.out.println("=".repeat(50));
    }

    private static void displayOptions() {
        System.out.println("""
                        WELCOME TO LABORATORY MANAGEMENT
                        ================================
                Please choose options:
                1. Insert data
                2. Data deleting
                3. Data updating
                4. Data searching
                5. Display data
                6. Quiting
                Answer: """);
    }

    private static int getOption() {
            int option = scanner.nextInt();
            scanner.nextLine();
            return option;
        }
    }