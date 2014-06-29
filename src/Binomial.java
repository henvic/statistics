public class Binomial implements Distribution {
    private int n;
    private int k;
    private int p;
    private int id;

    public Binomial(int n, int k, int p, int id) {
        this.n = n;
        this.k = k;
        this.p = p;
        this.id = id;
    }

    public int getN() {
        return n;
    }

    public int getK() {
        return k;
    }

    public int getP() {
        return p;
    }

    public int getId() {
        return id;
    }
}
