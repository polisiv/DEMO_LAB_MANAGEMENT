package src.mainFunctions;

import src.database.Database;
import src.types.Experiment;

import java.util.ArrayList;
import java.util.Scanner;

public class Search {


    Scanner scanner = new Scanner(System.in);
    public Search(){
        while(true) {
            try {
                System.out.println("""
                                Searching Methods
                        1. Using Id
                        2. Using name or materials
                        Answer: """);
                int option = scanner.nextInt();
                switch (option) {
                    case 1: {
                        System.out.println("Id: ");
                        Integer id = scanner.nextInt();
                        System.out.println(Insert.database.search(id));
                        break;
                    }
                    case 2: {
                        scanner.nextLine();
                        System.out.println("Name or materials: ");
                        String input = scanner.nextLine();
                        System.out.println(Insert.database.search(input));
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Please try again!");
                scanner.nextLine();
            }
        }
    }
}
