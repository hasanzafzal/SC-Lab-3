import java.util.ArrayList;

class Book
{
    String title;
    String author;
    boolean available;

    Book(String title, String author)
    {
        this.title = title;
        this.author = author;
        this.available = true;
    }
}

public class LibraryManagementSystem
{
    private ArrayList<Book> books;

    public LibraryManagementSystem()
    {
        books = new ArrayList<>();
        books.add(new Book("Harry Potter and half-blood prince", "J.K Rowling"));
        books.add(new Book("Diary of a Wimpy Kid", "Jeff Kinney"));
        books.add(new Book("Fifty Shades of Grey", "E.L James"));
    }

    public void showAvailableBooks()
    {
        System.out.println("Available Books:");
        for (Book b : books)
        {
            if (b.available)
            {
                System.out.println(b.title + " by " + b.author);
            }
        }
    }

    public void issueBook(String title)
    {
        for (Book b : books)
        {
            if (b.title.equalsIgnoreCase(title) && b.available)
            {
                b.available = false;
                System.out.println("Issued: " + b.title);
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(String title)
    {
        for (Book b : books)
        {
            if (b.title.equalsIgnoreCase(title) && !b.available)
            {
                b.available = true;
                System.out.println("Returned: " + b.title);
                return;
            }
        }
        System.out.println("Book not found in borrowed list.");
    }

    public void showAllBooks()
    {
        System.out.println("All Books in Library:");
        for (Book b : books)
        {
            String status = b.available ? "Available" : "Borrowed";
            System.out.println(b.title + " by " + b.author + " - " + status);
        }
    }

    public static void main(String[] args)
    {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.showAvailableBooks();
        library.issueBook("Fifty Shades of Grey");
        library.showAllBooks();
        library.returnBook("Fifty Shades of Grey");
        library.showAvailableBooks();
    }
}