package executable;

import java.io.IOException;

public class RunApp {
    String program;
    Process process;

    public RunApp(){
    }

    public void runApp(String program){
        this.program = program;
        try {
            process = Runtime.getRuntime().exec(program);
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
