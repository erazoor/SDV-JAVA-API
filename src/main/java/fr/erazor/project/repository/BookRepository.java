package fr.erazor.project.repository;

import fr.erazor.project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByPublicationDate(Date publicationDate);

    List<Book> findByTitleAndAuthor(String title, String author);
}
