public class BudgetResult {
    private final Book book1;
    private final Book book2;
    public BudgetResult(Book book1, Book book2) {
        this.book1 = book1;
        this.book2 = book2;
    }

    public Book getBook1() {
        return book1;
    }

    public Book getBook2() {
        return book2;
    }

    public int getCombinedPrice() {
        return book1.getPrice() + book2.getPrice();
    }
}
