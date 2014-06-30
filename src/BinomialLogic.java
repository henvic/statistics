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

    public double[] p(int[] quantilis, int trails, double probabilitySuccess) {
        RCode code = new RCode();

        double[] res2;

        code.addIntArray("quantilis", quantilis);
        code.addIntArray("trails", new int[] {trails});
        code.addDoubleArray("probabilitySuccess", new double[] {probabilitySuccess});
        code.addRCode("res <- pbinom(quantilis, trails, probabilitySuccess)");

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

//            for (double each : res2) {
//                System.out.println(each);
//            }
//
            code.showPlot(file);
        } catch (IOException ignore) {
            System.out.println("ignore!");
        }

        return res2;
    }


    public String[] q(int[] quantilis, int trails, double probabilitySuccess) {
        RCode code = new RCode();
        String[] resS;
        double[] res2;

        code.clear();
        caller.cleanRCode();

        code.addIntArray("quantilis", quantilis);
        code.addIntArray("trails", new int[] {trails});
        code.addDoubleArray("probabilitySuccess", new double[] {probabilitySuccess});
        code.addRCode("res <- qbinom(quantilis, trails, probabilities)");

        caller.setRCode(code);
        caller.runAndReturnResultOnline("res");

        resS = caller.getParser().getAsStringArray("res");
        res2 = new double[resS.length];


        int counter = 0;
        for (String x : resS) {
            System.out.print(x + " ");

            if (x.equals("Inf")) {
                res2[counter] = 100;
            }
            else if (x.equals("NaN")){
//                dont = true;
            } else {
                res2[counter] = Double.parseDouble(x);
            }
            counter += 1;
        }
            try {
                File file = code.startPlot();


                code.addDoubleArray("res2", res2);
                code.addRCode("barplot(res2)");
                code.endPlot();

                caller.setRCode(code);
                caller.runAndReturnResultOnline("barplot(res2)");

//            for (double each : res2) {
//                System.out.println(each);
//            }
//
                code.showPlot(file);
            } catch (IOException ignore) {
                System.out.println("ignore!");
            }

        return resS;

    }

    public double[] r(int observations, int trails, double probabilitySuccess) {
        double[] res2;
        String[] str = new String[observations];
        RCode code = new RCode();

        code.addIntArray("observations", new int[] {observations});
        code.addIntArray("trails", new int[] {trails});
        code.addDoubleArray("probabilitySuccess", new double[] {probabilitySuccess});
        code.addRCode("res <- rbinom(observations, trails, probabilities)");

        caller.setRCode(code);
        caller.runAndReturnResultOnline("res");
        res2 = caller.getParser().getAsDoubleArray("res");

        int counter = 0;
        for (double each : res2){
            str[counter] = each + "";
            counter += 1;
        }

        try {
            File file = code.startPlot();

            code.addDoubleArray("res2", res2);
            code.addStringArray("str", str);
            code.addStringArray("lambdaS", new String[] {"Os numeros variam proximo de " + probabilitySuccess + "" });
            code.addRCode("barplot(res2, xlab=\"Numeros aleatorios\", border=\"black\", ylab=lambdaS, font.lab=2, names.arg=str, col=rainbow(length(str))))");
            code.addRCode("abline(h=res2)");
            code.endPlot();

            caller.setRCode(code);
            caller.runAndReturnResultOnline("barplot(res2)");

            for (double each : res2) {
                System.out.println(each);
            }

            code.showPlot(file);
        } catch (IOException ignore) {
            System.out.println("ignore!");
        }

        return res2;
    }
}
