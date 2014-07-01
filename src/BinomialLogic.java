import rcaller.RCaller;
import rcaller.RCode;

import java.io.File;
import java.io.IOException;

public class BinomialLogic {
    RCaller caller;

    public BinomialLogic(RCaller caller) {
        this.caller = caller;
    }

    public double[] d(int[] quantilis, int trails, double successProbability) {
        RCode code = new RCode();

        double[] res2;

        code.addIntArray("quantilis", quantilis);
        code.addIntArray("trails", new int[] {trails});
        code.addDoubleArray("successProbability", new double[] {successProbability});
        code.addRCode("res <- dbinom(quantilis, trails, successProbability)");

        caller.setRCode(code);
        caller.runAndReturnResult("res");
        res2 = caller.getParser().getAsDoubleArray("res");

        try {
            File file = code.startPlot();

            code.addDoubleArray("res2", res2);
            code.addStringArray("ylabS", new String[] {"Probabilidade P(X = x) (Para chance de sucesso = " + successProbability + ")"});
            code.addRCode("barplot(res2, names.arg=quantilis, ylab=ylabS, xlab=\"Variavel (x)\", font.lab=2, col=rainbow(length(quantilis)), ylim=c(0, 1.0))");
            code.endPlot();

            caller.setRCode(code);
            caller.runAndReturnResultOnline("barplot(res2)");

            code.showPlot(file);
        } catch (IOException ignore) {
            System.out.println("ignore!");
        }

        return res2;
    }
}
