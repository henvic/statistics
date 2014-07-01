import java.util.ArrayList;

public class RepoOfPoisson {

    private ArrayList<Poisson> objects = new ArrayList<Poisson>();

    public void add(Poisson o) {

        objects.add(o);
    }

    public Poisson search(int id) throws Exception {
        for(Poisson o : objects) {
            if (o.getId() == id) {
                return o;
            }
        }

        throw new Exception("Id not found.");
    }
}
