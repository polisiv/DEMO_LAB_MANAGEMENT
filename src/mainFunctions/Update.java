package src.mainFunctions;

import java.util.Scanner;

public class Update {
    Scanner scanner = new Scanner(System.in);
    public Update(){
        System.out.println("Enter experiment's name");
        String name = scanner.nextLine();
        System.out.println("Enter updated section (please ONLY enter DESCRIPTION or MATERIALS");
        String updatedSection = scanner.nextLine();
        System.out.println("Enter updated information");
        String updatedInformation = scanner.nextLine();
        Insert.database.update(name,updatedSection,updatedInformation);
    }
}
