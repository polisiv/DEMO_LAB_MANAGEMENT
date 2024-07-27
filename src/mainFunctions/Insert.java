package src.mainFunctions;

import src.database.Database;
import src.types.Experiment;
import src.types.Long_term;
import src.types.Short_term;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Insert {
    Scanner scanner = new Scanner(System.in);
    public static ArrayList<Experiment> list = new ArrayList<>();
    static Database database = new Database(list);
    public Insert() {
        while (true) {
            try {
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                System.out.println("Enter description: ");
                String description = scanner.nextLine();
                System.out.println("Enter elements: ");
                String elements = scanner.nextLine();
                System.out.println("(1) for long term experiment and (2) for short term experiment");
                int ans = scanner.nextInt();
                scanner.nextLine();
                switch (ans) {
                    case 1: {
                        list.add(new Long_term(name, description, elements));
                        database.add(list);
                        break;
                    }
                    case 2: {
                        list.add(new Short_term(name, description, elements));
                        database.add(list);
                        break;
                    }
                    default:
                        System.out.println("Invalid input");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please try again!");
                scanner.nextLine();
            }
        }
    }
}
