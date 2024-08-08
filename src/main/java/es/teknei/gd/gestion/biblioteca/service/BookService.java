package es.teknei.gd.gestion.biblioteca.service;

import es.teknei.gd.gestion.biblioteca.model.Book;
import es.teknei.gd.gestion.biblioteca.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book) {
        logger.info("Adding book: {}", book);
        Book savedBook = bookRepository.save(book);
        logger.info("Book added with ID: {}", savedBook.getId());
        return savedBook;
    }

    public List<Book> listAllBooks() {
        logger.info("Fetching all books");
        List<Book> books = bookRepository.findAll();
        logger.info("Found {} books", books.size());
        return books;
    }

    public Book findBookById(Long id) {
        logger.info("Finding book with ID: {}", id);
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            logger.info("Found book: {}", book);
        } else {
            logger.warn("No book found with ID: {}", id);
        }
        return book;
    }

    public Book updateBook(Book book) {
        logger.info("Updating book: {}", book);
        Book updatedBook = bookRepository.save(book);
        logger.info("Book updated with ID: {}", updatedBook.getId());
        return updatedBook;
    }

    public void deleteBook(Long id) {
        logger.info("Deleting book with ID: {}", id);
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            logger.info("Book with ID {} deleted", id);
        } else {
            logger.warn("Attempted to delete non-existent book with ID: {}", id);
        }
    }

    public boolean doesBookExist(Long id) {
        boolean exists = bookRepository.existsById(id);
        logger.info("Checking existence of book with ID: {} - Exists: {}", id, exists);
        return exists;
    }
}
