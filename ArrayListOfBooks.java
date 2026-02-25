import java.util.ArrayList;

public class ArrayListOfBooks {

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();

        try {

            Book b1 = new Book(
                    "Icon",
                    499.00,
                    "UKS990820",
                    "Fiction",
                    "Frederick Forsyth"
            );
            books.add(b1);

            Book b2 = new Book(
                    "The Alchemist",
                    299.00,
                    "ISBN12345",
                    "Fiction",
                    "Paulo Coelho"
            );
            books.add(b2);

            // Default constructor
            Book b3 = new Book();
            books.add(b3);

            // Copy constructor
            Book b4 = new Book(b1);
            books.add(b4);

            // Trying to create book with NEGATIVE price
            Book b5 = new Book(
                    "Invalid Book",
                    -200,
                    "ISBN000",
                    "Fiction",
                    "Unknown"
            );
            books.add(b5);

        } catch (InvalidPriceException e) {
            System.out.println("Invalid price exception caught: " + e.getMessage());
        } catch (InvalidGenreException e) {
            System.out.println("Invalid genre exception caught: " + e.getMessage());
        }

        // Display all books
        System.out.println("\nBook List:");
        for (Book b : books) {
            b.display();
        }

        // Calculate average price
        double total = 0;
        for (Book b : books) {
            total += b.price;
        }

        double average = total / books.size();
        System.out.println("\nAverage price of books: " + average);

        // Print Fiction books using forEach()
        System.out.println("\nFiction Books:");
        books.forEach(b -> {
            if (b.genre.equals("Fiction")) {
                b.display();
            }
        });
    }
}