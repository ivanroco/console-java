package copy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopyFile {

    Path destiny;
    Scanner scanner;
    String opc, name;

    public CopyFile(){
        scanner = new Scanner(System.in);
    }

    public void copyFile(Path source){

        System.out.println("Desea guardarolo en la misma ruta?\ns\\n");
        opc = scanner.nextLine();
        if(opc.equalsIgnoreCase("s")){
            System.out.print("Infrese el nombre del archivo con su extension: ");
            name = scanner.nextLine();
            destiny = Path.of(source.getParent() + File.separator + name);
            try {
                Files.copy(source, destiny, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(opc.equalsIgnoreCase("n")){
            System.out.print("Ingrese la ruta absoluta, nombre y la extension del archivo");
            name = scanner.nextLine();
            destiny = Path.of(name);
            try {
                Files.copy(source,destiny);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("seleccione una opcion valida");
            copyFile(source);
        }
    }
}
