import java.util.ArrayList;
import java.util.List;

public class Bibliothek {
    private List<Buch> books = new ArrayList<>();

    public Bibliothek() {}

    public void add(Buch b){
        books.add(b);
    }
}
