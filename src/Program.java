import rcaller.RCaller;

public class Program {
    RCaller caller;
    PoissonLogic poissonLogic;
    BinomialLogic binomialLogic;

    public Program(RCaller caller) {
        this.caller = caller;
        this.poissonLogic = new PoissonLogic(caller);
        this.binomialLogic = new BinomialLogic(caller);
    }

    public void poisson() {
        System.out.println("Get Poisson Density:");

        for (double x : poissonLogic.d(new double[] {1, 2, 5, 4, 1}, 1)) {
            System.out.println(x + " ");
        }

        System.out.println("");
        System.out.println("Get Poisson Distribution:");
        double[] temp = poissonLogic.p(new double[] {0, 1, 2, 5, 4, 1, 12, 15, 20}, 2);

        for (double x : temp) {
            System.out.println(x + " ");
        }

        System.out.println("");

        System.out.println("Get Poisson Quantile:");

        poissonLogic.q(new double[] {0.7, 1}, 200);

        System.out.println("");

        System.out.println("Get Poisson Random:");
        poissonLogic.r(10, 3);
    }

    public void binomial() {
//        System.out.println("Get Binomial Density:");

//
//        for (double x : binomialLogic.d(new int[] {1, 2, 20, 4, 1}, 4, 0.5)) {
//            System.out.println(x + " ");
//        }
//
//        System.out.println("");
//        System.out.println("Get Binomial Distribution:");
        double[] temp = binomialLogic.p(new int[] {1, 2, 5, 4, 1}, 1, 0.5);
//        for (double x : temp) {
//            System.out.println(x + " ");
//        }

        System.out.println("");

        System.out.println("Get Binomial Quantile:");

        int[] temp2 = new int[temp.length];

        for (int counter = 0, length = temp.length; counter < length; counter += 1) {
            temp2[counter] = (int) temp[counter];
        }

        binomialLogic.q(temp2, 1, 0.6);
//
//        System.out.println("");
//
//        System.out.println("Get Binomial Random:");
//        binomialLogic.r(10, 3, 0.5);
    }

    public void run() {
        poisson();
        binomial();
    }
}
