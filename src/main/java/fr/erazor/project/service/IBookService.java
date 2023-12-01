package fr.erazor.project.service;

import fr.erazor.project.dto.book.BookUpdateDTO;
import fr.erazor.project.model.Book;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Interface consomée par la Class BookService.
 * L'Interface permet de définir les méthodes
 * qui seront utilisées par la Class BookService.
 */
public interface IBookService {
    Book saveBook(Book book);
    Optional<Book> getBook(Long id);
    List<Book> getAllBooks();
    Book updateBook(Long id, BookUpdateDTO bookUpdateDTO);
    void deleteBook(Long id);
    Optional<List<Book>> findBooksByTitle(String title);
    Optional<List<Book>> findBooksByAuthor(String author);
    List<Book> findBooksByPublicationDate(Date publicationDate);
    List<Book> findBooksByTitleAndAuthor(String title, String author);
}
