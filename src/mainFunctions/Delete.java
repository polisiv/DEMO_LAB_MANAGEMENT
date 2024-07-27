package src.mainFunctions;

import src.database.Database;
import src.types.Experiment;

import java.util.ArrayList;
import java.util.Scanner;

public class Delete {
    public static Scanner scanner = new Scanner(System.in);
    public Delete(){
        System.out.println("""
                Deleting Methods
        1. Using Id
        2. Using name or materials
        Answer: """);
        int option = scanner.nextInt();
        switch (option){
            case 1: {
                System.out.println("Id: ");
                Integer id = scanner.nextInt();
                Insert.database.remove(id);
                break;
            }
            case 2: {
                scanner.nextLine();
                System.out.println("Name or materials: ");
                String input = scanner.nextLine();
                Insert.database.remove(input);
            }
        }
    }
}
