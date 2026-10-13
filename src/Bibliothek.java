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

    public float avg_pages(List<Buch> book_list){
        int s = 0;
        for(Buch b: book_list){
            s+=b.getPages();
        }
        float rawAverage = (float) s /book_list.size();
        return Math.round(rawAverage * 100.0f) / 100.0f;
    }

    public Buch find_by_title(String title){
        for(Buch b: books){
            if(b.getTitle().equals(title)){
                return b;
            }
        }
        return null;
    }
}
