public class Book {
    private final String title;
    private final String author;
    private final int price;
    private final int pages;

    public Book(String title, String author, int price, int pages) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }
}
