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
        this.pascalLogic = new PascalLogic(caller);
    }

    public void poisson() {
        System.out.println("Get Poisson Density:");
        System.out.println(poissonLogic.d(new double[] {1, 2, 5, 4, 1}, 1));
    }

    public void binomial() {
        System.out.println("Get Binomial Density:");
        System.out.println(binomialLogic.d(new int[] {1, 2, 20, 4, 1}, 4, 0.5));
    }

    public void pascal() {
        System.out.println("Get Pascal Density:");
        System.out.println(pascalLogic.d(new int[] {1, 5, 8}, 5, 0.5));
    }

    public void run() {
        poisson();
        binomial();
        pascal();
    }
}
