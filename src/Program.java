import rcaller.RCaller;

public class Program {
    RCaller caller;
    PoissonLogic poissonLogic;
    BinomialLogic binomialLogic;
    PascalLogic pascalLogic;

    public Program(RCaller caller) {
        this.caller = caller;
        this.poissonLogic = new PoissonLogic(caller);
        this.binomialLogic = new BinomialLogic(caller);
    }

    public void poisson() {
        System.out.println("Get Poisson Density:");

        double[] p = poissonLogic.d(new double[] {1, 2, 5, 4, 1}, 1);

        for (double x : p) {
            System.out.println(x + " ");
        }
    }

    public void binomial() {
        double[] p = binomialLogic.d(new int[] {1, 2, 20, 4, 1}, 4, 0.5);
        System.out.println("Get Binomial Density:");

        for (double x : p) {
            System.out.println(x + " ");
        }
    }

    public void negativeBinomial() {
        double[] p = pascalLogic.d(new int[] {1, 2, 20, 4, 1}, 4, 0.5);
        System.out.println("Get Binomial Density:");

        for (double x : p) {
            System.out.println(x + " ");
        }
    }

    public void run() {
        poisson();
        binomial();
        negativeBinomial();
    }
}
