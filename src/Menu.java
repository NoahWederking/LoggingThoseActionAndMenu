import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private String menuHeader;
    private String[] menuItems;
    private String leadText;
    private int choice = -1;


    public Menu(String menuHeader, String leadText, String[] menuItems){
        this.menuHeader = menuHeader;
        this.menuItems = menuItems;
        this.leadText = leadText;

    }
    public String getMenuheader(){
        return menuHeader;
    }
    public String getLeadText(){
        return leadText;
    }
    public int getChoice(){
        return choice;
    }
    public void printMenu() {
        String printString = menuHeader + "\n";
        for (int i = 0; i < menuItems.length; i++)
            printString += menuItems[i] + "\n";
        System.out.println("\n" + printString);
        System.out.print(getLeadText());

    }
    public int readChoice() {
        Scanner scanner = new Scanner(System.in);
        boolean validChoice = false;
        choice = 1;
        while (! validChoice) {
            //System.out.print(getLeadText());
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                validChoice = true;
            } else {scanner.nextLine();}     }
        return choice;   }

    @Override
    public String toString(){
        return "Menu header " + menuHeader + "\nMenuitems " + menuItems + "\n leadtext: " + leadText;
    }
}
