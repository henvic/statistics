import graphics.DefaultTheme;
import rcaller.RCaller;

public class Main {
    public static void main(String[] args) {
        RCaller caller = new RCaller();

        caller.setRscriptExecutable("/usr/bin/Rscript");
        caller.setRExecutable("/usr/bin/R");
        caller.setGraphicsTheme(new DefaultTheme());

        new Program(caller).run();
    }
}
