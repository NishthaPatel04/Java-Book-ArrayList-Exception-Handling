public class Book {

    public String title;
    public double price;
    public String ISBN;
    public String genre;
    public String author;

    public Book() {
        title = "Ready Player One";
        price = 458;
        ISBN = "ABR4212";
        genre = "Fiction";
        author = "Ernest Cline";
    }

    // Constructor with exception for negative price
    public Book(String title, double price, String genre)
            throws InvalidPriceException, InvalidGenreException {

        this.title = title;

        if (price < 0)
            throw new InvalidPriceException("Price cannot be negative");
        this.price = price;

        if (!genre.equals("Fiction") &&
            !genre.equals("Non-fiction") &&
            !genre.equals("Auto-biography"))
            throw new InvalidGenreException("Invalid genre");

        this.genre = genre;
    }

    public Book(String title, double price, String ISBN,
                String genre, String author)
            throws InvalidPriceException, InvalidGenreException {

        this(title, price, genre);
        this.ISBN = ISBN;
        this.author = author;
    }

    public Book(Book b) {
        this.title = b.title;
        this.price = b.price;
        this.ISBN = b.ISBN;
        this.genre = b.genre;
        this.author = b.author;
    }

    public void display() {
        System.out.println("Title: " + title +
                ", Price: " + price +
                ", ISBN: " + ISBN +
                ", Genre: " + genre +
                ", Author: " + author);
    }
}