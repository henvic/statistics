import rcaller.RCaller;
import rcaller.RCode;

import java.io.File;
import java.io.IOException;

public class PascalLogic {
    RCaller caller;

    public PascalLogic(RCaller caller) {
        this.caller = caller;
    }

    public String d(int[] quantilis, int trails, double successProbability) {
        RCode code = new RCode();

        double[] res2;

        code.addIntArray("quantilis", quantilis);
        code.addIntArray("trails", new int[] {trails});
        code.addDoubleArray("successProbability", new double[] {successProbability});
        code.addRCode("res <- dnbinom(quantilis, trails, successProbability)");

        caller.setRCode(code);
        caller.runAndReturnResult("res");
        res2 = caller.getParser().getAsDoubleArray("res");

        try {
            File file = code.startPlot();

            code.addDoubleArray("res2", res2);
            code.addRCode("barplot(res2)");
            code.endPlot();

            caller.setRCode(code);
            caller.runAndReturnResultOnline("barplot(res2)");

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
