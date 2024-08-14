package es.teknei.gd.gestion.biblioteca.service;

import es.teknei.gd.gestion.biblioteca.model.Book;
import es.teknei.gd.gestion.biblioteca.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book) {
        log.info("Adding book: {}", book);
        Book savedBook = bookRepository.save(book);
        log.info("Book added with ID: {}", savedBook.getId());
        return savedBook;
    }

    public List<Book> listAllBooks() {
        log.info("Fetching all books");
        List<Book> books = bookRepository.findAll();
        log.info("Found {} books", books.size());
        return books;
    }

    public Book findBookById(Long id) {
        log.info("Finding book with ID: {}", id);
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            log.info("Found book: {}", book);
        } else {
            log.warn("No book found with ID: {}", id);
        }
        return book;
    }

    public Book updateBook(Book book) {
        log.info("Updating book: {}", book);
        Book updatedBook = bookRepository.save(book);
        log.info("Book updated with ID: {}", updatedBook.getId());
        return updatedBook;
    }

    public void deleteBook(Long id) {
        log.info("Deleting book with ID: {}", id);
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            log.info("Book with ID {} deleted", id);
        } else {
            log.warn("Attempted to delete non-existent book with ID: {}", id);
        }
    }

    public boolean doesBookExist(Long id) {
        boolean exists = bookRepository.existsById(id);
        log.info("Checking existence of book with ID: {} - Exists: {}", id, exists);
        return exists;
    }
}
