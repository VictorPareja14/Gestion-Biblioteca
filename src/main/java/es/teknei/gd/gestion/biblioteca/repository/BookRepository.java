package es.teknei.gd.gestion.biblioteca.repository;

import es.teknei.gd.gestion.biblioteca.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}