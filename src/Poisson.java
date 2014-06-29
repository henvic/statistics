public class Poisson implements Distribution {
    private int id;
    private double lambda;
    private int[] vector;
    private double[] distribution;
    private double[] variance;

    public Poisson(int id, double lambda, int[] vector, double[] distribution, double[] variance) {
        this.id = id;
        this.lambda = lambda;
        this.vector = vector;
        this.distribution = distribution;
        this.variance = variance;
    }

    public int getId() {
        return id;
    }
}
