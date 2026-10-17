import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main{
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        Library library = new Library();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Bibliothek Hauptmenü ---");
            System.out.println("1. Programm beenden");
            System.out.println("2. Buch hinzufügen");
            System.out.println("3. Bibliothek initialisieren");
            System.out.println("4. Bucher eines Autors suchen");
            System.out.println("5. Durchschnittliche Seitenanzahl");
            System.out.println("6. Bucher innerhalb eines Preislimits");
            System.out.println("7. Teuerste Buch");
            System.out.println("8. Bucher mit einer Mindestanzahl");
            System.out.println("9. Zwei Bucher innerhalb einer Budgets");
            System.out.print("Bitte wählen Sie eine Option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    running = false;
                    System.out.println("Programm wird beendet.");
                    break;
                case "2":
                    addBook(library);
                    break;
                case "3":
                    initialiseLibrary(library);
                    break;
                case "4":
                    booksByAuthor(library);
                    break;
                case "5":
                    System.out.println(avgPages(library));
                    break;
                case "6":
                    booksCheaperThan(library);
                    break;
                case "7":
                    mostExpensiveBook(library);
                    break;
                case "8":
                    pagesMoreThan(library);
                    break;
                case "9":
                    booksWithinBudget(library);
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
            }
        }
    }

    public static void initialiseLibrary(Library library){
        library.add(new Book("Clean Code", "Robert Martin", 45, 464));
        library.add(new Book("1984", "George Orwell", 18, 328));
        library.add(new Book("Animal Farm", "George Orwell", 12, 112));
        library.add(new Book("Java Basics", "Max Muller", 35, 520));
        library.add(new Book("The Hobbit", "J. R. R. Tolkien", 28, 310));
    }

    public static void addBook(Library library){
        System.out.println("Titel: ");
        String title = scanner.nextLine();
        System.out.println("Autor: ");
        String author = scanner.nextLine();
        System.out.println("Preis: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Anzahl der Seiten: ");
        int pages = Integer.parseInt(scanner.nextLine());
        Book b = new Book(title, author, price, pages);
        library.add(b);
    }

    public static void booksByAuthor(Library library){
        System.out.print("Autor: ");
        String author = scanner.nextLine();
        for (Book b: library.filterAuthor(author)){
            System.out.println(b.getTitle());
        }
    }

    public static float avgPages(Library library){
        System.out.print("Anzahl Bucher:");
        int no_books=Integer.parseInt(scanner.nextLine());
        List<Book> books = new ArrayList<>();
        for (int i=0; i< no_books; i++){
            System.out.print("Buch Titel: ");
            String title = scanner.nextLine();
            if(library.findByTitle(title)==null){
                System.out.println("Buch nicht in Bibliothek");
                i--;
            }else{
                books.add(library.findByTitle(title));
            }
        }
        return library.avgPages(books);
    }

    public static void booksCheaperThan(Library library){
        System.out.print("Maximaler Preis: ");
        int price=Integer.parseInt(scanner.nextLine());
        List<Book> books_cheaper = library.booksCheaper(price);
        for(Book book: books_cheaper){
            System.out.println(book.getTitle());
        }
    }

    public static void mostExpensiveBook(Library library){
        System.out.print("Anzahl Bucher: ");
        int no_books=Integer.parseInt(scanner.nextLine());
        List<Book> books = new ArrayList<>();
        for (int i=0; i< no_books; i++){
            System.out.print("Buch Titel: ");
            String title = scanner.nextLine();
            if(library.findByTitle(title)==null){
                System.out.println("Buch nicht in Bibliothek");
                i--;
            }else{
                books.add(library.findByTitle(title));
            }
        }
        if(!books.isEmpty()){
            Book book = library.mostExpensiveBook(books);
            System.out.printf("%s (%d Euro)%n", book.getTitle(), book.getPrice());
        }else{
            System.out.println("NULL");
        }
    }
    public static void pagesMoreThan(Library library){
        System.out.print("Mindestanzahl: ");
        int pages=Integer.parseInt(scanner.nextLine());
        List<Book> books = library.pagesMoreThan(pages);
        for(Book book: books){
            System.out.println(book.getTitle());
        }
    }
    public static void booksWithinBudget(Library library){
        System.out.print("Budget: ");
        int price=Integer.parseInt(scanner.nextLine());
        BudgetResult result = library.booksWithinBudget(price);
        if (result == null){
            System.out.println("Keine Bucher wurden in den Budget gefunden");
        }else{
            System.out.printf("%s + %s\nGesamtpreis: %d Euro\n",
                    result.getBook1().getTitle(),
                    result.getBook2().getTitle(),
                    result.getCombinedPrice());
        }
    }
}
