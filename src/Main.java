import java.util.Scanner;

class Main{
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        Bibliothek bibliothek = new Bibliothek();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Bibliothek Hauptmenü ---");
            System.out.println("1. Programm beenden");
            System.out.println("2. Buch hinzufügen");
            System.out.println("3. Bibliothek initialisieren");
            System.out.println("4. Bücher eines Autors suchen");
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
                case "4":
                    books_by_author(bibliothek);
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
        int price = scanner.nextInt();
        System.out.println("Anzahl der Seiten: ");
        int pages = scanner.nextInt();
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
}
