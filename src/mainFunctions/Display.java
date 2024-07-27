package src.mainFunctions;

import src.database.Database;
import src.types.Experiment;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {
    Scanner scanner = new Scanner(System.in);

    public Display(){
        System.out.println("""
                Displaying options
        1. Full experiment (full)
        2. Long term experiment (only)
        3. Short term experiment (only)
        4. Detailed experiment
        Answer: """);
        int option = scanner.nextInt();
        switch (option){
            case 1: {
                Insert.database.getExperimentList();
                break;
            }
            case 2: {
                Insert.database.getLongTerm();
                break;
            }
            case 3:{
                Insert.database.getShortTerm();
                break;
            }
            case 4:{
                scanner.nextLine();
                System.out.println("Input name: ");
                String name = scanner.nextLine();
                Insert.database.getDetail(name);
                break;
            }
            default: System.out.println("Invalid input");
        }

    }
}
