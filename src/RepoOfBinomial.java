import java.util.ArrayList;

public class RepoOfBinomial {

    private ArrayList<Binomial> objects = new ArrayList<Binomial>();

    public void add(Binomial o) {

        objects.add(o);
    }

    public Binomial search(int id) throws Exception {
        for(Binomial o : objects) {
            if (o.getId() == id) {
                return o;
            }
        }

        throw new Exception("Id not found.");
    }
}
