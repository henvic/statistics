public class Poisson implements Distribution {
    private int id;
    private double lambda;
    private double[] vector;
    private int r;
   

    public Poisson(int id, double lambda, double[] vector, int r) {
        this.id = id;
        this.lambda = lambda;
        this.vector = vector;
        this.r = r;

    }

    public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getId() {
        return id;
    }

	public double getLambda() {
		return lambda;
	}

	public void setLambda(double lambda) {
		this.lambda = lambda;
	}

	public double[] getVector() {
		return vector;
	}

	public void setVector(double[] vector) {
		this.vector = vector;
	}

	public void setId(int id) {
		this.id = id;
	}
    
}
