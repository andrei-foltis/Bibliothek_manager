import java.util.ArrayList;
import java.util.List;

public class Bibliothek {
    private List<Buch> books = new ArrayList<>();

    public Bibliothek() {}

    public void add(Buch b){
        books.add(b);
    }

    public List<Buch> filter_author(String a){
        List<Buch> filtered_books = new ArrayList<>();
        for (Buch b: books){
            if (b.getAuthor().equals(a)){
                filtered_books.add(b);
            }
        }
        return filtered_books;
    }
}
