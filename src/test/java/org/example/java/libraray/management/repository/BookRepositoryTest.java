package org.example.java.libraray.management.repository;


import org.example.java.libraray.management.exception.GlobalException;
import org.example.java.libraray.management.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookRepositoryTest {

    private BookRepository bookRepository;
    private final Long booksSeeded = 5L;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    void findById_BookPresent_ShouldReturnBook() {
        Book book = bookRepository.findById(1L);

        assertNotNull(book);
        assertEquals(1L, book.getId());
    }

    @Test
    void findById_BookNotPresent_ShouldReturnBookNotFound() {
        GlobalException ex = assertThrows(GlobalException.class, () -> bookRepository.findById(999L));
        assertEquals("Book not found with id: 999", ex.getMessage());
    }

    @Test
    void add_NoBookIdProvided_ShouldAutoIncrement() {
        Book bookToAdd = sampleBook();
        assertNull(bookToAdd.getId());

        Book addedBook = bookRepository.add(bookToAdd);
        assertEquals(booksSeeded + 1L, addedBook.getId());
    }

    @Test
    void add_BookIdProvided_ShouldAutoIncrement() {
        Book bookToAdd = sampleBook();
        bookToAdd.setId(100L);
        assertEquals(100L, bookToAdd.getId());

        Book addedBook = bookRepository.add(bookToAdd);
        assertEquals(booksSeeded + 1L, addedBook.getId());
    }

    @Test
    void update_BookPresent_ShouldUpdateBook() {
        Book bookToUpdate = bookRepository.findById(1L);
        bookToUpdate.setTitle("Updated Title");

        Book updatedBook = bookRepository.update(bookToUpdate);
        assertEquals("Updated Title", updatedBook.getTitle());
    }

    @Test
    void update_BookNotPresent_ShouldThrowException() {
        Book bookToUpdate = sampleBook();
        bookToUpdate.setId(999L);

        GlobalException ex = assertThrows(GlobalException.class, () -> bookRepository.update(bookToUpdate));
        assertEquals("Book not found with id: 999", ex.getMessage());
    }

    @Test
    void delete_BookPresent_ShouldDeleteBook() {
        Book bookToDelete = bookRepository.findById(1L);
        bookRepository.delete(bookToDelete.getId());

        GlobalException ex = assertThrows(GlobalException.class, () -> bookRepository.findById(1L));
        assertEquals("Book not found with id: 1", ex.getMessage());
    }

    @Test
    void delete_BookNotPresent_ShouldThrowException() {
        GlobalException ex = assertThrows(GlobalException.class, () -> bookRepository.delete(999L));
        assertEquals("Book not found with id: 999", ex.getMessage());
    }

    @Test
    void search_SearchByAuthorPresent_ShouldReturnBooks() {
        String searchQuery = "J.K. Rowling";
        var books = bookRepository.search(searchQuery);

        assertFalse(books.isEmpty());
        assertTrue(books.stream().anyMatch(book -> book.getAuthor().contains(searchQuery)));
    }

    @Test
    void search_SearchByAuthorNotPresent_ShouldReturnEmptyList() {
        String searchQuery = "Unknown Author";
        var books = bookRepository.search(searchQuery);

        assertTrue(books.isEmpty());
    }

    @Test
    void search_SearchByTitlePresent_ShouldReturnBooks() {
        String searchQuery = "Harry Potter";
        var books = bookRepository.search(searchQuery);

        assertFalse(books.isEmpty());
        assertTrue(books.stream().anyMatch(book -> book.getTitle().contains(searchQuery)));
    }

    @Test
    void search_SearchByTitleNotPresent_ShouldReturnEmptyList() {
        String searchQuery = "Unknown Title";
        var books = bookRepository.search(searchQuery);

        assertTrue(books.isEmpty());
    }

    private Book sampleBook() {
        Book book = new Book();
        book.setTitle("title");
        book.setAuthor("author");
        book.setGenres("genres");
        return book;
    }
}