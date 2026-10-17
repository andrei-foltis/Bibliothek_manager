import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public Library() {}

    public void add(Book b){
        books.add(b);
    }

    public List<Book> filterAuthor(String a){
        List<Book> filtered_books = new ArrayList<>();
        for (Book b: books){
            if (b.getAuthor().equals(a)){
                filtered_books.add(b);
            }
        }
        return filtered_books;
    }

    public float avgPages(List<Book> book_list){
        int s = 0;
        for(Book b: book_list){
            s+=b.getPages();
        }
        float rawAverage = (float) s /book_list.size();
        return Math.round(rawAverage * 100.0f) / 100.0f;
    }

    public Book findByTitle(String title){
        for(Book b: books){
            if(b.getTitle().equals(title)){
                return b;
            }
        }
        return null;
    }

    public List<Book> booksCheaper(int price) {
        List<Book> books_filtered = new ArrayList<>();
        for(Book b: books){
            if (b.getPrice()<=price){
                books_filtered.add(b);
            }
        }
        return books_filtered;
    }

    public Book mostExpensiveBook(List<Book> books) {
        if (books == null || books.isEmpty()) {
            return null;
        }
        Book book_expensive = books.getFirst();
        for(Book b: books){
            if(b.getPrice()>book_expensive.getPrice()){
                book_expensive = b;
            }
        }
        return book_expensive;
    }

    public List<Book> pagesMoreThan(int pages) {
        List<Book> books_filtered = new ArrayList<>();
        for(Book b: books){
            if(b.getPages()>=pages){
                books_filtered.add(b);
            }
        }
        return books_filtered;
    }

    public BudgetResult booksWithinBudget(int price) {
        Book bestB1 = null;
        Book bestB2 = null;
        int maxPrice = -1;
        int maxPages = -1;
        for(int i = 0; i< books.size(); i++){
            Book current1 = books.get(i);
            for(int j = i+1; j<books.size(); j++){
                Book current2 = books.get(j);

                int currentPrice = current1.getPrice() + current2.getPrice();
                int currentPages = current1.getPages() + current2.getPages();

                if (currentPrice <= price) {
                    if (currentPrice > maxPrice) {
                        maxPrice = currentPrice;
                        maxPages = currentPages;
                        bestB1 = current1;
                        bestB2 = current2;
                    } else if (currentPrice == maxPrice) {
                        if (currentPages > maxPages) {
                            maxPages = currentPages;
                            bestB1 = current1;
                            bestB2 = current2;
                        }
                    }
                }
            }
        }

        if(bestB1 != null && bestB2 != null){
            return new BudgetResult(bestB1, bestB2);
        }
        return null;
    }
}