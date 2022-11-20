

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    void run(){
        Menu menu = new Menu("???Velkommen???","Vælg hvad du vil",
                new String[]{"1. Tilføj linje", "2. Se logging", "3. Slet", "9. Luk program"});
        FileManage fm = new FileManage();
        fm.launchMessage();
        System.out.println();
        boolean running = true;
        while(running) {
            menu.printMenu();
            menu.readChoice();
            switch (menu.getChoice()){
                case 1: fm.createNewLine();
                break;
                case 2: fm.readingFile();
                break;
                case 3: fm.deleteLine();
                    break;
                case 9: running = false;
                        fm.endMassage();
                break;
                default:
                    System.out.println("Valg ikke valid");
                    break;

            }

        }
    }
}