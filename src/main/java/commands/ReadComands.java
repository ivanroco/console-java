package commands;

import java.util.ArrayList;

public class ReadComands {

    String input;
    int count;
    char character;
    String words;
    ArrayList<String> wordsCommands;
    public ReadComands(){
        wordsCommands = new ArrayList<>();
        count = 0;
        words = "";
    }

    public void inputAnalicer(String input){
        this.input = input;
        count = 0;
        wordsCommands.clear();
        words = "";
        do{
            character = input.charAt(count);
            switch (character){
                case 't': state1(); break;
                case 'c': state2(); break;
                case 'C':
                case '/': state3(); break;
                case '-': state4(); break;
                case ' ': count++; break;
                default: stage5();
            }
        }while (count < input.length());
    }

    public void state1(){
        words += character;
        count++;
        if(count < input.length()){
            character = input.charAt(count);
            switch (character){
                case 'y': state1_1(); break;
                default: break;
            }
        }
    }

    public void state1_1(){
        words += character;
        count++;
        if(count < input.length()){
            character = input.charAt(count);
            switch (character){
                case 'p': state1_2(); break;
                default: break;
            }
        }
    }

    public void state1_2(){
        words += character;
        count++;
        if(count < input.length()){
            character = input.charAt(count);
            switch (character){
                case 'e': state1_3(); break;
                default: break;
            }
        }
    }

    public void state1_3(){
        words += character;
        count++;
        if(count < input.length()){
            character = input.charAt(count);
            switch (character){
                case ' ': wordsCommands.add(words); words = ""; break;
                default: words = ""; break;
            }
        }else {
            System.out.println("Faltan parametros en la instruccion tyoe");
        }
    }

    public void state2(){
        words += character;
        count++;
        if(count < input.length()){
            character = input.charAt(count);
            switch (character){
                case 'o': state2_1(); break;
                default: break;
            }
        }
    }

    public void state2_1(){
        words += character;
        count++;
        if(count < input.length()){
            character = input.charAt(count);
            switch (character){
                case 'p': state2_2(); break;
                default: break;
            }
        }
    }

    public void state2_2(){
        words += character;
        count++;
        if(count < input.length()){
            character = input.charAt(count);
            switch (character){
                case 'y': state2_3(); break;
                default: break;
            }
        }
    }

    public void state2_3(){
        if(character != ' ')
        words += character;
        count++;
        if(count < input.length()){
            character = input.charAt(count);
            switch (character){
                case ' ': wordsCommands.add(words); words = ""; break;
                default: words = ""; break;
            }
        }else {
            words = "";
            System.out.println("Faltan parametros en la instruccion copy");
        }
    }

    public void state3(){
        if(character != ' ')
        words += character;
        count++;
        if(count < input.length()){
            character = input.charAt(count);
            switch (character){
                case ' ': wordsCommands.add(words); words = ""; break;
                default: state3();
            }
        }else{
            wordsCommands.add(words);
            words = "";
        }
    }

    private void state4(){
        words += character;
        wordsCommands.add(words);
        words = "";
        count++;
        if(count < input.length()){
            character = input.charAt(count);
            if(String.valueOf(character).matches("\\d*")){
                state4_1();
            }
        }else{
            System.out.println("Faltan parametros");
        }
    }

    private void state4_1(){
        words += character;
        count++;
        if(count < input.length()){
            character = input.charAt(count);
            if(String.valueOf(character).matches("\\d*")){
                state4_1();
            }else{
                wordsCommands.add(words);
                words = "";
            }
        }else{
            wordsCommands.add(words);
            words = "";
        }
    }

    public ArrayList<String> getWordsCommands() {
        return wordsCommands;
    }

    private void stage5(){
        words += character;
        count++;
        if(count < input.length()){
            character = input.charAt(count);
            if(character == '-' || character == '_'){
                stage5();
            }
        }else{
            wordsCommands.add(words);
            words = "";
        }
    }
}
