import commands.ReadComands;
import commands.ValidateCommands;

import java.util.Scanner;

public class MainConsole {

    static Scanner scanner;
    static String text;
    static ReadComands readComands;
    static ValidateCommands validateCommands;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        readComands = new ReadComands();
        validateCommands = new ValidateCommands();
        read();
    }

    public static void read(){
        do{
            text = scanner.nextLine();
            if(!(text.isEmpty() || text.isBlank() || text.equalsIgnoreCase("q"))){
                readComands.inputAnalicer(text);
                validateCommands.analyze(readComands.getWordsCommands());
            }
        }while (!text.equalsIgnoreCase("q"));
    }
}
