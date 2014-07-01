import rcaller.RCaller;
import rcaller.RCode;

import java.io.File;
import java.io.IOException;

public class PoissonLogic {
    RCaller caller;

    public PoissonLogic(RCaller caller) {
        this.caller = caller;
    }

    public String d(double[] quantilis, double lambda) {
        RCode code = new RCode();

        double[] res2;
        String[] str = new String[quantilis.length];

        code.addDoubleArray("quantilis", quantilis);
        code.addDoubleArray("lambda", new double[] {lambda});
        code.addRCode("res <- dpois(quantilis, lambda)");

        caller.setRCode(code);
        caller.runAndReturnResult("res");
        res2 = caller.getParser().getAsDoubleArray("res");

        int counter = 0;
        for (double x : quantilis){
            str[counter] = x + "";
            counter += 1;
        }

        try {
            File file = code.startPlot();

            code.addDoubleArray("res2", res2);
            code.addStringArray("str", str);
            code.addStringArray("lambdaS", new String[] {"Probabilidade P(X = x)(para lambda = " + lambda + ")" });
            code.addRCode("barplot(res2, main=\"Density Poisson\", xlab=\"Variavel (x)\", border=\"black\", ylab=lambdaS, ylim=c(0,1.0), font.lab=2, names.arg=str, col=rainbow(length(str)))");
            code.addRCode("abline(h=res)");
            code.endPlot();

            caller.setRCode(code);
            caller.runOnly();
            code.showPlot(file);
        } catch (IOException ignore) {
            System.out.println("ignore!");
        }

        String end = "";

        for (double e : res2) {
            end += e + " ";
        }

        return end;
    }
}
