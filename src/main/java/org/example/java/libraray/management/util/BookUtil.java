package org.example.java.libraray.management.util;

import org.example.java.libraray.management.model.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static Map<Long, Book> defaultSeedBookMap() {
        Map<Long, Book> books = new HashMap<>();

        Book b1 = new Book();
        b1.setId(1L);
        b1.setTitle("Harry Potter and the Sorcerer's Stone");
        b1.setAuthor("J.K. Rowling");
        b1.setGenres("Fantasy, Adventure");

        Book b2 = new Book();
        b2.setId(2L);
        b2.setTitle("A Game of Thrones");
        b2.setAuthor("George R.R. Martin");
        b2.setGenres("Fantasy, Adventure");

        Book b3 = new Book();
        b3.setId(3L);
        b3.setTitle("Murder on the Orient Express");
        b3.setAuthor("Agatha Christie");
        b3.setGenres("Mystery");

        Book b4 = new Book();
        b4.setId(4L);
        b4.setTitle("The Shining");
        b4.setAuthor("Stephen King");
        b4.setGenres("Horror");

        Book b5 = new Book();
        b5.setId(5L);
        b5.setTitle("The Hobbit");
        b5.setAuthor("J.R.R. Tolkien");
        b5.setGenres("Fantasy, Adventure");

        books.put(b1.getId(), b1);
        books.put(b2.getId(), b2);
        books.put(b3.getId(), b3);
        books.put(b4.getId(), b4);
        books.put(b5.getId(), b5);

        return books;
    }

    public static Book inputBookAddDetails() {
        Book book = new Book();

        System.out.print("Enter Book ID: ");
        book.setId(Long.parseLong(scanner.nextLine()));

        System.out.print("Enter Book Title: ");
        book.setTitle(scanner.nextLine());

        System.out.print("Enter Author Name: ");
        book.setAuthor(scanner.nextLine());

        System.out.print("Enter Genres (comma separated): ");
        book.setGenres(scanner.nextLine());

        return book;
    }

    public static Book inputBookUpdateDetails(Book existingBook) {
        if (existingBook == null) {
            System.out.println("❌ No book found to update.");
            return null;
        }

        Book updatedBook = new Book();
        updatedBook.setId(existingBook.getId());

        System.out.print("Enter Book Title [" + existingBook.getTitle() + "]: ");
        String titleInput = scanner.nextLine();
        updatedBook.setTitle(titleInput.isBlank() ? existingBook.getTitle() : titleInput);

        System.out.print("Enter Author Name [" + existingBook.getAuthor() + "]: ");
        String authorInput = scanner.nextLine();
        updatedBook.setAuthor(authorInput.isBlank() ? existingBook.getAuthor() : authorInput);

        System.out.print("Enter Genres (comma separated) [" + existingBook.getGenres() + "]: ");
        String genresInput = scanner.nextLine();
        updatedBook.setGenres(genresInput.isBlank() ? existingBook.getGenres() : genresInput);

        return updatedBook;
    }
}
