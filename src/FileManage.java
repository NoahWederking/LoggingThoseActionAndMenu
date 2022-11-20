import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileManage {

    private ArrayList<String> lines = new ArrayList<String>();


    //Menu is instantiated to use the readChoice method #Genbrug
    Menu menu = new Menu("???Velkommen???","Vælg noget du vil",
            new String[]{"1. Tilføj", "2. Se", "3. Slet"});

    public void readingFile(){
        Scanner fileScanner = null;
        try{
            fileScanner = new Scanner(new File("file.txt"));
            while (fileScanner.hasNext()){
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        lines.add(logging()+ "*Viewing Files*");
        saveFile();

    }

    public void saveFile(){
        File file = new File("file.txt");
        try {
            FileWriter fw = new FileWriter(file,true);

            //Hvis de to nedenstående linjer er med vil den skrive hele arraylisten igen og igen
            //for (int i = 0; i <lines.size(); i++){
                //fw.append(lines.get(i)+ "\n");}
            fw.append(lines.get(lines.size()-1)+ "\n");
            fw.close();
        } catch (IOException e ){
            e.printStackTrace();
        }
    }

    public void createNewLine(){
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.println("Indsæt en sætning ");
        name = sc.nextLine();
        lines.add(logging() + "Adding line:" + " "+ name);
        saveFile();

    }

    public String logging(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MMMMMMMMM-dd-HH:mm ");
        Date date = new Date();
        String time = dateFormat.format(date);
        return time;
    }


    public void deleteLine(){
        System.out.println(lines.size());
        System.out.println("Vælg et index du gerne vil have fjernet start fra \"0\"");
        menu.readChoice();
        boolean running = true;
        while(running) {
            if (menu.getChoice() > lines.size()) {
                System.out.println("Input out of bounds");
            } else {
                System.out.println("Delete successful");
                running = false;
            }
        }
        lines.remove(menu.getChoice());
        lines.add(logging() + "Deleting Line #"+menu.getChoice() + "* " + lines.get(menu.getChoice())+" *");
        saveFile();

    }

    public void launchMessage(){
        lines.add(logging() + "*PROGRAM STARTED*");
        saveFile();
    }
    public void endMassage(){
        lines.add(logging() + "*PROGRAM ENDED*");
        saveFile();
    }
}
