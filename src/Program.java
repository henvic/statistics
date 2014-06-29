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
        double[] temp = poissonLogic.d(new double[] {1, 2, 5, 4, 1}, 1);

        for (double x : temp) {
            System.out.println(x + " ");
        }

        System.out.println("");
        System.out.println("Get Poisson Distribution:");
        for (double x : poissonLogic.p(new double[] {1, 2, 5, 4, 1}, 1)) {
            System.out.println(x + " ");
        }

        System.out.println("");

        System.out.println("Get Poisson Quantile:");

        poissonLogic.q(temp, 1);

        System.out.println("");

        System.out.println("Get Poisson Random:");
        poissonLogic.r(10, 3);
    }

    public void binomial() {
        System.out.println("Get Poisson Density:");
        double[] temp = binomialLogic.d(new int[] {1, 2, 5, 4, 1}, 1, 0.5);

        for (double x : temp) {
            System.out.println(x + " ");
        }

        System.out.println("");
        System.out.println("Get Poisson Distribution:");
        for (double x : binomialLogic.p(new int[] {1, 2, 5, 4, 1}, 1, 0.5)) {
            System.out.println(x + " ");
        }

        System.out.println("");

        System.out.println("Get Poisson Quantile:");

        int[] temp2 = new int[temp.length];

        for (int counter = 0, length = temp.length; counter < length; counter += 1) {
            temp2[counter] = (int) temp[counter];
        }

        binomialLogic.q(temp2, 1, 0.6);

        System.out.println("");

        System.out.println("Get Poisson Random:");
        binomialLogic.r(10, 3, 0.5);
    }

    public void run() {
        poisson();
        binomial();
    }
}
