import java.util.Scanner;

class Main{
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        Bibliothek bibliothek = new Bibliothek();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Bibliothek Hauptmenü ---");
            System.out.println("1. Buch hinzufügen");
            System.out.println("2. Bücher eines Autors suchen");
            System.out.println("3. Programm beenden");
            System.out.print("Bitte wählen Sie eine Option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    add_book(bibliothek);
                    break;
                case "2":
                    books_by_author(bibliothek);
                    break;
                case "3":
                    running = false;
                    System.out.println("Programm wird beendet.");
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
            }
        }
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
