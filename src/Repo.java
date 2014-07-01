import java.util.ArrayList;

public class Repo {

    private ArrayList<Distribution> objects = new ArrayList<Distribution>();

    public void add(Distribution o) {
        objects.add(o);
    }

    public Object get(int id) throws Exception {
        for(Distribution o : objects) {
            if (o.getId() == id) {
                return o;
            }
        }

        throw new Exception("Id not found.");
    }
}
