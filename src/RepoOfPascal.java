import java.util.ArrayList;

public class RepoOfPascal {

    private ArrayList<Pascal> objects = new ArrayList<Pascal>();

    public void add(Pascal o) {

        objects.add(o);
    }

    public Pascal search(int id) throws Exception {
        for(Pascal o : objects) {
            if (o.getId() == id) {
                return o;
            }
        }

        throw new Exception("Id not found.");
    }
}
