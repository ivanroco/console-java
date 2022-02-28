package show;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ShowContent {
    int count;
    Path source;
    BufferedReader reader;
    String aux, opc;
    Scanner scanner;
    public ShowContent(){
        count = 0;
        aux = "";
        scanner = new Scanner(System.in);
    }

    public void show(Path source, String opc){
        count = 0;
        aux = "";
        this.source = source;
        if(opc.equals("")){
            showAll();
        }else if(opc.matches("\\d*")){
            this.opc = opc;
            showLines();
        }

    }

    public void showAll(){
        try {
            reader = new BufferedReader(new FileReader(String.valueOf(source)));
            while (aux != null){
                aux = reader.readLine();
                if(aux != null){
                    System.out.println(aux);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showLines() {
        try {
            reader = new BufferedReader(new FileReader(String.valueOf(source)));
            while (aux != null) {
                aux = reader.readLine();
                if (aux != null) {
                    if(count == Integer.parseInt(opc)){
                        scanner.nextLine();
                    }
                    System.out.println(aux);
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
