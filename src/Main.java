import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main{
    private static final Scanner scanner = new Scanner(System.in);
    static void main(String[] args){
        Bibliothek bibliothek = new Bibliothek();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Bibliothek Hauptmenü ---");
            System.out.println("1. Programm beenden");
            System.out.println("2. Buch hinzufügen");
            System.out.println("3. Bibliothek initialisieren");
            System.out.println("4. Bücher eines Autors suchen");
            System.out.println("5. Durchschnittliche Seitenanzahl");
            System.out.println("6. Bucher innerhalb eines Preislimits");
            System.out.println("7. Teuerste Buch");
            System.out.print("Bitte wählen Sie eine Option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    running = false;
                    System.out.println("Programm wird beendet.");
                    break;
                case "2":
                    add_book(bibliothek);
                    break;
                case "3":
                    initialise_library(bibliothek);
                    break;
                case "4":
                    books_by_author(bibliothek);
                    break;
                case "5":
                    System.out.println(avg_pages(bibliothek));
                    break;
                case "6":
                    books_cheaper_than(bibliothek);
                    break;
                case "7":
                    most_expensive_book(bibliothek);
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
            }
        }
    }

    public static void initialise_library(Bibliothek bibliothek){
        bibliothek.add(new Buch("Clean Code", "Robert Martin", 45, 464));
        bibliothek.add(new Buch("1984", "George Orwell", 18, 328));
        bibliothek.add(new Buch("Animal Farm", "George Orwell", 12, 112));
        bibliothek.add(new Buch("Java Basics", "Max Muller", 35, 520));
        bibliothek.add(new Buch("The Hobbit", "J. R. R. Tolkien", 28, 310));
    }

    public static void add_book(Bibliothek bibliothek){
        System.out.println("Titel: ");
        String title = scanner.nextLine();
        System.out.println("Autor: ");
        String author = scanner.nextLine();
        System.out.println("Preis: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Anzahl der Seiten: ");
        int pages = Integer.parseInt(scanner.nextLine());
        Buch b = new Buch(title, author, price, pages);
        bibliothek.add(b);
    }

    public static void books_by_author(Bibliothek bibliothek){
        System.out.println("Autor: ");
        String author = scanner.nextLine();
        for (Buch b:bibliothek.filter_author(author)){
            System.out.println(b.getTitle());
        }
    }

    public static float avg_pages(Bibliothek bibliothek){
        System.out.println("Anzahl Bucher:");
        int no_books=Integer.parseInt(scanner.nextLine());
        List<Buch> books = new ArrayList<>();
        for (int i=0; i< no_books; i++){
            System.out.println("Buch Titel: ");
            String title = scanner.nextLine();
            if(bibliothek.find_by_title(title)==null){
                System.out.println("Buch nicht in Bibliothek");
                i--;
            }else{
                books.add(bibliothek.find_by_title(title));
            }
        }
        return bibliothek.avg_pages(books);
    }

    public static void books_cheaper_than(Bibliothek bibliothek){
        System.out.println("Maximaler Preis: ");
        int price=Integer.parseInt(scanner.nextLine());
        List<Buch> books_cheaper = bibliothek.books_cheaper(price);
        for(Buch b: books_cheaper){
            System.out.println(b.getTitle());
        }
    }

    public static void most_expensive_book(Bibliothek bibliothek){
        System.out.println("Anzahl Bucher: ");
        int no_books=Integer.parseInt(scanner.nextLine());
        List<Buch> books = new ArrayList<>();
        for (int i=0; i< no_books; i++){
            System.out.println("Buch Titel: ");
            String title = scanner.nextLine();
            if(bibliothek.find_by_title(title)==null){
                System.out.println("Buch nicht in Bibliothek");
            }else{
                books.add(bibliothek.find_by_title(title));
            }
        }
        if(!books.isEmpty()){
            Buch b = bibliothek.most_expensive_book(books);
            System.out.printf("%s (%d Euro)%n", b.getTitle(), b.getPrice());
        }else{
            System.out.println("NULL");
        }
    }
}
