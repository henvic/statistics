import rcaller.RCaller;
import rcaller.RCode;

import java.io.File;
import java.io.IOException;

public class PoissonLogic {
    RCaller caller;

    public PoissonLogic(RCaller caller) {
        this.caller = caller;
    }

    public double[] d(double[] quantilis, double lambda) {
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
            code.addStringArray("lambdaS", new String[] {"Probabilidade (para lambda = " + lambda + ")" });
            code.addRCode("barplot(res2, main=\"Density Poisson\", xlab=\"Variavel P(X = x)\", border=\"black\", ylab=lambdaS, ylim=c(0,1.0), font.lab=2, names.arg=str, col=rainbow(length(str)))");
            code.addRCode("abline(h=res)");
            code.endPlot();

            caller.setRCode(code);
            caller.runOnly();
//            caller.runAndReturnResultOnline("barplot(res2)");

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

    public double[] p(double[] quantilis, double lambda) {
        RCode code = new RCode();

        double[] res2;
        String[] str = new String[quantilis.length];

        code.addDoubleArray("quantilis", quantilis);
        code.addDoubleArray("lambda", new double[] {lambda});
        code.addRCode("res <- ppois(quantilis, lambda)");

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
            code.addStringArray("lambdaS", new String[] {"Probabilidade (para lambda = " + lambda + ")" });
            code.addRCode("barplot(res2, main=\"Distribution Function - Poisson\", xlab=\"Variavel P(X <= x)\", border=\"black\", ylab=lambdaS, ylim=c(0,1.0), font.lab=2, names.arg=str, col=rainbow(length(str)))");
            code.addRCode("abline(h=res)");
            code.endPlot();

            caller.setRCode(code);
//            caller.runOnly();
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


    public String[] q(double[] probabilities, double lambda) {
        RCode code = new RCode();
        String[] resS;
        String[] str = new String[probabilities.length];
        double[] res2;

        code.addDoubleArray("lambda", new double[] {lambda});
        code.addDoubleArray("probabilities", probabilities);
        code.addRCode("res <- qpois(probabilities, lambda)");

        caller.setRCode(code);
        caller.runAndReturnResult("res");

        resS = caller.getParser().getAsStringArray("res");
        res2 = new double[resS.length];

        int counter = 0;
        for (double x : probabilities) {
            int cut = (x+"").length();

            if (cut > 6) {
                cut = 6;
            }

            str[counter] = x + "";
            str[counter] = str[counter].substring(0, cut);
            counter += 1;
        }

        counter = 0;
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
//                code.addRCode("barplot(res2)");
                code.addStringArray("str", str);
                code.addStringArray("lambdaS", new String[] {"Probabilidade (para lambda = " + lambda + ")" });
                code.addRCode("barplot(res2, main=\"Quantile Function - Poisson\", xlab=\"Variavel aleatoria\", border=\"black\", ylab=lambdaS, font.lab=2, names.arg=str, col=rainbow(length(str)))");
                code.addRCode("abline(h=res2)");
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

    public double[] r(int amount, double lambda) {
        double[] res2;
        String[] str = new String[amount];
        RCode code = new RCode();

        code.addDoubleArray("lambda", new double[] {lambda});
        code.addIntArray("amount", new int[] {amount});
        code.addRCode("res <- rpois(amount, lambda)");

        caller.setRCode(code);
        caller.runAndReturnResult("res");
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
            code.addStringArray("lambdaS", new String[] {"Os numeros variam proximo de " + lambda + "" });
            code.addRCode("barplot(res2, main=\"Random numbers - Poisson\", xlab=\"Numeros aleatorios\", border=\"black\", ylab=lambdaS, font.lab=2, names.arg=str, col=rainbow(length(str)))");
            code.addRCode("abline(h=res2)");
            code.endPlot();

            caller.setRCode(code);
            caller.runOnly();

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
