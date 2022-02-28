package commands;

import copy.CopyFile;
import executable.RunApp;
import show.ShowContent;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

public class ValidateCommands {

    ArrayList<String> commands;
    int index;
    File file;
    CopyFile copyFile;
    ShowContent showContent;
    RunApp runApp;
    Boolean run;

    public ValidateCommands(){
        copyFile = new CopyFile();
        showContent = new ShowContent();
        runApp = new RunApp();
        commands = new ArrayList<>();
        run = false;
    }

    public void analyze(ArrayList<String> commands){
        this.commands.clear();
        this.commands.addAll(commands);
        index = 0;
        run = false;
        if(!commands.isEmpty()){
            if(this.commands.get(index).equals("type")){
                state1();
            }

            if(index < commands.size()){
                if (this.commands.get(index).equals("copy")){
                    state2();
                }
            }

            if(index < commands.size()){
                if(!run)
                    stage3();
            }
        }
    }

    private void stage3() {
        runApp.runApp(commands.get(index));
    }

    private void state1(){
        index++;
        if(index < commands.size()){
            file = new File(commands.get(index));
            if(file.exists()){
                state1_2();
            }else{
                System.out.println(commands.get(index));
                System.out.println("El archivo no existe / Ruta invalida!");
            }
        }
    }

    private void state1_2(){
        index++;
        if(index < commands.size()){
            if(commands.get(index).equals("-")){
                state1_3();
            }
        }else{
            showContent.show(Path.of(commands.get(index - 1)),"");
        }
        run = true;
    }

    private void state1_3(){
        index++;
        if(index < commands.size()){
            if(commands.get(index).matches("\\d*")){
                showContent.show(Path.of(commands.get(1)),commands.get(index));
            }
        }else{
            System.out.println("faltan parametros");
        }
        run = true;
    }

    private void state2(){
        index++;
        if(index < commands.size()){
            file = new File(commands.get(index));
            if(file.exists()){
                state2_1();
            }else{
                System.out.println("El archivo no existe / Ruta invalida!");
            }
        }
    }

    private void state2_1(){
         copyFile.copyFile(Path.of(commands.get(index)));
         run = true;

    }
}
