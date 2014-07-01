public class Binomial implements Distribution {
    public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public void setN(int[] n) {
		this.n = n;
	}

	public void setK(int k) {
		this.k = k;
	}

	public void setP(double p) {
		this.p = p;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int[] n;
    private int k;
    private double p;
    private int r;
    private int id;

    public Binomial(int[] n, int k, double p, int id, int r) {
        this.n = n;
        this.k = k;
        this.p = p;
        this.id = id;
        this.r = r;
    }

    public int[] getN() {
        return n;
    }

    public int getK() {
        return k;
    }

    public double getP() {
        return p;
    }

    public int getId() {
        return id;
    }
}
